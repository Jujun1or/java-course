package homework;

/**
 * Практика по теме "Комментарии и документация Javadoc"
 *
 * Команда для генерации документации:
 * javadoc CommentsAndJavadocPractice.java
 *
 * После выполнения в папке появится набор HTML-файлов с описанием класса и методов.
 *
 * Пример запуска (в терминале):
 * > javac CommentsAndJavadocPractice.java
 * > javadoc -encoding UTF-8 -charset UTF-8 CommentsAndJavadocPractice.java
 *
 * @author Roma
 * @version 1.0
 * @since 1.0
 */
public class CommentsAndJavadocPractice {

    /*
     * Это блочный комментарий.
     * Обычно используется для описания логики внутри метода или пояснения блока кода.
     */
    public static void main(String[] args) {

        // Это однострочный комментарий: поясняет отдельную строчку
        int a = 5; // комментарий можно писать и после выражения

        // Вызываем метод сложения для демонстрации Javadoc
        int result = add(a, 10);
        System.out.println("Результат сложения: " + result);
    }

    /**
     * Складывает два числа и возвращает результат.
     *
     * @param x первое число
     * @param y второе число
     * @return сумма аргументов x и y
     * @throws ArithmeticException если сумма выходит за диапазон int
     * @see Math#addExact(int, int)
     */
    public static int add(int x, int y) {
        // Здесь мы используем Math.addExact — он выбрасывает исключение при переполнении
        return Math.addExact(x, y);
    }

    /**
     * Метод для демонстрации устаревшей функции.
     *
     * @deprecated Этот метод оставлен для совместимости и не должен использоваться.
     * Лучше использовать {@link #add(int, int)}.
     */
    @Deprecated
    public static int oldAdd(int a, int b) {
        return a + b;
    }
}
