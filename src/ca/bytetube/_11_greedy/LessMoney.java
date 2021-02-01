package ca.bytetube._11_greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LessMoney {

    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new minHeapComparator());
        //1.建立小根堆结构
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }

        //2.弹2次堆顶，拿到最小的2个数，累加之后，重新装入堆中
        int sum = 0;
        int cur = 0;

        while (priorityQueue.size() > 1){
            cur = priorityQueue.poll() + priorityQueue.poll();
            sum += cur;
            priorityQueue.add(cur);//累加之后，重新装入堆中
        }

        return sum;

    }


    private static class  minHeapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }


    public static void main(String[] args) {
        int[] arr = {10,20,30};
        System.out.println(lessMoney(arr));
    }


}
