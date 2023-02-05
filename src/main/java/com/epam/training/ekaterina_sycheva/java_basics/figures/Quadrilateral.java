package com.epam.training.ekaterina_sycheva.java_basics.figures;

class Quadrilateral extends Figure{
    Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        Triangle t1 = new Triangle(a, d, c);
        Triangle t2 = new Triangle(d, c, b);
        Triangle t3 = new Triangle(a, b, c);
        Triangle t4 = new Triangle(a, d, b);
        if (t1.area() + t2.area() == t3.area() + t4.area()) {
            return t1.area() + t2.area();
        } else if (t1.area() + t3.area() == t2.area() + t4.area()) {
            return  t1.area() + t3.area();
        } else if (t1.area() + t4.area() == t2.area() + t3.area()) {
            return t1.area() + t4.area();
        } else {
            return t2.area() + t4.area();
        }
    }

    /**
     * @return a String in format: <code>(a.x,a.y)(b.x,b.y)(c.x,c.y)(d.x, d.y)</code>
     * Example: <code>(0.0,0.0)(0.0,7.1)(7.0,7.0)(7.0,0.0)</code>
     */
    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString() + d.toString();
    }

    @Override
    public Point leftmostPoint() {
        if (a.getX() <= b.getX() && a.getX() <= c.getX() && a.getX() <= d.getX()) {
            return a;
        } else if (b.getX() <= a.getX() && b.getX() <= c.getX() && b.getX() <= d.getX()) {
            return b;
        } else if (c.getX() <= a.getX() && c.getX() <= b.getX() && c.getX() <= d.getX()) {
            return c;
        } else {
            return d;
        }
    }
}
