package com.epam.training.ekaterina_sycheva.java_basics.halving_carousel;

public class DecrementingCarousel {
    private final int capacity;
    protected int [] car;
    protected int i = 0, k = 0;
    protected boolean endAdd = false;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        car = new int[capacity];
    }

    public boolean addElement(int element){
        if (element > 0 && i < capacity && !endAdd) {
            car[i] = element;
            i++;
            return true;
        } else {
            return false;
        }
    }

    public int next() {
        int m;
        if (isFinished()) {
            m = -1;
        } else {
            while (true) {
                if (car[k] != 0) {
                    m = car[k];
                    car[k]--;
                    if (k != car.length - 1) {
                        k++;
                    } else {
                        k = 0;
                    }
                    break;
                } else if (car[k] == 0) {
                    if (k < car.length - 1) {
                        k++;
                    } else {
                        k = 0;
                    }
                }
            }
        }
        return m;
    }

    public boolean isFinished() {
        boolean fin = true;
        if (car == null) {
            return fin;
        } else {
            for (int j : car) {
                if (j != 0) {
                    fin = false;
                    break;
                }
            }
            return fin;
        }
    }


    public CarouselRun run(){
        if (endAdd) {
            return null;
        } else {
            endAdd = true;
            return new CarouselRun(this);
        }
    }
}
