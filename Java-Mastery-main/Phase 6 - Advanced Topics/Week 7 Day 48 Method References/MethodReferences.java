import java.util.*;
import java.util.function.*;

/**
 * Method References in Java
 * 
 * This program demonstrates:
 * - Syntax: ClassName::methodName
 * - Static method references
 * - Instance method references
 * - Constructor references
 * - Five examples of method references
 */
public class MethodReferences {
    public static void main(String[] args) {
        // Program 1: Static method reference
        System.out.println("Program 1 - Static method reference:");
        
        List<String> words = Arrays.asList("banana", "apple", "cherry", "date", "elderberry");
        System.out.println("Original list: " + words);
        
        // Sort using static method reference to String.CASE_INSENSITIVE_ORDER
        words.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Sorted case-insensitive: " + words);
        
        // Using static method reference for string length
        List<String> fruits = Arrays.asList("apple", "banana", "kiwi", "strawberry");
        List<Integer> lengths = fruits.stream()
                                    .map(String::length)  // Method reference equivalent to s -> s.length()
                                    .collect(java.util.stream.Collectors.toList());
        System.out.println("Fruit lengths: " + lengths);
        
        // Using Math.max with method reference
        BinaryOperator<Integer> maxFinder = Math::max;
        System.out.println("Max of 15 and 25: " + maxFinder.apply(15, 25));
        System.out.println();
        
        // Program 2: Instance method reference with specific object
        System.out.println("Program 2 - Instance method reference with specific object:");
        
        String prefix = "Hello ";
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // Using method reference to instance method of specific object
        List<String> greetings = names.stream()
                                    .map(prefix::concat)  // Equivalent to name -> prefix.concat(name)
                                    .collect(java.util.stream.Collectors.toList());
        System.out.println("Greetings: " + greetings);
        
        // Using StringBuilder instance method
        StringBuilder builder = new StringBuilder("Prefix: ");
        List<String> items = Arrays.asList("item1", "item2", "item3");
        StringBuilder result = new StringBuilder(builder);  // Need new instance
        
        // For each with method reference
        items.forEach(item -> result.append(item).append(", "));
        System.out.println("Built string: " + result.toString());
        System.out.println();
        
        // Program 3: Instance method reference with arbitrary object
        System.out.println("Program 3 - Instance method reference with arbitrary object:");
        
        List<String> mixedCase = Arrays.asList("HeLLo", "WORLD", "Java", "PROGRAMMING");
        System.out.println("Mixed case: " + mixedCase);
        
        // Convert to lowercase using method reference
        List<String> lowerCase = mixedCase.stream()
                                        .map(String::toLowerCase)  // Method reference to instance method
                                        .collect(java.util.stream.Collectors.toList());
        System.out.println("Lowercase: " + lowerCase);
        
        // Check if strings start with 'J'
        List<String> javaWords = mixedCase.stream()
                                        .filter(s -> s.startsWith("J"))
                                        .map(String::toLowerCase)
                                        .collect(java.util.stream.Collectors.toList());
        System.out.println("Words starting with 'J' (lowercase): " + javaWords);
        System.out.println();
        
        // Program 4: Constructor reference
        System.out.println("Program 4 - Constructor reference:");
        
        List<String> stringList = Arrays.asList("apple", "banana", "cherry");
        
        // Create ArrayList from stream using constructor reference
        ArrayList<String> newArrayList = stringList.stream()
                                                 .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Created ArrayList: " + newArrayList);
        
        // Using constructor reference with map
        List<Integer> lengths2 = stringList.stream()
                                         .map(String::length)
                                         .map(Integer::new)  // Constructor reference (not very useful here, but syntactically correct)
                                         .collect(java.util.stream.Collectors.toList());
        System.out.println("Lengths: " + lengths2);
        
        // More practical example: creating objects from strings
        List<String> numberStrings = Arrays.asList("10", "20", "30", "40");
        List<Integer> numbers = numberStrings.stream()
                                           .map(Integer::valueOf)  // Static method reference
                                           .collect(java.util.stream.Collectors.toList());
        System.out.println("Parsed numbers: " + numbers);
        System.out.println();
        
        // Program 5: Method reference in sorting
        System.out.println("Program 5 - Method reference in sorting:");
        
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("Diana", 28)
        );
        
        System.out.println("Before sorting: " + people);
        
        // Sort by name using method reference
        people.sort(Comparator.comparing(Person::getName));
        System.out.println("After sorting by name: " + people);
        
