/*
 * ============================================================
 *           STRING BASICS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS A STRING?
 * ------------------
 * A String in Java is a SEQUENCE OF CHARACTERS enclosed in
 * double quotes. It is one of the most widely used classes
 * in Java, found in the java.lang package (auto-imported).
 *
 * Example:
 *   String name = "Hello Java";
 *
 * Key Characteristics:
 *  - String is a CLASS (not a primitive type)
 *  - Strings are IMMUTABLE — once created, cannot be changed
 *  - Stored in a special memory area called STRING POOL
 *  - Every String literal is an object of String class
 *  - String index starts from 0 (like arrays)
 *  - null ≠ empty string ("") ≠ blank string (" ")
 *
 * ============================================================
 * STRING IMMUTABILITY
 * ============================================================
 *
 *  Once a String object is created, its VALUE CANNOT BE
 *  CHANGED. Any operation that "modifies" a String actually
 *  creates a NEW String object.
 *
 *  Example:
 *  String s = "Hello";
 *  s = s + " World";  // "Hello" still exists in pool
 *                     // s now points to NEW object "Hello World"
 *
 *  Why immutable?
 *  - Security (passwords, file paths)
 *  - Thread safety
 *  - Hashcode caching
 *  - String pool optimization
 *
 * ============================================================
 * STRING POOL (Interning)
 * ============================================================
 *
 *  String Pool is a special memory region inside the HEAP
 *  where Java stores STRING LITERALS to save memory.
 *
 *  String s1 = "Hello";     // stored in String Pool
 *  String s2 = "Hello";     // reuses SAME object from pool
 *  String s3 = new String("Hello");  // NEW object in HEAP
 *
 *  s1 == s2  → true  (same pool reference)
 *  s1 == s3  → false (different heap object)
 *  s1.equals(s3) → true  (same content)
 *
 *  intern() method → forces string into pool
 *
 * ============================================================
 * WAYS TO CREATE A STRING
 * ============================================================
 *
 *  1. String Literal (recommended):
 *     String s = "Hello";
 *
 *  2. Using new keyword:
 *     String s = new String("Hello");
 *
 *  3. From char array:
 *     char[] arr = {'H','e','l','l','o'};
 *     String s = new String(arr);
 *
 *  4. From byte array:
 *     byte[] b = {72, 101, 108, 108, 111};
 *     String s = new String(b);
 *
 *  5. Using StringBuilder/StringBuffer:
 *     String s = new StringBuilder("Hello").toString();
 *
 * ============================================================
 * CATEGORIES OF String METHODS
 * ============================================================
 *
 *  1.  Length & Access
 *      length(), charAt(), indexOf(), lastIndexOf()
 *
 *  2.  Comparison
 *      equals(), equalsIgnoreCase(), compareTo(),
 *      compareToIgnoreCase(), startsWith(), endsWith(),
 *      contains(), matches(), regionMatches()
 *
 *  3.  Searching
 *      indexOf(), lastIndexOf(), contains()
 *
 *  4.  Extraction / Substrings
 *      substring(), split(), toCharArray(), chars()
 *
 *  5.  Modification (returns new String)
 *      concat(), replace(), replaceAll(), replaceFirst(),
 *      toLowerCase(), toUpperCase(), trim(), strip(),
 *      stripLeading(), stripTrailing(), repeat()
 *
 *  6.  Checking
 *      isEmpty(), isBlank(), startsWith(), endsWith()
 *
 *  7.  Conversion
 *      valueOf(), toString(), toCharArray(), getBytes(),
 *      format(), join(), intern()
 *
 *  8.  StringBuilder & StringBuffer
 *      (Mutable alternatives to String)
 *
 * ============================================================
 * String vs StringBuilder vs StringBuffer
 * ============================================================
 *
 *  Feature        String       StringBuilder   StringBuffer
 *  ----------     ---------    -------------   -----------
 *  Mutable        No           Yes             Yes
 *  Thread-safe    Yes          No              Yes
 *  Performance    Slow (+)     Fast            Medium
 *  Use when       Fixed text   Single thread   Multi thread
 *
 *  + String concatenation in loops is slow because a new
 *    object is created every iteration.
 *    Use StringBuilder for concatenation in loops!
 *
 * ============================================================
 * IMPORTANT NOTES
 * ============================================================
 *
 *  1. Use .equals() NOT == to compare String content
 *  2. String index: 0 to length()-1
 *  3. substring(a,b) → from index a to b-1 (b exclusive)
 *  4. split() returns String array
 *  5. Strings are immutable — always return new String
 *  6. null.length() → NullPointerException
 *  7. "".equals(null) → false (safe, no exception)
 *  8. String.format() is like printf but returns String
 *
 * ============================================================
 */

