package ca.bytetube._04_stack.list;

import ca.bytetube._03_list.AbstractList;

public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;


    private static class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }


    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    private Node<E> node(int index){
        rangeCheck(index);

        if (index <= size >> 1) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;

        }

    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //3.尾插
        if (index == size) {
            Node<E> prev = last;//null
            Node<E> newLast = new Node<>(element,prev,null);
            if (size == 0) {//插入第一个节点
                first = newLast;
                last = newLast;
            }else {
                prev.next = newLast;
                last = newLast;
            }
        }else {
            //1.普通位置的插入
            Node<E> next = node(index);//0
            Node<E> prev = next.prev;//null
            Node node = new Node(element, prev, next);
            next.prev = node;
            if (index == 0) {//2.头插
                first = node;
            }else {
                prev.next = node;
            }
        }
        size++;

    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (index == 0) {//头删
            first = next;
        }else {
            prev.next = next;
        }

        if (next == null) {//尾删
            last = prev;
        }
        else {
            //1.普通位置删除
            next.prev = prev;

        }
        size--;

        return node.element;
    }



    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }

        }else {

            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(",[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            sb.append(node.element);
            node = node.next;
            if (i!=size-1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
