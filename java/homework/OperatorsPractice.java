package homework;

/*
Практика по теме: Операторы в Java
*/

public class OperatorsPractice {

    public static void main(String[] args) {

        practice1();

        practice2();
    }

    /*
     Практика #1
     Примеры всех основных операторов с базовыми типами и строками.
     */
    public static void practice1() {
        System.out.println("=== Практика #1 ===");

        // Арифметические операторы
        int a = 10;
        int b = 3;
        System.out.println("Сложение: a + b = " + (a + b));
        System.out.println("Вычитание: a - b = " + (a - b));
        System.out.println("Умножение: a * b = " + (a * b));
        System.out.println("Деление: a / b = " + (a / b));
        System.out.println("Остаток от деления: a % b = " + (a % b));

        // Инкремент и декремент
        int x = 5;
        System.out.println("Постфиксный инкремент x++: " + (x++));
        System.out.println("После постфиксного инкремента: " + x);
        System.out.println("Префиксный инкремент ++x: " + (++x));

        int y = 5;
        System.out.println("Постфиксный декремент y--: " + (y--));
        System.out.println("После постфиксного декремента: " + y);
        System.out.println("Префиксный декремент --y: " + (--y));

        // Побитовые операторы
        int bitA = 5;  // 0101
        int bitB = 3;  // 0011
        System.out.println("Побитовое И (5 & 3): " + (bitA & bitB));
        System.out.println("Побитовое ИЛИ (5 | 3): " + (bitA | bitB));
        System.out.println("Побитовое XOR (5 ^ 3): " + (bitA ^ bitB));
        System.out.println("Побитовое отрицание (~5): " + (~bitA));
        System.out.println("Сдвиг влево (5 << 1): " + (bitA << 1));
        System.out.println("Сдвиг вправо (5 >> 1): " + (bitA >> 1));
        System.out.println("Беззнаковый сдвиг вправо (-5 >>> 1): " + (-5 >>> 1));

        // Операторы сравнения
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a <= b: " + (a <= b));

        // Логические операторы
        boolean p = true;
        boolean q = false;
        System.out.println("p && q: " + (p && q));
        System.out.println("p || q: " + (p || q));
        System.out.println("!p: " + (!p));

        // Тернарный оператор
        int max = (a > b) ? a : b;
        System.out.println("Тернарный оператор (a > b ? a : b): " + max);

        // Операторы присваивания
        int num = 10;
        num += 5;
        num -= 3;
        num *= 2;
        num /= 4;
        num %= 5;
        System.out.println("Результат после серии присваиваний: " + num);

        // Работа со строками
        String first = "Рома";
        String last = "Медведьков";
        String fullName = first + " " + last;
        System.out.println("Оператор + со строками: " + fullName);

        String text = "Возраст: ";
        int age = 20;
        String result = text + age;
        System.out.println("Конкатенация строки и числа: " + result);

        System.out.println();
    }

    /*
     Практика #2
     Примеры использования оператора instanceof.
     Здесь показаны примеры с пользовательскими классами и null-объектом.
     */
    public static void practice2() {
        System.out.println("=== Практика #2 ===");

        Person p = new Person("Рома");
        Student s = new Student("Рома", "Java-разработчик");
        Employee e = new Employee("Рома", "Инженер");

        // Проверяем типы объектов
        System.out.println("p instanceof Person: " + (p instanceof Person));
        System.out.println("p instanceof Student: " + (p instanceof Student));
        System.out.println("s instanceof Student: " + (s instanceof Student));
        System.out.println("s instanceof Person: " + (s instanceof Person));
        System.out.println("e instanceof Employee: " + (e instanceof Employee));
        System.out.println("e instanceof Person: " + (e instanceof Person));

        // Проверяем общую ссылку
        Person personRef = s;
        System.out.println("personRef instanceof Student: " + (personRef instanceof Student));
        System.out.println("personRef instanceof Employee: " + (personRef instanceof Employee));

        // Проверяем null
        Person nullPerson = null;
        System.out.println("nullPerson instanceof Person: " + (nullPerson instanceof Person));

        System.out.println();
    }
}

/*
 Базовый класс Person
 Содержит общее поле name.
*/
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

/*
 Класс Student наследует Person и добавляет специальность.
*/
class Student extends Person {
    String specialty;

    Student(String name, String specialty) {
        super(name);
        this.specialty = specialty;
    }

}

/*
 Класс Employee тоже наследует Person, но имеет другую специализацию.
*/
class Employee extends Person {
    String position;

    Employee(String name, String position) {
        super(name);
        this.position = position;
    }

}
