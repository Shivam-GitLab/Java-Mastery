import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
public class ThrowsDemo {
    public static void main(String[] args) throws IOException {
        method2();
        System.out.println("Hello");
    }

    public static void method2() throws FileNotFoundException {
        method1();
    }

    public static void method1() throws FileNotFoundException {
        FileReader fileReader = new FileReader("a.txt");
    }
}
