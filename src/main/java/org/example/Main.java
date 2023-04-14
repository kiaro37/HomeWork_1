package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ex1();
        //ex2();
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
}