/*  Java Class: ListPQ.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 12/11/2017
    Description: The priority queue ADT implemented using Linked List. For Lab final question #4.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

public class ListPQ<E> {
    private LinkedList<E> list = new LinkedList<>();
    public ListPQ(){ }
    public void insert(int key, E data){list.insert(key, data); }
    public E min(){
        E data = (E) list.getMin().getData();
        return data;
    }
    public E removeMin(){ return (E) list.removeMin().getData();}
    public int size(){ return list.size();}
    public boolean isEmpty(){ return list.size() == 0;}
}
