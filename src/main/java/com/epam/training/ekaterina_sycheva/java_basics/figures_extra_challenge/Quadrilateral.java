package com.epam.training.ekaterina_sycheva.java_basics.figures_extra_challenge;

import static java.lang.Math.abs;

class Quadrilateral extends Figure {
    Point a;
    Point b;
    Point c;
    Point d;

    public Quadrilateral (Point a, Point b, Point c, Point d) {
        //abc, bcd, acd, abd
        Triangle t1 = new Triangle(a, b, c);
        Triangle t2 = new Triangle(b, c, d);
        Triangle t3 = new Triangle(a, c, d);
        Triangle t4 = new Triangle(a, b, d);
        //degenerative test
        if (t1.area() != 0 && t2.area() != 0 && t3.area() != 0 && t4.area() != 0){
            LineSegment ab = new LineSegment(a, b);
            LineSegment bc = new LineSegment(b, c);
            LineSegment cd = new LineSegment(c, d);
            LineSegment ad = new LineSegment(a, d);
            //convex test
            if (abs(t1.area()+t3.area()-t2.area()-t4.area()) > 0.01) {
                throw new IllegalArgumentException("Quadrilateral cannot be nonconvex");
            } else {
                //plain test
                    if (ab.pointCross(cd) == null && bc.pointCross(ad) == null) {
                    this.a = a;
                    this.b = b;
                    this.c = c;
                    this.d = d;
                } else throw new IllegalArgumentException("Quadrilateral cannot be self-intersecting");
            }
        } else throw new IllegalArgumentException("Quadrilateral cannot be degenerative");

    }

    @Override
    public Point centroid() {
        Point c_abc = new Triangle(a, b, c).centroid();
        Point c_bcd = new Triangle(b, c, d).centroid();
        Point c_acd = new Triangle(a, c, d).centroid();
        Point c_abd = new Triangle(a, b, d).centroid();
        LineSegment seg1 = new LineSegment(c_abc, c_acd);
        LineSegment seg2 = new LineSegment(c_bcd, c_abd);
        return seg1.pointCross(seg2);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        boolean hasA, hasB, hasC, hasD;
        if (this.getClass() == figure.getClass()) {
            hasA = ((Quadrilateral) figure).hasVertex(this.a);
            hasB = ((Quadrilateral) figure).hasVertex(this.b);
            hasC = ((Quadrilateral) figure).hasVertex(this.c);
            hasD = ((Quadrilateral) figure).hasVertex(this.d);
            if (hasA && hasB && hasC && hasD) {
                return true;
            }
        }
        return false;
    }

    private boolean hasVertex(Point p) {
        if ((abs(p.getX()-a.getX()) < 0.001 && abs(p.getY()-a.getY()) < 0.001)
                || (abs(p.getX()-b.getX()) < 0.0001 && abs(p.getY()-b.getY()) < 0.001)
                || (abs(p.getX()-c.getX()) < 0.0001 && abs(p.getY()-c.getY()) < 0.001)
                || (abs(p.getX()-d.getX()) < 0.0001 && abs(p.getY()-d.getY()) < 0.001)) {
            return true;
        }
        return false;
    }

}
