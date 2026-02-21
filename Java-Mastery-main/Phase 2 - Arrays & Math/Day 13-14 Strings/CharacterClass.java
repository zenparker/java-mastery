/*
 * ============================================================
 *         CHARACTER CLASS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS THE Character CLASS?
 * -----------------------------
 * The Character class is a WRAPPER CLASS for the primitive
 * data type 'char' in Java. It is found in the java.lang
 * package (auto-imported, no import needed).
 *
 * It wraps a single char value in an object and provides
 * a rich set of STATIC UTILITY METHODS to work with
 * individual characters.
 *
 * Key Characteristics:
 *  - Part of java.lang (no import required)
 *  - Wrapper class for primitive 'char'
 *  - All utility methods are STATIC
 *  - Immutable (value cannot be changed after creation)
 *  - Supports Unicode characters
 *  - char range: 0 to 65535 (Unicode UTF-16)
 *
 * ============================================================
 * char vs Character
 * ============================================================
 *
 *  char        → primitive data type (2 bytes)
 *  Character   → Wrapper class (Object)
 *
 *  char    ch  = 'A';         // primitive
 *  Character c = 'A';         // autoboxing (primitive → object)
 *  char    prim = c;          // unboxing (object → primitive)
 *
 * ============================================================
 * ASCII & UNICODE VALUES
 * ============================================================
 *
 *  Characters are internally stored as numbers (Unicode).
 *
 *  Important ranges:
 *  -----------------
 *  '0' to '9'  →  48 to  57  (digits)
 *  'A' to 'Z'  →  65 to  90  (uppercase)
 *  'a' to 'z'  →  97 to 122  (lowercase)
 *  ' '         →  32         (space)
 *  '\n'        →  10         (newline)
 *  '\t'        →   9         (tab)
 *
 *  Relationship:
 *  'A' = 65  |  'a' = 97  |  Difference = 32
 *  'a' = 'A' + 32   (uppercase → lowercase)
 *  'A' = 'a' - 32   (lowercase → uppercase)
 *
 * ============================================================
 * CATEGORIES OF Character METHODS
 * ============================================================
 *
 *  1. CHECKING METHODS (returns boolean)
 *  ----------------------------------------
 *  isLetter(ch)        → true if letter (a-z, A-Z)
 *  isDigit(ch)         → true if digit (0-9)
 *  isLetterOrDigit(ch) → true if letter OR digit
 *  isWhitespace(ch)    → true if whitespace (space, tab, \n)
 *  isSpaceChar(ch)     → true if Unicode space
 *  isUpperCase(ch)     → true if uppercase letter
 *  isLowerCase(ch)     → true if lowercase letter
 *  isAlphabetic(ch)    → true if alphabetic character
 *  isTitleCase(ch)     → true if title case (e.g. ǅ)
 *  isDefined(ch)       → true if defined in Unicode
 *
 *  2. CONVERSION METHODS
 *  ----------------------
 *  toUpperCase(ch)     → convert to uppercase
 *  toLowerCase(ch)     → convert to lowercase
 *  toTitleCase(ch)     → convert to title case
 *  getNumericValue(ch) → numeric value of char (A=10, Z=35)
 *  digit(ch, radix)    → digit value in given radix
 *  forDigit(d, radix)  → char for given digit value
 *
 *  3. TYPE / INFO METHODS
 *  -----------------------
 *  getType(ch)         → Unicode category type (int)
 *  hashCode(ch)        → hash code of char
 *  charCount(cp)       → chars needed for code point
 *  compare(x, y)       → compare two chars
 *  compareTo(c)        → compare Character objects
 *  toString(ch)        → convert char to String
 *  valueOf(ch)         → return Character object
 *
 * ============================================================
 * CHARACTER CONSTANTS
 * ============================================================
 *
 *  Character.MIN_VALUE      → '\u0000' (0)
 *  Character.MAX_VALUE      → '\uffff' (65535)
 *  Character.MIN_RADIX      → 2   (binary)
 *  Character.MAX_RADIX      → 36  (alphanumeric)
 *  Character.SIZE           → 16  (bits)
 *  Character.BYTES          → 2   (bytes)
 *
 * ============================================================
 * AUTOBOXING & UNBOXING
 * ============================================================
 *
 *  Autoboxing  : char → Character (automatic)
 *  char c = 'A';
 *  Character ch = c;    // auto-wrapped
 *
 *  Unboxing    : Character → char (automatic)
 *  Character ch = 'B';
 *  char c = ch;         // auto-unwrapped
 *
 * ============================================================
 * COMMON USE CASES
 * ============================================================
 *
 *  - Input validation (is it a digit? a letter?)
 *  - Password strength checking
 *  - Counting vowels, consonants, digits in a string
 *  - Case conversion
 *  - Palindrome checking
 *  - Anagram detection
 *  - Caesar cipher (encoding/decoding)
 *  - Tokenizing text
 *
 * ============================================================
 */

