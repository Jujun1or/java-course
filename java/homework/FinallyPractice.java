package homework;

/*
Практика по теме: try, catch, finally
*/

public class FinallyPractice {

    public static void main(String[] args) {

        System.out.println("=== Практика #1 ===");
        answerPractice1();

        System.out.println("\n=== Практика #2 ===");
        answerPractice2();

        System.out.println("\n=== Практика #3 ===");
        answerPractice3();
    }

    /*
     Практика #1
     Можно ли использовать конструкцию:

       try {
           ...
       }

     Ответ:
     НЕТ, нельзя.

     Объяснение:
     try обязательно должен иметь хотя бы один:
     - catch
     - или finally

     В противном случае код не скомпилируется.
    */
    public static void answerPractice1() {
        System.out.println("Нельзя использовать try без catch и без finally. Это ошибка компиляции.");
    }

    /*
     Практика #2
     Можно ли использовать конструкцию:

       try {
           ...
       } finally {
           ...
       }

     Ответ:
     ДА, можно.

     Объяснение:
     Такая конструкция корректна.
     Блок finally гарантированно выполнится даже при исключении.
     Используется, когда нужно всегда освободить ресурсы,
     но нет необходимости обрабатывать исключение именно здесь.
    */
    public static void answerPractice2() {
        System.out.println("Можно использовать try только с finally. Это корректный код.");
    }

    /*
     Практика #3
     Можно ли использовать конструкцию:

       try {
           ...
       } finally {
           ...
       } finally {
           ...
       }

     Ответ:
     Нет, нельзя.

     Объяснение:
     У одного try-блока может быть только один блок finally.
     Второй finally приведёт к ошибке компиляции.
    */
    public static void answerPractice3() {
        System.out.println("Нельзя использовать два finally. Допустим только один finally.");
    }
}
