/*  Java Class: PowerOfTwo.java
    Author: Jin Choi
    Class: CSCI220
    Date: 08/30/2017
    Description: Computes 2^i power using bitwise operators.
    0b01 = 2
    0b10 = 4
    0b100 = 8
    0b1000 = 16
    0b10000 = 32 etc..
    For each left shift, the numerical value represented in binary is the next power of 2.

    I certify that the code below is my own work.

	Exception(s): N/A

*/
public class PowerOfTwo {
    public static long compute(int n){
        long number = 2;
        int bitwise = n-1;
        number = number << bitwise;
        return number;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 62; i+=2){
            System.out.println("2^" + i + " = " + compute(i));
        }
    }
}
