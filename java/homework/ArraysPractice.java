package homework;

/*
Практика по теме: Массивы и класс java.util.Arrays
*/

import java.util.Arrays;

public class ArraysPractice {

    public static void main(String[] args) {

        practice1();

        practice2();
    }

    /*
     Практика #1
     Вопрос:
     Что произойдет в результате выполнения кода:

     int a1[] = {1,2,3,4,5};
     int a2[] = {6,7,8,9,10};
     a1 = a2;

     Ответ:
     - Переменная a1 начнёт ссылаться на тот же массив, что и a2.
     - Исходный массив {1,2,3,4,5} больше не доступен через a1.
     - После присваивания оба имени (a1 и a2) указывают на один и тот же массив {6,7,8,9,10}.
     */
    public static void practice1() {
        System.out.println("=== Практика #1 ===");

        int a1[] = {1, 2, 3, 4, 5};
        int a2[] = {6, 7, 8, 9, 10};

        System.out.println("До присваивания:");
        System.out.println("a1 = " + Arrays.toString(a1));
        System.out.println("a2 = " + Arrays.toString(a2));

        a1 = a2; // теперь и a1, и a2 указывают на один и тот же массив

        System.out.println("После присваивания a1 = a2:");
        System.out.println("a1 = " + Arrays.toString(a1));
        System.out.println("a2 = " + Arrays.toString(a2));

        // Изменим один элемент через a1 и посмотрим на a2
        a1[0] = 100;
        System.out.println("После изменения a1[0] = 100:");
        System.out.println("a1 = " + Arrays.toString(a1));
        System.out.println("a2 = " + Arrays.toString(a2));
        System.out.println("Вывод: a1 и a2 ссылаются на один и тот же массив.");
        System.out.println();
    }

    /*
     Практика #2
     Пример использования методов класса java.util.Arrays:
     - toString(...)
     - binarySearch(...)
     - equals(...)
     - compare(...)
     - sort(...)
     */
    public static void practice2() {
        System.out.println("=== Практика #2 ===");

        int[] arr = {5, 2, 9, 1, 7};

        // toString(...) — удобный вывод массива
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        // sort(...) — сортировка массива по возрастанию
        Arrays.sort(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));

        // binarySearch(...) — бинарный поиск по отсортированному массиву
        int index7 = Arrays.binarySearch(arr, 7);
        int index3 = Arrays.binarySearch(arr, 3); // элемента 3 нет

        System.out.println("Индекс элемента 7: " + index7);
        System.out.println("Результат поиска элемента 3: " + index3 + " (отрицательное значение => элемента нет)");

        // equals(...) — сравнение двух массивов по содержимому
        int[] arrCopy = {1, 2, 5, 7, 9};
        boolean eq1 = Arrays.equals(arr, arrCopy);
        boolean eq2 = Arrays.equals(arr, new int[]{1, 2, 5, 7, 9});

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("arrCopy = " + Arrays.toString(arrCopy));
        System.out.println("Arrays.equals(arr, arrCopy) = " + eq1);
        System.out.println("Arrays.equals(arr, {1,2,5,7,9}) = " + eq2);

        // compare(...) — лексикографическое сравнение массивов
        int[] arrA = {1, 2, 3};
        int[] arrB = {1, 2, 4};
        int[] arrC = {1, 2, 3};

        int cmpAB = Arrays.compare(arrA, arrB);
        int cmpBA = Arrays.compare(arrB, arrA);
        int cmpAC = Arrays.compare(arrA, arrC);

        System.out.println("Сравнение массивов через Arrays.compare:");
        System.out.println("arrA = " + Arrays.toString(arrA));
        System.out.println("arrB = " + Arrays.toString(arrB));
        System.out.println("arrC = " + Arrays.toString(arrC));
        System.out.println("Arrays.compare(arrA, arrB) = " + cmpAB);
        System.out.println("Arrays.compare(arrB, arrA) = " + cmpBA);
        System.out.println("Arrays.compare(arrA, arrC) = " + cmpAC);

        System.out.println();
    }
}
