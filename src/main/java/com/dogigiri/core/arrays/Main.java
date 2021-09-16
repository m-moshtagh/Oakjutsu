package com.dogigiri.core.arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {54, 2, 32, 0, 5};
        for (int a : array) System.out.println(a);

        //Two dimensional arrays are used whenever we need Matrix operations.
        int[][] twoDimensionArray = {{1, 6, 7}, {9, 4, 7}, {6, 3, 7}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(twoDimensionArray[i][j] + " ");
            }
            System.out.println();
        }

        //Three dimensional arrays represent something like a Cube.
        int[][][] threeDimensionalArray = {{{1, 2, 3}, {56, 9, 4}}, {{5, 4, 77}, {9, 2, -12}}};
        System.out.println(threeDimensionalArray[1][1][2]);
    }
}
