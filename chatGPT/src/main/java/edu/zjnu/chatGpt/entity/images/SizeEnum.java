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
@Getter
@AllArgsConstructor
public enum SizeEnum implements Serializable {
    size_1024("1024x1024"),
    size_512("512x512"),
    size_256("256x256"),

    ;
    private String name;

}
