/*
 * ============================================================
 *              LOOPS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS A LOOP?
 * ----------------
 * A loop is a control flow statement that repeatedly executes
 * a block of code as long as a specified condition is TRUE.
 * Once the condition becomes FALSE, the loop stops.
 *
 * WHY USE LOOPS?
 * ---------------
 * Without loops:
 *   System.out.println("Hello");  // line 1
 *   System.out.println("Hello");  // line 2
 *   System.out.println("Hello");  // line 3 ... repeated 100x
 *
 * With loops:
 *   for (int i = 0; i < 100; i++) {
 *       System.out.println("Hello");  // just ONE line!
 *   }
 *
 * ============================================================
 * TYPES OF LOOPS IN JAVA
 * ============================================================
 *
 *  1. for Loop
 *  2. while Loop
 *  3. do-while Loop
 *  4. for-each Loop (Enhanced for)
 *  5. Nested Loops
 *  6. Infinite Loop
 *  7. Loop Control Statements
 *     a. break
 *     b. continue
 *     c. return (exits method)
 *     d. Labeled break / continue
 *
 * ============================================================
 * 1. for LOOP
 * ============================================================
 *
 *  Used when the number of iterations is KNOWN in advance.
 *  Most compact loop — init, condition, update in ONE line.
 *
 *  Syntax:
 *  --------
 *  for (initialization; condition; update) {
 *      // body — executes while condition is true
 *  }
 *
 *  Execution Flow:
 *  ----------------
 *  Step 1: initialization  → runs ONCE at the start
 *  Step 2: condition check → if TRUE  → execute body
 *                          → if FALSE → exit loop
 *  Step 3: execute body
 *  Step 4: update          → runs after each iteration
 *  Step 5: go back to Step 2
 *
 *  Example:
 *  for (int i = 1; i <= 5; i++) {
 *      System.out.println(i);   // prints 1 2 3 4 5
 *  }
 *
 *  Variations:
 *  - Count up   : i++
 *  - Count down : i--
 *  - Step by 2  : i += 2
 *  - Multiple vars: for (int i=0, j=10; i<j; i++, j--)
 *
 * ============================================================
 * 2. while LOOP
 * ============================================================
 *
 *  Used when number of iterations is NOT known in advance.
 *  Checks condition BEFORE executing the body.
 *  Called an ENTRY-CONTROLLED loop.
 *
 *  Syntax:
 *  --------
 *  while (condition) {
 *      // body — executes while condition is true
 *      // update variable inside body!
 *  }
 *
 *  Execution Flow:
 *  ----------------
 *  Step 1: Check condition
 *          → if FALSE → skip loop entirely (0 iterations possible)
 *          → if TRUE  → execute body
 *  Step 2: Execute body
 *  Step 3: Go back to Step 1
 *
 *  ⚠ Must update loop variable inside body
 *    or risk INFINITE LOOP!
 *
 * ============================================================
 * 3. do-while LOOP
 * ============================================================
 *
 *  Executes body FIRST, then checks the condition.
 *  Called an EXIT-CONTROLLED loop.
 *  Guarantees the body runs AT LEAST ONCE.
 *
 *  Syntax:
 *  --------
 *  do {
 *      // body — executes at least once
 *  } while (condition);   // ← semicolon required!
 *
 *  Execution Flow:
 *  ----------------
 *  Step 1: Execute body (always at least once)
 *  Step 2: Check condition
 *          → if TRUE  → go back to Step 1
 *          → if FALSE → exit loop
 *
 *  Use case:
 *  - Menu-driven programs
 *  - Input validation (ask at least once)
 *  - ATM PIN entry
 *
 * ============================================================
 * 4. for-each LOOP (Enhanced for)
 * ============================================================
 *
 *  Designed specifically to iterate over arrays and collections.
 *  Cleaner, simpler syntax — no index management needed.
 *
 *  Syntax:
 *  --------
 *  for (dataType element : arrayOrCollection) {
 *      // use element directly
 *  }
 *
 *  Limitations:
 *  - Cannot modify array elements directly
 *  - No access to index by default
 *  - Cannot iterate in reverse
 *  - Cannot skip elements (no i += 2)
 *
 * ============================================================
 * 5. NESTED LOOPS
 * ============================================================
 *
 *  A loop inside another loop.
 *  Inner loop completes ALL iterations for each single
 *  iteration of the outer loop.
 *
 *  Total iterations = outer iterations × inner iterations
 *
 *  Example: outer=3, inner=3 → 3×3 = 9 total iterations
 *
 *  Common uses:
 *  - Printing patterns (stars, numbers, pyramids)
 *  - Matrix/2D array operations
 *  - Multiplication tables
 *
 * ============================================================
 * 6. LOOP CONTROL STATEMENTS
 * ============================================================
 *
 *  break:
 *  ------
 *  - Immediately EXITS the loop (or switch).
 *  - Skips remaining iterations entirely.
 *  - Use: search found, error condition, exit menu.
 *
 *  continue:
 *  ----------
 *  - SKIPS current iteration, moves to next.
 *  - Does NOT exit the loop.
 *  - Use: skip invalid values, skip even/odd numbers.
 *
 *  Labeled break/continue:
 *  ------------------------
 *  - Controls WHICH loop to break/continue in nested loops.
 *  - Label is placed before the outer loop.
 *  - Syntax: outerLoop: for(...) { break outerLoop; }
 *
 * ============================================================
 * for vs while vs do-while — WHEN TO USE?
 * ============================================================
 *
 *  Loop        When to use
 *  ----------  -------------------------------------------
 *  for         Iterations known in advance (1 to 10)
 *  while       Iterations unknown, condition checked first
 *  do-while    Must run at least once (menus, validation)
 *  for-each    Iterating arrays/collections cleanly
 *  nested      Patterns, matrices, combinations
 *
 * ============================================================
 * BEST PRACTICES
 * ============================================================
 *
 *  1. Always ensure loop will eventually terminate
 *  2. Keep loop body small and focused
 *  3. Use for-each when index not needed
 *  4. Avoid modifying loop variable inside body
 *  5. Use break/continue sparingly for clarity
 *  6. Prefer for loop when count is known
 *  7. Use meaningful loop variable names (not just i,j,k)
 *     for complex nested loops
 *
 * ============================================================
 */

