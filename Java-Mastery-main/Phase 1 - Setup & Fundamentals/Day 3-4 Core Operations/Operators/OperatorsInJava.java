/*
 * ============================================================
 *              OPERATORS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS AN OPERATOR?
 * ---------------------
 * An operator is a special symbol that performs operations
 * on one or more operands (values/variables) and produces
 * a result.
 *
 * Example: a + b  →  '+' is operator, 'a' and 'b' are operands
 *
 * ============================================================
 * TYPES OF OPERATORS IN JAVA
 * ============================================================
 *
 *  1. Arithmetic Operators
 *  2. Assignment Operators
 *  3. Relational (Comparison) Operators
 *  4. Logical Operators
 *  5. Bitwise Operators
 *  6. Unary Operators
 *  7. Ternary Operator
 *  8. Shift Operators
 *  9. instanceof Operator
 *
 * ============================================================
 * 1. ARITHMETIC OPERATORS
 * ============================================================
 *  Used to perform basic mathematical operations.
 *
 *  Operator  Name            Example    Result (a=10, b=3)
 *  --------  -----------     -------    ------------------
 *    +       Addition        a + b      13
 *    -       Subtraction     a - b      7
 *    *       Multiplication  a * b      30
 *    /       Division        a / b      3  (integer division)
 *    %       Modulus         a % b      1  (remainder)
 *
 * ============================================================
 * 2. ASSIGNMENT OPERATORS
 * ============================================================
 *  Used to assign values to variables.
 *
 *  Operator  Example    Equivalent To
 *  --------  -------    -------------
 *    =       a = 5      a = 5
 *    +=      a += 3     a = a + 3
 *    -=      a -= 3     a = a - 3
 *    *=      a *= 3     a = a * 3
 *    /=      a /= 3     a = a / 3
 *    %=      a %= 3     a = a % 3
 *
 * ============================================================
 * 3. RELATIONAL (COMPARISON) OPERATORS
 * ============================================================
 *  Compare two values and return boolean (true/false).
 *
 *  Operator  Name                    Example    Result (a=10, b=3)
 *  --------  --------------------    -------    ------------------
 *    ==      Equal to                a == b     false
 *    !=      Not equal to            a != b     true
 *    >       Greater than            a > b      true
 *    <       Less than               a < b      false
 *    >=      Greater than or equal   a >= b     true
 *    <=      Less than or equal      a <= b     false
 *
 * ============================================================
 * 4. LOGICAL OPERATORS
 * ============================================================
 *  Used to combine multiple boolean conditions.
 *
 *  Operator  Name        Example         Result
 *  --------  --------    -------         ------
 *    &&      Logical AND  a>5 && b<5     true if BOTH are true
 *    ||      Logical OR   a>5 || b>5     true if ANY ONE is true
 *    !       Logical NOT  !(a>5)         reverses the result
 *
 *  Truth Table:
 *  A      B      A && B    A || B    !A
 *  -----  -----  ------    ------    ------
 *  true   true   true      true      false
 *  true   false  false     true      false
 *  false  true   false     true      true
 *  false  false  false     false     true
 *
 * ============================================================
 * 5. BITWISE OPERATORS
 * ============================================================
 *  Operate on individual bits of integer values.
 *
 *  Operator  Name         Example     Description
 *  --------  ----------   -------     -----------
 *    &       Bitwise AND  a & b       1 if BOTH bits are 1
 *    |       Bitwise OR   a | b       1 if ANY bit is 1
 *    ^       Bitwise XOR  a ^ b       1 if bits are DIFFERENT
 *    ~       Bitwise NOT  ~a          flips all bits
 *
 * ============================================================
 * 6. UNARY OPERATORS
 * ============================================================
 *  Operate on a single operand.
 *
 *  Operator  Name              Example   Description
 *  --------  ---------------   -------   -----------
 *    +       Unary plus        +a        positive value
 *    -       Unary minus       -a        negates value
 *    ++      Increment         a++       increase by 1
 *    --      Decrement         a--       decrease by 1
 *    !       Logical NOT       !true     reverses boolean
 *
 *  Pre vs Post:
 *  Pre-increment  (++a) → increments FIRST, then uses value
 *  Post-increment (a++) → uses value FIRST, then increments
 *
 * ============================================================
 * 7. TERNARY OPERATOR
 * ============================================================
 *  Shorthand for if-else. Works on 3 operands.
 *
 *  Syntax:
 *  variable = (condition) ? value_if_true : value_if_false;
 *
 *  Example:
 *  int max = (a > b) ? a : b;
 *  → if a > b is true  → max = a
 *  → if a > b is false → max = b
 *
 * ============================================================
 * 8. SHIFT OPERATORS
 * ============================================================
 *  Shift bits of a number left or right.
 *
 *  Operator  Name                  Example   Description
 *  --------  -------------------   -------   -----------
 *    <<      Left Shift            a << 2    multiply by 2^2 = 4
 *    >>      Right Shift           a >> 2    divide by 2^2 = 4
 *    >>>     Unsigned Right Shift  a >>> 2   shift with 0 fill
 *
 * ============================================================
 * 9. instanceof OPERATOR
 * ============================================================
 *  Checks if an object is an instance of a specific class.
 *
 *  Syntax:
 *  object instanceof ClassName  → returns true or false
 *
 * ============================================================
 * OPERATOR PRECEDENCE (High to Low)
 * ============================================================
 *
 *  Level  Operators
 *  -----  -----------------------------------------
 *    1    () [] .                  (highest)
 *    2    ++ -- ! ~ (unary)
 *    3    * / %
 *    4    + -
 *    5    << >> >>>
 *    6    < > <= >= instanceof
 *    7    == !=
 *    8    &
 *    9    ^
 *   10    |
 *   11    &&
 *   12    ||
 *   13    ?:  (ternary)
 *   14    = += -= *= /= %=        (lowest)
 *
 * ============================================================
 */

