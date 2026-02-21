/*
 * ============================================================
 *           HashSet CLASS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS HashSet?
 * -----------------
 * HashSet is a collection that stores UNIQUE elements with
 * NO guaranteed order. It implements the Set interface and
 * is backed internally by a HashMap.
 *
 * Found in: java.util package
 *
 * Real-life analogies:
 *  - A bag of unique lottery tickets (no duplicates)
 *  - A guest list (each person appears only once)
 *  - A set of unique words in a document
 *  - Countries visited (can't visit same country "twice" in set)
 *
 * Key Characteristics:
 *  - Stores UNIQUE elements only (no duplicates)
 *  - NO guaranteed order (not sorted, not insertion order)
 *  - Allows ONE null element
 *  - NOT thread-safe (use Collections.synchronizedSet())
 *  - Backed by HashMap internally
 *  - Average O(1) for add(), remove(), contains()
 *  - Does NOT support index-based access (no get(i))
 *
 * ============================================================
 * INTERNAL WORKING
 * ============================================================
 *
 *  HashSet is backed by a HashMap<E, Object>.
 *  Every element stored as a KEY in the internal HashMap.
 *  A dummy Object (PRESENT) is used as the VALUE.
 *
 *  HashSet<String> set = new HashSet<>();
 *  set.add("Java");
 *  → internally: map.put("Java", PRESENT);
 *
 *  Uniqueness guaranteed by:
 *  1. hashCode() — determines bucket location
 *  2. equals()   — checks if element already exists in bucket
 *
 *  If hashCode() same AND equals() true → DUPLICATE → rejected
 *
 *  Default capacity  = 16
 *  Default loadFactor= 0.75
 *  Resize threshold  = 16 × 0.75 = 12
 *
 * ============================================================
 * Set Implementations in Java
 * ============================================================
 *
 *  Class            Order           Null    Performance
 *  -------------    -----------     -----   -----------
 *  HashSet          None            1 null  O(1) avg
 *  LinkedHashSet    Insertion order 1 null  O(1) avg
 *  TreeSet          Sorted (ASC)    No null O(log n)
 *  EnumSet          Enum order      No null O(1) very fast
 *  CopyOnWriteArraySet Insertion    1 null  O(n) write
 *
 * ============================================================
 * IMPORT REQUIRED
 * ============================================================
 *
 *  import java.util.HashSet;
 *  import java.util.Set;
 *  import java.util.LinkedHashSet;
 *  import java.util.TreeSet;
 *  import java.util.Collections;
 *  import java.util.Iterator;
 *
 * ============================================================
 * WAYS TO CREATE HashSet
 * ============================================================
 *
 *  1. Empty HashSet:
 *     HashSet<String> set = new HashSet<>();
 *
 *  2. With initial capacity:
 *     HashSet<Integer> set = new HashSet<>(50);
 *
 *  3. With capacity + loadFactor:
 *     HashSet<String> set = new HashSet<>(50, 0.9f);
 *
 *  4. From a Collection:
 *     HashSet<String> set = new HashSet<>(list);
 *
 *  5. From Set.of() (Java 9+):
 *     HashSet<String> set = new HashSet<>(Set.of("a","b","c"));
 *
 * ============================================================
 * ALL HashSet METHODS
 * ============================================================
 *
 *  ADDING:
 *  --------
 *  add(element)           → add element (false if duplicate)
 *  addAll(collection)     → add all elements from collection
 *
 *  REMOVING:
 *  ----------
 *  remove(element)        → remove specific element
 *  removeAll(collection)  → remove all matching elements
 *  removeIf(predicate)    → remove elements matching condition
 *  retainAll(collection)  → keep only matching elements
 *  clear()                → remove ALL elements
 *
 *  CHECKING:
 *  ----------
 *  contains(element)      → true if element exists
 *  containsAll(collection)→ true if all elements exist
 *  isEmpty()              → true if set is empty
 *  size()                 → number of elements
 *
 *  CONVERTING:
 *  ------------
 *  toArray()              → convert to Object[]
 *  toArray(T[])           → convert to typed array
 *  toString()             → string representation
 *  iterator()             → returns Iterator
 *
 *  SET OPERATIONS:
 *  ---------------
 *  addAll(set2)           → UNION      (A ∪ B)
 *  retainAll(set2)        → INTERSECTION (A ∩ B)
 *  removeAll(set2)        → DIFFERENCE  (A - B)
 *
 * ============================================================
 * SET THEORY OPERATIONS
 * ============================================================
 *
 *  A = {1, 2, 3, 4, 5}
 *  B = {3, 4, 5, 6, 7}
 *
 *  Union        A ∪ B = {1,2,3,4,5,6,7}   → addAll()
 *  Intersection A ∩ B = {3,4,5}            → retainAll()
 *  Difference   A - B = {1,2}              → removeAll()
 *  Difference   B - A = {6,7}              → removeAll()
 *  Subset       A ⊆ B → false              → containsAll()
 *
 * ============================================================
 * IMPORTANT NOTES
 * ============================================================
 *
 *  1. add() returns boolean: true=added, false=duplicate
 *  2. No get(index) method — not index-based
 *  3. Iteration order is NOT guaranteed in HashSet
 *  4. For sorted order → use TreeSet
 *  5. For insertion order → use LinkedHashSet
 *  6. Custom objects need hashCode() + equals() override
 *  7. Never modify an element's hashCode-relevant fields
 *     while it's stored in a HashSet
 *
 * ============================================================
 */