import java.util.Arrays;

public class StringBasics {

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#          STRING BASICS IN JAVA           #");
        System.out.println("############################################");

        // ============================================================
        // 1. CREATING STRINGS
        // ============================================================
        System.out.println("\n===== 1. CREATING STRINGS =====");

        // Method 1: String literal (most common)
        String s1 = "Hello Java";
        System.out.println("Literal        : " + s1);

        // Method 2: using new keyword
        @SuppressWarnings("RedundantStringConstructorCall")
        String s2 = new String("Hello Java");
        System.out.println("new String()   : " + s2);

        // Method 3: from char array
        char[] charArr = {'J', 'a', 'v', 'a'};
        String s3 = new String(charArr);
        System.out.println("From char[]    : " + s3);

        // Method 4: from byte array
        byte[] byteArr = {72, 101, 108, 108, 111};
        String s4 = new String(byteArr);
        System.out.println("From byte[]    : " + s4);   // Hello

        // Method 5: using StringBuilder
        String s5 = new StringBuilder("Built").append("String").toString();
        System.out.println("StringBuilder  : " + s5);

        // Empty and blank strings
        String empty = "";
        String blank = "   ";
        String nul   = null;
        System.out.println("\nEmpty  string  : \"" + empty + "\"");
        System.out.println("Blank  string  : \"" + blank + "\"");
        System.out.println("Null   string  : "   + nul);

        // ============================================================
        // 2. STRING POOL & == vs equals()
        // ============================================================
        System.out.println("\n===== 2. STRING POOL & == vs equals() =====");

        // String p1 = "Hello";
        // String p2 = "Hello";                // same pool object
        // String p3 = new String("Hello");    // new heap object
        // String p4 = new String("Hello");    // another heap object

        System.out.println("p1 = \"Hello\" (literal)");
        System.out.println("p2 = \"Hello\" (literal)");
        System.out.println("p3 = new String(\"Hello\")");
        System.out.println("p4 = new String(\"Hello\")");

        // System.out.println("\n--- == (Reference Comparison) ---");
        // System.out.println("p1 == p2         : " + (p1 == p2));  // true  (same pool ref)
        // System.out.println("p1 == p3         : " + (p1 == p3));  // false (diff heap obj)
        // System.out.println("p3 == p4         : " + (p3 == p4));  // false (diff heap obj)

        // System.out.println("\n--- .equals() (Content Comparison) ---");
        // System.out.println("p1.equals(p2)    : " + p1.equals(p2));  // true
        // System.out.println("p1.equals(p3)    : " + p1.equals(p3));  // true
        // System.out.println("p3.equals(p4)    : " + p3.equals(p4));  // true

        // intern()
        // String p5 = p3.intern();  // moves to pool
        // System.out.println("\n--- intern() ---");
        // System.out.println("p3.intern() == p1: " + (p5 == p1));  // true (now in pool)

        // ============================================================
        // 3. STRING LENGTH & CHARACTER ACCESS
        // ============================================================
        System.out.println("\n===== 3. LENGTH & CHARACTER ACCESS =====");

