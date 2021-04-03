package cn.plusman.learn.java.toarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 数组 Set 方法测试
 * @author plusman
 * @since 2021/3/31 9:47 AM
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> alphaTable = new HashSet<>();
        alphaTable.add("a");
        alphaTable.add("b");
        alphaTable.add("c");
        alphaTable.add("d");
        
        // 只有 in 的空间大于 alphaTable.size 的时候才会赋值
        String[] in = new String[3];
        String[] out = alphaTable.toArray(in);
        
        System.out.println("in: " + Arrays.toString(in));
        System.out.println("out: " + Arrays.toString(out));
    }
}
