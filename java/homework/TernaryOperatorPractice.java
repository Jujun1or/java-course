package homework;

/*
Практика по теме: Тернарный оператор ? :
*/

public class TernaryOperatorPractice {

    public static void main(String[] args) {

        // Пример: исходный вариант с if–else
        int a = 2;
        int i;

        if (a == 1) {
            i = 1;
        } else if (a == 2) {
            i = 2;
        } else {
            i = 3;
        }
        System.out.println("Результат через if-else: " + i);

        // То же самое через тернарный оператор
        i = (a == 1) ? 1 : (a == 2 ? 2 : 3);
        System.out.println("Результат через тернарный оператор: " + i);
    }
}
