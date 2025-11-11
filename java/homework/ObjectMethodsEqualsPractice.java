package homework;

/*
Практика по теме: Переопределение метода equals()
*/

public class ObjectMethodsEqualsPractice {

    public static void main(String[] args) {

        Person p1 = new Person("Рома", 18);
        Person p2 = new Person("Рома", 18);
        Person p3 = new Person("Андрей", 18);

        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false
        System.out.println("p1 == p2: " + (p1 == p2));         // false (разные объекты)
    }
}

/*
Пример собственного класса Person.
Переопределяем equals(), чтобы сравнение выполнялось по содержимому, а не по ссылке.
*/
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Переопределённый метод equals()
    @Override
    public boolean equals(Object obj) {
        // 1. Проверка на сравнение с самим собой
        if (this == obj) return true;

        // 2. Проверка на null и совпадение классов
        if (obj == null || getClass() != obj.getClass()) return false;

        // 3. Приведение типа и сравнение полей
        Person other = (Person) obj;
        return this.age == other.age &&
                (this.name != null ? this.name.equals(other.name) : other.name == null);
    }

    // Для корректной работы equals() желательно переопределить и hashCode()
    @Override
    public int hashCode() {
        int result = (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
