package cn.plusman.learn.java.lambda;

import lombok.Getter;

import java.util.Comparator;
import java.util.function.Function;

/**
 * @author plusman
 * @since 2021/4/5 12:16 PM
 */
public class DoubleColonDemo {
    public static void main(String[] args) {
        Computer c1 = new Computer(12);
        Computer c2 = new Computer(13);
        
        Function<Computer, Integer> getAge = Computer::getAge;
        Integer age = getAge.apply(c1);
        System.out.println(age);
    
    
        int compareResult = Comparator.comparing(Computer::getAge).compare(c1, c2);
        System.out.println(compareResult);
    }
}

@Getter
class Computer {
    Computer(Integer age) {
        this.age = age;
    }
    
    private Integer age;
}
