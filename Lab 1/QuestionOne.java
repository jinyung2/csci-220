/*  Java Class: QuestionOne.java
    Author: Jin Choi
    Class: CSCI220
    Date: 08/30/2017
    Description: Tests to see if there is a pair of numbers within the array that results in a even number.

    I certify that the code below is my own work.

	Exception(s): N/A

*/
public class QuestionOne {

    public static boolean tester(int[] a){
        int counter = 0;
        while(counter < a.length){
            for(int i = counter; i < a.length ; i++){
                if ((a[counter] * a[i])%2 == 0){
                    System.out.println("A product of two numbers are even.");
                    return true;
                }
            }
            counter++;
        }
        System.out.println("No products of two numbers were even.");
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b = {1,3,5,7,9,11,13,15};
        int[] c = {5,7,9,2,8};
        int[] d = {11, 21, 31, 41, 51};
        tester(a);
        tester(b);
        tester(c);
        tester(d);
    }
}
