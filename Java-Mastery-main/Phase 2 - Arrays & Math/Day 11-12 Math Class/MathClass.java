/*
 * ============================================================
 *           MATH CLASS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS THE Math CLASS?
 * ------------------------
 * The Math class is a built-in class in Java found in the
 * java.lang package (auto-imported, no import needed).
 * It provides a collection of STATIC methods and constants
 * for performing common mathematical operations.
 *
 * Key Characteristics:
 *  - Part of java.lang package (no import required)
 *  - All methods are STATIC → call via Math.methodName()
 *  - Cannot be instantiated (constructor is private)
 *  - All methods work with double/int/long/float types
 *  - Provides two important mathematical constants
 *
 * ============================================================
 * MATH CONSTANTS
 * ============================================================
 *
 *  Constant       Value                  Description
 *  ----------     -------------------    -------------------
 *  Math.PI        3.141592653589793      π (pi)
 *  Math.E         2.718281828459045      Euler's number (e)
 *
 * ============================================================
 * CATEGORIES OF Math METHODS
 * ============================================================
 *
 *  1.  Basic Arithmetic
 *      - Math.abs()        Absolute value
 *      - Math.max()        Maximum of two values
 *      - Math.min()        Minimum of two values
 *
 *  2.  Rounding Methods
 *      - Math.ceil()       Round UP to nearest integer
 *      - Math.floor()      Round DOWN to nearest integer
 *      - Math.round()      Round to nearest integer
 *      - Math.rint()       Round to nearest even integer
 *
 *  3.  Power & Root
 *      - Math.pow()        Raise to power
 *      - Math.sqrt()       Square root
 *      - Math.cbrt()       Cube root
 *      - Math.hypot()      Hypotenuse (√(x²+y²))
 *      - Math.exp()        e raised to power (e^x)
 *
 *  4.  Logarithmic
 *      - Math.log()        Natural log (base e)
 *      - Math.log10()      Log base 10
 *      - Math.log1p()      log(1 + x)
 *
 *  5.  Trigonometric
 *      - Math.sin()        Sine (radians)
 *      - Math.cos()        Cosine (radians)
 *      - Math.tan()        Tangent (radians)
 *      - Math.asin()       Arc sine
 *      - Math.acos()       Arc cosine
 *      - Math.atan()       Arc tangent
 *      - Math.atan2()      Arc tangent of y/x
 *      - Math.toRadians()  Degrees → Radians
 *      - Math.toDegrees()  Radians → Degrees
 *
 *  6.  Random
 *      - Math.random()     Random double [0.0, 1.0)
 *
 *  7.  Sign & Comparison
 *      - Math.signum()     Sign of a number (-1, 0, 1)
 *      - Math.copySign()   Copy sign from one to another
 *
 *  8.  Exact Arithmetic (throws on overflow)
 *      - Math.addExact()   Exact addition
 *      - Math.subtractExact() Exact subtraction
 *      - Math.multiplyExact() Exact multiplication
 *      - Math.incrementExact() Exact increment
 *      - Math.decrementExact() Exact decrement
 *      - Math.negateExact()    Exact negation
 *
 *  9.  Bit & Integer Operations
 *      - Math.floorDiv()   Floor division
 *      - Math.floorMod()   Floor modulo
 *      - Math.clamp()      Clamp value between min/max (Java 21)
 *
 * ============================================================
 * ROUNDING — DIFFERENCES
 * ============================================================
 *
 *  Value     ceil()  floor()  round()  rint()
 *  -------   ------  -------  -------  ------
 *   3.2         4       3        3        3.0
 *   3.5         4       3        4        4.0   ← nearest even
 *   3.7         4       3        4        4.0
 *  -3.2        -3      -4       -3       -3.0
 *  -3.5        -3      -4       -3       -4.0  ← nearest even
 *  -3.7        -3      -4       -4       -4.0
 *
 * ============================================================
 * TRIGONOMETRY NOTE
 * ============================================================
 *
 *  All trig methods use RADIANS (not degrees).
 *  Convert degrees → radians: Math.toRadians(degrees)
 *  Convert radians → degrees: Math.toDegrees(radians)
 *
 *  Common conversions:
 *  0°   = 0 radians
 *  30°  = π/6  ≈ 0.5236
 *  45°  = π/4  ≈ 0.7854
 *  60°  = π/3  ≈ 1.0472
 *  90°  = π/2  ≈ 1.5708
 *  180° = π    ≈ 3.1416
 *  360° = 2π   ≈ 6.2832
 *
 * ============================================================
 * Math.random() RANGE FORMULA
 * ============================================================
 *
 *  Math.random() returns [0.0, 1.0) (0 inclusive, 1 exclusive)
 *
 *  Random int between min and max (inclusive):
 *  (int)(Math.random() * (max - min + 1)) + min
 *
 *  Examples:
 *  Random 0-9  : (int)(Math.random() * 10)
 *  Random 1-10 : (int)(Math.random() * 10) + 1
 *  Random 1-100: (int)(Math.random() * 100) + 1
 *  Random 5-15 : (int)(Math.random() * 11) + 5
 *
 * ============================================================
 * SPECIAL VALUES
 * ============================================================
 *
 *  Math.sqrt(-1)   → NaN  (Not a Number)
 *  Math.log(0)     → -Infinity
 *  Math.log(-1)    → NaN
 *  1.0 / 0.0       → Infinity
 *  0.0 / 0.0       → NaN
 *  Math.pow(0, 0)  → 1.0  (by convention)
 *
 * ============================================================
 */

