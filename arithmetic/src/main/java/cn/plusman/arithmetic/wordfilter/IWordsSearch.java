/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.arithmetic.wordfilter;

import cn.plusman.arithmetic.wordfilter.bo.JudgeResult;

import java.util.List;

/**
 * 敏感词搜索接口定义
 * @author plusman
 * @since 2021/1/12 11:55 PM
 */
public interface IWordsSearch {
    /**
     * 敏感词库初始化
     * @param words
     */
    void init(List<String> words);


    /**
     * 检测敏感词，返回首个错误词汇
     * @param str 需要检测的字符串
     * @param isReturnFailWords 是否返回失败词汇列表，默认 false
     * @return
     */
     JudgeResult isIllegal(String str, Boolean isReturnFailWords);

    /**
     * 检测敏感词，返回首个错误词汇
     * @param str 需要检测的字符串
     * @param isReturnFailWords 是否返回失败词汇列表，默认 false
     * @return
     */
    JudgeResult isIllegalWithGeekTime(String str, Boolean isReturnFailWords);

}
