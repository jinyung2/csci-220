/*  Java Class: StackBalance.java
    Author: Jin Choi
    Class: CSCI220
    Date: 10/01/17
    Description: Java Class that tests ot see if opening and closing symbols "({[" "]})" match.

    I certify that the code below is my own work.

	Exception(s): The code is a template from the book. Added print outs for match/non-match and tweaks for extra credit. Added driver with various test cases for the method.

*/

import java.util.Stack;

public class StackBalance {
    public static boolean isMatched(String n){
        final String opening = "({[";
        final String closing = ")}]";
        Stack<Character> buffer = new Stack<>();
        char[] expression = n.toCharArray();
        for (char c : expression){
            if (opening.indexOf(c) != -1){
                buffer.push(c);
            }
            else if (closing.indexOf(c)!= -1){
                if (buffer.isEmpty()){
                    System.out.println("Latest expression opens with a closing symbol. \n");
                    return false;
                }
                int index = closing.indexOf(c);
                char latest = buffer.pop();
                char[] temp = closing.toCharArray();
                if (index != opening.indexOf(latest)){
                    if (latest == '[') { latest = ']';};
                    if (latest == '(') { latest = ')';};
                    if (latest == '{') { latest = '}';};
                    System.out.println("Opening and closing symbols do not match. Expected: " + latest +", but latest symbol was: " + temp[index] +"\n");
                    return false;
                }
            }
        }
        if(buffer.isEmpty()){
            System.out.println("All opening and closing symbols have been matched.\n");
            return true;
        }
        else{
            System.out.println("Opening and closing symbols do not match. Buffer is not yet empty, no pair for " + "'" + buffer.peek() + "'.\n");
            return false;
        }
    }

    public static void main(String[] args) {
        String exp1 = "{(a+b)*c}";
        String exp2 = "{(a+b)*c]";
        String exp3 = "((a+b)*c}/5)";
        String exp4 = "[({a+b)*c}]";
        String exp5 = "{}}[]()[]()[]";
        String exp6 = "[[]()()(){}()[";
        String exp7 = "(((()))";
        System.out.println("Testing " + exp1 + ":");
        isMatched(exp1);
        System.out.println("Testing " + exp2 + ":");
        isMatched(exp2);
        System.out.println("Testing " + exp3 + ":");
        isMatched(exp3);
        System.out.println("Testing " + exp4 + ":");
        isMatched(exp4);
        System.out.println("Testing " + exp5 + ":");
        isMatched(exp5);
        System.out.println("Testing " + exp6 + ":");
        isMatched(exp6);
        System.out.println("Testing " + exp7 + ":");
        isMatched(exp7);
    }
}
