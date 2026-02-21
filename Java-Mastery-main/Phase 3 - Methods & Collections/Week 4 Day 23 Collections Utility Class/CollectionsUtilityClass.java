/*
 * ============================================================
 *      Collections UTILITY CLASS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS Collections CLASS?
 * ---------------------------
 * Collections (note: plural) is a UTILITY CLASS in java.util
 * package that provides STATIC methods to operate on or return
 * collections. It is different from the Collection interface.
 *
 * Key Difference:
 *  Collection  (singular) → INTERFACE (List, Set, Queue)
 *  Collections (plural)   → UTILITY CLASS (static methods)
 *
 * Found in : java.util.Collections
 * Import   : import java.util.Collections;
 *
 * All methods are STATIC → call directly on class:
 *  Collections.sort(list);
 *  Collections.reverse(list);
 *  Collections.shuffle(list);
 *
 * ============================================================
 * WHY USE Collections CLASS?
 * ============================================================
 *
 *  ✔ Ready-made algorithms (sort, search, shuffle)
 *  ✔ Wrappers for thread safety
 *  ✔ Wrappers for immutability (unmodifiable)
 *  ✔ Factory methods for special collections
 *  ✔ Statistical utilities (min, max, frequency)
 *  ✔ Structural operations (reverse, rotate, swap)
 *  ✔ Works on ANY Collection (List, Set, etc.)
 *
 * ============================================================
 * CATEGORIES OF METHODS
 * ============================================================
 *
 *  1.  SORTING      sort(), reverseOrder()
 *  2.  SEARCHING    binarySearch()
 *  3.  SHUFFLING    shuffle()
 *  4.  REVERSING    reverse()
 *  5.  ROTATING     rotate()
 *  6.  SWAPPING     swap()
 *  7.  FILLING      fill(), nCopies()
 *  8.  COPYING      copy(), addAll()
 *  9.  STATISTICS   min(), max(), frequency(), disjoint()
 *  10. REPLACING    replaceAll()
 *  11. UNMODIFIABLE unmodifiableList/Set/Map/Collection()
 *  12. SYNCHRONIZED synchronizedList/Set/Map/Collection()
 *  13. SINGLETON    singleton(), singletonList(), singletonMap()
 *  14. EMPTY        emptyList(), emptySet(), emptyMap()
 *  15. CHECKED      checkedList(), checkedSet(), checkedMap()
 *
 * ============================================================
 * IMPORTANT CONSTANTS
 * ============================================================
 *
 *  Collections.EMPTY_LIST   → immutable empty List
 *  Collections.EMPTY_SET    → immutable empty Set
 *  Collections.EMPTY_MAP    → immutable empty Map
 *
 * ============================================================
 * KEY RULES
 * ============================================================
 *
 *  1. sort() works only on List (not Set/Map directly)
 *  2. binarySearch() requires LIST to be SORTED first
 *  3. copy() destination list must be >= source size
 *  4. unmodifiable wrappers → UnsupportedOperationException
 *     on any structural modification
 *  5. synchronized wrappers → thread-safe but not for
 *     compound operations (use ConcurrentHashMap instead)
 *  6. nCopies() returns IMMUTABLE list
 *  7. emptyList/Set/Map() return IMMUTABLE empty collections
 *  8. singleton collections contain EXACTLY ONE element
 *
 * ============================================================
 */

import java.util.*;

public class CollectionsUtilityClass {

    // ── helpers ──
    static void sep()  { System.out.println("  " + "─".repeat(52)); }
    static void sep2() { System.out.println("  " + "═".repeat(52)); }
    static void header(String title) {
        System.out.println("\n  ╔══════════════════════════════════════════════╗");
        System.out.printf ("  ║  %-44s║%n", title);
        System.out.println("  ╚══════════════════════════════════════════════╝");
    }
    static void sub(String s) {
        System.out.println("\n  ── " + s + " ──");
    }

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#   Collections UTILITY CLASS IN JAVA      #");
        System.out.println("############################################");

        // ============================================================
        // 1. sort() — SORTING
        // ============================================================
        header("1. sort() — SORTING");

        // sort(List) — natural ascending order
        sub("sort(List) — Natural Ascending");
        List<Integer> intList = new ArrayList<>(
                Arrays.asList(64, 34, 25, 12, 22, 11, 90));
        System.out.println("  Before sort     : " + intList);
        Collections.sort(intList);
        System.out.println("  After  sort     : " + intList);

        // sort Strings
        List<String> strList = new ArrayList<>(
                Arrays.asList("Banana","Apple","Cherry","Avocado","Mango","Date"));
        System.out.println("\n  Before sort     : " + strList);
        Collections.sort(strList);
        System.out.println("  After  sort     : " + strList);

        // sort(List, Comparator) — custom order
        sub("sort(List, Comparator) — Custom Order");

        // Descending order
        List<Integer> desc = new ArrayList<>(
                Arrays.asList(3,1,4,1,5,9,2,6,5,3));
        Collections.sort(desc, Collections.reverseOrder());
        System.out.println("  Descending      : " + desc);

        // Sort Strings by length
        List<String> byLen = new ArrayList<>(
                Arrays.asList("Fig","Banana","Kiwi","Strawberry","Plum","Apple"));
        Collections.sort(byLen, Comparator.comparingInt(String::length));
        System.out.println("  By length (asc) : " + byLen);

