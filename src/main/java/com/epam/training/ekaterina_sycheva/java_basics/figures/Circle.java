package com.epam.training.ekaterina_sycheva.java_basics.figures;

import static  java.lang.Math.PI;

class Circle extends Figure {
    Point center;
    double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI*radius*radius;
    }

    @Override
    public String pointsToString() {
        return center.toString();
    }

    @Override
    public String toString() {
            return this.getClass().getSimpleName() + "[" + pointsToString() + radius + "]";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(center.getX() - radius, center.getY());
    }
}


