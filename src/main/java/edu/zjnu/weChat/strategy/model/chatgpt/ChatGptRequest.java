package edu.zjnu.weChat.strategy.model.chatgpt;

import edu.zjnu.weChat.strategy.ChatRequest;

/**
 * @author: 杨海波
 * @date: 2023-09-08 23:55:35
 * @description: ChatGptRequest
 */
public class ChatGptRequest extends ChatRequest {

    private String model = "text-davinci-003";

    private String prompt;

    private Integer max_tokens = 256;

    private float temperature = 0.5f;

    private Integer top_p = 1;

    private Integer n = 1;

    private Boolean stream = false;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(Integer max_tokens) {
        this.max_tokens = max_tokens;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public Integer getTop_p() {
        return top_p;
    }

    public void setTop_p(Integer top_p) {
        this.top_p = top_p;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Boolean getStream() {
        return stream;
    }

    public void setStream(Boolean stream) {
        this.stream = stream;
    }
}