        String str = "Hello World";
        System.out.println("String         : \"" + str + "\"");
        System.out.println("length()       : " + str.length());        // 11

        // charAt()
        System.out.println("\n--- charAt(index) ---");
        System.out.println("charAt(0)      : " + str.charAt(0));       // H
        System.out.println("charAt(6)      : " + str.charAt(6));       // W
        System.out.println("charAt(last)   : " + str.charAt(str.length()-1)); // d

        // Iterate characters
        System.out.println("\n--- Iterate with charAt ---");
        System.out.print("  Chars  : ");
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();

        System.out.print("  Index  : ");
        for (int i = 0; i < str.length(); i++) {
            System.out.printf("%-2d", i);
        }
        System.out.println();

        // toCharArray()
        System.out.println("\n--- toCharArray() ---");
        char[] chars = "Java".toCharArray();
        System.out.println("char[] : " + Arrays.toString(chars));

        // ============================================================
        // 4. STRING COMPARISON
        // ============================================================
        System.out.println("\n===== 4. STRING COMPARISON =====");

        String a = "Apple";
        String b = "apple";
        String c = "Banana";
        String d = "Apple";

        System.out.println("a = \"Apple\"  b = \"apple\"  c = \"Banana\"  d = \"Apple\"");

        // equals() & equalsIgnoreCase()
        System.out.println("\n--- equals() ---");
        System.out.println("a.equals(d)              : " + a.equals(d));          // true
        System.out.println("a.equals(b)              : " + a.equals(b));          // false
        System.out.println("a.equalsIgnoreCase(b)    : " + a.equalsIgnoreCase(b));// true

        // compareTo()
        System.out.println("\n--- compareTo() ---");
        System.out.println("a.compareTo(d)           : " + a.compareTo(d));       // 0
        System.out.println("a.compareTo(b)           : " + a.compareTo(b));       // -32
        System.out.println("a.compareTo(c)           : " + a.compareTo(c));       // -1
        System.out.println("c.compareTo(a)           : " + c.compareTo(a));       // 1
        System.out.println("a.compareToIgnoreCase(b) : " + a.compareToIgnoreCase(b)); // 0

        // startsWith() & endsWith()
        System.out.println("\n--- startsWith() & endsWith() ---");
        String url = "https://www.google.com";
        System.out.println("URL: " + url);
        System.out.println("startsWith(\"https\")      : " + url.startsWith("https")); // true
        System.out.println("startsWith(\"http\")       : " + url.startsWith("http"));  // true
        System.out.println("endsWith(\".com\")         : " + url.endsWith(".com"));     // true
        System.out.println("endsWith(\".org\")         : " + url.endsWith(".org"));     // false

        // contains()
        System.out.println("\n--- contains() ---");
        String sentence = "Java is a powerful language";
        System.out.println("Text: \"" + sentence + "\"");
        System.out.println("contains(\"Java\")         : " + sentence.contains("Java"));     // true
        System.out.println("contains(\"python\")       : " + sentence.contains("python"));   // false
        System.out.println("contains(\"powerful\")     : " + sentence.contains("powerful")); // true

        // ============================================================
        // 5. SEARCHING — indexOf() & lastIndexOf()
        // ============================================================
        System.out.println("\n===== 5. SEARCHING =====");

        String search = "Hello Java Hello World";
        System.out.println("String: \"" + search + "\"");

        // indexOf()
        System.out.println("\n--- indexOf() ---");
        System.out.println("indexOf('l')             : " + search.indexOf('l'));          // 2
        System.out.println("indexOf('l', 5)          : " + search.indexOf('l', 5));       // 18
        System.out.println("indexOf(\"Hello\")          : " + search.indexOf("Hello"));   // 0
        System.out.println("indexOf(\"Hello\", 1)       : " + search.indexOf("Hello",1)); // 12
        System.out.println("indexOf(\"Python\")         : " + search.indexOf("Python"));  // -1

