package homework;

/*
Практика по теме: Внутренние (inner) классы
*/

public class InnerClassesPractice {

    public static void main(String[] args) {

        System.out.println("=== Практика #1: спецификаторы доступа внутренних классов ===");
        AccessDemo accessDemo = new AccessDemo();

        // public inner class — доступен везде
        AccessDemo.PublicInner p = accessDemo.new PublicInner();
        p.show();

        // protected inner class — доступен внутри пакета И в подклассах
        AccessDemo.ProtectedInner pr = accessDemo.new ProtectedInner();
        pr.show();

        // package-private inner class — доступен только внутри пакета
        AccessDemo.PackageInner pkg = accessDemo.new PackageInner();
        pkg.show();

        System.out.println("\n=== Практика #2: доступ inner класса к outer ===");
        Outer outer = new Outer(10);
        Outer.Inner inner = outer.new Inner();
        inner.modifyOuter(); // изменяет поле внешнего класса

        System.out.println("\n=== Практика #3: доступ outer класса к inner ===");
        Outer outer2 = new Outer(50);
        System.out.println("Из внешнего класса читаем поле внутреннего: " + outer2.readInnerValue());
    }
}


/*
Практика #1
Пример разных спецификаторов доступа внутренних классов.
*/
class AccessDemo {

    public class PublicInner {
        public void show() {
            System.out.println("PublicInner: доступен откуда угодно");
        }
    }

    protected class ProtectedInner {
        public void show() {
            System.out.println("ProtectedInner: доступен в этом пакете и в наследниках");
        }
    }

    class PackageInner { // package-private
        public void show() {
            System.out.println("PackageInner: доступен только в пределах пакета");
        }
    }

    private class PrivateInner {
        public void show() {
            System.out.println("PrivateInner: доступен только внутри AccessDemo");
        }
    }

    // Только внутренний код может использовать private inner class
    public void createPrivateInner() {
        PrivateInner p = new PrivateInner();
        p.show();
    }
}


/*
Практика #2
Может ли внутренний класс обращаться к полям и методам внешнего?

Да. Внутренний класс автоматически хранит ссылку на объект внешнего класса.
Он имеет доступ ко всем полям внешнего класса, включая private.
*/
class Outer {

    private int value;

    public Outer(int value) {
        this.value = value;
    }

    public class Inner {
        public void modifyOuter() {
            System.out.println("Внутренний класс видит outer.value = " + value);
            value += 5;
            System.out.println("После изменения outer.value = " + value);

            // можно вызвать private методы внешнего класса:
            privateOuterMethod();
        }
    }

    private void privateOuterMethod() {
        System.out.println("private метод внешнего класса вызван из внутреннего");
    }

    /*
    Практика #3
    Может ли внешний класс обращаться к полям внутреннего?

    Да, но только если внутренний класс и его поля доступны по спецификаторам доступа.

    Например:
    - public inner class: доступ ко всем его public-полям
    - private поля внутреннего класса недоступны снаружи, как и в обычном классе
    */
    public int readInnerValue() {
        Inner inner = new Inner();
        // Поле value принадлежит outer, inner к нему не имеет отношения.
        // Поэтому покажем доступ к inner, создав своё поле ниже.
        return innerValueHolder();
    }

    private int innerValueHolder() {
        InnerState st = new InnerState();
        return st.innerValue;
    }

    // Внутренний класс со своим полем
    class InnerState {
        int innerValue = 123; // доступно outer-классу
    }
}