public class MathClass {

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#          Math CLASS IN JAVA              #");
        System.out.println("############################################");

        // ============================================================
        // 1. MATH CONSTANTS
        // ============================================================
        System.out.println("\n===== 1. MATH CONSTANTS =====");

        System.out.println("Math.PI  = " + Math.PI);   // 3.141592653589793
        System.out.println("Math.E   = " + Math.E);    // 2.718281828459045

        // Using PI for circle calculations
        double radius = 7.0;
        double circumference = 2 * Math.PI * radius;
        double area          = Math.PI * radius * radius;

        System.out.printf("%nCircle (radius=%.1f):%n", radius);
        System.out.printf("  Circumference = 2πr = %.4f%n", circumference);
        System.out.printf("  Area          = πr² = %.4f%n", area);

        // Using E
        System.out.printf("%nEuler's number (e):%n");
        System.out.printf("  e^1  = %.6f%n", Math.exp(1));   // 2.718281...
        System.out.printf("  e^2  = %.6f%n", Math.exp(2));   // 7.389056...

        // ============================================================
        // 2. BASIC ARITHMETIC — abs(), max(), min()
        // ============================================================
        System.out.println("\n===== 2. BASIC ARITHMETIC =====");

        // abs() — Absolute value (removes negative sign)
        System.out.println("--- Math.abs() ---");
        System.out.println("Math.abs(-15)       = " + Math.abs(-15));      // 15
        System.out.println("Math.abs(15)        = " + Math.abs(15));       // 15
        System.out.println("Math.abs(-3.75)     = " + Math.abs(-3.75));    // 3.75
        System.out.println("Math.abs(-0)        = " + Math.abs(-0));       // 0
        System.out.println("Math.abs(Integer.MIN_VALUE) = "
                + Math.abs(Integer.MIN_VALUE));   // ⚠ still negative (overflow!)

        // max() — Maximum of two values
        System.out.println("\n--- Math.max() ---");
        System.out.println("Math.max(10, 20)    = " + Math.max(10, 20));    // 20
        System.out.println("Math.max(-5, -10)   = " + Math.max(-5, -10));   // -5
        System.out.println("Math.max(3.5, 3.14) = " + Math.max(3.5, 3.14));// 3.5
        System.out.println("Math.max(100, 100)  = " + Math.max(100, 100));  // 100

        // Chaining max for 3 values
        int a = 45, b = 78, c = 33;
        int maxOf3 = Math.max(a, Math.max(b, c));
        System.out.println("Max of " + a + ", " + b + ", " + c + " = " + maxOf3);