        // Sort by length then alphabetically
        List<String> byLenAlpha = new ArrayList<>(byLen);
        Collections.sort(byLenAlpha,
                Comparator.comparingInt(String::length)
                          .thenComparing(Comparator.naturalOrder()));
        System.out.println("  By len+alpha    : " + byLenAlpha);

        // Sort by last character
        List<String> byLast = new ArrayList<>(
                Arrays.asList("Java","Python","C++","Kotlin","Go","Swift"));
        Collections.sort(byLast,
                Comparator.comparingInt(s -> s.charAt(s.length()-1)));
        System.out.println("  By last char    : " + byLast);

        // Sort custom objects
        sub("sort() with Custom Objects");
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Charlie", 30, 65000),
                new Person("Alice",   25, 75000),
                new Person("Bob",     30, 55000),
                new Person("Diana",   25, 80000),
                new Person("Eve",     28, 70000)
        ));

        // Sort by age
        Collections.sort(people, Comparator.comparingInt(p -> p.age));
        System.out.println("  By age:");
        people.forEach(p -> System.out.printf(
                "  %-10s age=%-3d salary=%.0f%n", p.name, p.age, p.salary));

        // Sort by age then salary descending
        people.sort(Comparator.comparingInt((Person p) -> p.age)
                              .thenComparingDouble(p -> -p.salary));
        System.out.println("  By age, then salary desc:");
        people.forEach(p -> System.out.printf(
                "  %-10s age=%-3d salary=%.0f%n", p.name, p.age, p.salary));

        // reverseOrder() Comparator
        sub("reverseOrder() Comparator");
        List<Integer> revOrd = new ArrayList<>(
                Arrays.asList(5,3,8,1,9,2,7,4,6));
        System.out.println("  Before          : " + revOrd);
        Collections.sort(revOrd, Collections.reverseOrder());
        System.out.println("  reverseOrder()  : " + revOrd);

        // Use reverseOrder with PriorityQueue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                Collections.reverseOrder());
        maxHeap.addAll(Arrays.asList(5,3,8,1,9));
        System.out.println("  MaxHeap peek()  : " + maxHeap.peek()); // 9

        // ============================================================
        // 2. binarySearch() — SEARCHING
        // ============================================================
        header("2. binarySearch() — SEARCHING");

        // ⚠ List MUST be sorted before binarySearch!
        List<Integer> sorted = new ArrayList<>(
                Arrays.asList(2,5,8,11,16,23,38,45,56,72,91));
        System.out.println("  Sorted list     : " + sorted);
        sep();

        int[] targets = {23, 56, 2, 91, 99, 38};
        for (int t : targets) {
            int idx = Collections.binarySearch(sorted, t);
            System.out.printf("  binarySearch(%-3d): index=%-3d %s%n",
                    t, idx, idx >= 0 ? "✔ Found" : "✘ Not found");
        }

        // binarySearch with Comparator
        sub("binarySearch(List, key, Comparator)");
        List<String> sortedStr = new ArrayList<>(
                Arrays.asList("Apple","Banana","Cherry","Date","Elderberry"));
        System.out.println("  Sorted list     : " + sortedStr);
        int si1 = Collections.binarySearch(sortedStr, "Cherry",
                Comparator.naturalOrder());
        int si2 = Collections.binarySearch(sortedStr, "Mango",
                Comparator.naturalOrder());
        System.out.println("  search(Cherry)  : " + si1 + " ✔");
        System.out.println("  search(Mango)   : " + si2
                + " (-(insertion point)-1)");

        // Negative return = -(insertion point) - 1
        sub("Understanding Negative Return Values");
        List<Integer> insTest = new ArrayList<>(Arrays.asList(10,20,30,40,50));
        System.out.println("  List            : " + insTest);
        int[] notFound = {5, 15, 25, 35, 45, 55};
        for (int v : notFound) {
            int idx = Collections.binarySearch(insTest, v);
            int ip  = -(idx + 1);   // insertion point
            System.out.printf("  search(%-2d)=%3d  insert at index %d%n", v, idx, ip);
        }

        // ============================================================
        // 3. reverse() — REVERSING
        // ============================================================
        header("3. reverse() — REVERSING");

        List<Integer> revList = new ArrayList<>(
                Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println("  Before reverse  : " + revList);
        Collections.reverse(revList);
        System.out.println("  After  reverse  : " + revList);

        // Reverse string list
        List<String> revStr = new ArrayList<>(
                Arrays.asList("Hello","World","Java","Rocks"));
        Collections.reverse(revStr);
        System.out.println("  Reversed strings: " + revStr);

        // Reverse to get descending without Comparator
        sub("reverse() for Descending Sort");
        List<Integer> descendList = new ArrayList<>(
                Arrays.asList(3,1,4,1,5,9,2,6,5,3,5));
        Collections.sort(descendList);
        System.out.println("  Sorted asc      : " + descendList);
        Collections.reverse(descendList);
        System.out.println("  After reverse   : " + descendList);

        // Reverse subList
        sub("reverse() on subList");
        List<Integer> sub1 = new ArrayList<>(
                Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println("  Before          : " + sub1);
        Collections.reverse(sub1.subList(2, 7));   // reverse index 2-6
        System.out.println("  reverse(2..6)   : " + sub1);

        // ============================================================
        // 4. shuffle() — SHUFFLING
        // ============================================================
        header("4. shuffle() — SHUFFLING");

        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= 10; i++) deck.add(i);
        System.out.println("  Original        : " + deck);
        Collections.shuffle(deck);
        System.out.println("  After shuffle() : " + deck);
        Collections.shuffle(deck);
        System.out.println("  Shuffle again   : " + deck);

        // shuffle with Random seed (reproducible)
        sub("shuffle(List, Random) — Seeded");
        List<Integer> seeded1 = new ArrayList<>(
                Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        List<Integer> seeded2 = new ArrayList<>(
                Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        Collections.shuffle(seeded1, new Random(42));
        Collections.shuffle(seeded2, new Random(42));
        System.out.println("  Seed 42 run 1   : " + seeded1);
        System.out.println("  Seed 42 run 2   : " + seeded2);
        System.out.println("  Same result?    : " + seeded1.equals(seeded2));

        // Card deck shuffle simulation
        sub("Card Deck Shuffle");
        String[] suits  = {"♠","♥","♦","♣"};
        String[] values = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        List<String> cards = new ArrayList<>();
        for (String suit : suits)
            for (String val : values)
                cards.add(val + suit);
        System.out.println("  Deck size       : " + cards.size());
        System.out.println("  Top 5 (before)  : " + cards.subList(0,5));
        Collections.shuffle(cards);
        System.out.println("  Top 5 (after)   : " + cards.subList(0,5));
        System.out.println("  Bottom 5        : " + cards.subList(47,52));

        // ============================================================
        // 5. swap() — SWAPPING ELEMENTS
        // ============================================================
        header("5. swap() — SWAPPING ELEMENTS");

        List<String> swapList = new ArrayList<>(
                Arrays.asList("A","B","C","D","E","F"));
        System.out.println("  Before          : " + swapList);

        Collections.swap(swapList, 0, 5);  // swap first & last
        System.out.println("  swap(0,5)       : " + swapList);

        Collections.swap(swapList, 1, 3);  // swap index 1 & 3
        System.out.println("  swap(1,3)       : " + swapList);

        // swap to sort manually (bubble sort style)
        sub("Manual Bubble Sort using swap()");
        List<Integer> bubbleList = new ArrayList<>(
                Arrays.asList(64,34,25,12,22,11,90));
        System.out.println("  Before          : " + bubbleList);
        int n = bubbleList.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (bubbleList.get(j) > bubbleList.get(j+1))
                    Collections.swap(bubbleList, j, j+1);
        System.out.println("  After bubble    : " + bubbleList);

        // ============================================================
        // 6. rotate() — ROTATING ELEMENTS
        // ============================================================
        header("6. rotate() — ROTATING ELEMENTS");

        List<Integer> rotList = new ArrayList<>(
                Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println("  Original        : " + rotList);

        // Positive distance → rotate RIGHT
        List<Integer> rCopy = new ArrayList<>(rotList);
        Collections.rotate(rCopy, 3);
        System.out.println("  rotate(+3) right: " + rCopy);

        // Negative distance → rotate LEFT
        List<Integer> lCopy = new ArrayList<>(rotList);
        Collections.rotate(lCopy, -3);
        System.out.println("  rotate(-3) left : " + lCopy);

        // rotate by full length = same list
        List<Integer> fullRot = new ArrayList<>(rotList);
        Collections.rotate(fullRot, rotList.size());
        System.out.println("  rotate(size)    : " + fullRot + " (unchanged)");

        // Visualize rotation steps
        sub("Rotation Visualization");
        List<String> rotVis = new ArrayList<>(
                Arrays.asList("A","B","C","D","E"));
        System.out.printf("  %-18s: %s%n", "Original", rotVis);
        for (int d = 1; d <= 5; d++) {
            List<String> tmp = new ArrayList<>(rotVis);
            Collections.rotate(tmp, d);
            System.out.printf("  rotate(%+d)%-9s: %s%n", d, "", tmp);
        }

        // ============================================================
        // 7. fill() — FILLING
        // ============================================================
        header("7. fill() — FILLING");

        List<String> fillList = new ArrayList<>(
                Arrays.asList("A","B","C","D","E","F","G"));
        System.out.println("  Before fill     : " + fillList);
        Collections.fill(fillList, "★");
        System.out.println("  fill(★)         : " + fillList);

        // fill integers
        List<Integer> fillInt = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println("  Before fill     : " + fillInt);
        Collections.fill(fillInt, 0);
        System.out.println("  fill(0)         : " + fillInt);

        // fill portion using subList
        sub("fill() on subList (partial fill)");
        List<Integer> partial = new ArrayList<>(
                Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println("  Before          : " + partial);
        Collections.fill(partial.subList(3, 7), 99);
        System.out.println("  fill(3..6,99)   : " + partial);

        // ============================================================
        // 8. nCopies() — CREATING REPEATED ELEMENTS
        // ============================================================
        header("8. nCopies() — REPEATED ELEMENTS");

        // Create immutable list of N copies
        List<String> copies = Collections.nCopies(5, "Java");
        System.out.println("  nCopies(5,Java) : " + copies);
        System.out.println("  size()          : " + copies.size());
        System.out.println("  immutable?      : yes");

        // Copy to mutable list
        List<String> mutable = new ArrayList<>(Collections.nCopies(5, "Java"));
        mutable.set(2, "Python");
        System.out.println("  mutable copy    : " + mutable);

        // nCopies for initializing board / grid
        sub("nCopies for 2D Grid Initialization");
        int rows = 3, cols = 4;
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            grid.add(new ArrayList<>(Collections.nCopies(cols, 0)));
        }
        System.out.println("  Grid (3×4 zeros):");
        grid.forEach(row -> System.out.println("    " + row));

        // nCopies for padding
        sub("nCopies for String Padding");
        List<String> words = new ArrayList<>(Arrays.asList("Hello","Java"));
        words.addAll(Collections.nCopies(3, ""));  // pad with empty
        System.out.println("  Padded list     : " + words);

        // ============================================================
        // 9. copy() — COPYING LISTS
        // ============================================================
        header("9. copy() — COPYING LISTS");

        List<Integer> source = Arrays.asList(10,20,30,40,50);
        List<Integer> dest   = new ArrayList<>(
                Collections.nCopies(source.size(), 0));   // must be same size or larger
        System.out.println("  Source          : " + source);
        System.out.println("  Dest (before)   : " + dest);
        Collections.copy(dest, source);
        System.out.println("  Dest (after)    : " + dest);

        // copy into larger destination
        sub("copy() into Larger Destination");
        List<Integer> src2  = Arrays.asList(1,2,3);
        List<Integer> dest2 = new ArrayList<>(
                Arrays.asList(10,20,30,40,50));
        System.out.println("  Src             : " + src2);
        System.out.println("  Dest before     : " + dest2);
        Collections.copy(dest2, src2);   // copies only src.size() elements
        System.out.println("  Dest after      : " + dest2);

        // ⚠ copy with dest smaller than source
        sub("⚠ copy() Error — Dest too small");
        try {
            List<Integer> smallDest = new ArrayList<>(Arrays.asList(1,2));
            Collections.copy(smallDest, Arrays.asList(1,2,3,4,5));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  ✘ dest smaller than src → IndexOutOfBoundsException");
        }

        // addAll() — add array elements to collection
        sub("addAll(Collection, elements...)");
        List<String> addTarget = new ArrayList<>(Arrays.asList("A","B","C"));
        System.out.println("  Before addAll   : " + addTarget);
        Collections.addAll(addTarget, "D","E","F","G");
        System.out.println("  After  addAll   : " + addTarget);

        // ============================================================
        // 10. min() & max() — STATISTICS
        // ============================================================
        header("10. min() & max() — STATISTICS");

        List<Integer> statList = new ArrayList<>(
                Arrays.asList(42,17,93,8,56,31,74,25,88,3));
        System.out.println("  List            : " + statList);
        System.out.println("  min()           : " + Collections.min(statList));
        System.out.println("  max()           : " + Collections.max(statList));

        // min/max with Comparator
        sub("min() & max() with Comparator");
        List<String> strStat = new ArrayList<>(
                Arrays.asList("Banana","Fig","Blueberry","Kiwi","Strawberry","Plum"));
        System.out.println("  List            : " + strStat);
        System.out.println("  min(natural)    : " + Collections.min(strStat));
        System.out.println("  max(natural)    : " + Collections.max(strStat));
        System.out.println("  min(by length)  : " + Collections.min(strStat,
                Comparator.comparingInt(String::length)));
        System.out.println("  max(by length)  : " + Collections.max(strStat,
                Comparator.comparingInt(String::length)));

        // min/max of custom objects
        sub("min() & max() with Custom Objects");
        List<Person> pList = new ArrayList<>(Arrays.asList(
                new Person("Alice",25,75000),
                new Person("Bob",30,55000),
                new Person("Charlie",22,90000),
                new Person("Diana",28,68000)
        ));
        Person youngest = Collections.min(pList, Comparator.comparingInt(p->p.age));
        Person richest  = Collections.max(pList, Comparator.comparingDouble(p->p.salary));
        System.out.println("  Youngest        : " + youngest.name + " (age "+youngest.age+")");
        System.out.println("  Highest salary  : " + richest.name + " (₹"+richest.salary+")");

        // ============================================================
        // 11. frequency() — COUNT OCCURRENCES
        // ============================================================
        header("11. frequency() — COUNT OCCURRENCES");

        List<String> freqList = new ArrayList<>(
                Arrays.asList("Java","Python","Java","C++","Java",
                              "Python","Kotlin","Java","Swift","Python"));
        System.out.println("  List            : " + freqList);
        sep();
        Set<String> unique = new LinkedHashSet<>(freqList);
        for (String s : unique) {
            int f = Collections.frequency(freqList, s);
            System.out.printf("  frequency(\"%-8s\"): %d %s%n",
                    s + "\"", f, "█".repeat(f));
        }

        // frequency on numbers
        sub("frequency() with Integers");
        List<Integer> numFreq = new ArrayList<>(
                Arrays.asList(1,2,3,2,1,3,3,2,1,3,4,5,1,2,3));
        System.out.println("  List            : " + numFreq);
        Set<Integer> uNums = new TreeSet<>(numFreq);
        for (int v : uNums) {
            System.out.printf("  frequency(%-2d)   : %d%n",
                    v, Collections.frequency(numFreq, v));
        }

        // ============================================================
        // 12. disjoint() — CHECK NO COMMON ELEMENTS
        // ============================================================
        header("12. disjoint() — NO COMMON ELEMENTS");

        List<Integer> dj1 = Arrays.asList(1,2,3,4,5);
        List<Integer> dj2 = Arrays.asList(6,7,8,9,10);
        List<Integer> dj3 = Arrays.asList(4,5,6,7,8);
        List<Integer> dj4 = Arrays.asList(11,12,13);

        System.out.println("  List1 = " + dj1);
        System.out.println("  List2 = " + dj2);
        System.out.println("  List3 = " + dj3);
        System.out.println("  List4 = " + dj4);
        sep();
        System.out.println("  disjoint(L1,L2) : " + Collections.disjoint(dj1,dj2)
                + "  (no common elements)");
        System.out.println("  disjoint(L1,L3) : " + Collections.disjoint(dj1,dj3)
                + " (shared: 4,5)");
        System.out.println("  disjoint(L1,L4) : " + Collections.disjoint(dj1,dj4)
                + "  (no common elements)");
        System.out.println("  disjoint(L2,L3) : " + Collections.disjoint(dj2,dj3)
                + " (shared: 6,7,8)");

        // disjoint with Sets
        sub("disjoint() with Sets");
        Set<String> setA = new HashSet<>(Set.of("apple","banana","cherry"));
        Set<String> setB = new HashSet<>(Set.of("date","elderberry","fig"));
        Set<String> setC = new HashSet<>(Set.of("cherry","date","grape"));
        System.out.println("  A ∩ B = ∅?      : " + Collections.disjoint(setA,setB)); // true
        System.out.println("  A ∩ C = ∅?      : " + Collections.disjoint(setA,setC)); // false

        // ============================================================
        // 13. replaceAll() — REPLACE ELEMENTS
        // ============================================================
        header("13. replaceAll() — REPLACE ALL ELEMENTS");

        List<String> replList = new ArrayList<>(
                Arrays.asList("hello","world","java","rocks","programming"));
        System.out.println("  Before          : " + replList);

        // Uppercase all - using List.replaceAll() method
        replList.replaceAll(String::toUpperCase);
        System.out.println("  toUpperCase()   : " + replList);

        // Custom transformation - using List.replaceAll()
        replList.replaceAll(s -> "[" + s + "]");
        System.out.println("  Wrap in []      : " + replList);

        // Transform numbers
        sub("List.replaceAll() with Integers");
        List<Integer> replInt = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println("  Before          : " + replInt);
        replInt.replaceAll(x -> x * x);   // square each
        System.out.println("  Square each     : " + replInt);

        replInt.replaceAll(x -> x % 2 == 0 ? x : -x); // negate odds
        System.out.println("  Negate odds     : " + replInt);

        // ============================================================
        // 14. UNMODIFIABLE WRAPPERS
        // ============================================================
        header("14. UNMODIFIABLE WRAPPERS (Read-Only)");

        // unmodifiableList
        sub("unmodifiableList()");
        List<String> mutableList = new ArrayList<>(
                Arrays.asList("Java","Python","C++"));
        List<String> readOnlyList = Collections.unmodifiableList(mutableList);
        System.out.println("  readOnlyList    : " + readOnlyList);
        System.out.println("  get(0)          : " + readOnlyList.get(0)); // OK

        // Modification throws
        try {
            readOnlyList.add("Kotlin");
        } catch (UnsupportedOperationException e) {
            System.out.println("  ✘ add() blocked → UnsupportedOperationException");
        }
        try {
            readOnlyList.remove(0);
        } catch (UnsupportedOperationException e) {
            System.out.println("  ✘ remove() blocked → UnsupportedOperationException");
        }
        try {
            readOnlyList.set(0,"Go");
        } catch (UnsupportedOperationException e) {
            System.out.println("  ✘ set() blocked → UnsupportedOperationException");
        }

        // ⚠ Changes to original affect the view!
        mutableList.add("Kotlin");
        System.out.println("  After mutable.add: readOnly=" + readOnlyList);
        System.out.println("  ⚠ Original changes reflect in unmodifiable view!");

        // unmodifiableSet
        sub("unmodifiableSet()");
        Set<Integer> mutableSet = new HashSet<>(Set.of(1,2,3,4,5));
        Set<Integer> readOnlySet = Collections.unmodifiableSet(mutableSet);
        System.out.println("  readOnlySet     : " + readOnlySet);
        try {
            readOnlySet.add(6);
        } catch (UnsupportedOperationException e) {
            System.out.println("  ✘ add(6) blocked → UnsupportedOperationException");
        }

        // unmodifiableMap
        sub("unmodifiableMap()");
        Map<String,Integer> mutableMap = new HashMap<>();
        mutableMap.put("A",1); mutableMap.put("B",2); mutableMap.put("C",3);
        Map<String,Integer> readOnlyMap = Collections.unmodifiableMap(mutableMap);
        System.out.println("  readOnlyMap     : " + readOnlyMap);
        System.out.println("  get(A)          : " + readOnlyMap.get("A")); // OK
        try {
            readOnlyMap.put("D",4);
        } catch (UnsupportedOperationException e) {
            System.out.println("  ✘ put() blocked → UnsupportedOperationException");
        }

        // ============================================================
        // 15. SYNCHRONIZED WRAPPERS (Thread-Safe)
        // ============================================================
        header("15. SYNCHRONIZED WRAPPERS (Thread-Safe)");

        sub("synchronizedList()");
        List<Integer> syncList = Collections.synchronizedList(
                new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        System.out.println("  syncList        : " + syncList);
        System.out.println("  Thread-safe?    : ✔ Yes (for individual ops)");

        // Thread-safe operations
        syncList.add(6);
        syncList.remove(Integer.valueOf(3));
        System.out.println("  After add/remove: " + syncList);

        // ⚠ Iteration still needs manual sync
        System.out.println("  ⚠ Iteration needs: synchronized(list) block");
        synchronized (syncList) {
            System.out.print("  Synchronized iterate: ");
            for (int v : syncList) System.out.print(v + " ");
            System.out.println();
        }

        sub("synchronizedMap()");
        Map<String,Integer> syncMap = Collections.synchronizedMap(
                new HashMap<>(Map.of("a",1,"b",2,"c",3)));
        syncMap.put("d",4);
        System.out.println("  syncMap         : " + syncMap);
        System.out.println("  Thread-safe?    : ✔ Yes");

        sub("synchronizedSet()");
        Set<String> syncSet = Collections.synchronizedSet(
                new HashSet<>(Set.of("Java","Python","Go")));
        syncSet.add("Kotlin");
        System.out.println("  syncSet         : " + syncSet);

        // ============================================================
        // 16. SINGLETON COLLECTIONS
        // ============================================================
        header("16. SINGLETON COLLECTIONS (Single Element)");

        sub("singleton() — Single Element Set");
        Set<String> singleSet = Collections.singleton("Java");
        System.out.println("  singleton()     : " + singleSet);
        System.out.println("  size()          : " + singleSet.size());
        System.out.println("  contains(Java)  : " + singleSet.contains("Java"));
        try {
            singleSet.add("Python");
        } catch (UnsupportedOperationException e) {
            System.out.println("  ✘ add() blocked → immutable singleton");
        }

        sub("singletonList() — Single Element List");
        List<Integer> singleList = Collections.singletonList(42);
        System.out.println("  singletonList() : " + singleList);
        System.out.println("  get(0)          : " + singleList.get(0));
        try {
            singleList.add(100);
        } catch (UnsupportedOperationException e) {
            System.out.println("  ✘ add() blocked → immutable singletonList");
        }

        sub("singletonMap() — Single Entry Map");
        Map<String,Integer> singleMap = Collections.singletonMap("score", 100);
        System.out.println("  singletonMap()  : " + singleMap);
        System.out.println("  get(score)      : " + singleMap.get("score"));
        try {
            singleMap.put("level", 5);
        } catch (UnsupportedOperationException e) {
            System.out.println("  ✘ put() blocked → immutable singletonMap");
        }

        // ============================================================
        // 17. EMPTY COLLECTIONS
        // ============================================================
        header("17. EMPTY COLLECTIONS (Immutable)");

        sub("emptyList()");
        List<String> emptyL = Collections.emptyList();
        System.out.println("  emptyList()     : " + emptyL);
        System.out.println("  isEmpty()       : " + emptyL.isEmpty());
        System.out.println("  size()          : " + emptyL.size());
        try {
            emptyL.add("item");
        } catch (UnsupportedOperationException e) {
            System.out.println("  ✘ add() blocked → immutable emptyList");
        }

        sub("emptySet()");
        Set<Integer> emptyS = Collections.emptySet();
        System.out.println("  emptySet()      : " + emptyS);
        System.out.println("  contains(1)     : " + emptyS.contains(1));

        sub("emptyMap()");
        Map<String,Integer> emptyM = Collections.emptyMap();
        System.out.println("  emptyMap()      : " + emptyM);
        System.out.println("  get(key)        : " + emptyM.get("key"));

        // Practical use: return empty instead of null
        sub("⚠ Return Empty instead of null (Best Practice)");
        System.out.println("  ✔ return Collections.emptyList() ← never returns null");
        System.out.println("  ✘ return null                    ← causes NullPointerException");

        // ============================================================
        // 18. CHECKED COLLECTIONS
        // ============================================================
        header("18. CHECKED COLLECTIONS (Type-Safe)");

        sub("checkedList() — Runtime Type Checking");
        List<String> rawList = new ArrayList<>();
        List<String> checkedList = Collections.checkedList(rawList, String.class);
        checkedList.add("Java");
        checkedList.add("Python");
        System.out.println("  checkedList     : " + checkedList);

        // Demonstrate type safety - attempting to add wrong type
        try {
            // This would cause compile error in normal code
            // checkedList.add(123);  // Compile error: Integer cannot be converted to String
            System.out.println("  ✔ Type safety prevents adding wrong types at compile time");
        } catch (Exception e) {
            System.out.println("  This demonstrates compile-time type checking");
        }

        sub("checkedMap()");
        Map<String,Integer> rawMap = new HashMap<>();
        Map<String,Integer> checkedMap = Collections.checkedMap(
                rawMap, String.class, Integer.class);
        checkedMap.put("score", 95);
        System.out.println("  checkedMap      : " + checkedMap);

        // ============================================================
        // 19. REAL-WORLD EXAMPLES
        // ============================================================
        header("19. REAL-WORLD EXAMPLES");

        // Example 1: Student Marks Sorter
        System.out.println("  ── Student Marks Sorter ──");
        studentMarksSorter();

        // Example 2: Card Game Dealer
        System.out.println("\n  ── Card Game Dealer ──");
        cardGameDealer();

        // Example 3: Inventory Manager
        System.out.println("\n  ── Inventory Manager ──");
        inventoryManager();

        // Example 4: Leaderboard Manager
        System.out.println("\n  ── Game Leaderboard ──");
        leaderboardManager();

        // Example 5: Read-Only Config System
        System.out.println("\n  ── Read-Only Config System ──");
        configSystem();

        // Example 6: Word Frequency Analyzer
        System.out.println("\n  ── Word Frequency Analyzer ──");
        wordFrequencyAnalyzer();

        System.out.println("\n############################################");
        System.out.println("# Collections Utility — Done! ✔           #");
        System.out.println("############################################");
    }

    // ============================================================
    // REAL-WORLD HELPER METHODS
    // ============================================================

    // Student Marks Sorter
    static void studentMarksSorter() {
        List<Student2> students = new ArrayList<>(Arrays.asList(
                new Student2("Alice",   new int[]{85,92,78,96,88}),
                new Student2("Bob",     new int[]{72,68,74,70,76}),
                new Student2("Charlie", new int[]{95,98,92,97,99}),
                new Student2("Diana",   new int[]{60,55,62,58,65}),
                new Student2("Eve",     new int[]{88,85,90,84,87})
        ));

        // Calculate averages and sort descending
        students.sort(Comparator.comparingDouble((Student2 s) -> s.average()).reversed());

        System.out.printf("  %-4s %-12s %8s %8s%n","Rank","Name","Average","Grade");
        sep();
        for (int i = 0; i < students.size(); i++) {
            Student2 s = students.get(i);
            double avg = s.average();
            String grade = avg>=90?"A+":avg>=80?"A":avg>=70?"B":avg>=60?"C":"D";
            System.out.printf("  #%-3d %-12s %8.1f %8s%n",
                    i+1, s.name, avg, grade);
        }

        // Stats using Collections
        List<Double> avgs = new ArrayList<>();
        for (Student2 s : students) avgs.add(s.average());
        System.out.printf("  Class max avg   : %.1f%n", Collections.max(avgs));
        System.out.printf("  Class min avg   : %.1f%n", Collections.min(avgs));
    }

    // Card Game Dealer
    static void cardGameDealer() {
        // Build deck
        List<String> deck = new ArrayList<>();
        String[] s = {"♠","♥","♦","♣"};
        String[] v = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for (String suit : s)
            for (String val : v)
                deck.add(val+suit);

        System.out.println("  Deck size       : " + deck.size());
        Collections.shuffle(deck);
        System.out.println("  Shuffled! Dealing 5-card hands...");
        System.out.println();

        // Deal to 4 players
        String[] players = {"Alice","Bob","Charlie","Diana"};
        List<List<String>> hands = new ArrayList<>();
        for (int i = 0; i < players.length; i++) hands.add(new ArrayList<>());

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < players.length; j++)
                hands.get(j).add(deck.remove(0));

        for (int i = 0; i < players.length; i++) {
            List<String> hand = hands.get(i);
            Collections.sort(hand);  // sort hand
            System.out.printf("  %-10s: %s%n", players[i], hand);
        }
        System.out.println("  Cards left      : " + deck.size());
    }

    // Inventory Manager
    static void inventoryManager() {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Laptop",    75000, 15),
                new Product("Phone",     25000, 42),
                new Product("Tablet",    35000,  8),
                new Product("Monitor",   18000, 23),
                new Product("Keyboard",   1500, 67),
                new Product("Mouse",       800, 34),
                new Product("Headset",    3000,  5)
        ));

        System.out.printf("  %-12s %10s %6s %12s%n",
                "Product","Price","Stock","Value");
        sep();

        // Sort by value (price × stock) descending
        products.sort(Comparator.comparingDouble(
                (Product p) -> -(p.price * p.stock)));

        double totalValue = 0;
        List<String> lowStock = new ArrayList<>();

        for (Product p : products) {
            double val = p.price * p.stock;
            totalValue += val;
            if (p.stock < 10) lowStock.add(p.name);
            System.out.printf("  %-12s %10.0f %6d %12.0f%n",
                    p.name, p.price, p.stock, val);
        }
        sep();
        System.out.printf("  %-30s %12.0f%n", "Total Inventory Value:", totalValue);

        // Stats
        Product cheapest = Collections.min(products,
                Comparator.comparingDouble(p -> p.price));
        Product mostStock = Collections.max(products,
                Comparator.comparingInt(p -> p.stock));
        System.out.println("  Cheapest        : " + cheapest.name
                + " (₹"+cheapest.price+")");
        System.out.println("  Most stock      : " + mostStock.name
                + " ("+mostStock.stock+" units)");
        System.out.println("  Low stock alert : " + lowStock);
    }

    // Leaderboard Manager
    static void leaderboardManager() {
        List<GamePlayer> players = new ArrayList<>(Arrays.asList(
                new GamePlayer("Alice",   4500, 120),
                new GamePlayer("Bob",     7800,  85),
                new GamePlayer("Charlie", 3200, 150),
                new GamePlayer("Diana",   9100,  95),
                new GamePlayer("Eve",     6500, 110),
                new GamePlayer("Frank",   7800,  90)
        ));

        // Sort by score desc, then by time asc (tiebreaker)
        players.sort(Comparator.comparingInt((GamePlayer p) -> -p.score)
                               .thenComparingInt(p -> p.timeSeconds));

        System.out.printf("  %-5s %-10s %8s %8s%n",
                "Rank","Player","Score","Time(s)");
        sep();
        for (int i = 0; i < players.size(); i++) {
            GamePlayer p = players.get(i);
            String medal = i==0?"🥇":i==1?"🥈":i==2?"🥉":"  ";
            System.out.printf("  %s%-4d %-10s %8d %8d%n",
                    medal, i+1, p.name, p.score, p.timeSeconds);
        }
        List<Integer> scores = new ArrayList<>();
        players.forEach(p -> scores.add(p.score));
        System.out.println("  Top score       : " + Collections.max(scores));
        System.out.println("  Lowest score    : " + Collections.min(scores));
        System.out.println("  Score of Frank  : "
                + Collections.frequency(scores, 7800) + " players tied at 7800");
    }

    // Read-Only Config System
    static void configSystem() {
        // Mutable internal config
        Map<String,String> internalConfig = new HashMap<>();
        internalConfig.put("db.host",     "localhost");
        internalConfig.put("db.port",     "5432");
        internalConfig.put("db.name",     "myapp");
        internalConfig.put("app.version", "2.1.0");
        internalConfig.put("app.env",     "production");
        internalConfig.put("cache.ttl",   "3600");

        // Expose as unmodifiable to external consumers
        Map<String,String> config = Collections.unmodifiableMap(internalConfig);

        System.out.println("  ── Application Config (Read-Only) ──");
        // Sort keys for display
        List<String> keys = new ArrayList<>(config.keySet());
        Collections.sort(keys);
        for (String key : keys)
            System.out.printf("  %-18s = %s%n", key, config.get(key));

        // Attempt to modify (blocked)
        try {
            config.put("db.password","hack");
        } catch (UnsupportedOperationException e) {
            System.out.println("\n  ✘ External modification blocked! Config is safe.");
        }

        // Internal system CAN modify
        internalConfig.put("app.version","2.2.0");
        System.out.println("  Internal update → app.version = "
                + config.get("app.version"));
    }

    // Word Frequency Analyzer
    static void wordFrequencyAnalyzer() {
        String text = "to be or not to be that is the question "
                    + "whether tis nobler in the mind to suffer "
                    + "the slings and arrows of outrageous fortune";

        String[] words = text.split(" ");
        List<String> wordList = Arrays.asList(words);

        System.out.println("  Text words      : " + wordList.size());

        // Count frequency of each unique word
        Set<String> uniqueWords = new TreeSet<>(wordList);
        List<String[]> freqData = new ArrayList<>();
        for (String w : uniqueWords) {
            freqData.add(new String[]{w,
                    String.valueOf(Collections.frequency(wordList, w))});
        }

        // Sort by frequency descending
        freqData.sort((a,b) ->
                Integer.parseInt(b[1]) - Integer.parseInt(a[1]));

        System.out.printf("  %-15s %5s %s%n", "Word", "Count","Bar");
        sep();
        for (String[] entry : freqData) {
            int f = Integer.parseInt(entry[1]);
            System.out.printf("  %-15s %5s %s%n",
                    entry[0], entry[1], "▓".repeat(f * 3));
        }
        System.out.println("  Unique words    : " + uniqueWords.size());

        // Check if two word sets are disjoint
        List<String> set1 = Arrays.asList("to","be","or");
        List<String> set2 = Arrays.asList("xyz","abc","def");
        System.out.println("  [to,be,or] in text? : "
                + !Collections.disjoint(wordList, set1));
        System.out.println("  [xyz,abc,def] in text?: "
                + !Collections.disjoint(wordList, set2));
    }
}

// ── Supporting classes ──
class Person {
    String name; int age; double salary;
    Person(String n, int a, double s) { name=n; age=a; salary=s; }
}

class Student2 {
    String name; int[] marks;
    Student2(String n, int[] m) { name=n; marks=m; }
    double average() {
        int sum=0;
        for(int m:marks) sum+=m;
        return (double)sum/marks.length;
    }
}

class Product {
    String name; double price; int stock;
    Product(String n, double p, int s) { name=n; price=p; stock=s; }
}

class GamePlayer {
    String name; int score; int timeSeconds;
    GamePlayer(String n, int sc, int t) { name=n; score=sc; timeSeconds=t; }
}