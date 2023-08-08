package edu.zjnu.weChat.strategy.impl.tuling;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author: 杨海波
 * @date: 2023-08-07 19:16:41
 * @description: todo
 */
public class Result {

    @JSONField(name = "groupType")
    private String groupType;

    @JSONField(name = "resultType")
    private String resultType;

    @JSONField(name = "values")
    private Values values;

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public Values getValues() {
        return values;
    }

    public void setValues(Values values) {
        this.values = values;
    }
}
