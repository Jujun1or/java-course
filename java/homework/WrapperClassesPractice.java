package homework;

/*
Практика по теме: Классы-оболочки (Wrapper Classes) и автоупаковка/распаковка
*/

public class WrapperClassesPractice {

    public static void main(String[] args) {

        practice1();

        practice2();

        practice3();

        practice4();
    }

    /*
     Практика #1
     Примеры использования метода decode().
     Метод decode() интерпретирует строку с числом в разных системах счисления:
     */
    public static void practice1() {
        System.out.println("=== Практика #1 ===");

        Integer decimal = Integer.decode("12");     // 12 (десятичная)
        Integer octal = Integer.decode("012");      // 10 (восьмеричная)
        Integer hex1 = Integer.decode("0x12");      // 18 (шестнадцатеричная)
        Integer hex2 = Integer.decode("#12");       // 18 (шестнадцатеричная форма с #)

        System.out.println("decode(\"12\") = " + decimal);
        System.out.println("decode(\"012\") = " + octal);
        System.out.println("decode(\"0x12\") = " + hex1);
        System.out.println("decode(\"#12\") = " + hex2);
        System.out.println();
    }

    /*
     Практика #2
     Все способы создания экземпляра класса Boolean.
     */
    public static void practice2() {
        System.out.println("=== Практика #2 ===");

        // Через valueOf с типом boolean
        Boolean b1 = Boolean.valueOf(true);

        // Через valueOf с типом String (true игнорирует регистр)
        Boolean b2 = Boolean.valueOf("true");
        Boolean b3 = Boolean.valueOf("TRUE");
        Boolean b4 = Boolean.valueOf("false");

        // Через константы
        Boolean b5 = Boolean.TRUE;
        Boolean b6 = Boolean.FALSE;

        // Через автоупаковку
        Boolean b7 = true;

        System.out.println("b1 (valueOf(true)) = " + b1);
        System.out.println("b2 (valueOf(\"true\")) = " + b2);
        System.out.println("b3 (valueOf(\"TRUE\")) = " + b3);
        System.out.println("b4 (valueOf(\"false\")) = " + b4);
        System.out.println("b5 (Boolean.TRUE) = " + b5);
        System.out.println("b6 (Boolean.FALSE) = " + b6);
        System.out.println("b7 (автоупаковка) = " + b7);
        System.out.println();
    }

    /*
     Практика #3
     Пример NullPointerException при автоупаковке и автораспаковке.
     Исключение возникает при попытке распаковки null-значения.
     */
    public static void practice3() {
        System.out.println("=== Практика #3 ===");

        Integer number = null; // null-ссылка
        try {
            int value = number; // попытка unboxing — выбросит NullPointerException
            System.out.println("Значение: " + value);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: попытка распаковать null -> " + e);
        }

        // При упаковке (boxing) NPE не возникает
        int base = 10;
        Integer wrapped = base; // ok
        System.out.println("Корректная упаковка: " + wrapped);
        System.out.println();
    }

    /*
     Практика #4
     Разбор примера с IntegerCache и сравнением значений.
     IntegerCache хранит объекты от -128 до 127,
     поэтому одинаковые значения в этом диапазоне ссылаются на один объект.
     */
    public static void practice4() {
        System.out.println("=== Практика #4 ===");

        int i1 = 128;
        Integer a1 = i1;
        Integer b1 = i1;

        System.out.println("a1==i1 -> " + (a1 == i1));         // true (unboxing)
        System.out.println("b1==i1 -> " + (b1 == i1));         // true (unboxing)
        System.out.println("a1==b1 -> " + (a1 == b1));         // false (разные объекты)
        System.out.println("a1.equals(i1) -> " + a1.equals(i1)); // true (по значению)
        System.out.println("b1.equals(i1) -> " + b1.equals(i1)); // true
        System.out.println("a1.equals(b1) -> " + a1.equals(b1));// true

        System.out.println();

        int i2 = 127;
        Integer a2 = i2;
        Integer b2 = i2;

        System.out.println("a2==i2 -> " + (a2 == i2));         // true
        System.out.println("b2==i2 -> " + (b2 == i2));         // true
        System.out.println("a2==b2 -> " + (a2 == b2));         // true (IntegerCache)
        System.out.println("a2.equals(i2) -> " + a2.equals(i2)); // true
        System.out.println("b2.equals(i2) -> " + b2.equals(i2)); // true
        System.out.println("a2.equals(b2) -> " + a2.equals(b2));// true

        System.out.println();
        System.out.println("Объяснение:");
        System.out.println("Для значений от -128 до 127 объекты Integer берутся из IntegerCache,");
        System.out.println("поэтому a2 и b2 указывают на один и тот же объект.");
        System.out.println("Для 128 создаются новые объекты, поэтому a1 и b1 разные.");
        System.out.println();
    }
}
