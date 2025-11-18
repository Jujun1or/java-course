package homework;

/*
Практика по теме: Вложенные классы в интерфейсе (static nested class)
*/

public class NestedInInterfacePractice {

    public static void main(String[] args) {

        System.out.println("=== Пример вызова вложенного класса внутри интерфейса ===");

        // Создание экземпляра вложенного класса интерфейса
        Tools.Logger logger = new Tools.Logger();
        logger.log("Сообщение из вложенного класса интерфейса");

        // Вызов другого вложенного класса
        Tools.Helper helper = new Tools.Helper();
        helper.help();
    }
}

/*
Интерфейс может содержать:
- вложенные классы
- вложенные интерфейсы
- вложенные enum
- вложенные записи (record)

Вложенный класс в интерфейсе всегда ведёт себя как static nested class,
даже без ключевого слова static.
*/
interface Tools {

    /*
    Вложенный класс Logger.
    Он автоматически считается static nested class.
    */
    class Logger {
        public void log(String message) {
            System.out.println("Logger: " + message);
        }
    }

    /*
    Ещё один пример вложенного класса.
    */
    class Helper {
        public void help() {
            System.out.println("Helper: выполнение вспомогательных действий");
        }
    }
}
