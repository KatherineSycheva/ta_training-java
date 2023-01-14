package com.epam.training.ekaterina_sycheva.java_basics.matrices_multiplication;

import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int [][] res_matrix = new int[matrix1.length][matrix2[0].length];

        // Put your code here
        if (matrix1[0].length != matrix2.length) {
            return null;
        } else {
            for (int i = 0; i < matrix1.length; i++)
                for (int j = 0; j < matrix2[0].length; j++) {
                    int sum = 0;
                    for (int k = 0; k < matrix2.length; k++) {
                        sum += matrix1[i][k] * matrix2[k][j];
                    }
                    res_matrix[i][j] = sum;
                }
            return res_matrix;
        }
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code
        int[][] a = {
                {0, 12345},
                {4509, 0},
                {3, 567} };

        int[][] b = {
                {653, 0, 25353},
                {0, 61, 6} };

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
