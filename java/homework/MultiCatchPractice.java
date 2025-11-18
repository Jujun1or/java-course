package homework;

/*
Практика по теме: несколько catch-блоков, multi-catch, иерархия исключений
*/

public class MultiCatchPractice {

    public static void main(String[] args) {

        System.out.println("=== Практика #1: несколько catch-секций ===");
        handleSeveralExceptions();

        System.out.println("\n=== Практика #1: multi-catch и иерархия ===");
        handleHierarchy();

        System.out.println("\n=== Практика #2: final в catch ===");
        explainFinalInCatch();

        System.out.println("\n=== Вложенные try-блоки ===");
        nestedTryExample();
    }


    /*
     Практика #1 — часть 1.
     Несколько исключений обрабатываются одинаково.
     */
    public static void handleSeveralExceptions() {

        try {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new IllegalArgumentException("Неверный аргумент");
            } else {
                throw new ArithmeticException("Арифметическая ошибка");
            }
        }
        catch (IllegalArgumentException | ArithmeticException e) {
            // Multi-catch: исключения НЕ находятся в одной иерархической цепочке
            System.out.println("Исключение обработано одинаковым способом: " + e);
        }
    }


    /*
     Практика #1 — часть 2.
     Исключения находятся в одной иерархии:
       Ex1 <- Ex2 <- Ex3
     Показываем:
     - что нельзя использовать | для исключений в одной цепочке
     - как правильно обрабатывать такие исключения
    */
    public static void handleHierarchy() {

        try {
            throw new Ex3("Ex3 выброшено");
        }

        /*
         НЕЛЬЗЯ ТАК:
         catch (Ex1 | Ex2 | Ex3 e) {}
         Это ошибка, потому что Ex2 является подклассом Ex1, а Ex3 — подклассом Ex2.
         Исключения не должны находиться в одной иерархической цепочке.

         Правильный порядок: от младшего к старшему.
        */
        catch (Ex3 e) {
            System.out.println("Перехвачено Ex3: " + e.getMessage());
        }
        catch (Ex2 e) {
            System.out.println("Перехвачено Ex2: " + e.getMessage());
        }
        catch (Ex1 e) {
            System.out.println("Перехвачено Ex1: " + e.getMessage());
        }
    }


    /*
     Собственная иерархия исключений
     Ex1 <- Ex2 <- Ex3
    */
    static class Ex1 extends Exception {
        public Ex1(String msg) { super(msg); }
    }

    static class Ex2 extends Ex1 {
        public Ex2(String msg) { super(msg); }
    }

    static class Ex3 extends Ex2 {
        public Ex3(String msg) { super(msg); }
    }


    /*
     Практика #2
     Зачем нужен final в catch?

     catch(final Exception e)
     означает, что переменная e НЕ может быть переназначена внутри блока.

     Это запрещает делать так:

         e = new Exception();

     И гарантирует, что ссылка e всегда указывает на пойманное исключение.
    */
    public static void explainFinalInCatch() {

        try {
            throw new Exception("Ошибка");
        }
        catch (final Exception e) {

            // e = new Exception("Нельзя"); // ошибка — final запрещает переназначение

            System.out.println("final в catch защищает переменную e от изменения.");
        }
    }


    /*
     Показываем, что try-блоки могут быть вложенными.
    */
    public static void nestedTryExample() {

        try {
            System.out.println("Внешний try работает.");

            try {
                int x = 10 / 0;
            } catch (ArithmeticException ex) {
                System.out.println("Внутренний catch перехватил ArithmeticException");
            }

            // Теперь возникнет другое исключение, внешнее его обработает
            String s = null;
            System.out.println(s.length());
        }
        catch (NullPointerException ex) {
            System.out.println("Внешний catch перехватил NullPointerException");
        }
    }
}
