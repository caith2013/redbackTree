package com.optimum;

public class MatrixRotate90 {

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];

        // transpose + reverse rows
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                result[c][n - 1 - r] = matrix[r][c];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] rotated = rotate(m);

        for (int[] row : rotated) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }
    }
}
