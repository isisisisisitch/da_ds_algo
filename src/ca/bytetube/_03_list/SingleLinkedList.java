package ca.bytetube._03_list;

public class SingleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;


    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }


    private Node<E> node(int index){
        rangeCheck(index);
        Node<E> node  = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //1.头插
        if (index == 0) {
            first = new Node<>(element, first);
        }else { //2.普通的位置添加
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }

        size++;

    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E>  old = first;
        if (index == 0) {//1.头删
           first = first.next;
        }else {
            //2.普通位置的删除
            Node<E> prev = node(index - 1);
            old = prev.next;
            prev.next = old.next;
        }
        size--;
        return old.element;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> old = node(index);
        E oldEle = old.element;
        old.element = element;
        return oldEle;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        //1.element == null
        if (element == null) {

            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }

                node = node.next;
            }
        }else { //2.element!=null

            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }


        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("size=").append(size).append(",[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            builder.append(node.element);
            node = node.next;
            if (i!=size-1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
