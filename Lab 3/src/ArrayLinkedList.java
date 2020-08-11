/*  Java Class: ArrayLinkedList.java
    Author: Jin Choi
    Class: CSCI220
    Date: 09/18/2017
    Description: Implements an Array of names and methods to insert at the front and rear, remove an element and print the contents.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

public class ArrayLinkedList {

    public static void insertRear(String[] a, String name){
        int pos = a.length-1;
        while(a[pos] == null){
            pos -= 1;
        }
        if (pos < a.length-1){
            a[pos+1] = name;
        }
        else{
            for (int i = 0; i < a.length-1; i++){
                a[i] = a[i+1];
            }
            a[a.length-1] = name;
        }
    }
    public static void insertFront(String[] a, String name){
        for (int i = a.length - 2; i >= 0; i--){
            a[i+1] = a[i];
        }
        a[0] = name;
    }

    public static String remove(String[] a, int index){
        String removed = a[index];
        for (int i = index; i < a.length - 1; i++){
            a[i] = a[i + 1];
        }
        a[a.length-1] = null;
        return removed;
    }
    public static void print(String[] a){
        System.out.println("Current elements in the array: ");
        for (int i = 0; i < a.length; i++){
            if (i == 0){
                System.out.print(a[i]);
            }
            else if (i == a.length - 1){
                System.out.print("," + a[i] + "\n");
            }
            else {
                System.out.print("," + a[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] arr = new String[10];
        insertFront(arr,"John");
        insertFront(arr,"Peter");
        insertFront(arr,"Goode");
        insertFront(arr,"Annin");
        insertFront(arr,"Arthur");
        insertFront(arr,"Julian");
        insertFront(arr,"Jill");
        insertFront(arr,"Jane");
        insertFront(arr,"Janice");
        insertFront(arr,"Horia");

        print(arr);

        insertRear(arr,"Tim");
        insertRear(arr, "Johnny");
        insertRear(arr, "Ted");

        print(arr);

        remove(arr, 8);
        remove(arr, 2);
        remove(arr, 5);

        print(arr);

        insertRear(arr, "Jesus");

        print(arr);

        insertRear(arr, "Jenny");

        print(arr);

        insertRear(arr, "Michelle");

        print(arr);

        insertRear(arr, "Connor");

        print(arr);
    }
}
