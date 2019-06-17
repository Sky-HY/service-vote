package com.vote.utils;

public class HyResult {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;


    public HyResult() {
        this.status = 200;
        this.msg = "ok";
    }

    private HyResult(Object data) {
        this.status = 200;
        this.msg = "ok";
        this.data = data;
    }

    public HyResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static HyResult ok() {
        return new HyResult();
    }

    public static HyResult ok(Object data) {
        return new HyResult(data);
    }

    public static HyResult build(Integer status, String msg) {
        return new HyResult(status, msg, null);
    }


    public static HyResult build(Integer status, String msg, Object data) {
        return new HyResult(status, msg, data);
    }

    /*public static HyResult formatToPojo(String json,Class<?> clazz){
        if (clazz==null){
            throw new NullPointerException();
        }
        Object o = JsonUtil.jsonToPojo(json, clazz);

    }*/


}
