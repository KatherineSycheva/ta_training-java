package com.epam.training.ekaterina_sycheva.java_basics.gradually_decreasing_carousel;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{

    int prev_value;

    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
        prev_value = 1;
    }

    @Override
    public int toDo() {
        int next_val = 0;
        while (true) {
            if (car[k] > 0) {
                next_val = car[k];
                if (prev_value > car[k]) {
                    car[k] = 0;
                } else {
                    car[k] -= prev_value;
                }
                if (k != car.length - 1) {
                    k++;
                } else {
                    k = 0;
                    prev_value++;
                }
                break;
            } else if (car[k] == 0) {
                if (k < car.length - 1) {
                    k++;
                } else {
                    k = 0;
                    prev_value++;
                }
            } else if (car[k] < 0) {
                car[k] = 0;
                if (k < car.length - 1) {
                    k++;
                } else {
                    k = 0;
                }
                if (isFinished()) break;
            }
        }
        return next_val;
    }


}
