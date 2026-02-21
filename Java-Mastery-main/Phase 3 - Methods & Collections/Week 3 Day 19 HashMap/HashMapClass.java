/*
 * ============================================================
 *          HashMap CLASS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS HashMap?
 * -----------------
 * HashMap is a data structure that stores data in KEY-VALUE
 * PAIRS. It is part of the java.util package and implements
 * the Map interface. Each key maps to exactly one value.
 *
 * Real-life analogies:
 *  - Dictionary: word (key) → meaning (value)
 *  - Phone book: name (key) → number (value)
 *  - Student ID: rollNo (key) → studentName (value)
 *  - Country code: code (key) → country (value)
 *
 * Key Characteristics:
 *  - Stores KEY-VALUE pairs
 *  - Keys must be UNIQUE (no duplicate keys)
 *  - Values CAN be duplicated
 *  - Allows ONE null key and MULTIPLE null values
 *  - NO guaranteed order (use LinkedHashMap for order)
 *  - NOT thread-safe (use ConcurrentHashMap for threads)
 *  - Backed by a HASH TABLE internally
 *  - Average O(1) for get(), put(), remove()
 *
 * ============================================================
 * INTERNAL WORKING
 * ============================================================
 *
 *  HashMap uses an array of BUCKETS (Node[]).
 *  Default initial capacity  = 16 buckets
 *  Default load factor       = 0.75
 *  Threshold = capacity × loadFactor = 16 × 0.75 = 12
 *
 *  When entries exceed threshold → REHASHING occurs:
 *  capacity doubles: 16 → 32 → 64 → 128 → ...
 *
 *  How put(key, value) works:
 *  1. Compute hashCode(key)
 *  2. Find bucket index: index = hash & (capacity-1)
 *  3. If bucket empty → store Node{key, value}
 *  4. If bucket occupied → COLLISION → use chaining
 *     (linked list, or tree if > 8 nodes — Java 8+)
 *
 *  COLLISION: Two keys hash to same bucket index.
 *  Resolved by: Chaining (linked list per bucket)
 *
 *  Java 8+: If a bucket's linked list grows > 8 nodes,
 *  it converts to a RED-BLACK TREE for O(log n) ops.
 *
 * ============================================================
 * HashMap vs Other Map Implementations
 * ============================================================
 *
 *  Feature         HashMap   LinkedHashMap  TreeMap
 *  ----------      --------  -------------  -------
 *  Order           None      Insertion      Sorted
 *  Null key        1 allowed 1 allowed      Not allowed
 *  Performance     O(1) avg  O(1) avg       O(log n)
 *  Thread-safe     No        No             No
 *  Use when        Fast ops  Order matters  Sorted keys
 *
 * ============================================================
 * IMPORT REQUIRED
 * ============================================================
 *
 *  import java.util.HashMap;
 *  import java.util.Map;
 *  import java.util.Set;
 *  import java.util.Collection;
 *  import java.util.LinkedHashMap;
 *  import java.util.TreeMap;
 *
 * ============================================================
 * WAYS TO CREATE HashMap
 * ============================================================
 *
 *  1. Empty HashMap (default capacity 16, loadFactor 0.75):
 *     HashMap<String, Integer> map = new HashMap<>();
 *
 *  2. With initial capacity:
 *     HashMap<String, Integer> map = new HashMap<>(50);
 *
 *  3. With capacity + loadFactor:
 *     HashMap<String, Integer> map = new HashMap<>(50, 0.9f);
 *
 *  4. Copy from another Map:
 *     HashMap<String, Integer> map = new HashMap<>(otherMap);
 *
 *  5. Using Map.of() → then copy (Java 9+):
 *     HashMap<String,Integer> map = new HashMap<>(Map.of("a",1));
 *
 * ============================================================
 * ALL HashMap METHODS
 * ============================================================
 *
 *  ADDING / UPDATING:
 *  -------------------
 *  put(key, value)           → add/update key-value pair
 *  putAll(map)               → add all from another map
 *  putIfAbsent(key, value)   → add only if key not present
 *  replace(key, value)       → replace value for key
 *  replace(key, old, new)    → replace only if old value matches
 *  merge(key, val, function) → merge with existing value
 *  compute(key, function)    → compute new value for key
 *  computeIfAbsent(key, fn)  → compute if key absent
 *  computeIfPresent(key, fn) → compute if key present
 *
 *  ACCESSING:
 *  -----------
 *  get(key)                  → get value by key (null if absent)
 *  getOrDefault(key, def)    → get value or default
 *  containsKey(key)          → true if key exists
 *  containsValue(value)      → true if value exists
 *  size()                    → number of key-value pairs
 *  isEmpty()                 → true if map is empty
 *
 *  REMOVING:
 *  ----------
 *  remove(key)               → remove by key
 *  remove(key, value)        → remove only if key=value match
 *  clear()                   → remove all entries
 *
 *  VIEWS:
 *  -------
 *  keySet()                  → Set of all keys
 *  values()                  → Collection of all values
 *  entrySet()                → Set of all key-value pairs
 *
 *  ITERATION:
 *  -----------
 *  forEach(BiConsumer)       → iterate with lambda
 *
 * ============================================================
 * KEY RULES
 * ============================================================
 *
 *  1. Keys must implement hashCode() and equals()
 *  2. String and Integer are great keys (already implemented)
 *  3. put() with existing key → OVERWRITES old value
 *  4. get() with missing key  → returns null
 *  5. Use getOrDefault() to avoid null checks
 *  6. Never use mutable objects as keys!
 *
 * ============================================================
 */

