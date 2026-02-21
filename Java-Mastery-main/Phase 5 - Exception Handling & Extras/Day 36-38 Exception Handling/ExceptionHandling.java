
/*
 * ============================================================
 *        EXCEPTION HANDLING IN JAVA — COMPLETE THEORY
 * ============================================================
 *
 * WHAT IS AN EXCEPTION?
 * ----------------------
 * An Exception is an UNWANTED or UNEXPECTED EVENT that occurs
 * during program execution and DISRUPTS the normal flow.
 *
 * Examples:
 *  - Dividing by zero          → ArithmeticException
 *  - Accessing null object     → NullPointerException
 *  - Array index out of range  → ArrayIndexOutOfBoundsException
 *  - File not found            → FileNotFoundException
 *  - Invalid type cast         → ClassCastException
 *
 * WITHOUT exception handling → program CRASHES
 * WITH exception handling    → program RECOVERS gracefully
 *
 * ============================================================
 * ERROR vs EXCEPTION
 * ============================================================
 *
 *  Throwable
 *  ├── Error           (serious, unrecoverable)
 *  │   ├── OutOfMemoryError
 *  │   ├── StackOverflowError
 *  │   └── VirtualMachineError
 *  └── Exception       (recoverable)
 *      ├── RuntimeException (Unchecked)
 *      │   ├── NullPointerException
 *      │   ├── ArithmeticException
 *      │   ├── ArrayIndexOutOfBoundsException
 *      │   ├── ClassCastException
 *      │   ├── NumberFormatException
 *      │   ├── IllegalArgumentException
 *      │   ├── IllegalStateException
 *      │   └── StackOverflowError
 *      └── Checked Exceptions
 *          ├── IOException
 *          │   ├── FileNotFoundException
 *          │   └── EOFException
 *          ├── SQLException
 *          ├── ClassNotFoundException
 *          └── ParseException
 *
 * ============================================================
 * CHECKED vs UNCHECKED EXCEPTIONS
 * ============================================================
 *
 *  CHECKED (Compile-time):
 *  - Compiler FORCES you to handle them
 *  - Must use try-catch OR declare with 'throws'
 *  - Represent recoverable conditions
 *  - Examples: IOException, SQLException, ParseException
 *
 *  UNCHECKED (Runtime):
 *  - Compiler does NOT force handling
 *  - Subclass of RuntimeException
 *  - Represent programming bugs
 *  - Examples: NullPointerException, ArithmeticException
 *
 *  ERROR:
 *  - NOT meant to be caught (usually)
 *  - JVM-level problems
 *  - Examples: OutOfMemoryError, StackOverflowError
 *
 * ============================================================
 * EXCEPTION HANDLING KEYWORDS
 * ============================================================
 *
 *  try     → code that might throw exception
 *  catch   → handles the exception
 *  finally → ALWAYS executes (cleanup)
 *  throw   → manually throw an exception
 *  throws  → declare exceptions a method may throw
 *
 * ============================================================
 * try-catch SYNTAX
 * ============================================================
 *
 *  try {
 *      // risky code
 *  } catch (ExceptionType1 e) {
 *      // handle ExceptionType1
 *  } catch (ExceptionType2 e) {
 *      // handle ExceptionType2
 *  } catch (ExceptionType1 | ExceptionType2 e) {
 *      // multi-catch (Java 7+)
 *  } finally {
 *      // always runs (cleanup)
 *  }
 *
 * ============================================================
 * EXCEPTION PROPAGATION
 * ============================================================
 *
 *  If exception not caught in current method →
 *  propagates UP the call stack:
 *
 *  main() → methodA() → methodB() → methodC()
 *  Exception in methodC → looks for catch in methodC
 *  Not found → propagates to methodB → to methodA → to main
 *  If not caught in main → JVM prints stack trace & terminates
 *
 * ============================================================
 * try-with-resources (Java 7+)
 * ============================================================
 *
 *  Automatically closes resources (AutoCloseable).
 *  No need for explicit finally block to close.
 *
 *  try (ResourceType res = new ResourceType()) {
 *      // use resource
 *  }
 *  // res.close() called automatically
 *
 * ============================================================
 * CUSTOM EXCEPTIONS
 * ============================================================
 *
 *  Extend Exception     → checked custom exception
 *  Extend RuntimeException → unchecked custom exception
 *
 *  Best practices:
 *  - Meaningful name ending in "Exception"
 *  - Provide constructors (message, cause, both)
 *  - Add context fields for debugging
 *
 * ============================================================
 * EXCEPTION CHAINING
 * ============================================================
 *
 *  Wrap low-level exception in high-level exception.
 *  Preserves original cause.
 *
 *  catch (SQLException e) {
 *      throw new DataAccessException("DB failed", e);
 *  }
 *  new Exception("High level", causeException)
 *  e.getCause() → original exception
 *
 * ============================================================
 * BEST PRACTICES
 * ============================================================
 *
 *  ✔ Catch specific exceptions (not generic Exception)
 *  ✔ Don't swallow exceptions (empty catch block)
 *  ✔ Log exceptions properly
 *  ✔ Use finally for cleanup
 *  ✔ Prefer try-with-resources for AutoCloseable
 *  ✔ Include meaningful messages
 *  ✔ Don't use exceptions for flow control
 *  ✔ Wrap low-level exceptions (exception chaining)
 *  ✔ Document exceptions with @throws Javadoc
 *
 *  X Avoid empty catch blocks {}         // swallowing exceptions
 *  X Avoid ignoring exceptions {}      // suppressing errors
 *  X Avoid throwing generic Exception
 *  X Avoid using exceptions for flow control
 *
 * ============================================================
 */

