/*
 * ============================================================
 *              METHODS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS A METHOD?
 * ------------------
 * A Method is a BLOCK OF CODE that performs a specific task.
 * It is defined once and can be CALLED (invoked) multiple
 * times from anywhere in the program.
 *
 * Real-life analogy:
 *  A TV remote's "Volume Up" button → press it (call method)
 *  → volume increases (method executes) → every time you
 *  press it, same action happens (reusability)
 *
 * Why use Methods?
 *  ✔ Reusability    — write once, use many times
 *  ✔ Modularity     — break program into smaller pieces
 *  ✔ Readability    — code is easier to understand
 *  ✔ Maintainability— fix bug in one place, fixed everywhere
 *  ✔ Abstraction    — hide implementation details
 *
 * ============================================================
 * ANATOMY OF A METHOD
 * ============================================================
 *
 *  accessModifier returnType methodName(parameters) {
 *      // method body
 *      return value;   // if returnType is not void
 *  }
 *
 *  Example:
 *  public static int add(int a, int b) {
 *      return a + b;
 *  }
 *
 *  Components:
 *  -----------
 *  public       → access modifier (who can call this method)
 *  static       → belongs to class (not object)
 *  int          → return type (what value method returns)
 *  add          → method name (identifier)
 *  (int a, int b) → parameter list (inputs to method)
 *  { }          → method body (code to execute)
 *  return a + b → return statement (sends value back)
 *
 * ============================================================
 * METHOD SIGNATURE
 * ============================================================
 *
 *  Method signature = methodName + parameterTypes
 *  Example: add(int, int)
 *
 *  Signature is used to UNIQUELY identify a method.
 *  Return type is NOT part of the signature.
 *  Used in METHOD OVERLOADING.
 *
 * ============================================================
 * TYPES OF METHODS
 * ============================================================
 *
 *  1. Based on return type:
 *     a. void methods     → returns nothing
 *     b. Non-void methods → returns a value
 *
 *  2. Based on parameters:
 *     a. No-parameter methods
 *     b. Parameterized methods
 *
 *  3. Based on modifier:
 *     a. static methods   → called on class
 *     b. instance methods → called on object
 *
 *  4. Special types:
 *     a. Recursive methods   → calls itself
 *     b. Overloaded methods  → same name, diff params
 *     c. varargs methods     → variable arguments
 *     d. main() method       → entry point
 *
 * ============================================================
 * ACCESS MODIFIERS
 * ============================================================
 *
 *  Modifier     Accessible From
 *  ----------   ----------------------------------------
 *  public       Anywhere (any class, any package)
 *  private      Only within the same class
 *  protected    Same class + subclass + same package
 *  (default)    Only within the same package
 *
 * ============================================================
 * RETURN TYPES
 * ============================================================
 *
 *  void         → method returns nothing
 *  int          → method returns an integer
 *  double       → method returns a double
 *  String       → method returns a String
 *  boolean      → method returns true/false
 *  int[]        → method returns an int array
 *  Object       → method returns an Object
 *  Any type     → method can return any data type
 *
 * ============================================================
 * PARAMETERS vs ARGUMENTS
 * ============================================================
 *
 *  Parameters → variables in method DEFINITION
 *  Arguments  → actual values passed when CALLING method
 *
 *  Definition: void greet(String name) { ... }
 *                          ↑ parameter
 *
 *  Call:       greet("Alice");
 *                     ↑ argument
 *
 * ============================================================
 * PASS BY VALUE IN JAVA
 * ============================================================
 *
 *  Java is ALWAYS Pass by Value.
 *
 *  For PRIMITIVES:
 *  - A COPY of the value is passed.
 *  - Changes inside method do NOT affect original.
 *
 *  For OBJECTS/ARRAYS:
 *  - A COPY of the REFERENCE is passed.
 *  - Changes to object's content AFFECT original.
 *  - But reassigning the reference does NOT affect original.
 *
 * ============================================================
 * METHOD OVERLOADING
 * ============================================================
 *
 *  Defining MULTIPLE methods with the SAME NAME but
 *  DIFFERENT parameter lists in the same class.
 *
 *  Valid overloading (different signatures):
 *  int add(int a, int b)
 *  double add(double a, double b)
 *  int add(int a, int b, int c)
 *  String add(String a, String b)
 *
 *  NOT valid (same signature, only return type differs):
 *  int add(int a, int b)
 *  double add(int a, int b)   ← COMPILE ERROR!
 *
 *  Resolved at COMPILE TIME (static polymorphism).
 *
 * ============================================================
 * RECURSION
 * ============================================================
 *
 *  A method that CALLS ITSELF is called recursive.
 *  Must have:
 *  1. BASE CASE   → condition to STOP recursion
 *  2. RECURSIVE CASE → method calls itself with simpler input
 *
 *  Without base case → StackOverflowError!
 *
 *  Example: factorial(5) = 5 × factorial(4)
 *                            = 5 × 4 × factorial(3)
 *                              = 5 × 4 × 3 × factorial(2)
 *                                = 5 × 4 × 3 × 2 × factorial(1)
 *                                  = 5 × 4 × 3 × 2 × 1 = 120
 *
 * ============================================================
 * varargs (Variable Arguments)
 * ============================================================
 *
 *  Allows a method to accept ZERO OR MORE arguments.
 *  Internally treated as an ARRAY.
 *
 *  Syntax: returnType methodName(dataType... varName)
 *
 *  Rules:
 *  - Only ONE varargs per method
 *  - Must be the LAST parameter
 *  - Cannot have two varargs in same method
 *
 * ============================================================
 * BEST PRACTICES
 * ============================================================
 *
 *  1. One method = One task (Single Responsibility)
 *  2. Method name should be a VERB (calculateArea, getName)
 *  3. Keep methods SHORT (ideally < 20 lines)
 *  4. Use meaningful parameter names
 *  5. Avoid too many parameters (max 3-4)
 *  6. Prefer return value over modifying global state
 *  7. Use private for helper methods
 *  8. Always handle edge cases
 *
 * ============================================================
 */

