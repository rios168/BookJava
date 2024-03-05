package com.book.management.bean;

import lombok.Data;

@Data
public class ResultBean<T> {

    public final static int FAIL = 900; //接口错误提示
    private int code;
    private String msg;
    private T data;

    public static ResultBean fail() {
        return new ResultBean(FAIL, "操作失败");
    }

    public static ResultBean fail(String msg) {
        return new ResultBean(FAIL, msg);
    }

    public static ResultBean fail(int code, String msg) {
        return new ResultBean(code, msg);
    }

    //空是成功,有消息就错误
    public static ResultBean msg(String msg) {
        if (msg == null) {
            return ResultBean.success();
        } else {
            return ResultBean.fail(msg);
        }
    }

    public static ResultBean success() {
        return new ResultBean(0, "操作成功");
    }

    public static <T> ResultBean success(T data) {
        return new ResultBean(data);
    }

    public static <T> ResultBean fail(T data) {
        ResultBean fail = ResultBean.fail();
        fail.data = data;
        return fail;
    }

    public static <T> ResultBean success(T data, long total) {
        ResultBean resultBean = new ResultBean(data);
        return resultBean;
    }


    public ResultBean(T data) {
        this.data = data;
        code = 0;
        msg = "操作成功";
    }

    public ResultBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBean(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
