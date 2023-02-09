package com.epam.training.ekaterina_sycheva.java_basics.segments;

import static java.lang.Math.*;
import static java.lang.StrictMath.pow;

class Segment {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        if ((start.getX() == end.getX()) && (start.getY() == end.getY())) {
            throw new IllegalArgumentException();
        }
        else {
            this.start = start;
            this.end = end;
        }
    }

    double length() {
        return sqrt(pow((end.getX() - start.getX()), 2) + pow((end.getY()-start.getY()),2));
    }

    Point middle() {
        return new Point((start.getX()+end.getX()) / 2, (start.getY()+end.getY()) / 2);
    }

    Point intersection(Segment another) {
        if (this.isCollinear(another)) {
            return null;
        } else {
            double x1 = this.start.getX();
            double x2 = this.end.getX();
            double y1 = this.start.getY();
            double y2 = this.end.getY();
            double x3 = another.start.getX();
            double x4 = another.end.getX();
            double y3 = another.start.getY();
            double y4 = another.end.getY();

            double px = ((x1*y2-y1*x2)*(x3-x4)-(x1-x2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
            double py = (((x1*y2-y1*x2)*(y3-y4)-(y1-y2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4)));
            Point cross = new Point(px, py);
            if (this.isBelonging(cross) && another.isBelonging(cross)) {
                return cross;
            } else {
                return null;
            }
        }
    }

    boolean isBelonging(Point p) {
        return (p.getX() >= this.start.getX() && p.getX() <= this.end.getX()) || (p.getX() <= this.start.getX() && p.getX() >= this.end.getX());
    }

    boolean isCollinear(Segment s) {
        return (this.start.getX() - this.end.getX()) * (s.start.getY() - s.end.getY()) - (this.start.getY() - this.end.getY()) * (s.start.getX() - s.end.getX()) == 0;
    }

}
