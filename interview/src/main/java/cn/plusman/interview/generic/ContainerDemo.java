package cn.plusman.interview.generic;

import java.util.LinkedList;
import java.util.List;

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

    public static void main(String[] args) {
        Box<String> box = new Box<>();

        box.setElement("hello");
        System.out.println(box.getElement());
    }
}
