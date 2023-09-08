package edu.zjnu.weChat.strategy;

/**
 * @author: 杨海波
 * @date: 2023-08-07 15:44:03
 * @description: ChatResponse
 */
public class ChatResponse {

    /**
     * 完整的报文返回塞在这里
     */
    String responseStr;

    /**
     * 聊天对话结果放在这里
     */
    String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ChatResponse(String tulingResponseStr) {
        this.responseStr = tulingResponseStr;
    }

    public String getResponseStr() {
        return responseStr;
    }

    public void setResponseStr(String responseStr) {
        this.responseStr = responseStr;
    }

    public ChatResponse() {
    }
}
