package cn.plusman.arithmetic.leetcode.top;

/**
 * For Data View
 * @author plusman
 * @since 2021/6/30 2:47 PM
 */
public class InspectUtil {
    public static void showArray(boolean[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i > -1; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j] ? "1 " : "0 ");
            }
            sb.append("\n");
        }
    
        System.out.println(sb.toString());
    }
}
