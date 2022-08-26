package com.employees.details.exception;

public class ErrorResponse {
    private String error;
    private String reason;

    public ErrorResponse(ApplicationException applicationException) {
        this.error = applicationException.getError();
        this.reason = applicationException.getDescription();
    }

    public ErrorResponse(String error, String reason) {
        this.error = error;
        this.reason = reason;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
