/*  Java Class: ContSum.java
    Author: Jin Choi
    Class: CSCI220
    Date: 09/25/17
    Description: Finds the maximum contiguous sum. tests various number of elements to gather runtime of program.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

import java.util.ArrayList;
import java.util.Random;

public class ContSum {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> a = new ArrayList<>();
        Random rand = new Random();
        rand.setSeed(System.nanoTime());
        for (int i = 0; i < 100; i++){
            a.add(rand.nextInt(2000));
        }
        System.out.println("100 entries: ");
        performance(a);
        a.clear();
        for (int i = 0; i < 1000; i++){
            a.add(rand.nextInt(2000));
        }
        System.out.println("1000 entries: ");
        performance(a);
        a.clear();
        for (int i = 0; i < 10000; i++){
            a.add(rand.nextInt(2000));
        }
        System.out.println("10000 entries: ");
        performance(a);
        a.clear();
        for (int i = 0; i < 100000; i++){
            a.add(rand.nextInt(2000));
        }
        System.out.println("100000 entries: ");
        performance(a);
    }

    public static Integer maxSum(ArrayList<Integer> n) {
        Integer maxSum = 0;
        for (int i = 0; i < n.size();i++){
            Integer sum = 0;
            Integer curMax = sum;
            for(int j = i; j < n.size(); j++){
                sum += n.get(j);
                if (sum > curMax){
                    curMax = sum;
                }
            }
            if (curMax > maxSum){
                maxSum = curMax;
            }
        }
        return maxSum;
    }

    public static void performance(ArrayList<Integer> n) {
        long startTime = System.currentTimeMillis();
        Integer max = maxSum(n);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println("Max sum of subvector is: " + max);
        System.out.println("Start Time: " + startTime + "\nEnd Time: " + endTime + "\nElapsed Time: " + elapsed +"\n");
    }
}
