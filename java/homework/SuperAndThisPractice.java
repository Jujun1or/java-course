package homework;

/*
Практика по теме: Ключевые слова super и this
*/

public class SuperAndThisPractice {

    public static void main(String[] args) {

        System.out.println("=== Практика #1: использование super ===");
        new C();

        System.out.println("\n=== Практика #2: обращение к полю и методу предка через super ===");
        C obj = new C();
        obj.method();

        System.out.println("\n=== Практика #3: использование this() в конструкторах ===");
        new A(5, 10, 15);
    }
}

/*
Практика #1
Пример использования super:
1) вызов конструктора суперкласса
2) доступ к полю суперкласса
3) вызов метода суперкласса
*/

class Parent {
    int value = 100;

    Parent() {
        System.out.println("Конструктор Parent");
    }

    void showMessage() {
        System.out.println("Метод суперкласса showMessage()");
    }
}

class Child extends Parent {
    int value = 200;

    Child() {
        super(); // (1) вызов конструктора суперкласса
        System.out.println("Конструктор Child");
        System.out.println("Поле суперкласса value = " + super.value); // (2) доступ к полю суперкласса
        super.showMessage(); // (3) вызов метода суперкласса
    }
}

/*
Практика #2
Объяснение:
Если переменная a и метод method() определены только в классе A,
а классы B и C их не переопределяют, то при вызове obj.method()
используется версия из класса C, которая вызывает super.method().
super.method() обратится к реализации из A, потому что в B её нет.
*/

class A {
    int a = 10;

    void method() {
        System.out.println("Метод A.method(), a = " + a);
    }
}

class B extends A {
    // в этом классе нет поля a и метода method()
}

class C extends B {

    @Override
    void method() {
        System.out.println("Метод C.method() (переопределённый)");
        int a = super.a; // доступ к полю из класса A
        System.out.println("Значение super.a = " + a);
        super.method(); // вызов метода из класса A
    }
}

/*
Практика #3
Переписанный пример класса A с использованием this().
Все конструкторы вызывают один базовый, уменьшая дублирование кода.
*/

class A {
    int a;
    int b;
    int c;
    int z;

    public A() {
        z = 1;
        System.out.println("Вызван конструктор без аргументов: z = " + z);
    }

    public A(int a) {
        this(); // вызывает конструктор A()
        this.a = a;
        System.out.println("Вызван конструктор с 1 аргументом: a = " + a);
    }

    public A(int a, int b) {
        this(a); // вызывает конструктор с 1 аргументом
        this.b = b;
        System.out.println("Вызван конструктор с 2 аргументами: a = " + a + ", b = " + b);
    }

    public A(int a, int b, int c) {
        this(a, b); // вызывает конструктор с 2 аргументами
        this.c = c;
        System.out.println("Вызван конструктор с 3 аргументами: a = " + a + ", b = " + b + ", c = " + c);
    }
}
