package com.epam.training.ekaterina_sycheva.java_basics.spiral;

import java.util.Arrays;

class Spiral {
        static int[][] spiral(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        int val = 1;
        int right_i = 0;
        int down_j = matrix[0].length - 1;
        int left_i = matrix.length - 1;
        int up_j = 0;
        int flag = 0;

        while (flag != -1) {
            if (rows == 1 && columns == 1) {
                matrix[0][0] = 1;
            }
            //right
            for (int j = 0; j < matrix[right_i].length; j++) {
                if (matrix[right_i][j] == 0) {
                    matrix[right_i][j] = val;
                    val++;
                }
            }
            right_i++;
            //down
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][down_j] == 0) {
                    matrix[i][down_j] = val;
                    val++;
                }
            }
            down_j--;
            //left
            for (int j = matrix[left_i].length - 1; j >= 0; j--) {
                if (matrix[left_i][j] == 0) {
                    matrix[left_i][j] = val;
                    val++;
                }
            }
            left_i--;
            //up
            for (int i = matrix.length-1; i >= 0; i--) {
                if (matrix[i][up_j] == 0) {
                    matrix[i][up_j] = val;
                    val++;
                }
            }
            up_j++;

            for (int i = 0; i < matrix.length; i++) {
                if (Arrays.binarySearch(matrix[i], 0) != -1) {
                    flag = i;
                    break;
                } else {
                    flag = -1;
                }
            }
        }


        return matrix;
    }
}

