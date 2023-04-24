package edu.zjnu.chatGpt.entity.images;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author SetsunaYang
 * 2023-02-15
 */
@AllArgsConstructor
@Getter
public enum ResponseFormat implements Serializable {
    URL("url"),
    B64_JSON("b64_json"),
    ;

    private String name;
}
