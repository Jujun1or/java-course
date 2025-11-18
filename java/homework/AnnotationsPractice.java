package homework;

/*
Практика по теме: Аннотации в Java
*/

public class AnnotationsPractice {

    public static void main(String[] args) {

        System.out.println("=== Пример @Override ===");
        Parent p = new Parent();
        p.say();

        Child c = new Child();
        c.say();

        System.out.println("\n=== Пример @Deprecated ===");
        DeprecatedExample ex = new DeprecatedExample();
        ex.oldMethod(); // вызовет предупреждение компилятора

        System.out.println("\n=== Пример @SuppressWarnings ===");
        WarningExample we = new WarningExample();
        we.run();
    }
}


/*
Практика #1 — аннотация @Override

Она нужна для проверки:
- действительно ли метод переопределяет метод суперкласса.
- если сигнатура неверная, компилятор выдаст ошибку.
*/
class Parent {
    public void say() {
        System.out.println("Parent.say()");
    }
}

class Child extends Parent {
    @Override
    public void say() { // без @Override можно случайно сделать опечатку
        System.out.println("Child.say()");
    }
}


/*
Практика #1 — аннотация @Deprecated

Она используется, чтобы указать:
- что метод устарел,
- что он может быть удалён в будущем,
- что есть более новый способ выполнения логики.

При вызове компилятор покажет предупреждение.
*/
class DeprecatedExample {

    @Deprecated
    public void oldMethod() {
        System.out.println("Вызван устаревший метод oldMethod()");
    }

    public void newMethod() {
        System.out.println("Новый метод newMethod()");
    }
}


/*
Практика #1 — аннотация @SuppressWarnings

Нужна для скрытия предупреждений компилятора.

Типичные случаи:
- использование сырых типов (raw types)
- работа со старыми API
- намеренное игнорирование unchecked-предупреждений
*/
class WarningExample {

    @SuppressWarnings("unchecked")
    public void run() {
        System.out.println("Запуск метода с подавлением предупреждений");

        // сырая коллекция — обычно вызывает предупреждение
        java.util.List list = new java.util.ArrayList();
        list.add("строка");
        list.add(123);
        System.out.println(list);
    }
}
