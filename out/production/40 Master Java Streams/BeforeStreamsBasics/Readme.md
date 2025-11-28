Complete Guide to Lambda Expressions in Java Lambda expressions were
introduced in Java 8 to enable functional programming and reduce the
verbosity of anonymous classes. They allow concise, functional-style
code that is both readable and expressive.

## What is a Lambda Expression?

A lambda expression is an anonymous function---a function without a name
and access modifiers. It is always used to implement a functional
interface (an interface with exactly one abstract method).

### Functional Interface Example

``` java
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}
```

## Lambda Expression Syntax

``` java
(parameters) -> { body }
```

-   **Parameters**: Input to the lambda.
-   **Arrow Token (-\>)**: Separates parameters from body.
-   **Body**: The code to execute.

## Why Use Lambda Expressions?

-   **Conciseness**: Reduces boilerplate code for anonymous classes.
-   **Improved readability**: Logic is the focus, not structure.
-   **Functional programming**: Enables higher-order functions.
-   **Stream API integration**: Works seamlessly with Java Streams.

## Syntax Examples

### 1. Lambda with No Parameters

``` java
Runnable runnable = () -> System.out.println("Hello, World!");
runnable.run();
```

### 2. Lambda with One Parameter

``` java
Greeting greeting = name -> System.out.println("Hello, " + name + "!");
greeting.sayHello("Alice");
```

### 3. Lambda with Multiple Parameters

``` java
Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
System.out.println(comparator.compare(5, 3)); // Output: 1
```

### 4. Lambda with Block Body

``` java
Greeting greeting = name -> {
    String message = "Hello, " + name + "!";
    System.out.println(message);
};
greeting.sayHello("Bob");
```

## Functional Interfaces and Lambda Expressions

Java 8 introduced several functional interfaces in the
`java.util.function` package:

-   **Predicate`<T>`{=html}**: `boolean test(T t)`

``` java
Predicate<Integer> isEven = number -> number % 2 == 0;
System.out.println(isEven.test(4)); // Output: true
```

-   **Consumer`<T>`{=html}**: `void accept(T t)`

``` java
Consumer<String> print = message -> System.out.println(message);
print.accept("Hello, Consumer!");
```

-   **Function\<T, R\>**: `R apply(T t)`

``` java
Function<String, Integer> stringLength = str -> str.length();
System.out.println(stringLength.apply("Lambda")); // Output: 6
```

-   **Supplier`<T>`{=html}**: `T get()`

``` java
Supplier<Double> randomValue = () -> Math.random();
System.out.println(randomValue.get());
```

-   **BiFunction\<T, U, R\>**: `R apply(T t, U u)`

``` java
BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
System.out.println(add.apply(3, 7)); // Output: 10
```

## Using Lambda Expressions with Collections

### 1. Sorting a List

``` java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.sort((a, b) -> a.compareTo(b));
names.forEach(System.out::println);
```

### 2. Filtering a List

``` java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println); // Output: 2, 4
```

### 3. Mapping a List

``` java
List<String> words = Arrays.asList("lambda", "stream", "function");
List<Integer> lengths = words.stream()
                             .map(String::length)
                             .collect(Collectors.toList());
System.out.println(lengths); // Output: [6, 6, 8]
```

## Capturing Variables in Lambda Expressions

Lambdas can capture variables from their enclosing scope, but such
variables must be effectively final.

``` java
String prefix = "Hello, ";
Greeting greeting = name -> System.out.println(prefix + name);
greeting.sayHello("Lambda");
```

## Limitations of Lambda Expressions

-   Cannot have explicit names (anonymous only).
-   Can only implement functional interfaces (single abstract method).
-   Not suited for large, complex operations.

## Real-World Use Cases

### Event Handling

``` java
button.setOnClickListener(event -> System.out.println("Button clicked!"));
```

### Parallel Processing

``` java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.parallelStream()
       .map(n -> n * 2)
       .forEach(System.out::println);
```

### Custom Functional Interfaces

``` java
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

MathOperation addition = (a, b) -> a + b;
System.out.println(addition.operate(5, 3)); // Output: 8
```

## Conclusion

Lambda expressions bring the power of functional programming to Java,
reducing boilerplate code and enabling clean, readable, and maintainable
solutions. Combined with Java's functional interfaces, they make code
more flexible and powerful.
