package homework;

/*
Практика по теме: обработка исключений и распространение исключений по стеку
*/

public class ExceptionPropagationPractice {

    public static void main(String[] args) {
        System.out.println("Старт программы.");

        generateExceptions();  // второе исключение дойдёт до сюда и завершит программу

        System.out.println("Этот текст никогда не будет напечатан.");
    }

    public static void generateExceptions() {

        // Первое исключение — перехватываем
        try {
            int x = 10 / 0;  // ArithmeticException
            System.out.println(x);
        } catch (ArithmeticException ex) {
            System.out.println("Поймано исключение: " + ex);
        }

        System.out.println("После первого обработанного исключения.");

        // Второе исключение — НЕ перехватываем
        // ArrayIndexOutOfBoundsException поднимется выше по стеку
        int[] arr = {1, 2, 3};
        int value = arr[10];   // здесь произойдёт аварийное завершение программы

        System.out.println("Этот текст уже не будет выполнен.");
    }
}
