/**
 * Практика #1 — Принцип подстановки Лисков (LSP)
 *
 * Цель LSP:
 * Делать наследование безопасным и логичным, чтобы полиморфизм работал правильно.
 *
 * В этом примере показана корректная реализация LSP
 * и пример нарушения принципа на основе классов Rectangle и Square.
 */

class Shape {
    /**
     * Базовый класс Shape задает общий интерфейс для всех фигур.
     * Контракт: каждая фигура должна уметь возвращать свою площадь.
     */
    public double getArea() {
        return 0.0;
    }
}

/**
 * Класс Rectangle (прямоугольник) реализует базовый контракт Shape.
 * Он определяет ширину и высоту и корректно вычисляет площадь.
 *
 * Поведение:
 * - Ширина и высота независимы.
 * - Можно изменять их отдельно.
 */
class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }

    @Override
    public String toString() {
        return "Rectangle{" + "width=" + width + ", height=" + height + '}';
    }
}

/**
 * Пример нарушения LSP: подкласс BadSquare изменяет ожидаемое поведение Rectangle.
 *
 * Проблема:
 * - При изменении ширины автоматически изменяется высота.
 * - Такой объект больше не ведет себя как обычный прямоугольник.
 *
 * Следствие:
 * - Код, использующий Rectangle, теперь работает непредсказуемо.
 * - Нарушается принцип подстановки Лисков.
 */
class BadSquare extends Rectangle {
    public BadSquare(double side) {
        super(side, side);
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(double height) {
        this.width = height;
        this.height = height;
    }

    @Override
    public String toString() {
        return "BadSquare{" + "side=" + width + '}';
    }
}

/**
 * Корректная реализация LSP: класс Square наследует Shape напрямую.
 *
 * Особенности:
 * - Не ломает поведение Rectangle, так как не является его потомком.
 * - Соблюдает единый контракт: просто возвращает площадь своей фигуры.
 */
class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Square{" + "side=" + side + '}';
    }
}

public class LiskovExample {
    public static void main(String[] args) {
        System.out.println("=== Нарушение LSP ===");
        Rectangle rect = new BadSquare(5);
        rect.setWidth(10);
        System.out.println(rect + " => area=" + rect.getArea());

        System.out.println("\n=== Соблюдение LSP ===");
        Shape s1 = new Rectangle(4, 6);
        Shape s2 = new Square(5);
        System.out.println(s1 + " => area=" + s1.getArea());
        System.out.println(s2 + " => area=" + s2.getArea());
    }
}
