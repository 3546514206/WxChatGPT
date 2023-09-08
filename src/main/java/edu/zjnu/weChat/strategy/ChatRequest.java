package edu.zjnu.weChat.strategy;

/**
 * @author: 杨海波
 * @date: 2023-08-07 15:43:48
 * @description: ChatRequest
 */
public class ChatRequest {

    String request;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public ChatRequest(String request) {
        this.request = request;
    }

    public ChatRequest() {
    }
}
