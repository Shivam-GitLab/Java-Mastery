public class Main02 {

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

    public static void main(String[] args) {
        int[] numerators = {10, 200, 30, 40};
        int[] denominators = {2, 0, 5, 10}; // example denominators

//        for (int i = 0; i < numerators.length; i++) {
        for (int i = 0; i < 10; i++) {
            try {
                int result = divide(numerators[i], denominators[i]);
                System.out.println("Result: " + result);
            }
            catch (Exception e) {
                System.out.println("Exception while dividing: " + e);
            }
        }

        System.out.println("Good job!");
    }
}
