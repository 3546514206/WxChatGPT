package edu.zjnu.weChat.strategy.model;

import edu.zjnu.weChat.excp.GptRuntimeException;
import edu.zjnu.weChat.strategy.ChatRequest;
import edu.zjnu.weChat.strategy.ChatResponse;
import edu.zjnu.weChat.strategy.Strategy;
import edu.zjnu.weChat.utils.WxHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author: 杨海波
 * @date: 2023-08-07 15:47:31
 * @description: 默认 ChatGPT 策略
 */
@Component
public class DefaultStrategy implements Strategy, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public ChatResponse doOperation(ChatRequest request) {

        String url = applicationContext.getEnvironment().getProperty("chatGPT.server") + applicationContext.getEnvironment().getProperty("chatGPT.servlet.context-path");
        HttpEntity httpEntity = WxHttpClient.getInstance().doPost(url, request.getRequest());
        try {
            String responseEntity = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            throw new GptRuntimeException("parse error");
        }



        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
