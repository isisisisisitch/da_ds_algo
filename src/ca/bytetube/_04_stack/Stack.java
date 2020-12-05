package ca.bytetube._04_stack;

import ca.bytetube._03_list.ArrayList;
import ca.bytetube._03_list.LinkedList;
import ca.bytetube._03_list.List;

//LinkedList implements Stack
public class Stack<E> {
    //extends "is a" A extends B ---> A is B
    //implements " has a"  A implements B ---> A has a B
    private List<E> list = new ArrayList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void push(E element) {
        list.add(element);

    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    public E peek() {
        return list.get(list.size() - 1);
    }

}
