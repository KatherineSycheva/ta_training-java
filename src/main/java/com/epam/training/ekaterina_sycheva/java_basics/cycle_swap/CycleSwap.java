package com.epam.training.ekaterina_sycheva.java_basics.cycle_swap;


class CycleSwap {
    static void cycleSwap(int[] array) {
        try {
            int shift = array[array.length-1];
            System.arraycopy(array, 0, array, 1, array.length-1);
            array[0] = shift;
        } catch (ArrayIndexOutOfBoundsException | NegativeArraySizeException e) {}
    }

    static void cycleSwap(int[] array, int shift) {
        try {
            int [] shiftedArray = new int [array.length-shift];
            System.arraycopy(array, 0, shiftedArray, 0, array.length-shift);
            System.arraycopy(array, array.length-shift, array, 0, shift);
            System.arraycopy(shiftedArray, 0, array, array.length-shiftedArray.length, shiftedArray.length);

        } catch (ArrayIndexOutOfBoundsException | NegativeArraySizeException e) {
        }
    }
}