        // min() — Minimum of two values
        System.out.println("\n--- Math.min() ---");
        System.out.println("Math.min(10, 20)    = " + Math.min(10, 20));    // 10
        System.out.println("Math.min(-5, -10)   = " + Math.min(-5, -10));   // -10
        System.out.println("Math.min(3.5, 3.14) = " + Math.min(3.5, 3.14));// 3.14

        // Chaining min for 3 values
        int minOf3 = Math.min(a, Math.min(b, c));
        System.out.println("Min of " + a + ", " + b + ", " + c + " = " + minOf3);

        // ============================================================
        // 3. ROUNDING METHODS
        // ============================================================
        System.out.println("\n===== 3. ROUNDING METHODS =====");

        double[] testVals = {3.2, 3.5, 3.7, -3.2, -3.5, -3.7};

        System.out.printf("%-8s %8s %8s %8s %8s%n",
                "Value", "ceil()", "floor()", "round()", "rint()");
        System.out.println("  " + "-".repeat(46));
        for (double v : testVals) {
            System.out.printf("%-8.1f %8.0f %8.0f %8d %8.1f%n",
                    v,
                    Math.ceil(v),
                    Math.floor(v),
                    Math.round(v),
                    Math.rint(v));
        }

        // Practical use — ceiling division
        System.out.println("\n--- Practical: Ceiling Division ---");
        int items    = 17;
        int perBox   = 5;
        int boxes    = (int) Math.ceil((double) items / perBox);
        System.out.println(items + " items, " + perBox + " per box → "
                + boxes + " boxes needed (ceil)");

        // Round to N decimal places
        System.out.println("\n--- Round to 2 Decimal Places ---");
        double price  = 199.5678;
        double rounded = Math.round(price * 100.0) / 100.0;
        System.out.printf("Original : %.4f%n", price);
        System.out.printf("Rounded  : %.2f%n", rounded);

        // ============================================================
        // 4. POWER & ROOT
        // ============================================================
        System.out.println("\n===== 4. POWER & ROOT =====");

        // Math.pow()
        System.out.println("--- Math.pow() ---");
        System.out.printf("Math.pow(2,  10) = %.0f%n",  Math.pow(2, 10));    // 1024
        System.out.printf("Math.pow(3,   3) = %.0f%n",  Math.pow(3, 3));     // 27
        System.out.printf("Math.pow(5,   0) = %.0f%n",  Math.pow(5, 0));     // 1
        System.out.printf("Math.pow(4, 0.5) = %.2f%n",  Math.pow(4, 0.5));   // 2.0 (square root)
        System.out.printf("Math.pow(2,  -1) = %.4f%n",  Math.pow(2, -1));    // 0.5
        System.out.printf("Math.pow(0,   0) = %.0f%n",  Math.pow(0, 0));     // 1

        // Math.sqrt()
        System.out.println("\n--- Math.sqrt() ---");
        System.out.printf("Math.sqrt(4)     = %.2f%n",  Math.sqrt(4));       // 2.0
        System.out.printf("Math.sqrt(9)     = %.2f%n",  Math.sqrt(9));       // 3.0
        System.out.printf("Math.sqrt(2)     = %.6f%n",  Math.sqrt(2));       // 1.414213...
        System.out.printf("Math.sqrt(144)   = %.2f%n",  Math.sqrt(144));     // 12.0
        System.out.printf("Math.sqrt(-1)    = %s%n",    Math.sqrt(-1));      // NaN

        // Math.cbrt()
        System.out.println("\n--- Math.cbrt() ---");
        System.out.printf("Math.cbrt(8)     = %.2f%n",  Math.cbrt(8));       // 2.0
        System.out.printf("Math.cbrt(27)    = %.2f%n",  Math.cbrt(27));      // 3.0
        System.out.printf("Math.cbrt(-8)    = %.2f%n",  Math.cbrt(-8));      // -2.0
        System.out.printf("Math.cbrt(125)   = %.2f%n",  Math.cbrt(125));     // 5.0

        // Math.hypot() — Hypotenuse
        System.out.println("\n--- Math.hypot() → √(x²+y²) ---");
        System.out.printf("Math.hypot(3, 4)   = %.2f%n", Math.hypot(3, 4));  // 5.0
        System.out.printf("Math.hypot(5, 12)  = %.2f%n", Math.hypot(5, 12)); // 13.0
        System.out.printf("Math.hypot(8, 15)  = %.2f%n", Math.hypot(8, 15)); // 17.0

