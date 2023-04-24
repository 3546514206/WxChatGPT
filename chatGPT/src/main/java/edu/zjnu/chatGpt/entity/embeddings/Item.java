package edu.zjnu.chatGpt.entity.embeddings;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class Item implements Serializable {
    private String object;
    private List<BigDecimal> embedding;
    private Integer index;
}
