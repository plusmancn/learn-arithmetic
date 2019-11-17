package cn.plusman.hashtable;

import java.util.HashMap;

public class HashMapInspect {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        // 1）是否有一个合理的 Hash 函数，插入情况
        map.put("1", "v1");
        System.out.println(2100000000 * 220000001 + 12);


        System.out.println("& 运算：" + (3 & 8));

        // 查找情况
        System.out.println("HashGet: " + map.get("1"));

        // 2）能否动态扩容，使用合理的内存空间
        int a = 97;
        System.out.println("Random：" + (a ^ (a >>> 16)));

        // 3）面对极端情况，比如大量 Hash 碰撞，是否会出现线性退化




        System.out.println(map);
    }
}
