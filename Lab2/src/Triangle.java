/*  Java Class: Triangle.java
    Author: Jin Choi
    Class: CSCI220
    Date: 09/06/2017
    Description: Triangle class which implements Polygon interface. Has methods to calculate area and perimeter, as well as helper methods designed to aid the calculation of area and perimeter.

    I certify that the code below is my own work.

	Exception(s): N/A
*/

public class Triangle implements Polygon {

            private double[][] vertex;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
                vertex = new double[3][2];
                vertex[0][0] = x1;
                vertex[0][1] = y1;
                vertex[1][0] = x2;
                vertex[1][1] = y2;
                vertex[2][0] = x3;
                vertex[2][1] = y3;
            }
        public double getDist(int start, int end){
            double distance = 0;
        if (start > 3 || end > 3 || start < 1 || end < 1){
            System.out.println("Out of bounds.");
            return 0;
        }
        if (start == end){
            return distance;
        }
        if (start == 1) {
            if (end == 2) {
                distance = Math.sqrt(Math.pow((vertex[1][0] - vertex[0][0]), 2) + Math.pow((vertex[1][1] - vertex[0][1]), 2));
            }
            if (end == 3) {
                distance = Math.sqrt(Math.pow((vertex[2][0] - vertex[0][0]), 2) + Math.pow((vertex[2][1] - vertex[0][1]), 2));
            }
        }
        else if (start == 2){
                if (end == 1){
                    distance = Math.sqrt(Math.pow((vertex[1][0]-vertex[0][0]),2)+Math.pow((vertex[1][1]-vertex[0][1]),2));
                }
                if (end == 3){
                    distance = Math.sqrt(Math.pow((vertex[2][0]-vertex[1][0]),2)+Math.pow((vertex[2][1]-vertex[1][1]),2));
                }
            }
        else{
            if (end == 2){
                distance = Math.sqrt(Math.pow((vertex[1][0]-vertex[0][0]),2)+Math.pow((vertex[1][1]-vertex[0][1]),2));
            }
            if (end == 1){
                distance = Math.sqrt(Math.pow((vertex[2][0]-vertex[0][0]),2)+Math.pow((vertex[2][1]-vertex[0][1]),2));
            }
        }
        return distance;
    }
    public double getBase(){
        double base = 0;
        double d1 = getDist(1,2);
        double d2 = getDist(2,3);
        double d3 = getDist(1,3);
        base = d1;
        if (d2 > base){
            base = d2;
        }
        if (d3 > base){
            base = d3;
        }
        return base;
    }

    public double getHeight(){
        double height = 0;
        double d1 = getDist(1,2);
        double d2 = getDist(2,3);
        double d3 = getDist(1,3);
        double max = d1;
        double notMax1 = d2;
        double notMax2 = d3;
        if (d2 > d1 && d2 > d3){
            max = d2;
            notMax1 = d1;
            notMax2 = d3;
        }
        if (d3 > d1 && d3 > d2){
            max = d3;
            notMax1 = d1;
            notMax2 = d2;
        }
        double angle = 0;
        angle = Math.acos((Math.pow(notMax1,2)-Math.pow(max,2) - Math.pow(notMax2,2))/(-2*max*notMax2));
        height = notMax2 * Math.sin(angle);
        return height;
    }
    @Override
    public double area() {
        return (0.5 * getBase() * getHeight());
    }

    @Override
    public double perimeter() {
        double peri = 0;
        double d1 = getDist(1,2);
        double d2 = getDist(2,3);
        double d3 = getDist(1,3);
        if (d1 == d2 + d3){ //Conditionals checks to see if points are co-linear.
            return peri;
        }
        if (d2 == d1 + d3){
            return peri;
        }
        if (d3 == d1 + d2){
            return peri;
        }
        peri = d1 + d2 + d3;
        return peri;
    }
}
