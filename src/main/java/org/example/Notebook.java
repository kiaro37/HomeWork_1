package org.example;
/*
Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объём ЖД
3 - Операционная система
4 - Цвет …

Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */

import java.util.*;

public class Notebook {


    public static void main(String[] args) {

        Assortment asus = new Assortment("Asus", 16, 512, "windows", "blue");
        Assortment dell = new Assortment("Dell", 12, 256, "no", "black");
        Assortment acer = new Assortment("Acer", 8, 128, "linux", "red");

        Set<Assortment> notebooks = new HashSet<>();
        notebooks.add(asus);
        notebooks.add(dell);
        notebooks.add(acer);

        for (Assortment value : notebooks
        ) {
            System.out.println(value);
        }

        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                "1 - ОЗУ\n" +
                "2 - Объём ЖД\n" +
                "3 - Операционная система\n" +
                "4 - Цвет");


        int num = scanner.nextInt();

        if (num == 1) {
            System.out.println("Введите минимальное значение критерия:");
            int choice = scanner.nextInt();
            for (Assortment value : notebooks
            ) {
                if (value.ram >= choice) {
                    System.out.println(value);
                }
            }
        } else if (num == 2) {
            System.out.println("Введите минимальное значение критерия:");
            int choice = scanner.nextInt();
            for (Assortment value : notebooks
            ) {
                if (value.hdd >= choice) {
                    System.out.println(value);
                }
            }
        } else if (num == 3) {
            System.out.println("Введите минимальное значение критерия:");
            String choice = scanner.next();
            for (Assortment value : notebooks
            ) {
                if (value.os.equals(choice)) {
                    System.out.println(value);
                }
            }
        } else if (num == 4) {
            System.out.println("Введите минимальное значение критерия:");
            String choice = scanner.next();
            for (Assortment value : notebooks
            ) {
                if (value.color.equals(choice)) {
                    System.out.println(value);
                }
            }
        } else System.out.println("Такого критерия нет");
    }
}
