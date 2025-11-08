
public class MasterInterface {
    public static void main(String[] args) {
        System.out.println("Welcome to Mastering Java Interfaces!");
        
        // Example of using an interface
        MyInterface myInterface = new MyInterfaceImpl();
        myInterface.displayMessage01();
        myInterface.displayMessage02();
    }
}

interface MyInterface {
    void displayMessage01();
    void displayMessage02();
}

class MyInterfaceImpl implements MyInterface {
//    @Override
    public void displayMessage01() {
        System.out.println("Hello from MyInterface! 01");
    }
    public void displayMessage02() {
        System.out.println("Hello from MyInterface! 02");
    }

}
// This code demonstrates the use of interfaces in Java.
// It defines an interface `MyInterface` with a method `displayMessage`.