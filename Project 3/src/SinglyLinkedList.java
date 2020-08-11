/*  Java Class: SinglyLinkedList.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 11/6/17
    Description: Use a linked list to store a list of names, have methods to insert at front and rear, remove an element and print the contents. Used to implement the LinkedQueue in project 3.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E>{
    private class Node<E> {
        private E name;
        private Node<E> next;

        public Node(E s){
            name = s;
        }
        public Node(E s, Node<E> n) {
            name = s;
            next = n;
        }
        public void setNext(Node<E> n){ next = n; }
        public Node<E> getNext(){ return next; }
        public void setName(E n){ name = n; }
        public E getName(){ return name; }
    }

    private Node<E> head = null;
    private Node<E> tail = null;

    private int size = 0;

    public SinglyLinkedList(){ }

    public int getSize(){ return size;}

    public E getFirst(){
        if (size == 0){
        return null; }
        return head.getName();
    }
    public E getLast(){
        if (size == 0){
            return null;
        }
        return tail.getName();}

    public E removePos(int pos) throws IndexOutOfBoundsException  {
        if (pos < 1 || pos > size) {
            throw new IndexOutOfBoundsException("Inputted parameter argument is out of bounds. "); }
        else if (size == 0) {
            System.out.println("This is currently empty.");
            return null;
        } else {
            if (pos == 1) { //remove first
                Node<E> temp = head;
                head = temp.getNext();
                size--;
                if (size == 0){
                    tail = null;
                }
                return temp.getName();
            }
            if (pos == size) { //remove last
                Node<E> lead = head;
                Node<E> follow = head;
                while (lead != tail) {
                    follow = lead;
                    lead = lead.getNext();
                }
                Node<E> temp = lead;
                tail = follow;
                tail.setNext(null);
                size--;
                return temp.getName();
            }
            Node<E> n = head; // remove anywhere in between
            pos = pos - 1;
            for (int i = 1; i < size - 1; i++) {
                if (i == pos) {
                    Node temp = n.getNext();
                    temp = temp.getNext();
                    n.setNext(temp);
                    break;

                }
                n = n.getNext();
            }
            size--;
            return n.getName();
        }
    }

    public void addFirst(E e){
        if (size == 0) {
            head = new Node(e);
            head.setNext(null);
            tail = head;
        }
        else{
            Node temp = new Node(e);
            temp.setNext(head);
            head = temp;
        }
        size++;
    }

    public void addLast(E e){
        Node newest = new Node(e, null);
        if (size == 0){
            head = newest;
            tail = head;
        }
        else {
            tail.setNext(newest);
            tail = newest;
        }
        size++;
    }
    public void print(){
        System.out.println("Current names in the list: ");
        Node cur = head;
        if (size == 0) {
            System.out.println("The list is empty.");
        }
        else{
            while((cur.getNext() != null)){
                System.out.print(cur.getName()+ " -> ");
                cur = cur.getNext();
            }
            System.out.println(cur.getName());
        }
    }
}
