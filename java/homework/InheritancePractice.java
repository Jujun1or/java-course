package homework;

/*
Практика по теме: Наследование (extends), this и super
*/

public class InheritancePractice {

    public static void main(String[] args) {

        System.out.println("=== Практика #1: this и super ===");
        Child child = new Child(10);
        child.showValues();

        System.out.println("\n=== Практика #2: модификаторы доступа при наследовании ===");
        C c = new C();
        c.testAccess();
    }
}

/*
Практика #1
Пример использования this и super.
- this обращается к текущему объекту (его полям и методам)
- super обращается к членам суперкласса, которые доступны (не private)
*/
class Parent {
    int value = 5;

    Parent() {
        System.out.println("Конструктор Parent");
    }

    void showValue() {
        System.out.println("Parent.value = " + value);
    }
}

class Child extends Parent {
    int value = 20;

    Child(int value) {
        super(); // вызывает конструктор родителя
        this.value = value; // this — поле текущего класса
    }

    void showValues() {
        System.out.println("this.value = " + this.value);   // обращаемся к полю текущего класса
        System.out.println("super.value = " + super.value); // обращаемся к полю родителя
        super.showValue(); // вызываем метод суперкласса
    }
}

/*
Практика #2
Проверяем, какие поля и методы класса A доступны в наследниках.
*/

class A {
    int a1 = 1;           // доступен в пределах пакета (package-private)
    public int a2 = 2;    // доступен везде
    protected int a3 = 3; // доступен в пределах пакета и в подклассах (даже из других пакетов)
    private int a4 = 4;   // доступен только внутри A

    void method1() {
        System.out.println("A.method1() — package-private");
    }

    public void method2() {
        System.out.println("A.method2() — public");
    }

    protected void method3() {
        System.out.println("A.method3() — protected");
    }

    private void method4() {
        System.out.println("A.method4() — private");
    }
}

class B extends A {

    void checkAccessInB() {
        System.out.println("\nПроверка в классе B (наследник A):");
        System.out.println("a1 = " + a1);  // доступен (тот же пакет)
        System.out.println("a2 = " + a2);  // доступен (public)
        System.out.println("a3 = " + a3);  // доступен (protected)
        // System.out.println(a4);         // ошибка (private)

        method1();  // доступен
        method2();  // доступен
        method3();  // доступен
        // method4(); // ошибка (private)
    }
}

class C extends B {

    void testAccess() {
        System.out.println("Проверка в классе C (наследник B):");

        // Все поля, кроме private, доступны
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a3 = " + a3);
        // System.out.println(a4); // ошибка — private из A

        // Методы аналогично
        method1();
        method2();
        method3();
        // method4(); // недоступен, private
    }
}
