package com.epam.training.ekaterina_sycheva.java_basics.decrementing_carousel;

public class CarouselRun {
    private int[] karusel;
    private int i = 0;

    public CarouselRun(int[] k, int s) {
        karusel = new int[s];
        if (k != null) {
            System.arraycopy(k, 0, karusel, 0, s);
        }
    }

    /**
     * Returns the current value of the current element,
     * then decreases the current element by one and switches to the next element in insertion order.
     * Skips zero elements. When there is no more elements to decrease, returns -1.
     * @return current value
     */
    public int next() {
        int m;
        if (isFinished()) {
            m = -1;
        } else {
            while (true) {
                if (karusel[i] != 0) {
                    m = karusel[i];
                    karusel[i]--;
                    if (i != karusel.length - 1) {
                        i++;
                    } else {
                        i = 0;
                    }
                    break;
                } else if (karusel[i] == 0) {
                    if (i < karusel.length - 1) {
                        i++;
                    } else {
                        i = 0;
                    }
                }
            }
        }
        return m;
    }

    /**
     * When there is no more elements to decrease, returns true. Otherwise, returns false.
     */
    public boolean isFinished() {
        boolean fin = true;
        if (karusel == null) {
            return fin;
        } else {
            for (int j : karusel) {
                if (j != 0) {
                    fin = false;
                    break;
                }
            }
            return fin;
        }
    }

}
