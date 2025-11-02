public class Solution {
    public static void main(String[] args) {
        int[] numerators = {10, 200, 30, 40};
        int[] denominators = {1, 2, 0, 4};

        for (int i = 0; i < numerators.length; i++) {
            System.out.println(divide(numerators[i], denominators[i]));
        }
        System.out.println("Good Job!");
    }
    // ===============

    public static int divide(int a, int b) {
        // return a / b;
        // Program will crash dring runtime errors
        /*
         * Output = Runtime Error
         * 10
         * 100
         * Exception in thread "main" java.lang.ArithmeticException: / by zero
         * at Solution.divide(Solution.java:13)
         * at Solution.main(Solution.java:7)
         */

/*        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Not");
            return -1;
        } finally {
            System.out.println("Terminated");
        }*/

        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Not");
            return -1;
        } finally {
            System.out.println("Terminated");
        }
    }
    /*
     * Program Will Crash During Runtime Errors
     * Runtime Error
     * 10
     * 100
     * Exception in thread "main" java.lang.ArithmeticException: / by zero
     * at Solution.divide(Solution.java:14)
     * at Solution.main(Solution.java:8)
     */
    /*
     * Exception i san event that distrupts the normal flow of the program.
     * It is an object which is thrown at runtime
     */
}

/*
public static int divide(int a, int b) {
    try {
        Student student = null;
        student.setId(123);  // This will cause NullPointerException
        System.out.println(student.getId());
        return a / b;
    }
    catch (NullPointerException e) {
        System.out.println("Null pointer exception :(");
        return -1;
    }
    catch (ArithmeticException e) {
        System.out.println("Arithmetic exception :(");
        return -1;
    }
    catch (RuntimeException e) {
        System.out.println("Runtime exception :(");
        return -1;
    }
    catch (Exception e) {
        System.out.println(e);
        return -1;
    }
}

public static int divide(int a, int b) {
    try {
        return a / b;
    }
    catch (ArithmeticException | NullPointerException e) {
        System.out.println("Arithmetic or NullPointer exception :(");
        return -1;
    }
    catch (Exception e) {
        System.out.println(e);
        return -1;
    }
}


public static int divide(int a, int b) {
    try {
        return a / b;
    }
//    catch (ArithmeticException | NullPointerException e) {
//    System.out.println("Arithmetic or RuntimeException :(");
//Both ArithmeticException and NullPointerException are subclasses of RuntimeException.

//So your message "Arithmetic or RuntimeException :(" is misleading —
// it should not mention RuntimeException because you’re not catching that directly.

//Syntactically, your code is 100% valid — no compile-time error.
//
//Logically, just fix the message for clarity.

    catch (ArithmeticException | NullPointerException e) {
        System.out.println("Arithmetic or RuntimeException :(");
        return -1;
    }
    catch (Exception e) {
        System.out.println(e);
        return -1;
    }
}

*/

/*
✅ Correct version:
public static int divide(int a, int b) {
    try {
        return a / b;
    }
    catch (ArithmeticException | NullPointerException e) {
        System.out.println("Arithmetic or NullPointer exception :(");
        return -1;
    }
    catch (Exception e) {
        System.out.println(e);
        return -1;
    }
}

🧠 Explanation:

Multi-catch (|) means “catch either of these exceptions with the same logic”.

It’s valid because ArithmeticException and NullPointerException are not in a parent–child relationship.

The catch (Exception e) handles any other remaining checked or runtime exceptions.*/
