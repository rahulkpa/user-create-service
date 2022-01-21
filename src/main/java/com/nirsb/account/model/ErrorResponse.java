package com.nirsb.account.model;

import java.util.Date;

public class ErrorResponse {
    private String status;
    private Date timeStamp;
    private String message;
    private String path;

    public ErrorResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ErrorResponse(String status, Date timeStamp, String message, String path) {
        this.status = status;
        this.timeStamp = timeStamp;
        this.message = message;
        this.path = path;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "status='" + status + '\'' +
                ", timeStamp=" + timeStamp +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
