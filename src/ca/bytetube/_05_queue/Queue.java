package ca.bytetube._05_queue;

import ca.bytetube._03_list.ArrayList;
import ca.bytetube._03_list.List;
import ca.bytetube._05_queue.list.LinkedList;

//LinkedList implements Stack
public class Queue<E> {
    private List<E> list = new LinkedList<>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void clear(){
        list.clear();
    }

    public void enQueue(E element){
        list.add(element);
    }

    public E deQueue(){
        return list.remove(0);
    }

    public E front(){
        return list.get(0);
    }



}
