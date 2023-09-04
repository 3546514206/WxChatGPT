package edu.zjnu.weChat.strategy.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.zjnu.weChat.excp.GptRuntimeException;
import edu.zjnu.weChat.strategy.ChatRequest;
import edu.zjnu.weChat.strategy.ChatResponse;
import edu.zjnu.weChat.strategy.Strategy;
import edu.zjnu.weChat.strategy.model.tuling.*;
import edu.zjnu.weChat.utils.WxHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author: 杨海波
 * @date: 2023-08-07 16:50:29
 * @description: TulingStrategy
 */
public class TulingStrategy implements Strategy {

    private final String baseUrl = "http://openapi.turingapi.com/openapi/api/v2";

    private final String apiKey = "3acc534b36904c569a1675a3fecd2aa2";

    private final String userId = "362079";

    @Override
    public ChatResponse doOperation(ChatRequest request) {
        TulingRequest tulingRequest = postTulingRequest(request);
        String tulingRequestStr = JSONObject.toJSONString(tulingRequest);
        HttpEntity httpEntity = WxHttpClient.getInstance().doPost(baseUrl, tulingRequestStr);
        String tulingResponseStr;
        try {
            tulingResponseStr = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            throw new GptRuntimeException("parse error");
        }

        TulingResponse tulingResponse = JSON.parseObject(tulingResponseStr, TulingResponse.class);
        String chatResponseStr = "";
        for (Result result : tulingResponse.getResults()) {
            if ("text".equals(result.getResultType())) {
                chatResponseStr = result.getValues().getText();
            }
        }

        return new ChatResponse(chatResponseStr);
    }

    private TulingRequest postTulingRequest(ChatRequest request) {
        TulingRequest tulingRequest = new TulingRequest();
        tulingRequest.setRequestType("0");

        Perception perception = new Perception();

        InputText inputText = new InputText();
        inputText.setText(request.getRequest());

        perception.setInputText(inputText);

        InputImage inputImage = new InputImage();
        inputImage.setUrl("");

        perception.setInputImage(inputImage);

        SelfInfo selfInfo = new SelfInfo();

        Location location = new Location();
        location.setCity("");
        location.setStreet("");
        location.setProvince("");
        selfInfo.setLocation(location);

        perception.setSelfInfo(selfInfo);

        tulingRequest.setPerception(perception);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setApiKey(apiKey);
        tulingRequest.setUserInfo(userInfo);

        return tulingRequest;
    }
}
