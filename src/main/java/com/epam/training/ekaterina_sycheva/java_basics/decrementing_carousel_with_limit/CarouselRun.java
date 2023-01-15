package com.epam.training.ekaterina_sycheva.java_basics.decrementing_carousel_with_limit;

public class CarouselRun {
    DecrementingCarousel obj;

    public CarouselRun(DecrementingCarousel obj) {
        this.obj = obj;
    }

    /*
    int next() – call the function next according class
    */
    public int next() {
        return obj.toDo();
    }
    /*
    boolean isFinished() - when the end of carousel true, else false
     */
    public boolean isFinished() {
        return obj.isFinished();
    }

}


