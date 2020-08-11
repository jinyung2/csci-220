/*  Java Class: GameEntry.java
    Author: Jin Choi
    Class: CSCI220
    Date: 09/20/2017
    Description: The class that handles 1 score input. Contains data for name, score, and the date.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

import java.util.Calendar;

public class GameEntry {

    private String name;
    private int score;
    private Calendar date;

    public GameEntry(String name, int score, int year, int month, int day) {
        this.name = name;
        this.score = score;
        date = Calendar.getInstance();
        date.set(year, month, day);
    }

    public String getDate() {
        return date.get(Calendar.MONTH)+1+"/"+date.get(Calendar.DAY_OF_MONTH)+"/"+date.get(Calendar.YEAR);
    }
    public void setDate(int year, int month, int day){
        date.set(year, month, day);
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score){
            this.score = score;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String toString() {
        return String.format("%-10s%-7d%s", name, score, getDate());
    }
}