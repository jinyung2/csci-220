public class ReverseArray<E> {
    public void reverse(E[] e, int start, int last){
        if (start < last){
            E temp = e[last];
            e[last] = e[start];
            e[start] = temp;
            reverse(e, start +1, last-1);
        }
    }
}
