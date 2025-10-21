package homework;

import java.util.Scanner;

public class NameLoader {
    private final Scanner sc;

    public NameLoader(Scanner sc) {
        this.sc = sc;
    }

    public String loadName(){
        System.out.print("Enter your name: ");
        return sc.nextLine().trim();
    }

}