        // lastIndexOf()
        System.out.println("\n--- lastIndexOf() ---");
        System.out.println("lastIndexOf('l')         : " + search.lastIndexOf('l'));       // 19
        System.out.println("lastIndexOf(\"Hello\")     : " + search.lastIndexOf("Hello")); // 12
        System.out.println("lastIndexOf('o')         : " + search.lastIndexOf('o'));       // 20

        // ============================================================
        // 6. EXTRACTION — substring() & split()
        // ============================================================
        System.out.println("\n===== 6. EXTRACTION =====");

        String ext = "Hello Java World";
        System.out.println("String: \"" + ext + "\"");

        // substring()
        System.out.println("\n--- substring() ---");
        System.out.println("substring(6)             : \"" + ext.substring(6) + "\"");       // Java World
        System.out.println("substring(6, 10)         : \"" + ext.substring(6, 10) + "\"");   // Java
        System.out.println("substring(0, 5)          : \"" + ext.substring(0, 5) + "\"");    // Hello
        System.out.println("substring(11)            : \"" + ext.substring(11) + "\"");      // World

        // First and last word
        String fw = ext.substring(0, ext.indexOf(' '));
        String lw = ext.substring(ext.lastIndexOf(' ') + 1);
        System.out.println("First word               : \"" + fw + "\"");
        System.out.println("Last  word               : \"" + lw + "\"");

        // split()
        System.out.println("\n--- split() ---");
        String csv   = "Alice,Bob,Charlie,Diana,Eve";
        String[] parts = csv.split(",");
        System.out.println("CSV: \"" + csv + "\"");
        System.out.println("split(\",\") → " + Arrays.toString(parts));
        System.out.println("parts[0] = " + parts[0]);
        System.out.println("Length   = " + parts.length);

        // split with limit
        String[]  limited = csv.split(",", 3);
        System.out.println("split(\",\", 3) → " + Arrays.toString(limited));

        // split by space
        String sentence2 = "The quick brown fox";
        String[] words2  = sentence2.split("\\s+");  // one or more spaces
        System.out.println("\nWords in \"" + sentence2 + "\":");
        for (int i = 0; i < words2.length; i++) {
            System.out.printf("  words[%d] = \"%s\"%n", i, words2[i]);
        }

        // split by multiple delimiters
        String data  = "one:two,three;four";
        String[] multi = data.split("[,:;]");
        System.out.println("\nsplit(\"[,:;]\") of \"" + data + "\":");
        System.out.println("→ " + Arrays.toString(multi));

        // ============================================================
        // 7. MODIFICATION METHODS
        // ============================================================
        System.out.println("\n===== 7. MODIFICATION METHODS =====");

        String mod = "  Hello Java World  ";
        System.out.println("Original  : \"" + mod + "\"");

        // toLowerCase() & toUpperCase()
        System.out.println("\n--- Case Conversion ---");
        System.out.println("toUpperCase() : \"" + mod.trim().toUpperCase() + "\"");
        System.out.println("toLowerCase() : \"" + mod.trim().toLowerCase() + "\"");

        // trim() & strip()
        System.out.println("\n--- Whitespace Removal ---");
        System.out.println("trim()         : \"" + mod.trim() + "\"");
        System.out.println("strip()        : \"" + mod.strip() + "\"");
        System.out.println("stripLeading() : \"" + mod.stripLeading() + "\"");
        System.out.println("stripTrailing(): \"" + mod.stripTrailing() + "\"");

        // replace()
        System.out.println("\n--- replace() ---");
        String rep = "Hello Java Java Java";
        System.out.println("Original       : \"" + rep + "\"");
        System.out.println("replace(a→o)   : \"" + rep.replace('a','o') + "\"");
        System.out.println("replace(Java→Python): \""
                + rep.replace("Java","Python") + "\"");
        System.out.println("replaceFirst() : \""
                + rep.replaceFirst("Java","Python") + "\"");
        System.out.println("replaceAll (regex): \""
                + "abc123def456".replaceAll("[0-9]", "#") + "\"");

