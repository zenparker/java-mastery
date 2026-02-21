import java.util.*;
import java.util.function.*;

/**
 * Lambda Expressions in Java
 * 
 * This program demonstrates:
 * - Syntax: (x, y) -> x + y
 * - Functional interfaces
 * - Ten examples of lambda expressions
 */
public class LambdaExpressions {
    public static void main(String[] args) {
        // Program 1: Basic lambda expression with Runnable
        System.out.println("Program 1 - Basic lambda expression with Runnable:");
        Runnable runnable = () -> System.out.println("Hello from lambda runnable!");
        Thread thread = new Thread(runnable);
        thread.start();
        
        // Execute immediately for demonstration
        runnable.run();
        System.out.println();
        
        // Program 2: Lambda with single parameter (no parentheses needed)
        System.out.println("Program 2 - Lambda with single parameter:");
        UnaryOperator<String> toUpperCase = str -> str.toUpperCase();
        System.out.println("Original: hello -> Converted: " + toUpperCase.apply("hello"));
        
        Predicate<String> isLong = str -> str.length() > 5;
        System.out.println("Is 'programming' longer than 5 chars? " + isLong.test("programming"));
        System.out.println("Is 'code' longer than 5 chars? " + isLong.test("code"));
        System.out.println();
        
        // Program 3: Lambda with multiple parameters
        System.out.println("Program 3 - Lambda with multiple parameters:");
        BinaryOperator<Integer> add = (x, y) -> x + y;
        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        
        System.out.println("Addition: 5 + 3 = " + add.apply(5, 3));
        System.out.println("Multiplication: 5 * 3 = " + multiply.apply(5, 3));
        
        // More complex example
        BiFunction<Integer, Integer, String> divideAndFormat = (dividend, divisor) -> {
            if (divisor == 0) {
                return "Cannot divide by zero";
            }
            return String.format("%.2f", (double) dividend / divisor);
        };
        
        System.out.println("Division: 10 / 3 = " + divideAndFormat.apply(10, 3));
        System.out.println("Division: 10 / 0 = " + divideAndFormat.apply(10, 0));
        System.out.println();
        
        // Program 4: Lambda with Consumer interface
        System.out.println("Program 4 - Lambda with Consumer interface:");
        Consumer<String> printConsumer = str -> System.out.println("Consumed: " + str);
        printConsumer.accept("Lambda example");
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(printConsumer); // Using consumer with forEach
        System.out.println();
        
        // Program 5: Lambda with Function interface
        System.out.println("Program 5 - Lambda with Function interface:");
        Function<String, Integer> stringLength = str -> str.length();
        Function<Integer, Integer> square = num -> num * num;
        
        String text = "Hello World";
        int length = stringLength.apply(text);
        int squaredLength = square.apply(length);
        
        System.out.println("Text: '" + text + "'");
        System.out.println("Length: " + length);
        System.out.println("Squared length: " + squaredLength);
        
        // Chaining functions
        Function<String, Integer> lengthSquared = stringLength.andThen(square);
        System.out.println("Length squared (chained): " + lengthSquared.apply(text));
        System.out.println();
        
        // Program 6: Lambda with Supplier interface
        System.out.println("Program 6 - Lambda with Supplier interface:");
        Supplier<Double> randomSupplier = () -> Math.random();
        Supplier<String> messageSupplier = () -> "Current timestamp: " + System.currentTimeMillis();
        
        System.out.println("Random number: " + randomSupplier.get());
        System.out.println("Random number: " + randomSupplier.get());
        System.out.println("Message: " + messageSupplier.get());
        System.out.println();
        
        // Program 7: Lambda with Predicate for filtering
        System.out.println("Program 7 - Lambda with Predicate for filtering:");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Original list: " + numbers);
        
        // Filter even numbers
        List<Integer> evenNumbers = filterList(numbers, n -> n % 2 == 0);
        System.out.println("Even numbers: " + evenNumbers);
        
        // Filter numbers greater than 5
        List<Integer> greaterThanFive = filterList(numbers, n -> n > 5);
        System.out.println("Numbers > 5: " + greaterThanFive);
        
        // Filter numbers in range 3-7
        List<Integer> inRange = filterList(numbers, n -> n >= 3 && n <= 7);
        System.out.println("Numbers in range [3,7]: " + inRange);
        System.out.println();
        
        // Program 8: Lambda with Comparator
        System.out.println("Program 8 - Lambda with Comparator:");
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("Diana", 28)
        );
        
        System.out.println("Before sorting: " + people);
        
        // Sort by age using lambda
        people.sort((p1, p2) -> p1.age - p2.age);
        System.out.println("After sorting by age: " + people);
        
        // Sort by name using lambda
        List<Person> peopleByName = new ArrayList<>(people);
        peopleByName.sort((p1, p2) -> p1.name.compareTo(p2.name));
        System.out.println("Sorted by name: " + peopleByName);
        System.out.println();
        
        // Program 9: Lambda in functional programming patterns
        System.out.println("Program 9 - Lambda in functional programming patterns:");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        
        // Map: transform each element
        List<Integer> doubled = mapList(nums, n -> n * 2);
        System.out.println("Original: " + nums);
        System.out.println("Doubled: " + doubled);
        
        // Reduce: combine all elements
        int sum = reduceList(nums, (acc, n) -> acc + n, 0);
        System.out.println("Sum: " + sum);
        
        // Combine map and filter
        List<Integer> processed = nums.stream()
            .filter(n -> n % 2 == 1) // Keep odd numbers
            .map(n -> n * n)         // Square them
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Odd numbers squared: " + processed);
        System.out.println();
        
        // Program 10: Method references (related to lambdas)
        System.out.println("Program 10 - Method references:");
        List<String> words = Arrays.asList("banana", "apple", "cherry", "date");
        
        System.out.println("Original: " + words);
        
        // Sort using method reference
        words.sort(String::compareTo);
        System.out.println("Sorted with method reference: " + words);
        
        // Transform using method reference
        List<String> upperCaseWords = mapList(words, String::toUpperCase);
        System.out.println("Uppercase: " + upperCaseWords);
        
        // Additional examples
        System.out.println("\nAdditional Examples:");
        
        // Example 1: Lambda for custom operations
        System.out.println("Example 1 - Custom operation:");
        TriFunction<Integer, Integer, Integer, Integer> customOp = (a, b, c) -> a * b + c;
        System.out.println("Custom operation (2 * 3 + 4): " + customOp.apply(2, 3, 4));
        
        // Example 2: Lambda for validation
        System.out.println("Example 2 - Validation:");
        Validator<String> emailValidator = email -> email.contains("@") && email.length() > 5;
        System.out.println("Valid email 'test@example.com': " + emailValidator.validate("test@example.com"));
        System.out.println("Valid email 'invalid': " + emailValidator.validate("invalid"));
    }
    
    // Generic method to filter a list using a predicate
    public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
    
    // Generic method to map a list using a function
    public static <T, R> List<R> mapList(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(mapper.apply(item));
        }
        return result;
    }
    
    // Generic method to reduce a list
    public static <T> T reduceList(List<T> list, BinaryOperator<T> accumulator, T identity) {
        T result = identity;
        for (T item : list) {
            result = accumulator.apply(result, item);
        }
        return result;
    }
    
    // Inner class for Person
    static class Person {
        String name;
        int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }
    
    // Functional interface for tri-function (three inputs, one output)
    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
    
    // Functional interface for validation
    @FunctionalInterface
    interface Validator<T> {
        boolean validate(T value);
    }
}