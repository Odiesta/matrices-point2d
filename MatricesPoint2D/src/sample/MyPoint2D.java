package sample;

import javafx.geometry.Point2D;

public class MyPoint2D {

    public static void main(String[] args) {
        // initialize Point2D object
        Point2D point2D = new Point2D(0,0);
        System.out.println(point2D);

        // Add coordinate to point2D
        point2D = point2D.add(1,5);
        System.out.println(point2D);

        // Subtract coordinate from point2D
        point2D = point2D.subtract(0,3);
        System.out.println(point2D);

        // Print the x and y coordinate of point2D
        System.out.println(point2D.getX());
        System.out.println(point2D.getY());
    }

}
