package homework;

/*
Практика по теме: Методы, перегрузка и переопределение
*/

public class MethodsPractice {

    public static void main(String[] args) {

        System.out.println("=== Перегрузка методов (overloading) ===");
        OverloadExample calc = new OverloadExample();

        // Один и тот же метод add(), но с разными параметрами
        System.out.println("add(int, int): " + calc.add(5, 7));
        System.out.println("add(double, double): " + calc.add(2.5, 3.5));
        System.out.println("add(String, String): " + calc.add("Рома", " Т."));


        System.out.println("\n=== Переопределение методов (overriding) ===");

        Animal generic = new Animal();
        Dog dog = new Dog();

        generic.makeSound(); // базовый вариант
        dog.makeSound();     // переопределённый вариант
    }
}

/*
 Пример перегрузки методов.
 Методы называются одинаково, но принимают разные типы аргументов.
*/
class OverloadExample {

    // Сложение двух целых чисел
    public int add(int a, int b) {
        return a + b;
    }

    // Сложение двух вещественных чисел
    public double add(double a, double b) {
        return a + b;
    }

    // "Сложение" строк (конкатенация)
    public String add(String a, String b) {
        return a + b;
    }
}

/*
 Пример переопределения метода.
 Класс Animal имеет метод makeSound(),
 а класс Dog его переопределяет (override).
*/
class Animal {
    public void makeSound() {
        System.out.println("Животное издает звук.");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Собака лает: Гав-гав!");
    }
}
