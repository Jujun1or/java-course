package homework;

/*
Практика по теме: Перегрузка методов (Overloading)
*/

public class OverloadingBehaviorPractice {

    @SuppressWarnings("removal")
    public static void main(String[] args) {

        A a = new A();
        Number[] num = { new Integer(1), 11, 1.11f, 11.11 };

        System.out.println("=== Цикл for (1) ===");
        for (Number n : num) {
            a.printNum(n);
        }

        System.out.println("\n=== Вызовы (2) ===");
        a.printNum(new Integer(1));
        a.printNum(11);
        a.printNum(1.11f);
        a.printNum(11.11);
    }
}

/*
 Класс с четырьмя перегруженными методами printNum().
 Каждый принимает разный тип аргумента.
*/
class A {
    public void printNum(Integer i) {
        System.out.printf("Integer = %d%n", i);
    }

    public void printNum(int i) {
        System.out.printf("int = %d%n", i);
    }

    public void printNum(Float f) {
        System.out.printf("Float = %.4f%n", f);
    }

    public void printNum(Number n) {
        System.out.println("Number = " + n);
    }
}

/*
Пояснение к результату:

=== Цикл for 1 ===

В цикле тип переменной n — Number.
Это значит, что компилятор видит аргумент именно как Number,
поэтому выбирает версию метода printNum(Number).
(Компилятор не знает, что во время выполнения n окажется Integer, Float и т.д.)

Результат:
Number = 1
Number = 11
Number = 1.11
Number = 11.11

=== Вызовы 2 ===

Здесь компилятор видит точные типы передаваемых значений:
- new Integer(1) тип Integer вызов printNum(Integer)
- 11 базовый тип int вызов printNum(int)
- 1.11f тип float автозапаковка в Float вызов printNum(Float)
- 11.11 тип double не существует метода printNum(double), поэтому подходит общий printNum(Number)

Результат:
Integer = 1
int = 11
Float = 1.1100
Number = 11.11

Вывод:
Разница возникает потому, что выбор перегруженного метода происходит
на этапе компиляции по типу аргумента, а не по фактическому типу объекта во время выполнения.
*/
