package homework;

/*
Практика по теме: Оператор switch
*/

public class SwitchOperatorPractice {

    public static void main(String[] args) {

        practice1();

        practice2();
    }

    /*
     Практика #1
     Тип переменной в switch может быть:
     - byte, short, int, char
     - перечисление (enum)
     - String
     - начиная с Java 5 — обертки (Byte, Short, Integer, Character)
     - начиная с Java 7 — тип String
     */
    public static void practice1() {
        System.out.println("=== Практика #1 ===");

        // Пример с int
        int number = 2;
        switch (number) {
            case 1 -> System.out.println("int: значение 1");
            case 2 -> System.out.println("int: значение 2");
            default -> System.out.println("int: другое значение");
        }

        // Пример с char
        char letter = 'B';
        switch (letter) {
            case 'A' -> System.out.println("char: A");
            case 'B' -> System.out.println("char: B");
            default -> System.out.println("char: не A и не B");
        }

        // Пример с String
        String day = "Monday";
        switch (day) {
            case "Monday" -> System.out.println("String: Понедельник");
            case "Tuesday" -> System.out.println("String: Вторник");
            default -> System.out.println("String: Другой день");
        }

        // Пример с enum
        Day today = Day.SUNDAY;
        switch (today) {
            case MONDAY -> System.out.println("enum: Понедельник");
            case SUNDAY -> System.out.println("enum: Воскресенье");
            default -> System.out.println("enum: Другой день");
        }

        System.out.println();
    }

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    /*
     Практика #2
     Пример, когда в некоторых частях case отсутствует break.
     Показывает, как работает "проваливание".
     */
    public static void practice2() {
        System.out.println("=== Практика #2 ===");

        int value = 2;
        int i = 0;

        switch (value) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2; // break отсутствует — выполнение продолжится в следующий case
            case 3:
                i = 3;
                break;
            default:
                i = 4;
        }

        System.out.println("Результат i = " + i);
        System.out.println("Пояснение: при value = 2 выполнились case 2 и case 3, потому что не было break после case 2.");
        System.out.println();
    }
}

