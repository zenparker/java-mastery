/*
 * ============================================================
 *        StringBuilder CLASS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS StringBuilder?
 * -----------------------
 * StringBuilder is a MUTABLE sequence of characters in Java.
 * Unlike String (which is immutable), StringBuilder allows
 * you to MODIFY the content without creating new objects.
 *
 * Found in: java.lang package (auto-imported)
 *
 * Key Characteristics:
 *  - MUTABLE   → content can be changed after creation
 *  - DYNAMIC   → size grows automatically as needed
 *  - FAST      → no new object created on modification
 *  - NOT thread-safe → use StringBuffer for multi-threading
 *  - Default capacity: 16 characters
 *  - Auto-resizes: newCapacity = (oldCapacity * 2) + 2
 *
 * ============================================================
 * String vs StringBuilder vs StringBuffer
 * ============================================================
 *
 *  Feature          String        StringBuilder   StringBuffer
 *  ----------       ----------    -------------   -----------
 *  Mutable          ✘ No          ✔ Yes           ✔ Yes
 *  Thread-safe      ✔ Yes         ✘ No            ✔ Yes
 *  Performance      Slow          ✔ Fastest       Medium
 *  Memory (concat)  Wastes        Efficient       Efficient
 *  Since            JDK 1.0       JDK 1.5         JDK 1.0
 *  Use when         Fixed text    Single-thread   Multi-thread
 *
 *  Performance Rule:
 *  String + in loop    → O(n²) — AVOID for large strings
 *  StringBuilder       → O(n)  — USE for concatenation
 *
 * ============================================================
 * HOW CAPACITY WORKS
 * ============================================================
 *
 *  Default capacity = 16
 *  new StringBuilder("Hello") → capacity = 16 + 5 = 21
 *
 *  When content exceeds capacity:
 *  newCapacity = (oldCapacity × 2) + 2
 *
 *  16 → 34 → 70 → 142 → ...
 *
 *  You can set initial capacity to avoid resizing:
 *  new StringBuilder(1000)   // pre-allocate for 1000 chars
 *
 * ============================================================
 * WAYS TO CREATE StringBuilder
 * ============================================================
 *
 *  1. Empty (capacity 16):
 *     StringBuilder sb = new StringBuilder();
 *
 *  2. With initial string:
 *     StringBuilder sb = new StringBuilder("Hello");
 *
 *  3. With initial capacity:
 *     StringBuilder sb = new StringBuilder(100);
 *
 *  4. From CharSequence:
 *     StringBuilder sb = new StringBuilder(charSequence);
 *
 * ============================================================
 * ALL StringBuilder METHODS
 * ============================================================
 *
 *  APPEND METHODS:
 *  ----------------
 *  append(String)        → append string
 *  append(char)          → append character
 *  append(int)           → append integer
 *  append(double)        → append double
 *  append(boolean)       → append boolean
 *  append(char[])        → append char array
 *  append(CharSequence)  → append CharSequence
 *
 *  INSERT METHODS:
 *  ---------------
 *  insert(int, String)   → insert at position
 *  insert(int, char)     → insert char at position
 *  insert(int, int)      → insert int at position
 *
 *  DELETE METHODS:
 *  ---------------
 *  delete(start, end)    → delete chars from start to end-1
 *  deleteCharAt(index)   → delete char at index
 *
 *  REPLACE & REVERSE:
 *  ------------------
 *  replace(start, end, str) → replace substring
 *  reverse()             → reverse entire content
 *
 *  ACCESS METHODS:
 *  ---------------
 *  charAt(index)         → get char at index
 *  indexOf(str)          → first occurrence
 *  indexOf(str, from)    → first occurrence from index
 *  lastIndexOf(str)      → last occurrence
 *  substring(start)      → substring from start
 *  substring(start, end) → substring from start to end-1
 *
 *  MODIFY METHODS:
 *  ---------------
 *  setCharAt(index, ch)  → set char at index
 *  setLength(newLength)  → set/truncate length
 *
 *  INFO METHODS:
 *  -------------
 *  length()              → current number of characters
 *  capacity()            → current allocated capacity
 *  ensureCapacity(min)   → ensure minimum capacity
 *  trimToSize()          → reduce capacity to current length
 *  toString()            → convert to String
 *  chars()               → return IntStream of chars
 *
 * ============================================================
 * METHOD CHAINING
 * ============================================================
 *
 *  Most StringBuilder methods return 'this' (the same object)
 *  allowing multiple operations in a single expression:
 *
 *  sb.append("Hello")
 *    .append(" ")
 *    .append("World")
 *    .insert(5, ",")
 *    .reverse();
 *
 * ============================================================
 * COMMON USE CASES
 * ============================================================
 *
 *  1. String concatenation in loops
 *  2. Building dynamic SQL queries
 *  3. Constructing HTML/XML tags
 *  4. Reversing strings
 *  5. Palindrome checking
 *  6. Building formatted reports
 *  7. CSV row construction
 *  8. Log message building
 *  9. Dynamic URL construction
 * 10. Parsing and modifying text
 *
 * ============================================================
 */

