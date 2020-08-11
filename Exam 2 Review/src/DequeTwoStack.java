import java.util.Stack;

public class DequeTwoStack<E> {
    private Stack<E> inStack = new Stack<E>();
    private Stack<E> outStack = new Stack<E>();
    private int size;
    public DequeTwoStack(){ }
    public void addFirst(E e){
        if (!outStack.empty()){
            while(!inStack.empty()){
                outStack.push(inStack.pop());
            }
        }
        size++;
        outStack.push(e);
    }
    public void addLast(E e){
        inStack.push(e);
        size++;
    }
    public E removeFirst(){
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
    public E removeLast(){
        return inStack.pop();
    }
    public E first(){
        if(!outStack.empty()){
            return outStack.pop();
        }
        else{
            while(!inStack.empty()){
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }
    }
    public E last(){return inStack.peek();}
    public int size(){return (inStack.size() + outStack.size());}
    public boolean isEmpty(){return (inStack.empty()&&outStack.empty());}
}
