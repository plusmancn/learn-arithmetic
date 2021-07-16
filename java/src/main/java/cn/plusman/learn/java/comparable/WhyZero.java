package cn.plusman.learn.java.comparable;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author plusman
 * @since 2021/7/14 5:28 PM
 */
public class WhyZero {
    @Data
    public static class Person {
        private Double age; 
    }
    
    public static void main(String[] args) {
        double[] arr = {4,5,0.0,2,1,3,4,6,-0.0};
        List<Person> persons = new ArrayList<>(arr.length);
        for (double i : arr) {
            Person person = new Person();
            person.setAge(i);
            persons.add(person);
        }
    
        System.out.println(persons);
        List<Person> sorted = persons.stream().sorted((v1, v2) -> {
            if (v1.getAge() > v2.getAge()) {
                return 1;
            } else {
                return -1;
            }
            // return v1.getAge().compareTo(v2.getAge());
        }).collect(Collectors.toList());
        System.out.println(sorted);
    }
}