public class StringBuilderClass {

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#       StringBuilder CLASS IN JAVA        #");
        System.out.println("############################################");

        // ============================================================
        // 1. CREATING StringBuilder OBJECTS
        // ============================================================
        System.out.println("\n===== 1. CREATING StringBuilder =====");

        // Empty StringBuilder (default capacity = 16)
        StringBuilder sb1 = new StringBuilder();
        System.out.println("Empty sb1          : \"" + sb1 + "\"");
        System.out.println("Length             : " + sb1.length());
        System.out.println("Capacity           : " + sb1.capacity());   // 16

        // With initial String
        StringBuilder sb2 = new StringBuilder("Hello Java");
        System.out.println("\nWith string        : \"" + sb2 + "\"");
        System.out.println("Length             : " + sb2.length());     // 10
        System.out.println("Capacity           : " + sb2.capacity());   // 26 (16+10)

        // With initial capacity
        StringBuilder sb3 = new StringBuilder(100);
        System.out.println("\nWith capacity(100) : \"" + sb3 + "\"");
        System.out.println("Length             : " + sb3.length());     // 0
        System.out.println("Capacity           : " + sb3.capacity());   // 100

        // From another CharSequence
        CharSequence cs = "CharSequence";
        StringBuilder sb4 = new StringBuilder(cs);
        System.out.println("\nFrom CharSequence  : \"" + sb4 + "\"");

        // ============================================================
        // 2. append() — Add to END
        // ============================================================
        System.out.println("\n===== 2. append() METHOD =====");

        StringBuilder sb = new StringBuilder();
        System.out.println("Initial            : \"" + sb + "\"");

        // Append different types
        sb.append("Hello");
        System.out.println("append(String)     : \"" + sb + "\"");

        sb.append(' ');
        System.out.println("append(char)       : \"" + sb + "\"");

        sb.append("Java");
        System.out.println("append(String)     : \"" + sb + "\"");

        sb.append(2024);
        System.out.println("append(int)        : \"" + sb + "\"");

        sb.append(3.14);
        System.out.println("append(double)     : \"" + sb + "\"");

        sb.append(true);
        System.out.println("append(boolean)    : \"" + sb + "\"");

        // Append char array
        char[] arr = {' ', 'A', 'B', 'C'};
        sb.append(arr);
        System.out.println("append(char[])     : \"" + sb + "\"");

        // Append null
        String nullStr = null;
        sb.append(nullStr);
        System.out.println("append(null)       : \"" + sb + "\"");  // appends "null"

        // Method chaining
        System.out.println("\n--- append() Chaining ---");
        StringBuilder chained = new StringBuilder()
                .append("Name: ")
                .append("Alice")
                .append(" | Age: ")
                .append(22)
                .append(" | GPA: ")
                .append(3.85)
                .append(" | Active: ")
                .append(true);
        System.out.println("Chained: " + chained);

        // Append with range (char array)
        System.out.println("\n--- append(char[], offset, len) ---");
        char[] charArr = {'J','a','v','a','P','r','o','g'};
        StringBuilder sb5 = new StringBuilder("Lang: ");
        sb5.append(charArr, 0, 4);  // "Java" only
        System.out.println("append(char[], 0, 4): \"" + sb5 + "\"");

        // ============================================================
        // 3. insert() — Add at SPECIFIC POSITION
        // ============================================================
        System.out.println("\n===== 3. insert() METHOD =====");

        StringBuilder ins = new StringBuilder("Hello World");
        System.out.println("Original           : \"" + ins + "\"");

        // Insert at beginning
        ins.insert(0, ">>> ");
        System.out.println("insert(0, \">>> \")   : \"" + ins + "\"");

        // Insert in middle
        ins.insert(9, "Java ");
        System.out.println("insert(9, \"Java \")  : \"" + ins + "\"");

