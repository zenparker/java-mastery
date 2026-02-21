/*
 * ============================================================
 *           CONDITIONALS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT ARE CONDITIONALS?
 * -----------------------
 * Conditionals are programming constructs that allow a program
 * to make DECISIONS and execute different blocks of code
 * based on whether a condition is TRUE or FALSE.
 *
 * Think of it like real life:
 *  "IF it is raining → take an umbrella
 *   ELSE             → wear sunglasses"
 *
 * ============================================================
 * TYPES OF CONDITIONALS IN JAVA
 * ============================================================
 *
 *  1. if Statement
 *  2. if-else Statement
 *  3. if-else-if Ladder
 *  4. Nested if-else
 *  5. switch Statement
 *  6. switch Expression  (Java 14+)
 *  7. Ternary Operator   (? :)
 *  8. Short-Circuit Evaluation (&& / ||)
 *  9. Pattern Matching with instanceof (Java 16+)
 *
 * ============================================================
 * 1. if STATEMENT
 * ============================================================
 *
 *  Executes a block ONLY when condition is TRUE.
 *  Skips the block if condition is FALSE.
 *
 *  Syntax:
 *  --------
 *  if (condition) {
 *      // runs only if condition == true
 *  }
 *
 *  Flowchart:
 *            [condition]
 *            /          \
 *         TRUE          FALSE
 *          ↓              ↓
 *      [execute]      [skip block]
 *          ↓              ↓
 *      [continue program]
 *
 * ============================================================
 * 2. if-else STATEMENT
 * ============================================================
 *
 *  Executes ONE of TWO blocks based on condition.
 *  Guarantees exactly one block always runs.
 *
 *  Syntax:
 *  --------
 *  if (condition) {
 *      // runs if condition == true
 *  } else {
 *      // runs if condition == false
 *  }
 *
 *  Flowchart:
 *            [condition]
 *            /          \
 *         TRUE          FALSE
 *          ↓              ↓
 *      [if block]     [else block]
 *          ↓              ↓
 *      [continue program]
 *
 * ============================================================
 * 3. if-else-if LADDER
 * ============================================================
 *
 *  Tests MULTIPLE conditions one by one (top to bottom).
 *  First TRUE condition's block executes, rest are skipped.
 *  Final else is optional (default/fallback).
 *
 *  Syntax:
 *  --------
 *  if (condition1) {
 *      // runs if condition1 == true
 *  } else if (condition2) {
 *      // runs if condition2 == true
 *  } else if (condition3) {
 *      // runs if condition3 == true
 *  } else {
 *      // runs if NONE of above are true
 *  }
 *
 * ============================================================
 * 4. NESTED if-else
 * ============================================================
 *
 *  An if/if-else block placed INSIDE another if/else block.
 *  Used for decisions that depend on multiple conditions.
 *
 *  Syntax:
 *  --------
 *  if (outerCondition) {
 *      if (innerCondition) {
 *          // both conditions true
 *      } else {
 *          // outer true, inner false
 *      }
 *  } else {
 *      // outer condition false
 *  }
 *
 *  ⚠ Tip: Avoid deeply nested if-else (more than 3 levels)
 *          — it becomes hard to read and maintain.
 *
 * ============================================================
 * 5. switch STATEMENT
 * ============================================================
 *
 *  Compares ONE variable/expression against MULTIPLE values.
 *  Cleaner than long if-else-if chains for exact matches.
 *
 *  Syntax:
 *  --------
 *  switch (expression) {
 *      case value1:
 *          // code
 *          break;       // stops fall-through
 *      case value2:
 *          // code
 *          break;
 *      default:
 *          // runs if no case matches
 *  }
 *
 *  Supported types: byte, short, int, char, String, enum
 *  NOT supported  : long, float, double, boolean
 *
 *  FALL-THROUGH:
 *  - Without break, execution continues to the NEXT case.
 *  - Can be used intentionally to group multiple cases.
 *
 * ============================================================
 * 6. switch EXPRESSION (Java 14+)
 * ============================================================
 *
 *  Modern version using arrow (→) syntax.
 *  - No break needed (no fall-through by default)
 *  - Can return a value directly
 *  - Supports multiple labels per case (case 1, 2, 3 →)
 *  - Can use yield keyword for multi-line cases
 *
 *  Syntax:
 *  --------
 *  String result = switch (expression) {
 *      case value1 -> "result1";
 *      case value2 -> "result2";
 *      case value3, value4 -> "result3";  // multiple labels
 *      default -> "default result";
 *  };
 *
 * ============================================================
 * 7. TERNARY OPERATOR (? :)
 * ============================================================
 *
 *  Compact one-line alternative to simple if-else.
 *  Operates on THREE operands.
 *
 *  Syntax:
 *  --------
 *  variable = (condition) ? valueIfTrue : valueIfFalse;
 *
 *  Example:
 *  int max = (a > b) ? a : b;
 *
 *  Nested Ternary:
 *  ----------------
 *  String grade = (score>=90) ? "A" : (score>=75) ? "B" : "C";
 *
 *  ⚠ Avoid over-nesting ternary — reduces readability.
 *
 * ============================================================
 * 8. SHORT-CIRCUIT EVALUATION
 * ============================================================
 *
 *  Java stops evaluating conditions as soon as result is known.
 *
 *  && (AND) Short-Circuit:
 *  - If LEFT side is FALSE → RIGHT side is NOT evaluated
 *  - Because false && anything = false
 *
 *  || (OR) Short-Circuit:
 *  - If LEFT side is TRUE → RIGHT side is NOT evaluated
 *  - Because true || anything = true
 *
 *  Why it matters:
 *  - Prevents NullPointerException
 *  - Improves performance
 *  - Example: if (obj != null && obj.getValue() > 0)
 *             → if obj is null, getValue() is never called
 *
 * ============================================================
 * 9. PATTERN MATCHING with instanceof (Java 16+)
 * ============================================================
 *
 *  Old way (before Java 16):
 *  if (obj instanceof String) {
 *      String s = (String) obj;  // manual cast needed
 *      System.out.println(s.length());
 *  }
 *
 *  New way (Java 16+):
 *  if (obj instanceof String s) {  // cast + assign in one step
 *      System.out.println(s.length());
 *  }
 *
 * ============================================================
 * if-else vs switch — WHEN TO USE WHICH?
 * ============================================================
 *
 *  Use if-else when:                 Use switch when:
 *  ✔ Range checks (age > 18)        ✔ Exact value matching
 *  ✔ Complex boolean expressions    ✔ One variable, many values
 *  ✔ Comparing different variables  ✔ Cleaner, readable code
 *  ✔ null checks                    ✔ String/char/enum matching
 *
 * ============================================================
 * BEST PRACTICES
 * ============================================================
 *
 *  1. Always use { } braces even for single-line if blocks
 *  2. Avoid deeply nested conditionals (max 3 levels)
 *  3. Always add default in switch
 *  4. Don't forget break in switch cases
 *  5. Use ternary only for simple, readable conditions
 *  6. Prefer switch expression (Java 14+) over switch statement
 *  7. Use short-circuit to guard against null checks
 *
 * ============================================================
 */

