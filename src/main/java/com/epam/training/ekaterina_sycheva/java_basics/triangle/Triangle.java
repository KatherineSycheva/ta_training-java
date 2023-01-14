package com.epam.training.ekaterina_sycheva.java_basics.triangle;

import static java.lang.Math.*;

class Triangle {
    private Point a;
    private Point b;
    private Point c;
    private double ab;
    private double bc;
    private double ac;

    public Triangle(Point a, Point b, Point c) {
        //TODO
        double ab = sqrt(pow(b.getX()-a.getX(),2)+pow(b.getY()-a.getY(),2));
        double bc = sqrt(pow(c.getX()-b.getX(),2)+pow(c.getY()-b.getY(),2));
        double ac = sqrt(pow(c.getX()-a.getX(),2)+pow(c.getY()-a.getY(),2));
        if ((ab+bc > ac) && (bc+ac > ab) && (ab+ac > bc)) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.ab = ab;
            this.bc = bc;
            this.ac = ac;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        //TODO
        //Geron's formula
        return 0.25*sqrt((ab+bc+ac)*(bc+ac-ab)*(ab+ac-bc)*(ab+bc-ac));
    }

    public Point centroid(){
        //TODO
        double xc = (a.getX()+b.getX()+c.getX())/3;
        double yc = (a.getY()+b.getY()+c.getY())/3;
        System.out.println(xc);
        System.out.println(yc);
        return new Point(xc, yc);
    }

}
