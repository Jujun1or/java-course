package homework;

/*
Практика по теме: Ограничения final для классов и методов
*/

public class FinalRestrictionPractice {

    public static void main(String[] args) {
        System.out.println("=== Практика #1: final-метод ===");
        SubClass sub = new SubClass();
        sub.showMessage();

        System.out.println("\n=== Практика #2: final-класс ===");
        FinalClass obj = new FinalClass();
        obj.printData();
    }
}

/*
Практика #1
Final-метод нельзя переопределить в подклассе.
*/
class BaseClass {
    public final void showMessage() {
        System.out.println("Это final-метод суперкласса");
    }
}

class SubClass extends BaseClass {
    // Попытка переопределить final-метод приведет к ошибке компиляции:
    // @Override
    // public void showMessage() {
    //     System.out.println("Переопределение запрещено");
    // }
    // Поэтому метод наследуется без изменений.
}

/*
Практика #2
Final-класс нельзя расширять.
*/
final class FinalClass {
    public void printData() {
        System.out.println("Final-класс работает, но наследовать его нельзя");
    }
}

// Попытка наследования вызовет ошибку компиляции:
// class ExtendedFinalClass extends FinalClass {
// }

