package com.epam.training.ekaterina_sycheva.java_basics.matrix_transposition;

import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {

        //Put your code here
        int rows = matrix[0].length;
        int cols = matrix.length;
        int [][] t_matrix = new int [rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                t_matrix[i][j] = matrix[j][i];
            }

        return t_matrix;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");
        // Get a result of your code
        int[][] matrix = {
                {1, 2},
                {7, -13} };

        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }

}
