package homework;

/*
Практика по теме: Исключения в Java
*/

public class ExceptionsPractice {

    public static void main(String[] args) {

        System.out.println("=== Практика #1: назначение основных классов исключений ===");
        explainHierarchy();

        System.out.println("\n=== Практика #2: примеры генерации исключений ===");

        handleArithmeticException();
        handleArrayIndexOutOfBoundsException();
        handleIllegalArgumentException();
        handleClassCastException();
        handleNullPointerException();
    }


    /*
     Практика #1

     Объяснение назначения основных классов исключений.
    */
    public static void explainHierarchy() {
        System.out.println("Throwable — базовый класс всех ошибок и исключений.");
        System.out.println("Exception — исключения, возникающие в нормальном потоке программы.");
        System.out.println("    RuntimeException — ошибки программиста (непроверяемые исключения).");
        System.out.println("Error — критические ошибки JVM, которые обычно нельзя обработать.");
    }


    /*
     Практика #2: ArithmeticException
     Возникает при ошибках арифметики (деление на ноль и др.)
    */
    public static void handleArithmeticException() {
        System.out.println("\n-- ArithmeticException --");

        try {
            int x = 10 / 0; // деление на ноль
            System.out.println(x);
        } catch (ArithmeticException ex) {
            System.out.println("Поймано исключение: " + ex);
        }
    }


    /*
     ArrayIndexOutOfBoundsException
     Возникает при обращении к индексу массива за пределами длины.
    */
    public static void handleArrayIndexOutOfBoundsException() {
        System.out.println("\n-- ArrayIndexOutOfBoundsException --");

        try {
            int[] arr = {1, 2, 3};
            int value = arr[5]; // индекс 5 не существует
            System.out.println(value);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Поймано исключение: " + ex);
        }
    }


    /*
     IllegalArgumentException
     Выбрасывается, когда метод получает недопустимый аргумент.
    */
    public static void handleIllegalArgumentException() {
        System.out.println("\n-- IllegalArgumentException --");

        try {
            setAge(-10); // недопустимый аргумент
        } catch (IllegalArgumentException ex) {
            System.out.println("Поймано исключение: " + ex);
        }
    }

    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
    }


    /*
     ClassCastException
     Выбрасывается при некорректном приведении типов.
    */
    public static void handleClassCastException() {
        System.out.println("\n-- ClassCastException --");

        try {
            Object obj = "Строка";
            Integer number = (Integer) obj; // неверное приведение
            System.out.println(number);
        } catch (ClassCastException ex) {
            System.out.println("Поймано исключение: " + ex);
        }
    }


    /*
     NullPointerException
     Возникает при обращении к методу/полю null-ссылки.
    */
    public static void handleNullPointerException() {
        System.out.println("\n-- NullPointerException --");

        try {
            String s = null;
            int len = s.length(); // обращение к методу null
            System.out.println(len);
        } catch (NullPointerException ex) {
            System.out.println("Поймано исключение: " + ex);
        }
    }
}
