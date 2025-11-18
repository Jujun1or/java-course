package homework;

/*
Пример собственного исключения.
*/

public class MyFirstExceptionPractice {

    public static void main(String[] args) {
        try {
            validateAge(-1);  // генерируем собственное исключение
        } catch (MyFirstException ex) {
            System.out.println("Поймано наше исключение: " + ex.getMessage());
        }
    }

    // Метод, который генерирует наше собственное исключение
    public static void validateAge(int age) throws MyFirstException {
        if (age < 0) {
            throw new MyFirstException("Возраст не может быть отрицательным");
        }
    }
}

/*
Собственное исключение.
Обычно определяют три конструктора:
- без аргументов;
- с сообщением;
- с сообщением и причиной.
*/

class MyFirstException extends Exception {

    public MyFirstException() {
        super();
    }

    public MyFirstException(String message) {
        super(message);
    }

    public MyFirstException(String message, Throwable cause) {
        super(message, cause);
    }
}
