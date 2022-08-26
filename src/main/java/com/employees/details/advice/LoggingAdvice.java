package com.employees.details.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;

@Aspect
@Controller
public class LoggingAdvice {

    private final Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value="execution(* com.employees.details.*.*.*(..)) && !within(com.employees.details.filter.*)")
    public void applicationPackagePointCut() {
    }

    @AfterThrowing(pointcut = "applicationPackagePointCut()", throwing = "e")
    public void loggingAfterException(JoinPoint joinPoint, Throwable e) {
        logger.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
    }

    @Around("applicationPackagePointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        logger.info("Method Invoked : ClassName - {} : Method Name - {} : Argumanets  - {}",
                joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName(), mapper.writeValueAsString(joinPoint.getArgs()));
        try {
            Object response = joinPoint.proceed();
            logger.info("Method Invoked : ClassName - {} : Method Name - {} : Response  - {}",
                    joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName(), mapper.writeValueAsString(response));
            return response;
        } catch (IllegalArgumentException ex) {
            logger.error("Illegal argument: {} in {}.{}()", mapper.writeValueAsString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
            throw ex;
        }
    }
}

