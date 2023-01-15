package com.epam.training.ekaterina_sycheva.java_basics.figures_extra_challenge;

import static java.lang.Math.*;

public class LineSegment {
    Point c;
    Point d;


    public LineSegment (Point c, Point d) {
        this.c = c;
        this.d = d;
    }

    public Point pointCross(LineSegment seg) {
        double x1 = c.getX();
        double x2 = d.getX();
        double x3 = seg.c.getX();
        double x4 = seg.d.getX();
        double y1 = c.getY();
        double y2 = d.getY();
        double y3 = seg.c.getY();
        double y4 = seg.d.getY();
        //is lines cross
        if ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4) != 0) {
            double px = ((x1*y2-y1*x2)*(x3-x4) - (x1-x2)*(x3*y4-y3*x4)) / ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
            double py = ((x1*y2-y1*x2)*(y3-y4) - (y1-y2)*(x3*y4-y3*x4)) / ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
            Point p = new Point(px, py);
            //is segments cross
            if (pointBelongs(this, p) && pointBelongs(seg, p)) {
                return p;
            }
        }
        return null;
    }

    //is point belongs to line segment
    public boolean pointBelongs(LineSegment seg, Point p) {
        double minx, maxx, miny, maxy;
        if (seg.c.getX() > seg.d.getX()) {
            minx = seg.d.getX();
            maxx = seg.c.getX();
        } else {
            minx = seg.c.getX();
            maxx = seg.d.getX();
        }
        if (seg.c.getY() > seg.d.getY()) {
            maxy = seg.c.getY();
            miny = seg.d.getY();
        } else {
            maxy = seg.d.getY();
            miny = seg.c.getY();
        }
        if ((p.getX()<=maxx && p.getX()>=minx) && (p.getY()<=maxy && p.getY()>=miny)) return true;
        else return false;
    }

    public double length() {
        return sqrt(pow(d.getX()-c.getX(), 2) + pow(d.getY() - c.getY(), 2));
    }

}