public class OperatorsInJava {

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#         OPERATORS IN JAVA                #");
        System.out.println("############################################");

        int a = 10, b = 3;

        // ============================================================
        // 1. ARITHMETIC OPERATORS
        // ============================================================
        System.out.println("\n===== 1. ARITHMETIC OPERATORS (a=10, b=3) =====");

        System.out.println("a + b  = " + (a + b)); // 13
        System.out.println("a - b  = " + (a - b)); // 7
        System.out.println("a * b  = " + (a * b)); // 30
        System.out.println("a / b  = " + (a / b)); // 3 (integer division, decimal dropped)
        System.out.println("a % b  = " + (a % b)); // 1 (remainder)

        // Division with double for precise result
        double preciseDiv = (double) a / b;
        System.out.printf("(double)a / b = %.4f%n", preciseDiv); // 3.3333

        // ============================================================
        // 2. ASSIGNMENT OPERATORS
        // ============================================================
        System.out.println("\n===== 2. ASSIGNMENT OPERATORS =====");

        int x = 10;
        System.out.println("Initial x     = " + x);

        x += 5;
        System.out.println("After x += 5  → x = " + x); // 15
        x -= 3;
        System.out.println("After x -= 3  → x = " + x); // 12
        x *= 2;
        System.out.println("After x *= 2  → x = " + x); // 24
        x /= 4;
        System.out.println("After x /= 4  → x = " + x); // 6
        x %= 4;
        System.out.println("After x %= 4  → x = " + x); // 2

        // ============================================================
        // 3. RELATIONAL (COMPARISON) OPERATORS
        // ============================================================
        System.out.println("\n===== 3. RELATIONAL OPERATORS (a=10, b=3) =====");

        System.out.println("a == b  → " + (a == b)); // false
        System.out.println("a != b  → " + (a != b)); // true
        System.out.println("a >  b  → " + (a > b)); // true
        System.out.println("a <  b  → " + (a < b)); // false
        System.out.println("a >= b  → " + (a >= b)); // true
        System.out.println("a <= b  → " + (a <= b)); // false

        // ============================================================
        // 4. LOGICAL OPERATORS
        // ============================================================
        System.out.println("\n===== 4. LOGICAL OPERATORS =====");

        boolean p = true, q = false;
        System.out.println("p = " + p + ", q = " + q);
        System.out.println("p && q  → " + (p && q)); // false (both must be true)
        System.out.println("p || q  → " + (p || q)); // true  (at least one true)
        System.out.println("!p      → " + (!p)); // false (reverses true)
        System.out.println("!q      → " + (!q)); // true  (reverses false)

        // Real-world example
        int age = 20;
        boolean hasID = true;
        boolean canVote = (age >= 18) && hasID;
        boolean canEnter = (age >= 18) || hasID;
        System.out.println("\nAge=20, hasID=true");
        System.out.println("Can Vote  (age>=18 && hasID) → " + canVote); // true
        System.out.println("Can Enter (age>=18 || hasID) → " + canEnter); // true

        // ============================================================
        // 5. UNARY OPERATORS
        // ============================================================
        System.out.println("\n===== 5. UNARY OPERATORS =====");