import java.io.*;
import java.util.*;

public class ExceptionHandling {

    static void sep()  { System.out.println("  " + "─".repeat(54)); }
    static void header(String t) {
        System.out.println(
                "\n  ╔══════════════════════════════════════════════════╗");
        System.out.printf(
                "  ║  %-48s║%n", t);
        System.out.println(
                "  ╚══════════════════════════════════════════════════╝");
    }
    static void sub(String s) {
        System.out.println("\n  ── " + s + " ──");
    }
    static void section(String s) {
        System.out.println(
                "\n╔════════════════════════════════════════════════════╗");
        System.out.printf(
                "║  %-50s║%n", s);
        System.out.println(
                "╚════════════════════════════════════════════════════╝");
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        System.out.println(
                "##################################################");
        System.out.println(
                "#       EXCEPTION HANDLING IN JAVA              #");
        System.out.println(
                "##################################################");

        // ════════════════════════════════════════════════════
        // 1. BASIC try-catch
        // ════════════════════════════════════════════════════
        section("1. BASIC try-catch");

        header("try-catch — Catching a Single Exception");

        sub("Without exception handling (comment out to see crash)");
        System.out.println("  Simulating ArithmeticException:");
        int a = 10, b = 0;
        try {
            int result = a / b;          // throws ArithmeticException
            System.out.println("  Result: " + result); // never reached
        } catch (ArithmeticException e) {
            System.out.println("  ✘ Caught: " + e.getMessage());
            System.out.println("  Exception class: " + e.getClass().getSimpleName());
        }
        System.out.println("  Program continues after catch ✔");

        sub("NullPointerException");
        String str = null;
        try {
            @SuppressWarnings("null")
            int len = str.length();      // NPE
        } catch (NullPointerException e) {
            System.out.println("  ✘ NPE caught: " + e.getMessage());
        }

        sub("ArrayIndexOutOfBoundsException");
        int[] arr = {1, 2, 3};
        try {
            System.out.println("  arr[5] = " + arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  ✘ AIOOBE caught: " + e.getMessage());
        }

        sub("NumberFormatException");
        String[] testNums = {"42", "3.14", "abc", "100", "12e3"};
        for (String s : testNums) {
            try {
                int n = Integer.parseInt(s);
                System.out.println("  Parsed: \"" + s + "\" → " + n);
            } catch (NumberFormatException e) {
                System.out.println("  ✘ Invalid: \"" + s + "\" → " + e.getMessage());
            }
        }

        sub("ClassCastException");
        Object obj = "Hello";
        try {
            Integer num = (Integer) obj;   // String cannot be cast to Integer
        } catch (ClassCastException e) {
            System.out.println("  ✘ CCE caught: " + e.getMessage());
        }

        // ════════════════════════════════════════════════════
        // 2. MULTIPLE CATCH BLOCKS
        // ════════════════════════════════════════════════════
        section("2. MULTIPLE CATCH BLOCKS");

        header("Multiple catch — Most Specific First");

        sub("Exception type hierarchy matters");
        int[][] matrix = {{1,2,3},{4,5}};
        String[] items = {"100","abc",null,"50"};

        for (int i = 0; i <= 4; i++) {
            try {
                String raw  = items[i];            // may throw AIOOBE
                int    val  = Integer.parseInt(raw); // may throw NFE or NPE
                int    cell = matrix[0][val - 48];   // may throw AIOOBE
                System.out.println("  [" + i + "] Value=" + val);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("  [" + i + "] ✘ Array OOB: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("  [" + i + "] ✘ Bad number: items["+i+"]='"
                        + items[i] + "'");
            } catch (NullPointerException e) {
                System.out.println("  [" + i + "] ✘ Null value at index " + i);
            }
        }

        sub("WRONG ORDER — parent before child (compile error if Exception first)");
        System.out.println("  Rule: Always catch SPECIFIC before GENERAL");
        System.out.println("  ✘ catch(Exception) then catch(NPE) → compile error");
        System.out.println("  ✔ catch(NPE)       then catch(Exception) → OK");

        sub("Multi-catch (Java 7+) — pipe | operator");
        String[] codes = {"404","abc","200",null,"500"};
        for (String code : codes) {
            try {
                int parsed = Integer.parseInt(code);
                System.out.println("  Code=" + parsed
                        + " msg=" + getHttpMessage(parsed));
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("  ✘ Multi-catch ["
                        + e.getClass().getSimpleName() + "]: " + code);
            }
        }

        // ════════════════════════════════════════════════════
        // 3. finally BLOCK
        // ════════════════════════════════════════════════════
        section("3. finally BLOCK");

        header("finally — Always Executes");

        sub("finally with no exception");
        System.out.println("  Scenario: No exception thrown");
        try {
            System.out.println("  try: executing...");
            int x = 10 / 2;
            System.out.println("  try: result=" + x);
        } catch (ArithmeticException e) {
            System.out.println("  catch: " + e.getMessage());
        } finally {
            System.out.println("  finally: ALWAYS runs ✔");
        }

        sub("finally with exception");
        System.out.println("  Scenario: Exception thrown");
        try {
            System.out.println("  try: start");
            int x = 10 / 0;             // throws!
            System.out.println("  try: end (never reached)");
        } catch (ArithmeticException e) {
            System.out.println("  catch: " + e.getMessage());
        } finally {
            System.out.println("  finally: runs even after exception ✔");
        }

        sub("finally with return (tricky!)");
        System.out.println("  finallyWithReturn() = " + finallyWithReturn());

        sub("finally for resource cleanup");
        FakeConnection conn = null;
        try {
            conn = new FakeConnection("localhost:5432");
            conn.query("SELECT * FROM users");
            int x = 10 / 0;             // simulate error mid-operation
        } catch (ArithmeticException e) {
            System.out.println("  ✘ Query failed: " + e.getMessage());
        } finally {
            if (conn != null) conn.close();  // always close!
        }

        sub("finally vs return — which wins?");
        System.out.println("  finallyReturn() = " + finallyReturn());

        // ════════════════════════════════════════════════════
        // 4. throw & throws
        // ════════════════════════════════════════════════════
        section("4. throw & throws");

        header("throw — Manually Throw Exception");

        sub("throw unchecked exception");
        try {
            validateAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("  ✘ " + e.getMessage());
        }
        try {
            validateAge(17);
        } catch (IllegalArgumentException e) {
            System.out.println("  ✘ " + e.getMessage());
        }
        System.out.println("  ✔ validateAge(25) = OK");
        validateAge(25);

        sub("throw NullPointerException explicitly");
        try {
            processName(null);
        } catch (NullPointerException e) {
            System.out.println("  ✘ " + e.getMessage());
        }
        processName("Alice");

        sub("Re-throwing exceptions");
        try {
            riskyOperation();
        } catch (RuntimeException e) {
            System.out.println("  ✘ Re-thrown caught: " + e.getMessage());
        }

        header("throws — Method Signature Declaration");

        sub("throws declares checked exceptions");
        try {
            readConfig("config.properties");
        } catch (IOException e) {
            System.out.println("  ✘ IOException caught in caller: " + e.getMessage());
        }

        sub("throws chain — propagation through methods");
        try {
            level1();
        } catch (Exception e) {
            System.out.println("  ✘ Caught in main: " + e.getMessage());
            System.out.println("  Caused by       : "
                    + (e.getCause() != null ? e.getCause().getMessage() : "none"));
        }

        // ════════════════════════════════════════════════════
        // 5. EXCEPTION HIERARCHY & METHODS
        // ════════════════════════════════════════════════════
        section("5. EXCEPTION HIERARCHY & METHODS");

        header("Throwable Methods");

        sub("getMessage(), toString(), getClass()");
        try {
            int[] a2 = new int[5];
            a2[10] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  getMessage()      : " + e.getMessage());
            System.out.println("  toString()        : " + e.toString());
            System.out.println("  getClass()        : " + e.getClass().getName());
            System.out.println("  getSimpleName()   : " + e.getClass().getSimpleName());
        }

        sub("getStackTrace()");
        try {
            stackTraceDemo();
        } catch (RuntimeException e) {
            System.out.println("  getMessage()      : " + e.getMessage());
            System.out.println("  Stack trace (top 3):");
            StackTraceElement[] st = e.getStackTrace();
            for (int i = 0; i < Math.min(3, st.length); i++) {
                System.out.println("    at " + st[i]);
            }
        }

        sub("getCause() — Exception Chaining");
        try {
            chainedOperation();
        } catch (RuntimeException e) {
            System.out.println("  High-level: " + e.getMessage());
            System.out.println("  Cause      : "
                    + (e.getCause() != null ? e.getCause().getMessage() : "null"));
            System.out.println("  Root cause : "
                    + (e.getCause() != null && e.getCause().getCause() != null
                    ? e.getCause().getCause().getMessage() : "null"));
        }

        sub("Catching parent Exception class");
        String[] inputs = {"10", "abc", null};
        for (String input : inputs) {
            try {
                System.out.println("  parse(\"" + input + "\") = "
                        + strictParse(input));
            } catch (IllegalArgumentException e) {
                System.out.printf("  ✘ [%-26s] %s%n",
                        e.getClass().getSimpleName(), e.getMessage());
            }
        }

        // ════════════════════════════════════════════════════
        // 6. CUSTOM EXCEPTIONS
        // ════════════════════════════════════════════════════
        section("6. CUSTOM EXCEPTIONS");

        header("Custom Checked Exception");

        sub("InsufficientFundsException (checked)");
        BankAccount account = new BankAccount("ACC001","Alice",5000);
        System.out.println("  Account: " + account);
        try {
            account.deposit(2000);
            account.withdraw(3000);
            account.withdraw(10000);   // will throw!
        } catch (InsufficientFundsException e) {
            System.out.println("  ✘ " + e.getMessage());
            System.out.printf("  Required: ₹%.0f  Available: ₹%.0f  Shortfall: ₹%.0f%n",
                    e.getRequired(), e.getAvailable(), e.getShortfall());
        }

        sub("InvalidAgeException (unchecked)");
        String[] names  = {"Alice","Bob","Charlie","Diana"};
        int[]    ages   = {25, -3, 200, 18};
        for (int i = 0; i < names.length; i++) {
            try {
                Person2 p = new Person2(names[i], ages[i]);
                System.out.println("  ✔ Created: " + p);
            } catch (InvalidAgeException e) {
                System.out.println("  ✘ " + e.getMessage()
                        + " [age=" + e.getInvalidAge() + "]");
            }
        }

        header("Custom Exception Hierarchy");

        sub("AppException hierarchy");
        processRequest("/api/users/999",   "GET");
        processRequest("/api/products/1",  "GET");
        processRequest("/api/admin/secret","GET");
        processRequest("/api/orders/1",    "DELETE");

        header("Exception with Error Codes");

        sub("ApiException with HTTP status codes");
        String[] endpoints = {"/users","/admin","/products/abc","/server-error"};
        for (String ep : endpoints) {
            try {
                callApi(ep);
            } catch (ApiException e) {
                System.out.printf("  ✘ [%d %s] %s%n",
                        e.getStatusCode(), e.getErrorCode(), e.getMessage());
            }
        }

        // ════════════════════════════════════════════════════
        // 7. EXCEPTION CHAINING
        // ════════════════════════════════════════════════════
        section("7. EXCEPTION CHAINING");

        header("Wrapping Low-Level in High-Level");

        sub("Database → Service → Controller chain");
        try {
            userController("findUser", 999);
        } catch (ServiceException e) {
            System.out.println("  ✘ Controller caught: " + e.getMessage());
            Throwable cause = e.getCause();
            int depth = 1;
            while (cause != null) {
                System.out.println("  " + "  ".repeat(depth)
                        + "↳ Caused by [" + cause.getClass().getSimpleName()
                        + "]: " + cause.getMessage());
                cause = cause.getCause();
                depth++;
            }
        }

        sub("initCause() vs constructor chaining");
        try {
            operationWithInitCause();
        } catch (RuntimeException e) {
            System.out.println("  ✘ " + e.getMessage());
            System.out.println("  Cause: " + e.getCause().getMessage());
        }

        // ════════════════════════════════════════════════════
        // 8. try-with-resources
        // ════════════════════════════════════════════════════
        section("8. try-with-resources");

        header("AutoCloseable Resources");

        sub("Single resource");
        System.out.println("  Opening single resource:");
        try (ManagedResource r = new ManagedResource("DB-Connection")) {
            r.use();
            System.out.println("  Resource used successfully");
        } catch (Exception e) {
            System.out.println("  ✘ " + e.getMessage());
        }
        // r.close() called automatically

        sub("Multiple resources (closed in reverse order)");
        System.out.println("  Opening multiple resources:");
        try (ManagedResource r1 = new ManagedResource("File-Reader");
             ManagedResource r2 = new ManagedResource("DB-Writer");
             ManagedResource r3 = new ManagedResource("Net-Socket")) {
            r1.use();
            r2.use();
            r3.use();
        } catch (Exception e) {
            System.out.println("  ✘ " + e.getMessage());
        }
        System.out.println("  ✔ All closed in REVERSE order: r3→r2→r1");

        sub("Resource that throws on close (suppressed exceptions)");
        System.out.println("  Suppressed exception demo:");
        try (FailingResource fr = new FailingResource("Flaky-DB")) {
            fr.use();
        } catch (Exception e) {
            System.out.println("  Primary exception  : " + e.getMessage());
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable s : suppressed) {
                System.out.println("  Suppressed         : " + s.getMessage());
            }
        }

        sub("try-with-resources vs finally");
        System.out.println("  try-with-resources:");
        System.out.println("  ✔ Cleaner syntax");
        System.out.println("  ✔ Handles suppressed exceptions properly");
        System.out.println("  ✔ Closes even if constructor throws");
        System.out.println("  ✔ Multiple resources in one try");

        // ════════════════════════════════════════════════════
        // 9. CHECKED vs UNCHECKED DEEP DIVE
        // ════════════════════════════════════════════════════
        section("9. CHECKED vs UNCHECKED — DEEP DIVE");

        header("Checked Exceptions — Must Handle");

        sub("throws declaration forces callers to handle");
        System.out.println("  readFile() declares throws IOException");
        try {
            String content = readFileSafe("data.txt");
            System.out.println("  Content: " + content);
        } catch (IOException e) {
            System.out.println("  ✘ " + e.getClass().getSimpleName()
                    + ": " + e.getMessage());
        }

        sub("Checked exception propagation");
        try {
            loadUserFromDB(42);
        } catch (Exception e) {
            System.out.println("  ✘ " + e.getMessage());
        }

        header("Unchecked Exceptions — Programmer's Responsibility");

        sub("Common unchecked exceptions");
        demonstrateUnchecked();

        sub("When to use checked vs unchecked");
        System.out.println();
        System.out.printf("  %-25s %-25s%n","Checked","Unchecked");
        sep();
        String[][] comparison = {
                {"Extends Exception",       "Extends RuntimeException"},
                {"Compile-time enforced",   "Runtime only"},
                {"Recoverable conditions",  "Programming bugs"},
                {"IOException, SQLException","NPE, ArithmeticException"},
                {"throws in signature",     "No throws needed"},
                {"Use: external resources", "Use: invalid args, logic"},
        };
        for (String[] row : comparison)
            System.out.printf("  %-25s %-25s%n", row[0], row[1]);

        // ════════════════════════════════════════════════════
        // 10. EXCEPTION PROPAGATION
        // ════════════════════════════════════════════════════
        section("10. EXCEPTION PROPAGATION");

        header("Call Stack Propagation");

        sub("Exception propagates UP the call stack");
        System.out.println("  main → methodA → methodB → methodC");
        System.out.println("  Exception in methodC propagates up:");
        try {
            propagateA();
        } catch (RuntimeException e) {
            System.out.println("  ✔ Caught in main: " + e.getMessage());
        }

        sub("Partial propagation — caught mid-stack");
        System.out.println("  Exception caught in methodB, not reaching main:");
        partialPropagateA();
        System.out.println("  ✔ Execution continued after catch in mid-stack");

        // ════════════════════════════════════════════════════
        // 11. BEST PRACTICES
        // ════════════════════════════════════════════════════
        section("11. BEST PRACTICES");

        header("DO's and DON'Ts");

        sub("✘ BAD: Swallowing exceptions");
        System.out.println("  try {");
        System.out.println("      riskyOp();");
        System.out.println("  } catch (Exception e) {} // NEVER do this!");

        sub("✔ GOOD: Log and handle properly");
        System.out.println("  catch (Exception e) {");
        System.out.println("      logger.error(\"Operation failed\", e);");
        System.out.println("      throw new ServiceException(\"...\", e);");
        System.out.println("  }");

        sub("✘ BAD: Too broad catch");
        System.out.println("  catch (Exception e) { ... }   // hides bugs");

        sub("✔ GOOD: Catch specific exceptions");
        System.out.println("  catch (FileNotFoundException e) { ... }");
        System.out.println("  catch (IOException e)           { ... }");

        sub("✘ BAD: Using exceptions for flow control");
        System.out.println("  Slow approach (exceptions are expensive):");
        long start = System.nanoTime();
        int count = 0;
        for (int i = 0; i < 100; i++) {
            try {
                if (i == 50) throw new RuntimeException("stop");
                count++;
            } catch (RuntimeException e) { /* flow control — BAD */ }
        }
        System.out.println("  Time (bad): " + (System.nanoTime()-start)/1000 + "μs");

        sub("✔ GOOD: Use boolean/return for flow control");
        start = System.nanoTime();
        count = 0;
        for (int i = 0; i < 100; i++) {
            if (i == 50) break;   // clean flow control
            count++;
        }
        System.out.println("  Time (good):" + (System.nanoTime()-start)/1000 + "μs");

        sub("✔ GOOD: Always use try-with-resources");
        System.out.println("  try (InputStream is = new FileInputStream(f)) {");
        System.out.println("      // auto-closed ✔");
        System.out.println("  }");

        sub("✔ GOOD: Include context in exception message");
        try {
            processUser(null, -1);
        } catch (IllegalArgumentException e) {
            System.out.println("  ✘ Good message: " + e.getMessage());
        }

        // ════════════════════════════════════════════════════
        // 12. REAL-WORLD EXAMPLES
        // ════════════════════════════════════════════════════
        section("12. REAL-WORLD EXAMPLES");

        header("Example 1: ATM System");
        atmSystemDemo();

        header("Example 2: File Parser");
        fileParserDemo();

        header("Example 3: REST API Simulation");
        restApiDemo();

        header("Example 4: Student Registration");
        studentRegistrationDemo();

        System.out.println(
                "\n##################################################");
        System.out.println(
                "#   Exception Handling in Java — Done! ✔       #");
        System.out.println(
                "##################################################");
    }

