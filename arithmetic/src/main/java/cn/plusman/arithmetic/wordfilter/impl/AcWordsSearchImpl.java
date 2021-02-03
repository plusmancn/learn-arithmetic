/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.arithmetic.wordfilter.impl;

import cn.plusman.arithmetic.wordfilter.IWordsSearch;
import cn.plusman.arithmetic.wordfilter.bo.JudgeResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 基于 AC 自动机的多模式串匹配
 * 等价于 tire 树 + 快速前缀跳转
 * @author plusman
 * @since 2021/1/12 11:56 PM
 */
public class AcWordsSearchImpl implements IWordsSearch {
    // root 节点地址不可更改
    final TreeNode root = new TreeNode('/');

    class TreeNode {
        // 单字
        public char data;
        public Map<Character, TreeNode> subNodes = new HashMap<>();
        public Boolean isEndNode = false;
        public Integer length = 0;
        public TreeNode failNode = null;

        public TreeNode(char data) {
            this.data = data;
        }
    }

    @Override
    public void init(List<String> words) {
        // 初始化 Tire 树数据
        for (String word : words) {
            insertWord(word);
        }

        // 构建快速失败节点
        buildFailNode();
    }

    private void insertWord(String word) {
        // 空字符串直接返回
        if (word == null || word.isEmpty()) {
            return;
        }

        TreeNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(currentNode.subNodes.containsKey(c)) {
                currentNode = currentNode.subNodes.get(c);
            } else {
                TreeNode newNode = new TreeNode(c);
                currentNode.subNodes.put(c, newNode);
                currentNode = newNode;
            }
        }

        // 设置尾节点
        currentNode.isEndNode = true;
    }

    private void buildFailNode() {
        TreeNode currentNode = root;


        // L1 层级的 FailNode 一定是 root
        for (TreeNode node : root.subNodes.values()) {
            node.failNode = root;
            node.length = 1;
        }


        List<TreeNode> levelContainer = currentNode.subNodes.values().stream().collect(Collectors.toList());

        int level = 1;
        while (!levelContainer.isEmpty()) {
            level++;
            List<TreeNode> nextLevelContainer = new ArrayList<>();

            for (TreeNode node : levelContainer) {
                for (TreeNode nextNode : node.subNodes.values()) {
                    // 下一层级 node 统计
                    nextNode.length = level;
                    nextLevelContainer.add(nextNode);

                    // 层层向上回溯
                    TreeNode tmpNode = node.failNode;
                    while (true) {
                        // failNode 不能是该节点的父节点
                        if(tmpNode.subNodes.containsKey(nextNode.data)
                        && !tmpNode.subNodes.get(nextNode.data).equals(node)) {
                            nextNode.failNode = tmpNode.subNodes.get(nextNode.data);
                            break;
                        } else {
                            tmpNode = tmpNode.failNode;

                            // 无法向上回溯则中断，即 root 的 failNode 是 null
                            if(tmpNode == null) {
                                nextNode.failNode = root;
                                break;
                            }
                        }
                    }
                }
            }

            levelContainer = nextLevelContainer;
        }
    }


    @Override
    public JudgeResult isIllegal(String str, Boolean isReturnFailWords) {
        JudgeResult rtn = new JudgeResult();

        for (int i = 0; i < str.length(); i++) {
            TreeNode currentNode = root;
            for (int j = i; j < str.length(); j++) {
                currentNode = currentNode.subNodes.get(str.charAt(j));
                if (currentNode != null) {
                    if (currentNode.isEndNode) {
                        rtn.getFailWords().add(str.substring(i, j + 1));
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        // 如果敏感词列表不为空，则代表字符串不合法
        if (!rtn.getFailWords().isEmpty()) {
            rtn.setIllegal(false);
        }

        return rtn;
    }

    /**
     * 遍历思路，
     * 1. 主串只过一遍，通过 failNode 快速跳转。
     * 2. 如果匹配某一模式串，则通过遍历该模式串的 failNode，快速找出子匹配
     *
     * @param str 需要检测的字符串
     * @param isReturnFailWords 是否返回失败词汇列表，默认 false
     * @return
     */
    @Override
    public JudgeResult isIllegalWithGeekTime(String str, Boolean isReturnFailWords) {
        JudgeResult rtn = new JudgeResult();
        TreeNode p = root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            TreeNode sp = p.subNodes.get(c);

            // 写法1：回退主串
            // if (sp != null) {
            //     // 如果匹配子串，则当前节点移动到下一节点
            //     p = sp;
            // } else if (!p.equals(root)) {
            //     p = p.failNode;
            //     // 主串回退一位，看失败子串的下一位是否匹配与目标匹配
            //     i--;
            //     continue;
            // }

            // 写法2：不停遍历 failNode，确认是否存在可用 failNode
            while (sp == null && !p.equals(root)) {
                p = p.failNode;
                sp = p.subNodes.get(c);
            }
            // 如果 sp 为 null，则 p 一定是 root
            if (sp != null) {
                p = sp;
            }

            // 搜索可以匹配的模式串
            TreeNode tmpNode = sp;
            while (tmpNode != null) {
                if (tmpNode.isEndNode) {
                    rtn.getFailWords().add(str.substring(i - tmpNode.length + 1, i + 1));
                }
                tmpNode = tmpNode.failNode;
            }
        }

        // 如果敏感词列表不为空，则代表字符串不合法
        if (!rtn.getFailWords().isEmpty()) {
            rtn.setIllegal(false);
        }

        return rtn;
    }
}
