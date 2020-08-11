/*  Java Class: AbsProgression.java
    Author: Jin Choi
    Class: CSCI220
    Date: 09/06/2017
    Description: Returns the absolute value of the difference of two number pairs.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

public class AbsProgression extends Progression{

    protected long prev;


    public AbsProgression(){
        this(2, 200);
    }
    public AbsProgression(long a, long b){
        super(a);
        prev = a + b;
    }

    protected void advance(){
        long diff = Math.abs(prev - current);
        prev = current;
        current = diff;

    }

    public static void main(String[] args) {
        System.out.println("Base case, starts with 2 and 200: ");
        AbsProgression q = new AbsProgression();
        q.printProgression(10);
        System.out.println("Starting with 3 and 300: ");
        AbsProgression p = new AbsProgression(3, 300);
        p.printProgression(15);
        System.out.println("Starting with 4 and 400: ");
        AbsProgression r = new AbsProgression(4, 400);
        r.printProgression(20);
        System.out.println("Starting with 10 and 387: ");
        AbsProgression s = new AbsProgression(10, 387);
        s.printProgression(25);
        Progression t = new Progression(200);
        t.printProgression(10);

    }
}
