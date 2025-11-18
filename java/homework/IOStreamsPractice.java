package homework;

/*
Практика по теме: байтовые потоки ввода-вывода (InputStream / OutputStream)
*/

import java.io.*;

public class IOStreamsPractice {

    public static void main(String[] args) {

        demoRead();

        demoWrite();

        explainReaderWriter();

        demoAutoCloseable();
    }


    /*
     Практика #1
     Демонстрация метода read() на основе FileInputStream.

     read() читает:
     - один байт (0–255)
     - возвращает -1, если достигнут конец файла
    */
    public static void demoRead() {

        // Создаём файл с тестовыми данными
        File file = new File("read_test.txt");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(65);    // 'A'
            fos.write(66);    // 'B'
            fos.write(67);    // 'C'
        } catch (IOException e) {
            System.out.println("Ошибка записи тестового файла: " + e);
        }

        // Читаем файл по одному байту
        try (FileInputStream fis = new FileInputStream(file)) {

            int b;
            while ((b = fis.read()) != -1) {
                System.out.println("Прочитан байт: " + b + " символ: " + (char) b);
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e);
        }
    }


    /*
     Практика #2
     Демонстрация метода write(int) на основе FileOutputStream.

     write(int) записывает один байт (младший байт аргумента).
    */
    public static void demoWrite() {

        File file = new File("write_test.txt");

        try (FileOutputStream fos = new FileOutputStream(file)) {

            // Записываем три байта
            fos.write(97);   // 'a'
            fos.write(98);   // 'b'
            fos.write(99);   // 'c'

            System.out.println("Файл успешно записан.");

        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e);
        }
    }


    /*
     Практика #3
     Зачем нужны Reader и Writer?

     Причина:
     - InputStream/OutputStream работают с байтами
     - Reader/Writer работают с символами (char)
     - обеспечивают корректную работу с кодировками

     Reader/Writer удобны для текстовых данных.
     InputStream/OutputStream — для бинарных данных.
    */
    public static void explainReaderWriter() {
        System.out.println("Reader и Writer нужны для работы с текстом и кодировками.");
        System.out.println("InputStream/OutputStream — это чистые байты.");
        System.out.println("Reader/Writer — это символы и поддержка Unicode.");
    }


    /*
     Практика #4
     Зачем нужен AutoCloseable?

     Интерфейс AutoCloseable позволяет объекту автоматически закрываться
     в конструкции try-with-resources.

     Это избавляет от необходимости вручную вызывать close() и защищает от утечек ресурсов.
    */
    public static void demoAutoCloseable() {

        /*
         FileInputStream реализует AutoCloseable,
         поэтому закрывается автоматически.
        */
        try (FileInputStream fis = new FileInputStream("read_test.txt")) {
            System.out.println("Файл открыт. После выхода из try поток закроется автоматически.");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }

        /*
         Создадим собственный класс, реализующий AutoCloseable.
        */
        try (MyResource res = new MyResource()) {
            res.work();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }
    }
}


/*
Пример собственного ресурса, который закрывается автоматически
в блоке try-with-resources.
*/
class MyResource implements AutoCloseable {

    public void work() {
        System.out.println("Ресурс работает.");
    }

    @Override
    public void close() {
        System.out.println("Ресурс автоматически закрыт.");
    }
}