        int num = 5;
        System.out.println("num       = " + num);
        System.out.println("+num      = " + (+num)); // 5
        System.out.println("-num      = " + (-num)); // -5

        // Post-increment: use value FIRST, then increment
        int postInc = num++;
        System.out.println("\npost-increment (num++):");
        System.out.println("postInc   = " + postInc); // 5 (old value used)
        System.out.println("num after = " + num); // 6 (incremented after)

        // Pre-increment: increment FIRST, then use value
        num = 5; // reset
        int preInc = ++num;
        System.out.println("\npre-increment (++num):");
        System.out.println("preInc    = " + preInc); // 6 (incremented first)
        System.out.println("num after = " + num); // 6

        // Post-decrement
        num = 5; // reset
        int postDec = num--;
        System.out.println("\npost-decrement (num--):");
        System.out.println("postDec   = " + postDec); // 5 (old value used)
        System.out.println("num after = " + num); // 4

        // Pre-decrement
        num = 5; // reset
        int preDec = --num;
        System.out.println("\npre-decrement (--num):");
        System.out.println("preDec    = " + preDec); // 4 (decremented first)
        System.out.println("num after = " + num); // 4

        // ============================================================
        // 6. TERNARY OPERATOR
        // ============================================================
        System.out.println("\n===== 6. TERNARY OPERATOR =====");

        int m = 15, n = 20;

        // Find maximum
        int max = (m > n) ? m : n;
        System.out.println("m=" + m + ", n=" + n);
        System.out.println("Max value     = " + max); // 20

        // Check even or odd
        String evenOdd = (m % 2 == 0) ? "Even" : "Odd";
        System.out.println(m + " is        = " + evenOdd); // Odd

        // Check pass or fail
        int score = 75;
        String result = (score >= 50) ? "PASS" : "FAIL";
        System.out.println("Score=" + score + " Result = " + result); // PASS

        // Nested ternary (grade system)
        String grade = (score >= 90) ? "A" : (score >= 75) ? "B" : (score >= 60) ? "C" : (score >= 50) ? "D" : "F";
        System.out.println("Score=" + score + " Grade  = " + grade); // B

        // ============================================================
        // 7. BITWISE OPERATORS
        // ============================================================
        System.out.println("\n===== 7. BITWISE OPERATORS =====");

        int ba = 5; // Binary: 0101
        int bb = 3; // Binary: 0011

        System.out.println("a  = " + ba + "  (binary: " + Integer.toBinaryString(ba) + ")");
        System.out.println("b  = " + bb + "  (binary: " + Integer.toBinaryString(bb) + ")");
        System.out.println();
        System.out.println("a & b  = " + (ba & bb) +
                "  (binary: " + Integer.toBinaryString(ba & bb) + ") → AND"); // 1
        System.out.println("a | b  = " + (ba | bb) +
                "  (binary: " + Integer.toBinaryString(ba | bb) + ") → OR"); // 7
        System.out.println("a ^ b  = " + (ba ^ bb) +
                "  (binary: " + Integer.toBinaryString(ba ^ bb) + ") → XOR"); // 6
        System.out.println("~a     = " + (~ba) + "           → NOT (flips all bits)"); // -6

        // ============================================================
        // 8. SHIFT OPERATORS
        // ============================================================
        System.out.println("\n===== 8. SHIFT OPERATORS =====");

        int sh = 8; // Binary: 1000
        System.out.println("sh = " + sh + " (binary: " + Integer.toBinaryString(sh) + ")");

        // Left shift: multiply by 2^n
        System.out.println("sh << 1  = " + (sh << 1) +
                "  (binary: " + Integer.toBinaryString(sh << 1) + ") → 8 * 2^1 = 16");
        System.out.println("sh << 2  = " + (sh << 2) +
                "  (binary: " + Integer.toBinaryString(sh << 2) + ") → 8 * 2^2 = 32");

        // Right shift: divide by 2^n
        System.out.println("sh >> 1  = " + (sh >> 1) +
                "   (binary: " + Integer.toBinaryString(sh >> 1) + ") → 8 / 2^1 = 4");
        System.out.println("sh >> 2  = " + (sh >> 2) +
                "   (binary: " + Integer.toBinaryString(sh >> 2) + ") → 8 / 2^2 = 2");

        // Unsigned right shift
        int neg = -8;
        System.out.println("neg      = " + neg);
        System.out.println("neg >> 1 = " + (neg >> 1) + "  (signed right shift)");
        System.out.println("neg>>>1  = " + (neg >>> 1) + "  (unsigned right shift, fills 0)");

