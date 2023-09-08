package edu.zjnu.weChat.strategy;

/**
 * @author: 杨海波
 * @date: 2023-08-07 15:41:25
 * @description: 策略接口
 */
public interface Strategy {

    /**
     * @param request
     * @return
     */
    ChatResponse exec(ChatRequest request);
}