import java.util.*;

public class HashSetClass {

    // ── separator helper ──
    static void sep() { System.out.println("  " + "-".repeat(48)); }

    // ── print set nicely ──
    static <T> void printSet(String label, Set<T> set) {
        System.out.printf("  %-22s : %s  (size=%d)%n", label, set, set.size());
    }

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#          HashSet CLASS IN JAVA           #");
        System.out.println("############################################");

        // ============================================================
        // 1. CREATING HashSet
        // ============================================================
        System.out.println("\n===== 1. CREATING HashSet =====");

        // Empty HashSet
        HashSet<String> set1 = new HashSet<>();
        System.out.println("Empty set           : " + set1);
        System.out.println("Size                : " + set1.size());
        System.out.println("isEmpty()           : " + set1.isEmpty());

        // With initial capacity
        HashSet<Integer> set2 = new HashSet<>(50);
        System.out.println("With capacity(50)   : " + set2);

        // With capacity + load factor
        HashSet<String> set3 = new HashSet<>(32, 0.9f);
        System.out.println("cap=32, lf=0.9      : " + set3);

        // From Set.of() — Java 9+
        HashSet<String> set4 = new HashSet<>(
                Set.of("Java", "Python", "C++", "Kotlin", "Swift"));
        System.out.println("From Set.of()       : " + set4);

        // From a List (removes duplicates)
        List<Integer> listWithDups = Arrays.asList(1,2,3,2,4,3,5,1,6);
        HashSet<Integer> set5 = new HashSet<>(listWithDups);
        System.out.println("List (with dups)    : " + listWithDups);
        System.out.println("HashSet (unique)    : " + set5);

        // From another Set
        HashSet<String> set6 = new HashSet<>(set4);
        System.out.println("From another set    : " + set6);

        // Different data types
        HashSet<Integer>   intSet  = new HashSet<>();
        HashSet<Double>    dblSet  = new HashSet<>();
        HashSet<Character> chrSet  = new HashSet<>();

        Collections.addAll(intSet, 10, 20, 30, 40, 50);
        Collections.addAll(dblSet, 1.1, 2.2, 3.3, 4.4);
        Collections.addAll(chrSet, 'J','A','V','A','P','R','O');

        System.out.println("HashSet<Integer>    : " + intSet);
        System.out.println("HashSet<Double>     : " + dblSet);
        System.out.println("HashSet<Character>  : " + chrSet);  // no duplicate 'A'

        // ============================================================
        // 2. add() — ADDING ELEMENTS
        // ============================================================
        System.out.println("\n===== 2. add() — ADDING ELEMENTS =====");

        HashSet<String> fruits = new HashSet<>();

        // add() returns boolean
        System.out.println("--- add() return values ---");
        System.out.println("add(Apple)          : " + fruits.add("Apple"));    // true
        System.out.println("add(Banana)         : " + fruits.add("Banana"));   // true
        System.out.println("add(Cherry)         : " + fruits.add("Cherry"));   // true
        System.out.println("add(Apple) again    : " + fruits.add("Apple"));    // false (dup!)
        System.out.println("add(Mango)          : " + fruits.add("Mango"));    // true
        System.out.println("add(null)           : " + fruits.add(null));       // true
        System.out.println("add(null) again     : " + fruits.add(null));       // false (dup!)
        System.out.println("\nSet after adds      : " + fruits);
        System.out.println("Size                : " + fruits.size());

