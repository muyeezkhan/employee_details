package com.employees.details.filter;

import com.employees.details.exception.ApplicationException;
import com.employees.details.exception.ErrorResponse;
import com.employees.details.util.JWTAuthentication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class AuthenticationFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Autowired
    private JWTAuthentication jwtAuthentication;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("Entered into AuthenticationFilter and the request is {}.", request.getRequestURI());
        try {
            System.out.println("-----------Path-------------" + request.getRequestURI());
            if (request.getRequestURI().contains("h2-console") || jwtAuthentication.getTokenPath().contains(request.getRequestURI())) {
                logger.info("Exiting AuthenticationFilter and the request is {}.", request.getRequestURI());
                filterChain.doFilter(request, response);
            } else if (!jwtAuthentication.getTokenPath().contains(request.getRequestURI())) {
                String token = request.getHeader("jwt-token");
                if (token.isBlank() || token.isEmpty() || !jwtAuthentication.authenticate(token)) {
                    throw new ApplicationException("Authentication Error", "Token is invalid or maybe expired");
                }
                logger.info("JWT Token is + " + token);
                logger.info("Exiting AuthenticationFilter and the request is {}.", request.getRequestURI());
                filterChain.doFilter(request, response);
            }
        } catch (ApplicationException ex) {

            ErrorResponse errorResponse = new ErrorResponse(ex);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            ObjectMapper mapper = new ObjectMapper();
            logger.error("Authentication failed due to {}.", mapper.writeValueAsString(errorResponse));
            mapper.writeValue(response.getWriter(), errorResponse);
        }
    }
}