public class CharacterClass {

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#        CHARACTER CLASS IN JAVA           #");
        System.out.println("############################################");

        // ============================================================
        // 1. CHARACTER BASICS — char vs Character
        // ============================================================
        System.out.println("\n===== 1. char vs Character BASICS =====");

        // Primitive char
        char primChar = 'A';
        System.out.println("Primitive char     : " + primChar);
        System.out.println("char as int (ASCII): " + (int) primChar);   // 65

        // Character wrapper object
        Character wrapChar = 'A';         // autoboxing
        System.out.println("Character object   : " + wrapChar);
        System.out.println("hashCode           : " + wrapChar.hashCode());

        // Unboxing
        char unboxed = wrapChar;
        System.out.println("Unboxed char       : " + unboxed);

        // char arithmetic
        System.out.println("\n--- char Arithmetic ---");
        char letter = 'A';
        System.out.println("'A' + 1  = " + (char)(letter + 1));  // B
        System.out.println("'A' + 25 = " + (char)(letter + 25)); // Z
        System.out.println("'a' - 32 = " + (char)('a' - 32));    // A (to uppercase)
        System.out.println("'A' + 32 = " + (char)('A' + 32));    // a (to lowercase)

        // Character constants
        System.out.println("\n--- Character Constants ---");
        System.out.println("Character.MIN_VALUE : " + (int) Character.MIN_VALUE); // 0
        System.out.println("Character.MAX_VALUE : " + (int) Character.MAX_VALUE); // 65535
        System.out.println("Character.SIZE      : " + Character.SIZE);            // 16 bits
        System.out.println("Character.BYTES     : " + Character.BYTES);           // 2 bytes
        System.out.println("Character.MIN_RADIX : " + Character.MIN_RADIX);       // 2
        System.out.println("Character.MAX_RADIX : " + Character.MAX_RADIX);       // 36

        // ============================================================
        // 2. ASCII / UNICODE VALUES
        // ============================================================
        System.out.println("\n===== 2. ASCII / UNICODE VALUES =====");

        // Print ASCII table for important ranges
        System.out.println("--- Digits (0-9) ---");
        System.out.printf("%-8s %-10s%n", "Char", "ASCII");
        System.out.println("  " + "-".repeat(18));
        for (char ch = '0'; ch <= '9'; ch++) {
            System.out.printf("  %-8c %-10d%n", ch, (int) ch);
        }

        System.out.println("\n--- Uppercase A-Z ---");
        System.out.print("  Char : ");
        for (char ch = 'A'; ch <= 'Z'; ch++) System.out.print(ch + " ");
        System.out.println();
        System.out.print("  ASCII: ");
        for (char ch = 'A'; ch <= 'Z'; ch++) System.out.printf("%-3d", (int) ch);
        System.out.println();

        System.out.println("\n--- Lowercase a-z ---");
        System.out.print("  Char : ");
        for (char ch = 'a'; ch <= 'z'; ch++) System.out.print(ch + " ");
        System.out.println();
        System.out.print("  ASCII: ");
        for (char ch = 'a'; ch <= 'z'; ch++) System.out.printf("%-3d", (int) ch);
        System.out.println();

        // Special characters
        System.out.println("\n--- Special Characters ---");
        char[] specials  = {' ', '\t', '\n', '!', '@', '#', '$', '%', '&', '*'};
        String[] names   = {"Space","Tab","Newline","!","@","#","$","%","&","*"};
        for (int i = 0; i < names.length; i++) {
            System.out.printf("  %-10s → ASCII: %d%n", names[i], (int) specials[i]);
        }

        // ============================================================
        // 3. CHECKING METHODS — isXxx()
        // ============================================================
        System.out.println("\n===== 3. CHECKING METHODS =====");

        char[] testChars = {'A', 'z', '5', ' ', '!', '\t', '@', '3', 'M', '\n'};

