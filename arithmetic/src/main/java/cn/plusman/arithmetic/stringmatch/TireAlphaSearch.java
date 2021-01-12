package cn.plusman.arithmetic.stringmatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 英文字母版 Tire 树构建 [a-z]
 *
 * Tire 树主要解决前缀匹配问题，对于集合类搜索不适用
 *
 * @author plusman
 * @since 1/6/21
 */
public class TireAlphaSearch {
    private TireNode root = new TireNode('/');

    /**
     * 往 Tire 树中插入一个字符串
     * @param text
     */
    public void insert(char[] text) {
        TireNode currentNode = root;

        for(int i = 0; i < text.length; i++) {
            int pos = text[i] - 'a';

            if (currentNode.children[pos] == null) {
                TireNode newNode = new TireNode(text[i]);
                currentNode.children[pos] = newNode;
                currentNode = newNode;
            } else {
                currentNode = currentNode.children[pos];
            }
        }

        // 设置尾节点为 true
        currentNode.isEndingChar = true;
    }

    /**
     * 嗖嗖模式串是否匹配
     * @param pattern
     * @return
     */
    public boolean find(char[] pattern) {
        TireNode currentNode = root;
        for(int i = 0; i < pattern.length; i++) {
            int pos = pattern[i] - 'a';
            if (currentNode.children[pos] != null) {
                currentNode = currentNode.children[pos];
            } else {
                return false;
            }
        }

        if (currentNode.isEndingChar) {
            return true;
        }

        return false;
    }

    /**
     * 获取输入提示
     * @param pattern
     * @return
     */
    public List<String> getTips(char[] pattern) {
        List<String> tips = new ArrayList<>();

        TireNode currentNode = root;
        for(int i = 0; i < pattern.length; i++) {
            int pos = pattern[i] - 'a';
            if (currentNode.children[pos] != null) {
                currentNode = currentNode.children[pos];
            } else {
                break;
            }
        }

        // 如果无任何字符串匹配，则返回空
        if (pattern.length > 0 && currentNode.equals(root)) {
            return tips;
        }

        // 如果已经匹配字符串，则返回该节点下所有字节点
        // 进行深度优先遍历
        tips = deepFirstTravel(currentNode);

        if (!currentNode.isEndingChar) {
            tips.remove(currentNode.data + "");
        }

        String prefix = new String(pattern);

        for (int i = 0; i < tips.size(); i++) {
            tips.set(i, prefix + tips.get(i).substring(1));
        }

        return tips;
    }

    /**
     * 如果能够把算法映射到 数据结构，则可以很容易写出算法
     *
     * 深度优先遍历，
     * @return
     */
    public List<String> deepFirstTravel(TireNode node) {
        List<String> list = new LinkedList<>();

        for(int i = 0; i < node.children.length; i++) {
            if(node.children[i] != null) {
                for (String s : deepFirstTravel(node.children[i])) {
                    list.add(node.data + s);
                }
            }
        }

        if (list.isEmpty() || node.isEndingChar) {
            list.add("" + node.data);
        }

        return list;
    }

    public class TireNode {
        public char data;
        // 26 个字母，解决排序问题，然则需要替换成其他 数据结构
        public TireNode[] children = new TireNode[26];
        public boolean isEndingChar = false;

        public TireNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        // 初始化树结构
        TireAlphaSearch tireAlphaSearch = new TireAlphaSearch();
        tireAlphaSearch.insert("how".toCharArray());
        tireAlphaSearch.insert("hi".toCharArray());
        tireAlphaSearch.insert("her".toCharArray());
        tireAlphaSearch.insert("hello".toCharArray());
        tireAlphaSearch.insert("so".toCharArray());
        tireAlphaSearch.insert("see".toCharArray());
        tireAlphaSearch.insert("se".toCharArray());

        // 搜索示例
        System.out.println("搜索 he：" + tireAlphaSearch.find("he".toCharArray()));
        System.out.println("搜索 se：" + tireAlphaSearch.find("se".toCharArray()));
        System.out.println("搜索 see：" + tireAlphaSearch.find("see".toCharArray()));
        System.out.println("搜索 hello：" + tireAlphaSearch.find("hello".toCharArray()));
        System.out.println("搜索 helloooo：" + tireAlphaSearch.find("helloooo".toCharArray()));

        // 提示项示例
        System.out.println("获取 he tips：" + tireAlphaSearch.getTips("he".toCharArray()));
        System.out.println("获取 see tips：" + tireAlphaSearch.getTips("see".toCharArray()));
        System.out.println("获取 tp tips：" + tireAlphaSearch.getTips("tp".toCharArray()));
        System.out.println("获取 '' tips：" + tireAlphaSearch.getTips("".toCharArray()));
    }
}
