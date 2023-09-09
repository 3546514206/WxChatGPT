package edu.zjnu.weChat.strategy.model.chatgpt;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author: 杨海波
 * @date: 2023-09-09 00:16:42
 * @description: Usage
 */
public class Usage {

    @JSONField(name = "prompt_tokens")
    private String promptTokens;

    @JSONField(name = "completion_tokens")
    private String completionTokens;

    @JSONField(name = "total_tokens")
    private String totalTokens;

    public String getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(String promptTokens) {
        this.promptTokens = promptTokens;
    }

    public String getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(String completionTokens) {
        this.completionTokens = completionTokens;
    }

    public String getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(String totalTokens) {
        this.totalTokens = totalTokens;
    }
}