        System.out.printf("%-5s %-8s %-8s %-10s %-12s %-10s %-10s %-12s%n",
                "Char","Letter","Digit","LetOrDig","Whitespace","Upper","Lower","Alphabetic");
        System.out.println("  " + "-".repeat(79));

        for (char ch : testChars) {
            String display = (ch == ' ') ? "SPC" :
                             (ch == '\t')? "TAB" :
                             (ch == '\n')? "NL"  : String.valueOf(ch);
            System.out.printf("%-5s %-8b %-8b %-10b %-12b %-10b %-10b %-12b%n",
                display,
                Character.isLetter(ch),
                Character.isDigit(ch),
                Character.isLetterOrDigit(ch),
                Character.isWhitespace(ch),
                Character.isUpperCase(ch),
                Character.isLowerCase(ch),
                Character.isAlphabetic(ch));
        }

        // Individual demonstrations
        System.out.println("\n--- Individual Method Demos ---");

        System.out.println("isLetter('A')         = " + Character.isLetter('A'));       // true
        System.out.println("isLetter('5')         = " + Character.isLetter('5'));       // false
        System.out.println("isDigit('7')          = " + Character.isDigit('7'));        // true
        System.out.println("isDigit('A')          = " + Character.isDigit('A'));        // false
        System.out.println("isLetterOrDigit('3')  = " + Character.isLetterOrDigit('3'));// true
        System.out.println("isLetterOrDigit('@')  = " + Character.isLetterOrDigit('@'));// false
        System.out.println("isWhitespace(' ')     = " + Character.isWhitespace(' '));   // true
        System.out.println("isWhitespace('A')     = " + Character.isWhitespace('A'));   // false
        System.out.println("isUpperCase('A')      = " + Character.isUpperCase('A'));    // true
        System.out.println("isUpperCase('a')      = " + Character.isUpperCase('a'));    // false
        System.out.println("isLowerCase('a')      = " + Character.isLowerCase('a'));    // true
        System.out.println("isLowerCase('A')      = " + Character.isLowerCase('A'));    // false
        System.out.println("isAlphabetic('A')     = " + Character.isAlphabetic('A'));   // true
        System.out.println("isAlphabetic('5')     = " + Character.isAlphabetic('5'));   // false
        System.out.println("isDefined('A')        = " + Character.isDefined('A'));      // true
        System.out.println("isSpaceChar(' ')      = " + Character.isSpaceChar(' '));    // true

        // ============================================================
        // 4. CONVERSION METHODS
        // ============================================================
        System.out.println("\n===== 4. CONVERSION METHODS =====");

        // toUpperCase() & toLowerCase()
        System.out.println("--- toUpperCase() & toLowerCase() ---");
        char[] mixed = {'a','B','c','D','e','F','g','H','i','J'};
        System.out.print("  Original  : ");
        for (char ch : mixed) System.out.print(ch + " ");
        System.out.println();

        System.out.print("  Upper     : ");
        for (char ch : mixed) System.out.print(Character.toUpperCase(ch) + " ");
        System.out.println();

        System.out.print("  Lower     : ");
        for (char ch : mixed) System.out.print(Character.toLowerCase(ch) + " ");
        System.out.println();

        System.out.println("\nCharacter.toUpperCase('a') = " + Character.toUpperCase('a')); // A
        System.out.println("Character.toUpperCase('A') = " + Character.toUpperCase('A')); // A
        System.out.println("Character.toLowerCase('Z') = " + Character.toLowerCase('Z')); // z
        System.out.println("Character.toLowerCase('z') = " + Character.toLowerCase('z')); // z
        System.out.println("Character.toUpperCase('5') = " + Character.toUpperCase('5')); // 5 (unchanged)

        // getNumericValue()
        System.out.println("\n--- getNumericValue() ---");
        System.out.println("getNumericValue('0') = " + Character.getNumericValue('0')); // 0
        System.out.println("getNumericValue('9') = " + Character.getNumericValue('9')); // 9
        System.out.println("getNumericValue('A') = " + Character.getNumericValue('A')); // 10
        System.out.println("getNumericValue('B') = " + Character.getNumericValue('B')); // 11
        System.out.println("getNumericValue('Z') = " + Character.getNumericValue('Z')); // 35
        System.out.println("getNumericValue('a') = " + Character.getNumericValue('a')); // 10

