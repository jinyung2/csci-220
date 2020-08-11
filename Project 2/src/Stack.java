/*  Java Class: Stack.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 10/10/2017
    Description: The Stack class implementation using SinglyLinkedList.java code written for a previous lab.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

public class Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public Stack(){ }
    public int size(){return list.getSize();}
    public boolean isEmpty(){return list.getSize() == 0;}
    public void push(E e){list.addFirst(e);}
    public E top(){return list.getFirst();}
    public E pop() throws Exception { return list.removePos(1);}
}
