package com.epam.training.ekaterina_sycheva.java_basics.figures_extra_challenge;

import static java.lang.Math.abs;

class Circle extends Figure {
    final Point center;
    final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        if (radius > 0 && center != null) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Figure cannot be degenerative");
        }
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure.getClass() == this.getClass()) {
            double rad = ((Circle) figure).radius;
            Point cent = ((Circle) figure).center;

            if (abs(center.getX()-cent.getX()) < 0.001
                    && abs(center.getY()-cent.getY()) < 0.001  && abs(radius-rad) < 0.001) {
                return true;
            } else return false;
        } else return false;
    }
}
