package edu.zjnu.chatGpt.entity.chat;

import edu.zjnu.chatGpt.entity.common.Usage;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 描述： chat答案类
 *
 * @author SetsunaYang
 * 2023-03-02
 */
@Data
public class ChatCompletionResponse implements Serializable {
    private String id;
    private String object;
    private long created;
    private String model;
    private List<ChatChoice> choices;
    private Usage usage;
}
