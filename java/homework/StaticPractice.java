package homework;

/*
Практика по теме: Статические поля и методы
*/

public class StaticPractice {

    public static void main(String[] args) {

        System.out.println("=== Практика #1 ===");

        // Вариант 1: прямой вызов по имени класса (рекомендованный способ)
        A.printVars();

        // Вариант 2: через объект (допустимо, но не рекомендуется)
        A obj1 = new A();
        obj1.printVars();

        // Вариант 3: через другую ссылку на тот же класс
        A obj2 = new A();
        obj2.a = 5;
        obj2.b = 10;

        // Независимо от того, какой объект вызвал метод, данные общие
        A.printVars();  // отразит последние значения a и b

        // Вариант 4: через null-ссылку (возможен, но крайне нежелателен)
        A obj3 = null;
        obj3.printVars(); // работает, потому что метод статический
    }
}

class A {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }
}