        // ============================================================
        // 9. instanceof OPERATOR
        // ============================================================
        System.out.println("\n===== 9. instanceof OPERATOR =====");

        String str = "Hello Java";
        Object obj = "I am Object";
        Integer intObj = 42;

        System.out.println("str instanceof String  → " + (str instanceof String)); // true
        System.out.println("obj instanceof String  → " + (obj instanceof String)); // true
        System.out.println("obj instanceof Integer → " + (obj instanceof Integer)); // false
        System.out.println("intObj instanceof Integer → " + (intObj instanceof Integer)); // true

        // ============================================================
        // 10. OPERATOR PRECEDENCE DEMO
        // ============================================================
        System.out.println("\n===== 10. OPERATOR PRECEDENCE DEMO =====");

        int r1 = 10 + 5 * 2; // * first → 10 + 10 = 20
        int r2 = (10 + 5) * 2; // () first → 15 * 2 = 30
        int r3 = 10 + 4 / 2 - 1; // / first → 10 + 2 - 1 = 11
        boolean r4 = 5 > 3 && 10 < 20; // relational first → true && true = true
        //boolean r5 = 5 > 3 || 10 > 20; // relational first → true || false = true
        //int r6 = (5 > 3) ? 100 : 200; // condition true → 100

        System.out.println("10 + 5 * 2         = " + r1); // 20
        System.out.println("(10 + 5) * 2       = " + r2); // 30
        System.out.println("10 + 4 / 2 - 1     = " + r3); // 11
        System.out.println("5>3 && 10<20       = " + r4); // true
        //System.out.println("5>3 || 10>20       = " + r5); // true
        //System.out.println("(5>3) ? 100 : 200  = " + r6); // 100

        System.out.println("\n############################################");
        System.out.println("#       All Operators Covered!             #");
        System.out.println("############################################");
    }
}

/*  

```

**Sample Output:**
```
############################################
#         OPERATORS IN JAVA                #
############################################

===== 1. ARITHMETIC OPERATORS (a=10, b=3) =====
a + b  = 13
a - b  = 7
a * b  = 30
a / b  = 3
a % b  = 1
(double)a / b = 3.3333

===== 2. ASSIGNMENT OPERATORS =====
Initial x     = 10
After x += 5  → x = 15
After x -= 3  → x = 12
After x *= 2  → x = 24
After x /= 4  → x = 6
After x %= 4  → x = 2

===== 3. RELATIONAL OPERATORS (a=10, b=3) =====
a == b  → false
a != b  → true
a >  b  → true
a <  b  → false
a >= b  → true
a <= b  → false

===== 4. LOGICAL OPERATORS =====
p = true, q = false
p && q  → false
p || q  → true
!p      → false
!q      → true

Age=20, hasID=true
Can Vote  (age>=18 && hasID) → true
Can Enter (age>=18 || hasID) → true

===== 5. UNARY OPERATORS =====
num       = 5
+num      = 5
-num      = -5

post-increment (num++):
postInc   = 5
num after = 6

pre-increment (++num):
preInc    = 6
num after = 6

post-decrement (num--):
postDec   = 5
num after = 4

pre-decrement (--num):
preDec    = 4
num after = 4

===== 6. TERNARY OPERATOR =====
m=15, n=20
Max value     = 20
15 is         = Odd
Score=75 Result = PASS
Score=75 Grade  = B

===== 7. BITWISE OPERATORS =====
a  = 5  (binary: 101)
b  = 3  (binary: 011)

a & b  = 1  (binary: 1) → AND
a | b  = 7  (binary: 111) → OR
a ^ b  = 6  (binary: 110) → XOR
~a     = -6           → NOT (flips all bits)

===== 8. SHIFT OPERATORS =====
sh = 8 (binary: 1000)
sh << 1  = 16  (binary: 10000) → 8 * 2^1 = 16
sh << 2  = 32  (binary: 100000) → 8 * 2^2 = 32
sh >> 1  = 4   (binary: 100) → 8 / 2^1 = 4
sh >> 2  = 2   (binary: 10) → 8 / 2^2 = 2

===== 9. instanceof OPERATOR =====
str instanceof String     → true
obj instanceof String     → true
obj instanceof Integer    → false
intObj instanceof Integer → true

===== 10. OPERATOR PRECEDENCE DEMO =====
10 + 5 * 2         = 20
(10 + 5) * 2       = 30
10 + 4 / 2 - 1     = 11
5>3 && 10<20       = true
5>3 || 10>20       = true
(5>3) ? 100 : 200  = 100

############################################
#       All Operators Covered!             #
############################################   */