/*
 * ============================================================
 *          INTRODUCTION TO JAVA - THEORY
 * ============================================================
 *
 * WHAT IS JAVA?
 * -------------
 * Java is a high-level, class-based, object-oriented programming
 * language designed to have as few implementation dependencies
 * as possible. It was developed by James Gosling at Sun
 * Microsystems and released in 1995. Now owned by Oracle.
 *
 * JAVA'S FAMOUS MOTTO:
 * ---------------------
 *  "Write Once, Run Anywhere" (WORA)
 *  — Java code compiled on one platform can run on any platform
 *    that has a JVM installed, without recompilation.
 *
 * ============================================================
 * KEY FEATURES OF JAVA
 * ============================================================
 *
 *  1. Simple           — Easy to learn; syntax based on C/C++
 *                        but removes complex features like
 *                        pointers and multiple inheritance.
 *
 *  2. Object-Oriented  — Everything is treated as an object.
 *                        Supports: Encapsulation, Inheritance,
 *                        Polymorphism, Abstraction.
 *
 *  3. Platform Independent — Java code compiles to Bytecode,
 *                        which runs on any OS via JVM.
 *
 *  4. Secure           — No explicit pointers; runs inside JVM
 *                        sandbox; has built-in security manager.
 *
 *  5. Robust           — Strong memory management, exception
 *                        handling, and type checking.
 *
 *  6. Multithreaded    — Supports concurrent execution of two
 *                        or more threads simultaneously.
 *
 *  7. Portable         — Bytecode can be carried and run on
 *                        any hardware with JVM.
 *
 *  8. High Performance — Uses Just-In-Time (JIT) compiler to
 *                        improve runtime performance.
 *
 *  9. Distributed      — Designed for distributed computing;
 *                        supports RMI and EJB.
 *
 * 10. Dynamic          — Supports dynamic loading of classes
 *                        at runtime.
 *
 * ============================================================
 * JAVA EDITIONS
 * ============================================================
 *
 *  1. Java SE (Standard Edition)
 *     — Core Java; used for desktop & general-purpose apps.
 *     — Includes: java.lang, java.util, java.io, etc.
 *
 *  2. Java EE (Enterprise Edition)
 *     — For large-scale, distributed, web-based applications.
 *     — Includes: Servlets, JSP, EJB, JPA, etc.
 *
 *  3. Java ME (Micro Edition)
 *     — For embedded systems and mobile devices (IoT).
 *
 *  4. JavaFX
 *     — For building rich GUI / desktop applications.
 *
 * ============================================================
 * HOW JAVA WORKS — COMPILATION PROCESS
 * ============================================================
 *
 *  Step 1: Write Source Code      →  HelloWorld.java
 *          (Human-readable Java code)
 *
 *  Step 2: Compile with javac     →  HelloWorld.class
 *          javac HelloWorld.java
 *          (Converts to platform-independent Bytecode)
 *
 *  Step 3: Run with java (JVM)    →  Output on Screen
 *          java HelloWorld
 *          (JVM interprets Bytecode → machine code)
 *
 *  Flow:
 *  Source Code (.java)
 *       ↓  [javac Compiler]
 *  Bytecode (.class)
 *       ↓  [JVM - Java Virtual Machine]
 *  Machine Code → Output
 *
 * ============================================================
 * JDK vs JRE vs JVM
 * ============================================================
 *
 *  JVM (Java Virtual Machine)
 *  — Abstract machine that executes Java Bytecode.
 *  — Platform dependent (different JVM for Windows/Mac/Linux).
 *  — Provides: Memory management, Garbage Collection, Security.
 *
 *  JRE (Java Runtime Environment)
 *  — JVM + Library Classes + Supporting Files.
 *  — Required to RUN Java programs.
 *  — JRE = JVM + Runtime Libraries
 *
 *  JDK (Java Development Kit)
 *  — Complete development package.
 *  — Required to DEVELOP & COMPILE Java programs.
 *  — JDK = JRE + Compiler (javac) + Debugger + Dev Tools
 *
 *  Relationship:
 *  JDK ⊃ JRE ⊃ JVM
 *  (JDK contains JRE, JRE contains JVM)
 *
 * ============================================================
 * STRUCTURE OF A JAVA PROGRAM
 * ============================================================
 *
 *  1. Package Declaration   (optional)  → package mypackage;
 *  2. Import Statements     (optional)  → import java.util.*;
 *  3. Class Declaration     (required)  → public class MyClass {}
 *  4. Main Method           (required)  → public static void main(String[] args)
 *  5. Statements & Logic               → code inside main()
 *
 * ============================================================
 * JAVA SYNTAX RULES
 * ============================================================
 *
 *  - Java is CASE-SENSITIVE (Hello ≠ hello)
 *  - Every statement ends with a semicolon ( ; )
 *  - Code blocks are enclosed in curly braces { }
 *  - Execution starts from the main() method
 *  - Class name MUST match the filename (MyClass → MyClass.java)
 *  - public static void main(String[] args) is the entry point
 *
 * ============================================================
 * JAVA NAMING CONVENTIONS
 * ============================================================
 *
 *  Classes      → PascalCase       → MyClass, BankAccount
 *  Methods      → camelCase        → calculateSalary(), getName()
 *  Variables    → camelCase        → studentName, totalMarks
 *  Constants    → UPPER_SNAKE_CASE → MAX_SIZE, PI_VALUE
 *  Packages     → lowercase        → com.company.project
 *
 * ============================================================
 * POPULAR APPLICATIONS OF JAVA
 * ============================================================
 *
 *  - Android App Development
 *  - Web Applications (Spring Boot, JSP, Servlets)
 *  - Enterprise Software (Banking, Insurance systems)
 *  - Big Data technologies (Hadoop, Apache Spark)
 *  - Cloud Applications
 *  - Embedded Systems & IoT
 *  - Desktop GUI Applications
 *  - Scientific & Research Applications
 *
 * ============================================================
 */

