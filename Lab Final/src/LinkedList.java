/*  Java Class: LinkedList.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 12/11/2017
    Description: A doubly linked list implementation for problem 4 on the lab final.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

public class LinkedList<E> {

    public class Node<E>{
        Node<E> prev;
        Node<E> next;
        Integer key;
        E data;

        Node(Node<E> prev, Node<E> next, int key, E data){
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.data = data;
        }

        void setNext(Node<E> node){ next = node; }
        void setPrev(Node<E> node){ prev = node; }
        Node<E> getPrev() { return prev; }
        Node<E> getNext() { return next; }
        Integer getKey() { return key; }
        void setKey(int key) { this.key = key; }
        public E getData() { return data; }
        void setData(E data) { this.data = data; }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private Node min;

    public LinkedList(){ size = 0; }

    public Node getMin(){ return min; }
    public boolean empty(){ return size == 0;}
    public int size(){ return size; }
    public void insert(int key, E e){
        if (size == 0){
            head = new Node<>(null,null, key, e);
            head = tail;
            min = head;
        }
        else{
            Node<E> current = new Node<>(null, null, key, e);
            current.setNext(head);
            head = current;
            min = current.getKey() < min.getKey() ? min = current : min;
        }
        size++;
    }

    public Node removeMin(){
        Node removed = null;
        Node<E> lead = head;
        while(lead.getKey()!=min.getKey()){
            lead = lead.getNext();
        }
        if (lead.equals(min)) {
            removed = lead;
            if (lead == head){
                Node<E> next = lead.getNext();
                head = null;
                next.setPrev(null);
                head = next;
            }else if(lead == tail){
                Node<E> temp = lead.getPrev();
                tail = null;
                temp.setNext(null);
                tail = temp;
            }else{
                Node<E> predecessor = lead.getPrev();
                Node<E> successor = lead.getNext();
                predecessor.setNext(successor);
                successor.setPrev(predecessor);
                lead = null;
            }
        }
        size--;
        return removed;
    }
}