        // Insert at end
        ins.insert(ins.length(), " !!!");
        System.out.println("insert(end, \" !!!\") : \"" + ins + "\"");

        // Insert different types
        StringBuilder ins2 = new StringBuilder("Score: ");
        ins2.insert(7, 100);
        System.out.println("\ninsert(int)        : \"" + ins2 + "\"");

        StringBuilder ins3 = new StringBuilder("Flag: ");
        ins3.insert(6, true);
        System.out.println("insert(boolean)    : \"" + ins3 + "\"");

        StringBuilder ins4 = new StringBuilder("Char: ");
        ins4.insert(6, 'X');
        System.out.println("insert(char)       : \"" + ins4 + "\"");

        // ============================================================
        // 4. delete() & deleteCharAt()
        // ============================================================
        System.out.println("\n===== 4. delete() & deleteCharAt() =====");

        StringBuilder del = new StringBuilder("Hello Beautiful Java World");
        System.out.println("Original           : \"" + del + "\"");

        // delete(start, end) — end is EXCLUSIVE
        del.delete(6, 16);   // removes "Beautiful "
        System.out.println("delete(6, 16)      : \"" + del + "\"");

        // delete first word
        StringBuilder del2 = new StringBuilder("PREFIX_Hello World");
        del2.delete(0, 7);
        System.out.println("delete(0, 7)       : \"" + del2 + "\"");

        // delete last word
        StringBuilder del3 = new StringBuilder("Hello World_SUFFIX");
        del3.delete(11, del3.length());
        System.out.println("delete(11, end)    : \"" + del3 + "\"");

        // deleteCharAt(index) — single character
        StringBuilder del4 = new StringBuilder("Hello! World");
        System.out.println("\nBefore deleteCharAt: \"" + del4 + "\"");
        del4.deleteCharAt(5);    // remove '!'
        System.out.println("deleteCharAt(5)    : \"" + del4 + "\"");

        // Delete all content
        StringBuilder del5 = new StringBuilder("Clear this content");
        del5.delete(0, del5.length());
        System.out.println("After delete all   : \"" + del5 + "\" (length=" + del5.length() + ")");

        // ============================================================
        // 5. replace() — Replace a RANGE
        // ============================================================
        System.out.println("\n===== 5. replace() METHOD =====");

        StringBuilder rep = new StringBuilder("Hello Java World");
        System.out.println("Original           : \"" + rep + "\"");

        // replace(start, end, str) — end is EXCLUSIVE
        rep.replace(6, 10, "Python");
        System.out.println("replace(6,10,Python): \"" + rep + "\"");

        // Replace first word
        StringBuilder rep2 = new StringBuilder("Hello World");
        rep2.replace(0, 5, "Goodbye");
        System.out.println("replace first word : \"" + rep2 + "\"");

        // Replace entire content
        StringBuilder rep3 = new StringBuilder("Old Content");
        rep3.replace(0, rep3.length(), "Completely New!");
        System.out.println("replace all        : \"" + rep3 + "\"");

        // Replace and change length
        StringBuilder rep4 = new StringBuilder("AABBCC");
        System.out.println("\nBefore             : \"" + rep4 + "\" length=" + rep4.length());
        rep4.replace(2, 4, "XXXX");  // replace 2 chars with 4
        System.out.println("replace(2,4,XXXX)  : \"" + rep4 + "\" length=" + rep4.length());

        // ============================================================
        // 6. reverse() — Reverse Content
        // ============================================================
        System.out.println("\n===== 6. reverse() METHOD =====");

        String[] reverseTests = {"Hello", "Java", "12345", "racecar", "OpenAI"};
        for (String test : reverseTests) {
            StringBuilder sbRev = new StringBuilder(test);
            String rev = sbRev.reverse().toString();
            System.out.printf("  reverse(\"%-10s\") = \"%s\"%n", test + "\"", rev);
        }