        // digit() — value in specific radix
        System.out.println("\n--- Character.digit(ch, radix) ---");
        System.out.println("digit('9', 10)   = " + Character.digit('9', 10));   // 9 (decimal)
        System.out.println("digit('F', 16)   = " + Character.digit('F', 16));   // 15 (hex F)
        System.out.println("digit('A', 16)   = " + Character.digit('A', 16));   // 10 (hex A)
        System.out.println("digit('1', 2)    = " + Character.digit('1', 2));    // 1  (binary)
        System.out.println("digit('Z', 36)   = " + Character.digit('Z', 36));   // 35 (base-36)

        // forDigit() — char for digit value in radix
        System.out.println("\n--- Character.forDigit(digit, radix) ---");
        System.out.println("forDigit(10, 16) = " + Character.forDigit(10, 16)); // a (hex)
        System.out.println("forDigit(15, 16) = " + Character.forDigit(15, 16)); // f (hex)
        System.out.println("forDigit(35, 36) = " + Character.forDigit(35, 36)); // z (base36)
        System.out.println("forDigit(9, 10)  = " + Character.forDigit(9, 10));  // 9 (decimal)

        // toString()
        System.out.println("\n--- Character.toString() ---");
        System.out.println("toString('J')    = \"" + Character.toString('J') + "\"");
        System.out.println("toString('A')    = \"" + Character.toString('A') + "\"");

        // valueOf()
        // System.out.println("\n--- Character.valueOf() ---");
        // Character cObj = Character.valueOf('X');
        // System.out.println("valueOf('X')     = " + cObj);
        // System.out.println("type             = " + cObj.getClass().getSimpleName());

        // compare() & compareTo()
        System.out.println("\n--- compare() & compareTo() ---");
        System.out.println("compare('A','A') = " + Character.compare('A','A'));  // 0
        System.out.println("compare('A','B') = " + Character.compare('A','B'));  // -1
        System.out.println("compare('B','A') = " + Character.compare('B','A'));  // 1
        System.out.println("compare('a','A') = " + Character.compare('a','A'));  // 32

        Character c1 = 'M', c2 = 'Z';
        System.out.println("'M'.compareTo('Z') = " + c1.compareTo(c2));  // negative

        // ============================================================
        // 5. PRACTICAL STRING OPERATIONS USING Character
        // ============================================================
        System.out.println("\n===== 5. PRACTICAL STRING OPERATIONS =====");

        // Count vowels, consonants, digits, spaces, special chars
        System.out.println("--- Character Analysis of a String ---");
        String sentence = "Hello World 2024! Java is #1 @ Programming.";
        System.out.println("Input   : \"" + sentence + "\"");

        int vowels = 0, consonants = 0, digs = 0,
            spaces = 0, upper = 0, lower = 0, special = 0;

        for (char ch : sentence.toCharArray()) {
            if (Character.isLetter(ch)) {
                char lc = Character.toLowerCase(ch);
                if ("aeiou".indexOf(lc) != -1) vowels++;
                else                            consonants++;
                if (Character.isUpperCase(ch))  upper++;
                else                            lower++;
            } else if (Character.isDigit(ch))   digs++;
            else if (Character.isWhitespace(ch)) spaces++;
            else                                special++;
        }

        System.out.println("Total chars  : " + sentence.length());
        System.out.println("Letters      : " + (vowels + consonants));
        System.out.println("  Vowels     : " + vowels);
        System.out.println("  Consonants : " + consonants);
        System.out.println("  Uppercase  : " + upper);
        System.out.println("  Lowercase  : " + lower);
        System.out.println("Digits       : " + digs);
        System.out.println("Spaces       : " + spaces);
        System.out.println("Special      : " + special);

        // Toggle case
        System.out.println("\n--- Toggle Case ---");
        String toggleStr = "Hello Java World";
        StringBuilder toggled = new StringBuilder();
        for (char ch : toggleStr.toCharArray()) {
            if (Character.isUpperCase(ch))
                toggled.append(Character.toLowerCase(ch));
            else if (Character.isLowerCase(ch))
                toggled.append(Character.toUpperCase(ch));
            else
                toggled.append(ch);
        }
        System.out.println("Original : " + toggleStr);
        System.out.println("Toggled  : " + toggled);

        // Reverse a string
        System.out.println("\n--- Reverse a String ---");
        String revStr    = "JavaProgramming";
        StringBuilder sb = new StringBuilder();
        for (int i = revStr.length() - 1; i >= 0; i--) {
            sb.append(revStr.charAt(i));
        }
        System.out.println("Original : " + revStr);
        System.out.println("Reversed : " + sb);

