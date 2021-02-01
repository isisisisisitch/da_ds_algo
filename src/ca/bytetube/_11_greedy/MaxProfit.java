package ca.bytetube._11_greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxProfit {

    private static class Node{
        public int c;
        public int p;

        public Node(int c, int p) {
            this.c = c;
            this.p = p;
        }
    }


    private static class  minCostComparator implements Comparator<Node> {


        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    private static class  maxProfitComparator implements Comparator<Node> {


        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int MaxProfit(int[] costs,int[] profits,int W,int k){
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(costs[i],profits[i]);
        }

        //按照cost建立小根堆
        PriorityQueue<Node> minCost = new PriorityQueue<>(new minCostComparator());
        //按照profit建立大根堆
        PriorityQueue<Node> maxProfit = new PriorityQueue<>(new maxProfitComparator());
        //把所有项目装入小根堆
        for (int i = 0; i < nodes.length; i++) {
            minCost.add(nodes[i]);
        }

        for (int i = 0; i < k; i++) {
            while (!minCost.isEmpty() && minCost.peek().c <= W){//目前能做的项目
                maxProfit.add(minCost.poll());//把能做的项目的利润放入大根堆
            }
            if (maxProfit.isEmpty()) {
                    return W;//最终返回的资金
            }
            W += maxProfit.poll().p;
        }

        return W;
    }



    public static void main(String[] args) {
        int[] costs = {100,150,50,200,80};
        int[] profits = {10,80,5,15,10};
        System.out.println(MaxProfit(costs,profits,100,3));

    }
}
