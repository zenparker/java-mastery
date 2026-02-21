import java.util.*;
import java.util.stream.Collectors;

/**
 * Streams API in Java
 * 
 * This program demonstrates:
 * - stream(), filter(), map()
 * - collect(), forEach()
 * - sorted(), distinct()
 * - Ten stream problems
 */
public class StreamsAPI {
    public static void main(String[] args) {
        // Program 1: Basic stream operations
        System.out.println("Program 1 - Basic stream operations:");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Original list: " + numbers);
        
        // Filter even numbers and collect them
        List<Integer> evenNumbers = numbers.stream()
                                         .filter(n -> n % 2 == 0)
                                         .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
        
        // Map to square of numbers
        List<Integer> squares = numbers.stream()
                                     .map(n -> n * n)
                                     .collect(Collectors.toList());
        System.out.println("Squares: " + squares);
        System.out.println();
        
        // Program 2: Stream with multiple operations
        System.out.println("Program 2 - Stream with multiple operations:");
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig");
        
        System.out.println("Original words: " + words);
        
        // Filter words with length > 4, convert to uppercase, sort them
        List<String> processedWords = words.stream()
                                          .filter(word -> word.length() > 4)
                                          .map(String::toUpperCase)
                                          .sorted()
                                          .collect(Collectors.toList());
        System.out.println("Filtered, uppercased, and sorted: " + processedWords);
        System.out.println();
        
        // Program 3: Stream with distinct operation
        System.out.println("Program 3 - Stream with distinct operation:");
        List<Integer> withDuplicates = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 1, 6);
        System.out.println("List with duplicates: " + withDuplicates);
        
        List<Integer> uniqueNumbers = withDuplicates.stream()
                                                  .distinct()
                                                  .sorted()
                                                  .collect(Collectors.toList());
        System.out.println("Distinct and sorted: " + uniqueNumbers);
        System.out.println();
        
        // Program 4: Stream with sorted operation
        System.out.println("Program 4 - Stream with sorted operation:");
        List<Integer> unsorted = Arrays.asList(5, 2, 8, 1, 9, 3);
        System.out.println("Unsorted: " + unsorted);
        
        List<Integer> sortedAsc = unsorted.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted ascending: " + sortedAsc);
        
        List<Integer> sortedDesc = unsorted.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println("Sorted descending: " + sortedDesc);
        System.out.println();
        
        // Program 5: Stream with forEach
        System.out.println("Program 5 - Stream with forEach:");
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape");
        
        System.out.println("Printing fruits with forEach:");
        fruits.stream().forEach(fruit -> System.out.println("- " + fruit));
        System.out.println();
        
        // Program 6: Stream with reduce operation
        System.out.println("Program 6 - Stream with reduce operation:");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Numbers: " + nums);
        
        Optional<Integer> sum = nums.stream().reduce((a, b) -> a + b);
        System.out.println("Sum: " + sum.orElse(0));
        
        Optional<Integer> product = nums.stream().reduce((a, b) -> a * b);
        System.out.println("Product: " + product.orElse(1));
        
        int sumWithIdentity = nums.stream().reduce(0, Integer::sum);
        System.out.println("Sum with identity: " + sumWithIdentity);
        System.out.println();
        
        // Program 7: Stream with min/max
        System.out.println("Program 7 - Stream with min/max:");
        List<Integer> values = Arrays.asList(45, 12, 78, 23, 89, 34, 67);
        System.out.println("Values: " + values);
        
        Optional<Integer> min = values.stream().min(Integer::compareTo);
        Optional<Integer> max = values.stream().max(Integer::compareTo);
        
        System.out.println("Minimum: " + min.orElse(null));
        System.out.println("Maximum: " + max.orElse(null));
        System.out.println();
        
        // Program 8: Stream with limit and skip
        System.out.println("Program 8 - Stream with limit and skip:");
        List<Integer> sequence = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Sequence: " + sequence);
        
        List<Integer> firstThree = sequence.stream().limit(3).collect(Collectors.toList());
        System.out.println("First 3 elements: " + firstThree);
        
        List<Integer> skipFirstFive = sequence.stream().skip(5).collect(Collectors.toList());
        System.out.println("Skip first 5 elements: " + skipFirstFive);
        
        List<Integer> middleSection = sequence.stream().skip(3).limit(4).collect(Collectors.toList());
        System.out.println("Middle section (skip 3, take 4): " + middleSection);
        System.out.println();
        
        // Program 9: Stream with anyMatch, allMatch, noneMatch
        System.out.println("Program 9 - Stream with match operations:");
        List<Integer> mixedNumbers = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> mixedNumbers2 = Arrays.asList(1, 2, 3, 4, 5);
        
        boolean allEven = mixedNumbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println("All numbers in first list are even: " + allEven);
        
        boolean anyEven = mixedNumbers2.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("Any number in second list is even: " + anyEven);
        
        boolean noneNegative = mixedNumbers.stream().noneMatch(n -> n < 0);
        System.out.println("None of the numbers are negative: " + noneNegative);
        System.out.println();
        
        // Program 10: Complex stream pipeline
        System.out.println("Program 10 - Complex stream pipeline:");
        List<String> sentences = Arrays.asList(
            "Java is powerful",
            "Streams are useful",
            "Functional programming is cool",
            "Lambda expressions simplify code",
            "Practice makes perfect"
        );
        
        System.out.println("Sentences: " + sentences);
        
        // Process: Split into words, filter long words, convert to uppercase, sort, limit to 5
        List<String> processed = sentences.stream()
                                        .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                                        .filter(word -> word.length() > 4)
                                        .map(String::toUpperCase)
                                        .sorted()
                                        .limit(5)
                                        .collect(Collectors.toList());
        
        System.out.println("Processed words (longer than 4 chars, uppercase, sorted, top 5): " + processed);
        System.out.println();
        
        // Additional examples
        
        // Example 1: Grouping by length
        System.out.println("Additional Example 1 - Grouping by length:");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace");
        System.out.println("Names: " + names);
        
        Map<Integer, List<String>> groupedByLength = names.stream()
                                                         .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + groupedByLength);
        System.out.println();
        
        // Example 2: Joining strings
        System.out.println("Additional Example 2 - Joining strings:");
        List<String> items = Arrays.asList("apple", "banana", "cherry", "date");
        String joined = items.stream().collect(Collectors.joining(", "));
        System.out.println("Joined: " + joined);
        
        String joinedWithPrefixSuffix = items.stream().collect(Collectors.joining(" | ", "[", "]"));
        System.out.println("Joined with prefix/suffix: " + joinedWithPrefixSuffix);
        System.out.println();
        
        // Example 3: Finding first element that matches a condition
        System.out.println("Additional Example 3 - Finding first element:");
        List<Integer> numbersToSearch = Arrays.asList(1, 3, 5, 8, 9, 12, 15, 18);
        Optional<Integer> firstEven = numbersToSearch.stream()
                                                    .filter(n -> n % 2 == 0)
                                                    .findFirst();
        System.out.println("First even number: " + firstEven.orElse(null));
        
        Optional<Integer> firstGreaterThan10 = numbersToSearch.stream()
                                                            .filter(n -> n > 10)
                                                            .findFirst();
        System.out.println("First number > 10: " + firstGreaterThan10.orElse(null));
    }
}