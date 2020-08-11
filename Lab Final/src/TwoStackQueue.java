/*  Java Class: TwoStackQueue.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 12/11/2017
    Description: The implementation of Queue ADT using two stacks for Lab Final question 1.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

import java.util.Stack;

public class TwoStackQueue<E> {

    private Stack<E> inStack;
    private Stack<E> outStack;

    public TwoStackQueue(){
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void enqueue(E e){
        inStack.push(e);
    }

    public E dequeue(){
        if(!outStack.empty()){
            return outStack.pop();
        }
        else{
            while(!inStack.empty()){
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }

    }

    public E front(){
        if(!outStack.empty()){
            return outStack.peek();
        }
        else{
            while(!inStack.empty()){
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }
    }
}
