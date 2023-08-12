package edu.zjnu.weChat.excp;

/**
 * @author: 杨海波
 * @date: 2023-08-07 16:06:40
 * @description: GptRuntimeException
 */
public class GptRuntimeException extends RuntimeException {

    private String msg;

    public GptRuntimeException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}

