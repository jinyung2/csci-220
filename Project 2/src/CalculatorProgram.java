/*  Java Class: CalculatorProgram.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 10/10/2017
    Description: The Calculator driver program that runs the calculator. Uses a scanner to take in user input for a math expression that is converted from infix to postfix. It is then evaluated and outputs the answer. Sentinel value of 0 terminates the program.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

import java.util.Scanner;

public class CalculatorProgram {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("This is a Calculator program capable of doing correct order of operation calculations involving \nsymbols: +  -  *  /  %  ^  ( ). Spaces are allowed and program can detect any errors in \ninputted expression. Input 0 to terminate program.");
        while(true){
            System.out.println("Enter a function: ");
            String n = scan.nextLine();
            if(n.equals("0")){
                System.out.println("Sentinel value inputted. Terminating program.");
                break;
            }

            Calculator calc = new Calculator(n);
            if (!calc.isMatched(n)){
                System.out.println("The expression's opening and closing symbols are mismatched.\n");
            }
            else{
                calc.convert();
                if(calc.isLegal()){
                    calc.print();
                    System.out.println("= " + calc.evaluate());
                }
                else{
                    System.out.println("Illegal operator detected.");
                }
            }
        }
        scan.close();
    }
}
