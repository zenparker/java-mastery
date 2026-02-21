/**
 * Exception Handling in Java
 * 
 * This program demonstrates:
 * - try-catch-finally
 * - throw vs throws
 * - Common exceptions (NullPointer, ArrayIndexOutOfBounds)
 * - Custom exceptions
 * - Five programs with error handling
 */
public class ExceptionHandling {
    public static void main(String[] args) {
        // Program 1: Basic try-catch-finally
        System.out.println("Program 1 - Basic try-catch-finally:");
        try {
            int result = 10 / 2;
            System.out.println("Division result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes");
        }
        System.out.println();
        
        // Program 2: Handling multiple exceptions
        System.out.println("Program 2 - Handling multiple exceptions:");
        int[] numbers = {1, 2, 3};
        
        try {
            int value = numbers[5]; // ArrayIndexOutOfBoundsException
            int result = value / 0; // ArithmeticException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Cleanup in finally block");
        }
        System.out.println();
        
        // Program 3: NullPointerException example
        System.out.println("Program 3 - NullPointerException example:");
        String text = null;
        
        try {
            int length = text.length(); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
            System.out.println("Handle null pointer gracefully");
        }
        System.out.println();
        
        // Program 4: Using throws keyword
        System.out.println("Program 4 - Using throws keyword:");
        try {
            divideNumbers(10, 0); // This method can throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught in main: " + e.getMessage());
        }
        System.out.println();
        
        // Program 5: Custom exception example
        System.out.println("Program 5 - Custom exception example:");
        try {
            validateAge(15); // This will throw custom exception
        } catch (InvalidAgeException e) {
            System.out.println("Custom exception caught: " + e.getMessage());
            System.out.println("Age must be at least 18, got: " + e.getAge());
        }
        
        try {
            validateAge(25); // This is valid
            System.out.println("Age 25 is valid");
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println();
        
        // Additional examples
        System.out.println("Additional Examples:");
        
        // Example 1: NumberFormatException
        System.out.println("Example 1 - NumberFormatException:");
        try {
            String invalidNumber = "abc";
            int num = Integer.parseInt(invalidNumber);
            System.out.println("Parsed number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
            System.out.println("Invalid number format for string: abc");
        }
        System.out.println();
        
        // Example 2: Input validation with exception handling
        System.out.println("Example 2 - Input validation:");
        try {
            String userInput = "25";
            int age = Integer.parseInt(userInput);
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            System.out.println("Valid age entered: " + age);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: Please enter a valid number");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
        
        // Example 3: File-like operations with exception handling
        System.out.println("Example 3 - File-like operations:");
        try {
            readFile("existing-file.txt");
        } catch (CustomFileException e) {
            System.out.println("File operation failed: " + e.getMessage());
        }
        System.out.println();
        
        // Example 4: Nested try-catch blocks
        System.out.println("Example 4 - Nested try-catch:");
        try {
            outerMethod();
        } catch (Exception e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
    }
    
    // Method that uses throws keyword
    public static int divideNumbers(int a, int b) throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return a / b;
    }
    
    // Method to validate age with custom exception
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException(age);
        }
    }
    
    // Method to simulate file reading with custom exception
    public static void readFile(String fileName) throws CustomFileException {
        if (fileName.equals("nonexistent-file.txt")) {
            throw new CustomFileException("File not found: " + fileName);
        }
        System.out.println("Reading file: " + fileName);
    }
    
    // Method for nested exception example
    public static void outerMethod() {
        try {
            innerMethod();
        } catch (ArithmeticException e) {
            System.out.println("Caught in outerMethod: " + e.getMessage());
            throw e; // Re-throw the exception
        }
    }
    
    public static void innerMethod() {
        int result = 10 / 0; // This will cause ArithmeticException
    }
}

// Custom exception class
class InvalidAgeException extends Exception {
    private int age;
    
    public InvalidAgeException(int age) {
        super("Invalid age: " + age + ". Age must be at least 18.");
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
}

// Another custom exception
class CustomFileException extends Exception {
    public CustomFileException(String message) {
        super(message);
    }
}