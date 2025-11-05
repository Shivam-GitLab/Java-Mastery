package BeforeStreamsBasics;
/*
 Java 8 QA Interview Questions
 Q: What are all features of Java 8 did you use?
 1. Functional Interface (include default & static method)
 ans - @FunctionalInterface
       interface MyFunctionalInterface {
           void myMethod();

           default void defaultMethod() {
               System.out.println("This is a default method");
           }

           static void staticMethod() {
               System.out.println("This is a static method");
           }
       }
 2. Lambda Expression
 3. Stream
 4. CompletableFuture
 5. Java DateTime API
*/

import java.util.*;
import java.util.function.*;
/* Collections → Iteration → Functional Interfaces → Lambda → Streams*/
public class Java8Demo {


    public static void main(String[] args) {
        // Streams
        // Java 8 --> minimal code, functional programing
        // Java 8 --> lambda expression, Streams, Date & Time API
        // lambda expression => is an anonymous function
        // (no name, no return type, no access modifier)


        // Thread t1 = new Thread(new Task());

        // new Task() Replace with lambda expression
        // lambda expression use for implement functional interface
        /*
        => Lambda Expression Syntax
          (parameters) -> { body }
          Parameters: Input to the lambda.
          Arrow Token (->): Separates parameters from body.
          Body: The code to execute.
        */
        Thread t1 = new Thread(() -> {
            System.out.println("Hello");
        });

//  Custom Functional Interface
//        MathOperation sumOperation = new MathOperation() {
//            @Override
//            public int operate(int a, int b) {
//                return a + b;
//            }
//        MathOperation sumOperation = (a, b) -> a + b;
        MathOperation sumOperation = (int a, int b) -> a + b;
//        MathOperation sumOperation = Integer::sum;
        System.out.println("Sum Operation");
        int res = sumOperation.operate(1, 2);
        System.out.println(" Sum = "+res);

        MathOperation subtractOperation = (a, b) -> a - b;

        MathOperation multiplyOperation = (a, b) -> a * b;
//      MathOperation divideOperation = (a, b) -> b != 0 ? a / b : 0;
        MathOperation divideOperation = (a, b) -> a / b;
        MathOperation max = Math::max;
        MathOperation min = Math::min;

        System.out.println("Sum: " + sumOperation.operate(5, 3));
        System.out.println("Subtract: " + subtractOperation.operate(5, 3));
        System.out.println("Multiply: " + multiplyOperation.operate(5, 3));
        System.out.println("Divide: " + divideOperation.operate(5, 3));
        System.out.println("Max: " + max.operate(5, 3));
        System.out.println("Min: " + min.operate(5, 3));

//   =>  What are all functional interface introduced in java 8 ?
       /* 01. Predicate
        Represents a function that accepts one argument
          and returns a boolean value (true/false).
             =>    Package: java.util.function*/
        // Predicate --> Functional interface (Boolean valued function)
        // => Holds Condition
        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        System.out.println(isEven.test(4));
        Predicate<String> isWordStartingWithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isWordEndingWithT = x -> x.toLowerCase().endsWith("t");
        Predicate<String> and = isWordStartingWithA.and(isWordEndingWithT);
        System.out.println(and.test("Akshay"));

 /*       02. Function
        Represents a function that accepts one argument, processes it, and produces a result.
              =>  Function<T, R>
        Takes 1 argument of type T.
        Returns a result of type R.
              =>  Package: java.util.function*/

        // Function --> work for you
        // Function<T, R> --> T is an input type, R is an output type
        Function<Integer, Integer> doubleIt = x -> 2 * x;
        Function<Integer, Integer> tripleIt = x -> 3 * x;
        System.out.println(doubleIt.andThen(tripleIt).apply(20));
        System.out.println(tripleIt.andThen(doubleIt).apply(20)); // same
        System.out.println(doubleIt.compose(tripleIt).apply(20)); // same
        System.out.println(doubleIt.apply(100));

//        So whatever input you give, it returns the same output.
        Function<Integer, Integer> identity = Function.identity();
        Integer res2 = identity.apply(500);
        System.out.println("identity "+res2);

/*        03. Consumer
        Represents an operation that accepts a single input parameter and returns no result.
                Package: java.util.function*/
       //  Consumer <Integer> print = x -> System.out.println(x);
        Consumer<Integer> print = System.out::println;
        print.accept(51);
        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> printList = x -> {
            for (int i : x) {
                System.out.print(i+" ");
            }
        };
        printList.accept(list);
        System.out.println();



  /*      4. Supplier
        Represents a supplier of results.
        Takes no input but produces a result.
        Package: java.util.function*/

        // Supplier => Not take only Give
        Supplier<String> giveHelloWorld = () -> "Hello World";
        System.out.println(giveHelloWorld.get());


// ============>>>>>====================================<<<<<<=======================================
        // Combined example
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
//  Consumer<Integer> consumer = x -> System.out.println(x);
        Consumer<Integer> consumer = System.out::println;
//        Supplier<Integer> supplier = () -> 10;
        Supplier<Integer> supplier = () -> 9;

        System.out.println("Combined Example");
        if (predicate.test(supplier.get())) {
            System.out.println("Condition is true");
            consumer.accept(function.apply(supplier.get()));
        }
        else {
            System.out.println("Condition is false");
            consumer.accept(function.apply(supplier.get()));
        }

        // BiPredicate, BiConsumer, BiFunction
        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
        System.out.println(isSumEven.test(5, 5));

//        BiConsumer
        BiConsumer<Integer, String> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };

//        BiFunction
        BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();
        System.out.println(biFunction.apply("a", "bc"));

