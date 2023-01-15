package com.epam.training.ekaterina_sycheva.java_basics.figures;

class Point {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")";
    }

}
