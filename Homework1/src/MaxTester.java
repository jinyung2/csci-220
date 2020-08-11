public class MaxTester {
    public static void main(String[] args) {
        MaxRecursion<Integer> n = new MaxRecursion<>();
        Integer[] a = {2,45,4000,100,200,3,4};
        Integer max = n.max(a,a.length, 0);
        System.out.println(max);
    }
}
