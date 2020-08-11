/*  Java Class: TestDriver.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 10/10/2017
    Description: Test driver that runs certain methods for LinkedDeque and ArrayVector.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

public class TestDriver {
    public static void main(String[] args) {
        LinkedDeque<Integer> linkD = new LinkedDeque<>();
        ArrayVector<Integer> arrayV = new ArrayVector<>();
        System.out.println("Adding 1~10 into a linkedDeque.");
        for(int i = 0; i < 10; i++){
            linkD.addFirst(i+1);
        }
        System.out.println("Contents: ");
        while(!linkD.isEmpty()){
            System.out.printf(linkD.removeLast() + " ");
        }
        System.out.println();
        System.out.println("Adds 1~10 into array vector: ");
        for(int i = 0; i < 10; i++){
            System.out.print(i+1 + " ");
            arrayV.add(i, i+1);
        }

        System.out.println("\nSize check after passing initial capacity of 8: " + arrayV.size());
        System.out.println("Removing 6 elements. ");
        for(int i = 0; i < 6; i++){
            arrayV.remove(0);
        }
        System.out.println("Size check after going under N/4 elements for shrink method: " + arrayV.getCapacity());
        for(int i = 0; i < arrayV.size();i++){
            System.out.println(arrayV.get(i));
        }
        arrayV.add(3, 10);
        System.out.println(arrayV.getCapacity());
        arrayV.add(4,20);
        arrayV.add(4,20);
        arrayV.add(4,20);
        arrayV.add(4,20);
        arrayV.add(4,20);
        for(int i = 0; i < arrayV.size(); i++){
            System.out.println(arrayV.get(i));
        }
        System.out.println(arrayV.getCapacity());

    }
}
