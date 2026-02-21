/*
 * ============================================================
 *         TYPE CONVERSION IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS TYPE CONVERSION?
 * -------------------------
 * Type Conversion is the process of converting a value from
 * one data type to another data type.
 *
 * Example:
 *   int a = 10;
 *   double b = a;  // int converted to double → 10.0
 *
 * ============================================================
 * TYPES OF TYPE CONVERSION IN JAVA
 * ============================================================
 *
 *  1. Implicit Type Conversion  (Widening / Automatic)
 *  2. Explicit Type Conversion  (Narrowing / Manual Casting)
 *  3. Type Conversion with Expressions
 *  4. String Conversion         (String ↔ Primitive)
 *  5. Wrapper Class Conversion  (Autoboxing & Unboxing)
 *
 * ============================================================
 * 1. IMPLICIT TYPE CONVERSION (WIDENING)
 * ============================================================
 *
 *  - Done AUTOMATICALLY by Java compiler.
 *  - Converts SMALLER data type → LARGER data type.
 *  - NO data loss occurs.
 *  - Also called: Widening Conversion / Upcasting
 *
 *  Widening Order (small → large):
 *  --------------------------------
 *  byte → short → int → long → float → double
 *                 char ↗
 *
 *  Rules:
 *  - No explicit cast needed
 *  - Safe conversion — no data loss
 *  - Java handles it automatically
 *
 *  Example:
 *  int x = 100;
 *  double y = x;  // automatic, no cast needed → 100.0
 *
 * ============================================================
 * 2. EXPLICIT TYPE CONVERSION (NARROWING / CASTING)
 * ============================================================
 *
 *  - Done MANUALLY by the programmer.
 *  - Converts LARGER data type → SMALLER data type.
 *  - DATA LOSS may occur (decimal part, overflow).
 *  - Also called: Narrowing Conversion / Downcasting
 *
 *  Narrowing Order (large → small):
 *  ----------------------------------
 *  double → float → long → int → short → byte
 *                                  ↘ char
 *
 *  Syntax:
 *  -------
 *  targetType variableName = (targetType) value;
 *
 *  Example:
 *  double pi = 3.14159;
 *  int x = (int) pi;   // manual cast → 3 (decimal lost!)
 *
 *  ⚠ WARNING: Data loss scenarios:
 *  - double → int : decimal part is TRUNCATED (not rounded)
 *  - large int → byte : value may OVERFLOW (wraps around)
 *
 * ============================================================
 * 3. TYPE CONVERSION IN EXPRESSIONS
 * ============================================================
 *
 *  Java automatically promotes types in expressions:
 *
 *  Rule 1: If operands are byte/short/char → promoted to int
 *  Rule 2: If one operand is long  → result is long
 *  Rule 3: If one operand is float → result is float
 *  Rule 4: If one operand is double→ result is double
 *
 *  Example:
 *  byte a = 10, b = 20;
 *  int result = a + b;  // a and b promoted to int first
 *
 * ============================================================
 * 4. STRING CONVERSION
 * ============================================================
 *
 *  A. Primitive → String (Converting TO String):
 *  -----------------------------------------------
 *  Method 1: String.valueOf(value)      → recommended
 *  Method 2: Integer.toString(value)    → type-specific
 *  Method 3: "" + value                 → concatenation trick
 *
 *  B. String → Primitive (Parsing FROM String):
 *  ---------------------------------------------
 *  String → int    : Integer.parseInt("123")
 *  String → double : Double.parseDouble("3.14")
 *  String → float  : Float.parseFloat("3.14")
 *  String → long   : Long.parseLong("123456")
 *  String → boolean: Boolean.parseBoolean("true")
 *  String → char   : str.charAt(0)
 *
 *  ⚠ WARNING:
 *  - Parsing invalid strings throws NumberFormatException
 *  - Example: Integer.parseInt("abc") → ERROR!
 *
 * ============================================================
 * 5. WRAPPER CLASS CONVERSION (Autoboxing & Unboxing)
 * ============================================================
 *
 *  Java provides Wrapper Classes for each primitive type:
 *
 *  Primitive   Wrapper Class
 *  ---------   -------------
 *  byte      → Byte
 *  short     → Short
 *  int       → Integer
 *  long      → Long
 *  float     → Float
 *  double    → Double
 *  char      → Character
 *  boolean   → Boolean
 *
 *  AUTOBOXING (Primitive → Wrapper Object):
 *  -----------------------------------------
 *  Automatic conversion of primitive to wrapper.
 *  int x = 5;
 *  Integer obj = x;  // autoboxing — Java wraps it automatically
 *
 *  UNBOXING (Wrapper Object → Primitive):
 *  ----------------------------------------
 *  Automatic conversion of wrapper to primitive.
 *  Integer obj = 10;
 *  int x = obj;  // unboxing — Java unwraps it automatically
 *
 * ============================================================
 * SUMMARY TABLE
 * ============================================================
 *
 *  Conversion        Direction          Cast Needed   Data Loss
 *  ----------------  -----------------  -----------   ---------
 *  Widening          small → large      No (auto)     No
 *  Narrowing         large → small      Yes (manual)  Possible
 *  String.valueOf()  primitive→String   No            No
 *  parseInt() etc.   String→primitive   No            Possible
 *  Autoboxing        primitive→Wrapper  No (auto)     No
 *  Unboxing          Wrapper→primitive  No (auto)     No
 *
 * ============================================================
 */

