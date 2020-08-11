/*  Java Class: LinkedDeque.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 10/10/2017
    Description: Implementation for a doubled ended Queue using the singlylinkedlist.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

public class LinkedDeque<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedDeque(){ }

    public int size(){ return list.getSize(); }
    public boolean isEmpty(){return list.getSize() == 0;}
    public E first(){return list.getFirst(); }
    public E last(){return list.getLast(); }
    public void addFirst(E e){ list.addFirst(e); }
    public void addLast(E e){ list.addLast(e);}
    public E removeFirst(){ return list.removePos(1);}
    public E removeLast(){return list.removePos(list.getSize());}
}
