package edu.zjnu.chatGpt.service;

import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;
import edu.zjnu.chatGpt.core.OpenAiClient;
import edu.zjnu.chatGpt.entity.chat.ChatChoice;
import edu.zjnu.chatGpt.entity.chat.ChatCompletion;
import edu.zjnu.chatGpt.entity.chat.ChatCompletionResponse;
import edu.zjnu.chatGpt.entity.chat.Message;
import edu.zjnu.chatGpt.function.KeyRandomStrategy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: 杨海波
 * @date: 2023-04-24 16:41:40
 * @description: GptService
 */
@Service
public class GptService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public String doChat(String request) {
        String response = null;
        OpenAiClient openAiClient = OpenAiClient.builder().apiKey(decryptKeys())
                //自定义key的获取策略：默认KeyRandomStrategy
                .keyStrategy(new KeyRandomStrategy()).build();

        //聊天模型：gpt-3.5
        Message message = Message.builder().role(Message.Role.USER).content(request).build();
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(Collections.singletonList(message)).build();
        ChatCompletionResponse chatCompletionResponse = openAiClient.chatCompletion(chatCompletion);

        for (ChatChoice choice : chatCompletionResponse.getChoices()) {
            if (choice.getMessage() != null) {
                response = choice.getMessage().getContent();
                break;
            }
        }

        return response;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 不加密会被封
     *
     * @return
     */
    private List<String> decryptKeys() {
        // key：AES模式下，key必须为16位
        String symmetricalKey = applicationContext.getEnvironment().getProperty("secret.aes.key", "plikajensixjkeos");
        // iv：偏移量，ECB模式不需要，CBC模式下必须为16位
        String iv = applicationContext.getEnvironment().getProperty("secret.aes.iv", "qscvbnjiokhtsgeu");
        // 密文
        String encryptKey = applicationContext.getEnvironment().getProperty("secret.aes.ciphertext", "");
        String[] encryptKeys = encryptKey.split(",");

        AES aes = new AES(Mode.CBC, Padding.PKCS5Padding, symmetricalKey.getBytes(), iv.getBytes());

        List<String> keys = new ArrayList<>();
        for (String toDecryptKey : encryptKeys) {
            String key = aes.decryptStr(toDecryptKey);
            keys.add(key);
        }

        return keys;
    }
}
