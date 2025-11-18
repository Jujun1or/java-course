package homework;

/*
Практика по теме: исключения в статических блоках инициализации
*/

public class StaticInitExceptionPractice {

    // Константа должна быть инициализирована в статическом блоке
    final static int START_COUNTER;

    // Статический блок выполняется при загрузке класса в JVM
    static {
        /*
         Здесь выполняется разбор строки "Y-".
         Метод Integer.parseInt пытается преобразовать строку в число,
         но строка не является корректным числом.

         В итоге:
         - возникает NumberFormatException
         - JVM оборачивает его в ExceptionInInitializerError
         - класс не загружается
         - метод main НЕ запустится
        */
        START_COUNTER = Integer.parseInt("Y-");
    }

    public static void main(String[] args) {
        // Эта строка никогда не выполнится
        System.out.println("Hello");
    }
}
