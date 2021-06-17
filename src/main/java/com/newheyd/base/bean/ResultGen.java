package com.newheyd.base.bean;

public class ResultGen {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static ResultObject genSuccessResult() {
        return new ResultObject().setMessage(DEFAULT_SUCCESS_MESSAGE).setResult(true);
    }

    public static ResultObject genSuccessResult(Object data) {
        return new ResultObject().setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data).setResult(true);
    }

    public static ResultObject genSuccessResult(Object data, Object data2) {
        return new ResultObject().setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data).setData2(data2).setResult(true);
    }

    public static ResultObject genSuccessResult(String message, Object data) {
        return new ResultObject().setMessage(message).setData(data).setMsg(message).setResult(true);
    }

    public static ResultObject genSuccessResult(String name, String message, Object data) {
        return new ResultObject().setName(name).setMessage(message).setData(data).setMsg(message).setResult(true);
    }

    public static ResultObject genFailResult(String message) {
        return new ResultObject().setStatus(ResultStatus.ERROR).setCode(ResultCode.FAIL).setMessage(message).setResult(false).setMsg(message).setErrorcode(1);
    }

    public static ResultObject appResullt(boolean result, int errorcode, String msg) {
        return new ResultObject(result, errorcode, msg);
    }

    public static ResultObject appResullt(boolean result, int errorcode, String msg, Object data) {
        return new ResultObject(result, errorcode, msg, data);
    }

    public static ResultObject appResullt(boolean result, int errorcode, String msg, Object data, Object data2) {
        return new ResultObject(result, errorcode, msg, data, data2);
    }

    public static ResultObject appResullt(boolean result, int errorcode, String msg, Object data, Object data2, Object data3) {
        return new ResultObject(result, errorcode, msg, data, data2, data3);
    }

    public static ResultObject appResullt(boolean result, int errorcode, String msg, Object data, Object data2, Object data3, Object data4) {
        return new ResultObject(result, errorcode, msg, data, data2, data3, data4);
    }
}
