/*  Java Class: GameScore.java
    Author: Jin Choi
    Class: CSCI220
    Date: 09/20/2017
    Description: The class that handles adding and removing scores, checking for conditions to see if a score qualifies as a high score.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

public class GameScore {
    private String game;
    private GameEntry[] ranking;
    private int count;

    public GameScore(String game, int capacity) {
        this.game = game;
        count = 0;
        ranking = new GameEntry[capacity];
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void print() {
        System.out.println("\n"+ game + " Top 10 Scores: \n");
        String output = String.format("%-6s%-10s%-7s%s\n%034d","Rank", "Name", "Score", "Date", 0).replace('0', '-');
        System.out.println(output);
        for (int i = 0; i < count; i++){
            int rank = i+1;
            System.out.printf("%-6s%s\n", rank, ranking[i].toString());
        }
    }
    //add method utilizes the insert sort algorithm
    public void add(GameEntry e) {
        if (count == 0) {ranking[0] = e; ++count;}
        else {
            int score = e.getScore();
            if (score < 1 || score > 1000) {
                System.out.println("\nInputted score for " + e.getName() + " is out of bounds. Setting score to 0.");
                score = 0;
                e.setScore(0);
            }
            if (count < ranking.length || score > ranking[count-1].getScore()) {
                if (count < ranking.length) {count++;}
                int j = count - 1;
                while (j > 0 && ranking[j-1].getScore() < score) {
                        ranking[j] = ranking[j - 1];
                        j--;
                }
                ranking[j] = e;
            }
        }
    }

    public GameEntry remove(int a) throws IndexOutOfBoundsException{
        if (a < 0 || a >= count) {throw new IndexOutOfBoundsException("Invalid index: " + a);}
        GameEntry temp = ranking[a];
        for (int j = a; j < count-1; j++) { ranking[j] = ranking[j+1]; }
        ranking[count-1] = null;
        count--;
        return temp;
    }

}


