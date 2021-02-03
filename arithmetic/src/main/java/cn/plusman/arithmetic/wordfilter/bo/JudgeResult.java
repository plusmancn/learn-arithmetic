/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.arithmetic.wordfilter.bo;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author plusman
 * @since 2021/1/14 7:35 PM
 */
@Data
public class JudgeResult {
    /**
     * 检测字符串是否合法
     */
    private boolean isIllegal = true;
    /**
     * 失败词汇列表
     */
    private Set<String> failWords = new HashSet<>();

    public boolean isIllegal() {
        return isIllegal;
    }

    public void setIllegal(boolean illegal) {
        isIllegal = illegal;
    }

    public Set<String> getFailWords() {
        return failWords;
    }
}
