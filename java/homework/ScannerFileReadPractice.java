package homework;

/*
Практика по теме: Чтение данных из файла с помощью java.util.Scanner
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileReadPractice {

    public static void main(String[] args) {

        // Создаём файл для примера (обычно файл уже существует заранее)
        File file = new File("scanner_input.txt");

        try {
            java.io.FileWriter fw = new java.io.FileWriter(file);
            fw.write("42\n");
            fw.write("Hello\n");
            fw.write("100 200 300\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Ошибка при создании тестового файла: " + e);
        }

        System.out.println("=== Чтение файла с помощью Scanner ===");

        // Чтение данных
        try (Scanner scanner = new Scanner(file)) {

            // nextInt(): читает целое число
            int n1 = scanner.nextInt();
            System.out.println("Первое число: " + n1);

            // next(): читает слово (строка до пробела/переноса)
            String word = scanner.next();
            System.out.println("Строка: " + word);

            // Читаем три числа подряд
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            System.out.println("Три числа: " + a + ", " + b + ", " + c);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e);
        }
    }
}