        // Math.exp()
        System.out.println("\n--- Math.exp() → e^x ---");
        System.out.printf("Math.exp(0)      = %.6f%n",  Math.exp(0));        // 1.0
        System.out.printf("Math.exp(1)      = %.6f%n",  Math.exp(1));        // 2.718281
        System.out.printf("Math.exp(2)      = %.6f%n",  Math.exp(2));        // 7.389056

        // ============================================================
        // 5. LOGARITHMIC METHODS
        // ============================================================
        System.out.println("\n===== 5. LOGARITHMIC METHODS =====");

        // Math.log() — Natural log (base e)
        System.out.println("--- Math.log() → ln(x) ---");
        System.out.printf("Math.log(1)      = %.6f%n",  Math.log(1));        // 0.0
        System.out.printf("Math.log(E)      = %.6f%n",  Math.log(Math.E));   // 1.0
        System.out.printf("Math.log(10)     = %.6f%n",  Math.log(10));       // 2.302585
        System.out.printf("Math.log(0)      = %s%n",    Math.log(0));        // -Infinity
        System.out.printf("Math.log(-1)     = %s%n",    Math.log(-1));       // NaN

        // Math.log10() — Log base 10
        System.out.println("\n--- Math.log10() → log₁₀(x) ---");
        System.out.printf("Math.log10(1)    = %.2f%n",  Math.log10(1));      // 0.0
        System.out.printf("Math.log10(10)   = %.2f%n",  Math.log10(10));     // 1.0
        System.out.printf("Math.log10(100)  = %.2f%n",  Math.log10(100));    // 2.0
        System.out.printf("Math.log10(1000) = %.2f%n",  Math.log10(1000));   // 3.0

        // Practical: number of digits using log10
        System.out.println("\n--- Digits in a number ---");
        int[] numArr = {5, 99, 500, 1234, 99999};
        for (int num : numArr) {
            int digits = (int) Math.log10(num) + 1;
            System.out.printf("  Digits in %-6d = %d%n", num, digits);
        }

        // Math.log1p() — log(1+x) more accurate for small x
        System.out.println("\n--- Math.log1p() → ln(1+x) ---");
        System.out.printf("Math.log1p(0)    = %.6f%n",  Math.log1p(0));      // 0.0
        System.out.printf("Math.log1p(1)    = %.6f%n",  Math.log1p(1));      // 0.693147

        // ============================================================
        // 6. TRIGONOMETRIC METHODS
        // ============================================================
        System.out.println("\n===== 6. TRIGONOMETRIC METHODS =====");

        // Degree to Radian conversion
        System.out.println("--- Degree ↔ Radian Conversion ---");
        double[] degrees = {0, 30, 45, 60, 90, 180, 270, 360};
        System.out.printf("%-8s  %-12s%n", "Degrees", "Radians");
        System.out.println("  " + "-".repeat(22));
        for (double deg : degrees) {
            System.out.printf("%-8.0f  %-12.6f%n", deg, Math.toRadians(deg));
        }

        // sin, cos, tan
        System.out.println("\n--- sin(), cos(), tan() ---");
        double[] angles = {0, 30, 45, 60, 90};
        System.out.printf("%-6s %10s %10s %12s%n", "Angle", "sin()", "cos()", "tan()");
        System.out.println("  " + "-".repeat(42));
        for (double deg : angles) {
            double rad = Math.toRadians(deg);
            double tanVal = (deg == 90) ? Double.POSITIVE_INFINITY
                                        : Math.tan(rad);
            System.out.printf("%-6.0f %10.6f %10.6f %12.6f%n",
                    deg, Math.sin(rad), Math.cos(rad), tanVal);
        }

