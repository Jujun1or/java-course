package homework;

/*
Практика по теме: java.util.Formatter
*/

import java.util.Date;
import java.util.Formatter;

public class FormatterPractice {

    public static void main(String[] args) {

        System.out.println("=== Практика #1: Пять спецификаторов из первой таблицы ===");
        demoBasicFormatters();

        System.out.println("\n=== Практика #2: объяснение flush() ===");
        explainFlush();

        System.out.println("\n=== Практика #3: Пять спецификаторов даты и времени ===");
        demoDateTimeFormatters();
    }


    /*
     Практика #1
     Демонстрация пяти спецификаторов:

     %b — логическое значение
     %c — символ
     %d — целое число
     %f — число с плавающей точкой
     %s — строка
    */
    public static void demoBasicFormatters() {

        try (Formatter f = new Formatter()) {

            f.format("Логическое значение: %b%n", true);        // %b
            f.format("Символ: %c%n", 'A');                      // %c
            f.format("Десятичное целое: %d%n", 123);            // %d
            f.format("Плавающая точка: %.2f%n", 3.14159);       // %f
            f.format("Строка: %s%n", "Рома");                   // %s

            System.out.println(f.toString());
        }
    }


    /*
     Практика #2
     Объяснение назначения flush()

     flush() используется для принудительного сброса внутреннего буфера
     Formatter в поток вывода.

     Он нужен:

     - когда Formatter работает поверх OutputStream или Writer,
     - чтобы данные гарантированно оказались в файле или сети даже до закрытия потока,
     - особенно важно при работе с сетевыми соединениями, логированием, файлами.

     В случае использования Formatter со строкой (StringBuilder в этом примере)
     flush() не нужен, потому что буфер является строкой, а не внешним потоком.
    */
    public static void explainFlush() {
        System.out.println("Метод flush() сбрасывает буфер Formatter в поток (файл, сеть, Writer).");
        System.out.println("Используется только когда Formatter работает поверх внешнего потока.");
    }


    /*
     Практика #3
     Демонстрация пяти спецификаторов времени и даты:

     %tH — часы в 24-часовом формате
     %tM — минуты
     %tS — секунды
     %tY — год (4 цифры)
     %tA — полное название дня недели
    */
    public static void demoDateTimeFormatters() {

        Date now = new Date(); // текущая дата и время

        try (Formatter f = new Formatter()) {

            f.format("Часы (24-формат): %tH%n", now);  // %tH
            f.format("Минуты: %tM%n", now);           // %tM
            f.format("Секунды: %tS%n", now);          // %tS
            f.format("Год (4 цифры): %tY%n", now);    // %tY
            f.format("День недели: %tA%n", now);      // %tA

            System.out.println(f.toString());
        }
    }
}
