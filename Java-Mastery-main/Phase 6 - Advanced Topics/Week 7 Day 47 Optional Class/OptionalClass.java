import java.util.*;

/**
 * Optional Class in Java
 * 
 * This program demonstrates:
 * - Optional.of(), empty()
 * - orElse(), orElseGet()
 * - Why use Optional
 * - Five examples of Optional usage
 */
public class OptionalClass {
    public static void main(String[] args) {
        // Program 1: Creating Optional instances
        System.out.println("Program 1 - Creating Optional instances:");
        
        // Creating Optional with a non-null value
        Optional<String> optionalWithValue = Optional.of("Hello World");
        System.out.println("Optional with value: " + optionalWithValue);
        
        // Creating Optional with null (this would throw an exception)
        // Optional<String> optionalWithNull = Optional.of(null); // Don't do this!
        
        // Creating Optional that might be null
        Optional<String> optionalMaybeNull = Optional.ofNullable("Hello");
        System.out.println("Optional with non-null: " + optionalMaybeNull);
        
        Optional<String> optionalNull = Optional.ofNullable(null);
        System.out.println("Optional with null: " + optionalNull);
        
        // Creating empty Optional
        Optional<String> emptyOptional = Optional.empty();
        System.out.println("Empty optional: " + emptyOptional);
        System.out.println();
        
        // Program 2: Using orElse() method
        System.out.println("Program 2 - Using orElse() method:");
        
        Optional<String> presentValue = Optional.of("Actual Value");
        String result1 = presentValue.orElse("Default Value");
        System.out.println("Present value orElse: " + result1);
        
        Optional<String> absentValue = Optional.empty();
        String result2 = absentValue.orElse("Default Value");
        System.out.println("Absent value orElse: " + result2);
        
        // orElse with null value
        Optional<String> nullOptional = Optional.ofNullable(null);
        String result3 = nullOptional.orElse("Fallback Value");
        System.out.println("Null optional orElse: " + result3);
        System.out.println();
        
        // Program 3: Using orElseGet() method
        System.out.println("Program 3 - Using orElseGet() method:");
        
        Optional<String> presentValue2 = Optional.of("Actual Value");
        String result4 = presentValue2.orElseGet(() -> "Computed Default");
        System.out.println("Present value orElseGet: " + result4);
        
        Optional<String> absentValue2 = Optional.empty();
        String result5 = absentValue2.orElseGet(() -> "Computed Default");
        System.out.println("Absent value orElseGet: " + result5);
        
        // Demonstrating lazy evaluation of orElseGet
        System.out.println("Demonstrating lazy evaluation:");
        Optional<String> presentOpt = Optional.of("Present");
        String result6 = presentOpt.orElseGet(() -> {
            System.out.println("This computation is NOT executed because value is present");
            return "Expensive Computation Result";
        });
        System.out.println("Result: " + result6);
        System.out.println();
        
        // Program 4: Using map() with Optional
        System.out.println("Program 4 - Using map() with Optional:");
        
        Optional<String> name = Optional.of("Alice");
        Optional<Integer> nameLength = name.map(String::length);
        System.out.println("Name: " + name + ", Length: " + nameLength);
        
        Optional<String> emptyName = Optional.empty();
        Optional<Integer> emptyNameLength = emptyName.map(String::length);
        System.out.println("Empty name: " + emptyName + ", Length: " + emptyNameLength);
        
        // Chaining map operations
        Optional<String> email = Optional.of("alice@example.com");
        Optional<String> domain = email.map(e -> e.split("@")[1]);
        System.out.println("Email: " + email + ", Domain: " + domain);
        System.out.println();
        
        // Program 5: Using filter() with Optional
        System.out.println("Program 5 - Using filter() with Optional:");
        
        Optional<Integer> number = Optional.of(10);
        Optional<Integer> evenNumber = number.filter(n -> n % 2 == 0);
        System.out.println("Number: " + number + ", Even filter: " + evenNumber);
        
        Optional<Integer> oddNumber = number.filter(n -> n % 2 != 0);
        System.out.println("Number: " + number + ", Odd filter: " + oddNumber);
        
        Optional<String> text = Optional.of("Hello");
        Optional<String> longText = text.filter(s -> s.length() > 10);
        System.out.println("Text: " + text + ", Long filter: " + longText);
        System.out.println();
        
        // Program 6: Using flatMap() with Optional
        System.out.println("Program 6 - Using flatMap() with Optional:");
        
        Optional<User> user = Optional.of(new User("John", "john@example.com"));
        Optional<String> emailDomain = user.flatMap(User::getEmail)
                                         .map(emailAddr -> emailAddr.split("@")[1]);
        System.out.println("User email domain: " + emailDomain);
        
        Optional<User> noEmailUser = Optional.of(new User("Jane", null));
        Optional<String> noDomain = noEmailUser.flatMap(User::getEmail)
                                             .map(emailAddr -> emailAddr.split("@")[1]);
        System.out.println("User without email domain: " + noDomain);
        System.out.println();
        
        // Program 7: Using ifPresent() with Optional
        System.out.println("Program 7 - Using ifPresent() with Optional:");
        
        Optional<String> value = Optional.of("Hello Optional!");
        value.ifPresent(v -> System.out.println("Value is present: " + v));
        
        Optional<String> emptyValue = Optional.empty();
        emptyValue.ifPresent(v -> System.out.println("This won't be printed"));
        System.out.println("Empty value processing completed");
        System.out.println();
        
        // Program 8: Practical example - Safe division
//        System.out.println("Program 8 - Practical example - Safe division:");
//
//        Optional<Double> result = safeDivide(10, 2);
//        System.out.println("10 / 2 = " + result.orElse(null));
//
//        Optional<Double> result2;
//        result2 = safeDivide(10, 0);
//        System.out.println("10 / 0 = " + result2.orElse(null));
//
//        result2.ifPresentOrElse(
//            valueResult -> System.out.println("Division successful: " + valueResult),
//            () -> System.out.println("Division failed - cannot divide by zero")
//        );
//        System.out.println();
        
        // Program 9: Finding element in a collection safely
        System.out.println("Program 9 - Finding element in collection safely:");
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana");
        
        Optional<String> foundName = findByName(names, "Charlie");
        System.out.println("Found Charlie: " + foundName.orElse("Not found"));
        
        Optional<String> missingName = findByName(names, "Eve");
        System.out.println("Found Eve: " + missingName.orElse("Not found"));
        
        // Processing the found name
        foundName.ifPresent(nameFound -> System.out.println("Processing found name: " + nameFound.toUpperCase()));
        System.out.println();
        
        // Program 10: Chaining Optionals for complex operations
        System.out.println("Program 10 - Chaining Optionals for complex operations:");
        
        Optional<String> complexResult = Optional.of("Hello World!")
                                               .filter(s -> s.length() > 5)
                                               .map(String::toUpperCase)
                                               .map(s -> s.replace("!", ""))
                                               .filter(s -> s.contains("WORLD"));
        
        System.out.println("Complex operation result: " + complexResult);
        
        // Example with failing chain
        Optional<String> failedChain = Optional.of("Hi!")
                                              .filter(s -> s.length() > 5) // This will fail
                                              .map(String::toUpperCase);
        
        System.out.println("Failed chain result: " + failedChain);
        
        // Additional examples
        
        // Example 1: Parsing integer safely
        System.out.println("\nAdditional Example 1 - Safe integer parsing:");
        Optional<Integer> parsed1 = parseIntSafely("123");
        Optional<Integer> parsed2 = parseIntSafely("abc");
        System.out.println("Parsing '123': " + parsed1.orElse(null));
        System.out.println("Parsing 'abc': " + parsed2.orElse(null));
    }
    
    // Safe division method returning Optional
    public static Optional<Double> safeDivide(double dividend, double divisor) {
        if (divisor == 0) {
            return Optional.empty();
        }
        return Optional.of(dividend / divisor);
    }
    
    // Find name in list returning Optional
    public static Optional<String> findByName(List<String> names, String target) {
        return names.stream()
                   .filter(name -> name.equalsIgnoreCase(target))
                   .findFirst();
    }
    
    // Safe integer parsing
    public static Optional<Integer> parseIntSafely(String str) {
        try {
            return Optional.of(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
    
    // Inner class for User example
    static class User {
        private final String name;
        private final String email;
        
        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
        
        public String getName() {
            return name;
        }
        
        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }
    }
}