package cn.plusman.arithmetic.stringmatch;

/**
 * cn.plusman.arithmetic.stringmatch
 *
 * @author plusman
 * @since 1/4/21
 */
public class KmpMatch {
    /**
     *
     * @param input
     * @param search
     * @return 如果成功，返回首次匹配的位置的起始下标，然则返回 -1
     */
    public static int match(String input, String search) {
        // 搜索串大于目标串，则必定匹配失败
        if (search.length() > input.length()) {
            return -1;
        }

        int[] next = getNextTable(search);

        // s 为当前搜索起点
        // stop 为搜索终止点（不含）
        int stop = input.length() - search.length() + 1;

        for (int s = 0; s < stop;) {
            for(int i = 0; i < search.length();) {
                if (input.charAt(s + i) != search.charAt(i)) {
                    // 利用失败函数的计算结果，快速移位
                    s += i - next[i];
                    break;
                }

                // 如果 i + 1 == search.length 代表所有字符串都已经匹配
                if (++i == search.length()) {
                    return s;
                }
            }
        }

        return -1;
    }

    /**
     * 生成字符串表
     * @param search
     * @return
     */
    public static int[] getNextTable(String search) {
        return new int[search.length() - 1];
    }

}
