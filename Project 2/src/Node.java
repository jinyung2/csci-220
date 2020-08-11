public class Node<E> {

    private E e;
    private Node<E> next;
    private Node<E> prev;

    public Node(E e){
        this.e = e;
        next = null;
        prev = null;
    }

    public Node(E e, Node next){
        this.e = e;
        this.next = next;
        prev = null;
    }

    public Node(E e, Node next, Node prev){
        this.e = e;
        this.next = next;
        this.prev = prev;
    }

    public E getE() { return e; }

    public void setE(E e) {
        this.e = e;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
