package edu.zjnu.weChat.strategy;

/**
 * @author: 杨海波
 * @date: 2023-08-07 15:49:12
 * @description: StrategyContext
 */
public class StrategyContext {

    private AbstractStrategy strategy;

    public StrategyContext(AbstractStrategy strategy){
        this.strategy = strategy;
    }

    public ChatResponse executeStrategy(ChatRequest request){
        return strategy.exec(request);
    }
}
