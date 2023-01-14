package com.epam.training.ekaterina_sycheva.java_basics.halving_carousel;

public class HalvingCarousel extends DecrementingCarousel {
    private int i = 0;


    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public int next() {
        int m;
        if (isFinished()) {
            m = -1;
        } else {
            while (true) {
                if (car[i] != 0) {
                    m = car[i];
                    car[i] /= 2;
                    if (i != car.length - 1) {
                        i++;
                    } else {
                        i = 0;
                    }
                    break;
                } else if (car[i] == 0) {
                    if (i < car.length - 1) {
                        i++;
                    } else {
                        i = 0;
                    }
                }
            }
        }
        return m;
    }

}
