/*  Java Class: MyList.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 12/11/2017
    Description: Generic implementation of the MyList assignment for problem 3 on Lab final.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

public class MyList<E> {

    private E[] array;
    private int size;
    private final int CAPACITY = 50;

    public MyList(){
        array = (E[]) new Object[CAPACITY];
        size = 0;
    }

    public void insertFront(E e) {
        for(int i = size - 1; i >= 0; i--){
            array[i+1] = array[i];
        }
        array[0] = e;
        size++;
    }

    public E removeRear(){
        E e = array[size-1];
        array[size-1] = null;
        size--;
        return e;
    }

    public boolean empty(){
        return (size == 0);
    }
}
