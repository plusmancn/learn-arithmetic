/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.learn.java.permission;

import java.io.*;

/**
 * SPI 沙箱测试
 * @author plusman
 * @since 2021/3/5 4:31 PM
 */
public class PolicyTest {
    public static void file() {
        File f = new File("/Users/plusman/Desktop/Learning/learn-arithmetic/java/src/main/resources/r.txt");
        InputStream is;
        try {
            is = new FileInputStream(f);
            byte[] content = new byte[10];
            while (is.read(content) != -1) {
                System.out.println(new String(content));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        file();
    }
}
