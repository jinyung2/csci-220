/*  Program: PQDriver.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 11/20/17
    Description: A driver to test methods for a Sorted Priority Queue ADT.

    I certify that the code below is my own work.

	Exception(s): N/A

*/


public class PQDriver {
    public static void main(String[] args) {
        SortedPriorityQueue<Integer,Integer> sortedPQ = new SortedPriorityQueue<>();
        Integer[] key = {1,3,2,4,5,8,7,6,10};
        Integer[] val = {44,50,21,32,90,8,5,1,36};
        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();

        System.out.println("Inserting various keys and values to the sorted Priority Queue: ");
        for (int i = 0; i < key.length; i++){ // inserts the keys and val pairs in the above array.
            System.out.print("("+ key[i] + ", " + val[i] +")" + " ");
            sortedPQ.insert(key[i], val[i]);
        }
        System.out.println("\n\nChecking the minimum element, the first to be removed:" + "(" + sortedPQ.min().getKey() + ", " + sortedPQ.min().getValue() + ") ");
        System.out.println("\n\nRunning remove minimum method until sorted priority queue is empty: ");
        while(!sortedPQ.isEmpty()){
            Integer n = sortedPQ.min().getValue();
            Integer m = sortedPQ.min().getKey();
            sortedPQ.removeMin();
            System.out.print("(" + m + ", " + n + ") ");
        }
        System.out.println("\n\nChecking size after complete removal of Key Value pairs:");
        System.out.println(sortedPQ.size());
        System.out.println("\n\nRe-adding key and value pairs to test for sorting. ");
        for(int i = 0; i < key.length; i++){
            sortedPQ.insert(key[i], val[i]);
        }
        Entry<Integer, Integer> current = sortedPQ.removeMin();
        Entry<Integer, Integer> next = sortedPQ.removeMin();
        compare(current.getValue(), next.getValue());
    }

    public static Integer compare(Integer a, Integer b){
        if (a > b){return a;}
        else if(b > a){return b;}
        else {return a;}
    }
}