        // concat()
        System.out.println("\n--- concat() & + operator ---");
        String firstName = "John";
        String lastName  = "Doe";
        System.out.println("concat()       : \"" + firstName.concat(" ").concat(lastName) + "\"");
        System.out.println("+ operator     : \"" + firstName + " " + lastName + "\"");

        // repeat() — Java 11+
        System.out.println("\n--- repeat() (Java 11+) ---");
        System.out.println("\"Ha\".repeat(5) : " + "Ha".repeat(5));
        System.out.println("\"=-\".repeat(10): " + "=-".repeat(10));
        System.out.println("\"* \".repeat(7) : " + "* ".repeat(7));

        // ============================================================
        // 8. CHECKING METHODS
        // ============================================================
        System.out.println("\n===== 8. CHECKING METHODS =====");

        String e1 = "";
        String e2 = "   ";
        String e3 = "Hello";

        System.out.println("--- isEmpty() ---");
        System.out.println("\"\".isEmpty()     : " + e1.isEmpty());   // true
        System.out.println("\"   \".isEmpty()  : " + e2.isEmpty());   // false
        System.out.println("\"Hello\".isEmpty(): " + e3.isEmpty());   // false

        System.out.println("\n--- isBlank() (Java 11+) ---");
        System.out.println("\"\".isBlank()     : " + e1.isBlank());   // true
        System.out.println("\"   \".isBlank()  : " + e2.isBlank());   // true
        System.out.println("\"Hello\".isBlank(): " + e3.isBlank());   // false

        // matches() with regex
        System.out.println("\n--- matches() ---");
        System.out.println("\"12345\".matches(\"[0-9]+\")    : "
                + "12345".matches("[0-9]+"));        // true
        System.out.println("\"Hello\".matches(\"[a-zA-Z]+\"): "
                + "Hello".matches("[a-zA-Z]+"));     // true
        System.out.println("\"He110\".matches(\"[a-zA-Z]+\"): "
                + "He110".matches("[a-zA-Z]+"));     // false

        // ============================================================
        // 9. CONVERSION METHODS
        // ============================================================
        System.out.println("\n===== 9. CONVERSION METHODS =====");

        // String.valueOf()
        System.out.println("--- String.valueOf() ---");
        System.out.println("valueOf(42)     : " + String.valueOf(42));
        System.out.println("valueOf(3.14)   : " + String.valueOf(3.14));
        System.out.println("valueOf(true)   : " + String.valueOf(true));
        System.out.println("valueOf('A')    : " + String.valueOf('A'));
        System.out.println("valueOf(null)   : " + String.valueOf((Object)null));

        // String.format()
        System.out.println("\n--- String.format() ---");
        String formatted = String.format("Name: %-10s Age: %3d GPA: %.2f",
                "Alice", 21, 3.85);
        System.out.println(formatted);

        String receipt = String.format("%-15s %6.2f", "Total:", 1249.99);
        System.out.println(receipt);

        // String.join()
        System.out.println("\n--- String.join() ---");
        String joined1 = String.join(", ", "Alice", "Bob", "Charlie");
        String joined2 = String.join(" | ", "Java", "Python", "C++", "Kotlin");
        String[] arr2  = {"One", "Two", "Three"};
        String joined3 = String.join("-", arr2);
        System.out.println("join(\", \")  : " + joined1);
        System.out.println("join(\" | \") : " + joined2);
        System.out.println("join(\"-\")   : " + joined3);

        // getBytes()
        System.out.println("\n--- getBytes() ---");
        byte[] bytes = "ABC".getBytes();
        System.out.println("\"ABC\".getBytes() : " + Arrays.toString(bytes));  // [65, 66, 67]

