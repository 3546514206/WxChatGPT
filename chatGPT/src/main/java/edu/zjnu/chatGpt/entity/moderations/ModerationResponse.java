package edu.zjnu.chatGpt.entity.moderations;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：
 *
 * @author SetsunaYang
 * 2023-02-15
 */
@Data
public class ModerationResponse implements Serializable {
    private String id;
    private String model;
    private List<Result> results;
}
