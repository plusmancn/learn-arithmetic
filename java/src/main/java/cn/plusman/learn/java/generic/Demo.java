package cn.plusman.learn.java.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author plusman
 * @since 2021/4/12 12:32 PM
 */
public class Demo {
    public static void main(String[] args) throws NoSuchMethodException {
        List<Integer> list = new ArrayList<>();
    
        list.add(12);
        // 这里直接添加会报错
        // list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        // 但是通过反射添加，是可以的
        try {
            add.invoke(list, "kl");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    
        System.out.println(list);
    }
}
