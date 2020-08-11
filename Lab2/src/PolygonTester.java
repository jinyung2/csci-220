/*  Java Class: PolygonTester.java
    Author: Jin Choi
    Class: CSCI220
    Date: 09/06/2017
    Description: Driver to test classes. contains various different triangles as well as vertex coordinates that do not form a triangle (forms a line). Tests a couple different cases for rectangle as well.

    I certify that the code below is my own work.

	Exception(s): N/A
*/

public class PolygonTester {
    public static void main(String[] args) {
        System.out.println("Triangle test cases: ");
        Triangle tri = new Triangle(0,0,3,0,3,4);//perfect right triangle
        System.out.printf("%s%.2f\n%s%.2f\n","The area is ", tri.area(), "The perimeter is ", tri.perimeter());
        Triangle tri1 = new Triangle(0,2.7,4.5,8.2,12,6.8);//obtuse triangle
        System.out.printf("%s%.2f\n%s%.2f\n","The area is ", tri1.area(), "The perimeter is ", tri1.perimeter());
        Triangle tri2 = new Triangle(0,0,4.3,0,3.5,5.6);//acute triangle
        System.out.printf("%s%.2f\n%s%.2f\n","The area is ", tri2.area(), "The perimeter is ", tri2.perimeter());
        Triangle tri3 = new Triangle(1,2,3,4,5,6);//not a triangle, points are colinear
        System.out.printf("%s%.2f\n%s%.2f\n","The area is ", tri3.area(), "The perimeter is ", tri3.perimeter());
        System.out.println("\nRectangle test cases: ");
        Rectangle rect = new Rectangle(5.5, 10.5); //tall rectangle
        System.out.printf("%s%.2f\n%s%.2f\n","The area is ", rect.area(), "The perimeter is ", rect.perimeter());
        Rectangle rect1 = new Rectangle(10.5, 5.5); //wide rectangle
        System.out.printf("%s%.2f\n%s%.2f\n","The area is ", rect1.area(), "The perimeter is ", rect1.perimeter());
        Rectangle rect2 = new Rectangle(10.5, 10.5); //square
        System.out.printf("%s%.2f\n%s%.2f\n","The area is ", rect2.area(), "The perimeter is ", rect2.perimeter());

    }
}
