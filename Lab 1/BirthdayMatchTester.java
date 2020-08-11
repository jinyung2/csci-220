/*  Java Class: BirthdayMatchTester.java
    Author: Jin Choi
    Class: CSCI220
    Date: 08/30/2017
    Description: Tester class with main method for running the BirthdayMatch program.

    I certify that the code below is my own work.

	Exception(s): N/A

*/
public class BirthdayMatchTester {
    public static void main(String[] args) {
        System.out.printf("%s%13s\n","DOB#","Matches");
        System.out.printf("%s%13s\n","----","-------");
        for (int i = 5; i <= 100; i+=5){
            int count = 0;
            for (int j = 0; j < 10; j++){
                BirthdayMatch a = new BirthdayMatch(i);
                a.generate();
                boolean result = a.compare();
                if (result){
                    count++;
                }
            }
            System.out.printf("%-10d%d\n",i,count);
        }
    }
}
