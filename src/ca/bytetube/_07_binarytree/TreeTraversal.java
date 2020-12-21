package ca.bytetube._07_binarytree;

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



    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(3);
        InOrderTraversalByRecursion(root);
        System.out.println();
        System.out.println("=================");
        InOrderTraversalByLoop(root);

    }


}