public class ConditionalsInJava {

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#         CONDITIONALS IN JAVA             #");
        System.out.println("############################################");

        // ============================================================
        // 1. if STATEMENT
        // ============================================================
        System.out.println("\n===== 1. if STATEMENT =====");

        int age = 20;
        System.out.println("Age = " + age);

        if (age >= 18) {
            System.out.println("✔ You are an adult.");
        }

        int battery = 15;
        System.out.println("\nBattery = " + battery + "%");

        if (battery < 20) {
            System.out.println("⚠ Low battery! Please charge your device.");
        }

        // Multiple statements inside if
        double temperature = 38.5;
        System.out.println("\nBody Temperature = " + temperature + "°C");

        if (temperature > 37.5) {
            System.out.println("⚠ Fever detected!");
            System.out.println("  Please rest and drink fluids.");
            System.out.println("  Consult a doctor if it persists.");
        }

        // ============================================================
        // 2. if-else STATEMENT
        // ============================================================
        System.out.println("\n===== 2. if-else STATEMENT =====");

        // Pass or Fail
        int marks = 55;
        System.out.println("Marks = " + marks);

        if (marks >= 50) {
            System.out.println("Result → ✔ PASS");
        } else {
            System.out.println("Result → ✘ FAIL");
        }

        // Even or Odd
        int number = 73;
        System.out.println("\nNumber = " + number);

