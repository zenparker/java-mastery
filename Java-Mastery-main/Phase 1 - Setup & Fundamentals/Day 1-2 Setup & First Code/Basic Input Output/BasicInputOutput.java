/*
 * ============================================================
 *          BASIC INPUT & OUTPUT IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS INPUT & OUTPUT?
 * ------------------------
 * Input  : Data received by the program (from user/keyboard/file)
 * Output : Data sent from the program (to screen/file/console)
 *
 * ============================================================
 * OUTPUT IN JAVA
 * ============================================================
 *
 * Java uses the System.out object to print data to the console.
 * It belongs to the java.lang package (auto-imported).
 *
 * Methods:
 * --------
 *  1. System.out.print()    — Prints text, NO newline at end
 *  2. System.out.println()  — Prints text + moves to NEXT LINE
 *  3. System.out.printf()   — Prints FORMATTED text (like C's printf)
 *
 * FORMAT SPECIFIERS (used in printf):
 * ------------------------------------
 *  %d  → integer
 *  %f  → float/double
 *  %s  → String
 *  %c  → char
 *  %b  → boolean
 *  %n  → newline
 *  %.2f → double with 2 decimal places
 *
 * ============================================================
 * INPUT IN JAVA
 * ============================================================
 *
 * Java provides multiple ways to take input:
 *
 * 1. Scanner Class (most common)
 * --------------------------------
 *  - Part of java.util package
 *  - Must be imported: import java.util.Scanner;
 *  - Works with keyboard, files, and strings
 *
 *  Common Scanner Methods:
 *  -----------------------
 *  nextInt()      → reads an integer
 *  nextDouble()   → reads a double
 *  nextFloat()    → reads a float
 *  nextLong()     → reads a long
 *  nextBoolean()  → reads a boolean
 *  next()         → reads a single word (String, stops at space)
 *  nextLine()     → reads full line including spaces
 *  nextChar()     → NOT available; use next().charAt(0) instead
 *
 * 2. BufferedReader Class (faster, used for large input)
 * -------------------------------------------------------
 *  - Part of java.io package
 *  - Reads input as a String; needs manual parsing
 *  - Faster than Scanner for competitive programming
 *
 * 3. Console Class
 * -----------------
 *  - Used for reading passwords (hides input)
 *  - Doesn't work in all IDEs
 *
 * ============================================================
 * IMPORTANT NOTES
 * ============================================================
 *  - Always close Scanner after use: scanner.close()
 *  - nextLine() issue: After nextInt(), call nextLine() to
 *    consume leftover newline character in the buffer.
 *  - Scanner is in java.util package — must import it.
 *  - BufferedReader throws IOException — must handle it.
 * ============================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BasicInputOutput {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {

        // ============================================================
        // 1. OUTPUT — System.out.print()
        // ============================================================

        System.out.println("===== OUTPUT METHODS =====");

        System.out.print("Hello ");       // No newline
        System.out.print("World ");       // continues on same line
        System.out.print("!\n");          // manual newline with \n

        System.out.println("I am on a new line!");   // auto newline
        System.out.println("So am I!");

        // ============================================================
        // 2. OUTPUT — System.out.printf() with Format Specifiers
        // ============================================================

        System.out.println("\n===== FORMATTED OUTPUT (printf) =====");

        String name   = "Alice";
        int age       = 22;
        double marks  = 95.678;
        char grade    = 'A';
        boolean pass  = true;

        System.out.printf("Name    : %s%n",   name);
        System.out.printf("Age     : %d%n",   age);
        System.out.printf("Marks   : %.2f%n", marks);   // 2 decimal places
        System.out.printf("Grade   : %c%n",   grade);
        System.out.printf("Passed  : %b%n",   pass);

        // Padding & alignment
        System.out.printf("%n===== ALIGNMENT DEMO =====%n");
        System.out.printf("%-15s %5d %8.2f%n", "Alice",   22, 95.50);
        System.out.printf("%-15s %5d %8.2f%n", "Bob",     19, 88.75);
        System.out.printf("%-15s %5d %8.2f%n", "Charlie", 21, 76.30);
        // %-15s → left-align string in 15 chars
        // %5d   → right-align int in 5 chars
        // %8.2f → right-align float in 8 chars with 2 decimals

        // ============================================================
        // 3. INPUT — Scanner Class (Reading all data types)
        // ============================================================

        System.out.println("\n===== INPUT USING Scanner =====");

        Scanner scanner = new Scanner(System.in);

        // Reading String
        System.out.print("Enter your name       : ");
        String userName = scanner.nextLine();

        // Reading int
        System.out.print("Enter your age        : ");
        int userAge = scanner.nextInt();

        // Reading double
        System.out.print("Enter your GPA        : ");
        double userGPA = scanner.nextDouble();

        // Reading float
        System.out.print("Enter your weight(kg) : ");
        float userWeight = scanner.nextFloat();

        // Reading long
        System.out.print("Enter phone number    : ");
        long userPhone = scanner.nextLong();

        // Reading boolean
        System.out.print("Are you a student? (true/false) : ");
        boolean isStudent = scanner.nextBoolean();

        // Reading char — Scanner has no nextChar(), use next().charAt(0)
        System.out.print("Enter grade (A/B/C)   : ");
        char userGrade = scanner.next().charAt(0);

        // ⚠️ nextLine() fix — consume leftover newline after nextInt/nextDouble etc.
        scanner.nextLine();

        // Reading full sentence
        System.out.print("Enter your address    : ");
        String userAddress = scanner.nextLine();

        // ── Display All Input ──
        System.out.println("\n===== YOUR DETAILS =====");
        System.out.printf("Name       : %s%n",   userName);
        System.out.printf("Age        : %d%n",   userAge);
        System.out.printf("GPA        : %.2f%n", userGPA);
        System.out.printf("Weight     : %.1f kg%n", userWeight);
        System.out.printf("Phone      : %d%n",   userPhone);
        System.out.printf("Student    : %b%n",   isStudent);
        System.out.printf("Grade      : %c%n",   userGrade);
        System.out.printf("Address    : %s%n",   userAddress);

        scanner.close(); // Always close scanner

        // ============================================================
        // 4. INPUT — BufferedReader Class (faster input method)
        // ============================================================

        System.out.println("\n===== INPUT USING BufferedReader =====");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter your city    : ");
        String city = br.readLine();                        // reads String

        System.out.print("Enter your pincode : ");
        int pincode = Integer.parseInt(br.readLine());      // parse to int

        System.out.print("Enter temperature  : ");
        double temperature = Double.parseDouble(br.readLine()); // parse to double

        System.out.println("\n===== BufferedReader Output =====");
        System.out.println("City        : " + city);
        System.out.println("Pincode     : " + pincode);
        System.out.printf("Temperature : %.1f°C%n", temperature);

        br.close(); // Always close BufferedReader
    }
}
 
