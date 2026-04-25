package com.project.shop.common;

public class Result<T> {
    private Integer code;
    String msg;
    private  T data;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T>Result<T> success(T data){
        Result<T> r = new Result<>();
        r.code = 200;
        r.msg = "操作成功";
        r.setData(data);
        return r;
    }

    public static <T>Result<T> fail(String msg){
        Result<T> r = new Result<>();
        r.code = 400;
        r.msg = msg;
        return r;
    }
}