        // intern()
        // System.out.println("\n--- intern() ---");
        // String interned = new String("Hello").intern();
        // System.out.println("interned == \"Hello\" : " + (interned == "Hello")); // true

        // ============================================================
        // 10. StringBuilder (Mutable String)
        // ============================================================
        System.out.println("\n===== 10. StringBuilder =====");

        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Initial        : " + sb);

        // append()
        sb.append(" Java");
        sb.append(" World");
        System.out.println("append()       : " + sb);

        // insert()
        sb.insert(5, " Beautiful");
        System.out.println("insert(5)      : " + sb);

        // replace()
        sb.replace(6, 15, "Awesome");
        System.out.println("replace(6,15)  : " + sb);

        // delete()
        sb.delete(5, 13);
        System.out.println("delete(5,13)   : " + sb);

        // deleteCharAt()
        sb.deleteCharAt(0);
        System.out.println("deleteCharAt(0): " + sb);

        // reverse()
        StringBuilder sb2 = new StringBuilder("Java");
        System.out.println("reverse()      : " + sb2.reverse());

        // length() & capacity()
        StringBuilder sb3 = new StringBuilder("Hello");
        System.out.println("\nsb3 length()   : " + sb3.length());      // 5
        System.out.println("sb3 capacity() : " + sb3.capacity());     // 21 (16 + 5)

        // charAt() & setCharAt()
        StringBuilder sb4 = new StringBuilder("Hello");
        sb4.setCharAt(0, 'J');
        System.out.println("setCharAt(0,J) : " + sb4);  // Jello

        // Chaining
        System.out.println("\n--- Method Chaining ---");
        String chained = new StringBuilder()
                .append("Java")
                .append(" ")
                .append("is")
                .append(" ")
                .append("Awesome!")
                .toString();
        System.out.println("Chained: " + chained);

        // Performance comparison
        // System.out.println("\n--- Performance: String vs StringBuilder ---");
        // int iterations = 10000;

        // long start1 = System.nanoTime();
        // String strResult = "";
        // for (int i = 0; i < iterations; i++) strResult += "a";
        // long time1 = System.nanoTime() - start1;

        // long start2 = System.nanoTime();
        // StringBuilder sbResult = new StringBuilder();
        // for (int i = 0; i < iterations; i++) sbResult.append("a");
        // long time2 = System.nanoTime() - start2;

        // System.out.printf("String  concat (%d times): %,d ns%n", iterations, time1);
        // System.out.printf("StringBuilder (%d times): %,d ns%n", iterations, time2);
        // System.out.printf("StringBuilder is ~%.0fx faster!%n", (double)time1/time2);

        // ============================================================
        // 11. REAL-WORLD EXAMPLES
        // ============================================================
        System.out.println("\n===== 11. REAL-WORLD EXAMPLES =====");

        // Example 1: Email Validator
        System.out.println("--- Email Validator ---");
        String[] emails = {
            "user@example.com",
            "hello.world@gmail.com",
            "invalid-email",
            "no@domain",
            "test@test.org"
        };
        for (String email : emails) {
            boolean valid = email.contains("@")
                    && email.indexOf("@") > 0
                    && email.lastIndexOf(".") > email.indexOf("@")
                    && email.lastIndexOf(".") < email.length() - 1
                    && !email.startsWith("@")
                    && email.matches("[a-zA-Z0-9._%+\\-]+@[a-zA-Z0-9.\\-]+\\.[a-zA-Z]{2,}");
            System.out.printf("  %-28s → %s%n", email,
                    valid ? "✔ Valid" : "✘ Invalid");
        }

        // Example 2: Word Count
        System.out.println("\n--- Word Count ---");
        String para = "Java is a powerful and versatile programming language. "
                    + "Java is widely used in web, mobile, and enterprise apps.";
        System.out.println("Text: \"" + para.substring(0, 50) + "...\"");
        String[] wordArr = para.trim().split("\\s+");
        System.out.println("Total words      : " + wordArr.length);