        // addAll()
        fruits.remove(null);  // clean up null
        List<String> moreFruits = Arrays.asList("Grape","Kiwi","Apple","Lemon","Banana");
        System.out.println("\nBefore addAll       : " + fruits);
        System.out.println("Adding list         : " + moreFruits);
        boolean changed = fruits.addAll(moreFruits);
        System.out.println("After  addAll       : " + fruits);
        System.out.println("Set changed?        : " + changed); // true (new elements added)

        // Demonstrate uniqueness clearly
        System.out.println("\n--- Uniqueness Demonstration ---");
        HashSet<Integer> numSet = new HashSet<>();
        int[] numArr = {5, 3, 8, 3, 1, 8, 5, 9, 2, 1, 7};
        System.out.print("Adding  : ");
        for (int n : numArr) {
            boolean added = numSet.add(n);
            System.out.print(n + (added ? "✔ " : "✘ "));
        }
        System.out.println("\nResult  : " + numSet);

        // ============================================================
        // 3. remove() — REMOVING ELEMENTS
        // ============================================================
        System.out.println("\n===== 3. remove() — REMOVING ELEMENTS =====");

        HashSet<String> langs = new HashSet<>(
                Set.of("Java","Python","C++","JavaScript","Kotlin","Swift","Go"));
        System.out.println("Original            : " + langs);

        // remove(element) — returns boolean
        System.out.println("\nremove(Java)        : " + langs.remove("Java"));    // true
        System.out.println("remove(Ruby)        : " + langs.remove("Ruby"));    // false
        System.out.println("After removes       : " + langs);

        // removeAll() — remove multiple elements
        Set<String> toRemove = new HashSet<>(Set.of("C++","Go"));
        langs.removeAll(toRemove);
        System.out.println("removeAll(C++,Go)   : " + langs);

