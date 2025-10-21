package homework;

/**
 * Практика по базовым типам данных Java
 * Здесь решения Практик #1–#8.
 */
public class PrimitiveTypesPractice {

    public static void main(String[] args) {

        // 1. Примеры всех базовых типов
        practice1();

        // 2. Имя в формате Unicode
        practice2();

        // 3. Область видимости переменных
        practice3();

        // 4. Перегрузка оператора +
        practice4();

        // 5. Расширяющие преобразования
        practice5();

        // 6. Сужающие преобразования
        practice6();

        // 7. Ошибки и переполнения при приведении типов
        practice7();

        // 8. Type inference и var
        practice8();
    }

    /**
     * Практика #1
     * Примеры всех базовых типов данных и их нулевых значений.
     * Каждый тип имеет свой диапазон и размер в битах.
     */
    public static void practice1() {
        System.out.println("=== Практика #1 ===");

        byte b = 0;          // 8 бит, диапазон от -128 до 127
        short s = 0;         // 16 бит
        int i = 0;           // 32 бита
        long l = 0L;         // 64 бита
        float f = 0.0f;      // 32 бита, число с плавающей точкой
        double d = 0.0;      // 64 бита, число с плавающей точкой
        char c = '\u0000';   // 16 бит, символ Unicode
        boolean bool = false;// логический тип, два значения: true / false

        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char (код): " + (int) c);
        System.out.println("boolean: " + bool);
        System.out.println();
    }

    /**
     * Практика #2
     * Печатаем имя "Рома" в формате Unicode (\\uXXXX).
     * Каждый символ заменён на его код в стандарте Unicode.
     */
    public static void practice2() {
        System.out.println("=== Практика #2 ===");

        // Имя "Рома" в Unicode: Р (0420), о (043E), м (043C), а (0430)
        String name = "\u0420\u043E\u043C\u0430";
        System.out.println("Имя в формате Unicode: " + name);
        System.out.println();
    }

    /**
     * Практика #3
     * Пример с областью видимости переменных.
     * Переменная, объявленная внутри блока {}, доступна только внутри этого блока.
     */
    public static void practice3() {
        System.out.println("=== Практика #3 ===");

        int a = 1;
        {
            int b = 2; // b существует только внутри этих фигурных скобок
        }

        // Здесь переменной b уже не существует, поэтому строка ниже не скомпилируется:
        // int c = a + b; // Ошибка: cannot find symbol b

        System.out.println("Ошибка компиляции: переменная b вне области видимости.");
        System.out.println();
    }

    /**
     * Практика #4
     * Пример перегрузки оператора "+" для строк.
     * В Java этот оператор используется для конкатенации строк,
     * а также может объединять строку с другими типами.
     */
    public static void practice4() {
        System.out.println("=== Практика #4 ===");

        String name = "Рома";
        int age = 20;
        double height = 1.80;
        boolean active = true;

        String info = name + " — возраст: " + age + ", рост: " + height + ", активен: " + active;
        System.out.println(info);
        System.out.println();
    }

    /**
     * Практика #5
     * Пример расширяющих преобразований типов.
     * При сложении разных типов результат всегда имеет более "широкий" тип.
     */
    public static void practice5() {
        System.out.println("=== Практика #5 ===");

        byte b = 10;
        int i = 5;
        long l = 100L;
        double d = 2.5;

        // Последовательность: byte -> int -> long -> double
        double result = b + i + l + d;

        System.out.println("Результат выражения (byte + int + long + double): " + result);
        System.out.println("Тип результата: double");
        System.out.println();
    }

    /**
     * Практика #6
     * Пример сужающих преобразований — когда значение нужно явно привести к меньшему типу.
     * Может происходить потеря данных или переполнение.
     */
    public static void practice6() {
        System.out.println("=== Практика #6 ===");

        int i = 130;
        byte b = (byte) i; // 130 выходит за пределы диапазона byte (-128..127)
        double d = 123.45;
        int i2 = (int) d;  // дробная часть теряется

        System.out.println("int -> byte: 130 -> " + b + " (произошло переполнение)");
        System.out.println("double -> int: 123.45 -> " + i2 + " (дробная часть отброшена)");
        System.out.println();
    }

    /**
     * Практика #7
     * Рассмотрим выражения с byte и int и проанализируем результат.
     */
    public static void practice7() {
        System.out.println("=== Практика #7 ===");

        int a = 120;
        // byte b = a + 10; // не скомпилируется: результат выражения имеет тип int
        byte c = (byte)(a + 10); // 130 -> -126 после приведения (переполнение)
        byte d = (byte)(a + 1);  // 121 помещается в диапазон byte

        System.out.println("a = 120");
        System.out.println("c = (byte)(a + 10) => " + c);
        System.out.println("d = (byte)(a + 1) => " + d);
        System.out.println("Объяснение: 130 выходит за диапазон byte, поэтому результат -126.");
        System.out.println();
    }

    /**
     * Практика #8
     * Пример использования var и понятие type inference.
     * Компилятор сам определяет тип переменной по её начальному значению.
     */
    public static void practice8() {
        System.out.println("=== Практика #8 ===");

        var number = 10;      // int
        var text = "Java";    // String
        var price = 99.99;    // double
        var active = true;    // boolean

        System.out.println("number (int): " + number);
        System.out.println("text (String): " + text);
        System.out.println("price (double): " + price);
        System.out.println("active (boolean): " + active);
        System.out.println();
    }
}