import java.util.*;

public class HashMapClass {

    // ── separator helper ──
    static void sep() { System.out.println("  " + "-".repeat(50)); }

    // ── print map nicely ──
    @SuppressWarnings("unused")
    static <K, V> void printMap(String label, Map<K, V> map) {
        System.out.println(label + " (size=" + map.size() + "):");
        map.forEach((k, v) -> System.out.printf("  %-15s → %s%n", k, v));
    }

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#          HashMap CLASS IN JAVA           #");
        System.out.println("############################################");

        // ============================================================
        // 1. CREATING HashMap
        // ============================================================
        System.out.println("\n===== 1. CREATING HashMap =====");

        // Empty HashMap
        HashMap<String, Integer> map1 = new HashMap<>();
        System.out.println("Empty map          : " + map1);
        System.out.println("Size               : " + map1.size());
        System.out.println("isEmpty()          : " + map1.isEmpty());

        // With initial capacity
        HashMap<String, Double> map2 = new HashMap<>(50);
        System.out.println("With capacity(50)  : " + map2);

        // With capacity + load factor
        HashMap<Integer, String> map3 = new HashMap<>(32, 0.9f);
        System.out.println("cap=32, lf=0.9     : " + map3);

        // From Map.of() — Java 9+
        HashMap<String, Integer> map4 = new HashMap<>(
                Map.of("one",1, "two",2, "three",3, "four",4));
        System.out.println("From Map.of()      : " + map4);

        // Different key-value types
        HashMap<String,  String>  strMap  = new HashMap<>();
        HashMap<Integer, String>  intMap  = new HashMap<>();
        HashMap<String,  Double>  dblMap  = new HashMap<>();
        HashMap<String,  Boolean> bolMap  = new HashMap<>();

        strMap.put("name", "Alice");   strMap.put("city", "Mumbai");
        intMap.put(1, "January");      intMap.put(2, "February");
        dblMap.put("pi", 3.14159);     dblMap.put("e",  2.71828);
        bolMap.put("isActive", true);  bolMap.put("isAdmin", false);

        System.out.println("\n<String, String>   : " + strMap);
        System.out.println("<Integer, String>  : " + intMap);
        System.out.println("<String, Double>   : " + dblMap);
        System.out.println("<String, Boolean>  : " + bolMap);