        // removeIf() — condition-based removal
        HashSet<Integer> evens = new HashSet<>(
                Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println("\nBefore removeIf     : " + evens);
        evens.removeIf(n -> n % 2 == 0);
        System.out.println("removeIf(even)      : " + evens);

        // retainAll() — keep only matching elements
        HashSet<Integer> setA = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8));
        HashSet<Integer> setB = new HashSet<>(Arrays.asList(4,5,6,7,8,9,10));
        System.out.println("\nBefore retainAll    : " + setA);
        System.out.println("Retain set          : " + setB);
        setA.retainAll(setB);
        System.out.println("After  retainAll    : " + setA);  // intersection

        // clear()
        HashSet<String> temp = new HashSet<>(Set.of("a","b","c"));
        System.out.println("\nBefore clear()      : " + temp);
        temp.clear();
        System.out.println("After  clear()      : " + temp + " isEmpty=" + temp.isEmpty());

        // ============================================================
        // 4. contains() & containsAll()
        // ============================================================
        System.out.println("\n===== 4. contains() & containsAll() =====");

        HashSet<String> countries = new HashSet<>(
                Set.of("India","USA","UK","France","Germany","Japan","China"));
        System.out.println("Countries           : " + countries);

        // contains()
        System.out.println("\ncontains(India)     : " + countries.contains("India"));    // true
        System.out.println("contains(Australia) : " + countries.contains("Australia")); // false
        System.out.println("contains(null)      : " + countries.contains(null));        // false

        // containsAll()
        Set<String> group1 = new HashSet<>(Set.of("India","USA","UK"));
        Set<String> group2 = new HashSet<>(Set.of("India","Brazil"));
        System.out.println("\ncontainsAll(India,USA,UK)   : "
                + countries.containsAll(group1));  // true
        System.out.println("containsAll(India,Brazil)   : "
                + countries.containsAll(group2));  // false

        // Practical: check multiple items
        System.out.println("\n--- Check list of items ---");
        String[] searchItems = {"India","Australia","Japan","Brazil","China"};
        for (String c : searchItems) {
            System.out.printf("  %-12s → %s%n", c,
                    countries.contains(c) ? "✔ Found" : "✘ Not found");
        }

        // ============================================================
        // 5. SET OPERATIONS — Union, Intersection, Difference
        // ============================================================
        System.out.println("\n===== 5. SET OPERATIONS =====");

        HashSet<Integer> A = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Integer> B = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));

        System.out.println("Set A               : " + new TreeSet<>(A));
        System.out.println("Set B               : " + new TreeSet<>(B));

        // UNION — A ∪ B (all elements from both)
        HashSet<Integer> union = new HashSet<>(A);
        union.addAll(B);
        printSet("A ∪ B (Union)",       new TreeSet<>(union));

        // INTERSECTION — A ∩ B (common elements)
        HashSet<Integer> intersection = new HashSet<>(A);
        intersection.retainAll(B);
        printSet("A ∩ B (Intersection)", new TreeSet<>(intersection));

        // DIFFERENCE — A - B (in A but not in B)
        HashSet<Integer> diffAB = new HashSet<>(A);
        diffAB.removeAll(B);
        printSet("A - B (Difference)",   new TreeSet<>(diffAB));

        // DIFFERENCE — B - A (in B but not in A)
        HashSet<Integer> diffBA = new HashSet<>(B);
        diffBA.removeAll(A);
        printSet("B - A (Difference)",   new TreeSet<>(diffBA));

        // SYMMETRIC DIFFERENCE — (A ∪ B) - (A ∩ B)
        HashSet<Integer> symDiff = new HashSet<>(union);
        symDiff.removeAll(intersection);
        printSet("A △ B (Sym.Diff)",     new TreeSet<>(symDiff));

        // SUBSET CHECK — A ⊆ B?
        System.out.println("  A ⊆ B (A subset of B)   : " + B.containsAll(A));
        HashSet<Integer> C = new HashSet<>(Arrays.asList(3,4,5));
        System.out.println("  C ⊆ A (C={3,4,5} ⊆ A)  : " + A.containsAll(C));

        // DISJOINT — no common elements?
        HashSet<Integer> D = new HashSet<>(Arrays.asList(8,9,10));
        System.out.println("  A disjoint B            : "
                + Collections.disjoint(A, B));  // false (shared 3,4,5)
        System.out.println("  A disjoint D            : "
                + Collections.disjoint(A, D));  // true  (nothing shared)

        // ============================================================
        // 6. ITERATION METHODS
        // ============================================================
        System.out.println("\n===== 6. ITERATION METHODS =====");

        HashSet<String> colors = new HashSet<>(
                Set.of("Red","Green","Blue","Yellow","Purple","Orange"));
        System.out.println("Set                 : " + colors);

        // Method 1: for-each
        System.out.print("for-each            : ");
        for (String c : colors) System.out.print(c + " ");
        System.out.println();

        // Method 2: forEach with lambda
        System.out.print("forEach(lambda)     : ");
        colors.forEach(c -> System.out.print(c + " "));
        System.out.println();

        // Method 3: Iterator
        System.out.print("Iterator            : ");
        Iterator<String> it = colors.iterator();
        while (it.hasNext()) System.out.print(it.next() + " ");
        System.out.println();

        // Method 4: Stream
        System.out.print("stream()            : ");
        colors.stream().sorted().forEach(c -> System.out.print(c + " "));
        System.out.println();

        // Safe removal during iteration
        System.out.println("\n--- Safe Removal with Iterator ---");
        HashSet<Integer> iterSet = new HashSet<>(
                Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println("Before              : " + new TreeSet<>(iterSet));
        Iterator<Integer> safeIt = iterSet.iterator();
        while (safeIt.hasNext()) {
            int val = safeIt.next();
            if (val % 2 == 0) safeIt.remove();  // safe!
        }
        System.out.println("After remove evens  : " + new TreeSet<>(iterSet));

        // ============================================================
        // 7. CONVERSION METHODS
        // ============================================================
        System.out.println("\n===== 7. CONVERSION METHODS =====");

        HashSet<String> techSet = new HashSet<>(
                Set.of("Java","Python","C++","Kotlin","Swift"));

        // Set → Array
        Object[] objArr = techSet.toArray();
        System.out.println("toArray()           : " + Arrays.toString(objArr));

        @SuppressWarnings("CollectionsToArray")
        String[] strArr = techSet.toArray(new String[0]);
        Arrays.sort(strArr);
        System.out.println("toArray(String[])   : " + Arrays.toString(strArr));

        // Set → List
        List<String> toList = new ArrayList<>(techSet);
        Collections.sort(toList);
        System.out.println("Set → ArrayList     : " + toList);

        // List → Set (remove duplicates)
        List<String> dupList = Arrays.asList(
                "Java","Python","Java","C++","Python","Kotlin");
        Set<String> fromList = new HashSet<>(dupList);
        System.out.println("List (with dups)    : " + dupList);
        System.out.println("Set  (no dups)      : " + fromList);

        // Array → Set
        String[] langArr = {"Go","Rust","Scala","Go","Rust"};
        Set<String> fromArr = new HashSet<>(Arrays.asList(langArr));
        System.out.println("Array (with dups)   : " + Arrays.toString(langArr));
        System.out.println("Set   (no dups)     : " + fromArr);

        // toString()
        System.out.println("toString()          : " + techSet.toString());

        // ============================================================
        // 8. LinkedHashSet — INSERTION ORDER
        // ============================================================
        System.out.println("\n===== 8. LinkedHashSet (Insertion Order) =====");

        LinkedHashSet<String> linked = new LinkedHashSet<>();
        linked.add("Banana");
        linked.add("Apple");
        linked.add("Cherry");
        linked.add("Mango");
        linked.add("Apple");      // duplicate — ignored
        linked.add("Date");
        linked.add("Cherry");     // duplicate — ignored

        System.out.println("LinkedHashSet       : " + linked);
        System.out.println("Insertion order     : ✔ Preserved");
        System.out.println("Duplicates          : ✘ Rejected");
        System.out.println("Size                : " + linked.size());

        // Compare: HashSet vs LinkedHashSet
        System.out.println("\n--- HashSet vs LinkedHashSet ---");
        String[] insertOrder = {"Mango","Apple","Cherry","Banana","Date"};
        HashSet<String>       hashS   = new HashSet<>(Arrays.asList(insertOrder));
        LinkedHashSet<String> linkedS = new LinkedHashSet<>(Arrays.asList(insertOrder));

        System.out.println("Inserted order      : " + Arrays.toString(insertOrder));
        System.out.println("HashSet             : " + hashS    + " (no order)");
        System.out.println("LinkedHashSet       : " + linkedS  + " (insertion order)");

        // ============================================================
        // 9. TreeSet — SORTED ORDER
        // ============================================================
        System.out.println("\n===== 9. TreeSet (Sorted Order) =====");

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(50); treeSet.add(10); treeSet.add(80);
        treeSet.add(30); treeSet.add(70); treeSet.add(20);
        treeSet.add(60); treeSet.add(40);

        System.out.println("TreeSet (natural)   : " + treeSet);

        // TreeSet specific methods
        System.out.println("first()             : " + treeSet.first());
        System.out.println("last()              : " + treeSet.last());
        System.out.println("floor(45)           : " + treeSet.floor(45));   // ≤ 45
        System.out.println("ceiling(45)         : " + treeSet.ceiling(45)); // ≥ 45
        System.out.println("lower(50)           : " + treeSet.lower(50));   // < 50
        System.out.println("higher(50)          : " + treeSet.higher(50));  // > 50
        System.out.println("headSet(50)         : " + treeSet.headSet(50)); // < 50
        System.out.println("tailSet(50)         : " + treeSet.tailSet(50)); // ≥ 50
        System.out.println("subSet(20,60)       : " + treeSet.subSet(20,60)); // [20,60)
        System.out.println("pollFirst()         : " + treeSet.pollFirst());  // remove & return first
        System.out.println("pollLast()          : " + treeSet.pollLast());   // remove & return last
        System.out.println("After polls         : " + treeSet);

        // TreeSet with Strings (alphabetical)
        TreeSet<String> strTree = new TreeSet<>(
                Set.of("Banana","Apple","Cherry","Avocado","Blueberry","Coconut"));
        System.out.println("\nString TreeSet      : " + strTree);
        System.out.println("headSet(Blueberry)  : " + strTree.headSet("Blueberry"));

        // TreeSet with custom comparator (descending)
        TreeSet<Integer> descTree = new TreeSet<>(Collections.reverseOrder());
        Collections.addAll(descTree, 5, 3, 8, 1, 9, 2, 7, 4, 6);
        System.out.println("TreeSet (desc)      : " + descTree);

        // ============================================================
        // 10. HashSet with CUSTOM OBJECTS
        // ============================================================
        System.out.println("\n===== 10. HashSet WITH CUSTOM OBJECTS =====");

        HashSet<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Clean Code",        "Robert Martin",  2008));
        bookSet.add(new Book("Effective Java",    "Joshua Bloch",   2018));
        bookSet.add(new Book("Design Patterns",   "Gang of Four",   1994));
        bookSet.add(new Book("Clean Code",        "Robert Martin",  2008)); // duplicate!
        bookSet.add(new Book("The Pragmatic Prog","Andy Hunt",      1999));
        bookSet.add(new Book("Effective Java",    "Joshua Bloch",   2018)); // duplicate!

        System.out.println("Books in set (unique):");
        System.out.printf("  %-28s %-18s %s%n", "Title", "Author", "Year");
        sep();
        bookSet.stream()
               .sorted(Comparator.comparing(b -> b.title))
               .forEach(b -> System.out.printf("  %-28s %-18s %d%n",
                       b.title, b.author, b.year));
        System.out.println("Size (duplicates removed): " + bookSet.size());

        // Checking membership
        Book search1 = new Book("Clean Code", "Robert Martin", 2008);
        Book search2 = new Book("Java Basics", "Unknown", 2020);
        System.out.println("\ncontains(Clean Code)  : " + bookSet.contains(search1)); // true
        System.out.println("contains(Java Basics) : " + bookSet.contains(search2)); // false

        // ============================================================
        // 11. REAL-WORLD EXAMPLES
        // ============================================================
        System.out.println("\n===== 11. REAL-WORLD EXAMPLES =====");

        // Example 1: Remove Duplicates from List
        System.out.println("--- Remove Duplicates ---");
        int[][] testCases = {
            {1,2,3,2,4,3,5,1,6},
            {10,20,10,30,20,40,50,30},
            {7,7,7,7,7}
        };
        for (int[] tc : testCases) {
            List<Integer> original = new ArrayList<>();
            for (int x : tc) original.add(x);
            Set<Integer> unique = new LinkedHashSet<>(original);
            System.out.printf("  Original : %-30s → Unique: %s%n",
                    original, new ArrayList<>(unique));
        }

        // Example 2: Common Elements in Two Lists
        System.out.println("\n--- Common Elements (Intersection) ---");
        List<String> list1 = Arrays.asList("Alice","Bob","Charlie","Diana","Eve");
        List<String> list2 = Arrays.asList("Bob","Diana","Frank","Grace","Alice");
        Set<String> setL1 = new HashSet<>(list1);
        Set<String> setL2 = new HashSet<>(list2);

        Set<String> common = new HashSet<>(setL1);
        common.retainAll(setL2);

        Set<String> onlyL1 = new HashSet<>(setL1);
        onlyL1.removeAll(setL2);

        Set<String> onlyL2 = new HashSet<>(setL2);
        onlyL2.removeAll(setL1);

        System.out.println("List 1              : " + list1);
        System.out.println("List 2              : " + list2);
        System.out.println("Common (∩)          : " + common);
        System.out.println("Only in List1       : " + onlyL1);
        System.out.println("Only in List2       : " + onlyL2);

        // Example 3: Unique Words Counter
        System.out.println("\n--- Unique Words in Text ---");
        String paragraph = "to be or not to be that is the question "
                         + "whether tis nobler in the mind to suffer";
        String[] allWords = paragraph.split(" ");
        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(allWords));

        System.out.println("Text               : \"" + paragraph + "\"");
        System.out.println("Total words        : " + allWords.length);
        System.out.println("Unique words       : " + uniqueWords.size());
        System.out.println("Unique word list   : " + new TreeSet<>(uniqueWords));

        // Repeated words
        System.out.print("Repeated words     : ");
        HashMap<String,Integer> wFreq = new HashMap<>();
        for (String w : allWords) wFreq.merge(w, 1, Integer::sum);
        wFreq.entrySet().stream()
             .filter(e -> e.getValue() > 1)
             .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
             .forEach(e -> System.out.print(e.getKey()+"("+e.getValue()+") "));
        System.out.println();

        // Example 4: Login Session Tracker
        System.out.println("\n--- Active User Sessions ---");
        HashSet<String> activeSessions = new HashSet<>();

        // Simulate logins
        String[] loginEvents = {
            "alice","bob","charlie","alice","diana",
            "bob","eve","charlie","alice"
        };
        System.out.println("Login events       : " + Arrays.toString(loginEvents));
        for (String user : loginEvents) {
            if (activeSessions.add(user))
                System.out.println("  ✔ " + user + " logged in (new session)");
            else
                System.out.println("  ℹ " + user + " already has active session");
        }
        System.out.println("Active sessions    : " + activeSessions);
        System.out.println("Active count       : " + activeSessions.size());

        // Simulate logouts
        activeSessions.remove("bob");
        activeSessions.remove("charlie");
        System.out.println("After logouts      : " + activeSessions);

        // Example 5: Spell Checker (Dictionary)
        System.out.println("\n--- Spell Checker ---");
        HashSet<String> dictionary = new HashSet<>(Arrays.asList(
            "hello","world","java","programming","is","fun",
            "the","quick","brown","fox","jumps","over","lazy","dog"
        ));
        String[] checkWords = {
            "hello","wrold","java","progaming","is","funn","the","quik"
        };
        System.out.printf("  %-15s %s%n", "Word", "Status");
        sep();
        int correct = 0, misspelled = 0;
        for (String w : checkWords) {
            boolean ok = dictionary.contains(w.toLowerCase());
            System.out.printf("  %-15s %s%n", w,
                    ok ? "✔ Correct" : "✘ Misspelled");
            if (ok) correct++; else misspelled++;
        }
        sep();
        System.out.printf("  Correct: %d  Misspelled: %d%n", correct, misspelled);

        // Example 6: Graph — Connected Nodes (Visited tracking)
        System.out.println("\n--- BFS Visited Nodes Tracker ---");
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2,3));
        graph.put(2, Arrays.asList(1,4,5));
        graph.put(3, Arrays.asList(1,6));
        graph.put(4, Arrays.asList(2));
        graph.put(5, Arrays.asList(2,6));
        graph.put(6, Arrays.asList(3,5));

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer>   queue   = new LinkedList<>();
        int startNode = 1;
        queue.add(startNode);
        visited.add(startNode);

        System.out.print("BFS from node " + startNode + "   : ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
        System.out.println("Visited nodes      : " + new TreeSet<>(visited));
        System.out.println("All nodes visited? : " + (visited.size() == graph.size()));

        // Example 7: Product Tag System
        System.out.println("\n--- Product Tag System ---");
        HashMap<String, HashSet<String>> productTags = new HashMap<>();
        productTags.put("Laptop",  new HashSet<>(Set.of("electronics","computer","portable","work")));
        productTags.put("Phone",   new HashSet<>(Set.of("electronics","mobile","portable","camera")));
        productTags.put("Tablet",  new HashSet<>(Set.of("electronics","computer","portable","camera")));
        productTags.put("Desktop", new HashSet<>(Set.of("electronics","computer","work","gaming")));

        // Find products with "portable" tag
        System.out.println("Products tagged 'portable':");
        productTags.forEach((product, tags) -> {
            if (tags.contains("portable"))
                System.out.println("  → " + product + " " + tags);
        });

        // Common tags between Laptop and Phone
        HashSet<String> laptopTags = productTags.get("Laptop");
        HashSet<String> phoneTags  = productTags.get("Phone");
        HashSet<String> commonTags = new HashSet<>(laptopTags);
        commonTags.retainAll(phoneTags);
        System.out.println("Common tags (Laptop∩Phone): " + commonTags);

        System.out.println("\n############################################");
        System.out.println("#       HashSet in Java — Done! ✔         #");
        System.out.println("############################################");
    }
}

// ── Book class with hashCode & equals for HashSet demo ──
class Book {
    String title;
    String author;
    int    year;

    Book(String title, String author, int year) {
        this.title  = title;
        this.author = author;
        this.year   = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return year == b.year
                && title.equals(b.title)
                && author.equals(b.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return String.format("\"%s\" by %s (%d)", title, author, year);
    }
}