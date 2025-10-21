package homework;

public class SpaceSingleton implements Printable{
    private static SpaceSingleton instance;
    private SpaceSingleton(){}

    public static SpaceSingleton getInstance(){
        if (instance == null){
            instance = new SpaceSingleton();
            return instance;
        }
        return instance;
    }

    private void printSpace(){
        System.out.print(" ");
    }


    @Override
    public void print() {
        printSpace();
    }
}
