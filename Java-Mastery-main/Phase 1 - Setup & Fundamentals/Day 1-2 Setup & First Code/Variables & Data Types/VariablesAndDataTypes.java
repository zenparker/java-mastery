/*
 * ============================================================
 *          VARIABLES & DATA TYPES IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS A VARIABLE?
 * -------------------
 * A variable is a named container (memory location) that holds
 * a value which can be used and modified during program execution.
 *
 * SYNTAX:
 *   dataType variableName = value;
 *
 * ============================================================
 * JAVA DATA TYPES
 * ============================================================
 *
 * Java is a STATICALLY TYPED language — every variable must
 * have a declared type before use.
 *
 * Data types are divided into two categories:
 *
 * 1. PRIMITIVE DATA TYPES (8 types)
 * ----------------------------------
 *  Type       Size      Range / Description
 *  -------    -------   ------------------------------------
 *  byte       1 byte    -128 to 127
 *  short      2 bytes   -32,768 to 32,767
 *  int        4 bytes   -2,147,483,648 to 2,147,483,647
 *  long       8 bytes   Very large integers (suffix: L)
 *  float      4 bytes   Decimal numbers (suffix: f)
 *  double     8 bytes   More precise decimals (default)
 *  char       2 bytes   Single character (Unicode)
 *  boolean    1 bit     true or false only
 *
 * 2. NON-PRIMITIVE (REFERENCE) DATA TYPES
 * -----------------------------------------
 *  - String   : Sequence of characters
 *  - Arrays   : Collection of same-type elements
 *  - Classes  : User-defined types
 *  - Interfaces, etc.
 *
 * ============================================================
 * TYPES OF VARIABLES (by scope)
 * ============================================================
 *
 *  1. Local Variable    — Declared inside a method/block
 *  2. Instance Variable — Declared inside a class (non-static)
 *  3. Static Variable   — Declared with 'static' keyword (class-level)
 *
 * ============================================================
 * KEY RULES
 * ============================================================
 *  - Variable names are case-sensitive (age ≠ Age)
 *  - Cannot start with a digit
 *  - Cannot use Java reserved keywords as names
 *  - Must be declared before use
 *  - Use camelCase naming convention (myVariable)
 * ============================================================
 */

public class VariablesAndDataTypes {

    // ── Instance Variables (belong to the object) ──
    int instanceAge = 25;
    String instanceName = "Alice";

    // ── Static Variable (belongs to the class) ──
    static String collegeName = "MIT";

    public static void main(String[] args) {

        // ============================================================
        // 1. PRIMITIVE DATA TYPES
        // ============================================================

        byte myByte = 100;
        short myShort = 32000;
        int myInt = 2147483647;
        long myLong = 9876543210L;          // 'L' suffix required
        float myFloat = 3.14f;              // 'f' suffix required
        double myDouble = 3.141592653589;   // default decimal type
        char myChar = 'J';                  // single quotes for char
        boolean myBoolean = true;

        System.out.println("===== PRIMITIVE DATA TYPES =====");
        System.out.println("byte    : " + myByte);
        System.out.println("short   : " + myShort);
        System.out.println("int     : " + myInt);
        System.out.println("long    : " + myLong);
        System.out.println("float   : " + myFloat);
        System.out.println("double  : " + myDouble);
        System.out.println("char    : " + myChar);
        System.out.println("boolean : " + myBoolean);

        // ============================================================
        // 2. NON-PRIMITIVE (REFERENCE) DATA TYPES
        // ============================================================

        String greeting = "Hello, Java!";
        int[] numbers = {10, 20, 30, 40, 50};   // Array

        System.out.println("\n===== NON-PRIMITIVE DATA TYPES =====");
        System.out.println("String : " + greeting);
        System.out.print("Array  : ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ============================================================
        // 3. TYPES OF VARIABLES (Scope Demo)
        // ============================================================

        // Local Variable — declared inside this method
        int localVariable = 500;

        System.out.println("\n===== VARIABLE TYPES =====");
        System.out.println("Local Variable   : " + localVariable);
        System.out.println("Static Variable  : " + collegeName);   // class-level

        // Accessing instance variable via object
        VariablesAndDataTypes obj = new VariablesAndDataTypes();
        System.out.println("Instance Age     : " + obj.instanceAge);
        System.out.println("Instance Name    : " + obj.instanceName);

        // ============================================================
        // 4. TYPE CASTING
        // ============================================================

        // Widening (automatic) — smaller → larger type
        int smallNum = 99;
        double widenedNum = smallNum;

        // Narrowing (manual) — larger → smaller type
        double bigDecimal = 9.99;
        int narrowedNum = (int) bigDecimal;   // decimal part lost

        System.out.println("\n===== TYPE CASTING =====");
        System.out.println("Widening  (int → double) : " + widenedNum);
        System.out.println("Narrowing (double → int) : " + narrowedNum);

        // ============================================================
        // 5. var KEYWORD (Java 10+) — Local Type Inference
        // ============================================================

        var city = "New York";    // inferred as String
        var population = 8336817; // inferred as int

        System.out.println("\n===== var KEYWORD (Type Inference) =====");
        System.out.println("City       : " + city);
        System.out.println("Population : " + population);
    }
}
 
 
/**
  
Output:

===== PRIMITIVE DATA TYPES =====
byte    : 100
short   : 32000
int     : 2147483647
long    : 9876543210
float   : 3.14
double  : 3.141592653589
char    : J
boolean : true

===== NON-PRIMITIVE DATA TYPES =====
String : Hello, Java!
Array  : 10 20 30 40 50 

===== VARIABLE TYPES =====
Local Variable   : 500
Static Variable  : MIT
Instance Age     : 25
Instance Name    : Alice

===== TYPE CASTING =====
Widening  (int → double) : 99.0
Narrowing (double → int) : 9

===== var KEYWORD (Type Inference) =====
City       : New York
Population : 8336817 */