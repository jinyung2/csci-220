/*  Java Class: CallCenterSim.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 11/6/17
    Description: The Simulation of the call center. Takes in input for number of available lines, time for simulation, and the two parameters for randomization of time of call and time to finish service. At the end computes longest line during sim, number of customers served, customers left in the queue after sim, longest wait time for any customer, total wait time and the average wait time of customers served.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CallCenterSim {

    public static void main(String[] args) {
        LinkedQueue<Customer> queue = new LinkedQueue<>();
        Random num = new Random(System.nanoTime());
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter value for number of lines: ");
        int l = scan.nextInt();
        System.out.println("Enter value for simulation time: ");
        int t = scan.nextInt();
        System.out.println("Enter value for call time: ");
        int n = scan.nextInt();
        System.out.println("Enter value for service time: ");
        int m = scan.nextInt();
        System.out.println("Running simulation with test case: " + "lines: " + l + " time: " + t + " call time: 1-"+  n + " service time: 1-"+m+"\n");
        ArrayList<Customer> serving = new ArrayList<>();
        ArrayList<Customer> removed = new ArrayList<>();
        double totalWait = 0; double longestWait = 0; int serveTime = 0; int callNum = 0; int served = 0; int waitTime = 0; int longestQueue = 0;
        int linesUsed = 0;
        int callTime = num.nextInt(n) + 1;
        for (int i = 1; i <= t; i++){
            System.out.println("Minute : " + i);
            if(i == callTime){
                callNum++;
                System.out.println(" -Customer " + callNum + " has called.");
                queue.enqueue(new Customer(callTime, String.valueOf(callNum)));
                callTime += num.nextInt(n) + 1;
                longestQueue = Math.max(queue.size(), longestQueue);
            }
            for(Customer c: serving){
                if (i == c.getServiceTime()){
                    removed.add(c);
                    System.out.println(" -Customer " + c.getID() + " has finished being served.");
                    served++;
                    linesUsed--;
                    longestWait = Math.max(c.waitTime(), longestWait);
                    totalWait += c.waitTime();
                }
            }
            serving.removeAll(removed);
            if (!queue.isEmpty() && (linesUsed < l)){
                linesUsed++;
                Customer current = queue.dequeue();
                serving.add(current);
                serveTime = i + (num.nextInt(m) + 1);
                System.out.println(" -Now serving customer " + current.getID() + ". Service will end at time " + serveTime);
                current.setServiceTime(i);
            }
        }
        System.out.println("Longest queue during simulation: " + longestQueue);
        System.out.println("Number of customers served: " + served);
        System.out.println("Numbers of customers left in queue: " + queue.size());
        System.out.println("Longest wait time for customer served: " + longestWait + " minutes.");
        System.out.println("Total wait time for customers served: " + totalWait + " minutes.");
        System.out.printf("%s%.2f%s","Average wait time for customers served: " , (totalWait/(double)served) , " minutes.");
    }
}