        // asin(), acos(), atan()
        System.out.println("\n--- Inverse: asin(), acos(), atan() ---");
        System.out.printf("Math.asin(1.0)   = %.6f rad = %.2f°%n",
                Math.asin(1.0),  Math.toDegrees(Math.asin(1.0)));  // 90°
        System.out.printf("Math.acos(1.0)   = %.6f rad = %.2f°%n",
                Math.acos(1.0),  Math.toDegrees(Math.acos(1.0)));  // 0°
        System.out.printf("Math.atan(1.0)   = %.6f rad = %.2f°%n",
                Math.atan(1.0),  Math.toDegrees(Math.atan(1.0)));  // 45°

        // atan2 — angle of a vector
        System.out.println("\n--- Math.atan2(y, x) ---");
        System.out.printf("atan2(1, 1)   = %.6f rad = %.2f°%n",
                Math.atan2(1, 1),   Math.toDegrees(Math.atan2(1, 1)));   // 45°
        System.out.printf("atan2(0, -1)  = %.6f rad = %.2f°%n",
                Math.atan2(0, -1),  Math.toDegrees(Math.atan2(0, -1)));  // 180°

        // Practical: triangle angle using trig
        System.out.println("\n--- Practical: Triangle Angle ---");
        double opp = 4.0, hyp = 5.0, adj = 3.0;
        System.out.printf("Triangle: opposite=%.0f, adjacent=%.0f, hypotenuse=%.0f%n",
                opp, adj, hyp);
        System.out.printf("Angle A (asin) = %.2f°%n", Math.toDegrees(Math.asin(opp/hyp)));
        System.out.printf("Angle A (acos) = %.2f°%n", Math.toDegrees(Math.acos(adj/hyp)));
        System.out.printf("Angle A (atan) = %.2f°%n", Math.toDegrees(Math.atan(opp/adj)));

        // ============================================================
        // 7. Math.random()
        // ============================================================
        System.out.println("\n===== 7. Math.random() =====");

        System.out.println("--- Raw Math.random() [0.0 , 1.0) ---");
        for (int i = 0; i < 5; i++) {
            System.out.printf("  random() = %.6f%n", Math.random());
        }

        // Random in ranges
        System.out.println("\n--- Random Ranges ---");
        int rand1to10   = (int)(Math.random() * 10) + 1;
        int rand1to100  = (int)(Math.random() * 100) + 1;
        int rand5to15   = (int)(Math.random() * 11) + 5;
        int rand0to9    = (int)(Math.random() * 10);
        int randNeg     = (int)(Math.random() * 21) - 10;  // -10 to +10

        System.out.println("Random 1–10    : " + rand1to10);
        System.out.println("Random 1–100   : " + rand1to100);
        System.out.println("Random 5–15    : " + rand5to15);
        System.out.println("Random 0–9     : " + rand0to9);
        System.out.println("Random -10–10  : " + randNeg);

        // Coin flip
        System.out.println("\n--- Coin Flip ---");
        String coin = Math.random() < 0.5 ? "HEADS" : "TAILS";
        System.out.println("Flip result    : " + coin);

        // Dice roll
        System.out.println("\n--- Dice Roll ---");
        int dice = (int)(Math.random() * 6) + 1;
        System.out.println("Dice result    : " + dice);

        // Random double in range
        System.out.println("\n--- Random double 5.0–10.0 ---");
        double randDouble = 5.0 + Math.random() * 5.0;
        System.out.printf("Random double  : %.4f%n", randDouble);

        // ============================================================
        // 8. SIGN METHODS
        // ============================================================
        System.out.println("\n===== 8. SIGN METHODS =====");

        // Math.signum()
        System.out.println("--- Math.signum() ---");
        System.out.printf("signum(-15.5)   = %.1f%n", Math.signum(-15.5));   // -1.0
        System.out.printf("signum(0.0)     = %.1f%n", Math.signum(0.0));     //  0.0
        System.out.printf("signum(25.5)    = %.1f%n", Math.signum(25.5));    //  1.0
        System.out.printf("signum(-0.001)  = %.1f%n", Math.signum(-0.001));  // -1.0

        // Math.copySign()
        System.out.println("\n--- Math.copySign() ---");
        System.out.printf("copySign(5.0, -1.0)  = %.1f%n", Math.copySign(5.0, -1.0));  // -5.0
        System.out.printf("copySign(-5.0, 1.0)  = %.1f%n", Math.copySign(-5.0, 1.0));  //  5.0
        System.out.printf("copySign(-5.0, -2.0) = %.1f%n", Math.copySign(-5.0, -2.0)); // -5.0