public class TypeConversion {

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#       TYPE CONVERSION IN JAVA            #");
        System.out.println("############################################");

        // ============================================================
        // 1. IMPLICIT TYPE CONVERSION (WIDENING)
        // ============================================================
        System.out.println("\n===== 1. IMPLICIT / WIDENING CONVERSION =====");
        System.out.println("Direction: byte → short → int → long → float → double");

        byte   myByte   = 42;
        short  myShort  = myByte;    // byte  → short  (auto)
        int    myInt    = myShort;   // short → int    (auto)
        long   myLong   = myInt;     // int   → long   (auto)
        float  myFloat  = myLong;    // long  → float  (auto)
        double myDouble = myFloat;   // float → double (auto)

        System.out.println("\nbyte   value : " + myByte);
        System.out.println("short  value : " + myShort);
        System.out.println("int    value : " + myInt);
        System.out.println("long   value : " + myLong);
        System.out.println("float  value : " + myFloat);
        System.out.println("double value : " + myDouble);

        // char to int (widening)
        char letter = 'A';
        int  ascii  = letter;   // char → int (gives ASCII value)
        System.out.println("\nchar 'A' → int (ASCII) : " + ascii);   // 65

        char letter2 = 'Z';
        int ascii2   = letter2;
        System.out.println("char 'Z' → int (ASCII) : " + ascii2);   // 90

        // int to double (most common widening)
        int    salary  = 50000;
        double dSalary = salary;
        System.out.println("\nint    salary : " + salary);
        System.out.println("double salary : " + dSalary);            // 50000.0

        // ============================================================
        // 2. EXPLICIT TYPE CONVERSION (NARROWING / CASTING)
        // ============================================================
        System.out.println("\n===== 2. EXPLICIT / NARROWING CONVERSION =====");
        System.out.println("Direction: double → float → long → int → short → byte");

        double bigDecimal = 9.99;
        float  fValue     = (float)  bigDecimal;   // double → float
        long   lValue     = (long)   bigDecimal;   // double → long  (decimal lost!)
        int    iValue     = (int)    bigDecimal;   // double → int   (decimal lost!)
        short  sValue     = (short)  bigDecimal;   // double → short
        byte   bValue     = (byte)   bigDecimal;   // double → byte

        System.out.println("\nOriginal double : " + bigDecimal);
        System.out.println("→ float  : " + fValue);   // 9.99
        System.out.println("→ long   : " + lValue);   // 9  (decimal truncated)
        System.out.println("→ int    : " + iValue);   // 9  (decimal truncated)
        System.out.println("→ short  : " + sValue);   // 9
        System.out.println("→ byte   : " + bValue);   // 9

        // ⚠ Data Loss — Decimal Truncation (NOT rounding)
        System.out.println("\n--- ⚠ Decimal Truncation (NOT Rounding) ---");
        double pi = 3.99999;
        int    piInt = (int) pi;
        System.out.println("double 3.99999 → int : " + piInt);  // 3 (not 4!)

