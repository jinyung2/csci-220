/*  Java Class: prefixAvg.java
    Author: Jin Choi
    Class: CSCI220
    Date:09/25/17
    Description: computes the avg of the sum of the elements up to that point. tests various number of elements to compute runtime. Shows difference in runtime for two solutions with different algorithms.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

import java.util.Random;

public class prefixAvg {

    public static void main(String[] args) {
        Random rand = new Random();
        rand.setSeed(System.nanoTime());
        Double[] a = new Double[100];
        for (int i = 0; i < a.length; i++){
            a[i] = rand.nextDouble()*1000;
        }
        System.out.println("For 100 entries: \n");
        performance1(a);
        performance2(a);

        Double[] b = new Double[1000];
        for (int i = 0; i < b.length; i++){
            b[i] = rand.nextDouble()*1000;
        }
        System.out.println("For 1000 entries: \n");
        performance1(b);
        performance2(b);

        Double[] c = new Double[10000];
        for (int i = 0; i < c.length; i++){
            c[i] = rand.nextDouble()*1000;
        }
        System.out.println("For 10000 entries: \n");
        performance1(c);
        performance2(c);

        Double[] d = new Double[100000];
        for (int i = 0; i < d.length; i++){
            d[i] = rand.nextDouble()*1000;
        }
        System.out.println("For 100000 entries: \n");
        performance1(d);
        performance2(d);
    }

    public static Double[] prefixAvg1(Double[] x){
        int capacity = x.length;
        Double[] result = new Double[capacity];
        for(int i = 0; i < x.length; i++){
            Double sum = 0.0;
            for (int j = 0; j < i; j++){
                sum +=x[j];
            }
            result[i] = sum/(i+1);
        }
        return result;

    }
    public static Double[] prefixAvg2(Double[] x){
        int capacity = x.length;
        Double[] result = new Double[capacity];
        Double sum = 0.0;
        for (int i = 0; i < x.length; i++){
            sum += x[i];
            result[i] = sum/(i+1);
        }
        return result;
    }

    public static void performance1(Double[] n) {
        long startTime = System.currentTimeMillis();
        Double[] x = prefixAvg1(n);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println("PrefixAvg1 running time: \nStart Time: " + startTime + "\nEnd Time: " + endTime + "\nElapsed Time: " + elapsed +"\n");
    }

    public static void performance2(Double[] n) {
        long startTime = System.currentTimeMillis();
        Double[] x = prefixAvg2(n);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println("PrefixAvg2 running time: \nStart Time: " + startTime + "\nEnd Time: " + endTime + "\nElapsed Time: " + elapsed +"\n");
    }
}
