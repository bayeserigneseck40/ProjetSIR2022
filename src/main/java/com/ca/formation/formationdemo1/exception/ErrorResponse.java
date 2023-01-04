package com.ca.formation.formationdemo1.exception;

import lombok.Data;

import java.util.Date;
@Data
public class ErrorResponse {

    private Date timestamp;
    private String status;
    private String message;
    private String details;

    public ErrorResponse(Date timestamp, String status, String message, String details) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.details = details;
    }


}
