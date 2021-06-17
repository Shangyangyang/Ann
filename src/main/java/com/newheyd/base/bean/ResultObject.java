package com.newheyd.base.bean;

import java.io.Serializable;

public class ResultObject implements Serializable {

    private int status = ResultStatus.OK.status;
    private int code = ResultCode.SUCCESS.code;

    private String message = null;

    private Object data = null;

    //APP返回JSON
    private boolean result = true;
    private int errorcode = ResultStatus.APPCODEOK.status;
    private String msg = "操作成功!";
    private Object data2;
    private Object data3;
    private Object data4;

    private String name;

    public ResultObject(boolean result, int errorcode, String msg) {
        super();
        this.result = result;
        this.errorcode = errorcode;
        this.msg = msg;
    }

    public ResultObject(boolean result, int errorcode, String msg, Object data) {
        super();
        this.result = result;
        this.errorcode = errorcode;
        this.msg = msg;
        this.data = data;
    }

    public ResultObject(boolean result, int errorcode, String msg, Object data, Object data2) {
        super();
        this.result = result;
        this.errorcode = errorcode;
        this.msg = msg;
        this.data = data;
        this.data2 = data2;
    }

    public ResultObject(boolean result, int errorcode, String msg, Object data, Object data2, Object data3) {
        super();
        this.result = result;
        this.errorcode = errorcode;
        this.msg = msg;
        this.data = data;
        this.data2 = data2;
        this.data3 = data3;
    }

    public ResultObject(boolean result, int errorcode, String msg, Object data, Object data2, Object data3, Object data4) {
        super();
        this.result = result;
        this.errorcode = errorcode;
        this.msg = msg;
        this.data = data;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
    }

    public ResultObject setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }

    public ResultObject setStatus(ResultStatus resultStatus) {
        this.status = resultStatus.status;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ResultObject setStatus(int status) {
        this.status = status;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResultObject setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultObject setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResultObject setData(Object data) {
        this.data = data;
        return this;
    }

    public boolean isResult() {
        return result;
    }

    public ResultObject setResult(boolean result) {
        this.result = result;
        return this;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public ResultObject setErrorcode(int errorcode) {
        this.errorcode = errorcode;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultObject setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData2() {
        return data2;
    }

    public ResultObject setData2(Object data2) {
        this.data2 = data2;
        return this;
    }

    public Object getData3() {
        return data3;
    }

    public ResultObject setData3(Object data3) {
        this.data3 = data3;
        return this;
    }

    public Object getData4() {
        return data4;
    }

    public ResultObject setData4(Object data4) {
        this.data4 = data4;
        return this;
    }

    public String getName() {
        return name;
    }

    public ResultObject setName(String name) {
        this.name = name;
        return this;
    }

    public ResultObject() {
        super();
    }
}
