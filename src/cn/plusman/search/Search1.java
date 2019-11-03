package cn.plusman.search;

public class Search1 {

    /**
     * 查找第一个值等于给定值的元素
     * @param a
     * @return int
     */
    public static int mySearch(int[] a, int key) {
        int low = 0;
        int high = a.length -1;
        int mid = -1;

        while (low <= high) {
            mid = (low + high) >>> 1;

            if(a[mid] == key) {
                // 向前搜索，直到搜到非 key 值
                while (a[mid -1] == key) {
                    mid = mid - 1;
                }

                return mid;
            } else if(a[mid] > key) {
                high = mid - 1;
            } else if(a[mid] < key) {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        System.out.println(mySearch(a, 8));
    }
}
