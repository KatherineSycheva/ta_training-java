package com.epam.training.ekaterina_sycheva.java_basics.cycle_swap;


class CycleSwap {
    /**
     * Shifts all the elements in the given array to the right by 1 position.
     * In this case, the last array element becomes first.
     * @param array
     */
    static void cycleSwap(int[] array) {
        if (array.length != 0) {
            int shift = array[array.length-1];
            System.arraycopy(array, 0, array, 1, array.length-1);
            array[0] = shift;
        }
    }

    /**
     * Shift all the elements in the given array to the right in the cycle manner by shift positions.
     * Shift value must be non-negative and not bigger than the array length.
     * @param array
     * @param shift
     */
    static void cycleSwap(int[] array, int shift) {
        if (array.length != 0) {
            int [] shiftedArray = new int [array.length-shift];
            System.arraycopy(array, 0, shiftedArray, 0, array.length-shift);
            System.arraycopy(array, array.length-shift, array, 0, shift);
            System.arraycopy(shiftedArray, 0, array, array.length-shiftedArray.length, shiftedArray.length);

        }
    }
}