// Step 1: Package Declaration (optional)
//package introduction;

// Step 2: Import Statements
import java.util.Date;      // for current date
import java.util.Scanner;   // for user input

// Step 3: Class Declaration (filename must be IntroductionToJava.java)
public class IntroductionToJava {

    // ── Constant (UPPER_SNAKE_CASE) ──
    static final String JAVA_VERSION = "Java SE 17";
    static final double PI = 3.14159;

    // ── Instance Variable (camelCase) ──
    String programmerName;

    // ── Constructor ──
    public IntroductionToJava(String name) {
        this.programmerName = name;
    }

    // ── Method to display welcome message ──
    public void displayWelcome() {
        System.out.println("--------------------------------------------");
        System.out.println("  Welcome, " + programmerName + "!");
        System.out.println("  You are learning: " + JAVA_VERSION);
        System.out.println("--------------------------------------------");
    }

    // ── Method to show JDK / JRE / JVM info ──
    public static void showJavaComponents() {
        System.out.println("\n===== JDK vs JRE vs JVM =====");
        System.out.printf("%-5s → %-45s%n", "JVM", "Executes Bytecode (core engine)");
        System.out.printf("%-5s → %-45s%n", "JRE", "JVM + Runtime Libraries (to RUN Java)");
        System.out.printf("%-5s → %-45s%n", "JDK", "JRE + Compiler + Tools (to DEVELOP Java)");
        System.out.println("  Hierarchy: JDK ⊇ JRE ⊇ JVM");
    }

    // ── Method to show Java Features ──
    public static void showJavaFeatures() {
        System.out.println("\n===== KEY FEATURES OF JAVA =====");

        String[] features = {
                "Simple",
                "Object-Oriented",
                "Platform Independent (WORA)",
                "Secure",
                "Robust",
                "Multithreaded",
                "Portable",
                "High Performance (JIT Compiler)",
                "Distributed",
                "Dynamic"
        };

        for (int i = 0; i < features.length; i++) {
            System.out.printf("  %2d. %s%n", (i + 1), features[i]);
        }
    }

    // ── Method to show Java Editions ──
    public static void showJavaEditions() {
        System.out.println("\n===== JAVA EDITIONS =====");
        System.out.printf("%-12s → %s%n", "Java SE", "Standard Edition  (Desktop/General purpose)");
        System.out.printf("%-12s → %s%n", "Java EE", "Enterprise Edition (Web/Large-scale apps)");
        System.out.printf("%-12s → %s%n", "Java ME", "Micro Edition     (Mobile/Embedded systems)");
        System.out.printf("%-12s → %s%n", "JavaFX", "Rich GUI Desktop Applications");
    }

    // ── Method to show Compilation Process ──
    public static void showCompilationProcess() {
        System.out.println("\n===== HOW JAVA WORKS =====");
        System.out.println("  Step 1: Write Code   →  HelloWorld.java  (Source Code)");
        System.out.println("  Step 2: Compile      →  javac HelloWorld.java");
        System.out.println("                       →  HelloWorld.class (Bytecode)");
        System.out.println("  Step 3: Run          →  java HelloWorld");
        System.out.println("                       →  JVM converts Bytecode → Output");
        System.out.println();
        System.out.println("  Flow:");
        System.out.println("  [Source Code .java]");
        System.out.println("        ↓  javac (compiler)");
        System.out.println("  [Bytecode .class]");
        System.out.println("        ↓  JVM");
        System.out.println("  [Machine Code → Output]");
    }

