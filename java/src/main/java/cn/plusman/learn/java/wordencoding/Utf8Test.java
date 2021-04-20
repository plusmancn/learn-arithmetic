package cn.plusman.learn.java.wordencoding;

/**
 * @author plusman
 * @since 2021/4/11 10:06 PM
 */
public class Utf8Test {
    public static void main(String[] args) {
        String s = "鹅";
        char c = '鹅';
        // 编译错误 Too many characters in character literal
        // char emojSmile = '😊';

        System.out.println(s);
        System.out.println(c);
    }
}
