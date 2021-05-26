package cn.plusman.learn.java.serialtest;

import java.io.*;

/**
 * 参考文章：https://www.cnblogs.com/duanxz/p/3511695.html
 * @author plusman
 * @since 2021/5/13 11:03 PM
 */
public class JavaTestDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializeTest();
        // deserializeTest();
    }
    
    public static void serializeTest() throws IOException {
        Person person = new Person();
        person.setName("plusman");
        person.setAge(14);
    
        FileOutputStream fos = new FileOutputStream("person.hex");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
    
        oos.writeObject(person);
        oos.flush();
        oos.close();
    }
    
    public static void deserializeTest() throws IOException, ClassNotFoundException {
        Person person;
    
        FileInputStream fis = new FileInputStream("person.hex");
        ObjectInputStream ois = new ObjectInputStream(fis);
        person = (Person) ois.readObject();
        ois.close();
        System.out.println("Person deserialize " + person);
    }
}
