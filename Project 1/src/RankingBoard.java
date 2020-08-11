/*  Java Class: RankingBoard.java
    Author: Jin Choi
    Class: CSCI220
    Date: 09/20/2017
    Description: The main driver that hardcodes test cases and handles file reader and writer.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

import java.io.*;
import java.text.SimpleDateFormat;

public class RankingBoard {
    public static void print(String[] a){
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
    public static void main(String[] args) {
        GameScore game = new GameScore("Pac-Man", 10);
        GameEntry e1 = new GameEntry("John", 1000, 2017, 7, 6);
        GameEntry e2 = new GameEntry("Mary", 20, 2017, 9, 13);
        GameEntry e3 = new GameEntry("James", 800, 2017, 0, 21);
        GameEntry e4 = new GameEntry("Patricia", 950, 2017, 2, 14);
        GameEntry e5 = new GameEntry("Robert", 990, 2017, 8, 26);
        GameEntry e6 = new GameEntry("Michael", 960, 2017, 6, 3);
        GameEntry e7 = new GameEntry("Elizabeth", 920, 2017, 1, 13);
        GameEntry e8 = new GameEntry("William", 890, 2017, 2, 28);
        GameEntry e9 = new GameEntry("Linda", 995, 2017, 11, 25);
        GameEntry e10 = new GameEntry("David", 925, 2017, 7, 4);
        GameEntry e11 = new GameEntry("Barbara", 965, 2017, 4, 1);
        GameEntry e12 = new GameEntry("Gary", 1001, 2017, 8, 13);
        game.add(e1);
        game.add(e2);
        game.add(e3);
        game.add(e4);
        game.add(e5);
        game.add(e6);
        game.add(e7);
        game.add(e8);
        game.add(e9);
        game.add(e10);
        game.add(e11);
        game.print();
        GameEntry rmv = game.remove(0);
        System.out.println("\nRemoved score:\n" + rmv.toString());
        game.add(e12);
        game.print();
        rmv = game.remove(0);
        System.out.println("\nRemoved score:\n" + rmv.toString());
        game.print();
        System.out.println();

        BufferedReader reader = null;
        BufferedWriter writer = null;


        try {
            reader = new BufferedReader(new FileReader("/home/john/Documents/CSCI220/scores.txt"));
            SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
            String curLine;
            String gameName;
            String name;
            int score;
            String finalText = "";

            int linePos = 1;
            while((curLine = reader.readLine()) != null){
                if (linePos == 1){
                    gameName = curLine;
                    finalText = gameName +"\n";
                }
                else{
                    String[] input = curLine.split("\t");
                    name = input[0];
                    score = Integer.parseInt(input[1]);
                    date.parse(input[2]);
                    score -= 100;
                    if (score < 0){
                        score = 0;
                    }
                    finalText = finalText + name + "\t" + score + "\t" + input[2] +"\n";
                }
                linePos++;
            }
            writer = new BufferedWriter(new FileWriter("/home/john/Documents/CSCI220/scores.txt"));
            System.out.println(finalText);
            writer.write(finalText);


        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}