        // ============================================================
        // 9. EXACT ARITHMETIC (throws ArithmeticException on overflow)
        // ============================================================
        System.out.println("\n===== 9. EXACT ARITHMETIC =====");

        System.out.println("--- Safe Exact Operations ---");
        System.out.println("addExact(100, 200)       = " + Math.addExact(100, 200));
        System.out.println("subtractExact(500, 300)  = " + Math.subtractExact(500, 300));
        System.out.println("multiplyExact(25, 4)     = " + Math.multiplyExact(25, 4));
        System.out.println("incrementExact(99)       = " + Math.incrementExact(99));
        System.out.println("decrementExact(50)       = " + Math.decrementExact(50));
        System.out.println("negateExact(-75)         = " + Math.negateExact(-75));

        // Overflow detection
        System.out.println("\n--- Overflow Detection ---");
        try {
            int result = Math.addExact(Integer.MAX_VALUE, 1);  // overflow!
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("✘ addExact(MAX_VALUE, 1) → " + e.getMessage());
        }

        try {
            int result = Math.multiplyExact(Integer.MAX_VALUE, 2); // overflow!
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("✘ multiplyExact(MAX, 2)  → " + e.getMessage());
        }

        // ============================================================
        // 10. FLOOR DIVISION & MODULO
        // ============================================================
        System.out.println("\n===== 10. FLOOR DIVISION & MODULO =====");

        System.out.println("--- Math.floorDiv() vs Regular / ---");
        System.out.printf("  7 / 2          = %d%n",           7 / 2);
        System.out.printf("  floorDiv(7,2)  = %d%n",  Math.floorDiv(7, 2));
        System.out.printf(" -7 / 2          = %d%n",          -7 / 2);        // -3 (truncates toward 0)
        System.out.printf("  floorDiv(-7,2) = %d%n",  Math.floorDiv(-7, 2));  // -4 (floors toward -∞)

        System.out.println("\n--- Math.floorMod() vs Regular % ---");
        System.out.printf("  7 %% 3          = %d%n",          7 % 3);
        System.out.printf("  floorMod(7,3)  = %d%n",  Math.floorMod(7, 3));
        System.out.printf(" -7 %% 3          = %d%n",         -7 % 3);        // -1 (can be negative)
        System.out.printf("  floorMod(-7,3) = %d%n",  Math.floorMod(-7, 3)); //  2 (always non-negative)

        // ============================================================
        // 11. SPECIAL VALUES (NaN, Infinity)
        // ============================================================
        System.out.println("\n===== 11. SPECIAL VALUES =====");

        System.out.printf("Math.sqrt(-1)   = %s%n",  Math.sqrt(-1));         // NaN
        System.out.printf("Math.log(0)     = %s%n",  Math.log(0));           // -Infinity
        System.out.printf("Math.log(-1)    = %s%n",  Math.log(-1));          // NaN
        System.out.printf("1.0 / 0.0       = %s%n",  (1.0 / 0.0));          // Infinity
        System.out.printf("-1.0 / 0.0      = %s%n",  (-1.0 / 0.0));         // -Infinity
        System.out.printf("0.0 / 0.0       = %s%n",  (0.0 / 0.0));          // NaN
        System.out.printf("Math.pow(0, 0)  = %.1f%n", Math.pow(0, 0));       // 1.0

        // NaN check
        double nanVal = Math.sqrt(-4);
        System.out.println("\nDouble.isNaN(Math.sqrt(-4))      : " + Double.isNaN(nanVal));
        System.out.println("Double.isInfinite(1.0/0.0)       : " + Double.isInfinite(1.0/0.0));

        // ============================================================
        // 12. REAL-WORLD EXAMPLES
        // ============================================================
        System.out.println("\n===== 12. REAL-WORLD EXAMPLES =====");

        // Example 1: Geometry Calculator
        System.out.println("--- Geometry Calculator ---");