        // ⚠ Data Loss — Overflow
        System.out.println("\n--- ⚠ Overflow Example ---");
        int   largeInt  = 300;
        byte  overflowB = (byte) largeInt;   // byte range: -128 to 127
        System.out.println("int 300 → byte : " + overflowB);    // 44 (overflow!)
        System.out.println("Reason: 300 % 256 = 44");

        int largeInt2   = 130;
        byte overflowB2 = (byte) largeInt2;
        System.out.println("int 130 → byte : " + overflowB2);   // -126 (overflow!)

        // int to char (narrowing)
        int  asciiCode = 66;
        char ch        = (char) asciiCode;
        System.out.println("\nint 66 → char  : " + ch);          // B

        // double to int (real world — removing decimals)
        double price   = 199.95;
        int    rounded = (int) price;
        System.out.println("\ndouble price   : " + price);
        System.out.println("int    rounded : " + rounded);       // 199

        // ============================================================
        // 3. TYPE CONVERSION IN EXPRESSIONS
        // ============================================================
        System.out.println("\n===== 3. TYPE PROMOTION IN EXPRESSIONS =====");

        // byte + byte → promoted to int
        byte x = 10, y = 20;
        // byte result = x + y;  // ✘ ERROR! result is int
        int  result = x + y;
        System.out.println("byte(10) + byte(20) → int : " + result);

        // int + long → result is long
        int  intVal  = 1000;
        long longVal = 9999999999L;
        long lResult = intVal + longVal;
        System.out.println("int + long → long  : " + lResult);

        // int + double → result is double
        int    i = 5;
        double d = 2.5;
        double dResult = i + d;
        System.out.println("int(5) + double(2.5) → double : " + dResult);  // 7.5

        // int / int → int (no decimal!)
        int a = 7, b = 2;
        int   intDiv    = a / b;
        double exactDiv = (double) a / b;   // cast ONE operand to double
        System.out.println("\nint(7) / int(2)         → int    : " + intDiv);    // 3
        System.out.println("(double)7 / 2           → double : " + exactDiv);   // 3.5

        // char arithmetic
        char  c       = 'A';
        int   charAdd = c + 1;   // char promoted to int
        char  nextChar = (char)(c + 1);
        System.out.println("\n'A' + 1 → int  : " + charAdd);     // 66
        System.out.println("'A' + 1 → char : " + nextChar);      // B

        // ============================================================
        // 4. STRING CONVERSION
        // ============================================================
        System.out.println("\n===== 4. STRING CONVERSION =====");

        // A. Primitive → String
        System.out.println("--- A. Primitive → String ---");

        int     num     = 42;
        double  dNum    = 3.14;
        boolean flag    = true;
        char    letter3 = 'J';

        // Method 1: String.valueOf()
        String s1 = String.valueOf(num);
        String s2 = String.valueOf(dNum);
        String s3 = String.valueOf(flag);
        String s4 = String.valueOf(letter3);

        System.out.println("String.valueOf(42)      → \"" + s1 + "\"  type: " + s1.getClass().getSimpleName());
        System.out.println("String.valueOf(3.14)    → \"" + s2 + "\"");
        System.out.println("String.valueOf(true)    → \"" + s3 + "\"");
        System.out.println("String.valueOf('J')     → \"" + s4 + "\"");

        // Method 2: Integer.toString(), Double.toString()
        String s5 = Integer.toString(num);
        String s6 = Double.toString(dNum);
        System.out.println("\nInteger.toString(42)    → \"" + s5 + "\"");
        System.out.println("Double.toString(3.14)   → \"" + s6 + "\"");

        // Method 3: Concatenation with ""
        String s7 = "" + num;
        String s8 = "" + dNum;
        System.out.println("\n\"\" + 42                 → \"" + s7 + "\"");
        System.out.println("\"\" + 3.14               → \"" + s8 + "\"");

        // B. String → Primitive (Parsing)
        System.out.println("\n--- B. String → Primitive (Parsing) ---");

        String strInt     = "123";
        String strDouble  = "3.14159";
        String strFloat   = "2.71";
        String strLong    = "9876543210";
        String strBoolean = "true";
        String strChar    = "Hello";

        int     parsedInt     = Integer.parseInt(strInt);
        double  parsedDouble  = Double.parseDouble(strDouble);
        float   parsedFloat   = Float.parseFloat(strFloat);
        long    parsedLong    = Long.parseLong(strLong);
        boolean parsedBoolean = Boolean.parseBoolean(strBoolean);
        char    parsedChar    = strChar.charAt(0);   // gets first character

