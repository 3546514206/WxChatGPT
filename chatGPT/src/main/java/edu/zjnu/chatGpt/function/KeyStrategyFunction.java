package edu.zjnu.chatGpt.function;

import java.util.function.Function;

/**
 * 描述：key 的获取策略
 * jdk默认实现
 *
 * @author https:www.unfbx.com
 * @see Function
 * @since 2023-04-03
 */
@FunctionalInterface
public interface KeyStrategyFunction<T, R> {

    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
    R apply(T t);

}
