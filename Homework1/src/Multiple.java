public class Multiple {
    public static boolean isMultiple(long a, long b){
        if (a%b == 0){ return true; }
        else {return false;}
    }

    public static void main(String[] args) {
        System.out.println(isMultiple(20, 5));
        System.out.println(isMultiple(19, 5));
        System.out.println(isMultiple(18, 5));
        System.out.println(isMultiple(16, 4));
    }
}