    // ════════════════════════════════════════════════════════
    //  HELPER METHODS
    // ════════════════════════════════════════════════════════

    static String getHttpMessage(int code) {
        return switch (code) {
            case 200 -> "OK";
            case 404 -> "Not Found";
            case 500 -> "Internal Server Error";
            default  -> "Unknown";
        };
    }

    static int finallyWithReturn() {
        try {
            System.out.println("    try: returning 1");
            return 1;
        } finally {
            System.out.println("    finally: runs before return!");
            // NOT overriding return here
        }
    }

    static int finallyReturn() {
        // Demonstrating that finally executes even when try has return
        int result = 1;
        try {
            // Some logic before return
            System.out.println("  try: preparing to return " + result);
        } finally {
            System.out.println("  finally: executed after return from try");
            // The original example had 'return 2;' here which is bad practice
            // We removed the return statement from finally to follow best practices
        }
        return result;
    }

    static void validateAge(int age) {
        if (age < 0)   throw new IllegalArgumentException(
                "Age cannot be negative: " + age);
        if (age < 18)  throw new IllegalArgumentException(
                "Must be 18+, got: " + age);
        System.out.println("  ✔ Valid age: " + age);
    }

    static void processName(String name) {
        if (name == null) throw new NullPointerException(
                "Name must not be null");
        System.out.println("  ✔ Processing: " + name.toUpperCase());
    }

