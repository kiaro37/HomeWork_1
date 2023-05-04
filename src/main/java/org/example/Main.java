package org.example;

import java.io.File;
import java.sql.SQLOutput;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.util.Collections.list;


public class Main {
    public static void main(String[] args) {
        //ex1();
        //ex2();
        //ex3();
        //ex4();
        //ex5();
        //ex2_1();
        //ex2_2();
        //ex3_1();
        //ex3_2();
        ex4_1();
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
                System.out.print(" " + arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void ex4() {
        //4. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
        //"Доброе утро, <Имя>!", если время от 05:00 до 11:59
        //"Добрый день, <Имя>!", если время от 12:00 до 17:59;
        //"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
        //"Доброй ночи, <Имя>!", если время от 23:00 до 4:59
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Введите ваше имя: ");
        String name = myScanner.nextLine();
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
        String timeNow = time.format(formatter);
        int now = Integer.parseInt(timeNow);
        if (now >= 5 && now < 12) {
            System.out.println("Доброе утро," + name);
        }
        if (now >= 12 && now < 18) {
            System.out.println("Добрый день," + name);
        }
        if (now >= 18 && now < 23) {
            System.out.println("Добрый вечер," + name);
        }
        if (now >= 23 || now < 5) {
            System.out.println("Доброй ночи," + name);
        }
    }

    private static void ex5() {
        //5.** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        //или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются
        //циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        //Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
        //[ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        //При каком n в какую сторону сдвиг можете выбирать сами.
        int[] arr = new int[]{7, 4, 6, 9, 2};
        int n = 3;
        int length = arr.length;
        int[] newArr = new int[length];
        System.arraycopy(arr, n, newArr, 0, length - n);
        System.arraycopy(arr, 0, newArr, length - n, n);
        System.out.println(Arrays.toString(newArr));
    }

    private static void ex2_1() {
        /**
         1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя
         StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
         Если значение null, то параметр не должен попадать в запрос.
         Пример 1:
         Параметры для фильтрации: {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"}
         Результат: SELECT * FROM USER WHERE name = 'Ivanov' and country = 'Russia' and city = 'Moscow';

         Пример 2:
         Параметры для фильтрации: {"name:null", "country:null", "city:null", "age:null"}
         Результат: SELECT * FROM USER;
         */
        String jsonFilter = "\"name:Ivanov\" \"country:Russia\" \"city:Moscow\" \"age:null\"";
        String[] parsejsonFilter = jsonFilter.split("\"?\\s+\"?|:\"?");
        System.out.println(Arrays.toString(parsejsonFilter));
        StringBuilder filterSb = new StringBuilder("select * from students where ");

        for (int i = 0; i < parsejsonFilter.length - 1; i += 2) {
            if (i + 1 < parsejsonFilter.length) {
                String key = parsejsonFilter[i];
                String value = parsejsonFilter[i + 1];
                if (!value.equals("null\"") && !value.equals("null")) {
                    if (filterSb.length() > 0) {
                        filterSb.append(" and ");
                    }
                    filterSb.append(key).append(" = '").append(value).append("'");
                }
            }
        }
        String filter = filterSb.toString();
        System.out.println(filter);
    }

    private static void ex2_2() {
        /**
         2.Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида:
         1 Расширение файла: txt
         2 Расширение файла: pdf
         3 Расширение файла:
         4 Расширение файла: jpg
         */

        File expansion = new File("G:\\Мой диск\\Study_Develop\\Java\\expansions");
        for (File item : expansion.listFiles()) {
            if (item.isDirectory()) {
                System.out.println(item.getName() + "\t folder");
            } else {
                String fileName = item.getName();
                if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
                    System.out.println(item.getName() + "\t" + "Расширение файла: " +
                            fileName.substring(fileName.lastIndexOf(".") + 1));
                }
            }
        }

    }

    private static void ex3_1() {
        /**
         1. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа.
         Пройти по списку, найти и удалить целые числа.
         Пример: {"Яблоко", "11", "13", "Апельсин", "Дыня", "17"} -> {"Яблоко", "Апельсин", "Дыня"}
         */

        ArrayList<String> list = new ArrayList<>();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Введите длину массива строк: ");
        int len = myScanner.nextInt();
        for (int i = 0; i < len; i++) {
            Scanner myScan = new Scanner(System.in);
            System.out.println("Введите строку: ");
            String string = myScan.nextLine();
            list.add(String.valueOf(string));
        }
        System.out.println(list);
        list.removeIf(s -> s.matches("\\d+"));
        System.out.println(list);
    }

    private static void ex3_2() {
        /**
         2. Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
         что на 0й позиции каждого внутреннего списка содержится название жанра,
         а на остальных позициях - названия книг. Напишите метод для заполнения данной структуры(можно через консоль).
         Пример:
         "Классика", "Преступление и наказание", "Война и мир", "Анна Каренина".
         "Научная фантастика", "Солярис", "Ночной дозор", "Братья Стругацкие".
         "Детектив", "Десять негритят".
         "Фантастика", "Хроники Нарнии", "Гарри Поттер и философский камень", "Грозовой перевал".
         */

        List<ArrayList<String>> catalog = new ArrayList<>();
        Scanner genreNums = new Scanner(System.in);
        System.out.println("Введите количество жанров: ");
        int genre = genreNums.nextInt();
        for (int i = 0; i < genre; i++) {
            ArrayList<String> booksOfCatalog = new ArrayList<>();
            Scanner genreName = new Scanner(System.in);
            System.out.println("Введите жанр: ");
            String name = genreName.nextLine();
            Scanner bookNums = new Scanner(System.in);
            System.out.println("Введите количество книг в жанре: ");
            int books = bookNums.nextInt();
            booksOfCatalog.add(name);
            for (int j = 0; j < books; j++) {
                Scanner bookName = new Scanner(System.in);
                System.out.println("Введите название книги: ");
                String book = bookName.nextLine();
                booksOfCatalog.add(book);
            }
            catalog.add(booksOfCatalog);
        }
        for (ArrayList<String> item : catalog
        ) {
            System.out.println(item);
        }
    }

    private static void ex4_1() {
        /**
         1. Реализовать консольное приложение, которое:
         Принимает от пользователя и “запоминает” строки.
         Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
         Если введено revert, удаляет предыдущую введенную строку из памяти.
         */
        List<String> ArrayList = new ArrayList<>();
        Scanner myScan = new Scanner(System.in);
        System.out.println("Введите количество строк: ");
        int stringNum = myScan.nextInt();
        for (int i = 0; i < stringNum; i++) {
            Scanner stringScan = new Scanner(System.in);
            System.out.println("Введите строку: ");
            String string = stringScan.nextLine();
            if (string.equals("revert")) {
                ArrayList.remove(0);
            } else if (string.equals("print")) {
                for (String item : ArrayList
                ) {
                    System.out.printf(item + ",");
                }
                break;
            } else ArrayList.add(0, string);
        }
        for (String item : ArrayList
        ) {
            System.out.printf(item + ", ");
        }
    }
}