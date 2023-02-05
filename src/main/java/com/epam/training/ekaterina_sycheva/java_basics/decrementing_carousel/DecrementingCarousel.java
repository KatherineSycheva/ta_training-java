package com.epam.training.ekaterina_sycheva.java_basics.decrementing_carousel;

public class DecrementingCarousel {
    private int capacity;
    private int [] car;
    private int i = 0;
    private boolean endAdd = false;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        car = new int[capacity];
    }

    /**
     * Adds an element to carousel.
     * If element is negative or zero, does not add the element.
     * If container is full, does not add the element.
     * If the run method was called to create a CarouselRun, does not add the element.
     * If element is added successfully, returns true, otherwise false.
     * @param element
     * @return true if element added else false
     */
    public boolean addElement(int element){
        if (element > 0 && i < capacity && !endAdd) {
            car[i] = element;
            i++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a CarouselRun to iterate over the elements.
     * If the run method has already been called earlier, it returns null
     * (DecrementingCarousel may generate only one CarouselRun object).
     * @return CarouselRun
     */
    public CarouselRun run(){
        if (endAdd) {
            return null;
        } else {
            endAdd = true;
            return new CarouselRun(car, i);
        }
    }

}