        // ============================================================
        // 2. put() & putAll() — ADDING ENTRIES
        // ============================================================
        System.out.println("\n===== 2. put() & putAll() =====");

        HashMap<String, Integer> scores = new HashMap<>();

        // put(key, value)
        scores.put("Alice",   92);
        scores.put("Bob",     78);
        scores.put("Charlie", 95);
        scores.put("Diana",   85);
        scores.put("Eve",     70);
        System.out.println("After put()        : " + scores);
        System.out.println("Size               : " + scores.size());

        // put() with DUPLICATE key → overwrites value
        System.out.println("\nBefore overwrite   : Alice=" + scores.get("Alice"));
        int oldVal = scores.put("Alice", 99);   // returns OLD value
        System.out.println("After  overwrite   : Alice=" + scores.get("Alice"));
        System.out.println("Old value returned : " + oldVal);  // 92

        // putIfAbsent() — only adds if key NOT present
        scores.putIfAbsent("Frank",  88);   // added (new key)
        scores.putIfAbsent("Alice",  0);    // NOT added (key exists)
        System.out.println("\nAfter putIfAbsent  : " + scores);

        // putAll() — add all from another map
        HashMap<String, Integer> moreScores = new HashMap<>();
        moreScores.put("Grace",  91);
        moreScores.put("Henry",  74);
        moreScores.put("Isla",   87);
        scores.putAll(moreScores);
        System.out.println("After putAll()     : " + scores);

        // Null key and null value
        HashMap<String, String> nullMap = new HashMap<>();
        nullMap.put(null, "nullKey");   // one null key allowed
        nullMap.put("a",  null);        // null value allowed
        nullMap.put("b",  null);        // multiple null values ok
        System.out.println("\nNull key/value     : " + nullMap);

        // ============================================================
        // 3. get() & getOrDefault() — ACCESSING VALUES
        // ============================================================
        System.out.println("\n===== 3. get() & getOrDefault() =====");

        HashMap<String, String> capitals = new HashMap<>();
        capitals.put("India",   "New Delhi");
        capitals.put("USA",     "Washington D.C.");
        capitals.put("UK",      "London");
        capitals.put("France",  "Paris");
        capitals.put("Japan",   "Tokyo");
        capitals.put("Germany", "Berlin");
        System.out.println("Capitals map       : " + capitals);

        // get()
        System.out.println("\nget(\"India\")        : " + capitals.get("India"));
        System.out.println("get(\"Japan\")        : " + capitals.get("Japan"));
        System.out.println("get(\"Australia\")    : " + capitals.get("Australia")); // null

        // getOrDefault()
        System.out.println("\ngetOrDefault(India) : "
                + capitals.getOrDefault("India",     "Unknown")); // New Delhi
        System.out.println("getOrDefault(China) : "
                + capitals.getOrDefault("China",     "Unknown")); // Unknown
        System.out.println("getOrDefault(Brazil): "
                + capitals.getOrDefault("Brazil",    "Not Found"));

        // Practical getOrDefault — word frequency
        System.out.println("\n--- Word Frequency with getOrDefault ---");
        String text = "the cat sat on the mat the cat sat";
        HashMap<String, Integer> wordFreq = new HashMap<>();
        for (String word : text.split(" ")) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        System.out.println("Text    : \"" + text + "\"");
        System.out.println("FreqMap : " + wordFreq);

        // ============================================================
        // 4. containsKey() & containsValue()
        // ============================================================
        System.out.println("\n===== 4. containsKey() & containsValue() =====");

        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Alice",   22);
        ages.put("Bob",     30);
        ages.put("Charlie", 25);
        ages.put("Diana",   28);
        System.out.println("Ages map           : " + ages);

