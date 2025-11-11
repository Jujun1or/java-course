package homework;

/*
Практика по теме: Статические методы и полиморфизм
*/

public class StaticPolymorphismPractice {

    public static void main(String[] args) {
        System.out.println("=== Демонстрация поведения static-методов ===");

        A objA = new A();
        B objB = new B();

        // Прямой вызов по имени класса
        A.method();
        B.method();

        // Вызов через ссылки
        A ref = new B();
        ref.method(); // вызывается метод из A, не из B

        System.out.println("\nПояснение: статические методы не переопределяются, а скрываются (hiding).");
    }
}

/*
Суперкласс со статическим методом.
*/
class A {
    public static void method() {
        System.out.println("Статический метод из класса A");
    }
}

/*
Подкласс с методом с таким же именем.
Здесь происходит не переопределение, а скрытие (method hiding).
*/
class B extends A {
    // @Override — ошибка компиляции!
    // Статические методы не могут быть переопределены.
    public static void method() {
        System.out.println("Статический метод из класса B");
    }
}
