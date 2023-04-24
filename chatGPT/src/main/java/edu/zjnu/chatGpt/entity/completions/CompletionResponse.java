package edu.zjnu.chatGpt.entity.completions;

import edu.zjnu.chatGpt.entity.common.Choice;
import edu.zjnu.chatGpt.entity.common.OpenAiResponse;
import edu.zjnu.chatGpt.entity.common.Usage;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述： 答案类
 *
 * @author https:www.unfbx.com
 * 2023-02-11
 */
@Data
public class CompletionResponse extends OpenAiResponse implements Serializable {
    private String id;
    private String object;
    private long created;
    private String model;
    private Choice[] choices;
    private Usage usage;
}
