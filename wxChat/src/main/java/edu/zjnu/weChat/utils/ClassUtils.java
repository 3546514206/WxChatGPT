package edu.zjnu.weChat.utils;

/**
 * @author: 杨海波
 * @date: 2023-08-07 16:01:26
 * @description: ClassUtils
 */
public class ClassUtils {

    public static Object createInstance(String className) {

        try {
            Class<?> clz = Class.forName(className);
            return clz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
