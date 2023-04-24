package edu.zjnu.chatGpt.entity.edits;


import edu.zjnu.chatGpt.entity.common.Choice;
import edu.zjnu.chatGpt.entity.common.Usage;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author SetsunaYang
 * 2023-02-15
 */
@Data
public class EditResponse implements Serializable {
    private String id;
    private String object;
    private long created;
    private String model;
    private Choice[] choices;
    private Usage usage;
}
