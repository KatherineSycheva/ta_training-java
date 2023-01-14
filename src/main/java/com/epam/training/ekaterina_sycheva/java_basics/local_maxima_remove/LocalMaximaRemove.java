package com.epam.training.ekaterina_sycheva.java_basics.local_maxima_remove;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){
        int j;
        int[] arrayRemovedMax;
        arrayRemovedMax = new int[array.length];
        j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                if (array[i] <= array[i+1]) {
                    arrayRemovedMax[j] = array[i];
                    j++;
                }
            } else if (i == array.length - 1) {
                if (array[i] <= array[i-1]) {
                    arrayRemovedMax[j] = array[i];
                    j++;
                }
            } else if (array[i] <= array[i+1] || array[i] <= array[i-1]) {
                arrayRemovedMax[j] = array[i];
                j++;
            }
        }
        return Arrays.copyOf(arrayRemovedMax, j);
    }
}
