package edu.zjnu.weChat.strategy;

import edu.zjnu.weChat.excp.GptRuntimeException;
import edu.zjnu.weChat.utils.WxHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author: 杨海波
 * @date: 2023-09-08 21:31:47
 * @description: 抽象策略类，用于定义算法模板
 */
public abstract class AbstractStrategy implements IStrategy {


    /**
     * 执行通讯请求
     *
     * @param url
     * @param requestStr
     * @return
     */
    protected String doHttp(String url, String requestStr, Map<String, String> headers) {
        HttpEntity httpEntity = WxHttpClient.getInstance().doPost(url, requestStr, headers);
        String responseStr;
        try {
            responseStr = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            throw new GptRuntimeException("parse error");
        }

        return responseStr;
    }

    /**
     * 算法模板
     *
     * @param request
     * @return
     */
    public ChatResponse exec(ChatRequest request) {
        ChatRequest postedChatRequest = postChatRequest(request);
        String responseStr = doExec(postedChatRequest);
        // 处理结果集并返回
        return postChatResponse(responseStr);
    }

    /**
     * 处理请求结果
     *
     * @param responseStr
     */
    protected abstract ChatResponse postChatResponse(String responseStr);

    /**
     * 请求参数处理
     *
     * @param request
     */
    protected abstract ChatRequest postChatRequest(ChatRequest request);

    /**
     * 执行通讯请求
     *
     * @param request
     * @return
     */
    protected abstract String doExec(ChatRequest request);

}
