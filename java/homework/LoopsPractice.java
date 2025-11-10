package homework;

/*
Практика по теме: Циклы (while, do-while, for, for-each)
*/

public class LoopsPractice {

    public static void main(String[] args) {

        practice1();

        practice2();

        forEachExample();
    }

    /*
     Практика #1
     Примеры бесконечных циклов для while и do-while.
     Чтобы не зациклить программу, добавлен выход через break.
     */
    public static void practice1() {
        System.out.println("=== Практика #1 ===");

        // Бесконечный цикл while
        int count1 = 0;
        while (true) {
            System.out.println("Бесконечный while: итерация " + count1);
            count1++;
            if (count1 >= 3) break; // выход из цикла
        }

        System.out.println();

        // Бесконечный цикл do-while
        int count2 = 0;
        do {
            System.out.println("Бесконечный do-while: итерация " + count2);
            count2++;
            if (count2 >= 3) break; // выход из цикла
        } while (true);

        System.out.println();
    }

    /*
     Практика #2
     Пример использования операторов break и continue.
     Цикл for выводит только нечётные числа и завершает работу при достижении 10.
     */
    public static void practice2() {
        System.out.println("=== Практика #2 ===");

        for (int i = 1; i <= 15; i++) {

            // Пропускаем чётные числа
            if (i % 2 == 0) continue;

            System.out.println("Текущее значение i: " + i);

            // Завершаем цикл, когда i достигает 11
            if (i == 11) {
                System.out.println("Достигнуто значение 11 — прерывание цикла");
                break;
            }
        }

        System.out.println();
    }

    /*
     Пример цикла for-each для массива.
     Проходим по всем элементам без индексов.
     */
    public static void forEachExample() {
        System.out.println("=== Пример for-each ===");

        int[] numbers = {1, 3, 5, 7, 9};

        for (int n : numbers) {
            System.out.println("Элемент массива: " + n);
        }

        System.out.println("Изменить элемент внутри такого цикла нельзя — только читать значения.");
        System.out.println();
    }
}
