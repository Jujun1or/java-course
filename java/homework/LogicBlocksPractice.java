package homework;

/*
Практика по теме: Логические блоки (инициализаторы)
*/

public class LogicBlocksPractice {

    public static void main(String[] args) {
        new A(100);
    }
}

/*
 Класс A содержит:
 - один static-блок (выполняется один раз при первой загрузке класса)
 - два обычных блока (выполняются при создании каждого объекта)
 - конструктор
 - поле id с инициализацией
*/
class A {

    {
        System.out.println("logic (1) id= " + this.id);
    }

    static {
        System.out.println("static logic");
    }

    private int id = 1;

    public A(int id) {
        this.id = id;
        System.out.println("ctor id= " + id);
    }

    {
        System.out.println("logic (2) id= " + id);
    }
}

/*
Пошаговое объяснение порядка выполнения:

1. При первом обращении к классу A (в new A(100)) выполняется static-блок
   вывод: "static logic"

2. Затем создаётся объект класса A:
   - Память под объект выделяется, все поля получают значения по умолчанию (id = 0).
   - Выполняется первый логический блок:
      "logic (1) id= 0" (на этом этапе поле id ещё не инициализировано)
   - Инициализируются поля (id = 1).
   - Выполняется второй логический блок:
      "logic (2) id= 1"
   - Затем вызывается конструктор:
      "ctor id= 100" (полю присваивается новое значение 100)

3. Итоговый порядок вывода:

static logic
logic (1) id= 0
logic (2) id= 1
ctor id= 100
*/
