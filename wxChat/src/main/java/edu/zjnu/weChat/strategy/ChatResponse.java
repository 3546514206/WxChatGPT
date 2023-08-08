package edu.zjnu.weChat.strategy;

/**
 * @author: 杨海波
 * @date: 2023-08-07 15:44:03
 * @description: ChatResponse
 */
public class ChatResponse {

    String response;

    public ChatResponse(String tulingResponseStr) {
        this.response = tulingResponseStr;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
