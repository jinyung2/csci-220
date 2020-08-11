/*  Java Class: LinkedQueue.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 11/6/17
    Description: The LinkedQueue class implemented using the SinglyLinkedList class from previous lab work.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

public class LinkedQueue<E>{
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    private int maxSize = 0;
    public LinkedQueue(){ }
    public void setMax(){ if (size() > maxSize){ maxSize = size(); } }
    public int getMax(){ return maxSize; }
    public int size(){ return list.getSize(); }
    public boolean isEmpty(){ return list.getSize() == 0;}
    public E first(){ return list.getFirst();}
    public void enqueue(E e){list.addLast(e);}
    public E dequeue(){return list.removePos(1);}
    }