    @SuppressWarnings("unused")
    static void riskyOperation() {
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("  Caught internally, re-throwing as RuntimeException");
            throw new RuntimeException("Operation failed: division error", e);
        }
    }

    static void readConfig(String filename) throws IOException {
        throw new FileNotFoundException(
                "Config file not found: " + filename);
    }

    static void level1() throws Exception {
        try { level2(); }
        catch (RuntimeException e) {
            throw new Exception("Level1 failed", e);
        }
    }

    static void level2() throws RuntimeException {
        try { level3(); }
        catch (ArithmeticException e) {
            throw new RuntimeException("Level2 failed", e);
        }
    }

    @SuppressWarnings("unused")
    static void level3() {
        int x = 10 / 0;
    }

    static void stackTraceDemo() {
        innerMethod();
    }

    static void innerMethod() {
        throw new RuntimeException("Deep exception from innerMethod");
    }

    static void chainedOperation() {
        try {
            try {
                throw new SQLException2("DB connection refused");
            } catch (SQLException2 low) {
                throw new DataAccessException2("Data layer failed", low);
            }
        } catch (DataAccessException2 mid) {
            throw new ServiceException2("Service unavailable", mid);
        }
    }

    static int strictParse(String input) {
        if (input == null) throw new NullPointerException("Input is null");
        return Integer.parseInt(input); // may throw NFE
    }

    static void processRequest(String path, String method) {
        try {
            apiHandler(path, method);
            System.out.println("  ✔ " + method + " " + path + " → 200 OK");
        } catch (NotFoundException e) {
            System.out.println("  ✘ 404 Not Found: " + e.getMessage());
        } catch (AccessDeniedException e) {
            System.out.println("  ✘ 403 Forbidden: " + e.getMessage());
        } catch (AppException e) {
            System.out.println("  ✘ App Error [" + e.getCode() + "]: " + e.getMessage());
        }
    }

    static void apiHandler(String path, String method) {
        if (path.contains("999"))    throw new NotFoundException("User not found");
        if (path.contains("admin"))  throw new AccessDeniedException("Admin area restricted");
        if (method.equals("DELETE")) throw new AppException("Delete not allowed","METHOD_NA");
    }

    static void callApi(String endpoint) {
        switch (endpoint) {
            case "/admin"         -> throw new ApiException(403,"FORBIDDEN","Access denied");
            case "/products/abc"  -> throw new ApiException(400,"BAD_REQUEST","Invalid ID");
            case "/server-error"  -> throw new ApiException(500,"SERVER_ERROR","Internal error");
            default               -> System.out.println("  ✔ GET " + endpoint + " → 200 OK");
        }
    }

    static void userController(String op, int id) throws ServiceException {
        try {
            userService(op, id);
        } catch (DataAccessException2 e) {
            throw new ServiceException("UserService failed for id=" + id, e);
        }
    }

    static void userService(String op, int id) throws DataAccessException2 {
        try {
            userRepository(op, id);
        } catch (SQLException2 e) {
            throw new DataAccessException2("Repository layer error", e);
        }
    }

    static void userRepository(String op, int id) throws SQLException2 {
        if (id == 999) throw new SQLException2(
                "No row found: SELECT * FROM users WHERE id=" + id);
    }

    @SuppressWarnings("unused")
    static void operationWithInitCause() {
        RuntimeException ex = new RuntimeException("High-level failure");
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            ex.initCause(e);
        }
        throw ex;
    }

    static String readFileSafe(String filename) throws IOException {
        // Simulate file not found
        throw new FileNotFoundException("File not found: " + filename);
    }

    static void loadUserFromDB(int id) throws Exception {
        try {
            simulateDbQuery(id);
        } catch (SQLException2 e) {
            throw new Exception("Failed to load user id=" + id, e);
        }
    }

    static void simulateDbQuery(int id) throws SQLException2 {
        if (id > 0) throw new SQLException2(
                "Connection timeout after 30s");
    }

    @SuppressWarnings({ "unused", "null" })
    static void demonstrateUnchecked() {
        // NPE
        safeTry(() -> { String s = null; s.length(); },
                "NullPointerException");
        // AIOOBE
        safeTry(() -> { int[] a = {1,2,3}; int x = a[5]; },
                "ArrayIndexOutOfBoundsException");
        // ArithmeticException
        safeTry(() -> { int x = 5/0; },
                "ArithmeticException");
        // StackOverflow
        safeTry(() -> infiniteRecurse(0),
                "StackOverflowError");
        // NFE
        safeTry(() -> Integer.parseInt("xyz"),
                "NumberFormatException");
        // CCE
        safeTry(() -> { Object o = "text"; Integer i = (Integer)o; },
                "ClassCastException");
        // NASE (Negative array size)
        safeTry(() -> { int[] a = new int[-1]; },
                "NegativeArraySizeException");
    }

    static void safeTry(Runnable r, String label) {
        try {
            r.run();
        } catch (Throwable e) {
            System.out.printf("  ✘ %-35s: %s%n",
                    label, e.getClass().getSimpleName());
        }
    }

    static void infiniteRecurse(int n) { infiniteRecurse(n+1); }

    static void propagateA() { propagateB(); }
    static void propagateB() { propagateC(); }
    static void propagateC() {
        System.out.println("  Exception thrown in propagateC()");
        throw new RuntimeException("Originated in methodC");
    }

    static void partialPropagateA() { partialPropagateB(); }
    static void partialPropagateB() {
        try {
            partialPropagateC();
        } catch (RuntimeException e) {
            System.out.println("  Caught mid-stack in methodB: " + e.getMessage());
        }
    }

    static void partialPropagateC() {
        throw new RuntimeException("Exception from methodC");
    }

    static void processUser(String name, int age) {
        if (name == null || age < 0) {
            throw new IllegalArgumentException(
                    "Invalid user data: name='" + name + "', age=" + age
                            + " (name must not be null, age must be ≥ 0)");
        }
    }

    // ════════════════════════════════════════════════════════
    //  REAL-WORLD DEMOS
    // ════════════════════════════════════════════════════════

    static void atmSystemDemo() {
        ATM atm = new ATM();
        System.out.println("  ATM System:");
        sep();
        String[][] transactions = {
                {"Alice","5000","withdraw","2000"},
                {"Bob",  "1000","withdraw","5000"},  // insufficient
                {"Charlie","0","withdraw","100"},     // zero balance
                {"Diana","3000","deposit", "-500"},   // negative deposit
                {"Eve",  "2000","withdraw","2000"},   // exact balance
        };
        for (String[] tx : transactions) {
            atm.processTransaction(tx[0],
                    Double.parseDouble(tx[1]),
                    tx[2],
                    Double.parseDouble(tx[3]));
        }
    }

    static void fileParserDemo() {
        System.out.println("  File Parser (CSV simulation):");
        sep();
        String[] csvLines = {
                "Alice,25,92.5",
                "Bob,abc,88.0",     // bad age
                "Charlie,22,",      // missing marks
                ",18,75.0",         // missing name
                "Diana,30,101.5",   // marks > 100
                "Eve,28,85.5",
        };
        List<ParsedRecord> records = new ArrayList<>();
        int line = 0;
        for (String csv : csvLines) {
            line++;
            try {
                records.add(parseRecord(csv, line));
                System.out.println("  ✔ Line " + line + ": " + records.get(records.size()-1));
            } catch (ParseException2 e) {
                System.out.println("  ✘ Line " + line + ": " + e.getMessage());
            }
        }
        System.out.println("  Parsed " + records.size() + "/" + csvLines.length + " records");
    }

    static ParsedRecord parseRecord(String csv, int lineNum) throws ParseException2 {
        String[] parts = csv.split(",", -1);
        if (parts.length != 3)
            throw new ParseException2("Expected 3 fields, got " + parts.length, lineNum);
        String name = parts[0].trim();
        if (name.isEmpty())
            throw new ParseException2("Name is empty", lineNum);
        int age;
        try {
            age = Integer.parseInt(parts[1].trim());
        } catch (NumberFormatException e) {
            throw new ParseException2("Invalid age: '" + parts[1] + "'", lineNum);
        }
        if (parts[2].trim().isEmpty())
            throw new ParseException2("Marks field is empty", lineNum);
        double marks;
        try {
            marks = Double.parseDouble(parts[2].trim());
        } catch (NumberFormatException e) {
            throw new ParseException2("Invalid marks: '" + parts[2] + "'", lineNum);
        }
        if (marks < 0 || marks > 100)
            throw new ParseException2("Marks out of range: " + marks, lineNum);
        return new ParsedRecord(name, age, marks);
    }

    static void restApiDemo() {
        System.out.println("  REST API Simulation:");
        sep();
        String[][] requests = {
                {"GET",    "/api/users/1"},
                {"GET",    "/api/users/999"},
                {"POST",   "/api/users"},
                {"DELETE", "/api/users/1"},
                {"GET",    "/api/admin"},
                {"GET",    "/api/products/abc"},
        };
        RestController controller = new RestController();
        for (String[] req : requests) {
            controller.handle(req[0], req[1]);
        }
    }

    static void studentRegistrationDemo() {
        System.out.println("  Student Registration:");
        sep();
        StudentRegistry registry = new StudentRegistry();
        String[][] students = {
                {"Alice",  "20", "alice@uni.edu",   "CS"},
                {"",       "22", "bob@uni.edu",     "Math"},  // empty name
                {"Charlie","17", "charlie@uni.edu", "CS"},    // underage
                {"Diana",  "25", "notanemail",      "Physics"},// bad email
                {"Eve",    "21", "eve@uni.edu",     "Unknown"},// bad dept
                {"Frank",  "23", "frank@uni.edu",   "CS"},
        };
        for (String[] s : students) {
            registry.register(s[0], s[1], s[2], s[3]);
        }
        registry.printRoster();
    }
}

