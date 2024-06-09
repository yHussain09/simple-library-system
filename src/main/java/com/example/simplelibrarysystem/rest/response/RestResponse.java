package com.example.simplelibrarysystem.rest.response;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class RestResponse {
    private HttpStatus statusInfo;
    private Date lastModified;
    private String message;
    private Object data;

    public RestResponse() {
    }

    public RestResponse(HttpStatus statusInfo, Object data, String message) {
        this.lastModified = new Date();
        this.statusInfo = statusInfo;
        this.data = data;
        this.message = message;
    }

    public HttpStatus getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(HttpStatus statusInfo) {
        this.statusInfo = statusInfo;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
