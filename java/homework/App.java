package homework;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = InitScanner.init();
        NameLoader loader = new NameLoader(sc);
        String name = loader.loadName();

        PrintH printH = new PrintH();
        PrintE printE = new PrintE();
        PrintL printL = new PrintL();
        PrintL2 printL2 = new PrintL2();
        PrintO printO = new PrintO();
        PrintComma printComma = new PrintComma();

        printH.print();
        printE.print();
        printL.print();
        printL2.print();
        printO.print();
        printComma.print();

        SpaceSingleton spaceSingleton = SpaceSingleton.getInstance();
        spaceSingleton.print();

        System.out.println(name);
    }

    @Deprecated
    private static void helloName(){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine().trim();
        System.out.println("Hello, " + name);
    }
}
