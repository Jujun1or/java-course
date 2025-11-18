package homework;

/*
Практика по теме: StringBuilder и StringBuffer
*/

public class StringBuilderBufferPractice {

    public static void main(String[] args) {

        System.out.println("=== Практика #1: методы StringBuilder ===");
        demoStringBuilderMethods();

        System.out.println("\n=== Практика #1: методы StringBuffer ===");
        demoStringBufferMethods();

        System.out.println("\n=== Практика #2: конвертация между String, StringBuilder, StringBuffer ===");
        demoConversions();
    }

    /*
     Практика #1
     Демонстрация 10 методов StringBuilder.
     Многие методы аналогичны StringBuffer, поэтому примеры отличаются содержанием.
    */
    public static void demoStringBuilderMethods() {

        StringBuilder sb = new StringBuilder("Java");

        // 1. append(): добавляет данные к строке
        sb.append(" Programming");
        System.out.println("append(): " + sb);

        // 2. insert(): вставка текста по индексу
        sb.insert(5, "Core ");
        System.out.println("insert(): " + sb);

        // 3. delete(): удаляет диапазон символов
        sb.delete(5, 10);
        System.out.println("delete(): " + sb);

        // 4. replace(): заменяет подстроку
        sb.replace(0, 4, "Kava");
        System.out.println("replace(): " + sb);

        // 5. reverse(): разворачивает строку
        sb.reverse();
        System.out.println("reverse(): " + sb);

        // Вернём обратно
        sb.reverse();

        // 6. setCharAt(): заменяет символ по индексу
        sb.setCharAt(0, 'J');
        System.out.println("setCharAt(): " + sb);

        // 7. substring(): получаем подстроку (работает как у String)
        System.out.println("substring(0, 4): " + sb.substring(0, 4));

        // 8. length(): длина строки
        System.out.println("length(): " + sb.length());

        // 9. capacity(): значение текущей ёмкости буфера
        System.out.println("capacity(): " + sb.capacity());

        // 10. ensureCapacity(): увеличивает ёмкость буфера
        sb.ensureCapacity(100);
        System.out.println("ensureCapacity(100): new capacity = " + sb.capacity());
    }


    /*
     Практика #1
     Демонстрация 10 методов StringBuffer.
     (Методы аналогичны StringBuilder, но потокобезопасные.)
    */
    public static void demoStringBufferMethods() {

        StringBuffer sb = new StringBuffer("Buffer");

        // 1
        sb.append(" Demo");
        System.out.println("append(): " + sb);

        // 2
        sb.insert(7, "Example ");
        System.out.println("insert(): " + sb);

        // 3
        sb.delete(7, 15);
        System.out.println("delete(): " + sb);

        // 4
        sb.replace(0, 6, "StringBuffer");
        System.out.println("replace(): " + sb);

        // 5
        sb.reverse();
        System.out.println("reverse(): " + sb);
        sb.reverse();

        // 6
        sb.setCharAt(0, 'S');
        System.out.println("setCharAt(): " + sb);

        // 7
        System.out.println("substring(0, 6): " + sb.substring(0, 6));

        // 8
        System.out.println("length(): " + sb.length());

        // 9
        System.out.println("capacity(): " + sb.capacity());

        // 10
        sb.ensureCapacity(120);
        System.out.println("ensureCapacity(120): new capacity = " + sb.capacity());
    }


    /*
     Практика #2
     Преобразование между String, StringBuilder и StringBuffer.
    */
    public static void demoConversions() {

        String str = "Hello";

        // String -> StringBuilder
        StringBuilder sb = new StringBuilder(str);
        System.out.println("String -> StringBuilder: " + sb);

        // String -> StringBuffer
        StringBuffer sbf = new StringBuffer(str);
        System.out.println("String -> StringBuffer: " + sbf);

        // StringBuilder -> String
        String fromSb = sb.toString();
        System.out.println("StringBuilder -> String: " + fromSb);

        // StringBuffer -> String
        String fromSbf = sbf.toString();
        System.out.println("StringBuffer -> String: " + fromSbf);

        // StringBuilder -> StringBuffer
        StringBuffer sbf2 = new StringBuffer(sb.toString());
        System.out.println("StringBuilder -> StringBuffer: " + sbf2);

        // StringBuffer -> StringBuilder
        StringBuilder sb2 = new StringBuilder(sbf.toString());
        System.out.println("StringBuffer -> StringBuilder: " + sb2);
    }
}