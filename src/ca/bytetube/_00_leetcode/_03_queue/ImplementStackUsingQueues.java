package ca.bytetube._00_leetcode._03_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dal
 *
 */
public class ImplementStackUsingQueues {
    private Queue<Integer> data;
    private Queue<Integer> help;
    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    /** Push element x to the top of stack. */
    public void push(int x) {
        data.add(x);
    }

    /** Removes the element from top of stack and returns that element. */
    public int pop() {
        checkData();
        //需要把data队列中最后一个元素弹出
        //1。把前n-1个元素转移到help中
        while (data.size() > 1){
            help.add(data.poll());
        }
        //2.将data中最后一个元素直接弹出
        int polled = data.poll();

        //3.data和help交换（引用交换，目的：为了减少容器中值的转移所消耗的时间）
        swap();
        return polled;

    }

    /** Get the top element. */
    public int peek() {
        checkData();
        //需要把data队列中最后一个元素弹出
        //1。把前n-1个元素转移到help中
        while (data.size() > 1){
            help.add(data.poll());
        }
        //2.将data中最后一个元素直接弹出
        int polled = data.poll();
        help.add(polled);
        //3.data和help交换（引用交换，目的：为了减少容器中值的转移所消耗的时间）
        swap();
        return polled;


    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
       return data.isEmpty() && help.isEmpty();
    }

    private void checkData(){
        if (data.isEmpty()) {
           throw new RuntimeException("stack is empty!");
        }
    }

    private void swap(){
        Queue<Integer> temp = help;
        help = data;
        data = temp;
    }
}
