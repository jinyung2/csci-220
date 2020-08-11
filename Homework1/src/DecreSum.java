public class DecreSum {
    public static int decSum(int n){
        if (n <= 0) {return 0;}
        else {return (n-1) + decSum(n-1) ;}
    }

    public static void main(String[] args) {
        for (int i = 10; i > 0; i--){
            int n = decSum(i);
            System.out.println("Sum of all integers less than " + i + " = " + n);
        }
    }
}