        System.out.println("Integer.parseInt(\"123\")         → " + parsedInt);
        System.out.println("Double.parseDouble(\"3.14159\")   → " + parsedDouble);
        System.out.println("Float.parseFloat(\"2.71\")        → " + parsedFloat);
        System.out.println("Long.parseLong(\"9876543210\")    → " + parsedLong);
        System.out.println("Boolean.parseBoolean(\"true\")    → " + parsedBoolean);
        System.out.println("\"Hello\".charAt(0)               → " + parsedChar);

        // ⚠ NumberFormatException Demo
        // System.out.println("\n--- ⚠ NumberFormatException Handling ---");
        // try {
        //     int bad = Integer.parseInt("abc123");  // invalid!
        // } catch (NumberFormatException e) {
        //     System.out.println("✘ Error: Cannot parse \"abc123\" to int!");
        //     System.out.println("  Reason: " + e.getMessage());
        // }

        try {
            int valid = Integer.parseInt("456");
            System.out.println("✔ Parsed \"456\" successfully → " + valid);
        } catch (NumberFormatException e) {
            System.out.println("✘ Parse failed!");
        }

        // ============================================================
        // 5. AUTOBOXING & UNBOXING (Wrapper Classes)
        // ============================================================
        System.out.println("\n===== 5. AUTOBOXING & UNBOXING =====");

        // AUTOBOXING — primitive → Wrapper Object (automatic)
        System.out.println("--- Autoboxing (primitive → Wrapper) ---");

        int     pInt     = 100;
        Integer wInt     = pInt;         // autoboxing
        System.out.println("int     " + pInt + " → Integer : " + wInt);

        double  pDouble  = 9.99;
        Double  wDouble  = pDouble;      // autoboxing
        System.out.println("double  " + pDouble + " → Double  : " + wDouble);

        boolean pBool    = true;
        Boolean wBool    = pBool;        // autoboxing
        System.out.println("boolean " + pBool + "  → Boolean : " + wBool);

        char    pChar    = 'Z';
        Character wChar  = pChar;        // autoboxing
        System.out.println("char    " + pChar + "   → Character: " + wChar);

        // UNBOXING — Wrapper Object → primitive (automatic)
        System.out.println("\n--- Unboxing (Wrapper → primitive) ---");

        Integer objInt    = 250;
        int     primInt   = objInt;      // unboxing
        System.out.println("Integer " + objInt + " → int    : " + primInt);

        Double  objDouble = 7.77;
        double  primDouble = objDouble;  // unboxing
        System.out.println("Double  " + objDouble + " → double : " + primDouble);

        // Wrapper class utility methods
        System.out.println("\n--- Wrapper Class Utility Methods ---");
        System.out.println("Integer.MAX_VALUE     : " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE     : " + Integer.MIN_VALUE);
        System.out.println("Double.MAX_VALUE      : " + Double.MAX_VALUE);
        System.out.println("Integer.toBinaryString(10) : " + Integer.toBinaryString(10));
        System.out.println("Integer.toHexString(255)   : " + Integer.toHexString(255));
        System.out.println("Integer.toOctalString(8)   : " + Integer.toOctalString(8));

        // ============================================================
        // 6. REAL-WORLD EXAMPLE
        // ============================================================
        System.out.println("\n===== 6. REAL-WORLD EXAMPLES =====");

        // Example 1: Calculate percentage (int division trap)
        System.out.println("--- Example 1: Percentage Calculation ---");
        int totalMarks   = 500;
        int obtainedMarks = 423;
        double percentage = (double) obtainedMarks / totalMarks * 100;
        System.out.println("Obtained : " + obtainedMarks + " / " + totalMarks);
        System.out.printf("Percentage : %.2f%%%n", percentage);

        // Example 2: Currency rounding
        System.out.println("\n--- Example 2: Currency Rounding ---");
        double amount    = 1234.567;
        int    paise     = (int)(amount * 100);   // preserve 2 decimals
        double rounded1   = paise / 100.0;
        System.out.println("Original amount : ₹" + amount);
        System.out.println("Rounded amount  : ₹" + rounded1);

        // Example 3: Taking String input and computing
        System.out.println("\n--- Example 3: String Input → Compute ---");
        String inputAge    = "22";
        String inputSalary = "55000.50";
        int    empAge      = Integer.parseInt(inputAge);
        double empSalary   = Double.parseDouble(inputSalary);
        double bonus       = empSalary * 0.10;
        System.out.println("Employee Age    : " + empAge);
        System.out.printf("Employee Salary : ₹%.2f%n", empSalary);
        System.out.printf("Bonus (10%%)     : ₹%.2f%n", bonus);
        System.out.printf("Total Package   : ₹%.2f%n", empSalary + bonus);

        System.out.println("\n############################################");
        System.out.println("#     Type Conversion in Java — Done! ✔   #");
        System.out.println("############################################");
    }
}

