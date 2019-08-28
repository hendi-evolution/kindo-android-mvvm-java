package com.sincerelylab.kindo.data.remote.responses;

public abstract class BaseResponse<T> {
    public int code;
    public String msg;
    public T data;
}
