package com.epam.training.ekaterina_sycheva.java_basics.decrementing_carousel_with_limit;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    final int actionLimit;
    int numActions = 0;

    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }

    @Override
    public int toDo() {
        int next_val;
        if (isFinished()) {
            next_val = -1;
        } else {
            while (true) {
                if (car[k] != 0) {
                    next_val = car[k];
                    car[k]--;
                    numActions++;
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
        return next_val;
    }
    @Override
    public boolean isFinished() {
        boolean fin = true;
        if (car == null || numActions == actionLimit) {
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

}
