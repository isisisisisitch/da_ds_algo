package ca.bytetube._05_queue.list;

public interface List<E> {

    public static final int ELEMENT_NOT_FOUND = -1;

    /**
     * clear all elements
     */
    public void clear();

    /**
     * size of the container
     * @return
     */
    public int size() ;

    /**
     * container is empty or not
     * @return
     */
    public boolean isEmpty() ;

    /**
     * add element to tail
     * @param element
     */
    public void add(E element) ;

    /**
     * insert element in certain index
     * @param index
     * @param element
     */
    public void add(int index, E element) ;


    /**
     * remove element in certain index
     * @param index
     * @return previous element
     */
    public E remove(int index) ;



    /**
     *get certain element according to index
     * @param index
     * @return
     */
    public E get(int index);
    /**
     * set element in certain index
     * @param index
     * @param element
     * @return previous element
     */
    public E set(int index, E element);
    /**
     * index of certain element
     * @param element
     * @return
     */
    public int indexOf(E element) ;



    /**
     * whether contain certain element in container
     * @param element
     * @return
     */
    public boolean contains(E element) ;



}
