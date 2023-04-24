package edu.zjnu.chatGpt.entity.images;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author SetsunaYang
 * 2023-02-15
 */
@Data
public class Item implements Serializable {
    private String url;
    @JsonProperty("b64_json")
    private String b64Json;
}
