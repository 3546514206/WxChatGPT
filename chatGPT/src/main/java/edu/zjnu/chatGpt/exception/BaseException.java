package edu.zjnu.chatGpt.exception;

import lombok.Getter;

/**
 * 描述： 异常
 *
 * @author https:www.unfbx.com
 * 2023-02-11
 */
@Getter
public class BaseException extends RuntimeException {

    private String msg;
    private int code;

    public BaseException(IError error) {
        super(error.msg());
        this.code = error.code();
        this.msg = error.msg();
    }

    public BaseException(String msg) {
        super(msg);
        this.code = edu.zjnu.chatGpt.exception.CommonError.SYS_ERROR.code();
        this.msg = msg;
    }

    public BaseException() {
        super(edu.zjnu.chatGpt.exception.CommonError.SYS_ERROR.msg());
        this.code = edu.zjnu.chatGpt.exception.CommonError.SYS_ERROR.code();
        this.msg = CommonError.SYS_ERROR.msg();
    }
}
