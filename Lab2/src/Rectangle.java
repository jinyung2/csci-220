/*  Java Class: Rectangle.java
    Author: Jin Choi
    Class: CSCI220
    Date: 09/06/2017
    Description: Rectangle class which implements Polygon interface. Has methods to calculate area and perimeter.

    I certify that the code below is my own work.

	Exception(s): N/A
*/

public class Rectangle implements Polygon{
    private double base;
    private double height;
    public Rectangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    public double area(){
        return base * height;
    }
    public double perimeter(){
        return 2.0*base + 2.0*height;
    }
}
