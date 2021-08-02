package cn.plusman.interview.concurrency;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * cn.plusman.interview.ThreadStartTwice
 *
 * @author plusman
 * @since 12/28/20
 */
public class AlternativePrint {
    public static void main(String[] args) {
        List<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(
            1,2,3,4,5,6,7
        ));
    }
}