public class MethodsInJava {

    // ============================================================
    // CLASS-LEVEL FIELDS (used in instance method demos)
    // ============================================================
    private String name;
    private int    age;
    static  int    objectCount = 0;

    // Constructor
    public MethodsInJava(String name, int age) {
        this.name = name;
        this.age  = age;
        objectCount++;
    }

    // ============================================================
    // 1. void METHOD — returns nothing
    // ============================================================

    // No parameters
    static void greetWorld() {
        System.out.println("Hello, World! 👋");
    }

    // With parameters
    static void greet(String name) {
        System.out.println("Hello, " + name + "! Welcome to Java.");
    }

    // With multiple parameters
    static void printInfo(String name, int age, String city) {
        System.out.printf("Name: %-10s Age: %3d City: %s%n", name, age, city);
    }

    // ============================================================
    // 2. NON-VOID METHODS — return a value
    // ============================================================

    // Return int
    static int add(int a, int b) {
        return a + b;
    }

    // Return double
    static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    // Return String
    static String fullName(String first, String last) {
        return first + " " + last;
    }

    // Return boolean
    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    // Return array
    static int[] generateRange(int start, int end) {
        int[] result = new int[end - start + 1];
        for (int i = 0; i < result.length; i++)
            result[i] = start + i;
        return result;
    }

    // Multiple return points
    static String classify(int n) {
        if (n > 0)  return "Positive";
        if (n < 0)  return "Negative";
        return "Zero";
    }

    // ============================================================
    // 3. METHOD OVERLOADING
    // ============================================================

    // Overloaded: area() — different parameter types
    static double area(double radius) {
        // Circle area
        return Math.PI * radius * radius;
    }

    static double area(double length, double width) {
        // Rectangle area
        return length * width;
    }

    static double area(double base, double height, boolean isTriangle) {
        // Triangle area
        return 0.5 * base * height;
    }

