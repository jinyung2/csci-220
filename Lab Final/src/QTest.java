public class QTest {
    public static void main(String[] args) {
        TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        queue.enqueue(5);
        queue.enqueue(7);
        Integer x = queue.front();
        System.out.println(x);
        queue.enqueue(1);
        x = queue.dequeue();
        System.out.println(x);
        queue.enqueue(2);
        x = queue.dequeue();
        System.out.println(x);
        x = queue.dequeue();
        System.out.println(x);
    }
}
