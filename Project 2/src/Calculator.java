/*  Java Class: Calculator.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 10/10/2017
    Description: The calculator class that handles an expression conversion from infix to postfix. This postfix expression is then calculated as a scientific calculator would. Handles a limited number of expressions, ranging from +-, * / %, ^ and ( ). Contains exception handling for invalid inputs, deals with spaces in the expression as well as mismatched opening and closing symbols.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

import java.util.ArrayList;

public class Calculator {
    private String infix;
    private Stack<Character> symbols = new Stack<>();
    private ArrayList<String> postfix = new ArrayList<>();
    private Stack<Integer> numbers = new Stack<>();

    public Calculator(String n) {
        infix = n;
    }

    public ArrayList<String> getPostfix(){
        return postfix;
    }

    public void convert() throws Exception {
        String test = infix;
        String trim = test.replaceAll("\\s+", "");
        char[] arr = trim.toCharArray();
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            Character cur = arr[i];
            if (Character.isDigit(cur)) {
                if (i == arr.length - 1) {
                    Integer m = Integer.parseInt(cur.toString());
                    numbers.push(m);
                    postfix.add(m.toString());
                    numbers.pop();
                } else {
                    a.append(cur);
                    Character next = arr[i + 1];
                    while (Character.isDigit(next) && i < arr.length) {
                        if (i == arr.length - 1) {
                            if (Character.isDigit(cur)) {
                                break;
                            }
                        } else {
                            a.append(next);
                            if (i < arr.length - 2) {
                                i++;
                                next = arr[i + 1];
                            } else {
                                i++;
                            }
                        }
                    }
                }

            } else {
                if (symbols.isEmpty()) {
                    symbols.push(cur);
                } else {

                    if (cur.equals(')')) {
                        while (!symbols.isEmpty()) {
                            if(!symbols.top().equals('(')){
                                postfix.add(symbols.pop().toString());
                            }
                            else{
                                symbols.pop();
                                break;
                            }
                        }
                    }
                    else if (compare(cur, symbols.top()) > -1) {
                        if (!cur.equals('(') && compare(cur, symbols.top()) == 0 && !cur.equals('^')) {
                            postfix.add(symbols.pop().toString());
                            symbols.push(cur);
                        } else {
                            symbols.push(cur);
                        }
                    }
                    else{
                        while(!symbols.isEmpty() && compare(cur, symbols.top())== -1 &&!symbols.top().equals('(')){
                            postfix.add(symbols.pop().toString());
                        }
                        symbols.push(cur);
                    }
                }
            }
            if (!a.toString().equals("")) {
                Integer m = Integer.parseInt(a.toString());
                numbers.push(m);
                a.delete(0, a.capacity() - 1);
                postfix.add(m.toString());
                numbers.pop();
            }
        }
        while (!symbols.isEmpty()) {
            postfix.add(symbols.pop().toString());
        }
    }

    public int compare(Character c, Character c1) {
        Character add = '+';
        Character sub = '-';
        Character open = '(';
        Character close = ')';
        Character multiply = '*';
        Character divide = '/';
        Character mod = '%';
        Character power = '^';
        int cPow = 0;
        int c1Pow = 0;
        if (c == open || c == close){ cPow = 3; }
        else if (c == power){ cPow = 2; }
        else if (c == multiply || c == divide || c == mod){ cPow = 1;}
        if (c1 == open || c1 == close){ c1Pow = 3; }
        else if (c1 == power){ c1Pow = 2; }
        else if (c1 == multiply || c1 == divide || c1 == mod){ c1Pow = 1;}
        if (cPow > c1Pow){ return 1;}
        if (cPow == c1Pow){ return 0;}
        else{return -1;}
    }

    public void print() {
        for (String s : postfix) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    public boolean isLegal() {
        for (String c : postfix) {
            if (!c.equals("+") && !c.equals("-") && !c.equals("%") && !c.equals("*") && !c.equals("/") && !c.equals("^") && !c.equals("(") && !c.equals(")") && !Character.isDigit(c.toCharArray()[0])) {
                return false;
            }
        }
        return true;
    }
    public Integer evaluate() throws Exception {
        for (int i = 0; i < postfix.size() ; i++){
            if (!postfix.get(i).equals("+")&&!postfix.get(i).equals("-")&&!postfix.get(i).equals("*")&&!postfix.get(i).equals("/")&&!postfix.get(i).equals("%")&&!postfix.get(i).equals("^")){
                Integer m = Integer.parseInt(postfix.get(i));
                numbers.push(m);
            }
            else if(postfix.get(i).equals("+")){
                Integer a = numbers.pop();
                Integer b = numbers.pop();
                Integer val = b + a;
                numbers.push(val);
            }
            else if(postfix.get(i).equals("-")){
                Integer a = numbers.pop();
                Integer b = numbers.pop();
                Integer val = b - a;
                numbers.push(val);
            }
            else if(postfix.get(i).equals("*")){
                Integer a = numbers.pop();
                Integer b = numbers.pop();
                Integer val = a * b;
                numbers.push(val);
            }
            else if(postfix.get(i).equals("/")){
                Integer a = numbers.pop();
                Integer b = numbers.pop();
                Integer val = b / a;
                numbers.push(val);
            }
            else if(postfix.get(i).equals("%")){
                Integer a = numbers.pop();
                Integer b = numbers.pop();
                Integer val = b % a;
                numbers.push(val);
            }
            else if(postfix.get(i).equals("^")){
                Integer a = numbers.pop();
                Integer b = numbers.pop();
                Integer val = (int)Math.pow(b,a);
                numbers.push(val);
            }
            else{
                throw new Exception("An illegal operator within the postfix expression.");
            }

        }
        return numbers.pop();
    }

    public boolean isMatched(String n) throws Exception {
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
                    return false;
                }
                int index = closing.indexOf(c);
                char latest = buffer.pop();
                char[] temp = closing.toCharArray();
                if (index != opening.indexOf(latest)){
                    if (latest == '[') { latest = ']';};
                    if (latest == '(') { latest = ')';};
                    if (latest == '{') { latest = '}';};
                    return false;
                }
            }
        }
        if(buffer.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}



