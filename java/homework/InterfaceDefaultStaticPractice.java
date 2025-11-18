package homework;

/*
Практика по теме: default и static методы интерфейсов (начиная с Java 8)
*/

public class InterfaceDefaultStaticPractice {

    public static void main(String[] args) {

        System.out.println("=== Практика #1 ===");

        MyClass obj = new MyClass();

        // Вызов default-метода
        obj.sayHello();

        // Вызов метода интерфейса через реализацию
        obj.doSomething();

        // Вызов статического метода интерфейса
        MyInterface.staticMethod();

        System.out.println("\n=== Практика #2: конфликт default-методов ===");
        ConflictClass cc = new ConflictClass();
        cc.show();
    }
}


/*
Практика #1
Интерфейс с одним default-методом и одним static-методом.
*/
interface MyInterface {

    default void sayHello() {
        System.out.println("Hello from default method of MyInterface");
    }

    static void staticMethod() {
        System.out.println("Static method of MyInterface");
    }

    void doSomething(); // обычный абстрактный метод
}

/*
Класс реализует интерфейс.
Может переопределять default-методы, но не обязан.
*/
class MyClass implements MyInterface {

    @Override
    public void doSomething() {
        System.out.println("MyClass.doSomething() — реализация абстрактного метода");
    }
}



/*
Практика #2
Если класс реализует два интерфейса, в которых есть одинаковые default-методы,
код НЕ скомпилируется. Компилятор требует явно разрешить конфликт.
*/

interface InterfaceA {
    default void show() {
        System.out.println("Default show() from InterfaceA");
    }
}

interface InterfaceB {
    default void show() {
        System.out.println("Default show() from InterfaceB");
    }
}

/*
При реализации A и B возникает конфликт одинаковых default-методов.
Решение: переопределить метод и указать, чью реализацию использовать.
*/
class ConflictClass implements InterfaceA, InterfaceB {

    @Override
    public void show() {

        System.out.println("Конфликтный метод переопределён вручную.");

        // Можно явно выбрать реализацию конкретного интерфейса:
        InterfaceA.super.show();
        InterfaceB.super.show();

        // Или дать свою собственную реализацию без вызова интерфейсов.
    }
}