        // Check palindrome
        System.out.println("\n--- Palindrome Check ---");
        String[] palTests = {"racecar", "hello", "madam", "level", "Java"};
        for (String word : palTests) {
            String clean = word.toLowerCase();
            boolean isPalin = true;
            int lo = 0, hi = clean.length() - 1;
            while (lo < hi) {
                if (clean.charAt(lo) != clean.charAt(hi)) {
                    isPalin = false; break;
                }
                lo++; hi--;
            }
            System.out.printf("  %-10s → %s%n", word,
                    isPalin ? "✔ Palindrome" : "✘ Not Palindrome");
        }

        // Count frequency of each character
        System.out.println("\n--- Character Frequency ---");
        String freqStr = "programming";
        int[]  freq    = new int[26];
        System.out.println("Input: \"" + freqStr + "\"");
        for (char ch : freqStr.toCharArray()) {
            if (Character.isLetter(ch)) freq[Character.toLowerCase(ch) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                char c = (char)('a' + i);
                System.out.printf("  '%c' appears %d time(s) %s%n",
                        c, freq[i], "★".repeat(freq[i]));
            }
        }

        // ============================================================
        // 6. CAESAR CIPHER
        // ============================================================
        System.out.println("\n===== 6. CAESAR CIPHER =====");

        String plainText = "Hello Java World";
        int    shift     = 3;
        StringBuilder encrypted = new StringBuilder();
        StringBuilder decrypted = new StringBuilder();

