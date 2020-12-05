package ca.bytetube._04_stack.list;


import ca.bytetube._03_list.AbstractList;

@SuppressWarnings("unchecked")
public class ArrayList<E> extends AbstractList<E> {//extends: ArrayList is a AbstractList

    private int size;
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(int capacity){//-2 10
        capacity = (capacity<DEFAULT_CAPACITY)?DEFAULT_CAPACITY:capacity;
        elements = (E[]) new Object[capacity];
    }

    public ArrayList(){//capacity = 10
        this(DEFAULT_CAPACITY);
    }


    public void clear() {
        size = 0;
    }


    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size+1);

        for (int i = size; i >index ; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity>=size+1) return;

        //每次扩容扩大1.5倍
        int newCapacity = oldCapacity+(oldCapacity>>1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;//address
    }

    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];

        for (int i = index+1; i < size; i++) {
            elements[i-1]  = elements[i];//覆盖
        }
        elements[--size] = null;
        return old;
    }


    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }


    public E set(int index, E element) {
        rangeCheck(index);

        E old = elements[index];
        elements[index] = element;
        return old;
    }

    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }

            }
        }else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }





    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            builder.append(elements[i]);
            if (i!=size-1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}

