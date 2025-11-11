package homework;

/*
Практика по теме: Параметризация (Generics)
*/

import java.util.ArrayList;
import java.util.List;

public class GenericsPractice {

    public static void main(String[] args) {

        practice1();

        practice2();
    }

    /*
     Практика #1
     Примеры использования instanceof с параметризованными классами.
     Важно помнить: из-за стирания типов (type erasure) во время выполнения
     тип параметра (например <Integer> или <String>) не сохраняется.
     Поэтому instanceof можно использовать только с "сырым" типом (raw type).
     */
    public static void practice1() {
        System.out.println("=== Практика #1 ===");

        Wrapper<Integer> intWrapper = new Wrapper<>();
        intWrapper.setItem(10);

        Wrapper<String> stringWrapper = new Wrapper<>();
        stringWrapper.setItem("Рома");

        // Проверяем принадлежность к классу Wrapper без параметра
        if (intWrapper instanceof Wrapper) {
            System.out.println("intWrapper является объектом типа Wrapper");
        }

        if (stringWrapper instanceof Wrapper) {
            System.out.println("stringWrapper является объектом типа Wrapper");
        }

        // Невозможно проверить конкретный тип, пример ниже не компилируется:
        // if (intWrapper instanceof Wrapper<Integer>) { ... }

        System.out.println("Тип параметра (например <Integer>) недоступен во время выполнения программы.");
        System.out.println();
    }

    /*
     Простой generic-класс, который хранит один элемент любого типа.
     */
    static class Wrapper<T> {
        private T item;

        public void setItem(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }
    }

    /*
     Практика #2
     Примеры использования wildcard-ограничений <? extends T> и <? super T>.
     Объяснение:
     - <? extends T> означает "любой подкласс T или сам T"
       (обычно используется для чтения данных, но не для записи)
     - <? super T> означает "любой суперкласс T или сам T"
       (обычно используется для записи, но не для чтения с точным типом)
     */
    public static void practice2() {
        System.out.println("=== Практика #2 ===");

        List<Number> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20.5);

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        // <? extends Number> - можно читать числа, но нельзя добавлять новые
        printNumbers(integers); // Integer наследует Number
        printNumbers(numbers);

        // <? super Integer> - можно добавлять объекты Integer,
        // но при чтении получаем Object, потому что тип может быть шире
        addIntegers(numbers); // Number является суперклассом Integer

        System.out.println("numbers после addIntegers(): " + numbers);
        System.out.println();
    }

    // Читает элементы из списка любых подклассов Number
    public static void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println("Элемент: " + n);
        }
    }

    // Добавляет числа в список, тип которого является суперклассом Integer
    public static void addIntegers(List<? super Integer> list) {
        list.add(100);
        list.add(200);
    }
}

