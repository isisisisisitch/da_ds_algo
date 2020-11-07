package ca.bytetube._02_arrayList;
import java.util.*;
public class ArrayList<E> {
    private int size;
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity){
        capacity = (capacity < DEFAULT_CAPACITY ) ? DEFAULT_CAPACITY: capacity;
        elements = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public int size(){
        return  size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        size = 0;
    }

    public void add(int index, E element){
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= size+1) return;

        //发生扩容 每次扩大1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements =  (E[]) new Object[newCapacity];//null
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }

    }

    private void outOfBounds(int index) {
        throw  new IndexOutOfBoundsException("Index:"+index+", Size"+ size);
    }
}
