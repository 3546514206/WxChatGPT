package edu.zjnu.weChat.strategy.model;

import com.alibaba.fastjson.JSONObject;
import edu.zjnu.weChat.strategy.AbstractStrategy;
import edu.zjnu.weChat.strategy.ChatRequest;
import edu.zjnu.weChat.strategy.ChatResponse;
import edu.zjnu.weChat.strategy.model.tuling.*;

/**
 * @author: 杨海波
 * @date: 2023-08-07 16:50:29
 * @description: TulingStrategy
 */
public class TulingStrategy extends AbstractStrategy {

    private final String baseUrl = "http://openapi.turingapi.com/openapi/api/v2";

    private final String apiKey = "3acc534b36904c569a1675a3fecd2aa2";

    private final String userId = "362079";


    @Override
    protected String doExec(ChatRequest request) {
        String requestStr = JSONObject.toJSONString(request);
        // 执行通讯请求
        return doHttp(baseUrl, requestStr, null);
    }

    @Override
    protected ChatResponse postChatResponse(String responseStr) {
        TulingResponse tulingResponse = JSONObject.parseObject(responseStr, TulingResponse.class);

        for (Result result : tulingResponse.getResults()) {
            if ("text".equals(result.getResultType())) {
                // 设置最终结果
                tulingResponse.setResult(result.getValues().getText());
            }
        }
        // 主动向下转型，屏蔽返回的其他数据
        return tulingResponse;
    }

    @Override
    protected ChatRequest postChatRequest(ChatRequest request) {
        TulingRequest tulingRequest = new TulingRequest();
        tulingRequest.setRequest(request.getRequest());

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