        // Count specific word
        String targetWord = "Java";
        int wordCount = 0;
        for (String w : wordArr)
            if (w.equalsIgnoreCase(targetWord.replaceAll("[^a-zA-Z]", "")))
                wordCount++;
        System.out.println("Occurrences of \"" + targetWord + "\" : " + wordCount);

        // Example 3: Name Formatter
        System.out.println("\n--- Name Formatter ---");
        String[] rawNames = {"  alice smith  ", "BOB JOHNSON", "charlie BROWN", "diana PRINCE"};
        System.out.printf("  %-22s → %s%n", "Raw Name", "Formatted");
        System.out.println("  " + "-".repeat(45));
        for (String name : rawNames) {
            String[] nameParts = name.trim().toLowerCase().split("\\s+");
            StringBuilder formatted2 = new StringBuilder();
            for (String part : nameParts) {
                formatted2.append(Character.toUpperCase(part.charAt(0)))
                          .append(part.substring(1))
                          .append(" ");
            }
            System.out.printf("  %-22s → %s%n",
                    "\"" + name.trim() + "\"", formatted2.toString().trim());
        }

        // Example 4: String Tokenizer
        System.out.println("\n--- CSV Parser ---");
        String csvLine = "101,Alice Smith,28,Engineer,Mumbai,75000.00";
        String[] fields = csvLine.split(",");
        String[] labels = {"ID","Name","Age","Role","City","Salary"};
        System.out.println("CSV: " + csvLine);
        System.out.println("Parsed:");
        for (int i = 0; i < labels.length; i++) {
            System.out.printf("  %-8s: %s%n", labels[i], fields[i]);
        }

        // Example 5: String Compression (Run-Length Encoding)
        System.out.println("\n--- Run-Length Encoding ---");
        String[] inputs = {"aabcccdddd", "aaabbbccc", "abcd"};
        for (String input : inputs) {
            StringBuilder encoded = new StringBuilder();
            int idx = 0;
            while (idx < input.length()) {
                char curr  = input.charAt(idx);
                int  cnt   = 0;
                while (idx < input.length() && input.charAt(idx) == curr) {
                    cnt++; idx++;
                }
                encoded.append(curr);
                if (cnt > 1) encoded.append(cnt);
            }
            System.out.printf("  %-15s → \"%s\"%n",
                    "\"" + input + "\"", encoded);
        }

        // Example 6: Reverse Words in a Sentence
        System.out.println("\n--- Reverse Words ---");
        String[] sentences3 = {
            "Hello Java World",
            "I love programming",
            "The quick brown fox"
        };
        for (String sent : sentences3) {
            String[] w = sent.split(" ");
            StringBuilder rev = new StringBuilder();
            for (int i = w.length - 1; i >= 0; i--) {
                rev.append(w[i]);
                if (i > 0) rev.append(" ");
            }
            System.out.printf("  %-25s → \"%s\"%n",
                    "\"" + sent + "\"", rev);
        }

        // Example 7: URL Builder
        System.out.println("\n--- URL Builder ---");
        String baseUrl   = "https://api.example.com";
        String endpoint  = "/users";
        String param1    = "page=1";
        String param2    = "limit=10";
        String param3    = "sort=name";
        String fullUrl   = String.format("%s%s?%s&%s&%s",
                baseUrl, endpoint, param1, param2, param3);
        System.out.println("Base     : " + baseUrl);
        System.out.println("Endpoint : " + endpoint);
        System.out.println("Params   : " + String.join(", ", param1, param2, param3));
        System.out.println("Full URL : " + fullUrl);

        System.out.println("\n############################################");
        System.out.println("#      String Basics in Java — Done! ✔    #");
        System.out.println("############################################");
    }
}