package com.company.project.core;

import com.alibaba.fastjson.JSON;

/**
 * 统一API响应结果封装
 */
public class Result {
    private int code;
    private String message;
    private Object data;

    public Result() {
    }

    public Result(ResultCode resultCode, String message, Object data) {
        this.code = resultCode.code;
        this.message = message;
        this.data = data;
    }

    public static Result ok(Object data) {
        return new Result(ResultCode.SUCCESS, "success", data);
    }

    public static Result error(String message) {
        return new Result(ResultCode.INTERNAL_SERVER_ERROR, message, null);
    }

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
