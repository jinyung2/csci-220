/*  Java Class: CircleQueue.java
    Author: Jin Choi
    Class: CSCI220
    Date: 10/03/17
    Description: Implementation of the circular Queue ADT in java.

    I certify that the code below is my own work.

	Exception(s): Code is based off the Code Fragment 6.10 outlined in the java textbook.

*/

public class CircleQueue<E> {

    private int size;
    private int front;
    private E[] data;

    public CircleQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        size = 0;
    }

    public int size(){
        return size;
    }

    public void enqueue(E e) throws IllegalStateException{
        if (size == data.length){
            throw new IllegalStateException("Queue is at max capacity");
        }
        int index = (front + size)%data.length;
        data[index] = e;
        size++;
    }

    public E dequeue(){
        if (size == 0){return null;}
        E result = data[front];
        data[front] = null;
        front = (front + 1)%data.length;
        size--;
        return result;
    }
    public E first(){
        if (size == 0) {return null;}
        return data[front];
    }
}
