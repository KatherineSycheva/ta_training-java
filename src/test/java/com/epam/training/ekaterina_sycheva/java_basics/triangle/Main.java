package com.epam.training.ekaterina_sycheva.java_basics.triangle;


public class Main {
    public static void main(String[] args) {
        /*{
            double area = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4)).area();
            System.out.println(area);
        }
        {
            Point centroid = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 3)).centroid();

            System.out.println(centroid.getX());
            System.out.println(centroid.getY());
        }*/
        Triangle t = new Triangle(new Point(0,0), new Point(4,0), new Point(0,3));
        t.centroid();
    }
}
