package com.epam.training.ekaterina_sycheva.java_basics.figures_extra_challenge;

import static java.lang.Math.*;

public class LineSegment {
    Point c;
    Point d;

    public LineSegment (Point c, Point d) {
        this.c = c;
        this.d = d;
    }

    /**
     * Returns the intersection point of this segment and @param segment
     * @param seg the segment to find the intersection with
     * @return point of intersection. If segments doesn't cross returns null
     */
    public Point pointCross(LineSegment seg) {
        double x1 = c.getX();
        double x2 = d.getX();
        double x3 = seg.c.getX();
        double x4 = seg.d.getX();
        double y1 = c.getY();
        double y2 = d.getY();
        double y3 = seg.c.getY();
        double y4 = seg.d.getY();
        //is lines crosses
        if ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4) != 0) {
            double px = ((x1*y2-y1*x2)*(x3-x4) - (x1-x2)*(x3*y4-y3*x4)) / ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
            double py = ((x1*y2-y1*x2)*(y3-y4) - (y1-y2)*(x3*y4-y3*x4)) / ((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
            Point p = new Point(px, py);
            //is segments crosses
            if (this.pointBelongs(p) && this.pointBelongs(p)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Returns True if p belongs to seg else False
     * @param p point to check
     * @return True if p belongs to seg else False
     */
    public boolean pointBelongs(Point p) {
        double minx, maxx, miny, maxy;
        if (this.c.getX() > this.d.getX()) {
            minx = this.d.getX();
            maxx = this.c.getX();
        } else {
            minx = this.c.getX();
            maxx = this.d.getX();
        }
        if (this.c.getY() > this.d.getY()) {
            maxy = this.c.getY();
            miny = this.d.getY();
        } else {
            maxy = this.d.getY();
            miny = this.c.getY();
        }
        if ((p.getX()<=maxx && p.getX()>=minx) && (p.getY()<=maxy && p.getY()>=miny)) return true;
        else return false;
    }

    /**
     * Returns the length of segment
     * @return length of segment as double value
     */
    public double length() {
        return sqrt(pow(d.getX()-c.getX(), 2) + pow(d.getY() - c.getY(), 2));
    }

}
