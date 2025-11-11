package homework;

/*
Практика по теме: Методы с переменным числом параметров (varargs)
*/

public class VarargsOverloadingPractice {

    public static void main(String[] args) {

        Printer p = new Printer();

        System.out.println("Примеры вызовов");

        // Вызывается метод с int...
        p.print(1, 2, 3);

        // Вызывается метод с String...
        p.print("JVM", "Maven", "Java");

        // Вызывается метод с Object...
        p.print(1, "тест", 3.14);

        // Вызывается метод без аргументов
        p.print();
    }
}

/*
 Класс Printer содержит несколько перегруженных методов print(),
 которые отличаются типом параметров varargs.
*/
class Printer {

    // Метод с переменным числом целых аргументов
    public void print(int... nums) {
        System.out.println("Метод print(int...) вызван:");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println("\n");
    }

    // Метод с переменным числом строковых аргументов
    public void print(String... words) {
        System.out.println("Метод print(String...) вызван:");
        for (String w : words) {
            System.out.print(w + " ");
        }
        System.out.println("\n");
    }

    // Метод с переменным числом объектов
    public void print(Object... objs) {
        System.out.println("Метод print(Object...) вызван:");
        for (Object o : objs) {
            System.out.print(o + " ");
        }
        System.out.println("\n");
    }

    // Перегруженный метод без аргументов
    public void print() {
        System.out.println("Метод print() без параметров вызван\n");
    }
}
