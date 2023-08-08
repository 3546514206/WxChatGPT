package edu.zjnu.weChat.strategy;

/**
 * @author: 杨海波
 * @date: 2023-08-07 15:49:12
 * @description: StrategyContext
 */
public class StrategyContext {

    private Strategy strategy;

    public StrategyContext(Strategy strategy){
        this.strategy = strategy;
    }

    public ChatResponse executeStrategy(ChatRequest request){
        return strategy.doOperation(request);
    }
}
