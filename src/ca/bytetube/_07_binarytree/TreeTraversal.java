package ca.bytetube._07_binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

    private static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void preOrderTraversalByRecursion(Node node){
        if (node == null) return;
        //current
        System.out.print(node.value+" ");
        //left
        preOrderTraversalByRecursion(node.left);
        //right
        preOrderTraversalByRecursion(node.right);

    }

    public static void preOrderTraversalByLoop(Node node){
        if (node != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(node);

            while (!stack.isEmpty()){
                Node pop = stack.pop();
                System.out.print(pop.value+" ");
                //当前节点有右先压右
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                //当前节点有左再压左
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }

        }

    }

    public static void InOrderTraversalByRecursion(Node node){
        if (node == null) return;
        //left
        InOrderTraversalByRecursion(node.left);
        //current
        System.out.print(node.value+" ");
        //right
        InOrderTraversalByRecursion(node.right);

    }

    public static void InOrderTraversalByLoop(Node node){
        if (node != null) {//第一次的判断
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || node != null){//root != null是因为第一个节点在入栈时，当前stack isEmpty
                if (node != null) {//是为了防止栈中压入null
                    stack.push(node);
                    node = node.left;
                }else {
                    Node pop = stack.pop();
                    System.out.print(pop.value+" ");
                    node = pop.right;
                }
            }

        }
    }

    public static void postOrderTraversalByRecursion(Node node){
        if (node == null) return;
        //left
        postOrderTraversalByRecursion(node.left);
        //right
        postOrderTraversalByRecursion(node.right);
        //current
        System.out.print(node.value+" ");

    }

    public static void postOrderTraversalByLoop(Node node){
        if (node != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(node);

            while (!stack1.isEmpty()){
                Node pop = stack1.pop();
                stack2.push(pop);
                //System.out.print(pop.value+" ");

                //当前节点有左先压左
                if (pop.left != null) {
                    stack1.push(pop.left);
                }
                //当前节点有右再压右
                if (pop.right != null) {
                    stack1.push(pop.right);
                }
            }

            while (!stack2.isEmpty()){
                Node pop = stack2.pop();
                System.out.print(pop.value+" ");
            }

        }
    }


    public static void levelOrderTraversal(Node node){
        if (node != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(node);
            while (!queue.isEmpty()){
                Node poll = queue.poll();
                System.out.print(poll.value+" ");

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
    }




    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(3);
       // postOrderTraversalByRecursion(root);
        System.out.println();
        System.out.println("=================");
        levelOrderTraversal(root);

    }


}
