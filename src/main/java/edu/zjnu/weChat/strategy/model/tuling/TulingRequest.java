package edu.zjnu.weChat.strategy.model.tuling;

import edu.zjnu.weChat.strategy.ChatRequest;

/**
 * @author: 杨海波
 * @date: 2023-08-07 17:07:05
 * @description: TulingRequest
 */
public class TulingRequest extends ChatRequest {

    private   String requestType;

    private   Perception perception;

    private  UserInfo userInfo;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Perception getPerception() {
        return perception;
    }

    public void setPerception(Perception perception) {
        this.perception = perception;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
