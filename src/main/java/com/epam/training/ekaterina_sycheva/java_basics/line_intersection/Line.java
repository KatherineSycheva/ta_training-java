package com.epam.training.ekaterina_sycheva.java_basics.line_intersection;

public class Line {
    public int k;
    public int b;
    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        if (other.k == this.k) {
            return null;
        } else {
            int x = (other.b - this.b) / (this.k - other.k);
            int y = this.k * x + this.b;
            return new Point(x, y);
        }
    }

}
