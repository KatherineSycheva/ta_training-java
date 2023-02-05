package com.epam.training.ekaterina_sycheva.java_basics.figures;

import java.lang.Math;

class Triangle extends Figure {
    Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        return 0.5 * Math.abs((b.getX() - a.getX())*(c.getY()-a.getY()) - (c.getX()-a.getX())*(b.getY()-a.getY()));
    }

    /**
     * @return a String value in format: <code>(a.x,a.y)(b.x,b.y)(c.x,c.y)</code>
     * Example: <code>(0.0,0.0)(0.1,5.8)(7.0,7.0)</code>
     */
    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point p = a;
        if (p.getX() > b.getX()) {
            p = b;
        }
        if (p.getX() > c.getX()) {
            p = c;
        }
        return p;
    }

}
