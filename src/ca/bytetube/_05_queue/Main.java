package ca.bytetube._05_queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        queue.enQueue("bytetube");
        queue.enQueue("hello queue");

//        System.out.println(queue.size());
        while (!queue.isEmpty()){
            String dQ = queue.deQueue();
            System.out.println(dQ);
        }
    }
}
