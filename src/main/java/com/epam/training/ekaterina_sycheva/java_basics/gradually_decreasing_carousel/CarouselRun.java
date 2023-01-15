package com.epam.training.ekaterina_sycheva.java_basics.gradually_decreasing_carousel;


public class CarouselRun {
    DecrementingCarousel obj;

    public CarouselRun(DecrementingCarousel obj) {
        this.obj = obj;
    }

    /*
    int next() – call the function next according class
    */
    public int next() {
        return obj.next();
    }
    /*
    boolean isFinished() - when the end of carousel true, else false
     */
    public boolean isFinished() {
        return obj.isFinished();
    }

}
