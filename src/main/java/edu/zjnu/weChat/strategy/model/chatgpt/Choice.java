package edu.zjnu.weChat.strategy.model.chatgpt;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author: 杨海波
 * @date: 2023-09-09 00:16:31
 * @description: Choice
 */
public class Choice {

    @JSONField(name = "text")
    private String text;

    @JSONField(name = "index")
    private String index;

    @JSONField(name = "logprobs")
    private String logprobs;

    @JSONField(name = "finish_reason")
    private String finishReason;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(String logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }
}
