package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //ex1();
        //ex2();
        ex3();
    }

    private static void ex1() {
        //1. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный
        //массив типа int длиной len, каждая ячейка которого равна initialValue;
        int len = 5;
        int initialValue = 3;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void ex2() {
        //2. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
        int[] arr = new int[]{2, 4, 1, 0, 5, 7, 9, 12};
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int i = 0; i <= arr.length - 1; i++
        ) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        for (int i = 0; i <= arr.length - 1; i++
        ) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        System.out.printf("Максимальное значение = %s\n", maxValue);
        System.out.printf("Минимальное значение = %s", minValue);
    }

    private static void ex3() {
        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
        // если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких
        //элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
        int value = 1;
        int rows = 4;
        int columns = 4;
        int arr[][] = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j) {
                    arr[i][j] = value;
                }
                System.out.print(" " +arr[i][j]+ " ");
            }
            System.out.println();
        }
    }
}