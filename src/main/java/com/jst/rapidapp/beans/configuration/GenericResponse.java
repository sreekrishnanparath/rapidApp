package com.jst.rapidapp.beans.configuration;

import org.springframework.http.HttpStatus;

public class GenericResponse<T> {
    private HttpStatus status;
    private String responseTime;
    private T result;

    public GenericResponse(HttpStatus status, T response,String responseTime) {
        this.status = status;
        this.responseTime = responseTime;
        this.result = response;
    }

    public GenericResponse() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getResponseTime() {
        return responseTime+"ms";
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


}
