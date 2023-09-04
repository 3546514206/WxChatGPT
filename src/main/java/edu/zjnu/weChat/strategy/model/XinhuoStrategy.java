package edu.zjnu.weChat.strategy.model;

import edu.zjnu.weChat.excp.GptRuntimeException;
import edu.zjnu.weChat.strategy.ChatRequest;
import edu.zjnu.weChat.strategy.ChatResponse;
import edu.zjnu.weChat.strategy.Strategy;
import edu.zjnu.weChat.strategy.model.xinhuo.XinhuoUtil;

/**
 * @author: 杨海波
 * @date: 2023-09-04 11:50:32
 * @description: 星火大模型
 */
public class XinhuoStrategy implements Strategy {


    public static String text;

    public static boolean done = false;

    @Override
    public ChatResponse doOperation(ChatRequest request) {


        try {
            XinhuoUtil.doXinhuoStrategy(request.getRequest());
        } catch (Exception e) {
            throw new GptRuntimeException("星辉大模型调用异常");
        }

        while (!done) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new GptRuntimeException("星辉大模型调用异常");
            }
        }

        done = false;

        return new ChatResponse(text);
    }


}
