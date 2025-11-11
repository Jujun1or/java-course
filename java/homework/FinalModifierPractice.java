package homework;

/*
Практика по теме: Модификатор final
*/

public class FinalModifierPractice {

    public static void main(String[] args) {

        System.out.println("=== Практика #1 ===");

        // Вариант 1: инициализация при объявлении
        A1 obj1 = new A1();
        System.out.println("A1.a = " + obj1.a);

        // Вариант 2: инициализация в конструкторе
        A2 obj2 = new A2(42);
        System.out.println("A2.a = " + obj2.a);

        // Вариант 3: инициализация в блоке инициализации
        A3 obj3 = new A3();
        System.out.println("A3.a = " + obj3.a);
    }
}

/*
 Вариант 1.
 Константа final инициализируется прямо при объявлении.
*/
class A1 {
    public final int a = 10;
}

/*
 Вариант 2.
 Инициализация в конструкторе.
 Такой подход позволяет задать значение во время создания объекта.
*/
class A2 {
    public final int a;

    public A2(int value) {
        this.a = value;
    }
}

/*
 Вариант 3.
 Инициализация в нестатическом блоке инициализации.
 Этот блок выполняется перед конструктором.
*/
class A3 {
    public final int a;

    {
        a = 99;
    }
}

