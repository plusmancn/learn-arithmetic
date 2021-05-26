package cn.plusman.learn.java.serialtest;

import lombok.Data;

import java.io.Serializable;

/**
 * @author plusman
 * @since 2021/5/13 11:02 PM
 */
@Data
public class Person implements Serializable {
    private static final long serialVersionUID = -1145750483391052979L;
    
    private String name;
    private Integer age;
}
