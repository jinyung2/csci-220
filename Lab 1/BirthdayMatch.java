/*  Java Class: BirthdayMatch.java
    Author: Jin Choi
    Class: CSCI220
    Date: 08/30/2017
    Description: Generates random birthdays and includes a method to search for matches.

    I certify that the code below is my own work.

	Exception(s): N/A

*/
import java.util.Random;
import java.util.GregorianCalendar;

public class BirthdayMatch {

    private int[] list;

    public BirthdayMatch(int n){
        list = new int[n];

    }
    public void generate(){
        for (int i = 0; i < list.length; i++) {
            Random a = new Random();
            GregorianCalendar cal = new GregorianCalendar();
            int year = a.nextInt(100) + 1900;
            cal.set(cal.YEAR, year);
            int DayOfYear = a.nextInt(cal.getActualMaximum(cal.DAY_OF_YEAR) - 1) + 1;
            list[i] = DayOfYear;
        }
    }

    public boolean compare(){
        int counter = 0;
        while (counter < list.length){
            for (int i = counter+1; i < list.length; i++){
                if (list[counter] == list[i]){
                    return true;
                }
            }
            counter++;
        }

        return false;
    }
}
