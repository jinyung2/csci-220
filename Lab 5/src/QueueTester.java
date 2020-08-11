/*  Java Class: QueueTester.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 10/03/17
    Description: A test driver for the circle Queue

    I certify that the code below is my own work.

	Exception(s): This is the tester code outlined in Lab handout.

*/

public class QueueTester {
    public static void main(String[] args) {
        CircleQueue<String> csClasses = new CircleQueue<>(5);
        csClasses.enqueue("CSCI 140");
        csClasses.enqueue("CSCI 220");
        csClasses.enqueue("CSCI 230");
        csClasses.dequeue();
        csClasses.enqueue("CSCI 110");
        csClasses.enqueue("CSCI 150");
        csClasses.enqueue("CSCI 145");
        String course = csClasses.first();
        System.out.println(course);
    }
}