/* 


```

**Sample Output:**
```
############################################
#       TYPE CONVERSION IN JAVA            #
############################################

===== 1. IMPLICIT / WIDENING CONVERSION =====
Direction: byte → short → int → long → float → double

byte   value : 42
short  value : 42
int    value : 42
long   value : 42
float  value : 42.0
double value : 42.0

char 'A' → int (ASCII) : 65
char 'Z' → int (ASCII) : 90

int    salary : 50000
double salary : 50000.0

===== 2. EXPLICIT / NARROWING CONVERSION =====
Direction: double → float → long → int → short → byte

Original double : 9.99
→ float  : 9.99
→ long   : 9
→ int    : 9
→ short  : 9
→ byte   : 9

--- ⚠ Decimal Truncation (NOT Rounding) ---
double 3.99999 → int : 3

--- ⚠ Overflow Example ---
int 300 → byte : 44
Reason: 300 % 256 = 44
int 130 → byte : -126

int 66 → char  : B

double price   : 199.95
int    rounded : 199

===== 3. TYPE PROMOTION IN EXPRESSIONS =====
byte(10) + byte(20) → int : 30
int + long → long  : 10000999999
int(5) + double(2.5) → double : 7.5

int(7) / int(2)         → int    : 3
(double)7 / 2           → double : 3.5

'A' + 1 → int  : 66
'A' + 1 → char : B

===== 4. STRING CONVERSION =====
--- A. Primitive → String ---
String.valueOf(42)      → "42"  type: String
String.valueOf(3.14)    → "3.14"
String.valueOf(true)    → "true"
String.valueOf('J')     → "J"

Integer.toString(42)    → "42"
Double.toString(3.14)   → "3.14"

"" + 42                 → "42"
"" + 3.14               → "3.14"

--- B. String → Primitive (Parsing) ---
Integer.parseInt("123")         → 123
Double.parseDouble("3.14159")   → 3.14159
Float.parseFloat("2.71")        → 2.71
Long.parseLong("9876543210")    → 9876543210
Boolean.parseBoolean("true")    → true
"Hello".charAt(0)               → H

--- ⚠ NumberFormatException Handling ---
✘ Error: Cannot parse "abc123" to int!
  Reason: For input string: "abc123"
✔ Parsed "456" successfully → 456

===== 5. AUTOBOXING & UNBOXING =====
--- Autoboxing (primitive → Wrapper) ---
int     100 → Integer : 100
double  9.99 → Double  : 9.99
boolean true  → Boolean : true
char    Z   → Character: Z

--- Unboxing (Wrapper → primitive) ---
Integer 250 → int    : 250
Double  7.77 → double : 7.77

--- Wrapper Class Utility Methods ---
Integer.MAX_VALUE     : 2147483647
Integer.MIN_VALUE     : -2147483648
Double.MAX_VALUE      : 1.7976931348623157E308
Integer.toBinaryString(10) : 1010
Integer.toHexString(255)   : ff
Integer.toOctalString(8)   : 10

===== 6. REAL-WORLD EXAMPLES =====
--- Example 1: Percentage Calculation ---
Obtained : 423 / 500
Percentage : 84.60%

--- Example 2: Currency Rounding ---
Original amount : ₹1234.567
Rounded amount  : ₹1234.57

--- Example 3: String Input → Compute ---
Employee Age    : 22
Employee Salary : ₹55000.50
Bonus (10%)     : ₹5500.05
Total Package   : ₹60500.55

############################################
#     Type Conversion in Java — Done! ✔   #
############################################   */