// ════════════════════════════════════════════════════════
//  SUPPORTING CLASSES
// ════════════════════════════════════════════════════════

// ── Fake DB classes for demo ──
class SQLException2 extends Exception {
    SQLException2(String msg) { super(msg); }
}

class DataAccessException2 extends Exception {
    DataAccessException2(String msg, Throwable cause) { super(msg, cause); }
}

class ServiceException2 extends RuntimeException {
    ServiceException2(String msg, Throwable cause) { super(msg, cause); }
}

// ── FakeConnection ──
class FakeConnection {
    String dsn;
    FakeConnection(String dsn) {
        this.dsn = dsn;
        System.out.println("  ✔ Connected to: " + dsn);
    }
    void query(String sql) {
        System.out.println("  ✔ Executing: " + sql);
    }
    void close() {
        System.out.println("  ✔ Connection closed (finally block)");
    }
}

// ── ManagedResource (AutoCloseable) ──
class ManagedResource implements AutoCloseable {
    String name;
    ManagedResource(String name) {
        this.name = name;
        System.out.println("  OPEN  → " + name);
    }
    void use() { System.out.println("  USE   → " + name); }
    @Override
    public void close() {
        System.out.println("  CLOSE ← " + name + " (auto-closed)");
    }
}

// ── FailingResource (throws on close) ──
class FailingResource implements AutoCloseable {
    String name;
    FailingResource(String name) {
        this.name = name;
        System.out.println("  OPEN  → " + name);
    }
    void use() {
        System.out.println("  USE   → " + name);
        throw new RuntimeException("Exception during USE of " + name);
    }
    @Override
    public void close() throws Exception {
        System.out.println("  CLOSE ← " + name + " (close fails too)");
        throw new Exception("Exception during CLOSE of " + name);
    }
}