        if (number % 2 == 0) {
            System.out.println(number + " → EVEN");
        } else {
            System.out.println(number + " → ODD");
        }

        // Positive, Negative or Zero
        int value = -8;
        System.out.println("\nValue = " + value);

        if (value > 0) {
            System.out.println(value + " → POSITIVE");
        } else if (value < 0) {
            System.out.println(value + " → NEGATIVE");
        } else {
            System.out.println(value + " → ZERO");
        }

        // Leap Year Check
        int year = 2024;
        System.out.println("\nYear = " + year);

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " → ✔ LEAP YEAR");
        } else {
            System.out.println(year + " → ✘ NOT a Leap Year");
        }

        // ============================================================
        // 3. if-else-if LADDER
        // ============================================================
        System.out.println("\n===== 3. if-else-if LADDER =====");

        // Grade System
        int score = 87;
        System.out.println("Score = " + score);

        if (score >= 90) {
            System.out.println("Grade → A+ (Outstanding)");
        } else if (score >= 80) {
            System.out.println("Grade → A  (Excellent)");
        } else if (score >= 70) {
            System.out.println("Grade → B  (Very Good)");
        } else if (score >= 60) {
            System.out.println("Grade → C  (Good)");
        } else if (score >= 50) {
            System.out.println("Grade → D  (Pass)");
        } else {
            System.out.println("Grade → F  (Fail)");
        }

        // Age Category
        int personAge = 15;
        System.out.println("\nPerson Age = " + personAge);

        if (personAge < 3) {
            System.out.println("Category → 👶 Infant");
        } else if (personAge < 13) {
            System.out.println("Category → 🧒 Child");
        } else if (personAge < 18) {
            System.out.println("Category → 🧑 Teenager");
        } else if (personAge < 60) {
            System.out.println("Category → 👨 Adult");
        } else {
            System.out.println("Category → 👴 Senior Citizen");
        }

        // Internet Speed Category
        double speed = 45.5;
        System.out.println("\nInternet Speed = " + speed + " Mbps");

        if (speed < 5) {
            System.out.println("Speed → 🔴 Very Slow");
        } else if (speed < 25) {
            System.out.println("Speed → 🟡 Slow");
        } else if (speed < 100) {
            System.out.println("Speed → 🟢 Good");
        } else {
            System.out.println("Speed → 🚀 Blazing Fast!");
        }

        // ============================================================
        // 4. NESTED if-else
        // ============================================================
        System.out.println("\n===== 4. NESTED if-else =====");

        // Job Eligibility
        int applicantAge    = 24;
        boolean hasResume   = true;
        boolean hasDegree   = true;
        int experience      = 2;

        System.out.println("Age=" + applicantAge + " | Resume=" + hasResume
                         + " | Degree=" + hasDegree + " | Experience=" + experience + "yrs");

        if (applicantAge >= 18) {
            if (hasResume) {
                if (hasDegree) {
                    if (experience >= 1) {
                        System.out.println("✔ ELIGIBLE for the job!");
                    } else {
                        System.out.println("✘ Need at least 1 year experience.");
                    }
                } else {
                    System.out.println("✘ Degree required for this position.");
                }
            } else {
                System.out.println("✘ Please submit a resume first.");
            }
        } else {
            System.out.println("✘ Must be 18 or older to apply.");
        }

        // Ticket Pricing (nested conditions)
        System.out.println("\n--- Movie Ticket Pricing ---");
        boolean isWeekend  = true;
        boolean isMember   = false;
        int     viewerAge  = 10;

        double ticketPrice;

        if (isWeekend) {
            if (viewerAge < 12) {
                ticketPrice = 100.0;
                System.out.println("Weekend Child Ticket  → ₹" + ticketPrice);
            } else if (viewerAge >= 60) {
                ticketPrice = 120.0;
                System.out.println("Weekend Senior Ticket → ₹" + ticketPrice);
            } else {
                ticketPrice = isMember ? 180.0 : 220.0;
                System.out.println("Weekend Adult Ticket  → ₹" + ticketPrice
                                 + (isMember ? " (Member discount)" : ""));
            }
        } else {
            if (viewerAge < 12) {
                ticketPrice = 70.0;
                System.out.println("Weekday Child Ticket  → ₹" + ticketPrice);
            } else {
                ticketPrice = isMember ? 120.0 : 150.0;
                System.out.println("Weekday Adult Ticket  → ₹" + ticketPrice
                                 + (isMember ? " (Member discount)" : ""));
            }
        }

        // ============================================================
        // 5. switch STATEMENT
        // ============================================================
        System.out.println("\n===== 5. switch STATEMENT =====");

        // Day of Week
        // int day = 5;
        // System.out.println("Day = " + day);

        // switch (day) {
        //     case 1: System.out.println("Monday    🏢 — Back to work!"); break;
        //     case 2: System.out.println("Tuesday   🏢 — Keep going!");  break;
        //     case 3: System.out.println("Wednesday 🏢 — Midweek!");     break;
        //     case 4: System.out.println("Thursday  🏢 — Almost there!"); break;
        //     case 5: System.out.println("Friday    🎉 — TGIF!");        break;
        //     case 6: System.out.println("Saturday  😎 — Weekend!");     break;
        //     case 7: System.out.println("Sunday    😴 — Rest day!");    break;
        //     default: System.out.println("✘ Invalid day number!");
        // }

        // Traffic Light
        // String light = "GREEN";
        // System.out.println("\nTraffic Light = " + light);

        // switch (light) {
        //     case "RED":
        //         System.out.println("🔴 STOP!");
        //         break;
        //     case "YELLOW":
        //         System.out.println("🟡 GET READY / SLOW DOWN");
        //         break;
        //     case "GREEN":
        //         System.out.println("🟢 GO!");
        //         break;
        //     default:
        //         System.out.println("⚠ Unknown signal!");
        // }

        // Fall-Through — Seasons
        // System.out.println("\n--- Fall-Through: Seasons ---");
        // int month = 7;
        // System.out.println("Month = " + month);

        // switch (month) {
        //     case 12: case 1: case 2:
        //         System.out.println("❄ Winter Season");
        //         break;
        //     case 3: case 4: case 5:
        //         System.out.println("🌸 Spring Season");
        //         break;
        //     case 6: case 7: case 8:
        //         System.out.println("☀ Summer Season");
        //         break;
        //     case 9: case 10: case 11:
        //         System.out.println("🍂 Autumn Season");
        //         break;
        //     default:
        //         System.out.println("✘ Invalid month!");
        // }

        // ============================================================
        // 6. switch EXPRESSION (Java 14+)
        // ============================================================
        System.out.println("\n===== 6. switch EXPRESSION (Java 14+) =====");

        // Arrow syntax — no break, no fall-through
        int dayNum = 3;
        String dayType = switch (dayNum) {
            case 1, 2, 3, 4, 5 -> "Weekday 🏢";
            case 6, 7           -> "Weekend 🎉";
            default             -> "Invalid day";
        };
        System.out.println("Day " + dayNum + " → " + dayType);

        // Planet weight calculator
        String planet = "Mars";
        double earthWeight = 70.0;
        System.out.println("\nEarth Weight = " + earthWeight + " kg | Planet = " + planet);

        double gravity = switch (planet) {
            case "Mercury" -> 0.38;
            case "Venus"   -> 0.91;
            case "Earth"   -> 1.00;
            case "Mars"    -> 0.38;
            case "Jupiter" -> 2.34;
            case "Saturn"  -> 1.06;
            case "Uranus"  -> 0.92;
            case "Neptune" -> 1.19;
            default        -> -1.0;
        };

        if (gravity == -1.0) {
            System.out.println("✘ Unknown planet!");
        } else {
            System.out.printf("Weight on %-8s → %.2f kg%n", planet, earthWeight * gravity);
        }

        // yield keyword (multi-line case in switch expression)
        int quantity = 7;
        System.out.println("\nQuantity = " + quantity);

        String discount = switch (quantity) {
            case 1, 2 -> "No discount";
            case 3, 4 -> "5% discount";
            case 5, 6 -> "10% discount";
            default   -> {
                if (quantity >= 10) {
                    yield "25% discount 🎉";
                } else {
                    yield "15% discount";
                }
            }
        };
        System.out.println("Discount → " + discount);

        // ============================================================
        // 7. TERNARY OPERATOR (? :)
        // ============================================================
        System.out.println("\n===== 7. TERNARY OPERATOR (? :) =====");

        // Basic ternary
        int a = 45, b = 78;
        int max  = (a > b) ? a : b;
        int min  = (a < b) ? a : b;
        System.out.println("a=" + a + ", b=" + b);
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);

        // Absolute value
        int num = -99;
        int abs = (num < 0) ? -num : num;
        System.out.println("\nAbsolute value of " + num + " = " + abs);

        // String ternary
        boolean isLoggedIn = true;
        String  message    = isLoggedIn ? "Welcome back! 👋" : "Please log in.";
        System.out.println("\nisLoggedIn = " + isLoggedIn);
        System.out.println(message);

        // Nested ternary — Grade
        int  testScore = 68;
        String letterGrade = (testScore >= 90) ? "A" :
                             (testScore >= 80) ? "B" :
                             (testScore >= 70) ? "C" :
                             (testScore >= 60) ? "D" : "F";
        System.out.println("\nScore=" + testScore + " → Grade: " + letterGrade);

        // Ternary in printf
        int speed2 = 120;
        System.out.printf("\nSpeed=%d → %s%n", speed2,
                (speed2 > 100) ? "⚠ Overspeeding!" : "✔ Within limit");

        // ============================================================
        // 8. SHORT-CIRCUIT EVALUATION
        // ============================================================
        System.out.println("\n===== 8. SHORT-CIRCUIT EVALUATION =====");

        // && Short-Circuit: stops if LEFT is false
        System.out.println("--- && Short-Circuit ---");
        int x = 0;

        // Without short-circuit guard → would throw ArithmeticException
        // if (x != 0 && (10 / x) > 1) — safe because x!=0 is false first
        if (x != 0 && (10 / x) > 1) {
            System.out.println("Condition true");
        } else {
            System.out.println("✔ Short-circuit prevented division by zero!");
            System.out.println("  x=0 → (x != 0) is false → right side skipped");
        }

        // || Short-Circuit: stops if LEFT is true
        // System.out.println("\n--- || Short-Circuit ---");
        // boolean isAdmin = true;

        // if (isAdmin || checkPermission()) {
        //     System.out.println("✔ Access granted! (checkPermission() was NOT called)");
        // }

        // Null check with short-circuit
        // System.out.println("\n--- Null Check with Short-Circuit ---");
        // String text = null;

        // if (text != null && text.length() > 0) {
        //     System.out.println("Text: " + text);
        // } else {
        //     System.out.println("✔ Null check prevented NullPointerException!");
        //     System.out.println("  text is null → text.length() was never called");
        // }

        // String text2 = "Hello Java";
        // if (text2 != null && text2.length() > 0) {
        //     System.out.println("✔ Text = \"" + text2 + "\", Length = " + text2.length());
        // }

        // ============================================================
        // 9. PATTERN MATCHING with instanceof (Java 16+)
        // ============================================================
        // System.out.println("\n===== 9. PATTERN MATCHING instanceof (Java 16+) =====");

        // Object[] objects = { "Hello Java", 42, 3.14, true, 'A' };

        // for (Object obj : objects) {

            // Old way (before Java 16) required manual cast
            // New way: instanceof with pattern variable
        //     if (obj instanceof String s) {
        //         System.out.println("String  → \"" + s + "\" (length=" + s.length() + ")");
        //     } else if (obj instanceof Integer i) {
        //         System.out.println("Integer → " + i + " (doubled=" + (i * 2) + ")");
        //     } else if (obj instanceof Double d) {
        //         System.out.printf("Double  → %.2f (squared=%.2f)%n", d, d * d);
        //     } else if (obj instanceof Boolean bo) {
        //         System.out.println("Boolean → " + bo + " (negated=" + !bo + ")");
        //     } else if (obj instanceof Character c) {
        //         System.out.println("Char    → '" + c + "' (ASCII=" + (int) c + ")");
        //     } else {
        //         System.out.println("Unknown type: " + obj);
        //     }
        // }

        // ============================================================
        // 10. REAL-WORLD EXAMPLE — Shopping Cart Discount
        // ============================================================
        System.out.println("\n===== 10. REAL-WORLD: Shopping Cart =====");

        double cartTotal    = 4500.0;
        boolean isPremium   = true;
        boolean hasCoupon   = false;
        String  couponCode  = "SAVE10";
        int     itemCount   = 6;

        System.out.println("Cart Total : ₹" + cartTotal);
        System.out.println("Premium    : " + isPremium);
        System.out.println("Items      : " + itemCount);

        double discountPct = 0;

        // Determine discount
        if (cartTotal >= 5000) {
            discountPct = isPremium ? 20 : 15;
            System.out.println("Discount   : " + discountPct + "% (High value cart)");
        } else if (cartTotal >= 2000) {
            discountPct = isPremium ? 15 : 10;
            System.out.println("Discount   : " + discountPct + "% (Mid value cart)");
        } else if (cartTotal >= 500) {
            discountPct = isPremium ? 10 : 5;
            System.out.println("Discount   : " + discountPct + "% (Basic cart)");
        } else {
            System.out.println("Discount   : No discount (Below ₹500)");
        }

        // Extra coupon discount
        if (hasCoupon && couponCode.equals("SAVE10")) {
            discountPct += 10;
            System.out.println("Coupon     : Extra 10% applied!");
        }

        // Free shipping check
        String shipping = (cartTotal >= 999 || isPremium) ? "FREE 🚚" : "₹99";
        System.out.println("Shipping   : " + shipping);

        double discountAmt = cartTotal * discountPct / 100;
        double finalTotal  = cartTotal - discountAmt;

        System.out.println("----------------------------");
        System.out.printf("Original   : ₹%.2f%n", cartTotal);
        System.out.printf("Discount   : -₹%.2f (%.0f%%)%n", discountAmt, discountPct);
        System.out.printf("Final Total: ₹%.2f%n", finalTotal);

        System.out.println("\n############################################");
        System.out.println("#    Conditionals in Java — Done! ✔       #");
        System.out.println("############################################");
    }

    // Helper method for short-circuit demo
    // static boolean checkPermission() {
    //     System.out.println("  [checkPermission() was called]");
    //     return false;
    // }
}
 