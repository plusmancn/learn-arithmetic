package cn.plusman.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AllPermutation {

    // 同样可以把参数理解为 picked, rest
    // 当 rest 为空时，则打印所有 picked 内元素
    // k 表示要处理的数据个数，n 数组长度，当 k = 1 时终止循环
    public static void printPermutations(int[] data, int k) {
        if (k == 1) {
            System.out.println(Arrays.toString(data));
            return;
        }

        // k = 3, 所以存在原址交换，这样也可以理解为，picked 数组初始值为 0
        for(int i = 0; i < k; i++) {
            int tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;

            printPermutations(data, k-1);

            // 由于 data 是引用传递，所以需要复原数据
            tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;
        }
    }

    public static void myPermutations(List<Integer> rest, List<Integer> picked) {
        if(rest.size() != 0) {
            for (Integer i : rest) {
                // 这其实也是浅 COPY
                List<Integer> newRest = new ArrayList<>(rest);
                newRest.remove(i);

                List<Integer> newPicked = new ArrayList<>(picked);
                newPicked.add(i);

                myPermutations(newRest, newPicked);
            }
        } else {
            System.out.println(picked);
        }

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        printPermutations(a, a.length);

        // myPermutations(new ArrayList<>(Arrays.asList(1, 2, 3)), new ArrayList<>());
    }
}
