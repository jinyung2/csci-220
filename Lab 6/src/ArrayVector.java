/*  Java Class: ArrayVector.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 10/10/2017
    Description: An ArrayVector implementation using dynamic array. handles resizing, shrinking for performance and various methods for adding and removing elements.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

public class ArrayVector<E> {
    private E[] A;
    private int size = 0;
    private int capacity = 8;
    public ArrayVector(){
        A = (E[]) new Object[capacity];
    }

    public int size(){return size; }
    public boolean isEmpty(){return A.length == 0; }
    public E get(int i) throws IndexOutOfBoundsException{
        checkIndex(i, size);
        return A[i]; }
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i,size);
        E temp = A[i];
        A[i] = e;
        return temp;
    }
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size+1);
        if (size == A.length){
            resize();
        }

        for(int k = size-1;k >=i; k--){
            A[k+1] = A[k];
        }
        A[i] = e;
        size++;
    }
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i,size);
        E temp = A[i];
        for(int k = i;k < size-1;k++){
            A[k] = A[k+1];
        }
        A[size-1] = null;
        size--;
        if (size <= A.length/4){
            shrink();
        }
        return temp;
    }

    private void resize(){
        this.capacity = this.capacity * 2;
        E[] temp = (E[])new Object[capacity];
        for(int k = 0; k < size; k++){
            temp[k] = A[k];
            A[k] = null;
        }
        A = temp;
    }

    private void shrink(){
        if(this.capacity % 2 == 0){
            this.capacity = this.capacity/2;
        }
        else{
            this.capacity = this.capacity/2+1;
        }
        E[] temp = (E[])new Object[capacity];
        for(int k = 0; k < size; k++){
            temp[k] = A[k];
        }
        A = temp;
    }
    public int getCapacity(){
        return capacity;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
        if(i < 0 || i >= n){
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

}