// ── Custom Exceptions ──
class InsufficientFundsException extends Exception {
    private final double required;
    private final double available;
    InsufficientFundsException(double required, double available) {
        super(String.format(
                "Insufficient funds: required ₹%.0f, available ₹%.0f",
                required, available));
        this.required  = required;
        this.available = available;
    }
    double getRequired()  { return required;  }
    double getAvailable() { return available; }
    double getShortfall() { return required - available; }
}

class InvalidAgeException extends RuntimeException {
    private final int invalidAge;
    InvalidAgeException(int age) {
        super("Invalid age: " + age + ". Age must be between 0 and 150.");
        this.invalidAge = age;
    }
    int getInvalidAge() { return invalidAge; }
}

class AppException extends RuntimeException {
    private final String code;
    AppException(String msg, String code) { super(msg); this.code=code; }
    String getCode() { return code; }
}

class NotFoundException extends AppException {
    NotFoundException(String msg) { super(msg,"NOT_FOUND"); }
}

class AccessDeniedException extends AppException {
    AccessDeniedException(String msg) { super(msg,"ACCESS_DENIED"); }
}

class ApiException extends RuntimeException {
    private final int    statusCode;
    private final String errorCode;
    ApiException(int status, String code, String msg) {
        super(msg);
        this.statusCode = status;
        this.errorCode  = code;
    }
    int    getStatusCode() { return statusCode; }
    String getErrorCode()  { return errorCode;  }
}