    // Overloaded: add() — different types
    static int    add(int a, int b, int c)     { return a + b + c; }
    static double add(double a, double b)       { return a + b; }
    static String add(String a, String b)       { return a + b; }
    static long   add(long a, long b)           { return a + b; }

    // Overloaded: print() — different param counts
    static void print(String msg)               { System.out.println("[MSG] " + msg); }
    static void print(String msg, int count) {
        for (int i = 0; i < count; i++) System.out.println("[MSG] " + msg);
    }
    static void print(String msg, String prefix){ System.out.println("[" + prefix + "] " + msg); }

    // ============================================================
    // 4. RECURSIVE METHODS
    // ============================================================

    // Factorial
    static long factorial(int n) {
        if (n == 0 || n == 1) return 1;   // base case
        return n * factorial(n - 1);       // recursive case
    }

    // Fibonacci
    static int fibonacci(int n) {
        if (n <= 0) return 0;              // base case 1
        if (n == 1) return 1;              // base case 2
        return fibonacci(n-1) + fibonacci(n-2); // recursive
    }

    // Sum of digits
    static int sumOfDigits(int n) {
        if (n < 10) return n;              // base case
        return (n % 10) + sumOfDigits(n / 10); // recursive
    }

    // Power (a^b)
    static double power(double base, int exp) {
        if (exp == 0) return 1;            // base case
        if (exp < 0)  return 1.0 / power(base, -exp);
        return base * power(base, exp - 1);// recursive
    }

    // Binary search (recursive)
    static int binarySearch(int[] arr, int target, int low, int high) {
        if (low > high) return -1;         // base case: not found
        int mid = (low + high) / 2;
        if (arr[mid] == target) return mid;// base case: found
        if (arr[mid] < target)
            return binarySearch(arr, target, mid+1, high);
        return binarySearch(arr, target, low, mid-1);
    }

