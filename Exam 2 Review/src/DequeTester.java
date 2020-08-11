public class DequeTester {
    public static void main(String[] args) {
        DequeTwoStack<Integer> tester = new DequeTwoStack<>();
        tester.addLast(1);
        tester.addLast(2);
        tester.addLast(3);
        System.out.println(tester.first());
        while(!tester.isEmpty()){
            System.out.println(tester.removeFirst());
        }
        System.out.println(tester.size());
    }
}
