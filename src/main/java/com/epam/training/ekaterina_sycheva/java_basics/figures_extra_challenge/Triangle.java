package com.epam.training.ekaterina_sycheva.java_basics.figures_extra_challenge;

import static java.lang.Math.abs;

class Triangle extends Figure{
    public final Point a;
    public final Point b;
    public final Point c;

    public Triangle (Point a, Point b, Point c) {
        if (a != null && b != null && c!= null) {
            double ab = new LineSegment(a, b).length();
            double bc = new LineSegment(b, c).length();
            double ac = new LineSegment(a, c).length();
            if (ab+bc-ac > 0.001 && ab+ac-bc > 0.001 && ac+bc-ab > 0.001) {
                this.a = a;
                this.b = b;
                this.c = c;
            } else throw new IllegalArgumentException("Figure cannot be degenerative");
        } else {
            throw new IllegalArgumentException("Figure cannot be degenerative");
        }
    }

    public double area() {
        return 0.5 * Math.abs((b.getX() - a.getX())*(c.getY()-a.getY()) - (c.getX()-a.getX())*(b.getY()-a.getY()));
    }

    @Override
    public Point centroid() {
        return new Point((a.getX()+b.getX()+c.getX())/3, (a.getY()+b.getY()+c.getY())/3);
    }

    public boolean isExist(Point p) {
        if (abs(p.getX()-a.getX()) < 0.001 && abs(p.getY()-a.getY()) < 0.001) {
            return true;
        }
        if (abs(p.getX()-b.getX()) < 0.001 && abs(p.getY()-b.getY()) < 0.001)  {
            return true;
        }
        if (abs(p.getX()-c.getX()) < 0.001 && abs(p.getY()-c.getY()) < 0.001)  {
            return true;
        }
        return false;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure.getClass() == this.getClass()) {
            boolean x = isExist(((Triangle) figure).a);
            boolean y = isExist(((Triangle) figure).b);
            boolean z = isExist(((Triangle) figure).c);
            if (x && y && z) {
                return true;
            } else return false;
        } else return false;
    }

}
