package com.solutions;

//1) There are 16 hourglasses in arr. An hourglass sum is the sum of an hourglass' values.
// Calculate the hourglass sum for every hourglass in arr,
// then print the maximum hourglass sum. The array will always be 6X6.

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//2) Rotate an array n times
public class TwoDArray {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 0, 0, 0},
                {0, 7, 0, 0, 0, 0},
                {4, 5, 6, 0, 0, 0},
                {0, 7, 0, 4, -1, 4},
                {0, 7, 0, 0, 3, 0},
                {0, 7, 0, 5, 3, 1}};

        int val = -9999;
        int[][] res = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        for (int i = 1; i < 5; i++)
            for (int j = 1; j < 5; j++) {
                int x = mat[i - 1][j - 1] + mat[i - 1][j] + mat[i - 1][j + 1] +
                        mat[i][j] +
                        mat[i + 1][j - 1] + mat[i + 1][j] + mat[i + 1][j + 1];
                if (x > val) {
                    val = x;
                    res = new int[][]{{mat[i - 1][j - 1], mat[i - 1][j], mat[i - 1][j + 1]},
                            {0, mat[i][j], 0},
                            {mat[i + 1][j - 1], mat[i + 1][j], mat[i + 1][j + 1]}};
                }
            }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(res[i][j] + " ");
            }

            System.out.println("");

        }

        System.out.println("The sum is "+ val);

        // rotate an array
        int arr[] = {4,5,6,7,8,9};
        int d= 6;

        for (int i = 0, j=d-1; i < j; i++, j--) {
            int temp =arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        for (int i = d, j=arr.length-1; i < j; i++, j--) {
            int temp =arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        for (int i = 0, j=arr.length-1; i < j; i++, j--) {
            int temp =arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        System.out.println(Arrays.toString(arr));

    }


}