    // ── Method to show Naming Conventions ──
    public static void showNamingConventions() {
        System.out.println("\n===== JAVA NAMING CONVENTIONS =====");
        System.out.printf("%-12s → %-20s → %s%n", "Classes", "PascalCase", "MyClass, BankAccount");
        System.out.printf("%-12s → %-20s → %s%n", "Methods", "camelCase", "getName(), calcSalary()");
        System.out.printf("%-12s → %-20s → %s%n", "Variables", "camelCase", "studentName, totalMarks");
        System.out.printf("%-12s → %-20s → %s%n", "Constants", "UPPER_SNAKE_CASE", "MAX_SIZE, PI_VALUE");
        System.out.printf("%-12s → %-20s → %s%n", "Packages", "lowercase", "com.company.project");
    }

    // ── Method to show System Information ──
    public static void showSystemInfo() {
        System.out.println("\n===== JAVA SYSTEM INFORMATION =====");
        System.out.println("Java Version  : " + System.getProperty("java.version"));
        System.out.println("Java Vendor   : " + System.getProperty("java.vendor"));
        System.out.println("OS Name       : " + System.getProperty("os.name"));
        System.out.println("OS Version    : " + System.getProperty("os.version"));
        System.out.println("OS Arch       : " + System.getProperty("os.arch"));
        System.out.println("Current Date  : " + new Date());
        System.out.println("Constant PI   : " + PI);
    }

    // ============================================================
    // MAIN METHOD — Entry Point of Java Program
    // ============================================================
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#       INTRODUCTION TO JAVA               #");
        System.out.println("############################################");

        // ── Take programmer name as input ──
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();
        scanner.close();

        // ── Create Object of class ──
        IntroductionToJava intro = new IntroductionToJava(name);

        // ── Call all methods ──
        intro.displayWelcome();
        showJavaComponents();
        showJavaFeatures();
        showJavaEditions();
        showCompilationProcess();
        showNamingConventions();
        showSystemInfo();

        System.out.println("\n############################################");
        System.out.println("#   Happy Coding with Java, " + name + "!");
        System.out.println("############################################");
    }
}

/* ```

**Sample Output:**```#############################################
INTRODUCTION TO JAVA#############################################

Enter your name:Rahul

--------------------------------------------Welcome,Rahul!
You are learning:
Java SE 17--------------------------------------------

=====
JDK vs
JRE vs JVM=====JVM→

Executes Bytecode (core engine)
JRE   → JVM +

Runtime Libraries (to RUN Java)
JDK   → JRE + Compiler +

Tools (to DEVELOP Java)
  Hierarchy: JDK ⊇ JRE ⊇ JVM

===== KEY FEATURES OF JAVA =====
   1. Simple
   2. Object-Oriented
   3.

Platform Independent (WORA)
   4. Secure
   5. Robust
   6. Multithreaded
   7. Portable
   8.

High Performance (JIT Compiler)
   9. Distributed
  10. Dynamic

===== JAVA EDITIONS =====
Java SE      →

Standard Edition  (Desktop/General purpose)
Java EE      →

Enterprise Edition (Web/Large-scale apps)
Java ME      →

Micro Edition     (Mobile/Embedded systems)
JavaFX       → Rich GUI Desktop Applications

===== HOW JAVA WORKS =====
  Step 1: Write Code   →  HelloWorld.java  (Source Code)
  Step 2: Compile      →  javac HelloWorld.java
                       →  HelloWorld.class (Bytecode)
  Step 3: Run          →  java HelloWorld
                       →  JVM converts Bytecode → Output

  Flow:
  [Source Code .java]
        ↓  javac (compiler)
  [Bytecode .class]
        ↓  JVM
  [Machine Code → Output]

===== JAVA NAMING CONVENTIONS =====
Classes      → PascalCase          → MyClass, BankAccount
Methods      → camelCase           → getName(), calcSalary()
Variables    → camelCase           → studentName, totalMarks
Constants    → UPPER_SNAKE_CASE    → MAX_SIZE, PI_VALUE
Packages     → lowercase           → com.company.project

===== JAVA SYSTEM INFORMATION =====
Java Version  : 17.0.9
Java Vendor   : Oracle Corporation
OS Name       : Windows 11
OS Version    : 10.0
OS Arch       : amd64
Current Date  : Sat Feb 21 10:30:00 IST 2026
Constant PI   : 3.14159

############################################
#   Happy Coding with Java, Rahul!
############################################  */