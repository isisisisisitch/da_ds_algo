package ca.bytetube._02_arrayList;
import java.util.*;
public class ArrayList<E> {
    private int size;
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

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

    public void add(E element){
        add(size,element);
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


    public E remove(int index){
        rangeCheck(index);

        E old = elements[index];

        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }

        elements[-- size] = null;

        return old;
    }

    public E get(int index){
        rangeCheck(index);
        return  elements[index];
    }

    public E set(int index,E element){
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;

        return old;

    }

    public int indexOf(E element){//null
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        }

        for (int i = 0; i < size; i++) {
            //==比较的是对象的内存地址 equals比较的是对象指定的值
            if (element.equals(elements[i])) return i;

        }
        return ELEMENT_NOT_FOUND;
    }


    public boolean contains(E element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }


    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }

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
