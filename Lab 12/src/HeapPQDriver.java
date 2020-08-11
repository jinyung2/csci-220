/*  Java Class: HeapPQDriver.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 11/29/2017
    Description: A driver to test various HeapPriorityQueue methods.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

import java.util.ArrayList;

public class HeapPQDriver {
    public static void main(String[] args) {
        HeapPriorityQueue<Integer, Integer> heapPQ = new HeapPriorityQueue<>();
        int[] key = {1,2,3,4,5,6,7,8,9,10};
        int[] val = {21,12,98,72,-5,64,9,2,100,-21};
        System.out.println("Adding 10 key value pairs: ");
        for(int i = 0; i < key.length; i++){
            heapPQ.insert(key[i],val[i]);
            System.out.println("Added (" + key[i] + ", " + val[i] + ") ");
        }
        System.out.println("Checking size of heap PQ: " + heapPQ.size());
        System.out.println("Running removeMin 3 times and returning removed element: ");
        for(int i = 0; i < 3; i++){
            Entry<Integer,Integer> temp = heapPQ.removeMin();
            int tempKey = temp.getKey();
            int tempVal = temp.getValue();
            System.out.println("Removed: (" + tempKey + ", " + tempVal + ")");
        }
        System.out.println("New size of heapPQ is: " + heapPQ.size());
        System.out.println("Outputting current pairs in the heap PQ's ArrayList: ");
        for (int i = 0; i < heapPQ.size(); i++){
            Entry<Integer, Integer> curr = heapPQ.heap.get(i);
            System.out.println("(" + curr.getKey() + ", " + curr.getValue() + ")");
        }
        System.out.println("Checking min: " + "(" + heapPQ.min().getKey() + ", " + heapPQ.min().getValue() + ")");
        System.out.println("Taking the ArrayList of heap values from heapPQ and using it as a parameter for heap2 using bottom up construction.");
        HeapPriorityQueue<Integer, Integer> heap2 = new HeapPriorityQueue<>(heapPQ.heap);
        System.out.println("Removing and outputting contents of bottom up constructed heap: ");
        while(!heap2.isEmpty()){
            Entry<Integer,Integer> temp = heap2.removeMin();
            int tempKey = temp.getKey();
            int tempVal = temp.getValue();
            System.out.println("(" + tempKey + ", " + tempVal + ")");
        }
    }
}
