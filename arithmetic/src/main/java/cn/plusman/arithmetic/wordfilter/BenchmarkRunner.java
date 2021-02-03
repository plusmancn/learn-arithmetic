/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.arithmetic.wordfilter;

import cn.plusman.arithmetic.wordfilter.bo.JudgeResult;
import cn.plusman.arithmetic.wordfilter.impl.AcWordsSearchImpl;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.infra.Blackhole;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author plusman
 * @since 2021/1/17 10:29 PM
 */
public class BenchmarkRunner {
    private static IWordsSearch wordsSearch = new AcWordsSearchImpl();

    static {
        // 从文件读取敏感词
        List<String> words =  new ArrayList<>();
        try {
            // TODO: 文件当前路径如何自动获取
            FileReader fileReader = new FileReader( "/Users/plusman/Desktop/Learning/learn-arithmetic/arithmetic/src/main/java/cn/plusman/arithmetic/wordfilter/fixtures/words.txt");
            BufferedReader bf = new BufferedReader(fileReader);
            String word;
            while ((word = bf.readLine()) != null) {
                words.add(word);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 初始化搜索数据
        wordsSearch.init(words);
    }

    @Benchmark
    public void testAc(Blackhole blackhole) {
        JudgeResult result = wordsSearch.isIllegalWithGeekTime("当前两岸局势被一女子蔡英文弄得剑拔弩张，当前爱国人士正在全力追捕蔡英文", true);
        blackhole.consume(result);
    }

    @Benchmark
    public void testNormal(Blackhole blackhole) {
        JudgeResult result = wordsSearch.isIllegal("当前两岸局势被一女子蔡英文弄得剑拔弩张，当前爱国人士正在全力追捕蔡英文", true);
        blackhole.consume(result);
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
