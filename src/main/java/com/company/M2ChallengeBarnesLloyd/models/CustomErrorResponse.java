package com.company.M2ChallengeBarnesLloyd.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class CustomErrorResponse {
// Copied code from recordStore assignment.
    private String errorMessage;
    private int status;
    private String errorCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss" )
    private LocalDateTime timestamp;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;

        this.errorCode = errorCode;

    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
