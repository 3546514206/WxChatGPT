package edu.zjnu.weChat.strategy.impl.tuling;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author: 杨海波
 * @date: 2023-08-07 19:19:04
 * @description: Values
 */
public class Values {

    @JSONField(name = "url")
    private String url;

    @JSONField(name = "text")
    private String text;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
