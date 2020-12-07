package ca.bytetube._00_leetcode._03_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * @author dal
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (k == 1) return nums;

        int[] maxes = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //只要deque[rear] <= nums[i],就删除队尾
            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.removeLast();
            }
            //能来到这，说明队尾<= nums[i]

            deque.addLast(i);

            //检查窗口的索引是否合法
            int w = i - k + 1;
            if (w < 0) continue;

            //检查对头的合法性
            if (deque.peekFirst() < w) {
                //过期
                deque.removeFirst();
            }

            maxes[w] = nums[deque.peekFirst()];
        }

        return maxes;

    }
}
