package edu.zjnu.weChat.strategy.impl.tuling;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author: 杨海波
 * @date: 2023-08-07 19:13:47
 * @description: Intent
 */
public class Intent {

    @JSONField(name = "parameters")
    private  Parameters parameters;

    @JSONField(name = "actionName")
    private String actionName;

    @JSONField(name = "intentName")
    private String intentName;

    @JSONField(name = "code")
    private String code;

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
