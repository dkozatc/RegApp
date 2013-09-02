package com.springapp.mvc;

/**
 * TODO add comments
 */
public class ServiceResponse<T> {

    private T data;

    public ServiceResponse() {
        this.data = null;
    }

    public ServiceResponse(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}
