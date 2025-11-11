package homework;

/*
Практика по теме: Перегрузка (overloading) и переопределение (overriding)
*/

public class OverloadingAndOverridingPractice {

    public static void main(String[] args) {

        OverloadedExample over = new OverloadedExample();
        over.print(5);
        over.print(3.14);
        over.print("Рома");

        Animal animal = new Animal();
        Dog dog = new Dog();

        animal.speak();  // вызов метода родителя
        dog.speak();     // вызов переопределённого метода

        WrongOverride wrong = new WrongOverride();
        wrong.showMessage();
    }
}

/*
Практика #1
Пример перегруженных методов.
Имя метода одно, но параметры разные.
Тип возвращаемого значения может быть одинаковым.
*/
class OverloadedExample {

    public void print(int n) {
        System.out.println("print(int n): " + n);
    }

    public void print(double d) {
        System.out.println("print(double d): " + d);
    }

    public void print(String s) {
        System.out.println("print(String s): " + s);
    }
}

/*
Практика #2
Пример переопределённого метода.
Метод speak() определён в суперклассе Animal и переопределён в подклассе Dog.
*/

class Animal {
    public String speak() {
        System.out.println("Животное издаёт звук.");
        return "generic sound";
    }
}

class Dog extends Animal {
    @Override
    public String speak() {
        System.out.println("Собака лает: гав-гав!");
        return "bark";
    }

    // Если попытаться изменить тип возвращаемого значения, несовместимый с родительским,
    // например: public int speak(), компилятор выдаст ошибку.
    // Тип возвращаемого значения должен быть таким же или "совместимым" (ковариантным).
}

/*
Практика #3
Аннотация @Override помогает компилятору проверить,
что метод действительно переопределяет метод суперкласса.
*/

class Parent {
    public void showMessage() {
        System.out.println("Сообщение из класса Parent");
    }
}

class WrongOverride extends Parent {
    // Без @Override ошибка могла бы остаться незамеченной:
    // мы опечатались в названии метода (showMassage вместо showMessage)
    // и метод не переопределит родительский, а создаст новый.

    // @Override
    public void showMassage() { // ошибка в названии — аннотация помогла бы это обнаружить
        System.out.println("Неправильный метод (ошибка в названии)");
    }
}