        // containsKey()
        System.out.println("\ncontainsKey(Alice)  : " + ages.containsKey("Alice"));    // true
        System.out.println("containsKey(Eve)    : " + ages.containsKey("Eve"));      // false
        System.out.println("containsKey(Bob)    : " + ages.containsKey("Bob"));      // true

        // containsValue()
        System.out.println("\ncontainsValue(22)   : " + ages.containsValue(22));      // true
        System.out.println("containsValue(99)   : " + ages.containsValue(99));      // false
        System.out.println("containsValue(30)   : " + ages.containsValue(30));      // true

        // Practical: check before accessing
        String[] lookups = {"Alice", "Eve", "Bob", "Zara"};
        System.out.println("\n--- Safe Lookup ---");
        for (String name : lookups) {
            if (ages.containsKey(name))
                System.out.printf("  %-8s → age: %d%n", name, ages.get(name));
            else
                System.out.printf("  %-8s → not found%n", name);
        }

        // ============================================================
        // 5. remove() & replace()
        // ============================================================
        System.out.println("\n===== 5. remove() & replace() =====");

        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Apples",  50);
        inventory.put("Bananas", 30);
        inventory.put("Cherries",20);
        inventory.put("Dates",   40);
        inventory.put("Elderberry",15);
        System.out.println("Inventory          : " + inventory);

        // remove(key)
        int removed = inventory.remove("Elderberry");
        System.out.println("remove(Elderberry) : returned " + removed);
        System.out.println("After remove       : " + inventory);

        // remove(key, value) — removes ONLY if value matches
        boolean rem1 = inventory.remove("Bananas", 30);   // matches → removed
        boolean rem2 = inventory.remove("Dates",   99);   // doesn't match → not removed
        System.out.println("remove(Bananas,30) : " + rem1 + " → " + inventory);
        System.out.println("remove(Dates, 99)  : " + rem2 + " (no match)");

        // remove non-existent key
        Integer notThere = inventory.remove("Mango");
        System.out.println("remove(Mango)      : " + notThere + " (not found)");

        // replace(key, value)
        inventory.replace("Apples", 100);
        System.out.println("\nreplace(Apples,100): " + inventory);

        // replace(key, oldVal, newVal) — replaces ONLY if old matches
        boolean rep1 = inventory.replace("Cherries", 20, 60);  // matches → replaced
        boolean rep2 = inventory.replace("Dates",    99, 80);  // doesn't match
        System.out.println("replace(Cherries,20→60): " + rep1 + " → " + inventory);
        System.out.println("replace(Dates,99→80)   : " + rep2 + " (no match)");

        // clear()
        HashMap<String, Integer> tempMap = new HashMap<>(Map.of("a",1,"b",2,"c",3));
        System.out.println("\nBefore clear()     : " + tempMap);
        tempMap.clear();
        System.out.println("After  clear()     : " + tempMap + " isEmpty=" + tempMap.isEmpty());

        // ============================================================
        // 6. keySet(), values(), entrySet()
        // ============================================================
        System.out.println("\n===== 6. keySet(), values(), entrySet() =====");

        HashMap<String, Integer> population = new HashMap<>();
        population.put("India",  1400);
        population.put("China",  1412);
        population.put("USA",    331);
        population.put("Brazil", 215);
        population.put("Russia", 145);
        System.out.println("Population map     : " + population);

        // keySet() — all keys
        Set<String> keys = population.keySet();
        System.out.println("\nkeySet()           : " + keys);
        System.out.print("Iterate keys       : ");
        for (String key : keys) System.out.print(key + " ");
        System.out.println();

        // values() — all values
        Collection<Integer> vals = population.values();
        System.out.println("\nvalues()           : " + vals);
        int totalPop = 0;
        for (int v : vals) totalPop += v;
        System.out.println("Sum of values      : " + totalPop + " million");