        // Circle
        double r = 5.0;
        System.out.printf("Circle (r=%.1f):%n", r);
        System.out.printf("  Area          = πr²     = %.4f%n", Math.PI * Math.pow(r, 2));
        System.out.printf("  Circumference = 2πr     = %.4f%n", 2 * Math.PI * r);

        // Sphere
        System.out.printf("Sphere (r=%.1f):%n", r);
        System.out.printf("  Surface Area  = 4πr²    = %.4f%n", 4 * Math.PI * Math.pow(r, 2));
        System.out.printf("  Volume        = (4/3)πr³= %.4f%n", (4.0/3) * Math.PI * Math.pow(r, 3));

        // Pythagorean theorem
        System.out.println("\n--- Pythagorean Theorem ---");
        double side1 = 3, side2 = 4;
        double hyp2  = Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
        double hypot = Math.hypot(side1, side2);
        System.out.printf("Sides: %.0f and %.0f%n", side1, side2);
        System.out.printf("Hypotenuse (manual) = %.4f%n", hyp2);
        System.out.printf("Hypotenuse (hypot)  = %.4f%n", hypot);

        // Example 2: Compound Interest
        System.out.println("\n--- Compound Interest ---");
        double principal = 10000.0;
        double rate      = 8.5 / 100;
        int    time      = 5;
        int    n         = 12;  // compounded monthly

        double amount  = principal * Math.pow(1 + rate/n, n * time);
        double interest = amount - principal;

        System.out.printf("Principal  : ₹%.2f%n", principal);
        System.out.printf("Rate       : %.1f%%%n", rate * 100);
        System.out.printf("Time       : %d years%n", time);
        System.out.printf("Compounded : Monthly (%d times/year)%n", n);
        System.out.printf("Amount     : ₹%.2f%n", amount);
        System.out.printf("Interest   : ₹%.2f%n", interest);

        // Example 3: Distance between two points
        System.out.println("\n--- Distance Between Two Points ---");
        double x1 = 1, y1 = 1;
        double x2 = 4, y2 = 5;
        double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        double distHypot = Math.hypot(x2-x1, y2-y1);
        System.out.printf("Point1: (%.0f, %.0f)  Point2: (%.0f, %.0f)%n", x1, y1, x2, y2);
        System.out.printf("Distance (sqrt) = %.4f%n", distance);
        System.out.printf("Distance (hypot)= %.4f%n", distHypot);

        // Example 4: Statistics
        System.out.println("\n--- Statistics: Std Deviation ---");
        double[] dataset = {4, 8, 6, 5, 3, 2, 8, 9, 2, 5};
        double mean = 0;
        for (double d : dataset) mean += d;
        mean /= dataset.length;

        double variance = 0;
        for (double d : dataset) variance += Math.pow(d - mean, 2);
        variance /= dataset.length;
        double stdDev = Math.sqrt(variance);

        System.out.print("Data  : ");
        for (double d : dataset) System.out.printf("%.0f ", d);
        System.out.printf("%nMean  : %.2f%n", mean);
        System.out.printf("Variance : %.2f%n", variance);
        System.out.printf("Std Dev  : %.4f%n", stdDev);

        // Example 5: Power simulation — OTP Generator
        System.out.println("\n--- 6-Digit OTP Generator ---");
        for (int i = 1; i <= 3; i++) {
            int otp = (int)(Math.random() * 900000) + 100000;
            System.out.println("OTP " + i + " : " + otp);
        }

        // Example 6: BMI Calculator
        System.out.println("\n--- BMI Calculator ---");
        double weight = 70.5;  // kg
        double height = 1.75;  // meters
        double bmi    = weight / Math.pow(height, 2);
        String category = bmi < 18.5 ? "Underweight" :
                          bmi < 25.0 ? "Normal ✔"    :
                          bmi < 30.0 ? "Overweight"  : "Obese";
        System.out.printf("Weight : %.1f kg%n", weight);
        System.out.printf("Height : %.2f m%n",  height);
        System.out.printf("BMI    : %.2f → %s%n", bmi, category);

        System.out.println("\n############################################");
        System.out.println("#       Math Class in Java — Done! ✔      #");
        System.out.println("############################################");
    }
}