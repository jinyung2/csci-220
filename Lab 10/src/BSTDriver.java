public class BSTDriver {
    public static void main(String[] args) {
        TreeMap<Integer, String> tree = new TreeMap<>();
        tree.put(0,"10");
        tree.put(-1,"10");
        tree.put(0,"11");
        tree.put(10,"5");
        tree.dump();
    }
}
