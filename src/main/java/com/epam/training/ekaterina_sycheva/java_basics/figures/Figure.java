package com.epam.training.ekaterina_sycheva.java_basics.figures;

abstract class Figure{

    /**
     * Returns the area of the figure according to its type
     * @return the area of the figure.
     */
    public abstract double area();

    /**
     * Returns a String value in specific format:
     * @return a String value in specific format
     */
    public abstract String pointsToString();

    /**
     * Returns a String value in specific formats:
     * Triangle[(a.x,a.y)(b.x,b.y)(c.x,c.y)];
     * Quadrilateral[(a.x,a.y)(b.x,b.y)(c.x,c.y)(d.x, d.y)];
     * Circle[(center.x,center.y)radius]
     * @return a String value in specific format
     */
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    /**
     * Returns a leftmost point of the figure: the one having the least X coordinate.
     * If there are many leftmost points, return any of them.
     * @return a leftmost point of the figure
     */
    public abstract Point leftmostPoint();

    /*
    * Return a distance between to points
    * @return a distance between to points, a double value
    */
    public double length(Point a, Point b) {
        return Math.sqrt(Math.pow((b.getX() - a.getX()),2) + Math.pow((b.getY() - a.getY()),2));
    }

}
