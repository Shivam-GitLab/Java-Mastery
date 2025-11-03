import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileFound03 {
    public static void main(String[] args) throws FileNotFoundException {
        //
        FileReader fileReader = new FileReader("hlo.txt");
     /*   java: unreported exception java.io.FileNotFoundException;
        must be caught or declared to be thrown*/
/*        The error Unhandled exception: java.io.FileNotFoundException means
        that your Java code is trying to open or access a file that either:*/
/*        try{
            FileReader fileReader = new FileReader("hlo.txt");
        }catch (Exception e){
            System.out.println(e);
//            java.io.FileNotFoundException: hlo.txt (The system cannot find the file specified)
        }*/
    }
}