        // Sort by age using method reference
        List<Person> peopleByAge = new ArrayList<>(people);
        peopleByAge.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("Sorted by age: " + peopleByAge);
        System.out.println();
        
        // Program 6: Using method references with consumers
        System.out.println("Program 6 - Method references with consumers:");
        
        List<String> actions = Arrays.asList("Eating", "Sleeping", "Coding", "Learning");
        
        // Using System.out::println method reference
        System.out.println("Actions using System.out::println:");
        actions.forEach(System.out::println);
        
        // Using method reference to a custom method
        actions.forEach(MethodReferences::logAction);
        System.out.println();
        
        // Program 7: Method references with predicates
        System.out.println("Program 7 - Method references with predicates:");
        
        List<String> emails = Arrays.asList("user@example.com", "admin@test.org", "invalid-email", "support@company.co");
        
        // Filter valid emails using a custom method
        List<String> validEmails = emails.stream()
                                       .filter(MethodReferences::isValidEmail)
                                       .collect(java.util.stream.Collectors.toList());
        System.out.println("Valid emails: " + validEmails);
        
        // Filter non-empty strings
        List<String> withEmpty = Arrays.asList("hello", "", "world", "", "java");
        List<String> nonEmpty = withEmpty.stream()
                                      .filter(String::isEmpty)  // This filters empty strings
                                      .collect(java.util.stream.Collectors.toList());
        System.out.println("Empty strings: " + nonEmpty);
        
        // Actually filter non-empty strings
        List<String> trulyNonEmpty = withEmpty.stream()
                                            .filter(s -> !s.isEmpty())  // Using lambda since no method exists for "isNotEmpty"
                                            .collect(java.util.stream.Collectors.toList());
        System.out.println("Non-empty strings: " + trulyNonEmpty);
        System.out.println();
        
        // Program 8: Method references with functions
        System.out.println("Program 8 - Method references with functions:");
        
        List<String> sentences = Arrays.asList("Hello World", "Java Programming", "Method References");
        
        // Convert to word counts
        List<Integer> wordCounts = sentences.stream()
                                         .map(s -> s.split(" ").length)  // Lambda for splitting and counting
                                         .collect(java.util.stream.Collectors.toList());
        System.out.println("Word counts: " + wordCounts);
        
        // Using a custom function method
        List<Integer> customTransforms = sentences.stream()
                                               .map(MethodReferences::customStringLength)
                                               .collect(java.util.stream.Collectors.toList());
        System.out.println("Custom length transforms: " + customTransforms);
        System.out.println();
        
        // Program 9: Method references in complex streams
        System.out.println("Program 9 - Method references in complex streams:");
        
        List<List<String>> listOfLists = Arrays.asList(
            Arrays.asList("apple", "apricot"),
            Arrays.asList("banana", "blueberry"),
            Arrays.asList("cherry", "cranberry")
        );
        
        System.out.println("Original nested list: " + listOfLists);
        
        // Flatten and convert to uppercase
        List<String> flattened = listOfLists.stream()
                                          .flatMap(List::stream)  // Method reference to stream() on each list
                                          .map(String::toUpperCase)
                                          .collect(java.util.stream.Collectors.toList());
        System.out.println("Flattened and uppercased: " + flattened);
        System.out.println();
        
        // Program 10: Method references with Optional
        System.out.println("Program 10 - Method references with Optional:");
        
        Optional<String> optionalString = Optional.of("hello world");
        
        // Chain operations using method references
        Optional<String> optionalResult = optionalString
                                 .map(String::trim)
                                 .filter(s -> s.length() > 5)
                                 .map(String::toUpperCase);
        System.out.println("Optional result: " + optionalResult);
        
        // Empty optional chain
        Optional<String> emptyOptional = Optional.ofNullable(null);
        Optional<String> emptyResult = emptyOptional
                                     .map(String::trim)
                                     .filter(s -> s.length() > 5)
                                     .map(String::toUpperCase);
        System.out.println("Empty optional result: " + emptyResult);
    }
    
    // Static method for logging
    public static void logAction(String action) {
        System.out.println("[LOG] Performing action: " + action);
    }
    
    // Static method for email validation
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.length() > 5;
    }
    
    // Static method for custom transformation
    public static int customStringLength(String str) {
        return str.length() + 10;  // Add 10 to length
    }
    
    // Inner class for Person example
    static class Person {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() {
            return name;
        }
        
        public int getAge() {
            return age;
        }
        
        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }
}