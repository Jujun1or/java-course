package homework;

/*
Практика по теме: Область видимости интерфейсов
*/

public class InterfaceVisibilityPractice {

    public static void main(String[] args) {
        System.out.println("См. комментарии над примерами");
    }
}

/*
Практика #1
interface Interface { ... }

Такой интерфейс не имеет явного модификатора доступа.
Это означает:
- область видимости: package-private (доступен только внутри этого пакета)
- за пределами пакета использовать нельзя
*/
interface PackageInterface {
    void test();
}

/*
Практика #2
public interface Interface { ... }

Такой интерфейс доступен откуда угодно:
- из любых пакетов
- из любых классов
- из любых модулей

Это максимальная область видимости.
*/
public interface PublicInterface {
    void work();
}

/*
Практика #3
protected interface Interface { ... }

Так объявить "топ-левел" интерфейс невозможно.
Код ниже НЕ скомпилируется:

protected interface ProtectedInterface { }

Причина:
- модификатор protected разрешён только для членов класса,
  но не для интерфейса верхнего уровня.
*/

/*
Практика #4
private interface Interface { ... }

Такой вариант тоже невозможен.
Код ниже НЕ скомпилируется:

private interface PrivateInterface { }

Причина:
- модификатор private запрещён для интерфейсов верхнего уровня.
- private допускается только для вложенных интерфейсов внутри классов.
*/


/*
Дополнительная демонстрация:
Вложенные интерфейсы МОГУТ иметь protected и private.
*/

class Container {

    // private вложенный интерфейс — допустимо
    private interface PrivateNested {
        void doSomething();
    }

    // protected вложенный интерфейс — тоже допустимо
    protected interface ProtectedNested {
        void action();
    }

    // public вложенный интерфейс — также допустимо
    public interface PublicNested {
        void move();
    }
}
