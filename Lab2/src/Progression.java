/*  Java Class: Progression.java
    Author:
    Class: CSCI220
    Date: 09/06/2017
    Description: Generates simple progression of numbers.

    I certify that the code below is my own work.

	Exception(s): This code is from the book, outlines a super class for various subclasses to be implemented.

*/

public class Progression {
    protected long current;

    public Progression(){
        current = 0;
    }

    public Progression(long start){
        current = start;
    }

    public long nextVal(){
        long answer = current;
        advance();
        return answer;
    }

    protected void advance(){
        current++;
    }

    public void printProgression(int n){
        for(int i = 0; i < n; i++){
            if (i > 0){
                System.out.print(" " + nextVal());
            }
            else{
                System.out.print(nextVal());
            }
        }
        System.out.println();
    }
}
