public class MyListDriver {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        for(int i = 0; i < 50; i++){
            list.insertFront(i);
        }
        list.insertFront(1);
        System.out.println(list.empty());
        System.out.println(list.removeRear());
    }
}