        // Encrypt
        for (char ch : plainText.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                encrypted.append((char)((ch - base + shift) % 26 + base));
            } else {
                encrypted.append(ch);
            }
        }

        // Decrypt
        for (char ch : encrypted.toString().toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                decrypted.append((char)((ch - base - shift + 26) % 26 + base));
            } else {
                decrypted.append(ch);
            }
        }

        System.out.println("Plain Text  : " + plainText);
        System.out.println("Shift       : " + shift);
        System.out.println("Encrypted   : " + encrypted);
        System.out.println("Decrypted   : " + decrypted);

        // ============================================================
        // 7. PASSWORD STRENGTH CHECKER
        // ============================================================
        System.out.println("\n===== 7. PASSWORD STRENGTH CHECKER =====");

        String[] passwords = {"abc", "Hello123", "P@ssw0rd!", "java"};

        for (String pass : passwords) {
            boolean hasUpper   = false, hasLower = false;
            boolean hasDigit   = false, hasSpec  = false;
            int     len        = pass.length();

            for (char ch : pass.toCharArray()) {
                if (Character.isUpperCase(ch))          hasUpper = true;
                else if (Character.isLowerCase(ch))     hasLower = true;
                else if (Character.isDigit(ch))         hasDigit = true;
                else if (!Character.isLetterOrDigit(ch))hasSpec  = true;
            }

            int strength = 0;
            if (len >= 8)   strength++;
            if (hasUpper)   strength++;
            if (hasLower)   strength++;
            if (hasDigit)   strength++;
            if (hasSpec)    strength++;

            String level = strength <= 1 ? "🔴 Weak"   :
                           strength <= 3 ? "🟡 Medium" : "🟢 Strong";

            System.out.printf("  %-14s → %-16s (Score: %d/5)%n",
                    "\"" + pass + "\"", level, strength);
            System.out.printf("    Length≥8:%b Upper:%b Lower:%b Digit:%b Special:%b%n",
                    len >= 8, hasUpper, hasLower, hasDigit, hasSpec);
        }

        // ============================================================
        // 8. INPUT VALIDATION
        // ============================================================
        System.out.println("\n===== 8. INPUT VALIDATION =====");

        // Validate if input is numeric
        System.out.println("--- Numeric String Validation ---");
        String[] numTests = {"12345", "123.45", "123abc", "-456", "  ", "007"};
        for (String s : numTests) {
            boolean isNum = !s.trim().isEmpty();
            for (char ch : s.trim().toCharArray()) {
                if (!Character.isDigit(ch)) { isNum = false; break; }
            }
            System.out.printf("  %-10s → %s%n", "\"" + s + "\"",
                    isNum ? "✔ Numeric" : "✘ Not purely numeric");
        }

        // Validate alphabetic only
        System.out.println("\n--- Alphabetic Validation ---");
        String[] alphaTests = {"Hello", "Java123", "World", "Test!", "ABC"};
        for (String s : alphaTests) {
            boolean isAlpha = !s.isEmpty();
            for (char ch : s.toCharArray()) {
                if (!Character.isLetter(ch)) { isAlpha = false; break; }
            }
            System.out.printf("  %-10s → %s%n", "\"" + s + "\"",
                    isAlpha ? "✔ Alphabetic" : "✘ Not alphabetic");
        }

        // Username validation
        System.out.println("\n--- Username Validation (alphanumeric + _ only) ---");
        String[] usernames = {"john_doe", "Alice123", "user name", "user@123", "dev_2024"};
        for (String uname : usernames) {
            boolean valid = uname.length() >= 3 && uname.length() <= 20;
            for (char ch : uname.toCharArray()) {
                if (!Character.isLetterOrDigit(ch) && ch != '_') {
                    valid = false; break;
                }
            }
            System.out.printf("  %-12s → %s%n", "\"" + uname + "\"",
                    valid ? "✔ Valid username" : "✘ Invalid username");
        }

        // ============================================================
        // 9. REAL-WORLD EXAMPLES
        // ============================================================
        System.out.println("\n===== 9. REAL-WORLD EXAMPLES =====");

        // Example 1: Title Case Converter
        System.out.println("--- Title Case Converter ---");
        String[] titles = {
            "the quick brown fox",
            "java programming language",
            "once upon a time"
        };
        for (String title : titles) {
            StringBuilder titleCase = new StringBuilder();
            boolean nextUpper = true;
            for (char ch : title.toCharArray()) {
                if (Character.isWhitespace(ch)) {
                    titleCase.append(ch);
                    nextUpper = true;
                } else if (nextUpper) {
                    titleCase.append(Character.toUpperCase(ch));
                    nextUpper = false;
                } else {
                    titleCase.append(Character.toLowerCase(ch));
                }
            }
            System.out.printf("  %-30s → %s%n", title, titleCase);
        }

        // Example 2: Vowel Counter in sentence
        System.out.println("\n--- Vowel Counter ---");
        String[] sentences2 = {
            "The sky is blue",
            "Java is awesome",
            "Programming is fun"
        };
        for (String sent : sentences2) {
            long vowelCount = 0;
            for (char ch : sent.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(ch) != -1) vowelCount++;
            }
            System.out.printf("  %-25s → Vowels: %d%n", "\"" + sent + "\"", vowelCount);
        }

        // Example 3: Remove non-alphabetic characters
        System.out.println("\n--- Remove Non-Alphabetic Characters ---");
        String[] dirty = {"He110 W0rld!", "J@v@ Pr0gr@mm!ng", "C00l Bro!", "Test#123"};
        for (String d : dirty) {
            StringBuilder clean = new StringBuilder();
            for (char ch : d.toCharArray()) {
                if (Character.isLetter(ch) || Character.isWhitespace(ch))
                    clean.append(ch);
            }
            System.out.printf("  %-25s → \"%s\"%n", "\"" + d + "\"", clean.toString().trim());
        }

        // Example 4: Anagram Check
        System.out.println("\n--- Anagram Checker ---");
        String[][] anagramPairs = {
            {"listen", "silent"},
            {"hello",  "world"},
            {"triangle", "integral"},
            {"java",   "vaja"}
        };
        for (String[] pair : anagramPairs) {
            int[] count = new int[26];
            for (char ch : pair[0].toLowerCase().toCharArray())
                if (Character.isLetter(ch)) count[ch - 'a']++;
            for (char ch : pair[1].toLowerCase().toCharArray())
                if (Character.isLetter(ch)) count[ch - 'a']--;

            boolean isAnagram = true;
            for (int cnt : count) if (cnt != 0) { isAnagram = false; break; }

            System.out.printf("  %-12s & %-12s → %s%n",
                    "\"" + pair[0] + "\"", "\"" + pair[1] + "\"",
                    isAnagram ? "✔ Anagram" : "✘ Not Anagram");
        }

        // Example 5: Number to Word (digit chars)
        System.out.println("\n--- Digit to Word Converter ---");
        String numStr = "04159";
        String[] words = {"Zero","One","Two","Three","Four",
                          "Five","Six","Seven","Eight","Nine"};
        System.out.print("  " + numStr + " → ");
        for (char ch : numStr.toCharArray()) {
            if (Character.isDigit(ch)) {
                System.out.print(words[Character.getNumericValue(ch)] + " ");
            }
        }
        System.out.println();

        System.out.println("\n############################################");
        System.out.println("#    Character Class in Java — Done! ✔    #");
        System.out.println("############################################");
    }
}