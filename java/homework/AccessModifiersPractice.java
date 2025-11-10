package homework;

/*
Практика по теме: Спецификаторы доступа (Access Modifiers)
*/

public class AccessModifiersPractice {

    public static void main(String[] args) {

        System.out.println("=== Демонстрация спецификаторов доступа ===");

        // Создаём объект базового класса
        // Создаём объект базового класса
        BaseClass base = new BaseClass();

        // Доступ к полям и методам из того же файла (того же пакета)
        base.publicField = "Публичное поле доступно";
        base.packageField = "Поле без модификатора доступно (один пакет)";
        base.protectedField = "Protected доступен внутри пакета";

        // base.privateField = "Ошибка"; // недоступно, private — только внутри BaseClass

        base.showAccessibleFields();

        // Доступ через подкласс
        SubClass sub = new SubClass();
        sub.showParentFields();

        System.out.println();

        // Проверим инкапсуляцию через private поле
        base.setPrivateField("Новое значение через setter");
        System.out.println("Доступ к private через getter: " + base.getPrivateField());
    }
}

/*
 Класс, демонстрирующий все типы доступа.
*/
class BaseClass {

    public String publicField;         // доступен всем
    String packageField;               // доступен только внутри пакета
    protected String protectedField;   // доступен внутри пакета и в подклассах
    private String privateField;       // доступен только внутри этого класса

    public BaseClass() {
        this.publicField = "public";
        this.packageField = "package-private";
        this.protectedField = "protected";
        this.privateField = "private";
    }

    public void showAccessibleFields() {
        System.out.println("BaseClass: доступ ко всем полям внутри самого класса:");
        System.out.println("publicField = " + publicField);
        System.out.println("packageField = " + packageField);
        System.out.println("protectedField = " + protectedField);
        System.out.println("privateField = " + privateField);
    }

    // Пример инкапсуляции: доступ к private-полю через методы
    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField(String value) {
        this.privateField = value;
    }
}

/*
 Подкласс, находящийся в том же пакете (для упрощения примера).
 Protected-поле будет доступно, private — нет.
*/
class SubClass extends BaseClass {

    public void showParentFields() {
        System.out.println("SubClass: проверка доступности полей родителя:");

        // Все, кроме private, доступны
        System.out.println("publicField = " + publicField);
        System.out.println("packageField = " + packageField);
        System.out.println("protectedField = " + protectedField);
        // System.out.println(privateField); // ошибка компиляции
    }
}
