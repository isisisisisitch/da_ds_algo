package ca.bytetube._00_leetcode.stack;


import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/
 * @author dal
 */
public class lc_stack_02_MinStack {
    private Node head;
    private static class Node{
        public int val;
        public int min;
        public Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    public lc_stack_02_MinStack() {
        //dummy node
        head = new Node(100,Integer.MAX_VALUE,null);
    }
    public void push(int x) {
        head = new Node(x,Math.min(x,head.min),head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }



//    private Stack<Integer> stackData;
//    private Stack<Integer> stackMin;
//
//    /** initialize your data structure here. */
//    public lc_stack_02_MinStack() {
//        stackData = new Stack<>();
//        stackMin = new Stack<>();
//    }
//
//    public void push(int x) {
//        this.stackData.push(x);
//        if (this.stackMin.isEmpty()) {
//            stackMin.push(x);
//        }else if (x <= stackMin.peek()) {
//            stackMin.push(x);
//        }
//
//    }
//
//    public void pop() {
//        if (stackData.isEmpty()) {
//            throw new RuntimeException("stackData is empty!");
//        }
//
//        int pop = stackData.pop();
//        if (pop == stackMin.peek()) {
//            stackMin.pop();
//        }
//
//
//    }
//
//    public int top() {
//        if (stackData.isEmpty()) {
//            throw new RuntimeException("stackData is empty!");
//        }
//        return stackData.peek();
//    }
//
//    public int getMin() {
//        if (stackMin.isEmpty()) {
//            throw new RuntimeException("stackMin is empty!");
//        }
//
//      return stackMin.peek();
//    }

}