class ServiceException extends Exception {
    ServiceException(String msg, Throwable cause) { super(msg, cause); }
}

// ── BankAccount ──
class BankAccount {
    String accNo, holder;
    double balance;
    BankAccount(String accNo, String holder, double balance) {
        this.accNo=accNo; this.holder=holder; this.balance=balance;
    }
    void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) throw new IllegalArgumentException(
                "Deposit amount must be positive: " + amount);
        balance += amount;
        System.out.printf("  ✔ Deposited ₹%.0f | Balance: ₹%.0f%n",
                amount, balance);
    }
    void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException(
                "Withdrawal amount must be positive: " + amount);
        if (amount > balance)
            throw new InsufficientFundsException(amount, balance);
        balance -= amount;
        System.out.printf("  ✔ Withdrew ₹%.0f  | Balance: ₹%.0f%n",
                amount, balance);
    }
    @Override public String toString() {
        return String.format("Account{%s, %s, ₹%.0f}",
                accNo, holder, balance);
    }
}

class Person2 {
    String name; int age;
    Person2(String name, int age) {
        if (age < 0 || age > 150) throw new InvalidAgeException(age);
        this.name=name; this.age=age;
    }
    @Override public String toString() {
        return name + "(age=" + age + ")";
    }
}

// ── ParseException ──
class ParseException2 extends Exception {
    private final int lineNumber;
    ParseException2(String msg, int line) {
        super("[Line " + line + "] " + msg);
        this.lineNumber = line;
    }
    int getLineNumber() { return lineNumber; }
}