        // UnaryOperator, BinaryOperator
        UnaryOperator<Integer> a = x -> 2 * x;
/*      @FunctionalInterface
        public interface UnaryOperator<T> extends Function<T, T> {


//             * Returns a unary operator that always returns its input argument.
//             *
//             * @param <T> the type of the input and output of the operator
//             * @return a unary operator that always returns its input argument

            static <T> java.util.function.UnaryOperator<T> identity() {
                return t -> t;
            }
        }*/
        BinaryOperator<Integer> b = Integer::sum;
//        BinaryOperator<Integer> b = (x, y) -> x + y;
/*        @FunctionalInterface
        public interface BinaryOperator<T> extends BiFunction<T,T,T> {
//
//             * Returns a {@link java.util.function.BinaryOperator} which returns the lesser of two elements
//             * according to the specified {@code Comparator}.
//             *
//             * @param <T> the type of the input arguments of the comparator
//             * @param comparator a {@code Comparator} for comparing the two values
//             * @return a {@code BinaryOperator} which returns the lesser of its operands,
//             *         according to the supplied {@code Comparator}
//             * @throws NullPointerException if the argument is null

            public static <T> java.util.function.BinaryOperator<T> minBy(Comparator<? super T> comparator) {
                Objects.requireNonNull(comparator);
                return (a, b) -> comparator.compare(a, b) <= 0 ? a : b;
            }*/


        // Method reference --> use a method without invoking & in place of lambda expression
        List<String> students1 = Arrays.asList("Ram", "Shyam", "Shanghai");
        List<String> students2 = Arrays.asList("A", "B", "C");
//        students.forEach(x -> System.out.println(x));
        students1.forEach(System.out::println);
        students2.forEach(System.out::println);

        // Constructor reference
        List<String> names = Arrays.asList("A", "B", "C");
//        List<MobilePhone> mobilePhoneList = names.stream().map(MobilePhone::new).collect(Collectors.toList());
        List<MobilePhone> mobilePhoneList = names.stream().map(MobilePhone::new).toList();
    }
}

class MobilePhone {
    String name;
    public MobilePhone(String name) {
        this.name = name;
    }
}

@FunctionalInterface
interface MathOperation {
    //    int operate(int a, int b);
    public abstract int operate(int a, int b);

    public default void print() {
        System.out.println("This is a default method");
    }

    public static void staticMethod() {
        System.out.println("This is a static method");
    }
}

class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello");
    }

    // (no name, no return type, no access modifier)
    /*  Add Arrow ->
    () -> {
        System.out.println("Hello");
    }*/

}
