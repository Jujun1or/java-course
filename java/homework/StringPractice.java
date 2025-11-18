package homework;

/*
Практика по теме: String, StringJoiner, текстовые блоки (""" ... """)
*/

import java.util.StringJoiner;

public class StringPractice {

    public static void main(String[] args) {

        System.out.println("=== Практика #1: методы String ===");
        demoStringMethods();

        System.out.println("\n=== Практика #2: StringJoiner ===");
        demoStringJoiner();

        System.out.println("\n=== Практика #3: тройные кавычки ===");
        explainTextBlocks();
    }


    /*
     Практика #1
     Демонстрация 10 методов класса String.
    */
    public static void demoStringMethods() {

        String s = "  Java Programming  ";

        // 1. length(): возвращает длину строки
        System.out.println("length(): " + s.length());

        // 2. trim(): обрезает пробелы по краям
        System.out.println("trim(): [" + s.trim() + "]");

        // 3. toLowerCase(): преобразует к нижнему регистру
        System.out.println("toLowerCase(): " + s.toLowerCase());

        // 4. toUpperCase(): преобразует к верхнему регистру
        System.out.println("toUpperCase(): " + s.toUpperCase());

        // 5. charAt(int): возвращает символ по индексу
        System.out.println("charAt(2): " + s.charAt(2));

        // 6. substring(): возвращает подстроку
        System.out.println("substring(2, 6): " + s.substring(2, 6));

        // 7. contains(): проверяет наличие подстроки
        System.out.println("contains(\"Java\"): " + s.contains("Java"));

        // 8. startsWith(): проверяет начало строки
        System.out.println("startsWith(\"  Ja\"): " + s.startsWith("  Ja"));

        // 9. replace(): заменяет символы или подстроки
        System.out.println("replace(\"Java\", \"Kava\"): " + s.replace("Java", "Kava"));

        // 10. split(): разбивает строку на массив по регулярному выражению
        String[] arr = s.split(" ");
        System.out.println("split(\" \"):");
        for (String part : arr) {
            System.out.println("[" + part + "]");
        }
    }


    /*
     Практика #2
     Пример использования StringJoiner.
     StringJoiner позволяет собирать строки с разделителем, префиксом и суффиксом.
    */
    public static void demoStringJoiner() {

        // Создаём StringJoiner с разделителем ", "
        StringJoiner joiner = new StringJoiner(", ");

        joiner.add("Рома");
        joiner.add("Дарья");
        joiner.add("Java");

        System.out.println("StringJoiner без префикса/суффикса: " + joiner.toString());

        // Создание joiner с префиксом и суффиксом
        StringJoiner joiner2 = new StringJoiner(" | ", "[", "]");

        joiner2.add("one");
        joiner2.add("two");
        joiner2.add("three");

        System.out.println("StringJoiner с префиксом и суффиксом: " + joiner2.toString());
    }


    /*
     Практика #3
     Объяснение тройных кавычек (""" … """).

     В Java начиная с версии 15 появились *текстовые блоки*.
     Это удобный способ записывать многострочные строки.
     Они упрощают:
     - создание длинных SQL запросов
     - HTML-шаблоны
     - JSON строки
     - форматирование без экранирования множества символов

     Тройные кавычки позволяют писать строку "как есть",
     включая переносы строк и пробелы.
    */
    public static void explainTextBlocks() {

        String text = """
                Это пример текстового блока.
                Можно писать много строк,
                не экранируя кавычки и специальные символы.
                Удобно для JSON, SQL и HTML.
                """;

        System.out.println(text);
    }
}
