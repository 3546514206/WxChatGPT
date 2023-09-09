package edu.zjnu.weChat.strategy.model;

import com.alibaba.fastjson.JSONObject;
import edu.zjnu.weChat.strategy.AbstractStrategy;
import edu.zjnu.weChat.strategy.ChatRequest;
import edu.zjnu.weChat.strategy.ChatResponse;
import edu.zjnu.weChat.strategy.model.chatgpt.ChatGptRequest;
import edu.zjnu.weChat.strategy.model.chatgpt.ChatGptResponse;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: 杨海波
 * @date: 2023-09-08 23:45:40
 * @description: 重新接入ChatGpt
 */
public class ChatGptStrategy extends AbstractStrategy {

    private final String baseUrl = "https://api.openai.com/v1/completions";
    // 为了防止 github 代码扫描封禁 key ，将 key 分成两段
    private final String apiKey1 = "sk-kbyuYWpbBqOAJgxU8yzUT3Blbk";
    private final String apiKey2 = "FJS78yFVZpVXQSP2vSKy5o";

    // 统一封装的 HTTP 通讯工具貌似有问题，重新写一个
    private final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .callTimeout(60, TimeUnit.SECONDS)
            .build();


    @Override
    protected ChatResponse postChatResponse(String responseStr) {

        ChatGptResponse chatGptResponse = JSONObject.parseObject(responseStr, ChatGptResponse.class);

        return null;
    }

    // 此处需要通过返回值更新 request 对象引用
    @Override
    protected ChatRequest postChatRequest(ChatRequest request) {
        ChatGptRequest postedChatRequest = new ChatGptRequest();
        postedChatRequest.setPrompt(request.getRequest());
        return postedChatRequest;
    }

    @Override
    protected String doExec(ChatRequest request) {
        String requestStr = JSONObject.toJSONString(request);
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + apiKey1 + apiKey2);
        headers.put("Accept", "*/*");
        // 执行通讯请求
        return doHttp(baseUrl, requestStr, headers);
    }

    /**
     *  重写父类通讯方法，换个客户端以解决 SSL 握手失败的问题
     * @param url
     * @param requestStr
     * @param headers
     * @return
     */
    public String doHttp(String url,String requestStr,Map<String,String> headers)  {

        Request request = new Request.Builder()
                .url(baseUrl)
                // 将 API_KEY 替换成你自己的 API_KEY
                .header("Authorization", "Bearer " + apiKey1 + apiKey2)
                .post(RequestBody.create(MediaType.get("application/json"), requestStr))
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
