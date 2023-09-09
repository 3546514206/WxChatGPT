package edu.zjnu.weChat.strategy.model.chatgpt;

import com.alibaba.fastjson.annotation.JSONField;
import edu.zjnu.weChat.strategy.ChatResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 杨海波
 * @date: 2023-09-08 23:56:27
 * @description: ChatGptResponse
 */
public class ChatGptResponse extends ChatResponse {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "object")
    private String object;

    @JSONField(name = "created")
    private String created;

    @JSONField(name = "model")
    private String model;

    @JSONField(name = "choices")
    private List<Choice> choices;

    @JSONField(name = "usage")
    private Usage usage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