class ParsedRecord {
    String name; int age; double marks;
    ParsedRecord(String n, int a, double m) {
        name=n; age=a; marks=m;
    }
    @Override public String toString() {
        return String.format("Record{%s, age=%d, marks=%.1f}",
                name, age, marks);
    }
}

// ── ATM ──
class ATM {
    void processTransaction(String user, double balance,
                            String type, double amount) {
        try {
            if (amount <= 0)
                throw new IllegalArgumentException(
                        "Amount must be positive: " + amount);
            if (type.equals("withdraw") && amount > balance)
                throw new InsufficientFundsException(amount, balance);
            double newBalance = type.equals("deposit")
                    ? balance + amount : balance - amount;
            System.out.printf("  ✔ %-10s %-8s ₹%6.0f → Balance: ₹%.0f%n",
                    user, type, amount, newBalance);
        } catch (InsufficientFundsException e) {
            System.out.printf("  ✘ %-10s Insufficient funds (need ₹%.0f, have ₹%.0f)%n",
                    user, amount, balance);
        } catch (IllegalArgumentException e) {
            System.out.printf("  ✘ %-10s Invalid amount: %s%n", user, e.getMessage());
        }
    }
}

// ── REST Controller ──
class RestController {
    void handle(String method, String path) {
        try {
            String response = dispatch(method, path);
            System.out.printf("  ✔ %-7s %-25s → %s%n", method, path, response);
        } catch (ApiException e) {
            System.out.printf("  ✘ %-7s %-25s → %d %s: %s%n",
                    method, path, e.getStatusCode(),
                    e.getErrorCode(), e.getMessage());
        }
    }
    String dispatch(String method, String path) {
        if (path.contains("/admin"))        throw new ApiException(403,"FORBIDDEN","Access denied");
        if (path.contains("/999"))          throw new ApiException(404,"NOT_FOUND","User 999 not found");
        if (path.contains("/abc"))          throw new ApiException(400,"BAD_REQUEST","Invalid ID format");
        if (method.equals("DELETE"))        throw new ApiException(405,"METHOD_NOT_ALLOWED","DELETE not supported");
        if (method.equals("POST"))          return "201 Created";
        return "200 OK";
    }
}

// ── Student Registry ──
class StudentRegistry {
    List<String[]>  roster = new ArrayList<>();
    Set<String>     validDepts = Set.of("CS","Math","Physics","Chemistry","Biology");

    void register(String name, String ageStr, String email, String dept) {
        try {
            if (name == null || name.trim().isEmpty())
                throw new IllegalArgumentException("Name is empty");
            int age;
            try {
                age = Integer.parseInt(ageStr);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid age format: " + ageStr);
            }
            if (age < 18) throw new IllegalArgumentException(
                    "Underage: " + age + " (minimum 18)");
            if (!email.contains("@") || !email.contains("."))
                throw new IllegalArgumentException("Invalid email: " + email);
            if (!validDepts.contains(dept))
                throw new IllegalArgumentException("Unknown department: " + dept);
            roster.add(new String[]{name, String.valueOf(age), email, dept});
            System.out.printf("  ✔ Registered: %-10s age=%-3s dept=%s%n",
                    name, ageStr, dept);
        } catch (IllegalArgumentException e) {
            System.out.printf("  ✘ Rejected  : %-10s → %s%n",
                    name.isEmpty() ? "(empty)" : name, e.getMessage());
        }
    }

    void printRoster() {
        System.out.println("\n  Final Roster (" + roster.size() + " students):");
        ExceptionHandling.sep();
        System.out.printf("  %-12s %-5s %-20s %s%n",
                "Name","Age","Email","Dept");
        ExceptionHandling.sep();
        roster.forEach(s -> System.out.printf("  %-12s %-5s %-20s %s%n",
                s[0],s[1],s[2],s[3]));
    }
}