        // Palindrome check using reverse
        System.out.println("\n--- Palindrome Check with reverse() ---");
        String[] words = {"racecar","hello","madam","level","Java","civic"};
        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            boolean isPalin = word.equalsIgnoreCase(reversed);
            System.out.printf("  %-10s → %s%n", "\"" + word + "\"",
                    isPalin ? "✔ Palindrome" : "✘ Not Palindrome");
        }

        // ============================================================
        // 7. charAt() & setCharAt()
        // ============================================================
        System.out.println("\n===== 7. charAt() & setCharAt() =====");

        StringBuilder access = new StringBuilder("Hello World");
        System.out.println("String             : \"" + access + "\"");

        // charAt()
        System.out.println("charAt(0)          : " + access.charAt(0));   // H
        System.out.println("charAt(6)          : " + access.charAt(6));   // W
        System.out.println("charAt(last)       : " + access.charAt(access.length()-1)); // d

        // setCharAt()
        System.out.println("\nBefore setCharAt   : \"" + access + "\"");
        access.setCharAt(0, 'J');
        System.out.println("setCharAt(0, 'J')  : \"" + access + "\"");
        access.setCharAt(6, 'w');
        System.out.println("setCharAt(6, 'w')  : \"" + access + "\"");

        // Iterate and modify
        System.out.println("\n--- Uppercase every other char ---");
        StringBuilder everyOther = new StringBuilder("helloworld");
        for (int i = 0; i < everyOther.length(); i++) {
            if (i % 2 == 0)
                everyOther.setCharAt(i, Character.toUpperCase(everyOther.charAt(i)));
        }
        System.out.println("Result             : \"" + everyOther + "\"");

        // ============================================================
        // 8. indexOf() & lastIndexOf()
        // ============================================================
        System.out.println("\n===== 8. indexOf() & lastIndexOf() =====");

        @SuppressWarnings("ReplaceStringBufferByString")
        StringBuilder search = new StringBuilder("Java is Java and Java is great");
        System.out.println("String             : \"" + search + "\"");

        System.out.println("indexOf(\"Java\")      : " + search.indexOf("Java"));       // 0
        System.out.println("indexOf(\"Java\", 5)   : " + search.indexOf("Java", 5));    // 10
        System.out.println("lastIndexOf(\"Java\")  : " + search.lastIndexOf("Java"));   // 19
        System.out.println("indexOf(\"Python\")    : " + search.indexOf("Python"));     // -1

        // Count occurrences
        System.out.println("\n--- Count Occurrences ---");
        String target = "Java";
        int count = 0, fromIdx = 0;
        while ((fromIdx = search.indexOf(target, fromIdx)) != -1) {
            count++;
            fromIdx += target.length();
        }
        System.out.println("\"Java\" appears " + count + " time(s)");

        // ============================================================
        // 9. substring() — Extract Content
        // ============================================================
        System.out.println("\n===== 9. substring() METHOD =====");

        @SuppressWarnings("ReplaceStringBufferByString")
        StringBuilder subSB = new StringBuilder("Hello Java World 2024");
        System.out.println("String             : \"" + subSB + "\"");

        System.out.println("substring(6)       : \"" + subSB.substring(6) + "\"");
        System.out.println("substring(6, 10)   : \"" + subSB.substring(6, 10) + "\"");
        System.out.println("substring(0, 5)    : \"" + subSB.substring(0, 5) + "\"");
        System.out.println("substring(11, 16)  : \"" + subSB.substring(11, 16) + "\"");

        // ============================================================
        // 10. length(), capacity(), setLength(), ensureCapacity()
        // ============================================================
        System.out.println("\n===== 10. CAPACITY & LENGTH METHODS =====");

        StringBuilder cap = new StringBuilder("Hello");
        System.out.println("Content            : \"" + cap + "\"");
        System.out.println("length()           : " + cap.length());      // 5
        System.out.println("capacity()         : " + cap.capacity());    // 21

        // ensureCapacity()
        cap.ensureCapacity(50);
        System.out.println("After ensureCapacity(50):");
        System.out.println("capacity()         : " + cap.capacity());    // 50+

        // setLength() — truncate or extend
        System.out.println("\n--- setLength() ---");
        StringBuilder setLen = new StringBuilder("Hello World");
        System.out.println("Before setLength   : \"" + setLen + "\" len=" + setLen.length());

        setLen.setLength(5);   // truncate to "Hello"
        System.out.println("setLength(5)       : \"" + setLen + "\" len=" + setLen.length());

        setLen.setLength(10);  // extend with null chars
        System.out.println("setLength(10)      : \"" + setLen + "\" len=" + setLen.length());

        // trimToSize()
        System.out.println("\n--- trimToSize() ---");
        StringBuilder trim = new StringBuilder(100);
        trim.append("Small");
        System.out.println("Before trimToSize  : capacity=" + trim.capacity());  // 100
        trim.trimToSize();
        System.out.println("After  trimToSize  : capacity=" + trim.capacity());  // 5

        // Auto capacity growth
        System.out.println("\n--- Auto Capacity Growth ---");
        StringBuilder grow = new StringBuilder();
        System.out.printf("%-15s length=%-4d capacity=%d%n", "Empty:", grow.length(), grow.capacity());
        for (int i = 0; i < 4; i++) {
            grow.append("JAVA_ROCKS!");  // 11 chars each
            System.out.printf("After append %d    : length=%-4d capacity=%d%n",
                    i+1, grow.length(), grow.capacity());
        }

        // ============================================================
        // 11. toString() & METHOD CHAINING
        // ============================================================
        System.out.println("\n===== 11. toString() & CHAINING =====");

        // toString()
        @SuppressWarnings("ReplaceStringBufferByString")
        StringBuilder toStr = new StringBuilder("StringBuilder");
        String result = toStr.toString();
        System.out.println("toString()         : \"" + result + "\"");
        System.out.println("Type               : " + result.getClass().getSimpleName());

        // Method chaining
        System.out.println("\n--- Method Chaining ---");
        String chainResult = new StringBuilder()
                .append("Hello")
                .append(", ")
                .append("Java")
                .append("! ")
                .insert(7, "Beautiful ")
                .replace(0, 5, "Goodbye")
                .append("Version ")
                .append(21)
                .toString();
        System.out.println("Chained result     : \"" + chainResult + "\"");

        // ============================================================
        // 12. StringBuilder vs String PERFORMANCE
        // ============================================================
        System.out.println("\n===== 12. PERFORMANCE COMPARISON =====");

        int n = 50000;

        // String concatenation (slow)
        long t1 = System.nanoTime();
        @SuppressWarnings("unused")
        String strConcat = "";
        for (int i = 0; i < n; i++) strConcat += "a";
        long time1 = System.nanoTime() - t1;

        // StringBuilder append (fast)
        long t2 = System.nanoTime();
        StringBuilder sbConcat = new StringBuilder();
        for (int i = 0; i < n; i++) sbConcat.append("a");
        long time2 = System.nanoTime() - t2;

        // StringBuilder with capacity (fastest)
        long t3 = System.nanoTime();
        StringBuilder sbPreAlloc = new StringBuilder(n);
        for (int i = 0; i < n; i++) sbPreAlloc.append("a");
        long time3 = System.nanoTime() - t3;

        System.out.printf("Iterations         : %,d%n", n);
        System.out.printf("String  concat     : %,12d ns%n", time1);
        System.out.printf("StringBuilder      : %,12d ns%n", time2);
        System.out.printf("SB + prealloc      : %,12d ns%n", time3);
        System.out.printf("SB speedup         : ~%.0fx faster than String%n",
                (double) time1 / time2);

        // ============================================================
        // 13. REAL-WORLD EXAMPLES
        // ============================================================
        System.out.println("\n===== 13. REAL-WORLD EXAMPLES =====");

        // Example 1: Build HTML Table
        System.out.println("--- HTML Table Builder ---");
        String[][] tableData = {
            {"Alice", "25", "Engineer"},
            {"Bob",   "30", "Manager"},
            {"Carol", "28", "Designer"}
        };
        String[] headers = {"Name", "Age", "Role"};

        StringBuilder html = new StringBuilder();
        html.append("<table border='1'>\n");
        html.append("  <tr>");
        for (String h : headers)
            html.append("<th>").append(h).append("</th>");
        html.append("</tr>\n");
        for (String[] row : tableData) {
            html.append("  <tr>");
            for (String cell : row)
                html.append("<td>").append(cell).append("</td>");
            html.append("</tr>\n");
        }
        html.append("</table>");
        System.out.println(html);

        // Example 2: Dynamic SQL Query Builder
        System.out.println("--- SQL Query Builder ---");
        String tableName  = "employees";
        String[] cols     = {"name", "department", "salary"};
        String condition  = "department = 'Engineering'";
        String orderBy    = "salary DESC";
        int    limit      = 10;

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(String.join(", ", cols));
        sql.append("\nFROM ").append(tableName);
        sql.append("\nWHERE ").append(condition);
        sql.append("\nORDER BY ").append(orderBy);
        sql.append("\nLIMIT ").append(limit).append(";");
        System.out.println(sql);

        // Example 3: CSV Row Builder
        System.out.println("\n--- CSV Row Builder ---");
        Object[][] csvData = {
            {101, "Alice",   "Mumbai",  85000.00},
            {102, "Bob",     "Delhi",   72000.50},
            {103, "Charlie", "Pune",    95000.75}
        };
        StringBuilder csv = new StringBuilder();
        csv.append("ID,Name,City,Salary\n");
        for (Object[] row : csvData) {
            StringBuilder rowSB = new StringBuilder();
            for (int i = 0; i < row.length; i++) {
                rowSB.append(row[i]);
                if (i < row.length - 1) rowSB.append(",");
            }
            csv.append(rowSB).append("\n");
        }
        System.out.print(csv);

        // Example 4: Log Message Builder
        System.out.println("--- Log Message Builder ---");
        String[] levels  = {"INFO", "WARN", "ERROR", "DEBUG"};
        String[] msgs    = {
            "Application started",
            "Memory usage above 80%",
            "Database connection failed",
            "Processing request id=4521"
        };
        for (int i = 0; i < levels.length; i++) {
            StringBuilder log = new StringBuilder();
            log.append("[").append(levels[i]).append("]")
               .append("  ")
               .append(String.format("%-8s", levels[i].equals("ERROR") ? "🔴" :
                                              levels[i].equals("WARN")  ? "🟡" :
                                              levels[i].equals("INFO")  ? "🟢" : "🔵"))
               .append(msgs[i]);
            System.out.println(log);
        }

        // Example 5: URL Encoder (spaces → %20)
        // System.out.println("\n--- Simple URL Encoder ---");
        // String[] urlInputs = {
        //     "Hello World",
        //     "Java Programming 2024",
        //     "search query here"
        // };
        // for (String input : urlInputs) {
        //     StringBuilder encoded = new StringBuilder();
        //     for (char ch : input.toCharArray()) {
        //         if (ch == ' ')          encoded.append("%20");
        //         else if (ch == '&')     encoded.append("%26");
        //         else if (ch == '=')     encoded.append("%3D");
        //         else if (ch == '?')     encoded.append("%3F");
        //         else                    encoded.append(ch);
        //     }
        //     System.out.printf("  %-25s → %s%n", "\"" + input + "\"", encoded);
        // }

        // Example 6: String Repeat Pattern Builder
        System.out.println("\n--- Pattern Builder ---");
        int width = 20;
        StringBuilder[] patterns = {
            new StringBuilder(),
            new StringBuilder(),
            new StringBuilder()
        };
        for (int i = 0; i < width; i++) {
            patterns[0].append(i % 2 == 0 ? "* " : "  ");
            patterns[1].append((char)('A' + i % 26));
            patterns[2].append(i % 10);
        }
        System.out.println("Alternating : " + patterns[0]);
        System.out.println("Alphabet    : " + patterns[1]);
        System.out.println("Numbers     : " + patterns[2]);

        // Example 7: Text Wrapper (wrap at N chars)
        System.out.println("\n--- Word Wrap (width=20) ---");
        String longText = "Java is a powerful versatile and widely used programming language";
        String[] textWords  = longText.split(" ");
        int      lineWidth  = 20;
        StringBuilder wrapped = new StringBuilder();
        int lineLen = 0;
        for (String word : textWords) {
            if (lineLen + word.length() + 1 > lineWidth && lineLen > 0) {
                wrapped.append("\n");
                lineLen = 0;
            }
            if (lineLen > 0) { wrapped.append(" "); lineLen++; }
            wrapped.append(word);
            lineLen += word.length();
        }
        System.out.println("Original : " + longText);
        System.out.println("Wrapped:");
        for (String line : wrapped.toString().split("\n")) {
            System.out.println("  |" + line + "|");
        }

        // Example 8: StringBuilder as Stack (push/pop chars)
        System.out.println("\n--- StringBuilder as Character Stack ---");
        StringBuilder stack = new StringBuilder();
        String pushChars = "JAVA";

        System.out.print("Pushing: ");
        for (char ch : pushChars.toCharArray()) {
            stack.append(ch);
            System.out.print(ch + " → [" + stack + "] ");
        }
        System.out.println();

        System.out.print("Popping: ");
        while (stack.length() > 0) {
            char popped = stack.charAt(stack.length() - 1);
            stack.deleteCharAt(stack.length() - 1);
            System.out.print(popped + " ← [" + stack + "] ");
        }
        System.out.println();

        System.out.println("\n############################################");
        System.out.println("#    StringBuilder in Java — Done! ✔      #");
        System.out.println("############################################");
    }
}