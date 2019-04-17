package cn.funwx.mall.utils;

import java.io.Serializable;

/**
 * Created by chj on 18/8/26.
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int resultCode;
    private String message;
    private T data;
    private static final Integer SUCCESS_CODE = 200;
    private static final Integer ERROR_CODE = 403;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(int resultCode) {
        this.resultCode = resultCode;
    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result suc() {
        return new Result(SUCCESS_CODE);
    }

    public static Result sucT(Object object) {
        Result res = new Result();
        res.setResultCode(SUCCESS_CODE);
        res.setData(object);
        return res;
    }

    public static Result suc(String msg) {
        return new Result(SUCCESS_CODE, msg);
    }

    public static Result err() {
        return new Result(ERROR_CODE);
    }

    public static Result err(String msg) {
        return new Result(ERROR_CODE, msg);
    }

    public boolean isSuc() {
        return resultCode == SUCCESS_CODE;
    }

    public boolean isErr() {
        return resultCode == ERROR_CODE;
    }

    public void success() {
        resultCode = SUCCESS_CODE;
    }

    public void error() {
        resultCode = ERROR_CODE;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data={" + data + "}" +
                '}';
    }

}