    // Reverse string recursively
    static String reverseString(String s) {
        if (s.isEmpty()) return s;         // base case
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    // ============================================================
    // 5. varargs METHODS
    // ============================================================

    // Sum of any number of ints
    static int sum(int... nums) {
        int total = 0;
        for (int n : nums) total += n;
        return total;
    }

    // Max of any number of values
    static int max(int first, int... rest) {
        int maxVal = first;
        for (int n : rest) if (n > maxVal) maxVal = n;
        return maxVal;
    }

    // Print all values
    static void printAll(String label, Object... values) {
        System.out.print(label + ": ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if (i < values.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    // Average of doubles
    static double average(double... nums) {
        if (nums.length == 0) return 0;
        double total = 0;
        for (double n : nums) total += n;
        return total / nums.length;
    }

    // ============================================================
    // 6. PASS BY VALUE DEMOS
    // ============================================================

    // Primitive — changes do NOT affect original
    static void tryChangeInt(int x) {
        x = x * 100;
        System.out.println("  Inside method  : x = " + x);
    }

    // Array — changes AFFECT original (reference copy)
    static void tryChangeArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) arr[i] *= 2;
        System.out.println("  Inside method  : " + java.util.Arrays.toString(arr));
    }

    // Reassigning reference — does NOT affect original
    static void tryReassignArray(int[] arr) {
        arr = new int[]{99, 99, 99};   // new object, original unchanged
        System.out.println("  Inside method  : " + java.util.Arrays.toString(arr));
    }

    // ============================================================
    // 7. INSTANCE METHODS (called on objects)
    // ============================================================

    // Getter methods
    public String getName() { return name; }
    public int    getAge()  { return age; }

    // Setter methods
    public void setName(String name) { this.name = name; }
    public void setAge(int age) {
        if (age >= 0 && age <= 150) this.age = age;
        else System.out.println("  Invalid age!");
    }

    // Instance method
    public void introduce() {
        System.out.println("Hi, I'm " + name + " and I'm " + age + " years old.");
    }

    // Instance method with logic
    public String getCategory() {
        if (age < 13)       return "Child";
        else if (age < 18)  return "Teenager";
        else if (age < 60)  return "Adult";
        else                return "Senior";
    }

    // Static method using static field
    public static int getObjectCount() { return objectCount; }

    // toString override
    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d}", name, age);
    }

    // ============================================================
    // 8. UTILITY / HELPER METHODS
    // ============================================================

    // Check prime
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    // Swap two values (using array trick)
    static int[] swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        return new int[]{a, b};
    }

    // Clamp value between min and max
    static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

    // Format number with commas
    static String formatNumber(long n) {
        return String.format("%,d", n);
    }

    // Check if string is palindrome
    static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) return false;
            lo++; hi--;
        }
        return true;
    }

    // Count occurrences of char in string
    static int countChar(String s, char c) {
        int count = 0;
        for (char ch : s.toCharArray())
            if (ch == c) count++;
        return count;
    }

    // Convert celsius to fahrenheit
    static double celsiusToFahrenheit(double c) { return (c * 9.0/5.0) + 32; }
    static double fahrenheitToCelsius(double f) { return (f - 32) * 5.0/9.0; }

    // ── separator helper ──
    static void sep() { System.out.println("  " + "-".repeat(45)); }

    // ============================================================
    // MAIN METHOD
    // ============================================================
    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#           METHODS IN JAVA                #");
        System.out.println("############################################");

        // ============================================================
        // 1. void METHODS
        // ============================================================
        System.out.println("\n===== 1. void METHODS =====");

        greetWorld();
        greet("Alice");
        greet("Bob");

        System.out.println("\n--- Multiple Parameters ---");
        printInfo("Alice",   22, "Mumbai");
        printInfo("Bob",     30, "Delhi");
        printInfo("Charlie", 25, "Pune");

        // ============================================================
        // 2. NON-VOID METHODS
        // ============================================================
        System.out.println("\n===== 2. NON-VOID METHODS =====");

        // Return int
        int sumResult = add(15, 27);
        System.out.println("add(15, 27)          = " + sumResult);

        // Return double
        double areaResult = circleArea(7.0);
        System.out.printf("circleArea(7.0)      = %.4f%n", areaResult);

        // Return String
        String fullN = fullName("John", "Doe");
        System.out.println("fullName(John, Doe)  = " + fullN);

        // Return boolean
        System.out.println("isEven(4)            = " + isEven(4));
        System.out.println("isEven(7)            = " + isEven(7));

        // Return array
        int[] range = generateRange(1, 10);
        System.out.println("generateRange(1,10)  = " + java.util.Arrays.toString(range));

        // Multiple returns
        System.out.println("classify(10)         = " + classify(10));
        System.out.println("classify(-5)         = " + classify(-5));
        System.out.println("classify(0)          = " + classify(0));

        // ============================================================
        // 3. METHOD OVERLOADING
        // ============================================================
        System.out.println("\n===== 3. METHOD OVERLOADING =====");

        // Overloaded area()
        System.out.println("--- area() overloads ---");
        System.out.printf("area(5.0)            = %.4f (Circle)%n",     area(5.0));
        System.out.printf("area(4.0, 6.0)       = %.4f (Rectangle)%n",  area(4.0, 6.0));
        System.out.printf("area(3.0, 8.0, true) = %.4f (Triangle)%n",   area(3.0, 8.0, true));

        // Overloaded add()
        System.out.println("\n--- add() overloads ---");
        System.out.println("add(int, int)        = " + add(10, 20));
        System.out.println("add(int, int, int)   = " + add(10, 20, 30));
        System.out.println("add(double, double)  = " + add(1.5, 2.7));
        System.out.println("add(long, long)      = " + add(100L, 200L));
        System.out.println("add(String, String)  = " + add("Hello", "World"));

        // Overloaded print()
        System.out.println("\n--- print() overloads ---");
        print("Welcome!");
        print("Java!", 3);
        print("Error occurred", "ERROR");

        // ============================================================
        // 4. RECURSIVE METHODS
        // ============================================================
        System.out.println("\n===== 4. RECURSIVE METHODS =====");

        // Factorial
        System.out.println("--- Factorial ---");
        for (int i = 0; i <= 10; i++) {
            System.out.printf("  factorial(%2d) = %,d%n", i, factorial(i));
        }

        // Fibonacci
        System.out.println("\n--- Fibonacci Series ---");
        System.out.print("  ");
        for (int i = 0; i <= 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        // Sum of digits
        System.out.println("\n--- Sum of Digits ---");
        int[] digitTests = {0, 5, 123, 9999, 12345};
        for (int n : digitTests) {
            System.out.printf("  sumOfDigits(%5d) = %d%n", n, sumOfDigits(n));
        }

        // Power
        System.out.println("\n--- Power (a^b) ---");
        System.out.printf("  power(2,  10) = %.0f%n",  power(2, 10));
        System.out.printf("  power(3,   5) = %.0f%n",  power(3, 5));
        System.out.printf("  power(5,   0) = %.0f%n",  power(5, 0));
        System.out.printf("  power(2,  -3) = %.4f%n",  power(2, -3));

        // Binary search recursive
        System.out.println("\n--- Recursive Binary Search ---");
        int[] sorted = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        System.out.println("  Array: " + java.util.Arrays.toString(sorted));
        int[] searchFor = {23, 56, 99, 2, 91};
        for (int key : searchFor) {
            int idx = binarySearch(sorted, key, 0, sorted.length - 1);
            System.out.printf("  binarySearch(%2d) → %s%n", key,
                    idx != -1 ? "✔ found at index " + idx : "✘ not found");
        }

        // Reverse string recursive
        System.out.println("\n--- Recursive Reverse String ---");
        String[] revTests = {"Hello", "Java", "racecar", "OpenAI"};
        for (String s : revTests) {
            System.out.printf("  reverse(\"%-10s\") = \"%s\"%n",
                    s + "\"", reverseString(s));
        }

        // ============================================================
        // 5. varargs METHODS
        // ============================================================
        System.out.println("\n===== 5. varargs METHODS =====");

        // sum()
        System.out.println("--- sum(int...) ---");
        System.out.println("sum()                = " + sum());
        System.out.println("sum(5)               = " + sum(5));
        System.out.println("sum(1, 2, 3)         = " + sum(1, 2, 3));
        System.out.println("sum(1,2,3,4,5,6,7,8) = " + sum(1,2,3,4,5,6,7,8));

        // max()
        System.out.println("\n--- max(int, int...) ---");
        System.out.println("max(5)               = " + max(5));
        System.out.println("max(3, 7)            = " + max(3, 7));
        System.out.println("max(1,5,3,9,2,8,4)   = " + max(1,5,3,9,2,8,4));

        // average()
        System.out.println("\n--- average(double...) ---");
        System.out.printf("average(10,20,30)    = %.2f%n", average(10, 20, 30));
        System.out.printf("average(1.5,2.5,3.5) = %.2f%n", average(1.5, 2.5, 3.5));

        // printAll()
        System.out.println("\n--- printAll(String, Object...) ---");
        printAll("Colors", "Red", "Green", "Blue");
        printAll("Numbers", 10, 20, 30, 40, 50);
        printAll("Mixed", "Java", 2024, true, 3.14);

        // ============================================================
        // 6. PASS BY VALUE
        // ============================================================
        System.out.println("\n===== 6. PASS BY VALUE =====");

        // Primitive
        System.out.println("--- Primitive (int) ---");
        int orig = 10;
        System.out.println("  Before call     : orig = " + orig);
        tryChangeInt(orig);
        System.out.println("  After  call     : orig = " + orig); // unchanged!

        // Array — content changes
        System.out.println("\n--- Array (content changes) ---");
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("  Before call     : " + java.util.Arrays.toString(arr));
        tryChangeArray(arr);
        System.out.println("  After  call     : " + java.util.Arrays.toString(arr)); // changed!

        // Array — reference reassign
        System.out.println("\n--- Array (reference reassign) ---");
        int[] arr2 = {1, 2, 3};
        System.out.println("  Before call     : " + java.util.Arrays.toString(arr2));
        tryReassignArray(arr2);
        System.out.println("  After  call     : " + java.util.Arrays.toString(arr2)); // unchanged!

        // ============================================================
        // 7. INSTANCE METHODS
        // ============================================================
        System.out.println("\n===== 7. INSTANCE METHODS =====");

        // Create objects
        MethodsInJava p1 = new MethodsInJava("Alice", 22);
        MethodsInJava p2 = new MethodsInJava("Bob",   15);
        MethodsInJava p3 = new MethodsInJava("Carol", 65);

        // Call instance methods
        p1.introduce();
        p2.introduce();
        p3.introduce();

        System.out.println("\n--- getCategory() ---");
        System.out.println(p1.getName() + " → " + p1.getCategory());
        System.out.println(p2.getName() + " → " + p2.getCategory());
        System.out.println(p3.getName() + " → " + p3.getCategory());

        // Getters & Setters
        System.out.println("\n--- Getters & Setters ---");
        System.out.println("Before: " + p1);
        p1.setName("Alicia");
        p1.setAge(23);
        System.out.println("After : " + p1);

        p1.setAge(-5);      // invalid
        p1.setAge(200);     // invalid

        // Static method
        System.out.println("\n--- Static vs Instance ---");
        System.out.println("Total objects created: " + MethodsInJava.getObjectCount());

        // ============================================================
        // 8. UTILITY METHODS
        // ============================================================
        System.out.println("\n===== 8. UTILITY METHODS =====");

        // isPrime
        System.out.println("--- isPrime() ---");
        System.out.print("  Primes 1-30: ");
        for (int i = 1; i <= 30; i++)
            if (isPrime(i)) System.out.print(i + " ");
        System.out.println();

        // swap
        System.out.println("\n--- swap() ---");
        int x = 25, y = 75;
        System.out.println("  Before: x=" + x + " y=" + y);
        int[] swapped = swap(x, y);
        System.out.println("  After : x=" + swapped[0] + " y=" + swapped[1]);

        // clamp
        System.out.println("\n--- clamp(val, min, max) ---");
        System.out.println("  clamp(5, 1, 10)    = " + clamp(5, 1, 10));   // 5
        System.out.println("  clamp(-5, 1, 10)   = " + clamp(-5, 1, 10));  // 1
        System.out.println("  clamp(15, 1, 10)   = " + clamp(15, 1, 10));  // 10

        // formatNumber
        System.out.println("\n--- formatNumber() ---");
        long[] nums = {1000, 50000, 1234567, 9876543210L};
        for (long n : nums)
            System.out.printf("  %-12d → %s%n", n, formatNumber(n));

        // isPalindrome
        System.out.println("\n--- isPalindrome() ---");
        String[] palTests = {"racecar","hello","A man a plan a canal Panama","Java"};
        for (String s : palTests) {
            System.out.printf("  %-35s → %s%n", "\"" + s + "\"",
                    isPalindrome(s) ? "✔ Palindrome" : "✘ Not Palindrome");
        }

        // countChar
        System.out.println("\n--- countChar() ---");
        System.out.println("  countChar(\"programming\", 'g') = "
                + countChar("programming", 'g'));
        System.out.println("  countChar(\"hello world\", 'l')  = "
                + countChar("hello world", 'l'));

        // Temperature conversion
        System.out.println("\n--- Temperature Conversion ---");
        double[] celsiusVals = {0, 20, 37, 100};
        for (double c : celsiusVals) {
            System.out.printf("  %.1f°C = %.2f°F%n", c, celsiusToFahrenheit(c));
        }
        double[] fahrenheitVals = {32, 68, 98.6, 212};
        for (double f : fahrenheitVals) {
            System.out.printf("  %.1f°F = %.2f°C%n", f, fahrenheitToCelsius(f));
        }

        // ============================================================
        // 9. REAL-WORLD EXAMPLES
        // ============================================================
        System.out.println("\n===== 9. REAL-WORLD EXAMPLES =====");

        // Example 1: Grade Calculator
        System.out.println("--- Grade Calculator ---");
        String[] stuNames  = {"Alice","Bob","Charlie","Diana","Eve"};
        int[][]  stuMarks  = {
            {92, 88, 95, 90, 85},
            {74, 68, 72, 70, 76},
            {98, 95, 97, 99, 96},
            {55, 48, 60, 52, 58},
            {82, 79, 85, 88, 80}
        };

        System.out.printf("  %-10s %8s %8s %8s%n", "Name", "Total", "Avg", "Grade");
        sep();
        for (int i = 0; i < stuNames.length; i++) {
            int total = sum(stuMarks[i]);
            double avg = average(convertToDouble(stuMarks[i]));
            String grade = avg >= 90 ? "A+" : avg >= 80 ? "A" :
                           avg >= 70 ? "B"  : avg >= 60 ? "C" :
                           avg >= 50 ? "D"  : "F";
            System.out.printf("  %-10s %8d %8.1f %8s%n",
                    stuNames[i], total, avg, grade);
        }

        // Example 2: ATM Operations
        System.out.println("\n--- ATM Operations ---");
        double balance = 10000.0;
        System.out.printf("  Initial balance  : ₹%,.2f%n", balance);
        balance = deposit(balance, 5000.0);
        balance = withdraw(balance, 3000.0);
        balance = withdraw(balance, 20000.0);  // insufficient
        System.out.printf("  Final balance    : ₹%,.2f%n", balance);

        // Example 3: Shopping Bill
        System.out.println("\n--- Shopping Bill ---");
        String[] items   = {"Rice","Milk","Eggs","Bread","Butter"};
        double[] prices  = {60.0, 28.0, 72.0, 45.0, 120.0};
        int[]    qtys    = {2, 3, 1, 2, 1};
        printBill(items, prices, qtys);

        System.out.println("\n############################################");
        System.out.println("#       Methods in Java — Done! ✔         #");
        System.out.println("############################################");
    }

    // ── Helper for grade calc ──
    static double[] convertToDouble(int[] arr) {
        double[] d = new double[arr.length];
        for (int i = 0; i < arr.length; i++) d[i] = arr[i];
        return d;
    }

    // ── varargs overload for int[] ──
    // static int sum(int[] nums) {
    //     int t = 0;
    //     for (int n : nums) t += n;
    //     return t;
    // }

    // ── ATM deposit ──
    static double deposit(double balance, double amount) {
        if (amount <= 0) {
            System.out.println("  ✘ Invalid deposit amount!");
            return balance;
        }
        balance += amount;
        System.out.printf("  ✔ Deposited ₹%,.2f | Balance: ₹%,.2f%n", amount, balance);
        return balance;
    }

    // ── ATM withdraw ──
    static double withdraw(double balance, double amount) {
        if (amount <= 0) {
            System.out.println("  ✘ Invalid withdrawal amount!");
            return balance;
        }
        if (amount > balance) {
            System.out.printf("  ✘ Insufficient funds! (Requested ₹%,.2f)%n", amount);
            return balance;
        }
        balance -= amount;
        System.out.printf("  ✔ Withdrew ₹%,.2f  | Balance: ₹%,.2f%n", amount, balance);
        return balance;
    }

    // ── Shopping bill printer ──
    static void printBill(String[] items, double[] prices, int[] qtys) {
        double total = 0;
        System.out.printf("  %-12s %8s %5s %10s%n","Item","Price","Qty","Amount");
        sep();
        for (int i = 0; i < items.length; i++) {
            double amt = prices[i] * qtys[i];
            total += amt;
            System.out.printf("  %-12s %8.2f %5d %10.2f%n",
                    items[i], prices[i], qtys[i], amt);
        }
        sep();
        double gst   = total * 0.05;
        double grand = total + gst;
        System.out.printf("  %-18s %10.2f%n", "Subtotal:", total);
        System.out.printf("  %-18s %10.2f%n", "GST (5%):", gst);
        System.out.printf("  %-18s %10.2f%n", "Grand Total:", grand);
    }
}