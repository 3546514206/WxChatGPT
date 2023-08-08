package edu.zjnu.weChat.strategy.impl.tuling;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author: 杨海波
 * @date: 2023-08-07 19:13:36
 * @description: TulingResponse
 */
public class TulingResponse {

    @JSONField(name = "intent")
    private Intent intent;

    @JSONField(name = "results")
    private List<Result> results;

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