        // entrySet() — key-value pairs as Map.Entry
        Set<Map.Entry<String, Integer>> entries = population.entrySet();
        System.out.println("\n--- entrySet() iteration ---");
        System.out.printf("  %-10s %10s%n", "Country", "Population(M)");
        sep();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.printf("  %-10s %10d%n", entry.getKey(), entry.getValue());
        }

        // Modify value via entrySet
        System.out.println("\n--- Modify values via entrySet ---");
        for (Map.Entry<String, Integer> entry : entries) {
            entry.setValue(entry.getValue() + 10);   // add 10 to each
        }
        System.out.println("After +10 each     : " + population);

        // ============================================================
        // 7. ITERATION METHODS
        // ============================================================
        System.out.println("\n===== 7. ITERATION METHODS =====");

        HashMap<String, Integer> grades = new HashMap<>();
        grades.put("Math",     92);
        grades.put("Science",  88);
        grades.put("English",  76);
        grades.put("History",  84);
        grades.put("CS",       97);
        System.out.println("Grades             : " + grades);

        // Method 1: for-each on entrySet (BEST practice)
        System.out.println("\n--- 1. for-each entrySet ---");
        for (Map.Entry<String, Integer> e : grades.entrySet()) {
            System.out.printf("  %-10s : %d%n", e.getKey(), e.getValue());
        }

        // Method 2: for-each on keySet
        System.out.println("\n--- 2. for-each keySet ---");
        for (String key : grades.keySet()) {
            System.out.printf("  %-10s : %d%n", key, grades.get(key));
        }

        // Method 3: forEach with lambda (Java 8+)
        System.out.println("\n--- 3. forEach lambda ---");
        grades.forEach((subject, mark) ->
            System.out.printf("  %-10s : %d %s%n",
                subject, mark, mark >= 90 ? "★" : ""));

        // Method 4: Iterator on entrySet
        // System.out.println("\n--- 4. Iterator ---");
        // Iterator<Map.Entry<String, Integer>> it = grades.entrySet().iterator();
        // while (it.hasNext()) {
        //     Map.Entry<String, Integer> e = it.next();
        //     System.out.printf("  %-10s : %d%n", e.getKey(), e.getValue());
        // }

        // Method 5: Stream (Java 8+)
        System.out.println("\n--- 5. Stream (subjects scored > 85) ---");
        grades.entrySet().stream()
              .filter(e -> e.getValue() > 85)
              .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
              .forEach(e -> System.out.printf("  %-10s : %d%n",
                      e.getKey(), e.getValue()));

        // ============================================================
        // 8. ADVANCED METHODS
        // ============================================================
        System.out.println("\n===== 8. ADVANCED METHODS =====");

        // merge() — combine values
        System.out.println("--- merge() ---");
        HashMap<String, Integer> votes = new HashMap<>();
        String[] ballots = {"Alice","Bob","Alice","Charlie","Bob","Alice","Alice"};
        for (String vote : ballots) {
            votes.merge(vote, 1, Integer::sum);  // add 1 each time
        }
        System.out.println("Ballots : " + Arrays.toString(ballots));
        System.out.println("Votes   : " + votes);

        // merge with string concat
        HashMap<String, String> tags = new HashMap<>();
        tags.merge("Java", "OOP",      (old, nw) -> old + ", " + nw);
        tags.merge("Java", "Static",   (old, nw) -> old + ", " + nw);
        tags.merge("Java", "Compiled", (old, nw) -> old + ", " + nw);
        tags.merge("Python", "Dynamic",(old, nw) -> old + ", " + nw);
        System.out.println("Tags    : " + tags);

        // compute() — compute new value
        System.out.println("\n--- compute() ---");
        HashMap<String, Integer> stock = new HashMap<>(
                Map.of("Apple",10, "Banana",20, "Cherry",15));
        System.out.println("Before compute     : " + stock);
        stock.compute("Apple",  (k, v) -> v == null ? 1 : v + 5);  // +5
        stock.compute("Mango",  (k, v) -> v == null ? 1 : v + 5);  // new key
        System.out.println("After  compute     : " + stock);

        // computeIfAbsent() — compute only if key missing
        System.out.println("\n--- computeIfAbsent() ---");
        HashMap<String, List<String>> groups = new HashMap<>();
        String[] members = {"Alice","Bob","Charlie","Anna","Brian","Clara"};
        for (String m : members) {
            String firstLetter = String.valueOf(m.charAt(0));
            groups.computeIfAbsent(firstLetter, k -> new ArrayList<>()).add(m);
        }
        System.out.println("Grouped by letter  : " + groups);

        // computeIfPresent() — compute only if key present
        System.out.println("\n--- computeIfPresent() ---");
        HashMap<String, Integer> prices = new HashMap<>(
                Map.of("Laptop",50000, "Phone",30000, "Tablet",20000));
        System.out.println("Before             : " + prices);
        prices.computeIfPresent("Laptop", (k, v) -> (int)(v * 0.9)); // 10% discount
        prices.computeIfPresent("TV",     (k, v) -> (int)(v * 0.9)); // key missing → no change
        System.out.println("After 10% discount : " + prices);

        // ============================================================
        // 9. LinkedHashMap — Maintains INSERTION ORDER
        // ============================================================
        System.out.println("\n===== 9. LinkedHashMap (Insertion Order) =====");

        LinkedHashMap<String, Integer> linked = new LinkedHashMap<>();
        linked.put("Banana",  3);
        linked.put("Apple",   1);
        linked.put("Cherry",  2);
        linked.put("Mango",   5);
        linked.put("Date",    4);

        System.out.println("LinkedHashMap      : " + linked);
        System.out.println("Order preserved    : ✔ Insertion order maintained");

        // Compare with HashMap (no order)
        HashMap<String, Integer> unordered = new HashMap<>(linked);
        System.out.println("HashMap (same data): " + unordered);
        System.out.println("Order preserved    : ✘ Order NOT guaranteed");

        // Access-order LinkedHashMap (LRU Cache pattern)
        LinkedHashMap<String, Integer> lruCache = new LinkedHashMap<>(
                16, 0.75f, true) {  // accessOrder=true
            @Override
            protected boolean removeEldestEntry(Map.Entry<String,Integer> e) {
                return size() > 3;   // keep only 3 entries
            }
        };
        lruCache.put("A", 1); lruCache.put("B", 2);
        lruCache.put("C", 3);
        System.out.println("\nLRU Cache (cap=3)  : " + lruCache);
        lruCache.get("A");           // access A → moves to end
        lruCache.put("D", 4);        // adds D → evicts LRU (B)
        System.out.println("After access A, add D: " + lruCache);

        // ============================================================
        // 10. TreeMap — SORTED ORDER
        // ============================================================
        System.out.println("\n===== 10. TreeMap (Sorted Order) =====");

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Banana",  3);
        treeMap.put("Apple",   1);
        treeMap.put("Cherry",  2);
        treeMap.put("Mango",   5);
        treeMap.put("Date",    4);

        System.out.println("TreeMap (natural)  : " + treeMap);

        // TreeMap specific methods
        System.out.println("firstKey()         : " + treeMap.firstKey());
        System.out.println("lastKey()          : " + treeMap.lastKey());
        System.out.println("headMap(Date)      : " + treeMap.headMap("Date"));
        System.out.println("tailMap(Date)      : " + treeMap.tailMap("Date"));
        System.out.println("subMap(B, M)       : " + treeMap.subMap("B","M"));
        System.out.println("floorKey(Coconut)  : " + treeMap.floorKey("Coconut"));
        System.out.println("ceilingKey(Coconut): " + treeMap.ceilingKey("Coconut"));

        // Reverse order TreeMap
        TreeMap<String, Integer> descMap = new TreeMap<>(Collections.reverseOrder());
        descMap.putAll(treeMap);
        System.out.println("TreeMap (reverse)  : " + descMap);

        // ============================================================
        // 11. HashMap of Objects
        // ============================================================
        System.out.println("\n===== 11. HashMap OF OBJECTS =====");

        HashMap<Integer, Employee> empMap = new HashMap<>();
        empMap.put(101, new Employee(101, "Alice",   "Engineering", 85000));
        empMap.put(102, new Employee(102, "Bob",     "Marketing",   65000));
        empMap.put(103, new Employee(103, "Charlie", "Engineering", 92000));
        empMap.put(104, new Employee(104, "Diana",   "HR",          70000));
        empMap.put(105, new Employee(105, "Eve",     "Engineering", 78000));

        System.out.println("--- Employee Directory ---");
        System.out.printf("  %-5s %-12s %-15s %10s%n",
                "ID","Name","Department","Salary");
        sep();
        empMap.forEach((id, emp) ->
            System.out.printf("  %-5d %-12s %-15s %10.0f%n",
                    id, emp.name, emp.dept, emp.salary));

        // Lookup by ID
        System.out.println("\n--- Lookup by ID ---");
        int[] lookupIds = {102, 105, 999};
        for (int id : lookupIds) {
            Employee emp = empMap.getOrDefault(id, null);
            System.out.printf("  ID %3d → %s%n", id,
                    emp != null ? emp.name + " (" + emp.dept + ")" : "Not found");
        }

        // Filter by department
        System.out.println("\n--- Engineering Department ---");
        empMap.forEach((id, emp) -> {
            if ("Engineering".equals(emp.dept))
                System.out.printf("  %d: %s | Salary: ₹%.0f%n",
                        id, emp.name, emp.salary);
        });

        // Total salary by department
        System.out.println("\n--- Total Salary by Department ---");
        HashMap<String, Double> deptSalary = new HashMap<>();
        empMap.forEach((id, emp) ->
            deptSalary.merge(emp.dept, emp.salary, Double::sum));
        deptSalary.forEach((dept, total) ->
            System.out.printf("  %-15s : ₹%.0f%n", dept, total));

        // ============================================================
        // 12. REAL-WORLD EXAMPLES
        // ============================================================
        System.out.println("\n===== 12. REAL-WORLD EXAMPLES =====");

        // Example 1: Phone Book
        System.out.println("--- Phone Book ---");
        HashMap<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Alice",   "+91-9876543210");
        phoneBook.put("Bob",     "+91-9123456789");
        phoneBook.put("Charlie", "+91-9988776655");
        phoneBook.put("Diana",   "+91-9001122334");

        String[] searchNames = {"Alice", "Eve", "Charlie"};
        for (String name : searchNames) {
            System.out.printf("  %-10s → %s%n", name,
                    phoneBook.getOrDefault(name, "Number not found"));
        }

        // Add and remove contacts
        phoneBook.put("Eve", "+91-9871234560");
        System.out.println("  Added Eve      : " + phoneBook.get("Eve"));
        phoneBook.remove("Bob");
        System.out.println("  After remove Bob (size): " + phoneBook.size());

        // Example 2: Character Frequency Counter
        System.out.println("\n--- Character Frequency Counter ---");
        String word = "programming";
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (char ch : word.toCharArray()) {
            charFreq.merge(ch, 1, Integer::sum);
        }
        // Sort by frequency (descending)
        charFreq.entrySet().stream()
                .sorted(Map.Entry.<Character,Integer>comparingByValue().reversed())
                .forEach(e -> {
                    System.out.printf("  '%c' : %d %s%n",
                            e.getKey(), e.getValue(),
                            "▓".repeat(e.getValue()));
                });

        // Example 3: Inventory Management
        System.out.println("\n--- Inventory Management ---");
        HashMap<String, Integer>  invItems = new HashMap<>();
        HashMap<String, Double>   invPrice = new HashMap<>();

        invItems.put("Laptop",   15); invPrice.put("Laptop",   75000.0);
        invItems.put("Phone",    30); invPrice.put("Phone",    25000.0);
        invItems.put("Tablet",    8); invPrice.put("Tablet",   35000.0);
        invItems.put("Monitor",  12); invPrice.put("Monitor",  18000.0);
        invItems.put("Keyboard", 50); invPrice.put("Keyboard",  1500.0);

        System.out.printf("  %-12s %8s %12s %14s %8s%n",
                "Item","Qty","Price","Total Value","Status");
        sep();
        double totalValue = 0;
        for (String item : invItems.keySet()) {
            int    qty   = invItems.get(item);
            double price = invPrice.get(item);
            double total = qty * price;
            totalValue  += total;
            String status = qty < 10 ? "⚠ LOW" : "✔ OK";
            System.out.printf("  %-12s %8d %12.2f %14.2f %8s%n",
                    item, qty, price, total, status);
        }
        sep();
        System.out.printf("  %-33s %14.2f%n", "Total Inventory Value:", totalValue);

        // Example 4: Student Grade Book
        System.out.println("\n--- Student Grade Book ---");
        HashMap<String, HashMap<String, Integer>> gradeBook = new HashMap<>();
        gradeBook.put("Alice",   new HashMap<>(Map.of("Math",95,"Science",92,"English",88)));
        gradeBook.put("Bob",     new HashMap<>(Map.of("Math",72,"Science",68,"English",80)));
        gradeBook.put("Charlie", new HashMap<>(Map.of("Math",98,"Science",95,"English",91)));

        System.out.printf("  %-10s %8s %10s %10s %8s%n",
                "Student","Math","Science","English","Avg");
        sep();
        for (Map.Entry<String, HashMap<String,Integer>> student : gradeBook.entrySet()) {
            HashMap<String,Integer> subjectMarks = student.getValue();
            int sum = subjectMarks.values().stream().mapToInt(Integer::intValue).sum();
            double avg = (double) sum / subjectMarks.size();
            System.out.printf("  %-10s %8d %10d %10d %8.1f%n",
                    student.getKey(),
                    subjectMarks.get("Math"),
                    subjectMarks.get("Science"),
                    subjectMarks.get("English"),
                    avg);
        }

        // Example 5: Anagram Grouping
        System.out.println("\n--- Anagram Grouping ---");
        String[] wordList = {"eat","tea","tan","ate","nat","bat","listen","silent","enlist"};
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for (String w : wordList) {
            char[] wChars = w.toCharArray();
            Arrays.sort(wChars);
            String key = new String(wChars);
            anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(w);
        }
        System.out.println("Words   : " + Arrays.toString(wordList));
        System.out.println("Anagram groups:");
        anagrams.forEach((k, v) -> System.out.println("  " + v));

        // Example 6: Caching (Memoization) — Fibonacci
        System.out.println("\n--- Memoized Fibonacci (HashMap cache) ---");
        HashMap<Integer, Long> memo = new HashMap<>();
        System.out.printf("  %-6s %s%n", "n", "fibonacci(n)");
        sep();
        for (int i = 0; i <= 15; i++) {
            System.out.printf("  %-6d %d%n", i, fibMemo(i, memo));
        }

        System.out.println("\n############################################");
        System.out.println("#       HashMap in Java — Done! ✔         #");
        System.out.println("############################################");
    }

    // ── Memoized Fibonacci helper ──
    static long fibMemo(int n, HashMap<Integer, Long> memo) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        long result = fibMemo(n-1, memo) + fibMemo(n-2, memo);
        memo.put(n, result);
        return result;
    }
}

// ── Employee class for object HashMap demo ──
class Employee {
    @SuppressWarnings("unused")
    int    id;
    String name;
    String dept;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id     = id;
        this.name   = name;
        this.dept   = dept;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Employee{%s, %s, ₹%.0f}", name, dept, salary);
    }
} 