package cn.plusman.interview.generic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * cn.plusman.interview.generic
 *
 * @author plusman
 * @since 12/27/20
 */
public class ContainerDemo {
    public static class Box<T> {

        private T element;

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }
    }

    public static void method1(Box<?> key) {
        System.out.println(key);
    }

    public static void method2(
        Map<String, Box<?>> key) {
        System.out.println(key);
    }

    public static void main(String[] args) {
        Box<String> box = new Box<>();

        box.setElement("hello");
        System.out.println(box.getElement());

        method1(box);

        HashMap<String, Box<String>> shashMap = new HashMap<>();
        shashMap.put("xx", box);

        // 无法编译通过，why
        // method2(shashMap);
    }
}