public class LoopsInJava {

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#           LOOPS IN JAVA                  #");
        System.out.println("############################################");

        // ============================================================
        // 1. for LOOP
        // ============================================================
        System.out.println("\n===== 1. for LOOP =====");

        // Basic for loop — count up
        System.out.println("--- Count Up (1 to 5) ---");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Count down
        System.out.println("--- Count Down (5 to 1) ---");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Step by 2 — even numbers
        System.out.println("--- Even Numbers (2 to 20) ---");
        for (int i = 2; i <= 20; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Step by 2 — odd numbers
        System.out.println("--- Odd Numbers (1 to 19) ---");
        for (int i = 1; i <= 19; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Sum of 1 to 100
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("--- Sum of 1 to 100 ---");
        System.out.println("Sum = " + sum);  // 5050

        // Factorial
        int n = 6;
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("--- Factorial of " + n + " ---");
        System.out.println(n + "! = " + factorial);  // 720

        // Multiplication Table
        int tableOf = 5;
        System.out.println("--- Multiplication Table of " + tableOf + " ---");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %2d = %3d%n", tableOf, i, tableOf * i);
        }

        // Multiple variables in for loop
        System.out.println("--- Multiple Variables in for ---");
        for (int i = 0, j = 10; i <= 10; i++, j--) {
            System.out.printf("i=%-3d j=%d%n", i, j);
        }

        // ============================================================
        // 2. while LOOP
        // ============================================================
        System.out.println("\n===== 2. while LOOP =====");

        // Basic while loop
        System.out.println("--- Count 1 to 5 ---");
        int count = 1;
        while (count <= 5) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();

        // Reverse a number
        System.out.println("--- Reverse a Number ---");
        int original = 12345;
        int reversed = 0;
        int temp     = original;
        while (temp != 0) {
            int digit = temp % 10;   // extract last digit
            reversed  = reversed * 10 + digit;
            temp      = temp / 10;   // remove last digit
        }
        System.out.println("Original : " + original);
        System.out.println("Reversed : " + reversed);

        // Count digits in a number
        System.out.println("--- Count Digits ---");
        int num     = 987654;
        int digits  = 0;
        int tempNum = num;
        while (tempNum != 0) {
            digits++;
            tempNum /= 10;
        }
        System.out.println("Number : " + num);
        System.out.println("Digits : " + digits);

        // Sum of digits
        System.out.println("--- Sum of Digits ---");
        int number   = 4567;
        int digitSum = 0;
        int tempN    = number;
        while (tempN != 0) {
            digitSum += tempN % 10;
            tempN    /= 10;
        }
        System.out.println("Number      : " + number);
        System.out.println("Digit Sum   : " + digitSum);  // 4+5+6+7 = 22

        // Power calculation: 2^10
        System.out.println("--- Power: 2^10 ---");
        int base   = 2;
        int exp    = 10;
        int result = 1;
        int e      = exp;
        while (e > 0) {
            result *= base;
            e--;
        }
        System.out.println(base + "^" + exp + " = " + result);

        // ============================================================
        // 3. do-while LOOP
        // ============================================================
        System.out.println("\n===== 3. do-while LOOP =====");

        // Basic do-while
        System.out.println("--- Count 1 to 5 ---");
        int c = 1;
        do {
            System.out.print(c + " ");
            c++;
        } while (c <= 5);
        System.out.println();

        // Even when condition is false from start — runs ONCE
        System.out.println("--- Runs at Least Once ---");
        int x = 100;
        do {
            System.out.println("Executed! x = " + x);  // prints even though x > 10
        } while (x < 10);   // condition FALSE from start

        // Menu simulation
        System.out.println("--- Menu Simulation ---");
        int menuChoice = 2;
        int iteration  = 0;

        do {
            System.out.println("==== MENU ====");
            System.out.println("1. View Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.println("Choice = " + menuChoice);

            switch (menuChoice) {
                case 1 -> System.out.println("→ Balance: ₹10,000");
                case 2 -> System.out.println("→ Withdrew ₹2,000. Remaining: ₹8,000");
                case 3 -> System.out.println("→ Deposited ₹5,000. Total: ₹15,000");
                case 4 -> System.out.println("→ Goodbye! 👋");
                default -> System.out.println("→ Invalid choice.");
            }
            iteration++;
            menuChoice = 4;  // simulate user choosing exit next
        } while (menuChoice != 4 && iteration < 3);
        System.out.println("Menu exited.");

        // ============================================================
        // 4. for-each LOOP (Enhanced for)
        // ============================================================
        System.out.println("\n===== 4. for-each LOOP =====");

        // Iterate over int array
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("--- Integer Array ---");
        for (int num2 : numbers) {
            System.out.print(num2 + " ");
        }
        System.out.println();

        // Iterate over String array
        String[] fruits = {"Apple", "Banana", "Cherry", "Mango", "Orange"};
        System.out.println("--- String Array ---");
        for (String fruit : fruits) {
            System.out.println("🍎 " + fruit);
        }

        // Sum using for-each
        double[] prices = {99.9, 149.5, 299.0, 59.99, 199.0};
        double total    = 0;
        for (double price : prices) {
            total += price;
        }
        System.out.println("--- Sum of Prices ---");
        System.out.printf("Total = ₹%.2f%n", total);

        // Find max using for-each
        int[] scores = {85, 92, 78, 95, 88, 76, 99, 83};
        int   maxScore = scores[0];
        int   minScore = scores[0];
        for (int sc : scores) {
            if (sc > maxScore) maxScore = sc;
            if (sc < minScore) minScore = sc;
        }
        System.out.println("--- Scores Array ---");
        System.out.print("Scores : ");
        for (int sc : scores) System.out.print(sc + " ");
        System.out.println();
        System.out.println("Max    : " + maxScore);
        System.out.println("Min    : " + minScore);

        // ============================================================
        // 5. NESTED LOOPS
        // ============================================================
        System.out.println("\n===== 5. NESTED LOOPS =====");

        // Multiplication Table Grid
        System.out.println("--- Multiplication Table (1-5) ---");
        System.out.print("    ");
        for (int i = 1; i <= 5; i++) System.out.printf("%4d", i);
        System.out.println();
        System.out.println("    --------------------");
        for (int i = 1; i <= 5; i++) {
            System.out.printf("%2d |", i);
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        // Right-angle triangle of stars
        System.out.println("--- Right Triangle Pattern ---");
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Inverted triangle
        System.out.println("--- Inverted Triangle ---");
        for (int row = 5; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Number pyramid
        System.out.println("--- Number Pyramid ---");
        for (int row = 1; row <= 5; row++) {
            // spaces
            for (int sp = 5; sp > row; sp--) System.out.print("  ");
            // numbers
            for (int col = 1; col <= row; col++) System.out.print(col + " ");
            System.out.println();
        }

        // Floyd's Triangle
        System.out.println("--- Floyd's Triangle ---");
        int num3 = 1;
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.printf("%3d", num3++);
            }
            System.out.println();
        }

        // 2D Array traversal
        // System.out.println("--- 2D Array (Matrix) Traversal ---");
        // int[][] matrix = {
        //     {1, 2, 3},
        //     {4, 5, 6},
        //     {7, 8, 9}
        // };
        // for (int row = 0; row < matrix.length; row++) {
        //     for (int col = 0; col < matrix[row].length; col++) {
        //         System.out.printf("%3d", matrix[row][col]);
        //     }
        //     System.out.println();
        // }

        // ============================================================
        // 6. LOOP CONTROL — break
        // ============================================================
        System.out.println("\n===== 6. break STATEMENT =====");

        // Basic break — exit when found
        System.out.println("--- Find first even number ---");
        int[] arr = {3, 7, 9, 4, 11, 6, 8};
        for (int val : arr) {
            if (val % 2 == 0) {
                System.out.println("First even number found: " + val);
                break;   // stop searching after first found
            }
        }

        // Break in while — search simulation
        System.out.println("--- Linear Search with break ---");
        int[] data   = {15, 43, 8, 27, 62, 33, 91};
        int   target = 27;
        int   index  = -1;
        int   idx    = 0;
        while (idx < data.length) {
            if (data[idx] == target) {
                index = idx;
                break;
            }
            idx++;
        }
        System.out.println("Search target : " + target);
        System.out.println(index != -1
            ? "✔ Found at index: " + index
            : "✘ Not found");

        // ============================================================
        // 7. LOOP CONTROL — continue
        // ============================================================
        System.out.println("\n===== 7. continue STATEMENT =====");

        // Skip even numbers — print only odds
        System.out.println("--- Skip Even, Print Odd (1-10) ---");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;  // skip even
            System.out.print(i + " ");
        }
        System.out.println();

        // Skip multiples of 3
        System.out.println("--- Skip Multiples of 3 (1-15) ---");
        for (int i = 1; i <= 15; i++) {
            if (i % 3 == 0) continue;
            System.out.print(i + " ");
        }
        System.out.println();

        // Print only positive numbers from array
        System.out.println("--- Print Only Positives ---");
        int[] mixed = {5, -3, 8, -1, 12, -7, 4, -9, 6};
        for (int val : mixed) {
            if (val < 0) continue;   // skip negatives
            System.out.print(val + " ");
        }
        System.out.println();

        // ============================================================
        // 8. LABELED break & continue
        // ============================================================
        System.out.println("\n===== 8. LABELED break & continue =====");

        // Labeled break — exit OUTER loop from inner loop
        System.out.println("--- Labeled break (exit outer loop) ---");
        outerLoop:
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i == 2 && j == 3) {
                    System.out.println("Breaking outer loop at i=" + i + " j=" + j);
                    break outerLoop;   // exits BOTH loops
                }
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        }
        System.out.println("After labeled break.");

        // Labeled continue — skip current outer iteration
        System.out.println("\n--- Labeled continue (skip outer iteration) ---");
        outer:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 2) {
                    System.out.println("  Skipping rest of i=" + i + " at j=" + j);
                    continue outer;   // skip to next i iteration
                }
                System.out.println("  i=" + i + " j=" + j);
            }
        }

        // ============================================================
        // 9. INFINITE LOOP (controlled)
        // ============================================================
        System.out.println("\n===== 9. INFINITE LOOP (controlled exit) =====");

        // Controlled infinite loop with break
        System.out.println("--- Countdown with controlled loop ---");
        int countdown = 5;
        while (true) {             // infinite loop
            System.out.print(countdown + " ");
            countdown--;
            if (countdown < 0) break;  // manual exit condition
        }
        System.out.println("\n🚀 Liftoff!");

        // ============================================================
        // 10. REAL-WORLD EXAMPLES
        // ============================================================
        System.out.println("\n===== 10. REAL-WORLD EXAMPLES =====");

        // Example 1: Prime Number Check
        System.out.println("--- Prime Numbers (1-50) ---");
        for (int i = 2; i <= 50; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) System.out.print(i + " ");
        }
        System.out.println();

        // Example 2: Fibonacci Series
        System.out.println("--- Fibonacci Series (first 10 terms) ---");
        int fib1 = 0, fib2 = 1;
        System.out.print(fib1 + " " + fib2 + " ");
        for (int i = 2; i < 10; i++) {
            int fib3 = fib1 + fib2;
            System.out.print(fib3 + " ");
            fib1 = fib2;
            fib2 = fib3;
        }
        System.out.println();

        // Example 3: Student Grade Report
        System.out.println("--- Student Grade Report ---");
        String[] students = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        int[]    stuScores = {92, 74, 88, 45, 96};

        System.out.printf("%-10s %-6s %-6s%n", "Name", "Score", "Grade");
        System.out.println("------------------------");
        for (int i = 0; i < students.length; i++) {
            String g = stuScores[i] >= 90 ? "A" :
                       stuScores[i] >= 80 ? "B" :
                       stuScores[i] >= 70 ? "C" :
                       stuScores[i] >= 50 ? "D" : "F";
            System.out.printf("%-10s %-6d %-6s%n",
                    students[i], stuScores[i], g);
        }

        // Example 4: Shopping Bill
        System.out.println("\n--- Shopping Bill ---");
        String[] items    = {"Rice", "Milk", "Eggs", "Bread", "Butter"};
        double[] unitPrices = {55.0, 28.0, 72.0, 45.0, 120.0};
        int[]    qty      = {2, 3, 1, 2, 1};

        double grandTotal = 0;
        System.out.printf("%-10s %6s %5s %10s%n", "Item", "Price", "Qty", "Amount");
        System.out.println("-------------------------------------");
        for (int i = 0; i < items.length; i++) {
            double amount = unitPrices[i] * qty[i];
            grandTotal   += amount;
            System.out.printf("%-10s %6.2f %5d %10.2f%n",
                    items[i], unitPrices[i], qty[i], amount);
        }
        System.out.println("-------------------------------------");
        System.out.printf("%-22s %10.2f%n", "Grand Total :", grandTotal);

        System.out.println("\n############################################");
        System.out.println("#       Loops in Java — Done! ✔            #");
        System.out.println("############################################");
    }
}
