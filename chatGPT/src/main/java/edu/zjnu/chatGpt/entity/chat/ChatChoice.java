package edu.zjnu.chatGpt.entity.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author https:www.unfbx.com
 * @since 2023-03-02
 */
@Data
public class ChatChoice implements Serializable {
    private long index;
    /**
     * 请求参数stream为true返回是delta
     */
    @JsonProperty("delta")
    private edu.zjnu.chatGpt.entity.chat.Message delta;
    /**
     * 请求参数stream为false返回是message
     */
    @JsonProperty("message")
    private Message message;
    @JsonProperty("finish_reason")
    private String finishReason;
}
