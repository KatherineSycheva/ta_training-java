package com.epam.training.ekaterina_sycheva.java_basics.segments;

public class Main {
    public static void main(String[] args) {

        {
            double length = new Segment(new Point(0, 0), new Point(3, 4)).length();
        }

        {
            Segment first = new Segment(new Point(0, 0), new Point(4, 4));
            Segment second = new Segment(new Point(2, 0), new Point(0, 2));
            Point intersection = first.intersection(second);
        }

        {
            Segment first = new Segment(new Point(2, 5), new Point(0.5, 1.5));
            Segment second = new Segment(new Point(0, 2), new Point(5, 5));
            Point intersection = first.intersection(second);
            System.out.println(intersection == null);
        }
    }
}
