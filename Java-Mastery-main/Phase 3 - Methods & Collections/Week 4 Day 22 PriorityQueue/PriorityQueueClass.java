/*
 * ============================================================
 *        PriorityQueue CLASS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS PriorityQueue?
 * -----------------------
 * PriorityQueue is a special type of Queue where elements are
 * served based on their PRIORITY rather than insertion order.
 * The element with the HIGHEST PRIORITY is always at the front.
 *
 * Found in: java.util package
 * Implements: Queue interface
 *
 * Real-life analogies:
 *  - Hospital emergency room → critical patients treated first
 *  - Airport boarding → business class before economy
 *  - CPU scheduling → high-priority process runs first
 *  - Call center → VIP customers served before regular
 *  - News feed → most relevant articles shown first
 *
 * Key Characteristics:
 *  - Elements served by PRIORITY (not insertion order)
 *  - Default: MIN-HEAP (smallest element = highest priority)
 *  - Backed by a BINARY HEAP data structure
 *  - Does NOT allow NULL elements
 *  - NOT thread-safe (use PriorityBlockingQueue for threads)
 *  - Unbounded (grows automatically)
 *  - NOT sorted internally — only peek/poll gives min
 *  - Allows duplicate values
 *  - Elements must be Comparable OR provide a Comparator
 *
 * ============================================================
 * INTERNAL WORKING — BINARY HEAP
 * ============================================================
 *
 *  PriorityQueue uses a BINARY MIN-HEAP internally.
 *  Stored as an array where:
 *    - Parent at index i
 *    - Left child  at 2*i + 1
 *    - Right child at 2*i + 2
 *
 *  Min-Heap property: Parent ≤ both children
 *
 *  Example: PQ with [10, 20, 15, 30, 40, 25]
 *
 *  Heap tree:
 *           10          ← always minimum at root
 *          /  \
 *        20    15
 *       /  \  /
 *      30  40 25
 *
 *  Array: [10, 20, 15, 30, 40, 25]
 *
 *  Operations:
 *  offer(e) → add to end, sift UP   → O(log n)
 *  poll()   → remove root, sift DOWN → O(log n)
 *  peek()   → return root (min)      → O(1)
 *
 * ============================================================
 * HEAP TYPES
 * ============================================================
 *
 *  MIN-HEAP (default):
 *  - Smallest element at top
 *  - new PriorityQueue<>()
 *  - Use case: find minimum, shortest path
 *
 *  MAX-HEAP:
 *  - Largest element at top
 *  - new PriorityQueue<>(Collections.reverseOrder())
 *  - Use case: find maximum, top-K elements
 *
 * ============================================================
 * WAYS TO CREATE PriorityQueue
 * ============================================================
 *
 *  1. Default (Min-Heap, capacity 11):
 *     PriorityQueue<Integer> pq = new PriorityQueue<>();
 *
 *  2. With initial capacity:
 *     PriorityQueue<Integer> pq = new PriorityQueue<>(50);
 *
 *  3. Max-Heap:
 *     PriorityQueue<Integer> pq =
 *         new PriorityQueue<>(Collections.reverseOrder());
 *
 *  4. With custom Comparator:
 *     PriorityQueue<String> pq =
 *         new PriorityQueue<>((a,b) -> a.length()-b.length());
 *
 *  5. From Collection:
 *     PriorityQueue<Integer> pq = new PriorityQueue<>(list);
 *
 *  6. Copy constructor:
 *     PriorityQueue<Integer> pq2 = new PriorityQueue<>(pq1);
 *
 * ============================================================
 * ALL PriorityQueue METHODS
 * ============================================================
 *
 *  ADDING:
 *  --------
 *  offer(e)      → insert element (returns false if fails)
 *  add(e)        → insert element (throws if fails)
 *
 *  REMOVING:
 *  ----------
 *  poll()        → remove & return HIGHEST PRIORITY (null if empty)
 *  remove()      → remove & return HIGHEST PRIORITY (throws if empty)
 *  remove(Object)→ remove specific element (O(n))
 *  clear()       → remove ALL elements
 *
 *  PEEKING:
 *  ---------
 *  peek()        → return HIGHEST PRIORITY without removing (null if empty)
 *  element()     → return HIGHEST PRIORITY without removing (throws if empty)
 *
 *  CHECKING:
 *  ----------
 *  contains(e)   → true if element exists (O(n))
 *  isEmpty()     → true if no elements
 *  size()        → number of elements
 *
 *  CONVERTING:
 *  ------------
 *  toArray()     → Object[] (NOT sorted order)
 *  toArray(T[])  → typed array (NOT sorted order)
 *  iterator()    → Iterator (NOT guaranteed order)
 *  comparator()  → returns the Comparator (null for natural)
 *
 * ============================================================
 * IMPORTANT NOTES
 * ============================================================
 *
 *  1. toArray() does NOT give sorted order
 *     → Must poll() repeatedly to get sorted order
 *
 *  2. Iteration order is NOT guaranteed
 *     → for-each may not be in priority order
 *
 *  3. contains() and remove(Object) are O(n) — no index
 *
 *  4. PriorityQueue does NOT allow null
 *     → NullPointerException on add(null)
 *
 *  5. For thread safety → use PriorityBlockingQueue
 *
 *  6. For sorted order output → use TreeSet or sort()
 *
 * ============================================================
 * PriorityQueue vs Other Data Structures
 * ============================================================
 *
 *  Structure      Order          Access     Use When
 *  ---------      -------        -------    --------
 *  Queue          FIFO           O(1)       Simple ordering
 *  PriorityQueue  By priority    O(log n)   Priority matters
 *  TreeSet        Sorted         O(log n)   Sorted + unique
 *  ArrayList      Insertion      O(1)       Random access
 *
 * ============================================================
 * COMPARATOR PATTERNS
 * ============================================================
 *
 *  Natural order (ascending):
 *  new PriorityQueue<>()
 *  new PriorityQueue<>(Comparator.naturalOrder())
 *
 *  Reverse order (descending):
 *  new PriorityQueue<>(Collections.reverseOrder())
 *  new PriorityQueue<>(Comparator.reverseOrder())
 *
 *  By field:
 *  new PriorityQueue<>(Comparator.comparingInt(o -> o.field))
 *
 *  By multiple fields:
 *  new PriorityQueue<>(Comparator
 *      .comparingInt((Person p) -> p.age)
 *      .thenComparing(p -> p.name))
 *
 *  Custom lambda:
 *  new PriorityQueue<>((a, b) -> a.score - b.score)
 *
 * ============================================================
 */

import java.util.*;

public class PriorityQueueClass {

    // ── separator helper ──
    static void sep() { System.out.println("  " + "-".repeat(50)); }
    static void header(String title) {
        System.out.println("\n  ╔══════════════════════════════════════════╗");
        System.out.printf ("  ║  %-40s║%n", title);
        System.out.println("  ╚══════════════════════════════════════════╝");
    }

    // ── drain PQ and return sorted list (PQ is consumed) ──
    static <T> List<T> drain(PriorityQueue<T> pq) {
        List<T> result = new ArrayList<>();
        while (!pq.isEmpty()) result.add(pq.poll());
        return result;
    }

    // ── print PQ state ──
    // static <T> void printPQ(String label, PriorityQueue<T> pq) {
    //     PriorityQueue<T> copy = new PriorityQueue<>(pq);
    //     System.out.printf("  %-22s: peek=%-8s drain=%s%n",
    //             label, pq.isEmpty() ? "null" : String.valueOf(pq.peek()),
    //             drain(copy));
    // }

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#      PriorityQueue CLASS IN JAVA         #");
        System.out.println("############################################");

        // ============================================================
        // 1. CREATING PriorityQueue
        // ============================================================
        header("1. CREATING PriorityQueue");

        // Default: empty, natural order, initial cap 11
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        System.out.println("  Empty PQ           : " + pq1);
        System.out.println("  isEmpty()          : " + pq1.isEmpty());
        System.out.println("  size()             : " + pq1.size());
        System.out.println("  comparator()       : " + pq1.comparator()); // null = natural

        // With initial capacity
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(50);
        System.out.println("\n  With capacity(50)  : " + pq2);

        // From Collection
        List<Integer> nums = Arrays.asList(30, 10, 50, 20, 40, 15, 35);
        PriorityQueue<Integer> pq3 = new PriorityQueue<>(nums);
        System.out.println("\n  From List          : " + nums);
        System.out.println("  PQ (heap order)    : " + pq3);
        System.out.println("  peek() (min)       : " + pq3.peek());

        // Copy constructor
        PriorityQueue<Integer> pq4 = new PriorityQueue<>(pq3);
        System.out.println("  Copy of pq3        : " + pq4);

        // Max-Heap
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        maxPQ.addAll(nums);
        System.out.println("\n  Max-Heap PQ        : " + maxPQ);
        System.out.println("  peek() (max)       : " + maxPQ.peek());

        // With Comparator (by string length)
        PriorityQueue<String> strPQ = new PriorityQueue<>(
                Comparator.comparingInt(String::length));
        Collections.addAll(strPQ, "Banana","Apple","Fig","Cherry","Kiwi","Blueberry");
        System.out.println("\n  By length (min)    : " + strPQ);
        System.out.println("  peek() (shortest)  : " + strPQ.peek());
        System.out.println("  comparator()       : " + strPQ.comparator());

        // Different types
        PriorityQueue<Double>  dblPQ = new PriorityQueue<>();
        PriorityQueue<String>  natPQ = new PriorityQueue<>();

        Collections.addAll(dblPQ, 3.14, 1.41, 2.71, 1.73, 2.23);
        Collections.addAll(natPQ, "Mango","Apple","Cherry","Banana");

        System.out.println("\n  PQ<Double>         : peek=" + dblPQ.peek()
                + " → " + drain(new PriorityQueue<>(dblPQ)));
        System.out.println("  PQ<String>         : peek=" + natPQ.peek()
                + " → " + drain(new PriorityQueue<>(natPQ)));

        // ============================================================
        // 2. offer() & add() — ADDING ELEMENTS
        // ============================================================
        header("2. offer() & add() — ADDING ELEMENTS");

        PriorityQueue<Integer> addPQ = new PriorityQueue<>();

        // offer() — preferred (returns false on failure)
        System.out.println("  --- offer() ---");
        System.out.println("  offer(30): " + addPQ.offer(30)
                + "  → " + addPQ);
        System.out.println("  offer(10): " + addPQ.offer(10)
                + "  → " + addPQ);
        System.out.println("  offer(50): " + addPQ.offer(50)
                + "  → " + addPQ);
        System.out.println("  offer(20): " + addPQ.offer(20)
                + "  → " + addPQ);
        System.out.println("  offer(40): " + addPQ.offer(40)
                + "  → " + addPQ);
        System.out.println("  peek()   : " + addPQ.peek() + " (always minimum)");

        // add() — throws on failure
        System.out.println("\n  --- add() ---");
        PriorityQueue<Integer> addPQ2 = new PriorityQueue<>();
        addPQ2.add(15);
        addPQ2.add(5);
        addPQ2.add(25);
        System.out.println("  After add(15,5,25) : " + addPQ2);
        System.out.println("  peek()             : " + addPQ2.peek()); // 5

        // NullPointerException demo
        System.out.println("\n  --- Null NOT allowed ---");
        try {
            addPQ2.offer(null);
        } catch (NullPointerException e) {
            System.out.println("  ✘ offer(null) → NullPointerException");
        }

        // Duplicates ARE allowed
        System.out.println("\n  --- Duplicates allowed ---");
        PriorityQueue<Integer> dupPQ = new PriorityQueue<>();
        dupPQ.offer(5); dupPQ.offer(5); dupPQ.offer(3);
        dupPQ.offer(3); dupPQ.offer(7);
        System.out.println("  Duplicates PQ      : " + dupPQ);
        System.out.println("  Drain order        : " + drain(new PriorityQueue<>(dupPQ)));

        // Heap visualization after insertions
        System.out.println("\n  --- Heap Build Visualization ---");
        PriorityQueue<Integer> buildPQ = new PriorityQueue<>();
        int[] insertSeq = {40, 20, 60, 10, 30, 50, 70};
        System.out.printf("  %-12s  %-30s  %s%n", "Insert", "Heap (internal)", "Min");
        sep();
        for (int v : insertSeq) {
            buildPQ.offer(v);
            System.out.printf("  offer(%-3d)    %-30s  %d%n",
                    v, buildPQ.toString(), buildPQ.peek());
        }

        // ============================================================
        // 3. peek() & element() — VIEWING MIN
        // ============================================================
        header("3. peek() & element() — VIEWING MIN/MAX");

        PriorityQueue<Integer> viewPQ = new PriorityQueue<>(
                Arrays.asList(25, 8, 42, 3, 17, 36, 55));
        System.out.println("  PQ                 : " + viewPQ);
        System.out.println("  size()             : " + viewPQ.size());

        // peek() — returns null if empty (safe)
        System.out.println("\n  --- peek() ---");
        System.out.println("  peek()             : " + viewPQ.peek()); // 3
        System.out.println("  PQ unchanged       : " + viewPQ);
        System.out.println("  peek() again       : " + viewPQ.peek()); // still 3

        // element() — throws if empty (unsafe)
        System.out.println("\n  --- element() ---");
        System.out.println("  element()          : " + viewPQ.element()); // 3

        // peek on empty
        PriorityQueue<Integer> emptyPQ = new PriorityQueue<>();
        System.out.println("\n  peek() on empty    : " + emptyPQ.peek());  // null (safe)
        try {
            emptyPQ.element();
        } catch (NoSuchElementException e) {
            System.out.println("  ✘ element() empty → NoSuchElementException");
        }

        // ============================================================
        // 4. poll() & remove() — REMOVING ELEMENTS
        // ============================================================
        header("4. poll() & remove() — REMOVING ELEMENTS");

        PriorityQueue<Integer> remPQ = new PriorityQueue<>(
                Arrays.asList(50, 10, 40, 20, 30, 15, 45));
        System.out.println("  PQ                 : " + remPQ);
        System.out.println("  Drain order (sorted): " +
                drain(new PriorityQueue<>(remPQ)));

        // poll() — returns null if empty (safe)
        System.out.println("\n  --- poll() one by one ---");
        System.out.printf("  %-12s %-30s%n", "poll()", "Remaining PQ");
        sep();
        PriorityQueue<Integer> pollPQ = new PriorityQueue<>(remPQ);
        while (!pollPQ.isEmpty()) {
            int val = pollPQ.poll();
            System.out.printf("  ← %-10d %s%n", val, pollPQ);
        }

        // poll on empty — returns null
        System.out.println("  poll() on empty    : " + pollPQ.poll()); // null

        // remove() — throws if empty
        System.out.println("\n  --- remove() (throws on empty) ---");
        PriorityQueue<Integer> remPQ2 = new PriorityQueue<>(Arrays.asList(5,1,3));
        System.out.println("  remove()           : " + remPQ2.remove()); // 1
        System.out.println("  remove()           : " + remPQ2.remove()); // 3
        System.out.println("  PQ after           : " + remPQ2);

        // remove(Object) — remove SPECIFIC value O(n)
        System.out.println("\n  --- remove(Object) specific value ---");
        PriorityQueue<Integer> remObj = new PriorityQueue<>(
                Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("  Before             : " + remObj);
        System.out.println("  remove(30)         : " + remObj.remove(30));  // true
        System.out.println("  After              : " + remObj);
        System.out.println("  remove(99)         : " + remObj.remove(99));  // false
        System.out.println("  min unchanged      : " + remObj.peek());      // 10

        // clear()
        System.out.println("\n  --- clear() ---");
        PriorityQueue<Integer> clrPQ = new PriorityQueue<>(Arrays.asList(1,2,3,4,5));
        System.out.println("  Before clear()     : " + clrPQ);
        clrPQ.clear();
        System.out.println("  After  clear()     : " + clrPQ
                + " isEmpty=" + clrPQ.isEmpty());

        // ============================================================
        // 5. contains() — SEARCHING
        // ============================================================
        header("5. contains() — SEARCHING  O(n)");

        PriorityQueue<String> conPQ = new PriorityQueue<>(
                Arrays.asList("Java","Python","C++","Kotlin","Swift","Go"));
        System.out.println("  PQ                 : " + conPQ);

        String[] searchItems = {"Java","Ruby","Kotlin","Rust","Go"};
        for (String s : searchItems) {
            System.out.printf("  contains(\"%-8s\") : %s%n",
                    s + "\"", conPQ.contains(s) ? "✔ Found" : "✘ Not found");
        }

        // ============================================================
        // 6. MIN-HEAP vs MAX-HEAP
        // ============================================================
        header("6. MIN-HEAP vs MAX-HEAP");

        int[] data = {64, 25, 12, 22, 11, 90, 45, 33, 78};
        System.out.println("  Data               : " + Arrays.toString(data));

        // Min-Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int v : data) minHeap.offer(v);
        System.out.println("\n  Min-Heap internal  : " + minHeap);
        System.out.println("  Min-Heap peek()    : " + minHeap.peek()); // 11
        System.out.print("  Min-Heap poll all  : ");
        PriorityQueue<Integer> minCopy = new PriorityQueue<>(minHeap);
        while (!minCopy.isEmpty()) System.out.print(minCopy.poll() + " ");
        System.out.println("  ← Ascending");

        // Max-Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int v : data) maxHeap.offer(v);
        System.out.println("\n  Max-Heap internal  : " + maxHeap);
        System.out.println("  Max-Heap peek()    : " + maxHeap.peek()); // 90
        System.out.print("  Max-Heap poll all  : ");
        PriorityQueue<Integer> maxCopy = new PriorityQueue<>(maxHeap);
        while (!maxCopy.isEmpty()) System.out.print(maxCopy.poll() + " ");
        System.out.println("  ← Descending");

        // Heap sort
        System.out.println("\n  --- Heap Sort using PQ ---");
        int[] unsorted = {38, 27, 43, 3, 9, 82, 10};
        PriorityQueue<Integer> sortPQ = new PriorityQueue<>();
        for (int v : unsorted) sortPQ.offer(v);
        int[] sorted = new int[unsorted.length];
        for (int i = 0; i < sorted.length; i++) sorted[i] = sortPQ.poll();
        System.out.println("  Unsorted           : " + Arrays.toString(unsorted));
        System.out.println("  Sorted (asc)       : " + Arrays.toString(sorted));

        // ============================================================
        // 7. CUSTOM COMPARATORS
        // ============================================================
        header("7. CUSTOM COMPARATORS");

        // By string length (ascending)
        PriorityQueue<String> byLen = new PriorityQueue<>(
                Comparator.comparingInt(String::length));
        Collections.addAll(byLen,
                "Banana","Fig","Blueberry","Kiwi","Apple","Strawberry","Plum");
        System.out.println("  --- By Length (shortest first) ---");
        System.out.printf("  %-10s %s%n", "peek()", byLen.peek());
        System.out.println("  Poll order : " + drain(new PriorityQueue<>(byLen)));

        // By string length descending
        PriorityQueue<String> byLenDesc = new PriorityQueue<>(
                Comparator.comparingInt(String::length).reversed());
        byLenDesc.addAll(Arrays.asList(
                "Banana","Fig","Blueberry","Kiwi","Apple","Strawberry","Plum"));
        System.out.println("\n  --- By Length (longest first) ---");
        System.out.println("  Poll order : " + drain(byLenDesc));

        // By absolute value
        PriorityQueue<Integer> byAbs = new PriorityQueue<>(
                Comparator.comparingInt(Math::abs));
        Collections.addAll(byAbs, -10, 3, -7, 5, -2, 8, -1);
        System.out.println("\n  --- By Absolute Value ---");
        System.out.println("  Data       : [-10, 3, -7, 5, -2, 8, -1]");
        System.out.println("  Poll order : " + drain(byAbs));

        // Multiple field comparator
        System.out.println("\n  --- Multiple Field Comparator ---");
        PriorityQueue<int[]> multiComp = new PriorityQueue<>(
                Comparator.comparingInt((int[] a) -> a[0])
                          .thenComparingInt(a -> a[1]));
        multiComp.offer(new int[]{2, 5});
        multiComp.offer(new int[]{1, 8});
        multiComp.offer(new int[]{2, 3});
        multiComp.offer(new int[]{1, 2});
        multiComp.offer(new int[]{3, 1});
        System.out.println("  Pairs [priority, id] sorted by priority then id:");
        while (!multiComp.isEmpty()) {
            int[] pair = multiComp.poll();
            System.out.printf("  [%d, %d]%n", pair[0], pair[1]);
        }

        // ============================================================
        // 8. ITERATION (⚠ NOT sorted order)
        // ============================================================
        header("8. ITERATION (⚠ NOT Sorted Order)");

        PriorityQueue<Integer> iterPQ = new PriorityQueue<>(
                Arrays.asList(30, 10, 50, 20, 40, 15, 35));
        System.out.println("  PQ                 : " + iterPQ);
        System.out.println("  peek() (min)       : " + iterPQ.peek());

        // for-each (NOT sorted)
        System.out.print("\n  for-each (⚠ NOT sorted): ");
        for (int v : iterPQ) System.out.print(v + " ");
        System.out.println();

        // forEach lambda (NOT sorted)
        System.out.print("  forEach  (⚠ NOT sorted): ");
        iterPQ.forEach(v -> System.out.print(v + " "));
        System.out.println();

        // Iterator (NOT sorted)
        System.out.print("  Iterator (⚠ NOT sorted): ");
        Iterator<Integer> it = iterPQ.iterator();
        while (it.hasNext()) System.out.print(it.next() + " ");
        System.out.println();

        // Correct sorted order — drain with poll()
        System.out.print("\n  poll() loop (✔ SORTED) : ");
        PriorityQueue<Integer> sortedIter = new PriorityQueue<>(iterPQ);
        while (!sortedIter.isEmpty()) System.out.print(sortedIter.poll() + " ");
        System.out.println();

        // toArray() — NOT sorted
        Object[] arr = iterPQ.toArray();
        System.out.println("\n  toArray() (⚠ NOT sorted): " + Arrays.toString(arr));

        // ============================================================
        // 9. PriorityQueue WITH CUSTOM OBJECTS
        // ============================================================
        header("9. PriorityQueue WITH CUSTOM OBJECTS");

        // Using Comparable (natural ordering)
        System.out.println("  --- Student PQ (by GPA descending) ---");
        PriorityQueue<Student> stuPQ = new PriorityQueue<>(
                Comparator.comparingDouble((Student s) -> s.gpa).reversed());
        stuPQ.offer(new Student("Alice",   3.92));
        stuPQ.offer(new Student("Bob",     3.45));
        stuPQ.offer(new Student("Charlie", 3.87));
        stuPQ.offer(new Student("Diana",   3.98));
        stuPQ.offer(new Student("Eve",     3.61));
        stuPQ.offer(new Student("Frank",   3.75));

        System.out.printf("  %-4s %-12s %s%n", "Rank", "Name", "GPA");
        sep();
        int rank = 1;
        while (!stuPQ.isEmpty()) {
            Student s = stuPQ.poll();
            System.out.printf("  #%-3d %-12s %.2f%n", rank++, s.name, s.gpa);
        }

        // Multiple field sorting
        System.out.println("\n  --- Job PQ (by priority, then salary) ---");
        PriorityQueue<Job> jobPQ = new PriorityQueue<>(
                Comparator.comparingInt((Job j) -> j.priority)
                          .thenComparingDouble(j -> -j.salary));
        jobPQ.offer(new Job("Backend Dev",    1, 95000));
        jobPQ.offer(new Job("Frontend Dev",   2, 85000));
        jobPQ.offer(new Job("DevOps",         1, 90000));
        jobPQ.offer(new Job("Data Scientist", 2, 110000));
        jobPQ.offer(new Job("ML Engineer",    1, 105000));
        jobPQ.offer(new Job("QA Engineer",    3, 70000));

        System.out.printf("  %-4s %-18s %5s %10s%n",
                "Pri.", "Title", "Level", "Salary");
        sep();
        while (!jobPQ.isEmpty()) {
            Job j = jobPQ.poll();
            System.out.printf("  [%d]  %-18s %5s %10.0f%n",
                    j.priority, j.title, "L" + j.priority, j.salary);
        }

        // ============================================================
        // 10. CLASSIC ALGORITHMS using PriorityQueue
        // ============================================================
        header("10. CLASSIC ALGORITHMS");

        // Top-K Largest Elements
        System.out.println("  --- Top-K Largest Elements ---");
        int[] nums2 = {3, 2, 1, 5, 6, 4, 8, 7, 9, 10, 15, 12};
        int k = 5;
        // Use min-heap of size k
        PriorityQueue<Integer> topK = new PriorityQueue<>(); // min-heap
        for (int v : nums2) {
            topK.offer(v);
            if (topK.size() > k) topK.poll(); // remove smallest
        }
        List<Integer> topKResult = drain(new PriorityQueue<>(topK));
        Collections.sort(topKResult, Collections.reverseOrder());
        System.out.println("  Array  : " + Arrays.toString(nums2));
        System.out.println("  K      : " + k);
        System.out.println("  Top " + k + "  : " + topKResult);

        // Top-K Smallest Elements
        System.out.println("\n  --- Top-K Smallest Elements ---");
        PriorityQueue<Integer> botK = new PriorityQueue<>(Collections.reverseOrder());
        for (int v : nums2) {
            botK.offer(v);
            if (botK.size() > k) botK.poll();
        }
        List<Integer> botKResult = drain(new PriorityQueue<>(botK));
        Collections.sort(botKResult);
        System.out.println("  Bottom " + k + ": " + botKResult);

        // K-th Largest Element
        System.out.println("\n  --- K-th Largest Element ---");
        int[] kthArr = {7, 10, 4, 3, 20, 15};
        int   kth    = 3;
        PriorityQueue<Integer> kthPQ = new PriorityQueue<>();
        for (int v : kthArr) {
            kthPQ.offer(v);
            if (kthPQ.size() > kth) kthPQ.poll();
        }
        System.out.println("  Array  : " + Arrays.toString(kthArr));
        System.out.printf("  %drd largest: %d%n", kth, kthPQ.peek()); // 10

        // Merge K Sorted Arrays
        System.out.println("\n  --- Merge K Sorted Arrays ---");
        int[][] kArrays = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };
        // PQ stores [value, arrayIndex, elementIndex]
        PriorityQueue<int[]> mergePQ = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < kArrays.length; i++) {
            if (kArrays[i].length > 0)
                mergePQ.offer(new int[]{kArrays[i][0], i, 0});
        }
        List<Integer> merged = new ArrayList<>();
        while (!mergePQ.isEmpty()) {
            int[] curr = mergePQ.poll();
            merged.add(curr[0]);
            int ai = curr[1], ei = curr[2] + 1;
            if (ei < kArrays[ai].length)
                mergePQ.offer(new int[]{kArrays[ai][ei], ai, ei});
        }
        for (int[] a : kArrays)
            System.out.println("  Array  : " + Arrays.toString(a));
        System.out.println("  Merged : " + merged);

        // Find Median using Two Heaps
        System.out.println("\n  --- Running Median (Two Heaps) ---");
        runningMedian(new int[]{5, 15, 1, 3, 2, 8, 7, 9, 10, 6});

        // Dijkstra-like shortest path simulation
        System.out.println("\n  --- Dijkstra Shortest Path (Graph) ---");
        dijkstraDemo();

        // ============================================================
        // 11. REAL-WORLD EXAMPLES
        // ============================================================
        header("11. REAL-WORLD EXAMPLES");

        // Example 1: Printer Queue with Priority
        System.out.println("  --- Printer Job Queue ---");
        printerQueueDemo();

        // Example 2: Hospital Emergency Room
        System.out.println("\n  --- Hospital Emergency Room ---");
        hospitalERDemo();

        // Example 3: Stock Price — Find K Cheapest
        System.out.println("\n  --- K Cheapest Stocks ---");
        stockDemo();

        // Example 4: Event Scheduler
        System.out.println("\n  --- Event Scheduler ---");
        eventSchedulerDemo();

        // Example 5: Frequency Sort
        System.out.println("\n  --- Sort by Frequency ---");
        frequencySortDemo();

        System.out.println("\n############################################");
        System.out.println("# PriorityQueue in Java — Done! ✔         #");
        System.out.println("############################################");
    }

    // ============================================================
    // HELPER METHODS & ALGORITHMS
    // ============================================================

    // Running Median using Two Heaps
    static void runningMedian(int[] stream) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                Collections.reverseOrder()); // lower half
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // upper half

        System.out.println("  Stream  : " + Arrays.toString(stream));
        System.out.printf("  %-8s %-15s %-15s %s%n",
                "Insert","Lower Half","Upper Half","Median");
        sep();

        for (int num : stream) {
            // Add to appropriate heap
            if (maxHeap.isEmpty() || num <= maxHeap.peek())
                maxHeap.offer(num);
            else
                minHeap.offer(num);

            // Balance heaps (size diff ≤ 1)
            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.offer(maxHeap.poll());
            else if (minHeap.size() > maxHeap.size())
                maxHeap.offer(minHeap.poll());

            // Compute median
            double median = maxHeap.size() == minHeap.size()
                ? (maxHeap.peek() != null && minHeap.peek() != null) 
                   ? ((double)maxHeap.peek() + minHeap.peek()) / 2.0 
                   : 0.0
                : maxHeap.peek() != null ? (double)maxHeap.peek() : 0.0;
            System.out.printf("  %-8d %-15s %-15s %.1f%n",
                    num,
                    maxHeap.toString().substring(0,
                            Math.min(13, maxHeap.toString().length())),
                    minHeap.toString().substring(0,
                            Math.min(13, minHeap.toString().length())),
                    median);
        }
    }

    // Dijkstra's Shortest Path
    static void dijkstraDemo() {
        // Graph as adjacency list: node → list of [neighbor, weight]
        int V = 6;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Edges: addEdge(graph, from, to, weight)
        addEdge(graph, 0, 1, 4);
        addEdge(graph, 0, 2, 2);
        addEdge(graph, 1, 3, 5);
        addEdge(graph, 1, 2, 1);
        addEdge(graph, 2, 3, 8);
        addEdge(graph, 2, 4, 10);
        addEdge(graph, 3, 5, 2);
        addEdge(graph, 4, 5, 3);

        int src = 0;
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // PQ stores [distance, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] curr   = pq.poll();
            int   d      = curr[0];
            int   node   = curr[1];
            if (d > dist[node]) continue; // outdated entry
            for (int[] edge : graph.get(node)) {
                int next  = edge[0];
                int wt    = edge[1];
                if (dist[node] + wt < dist[next]) {
                    dist[next] = dist[node] + wt;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        System.out.printf("  %-8s %s%n", "Node", "Dist from 0");
        sep();
        for (int i = 0; i < V; i++)
            System.out.printf("  Node %-3d : %d%n", i, dist[i]);
    }

    static void addEdge(List<List<int[]>> g, int u, int v, int w) {
        g.get(u).add(new int[]{v, w});
        g.get(v).add(new int[]{u, w});
    }

    // Printer Queue Demo
    static void printerQueueDemo() {
        PriorityQueue<PrintJob> printer = new PriorityQueue<>(
                Comparator.comparingInt((PrintJob j) -> j.priority)
                          .thenComparingInt(j -> j.pages));

        printer.offer(new PrintJob("Resume.pdf",     1, 2));
        printer.offer(new PrintJob("Report.docx",    3, 45));
        printer.offer(new PrintJob("Contract.pdf",   1, 8));
        printer.offer(new PrintJob("Presentation",   2, 15));
        printer.offer(new PrintJob("Invoice.pdf",    2, 3));
        printer.offer(new PrintJob("Manual.pdf",     3, 120));
        printer.offer(new PrintJob("Letter.docx",    1, 1));

        System.out.printf("  %-5s %-20s %7s %s%n",
                "Pri.", "Document","Pages","Status");
        sep();
        int order = 1;
        while (!printer.isEmpty()) {
            PrintJob j = printer.poll();
            String label = j.priority == 1 ? "🔴 URGENT" :
                           j.priority == 2 ? "🟡 NORMAL" : "🟢 LOW   ";
            System.out.printf("  %s  %-20s %7d  → Printing #%d%n",
                    label, j.name, j.pages, order++);
        }
    }

    // Hospital ER Demo
    @SuppressWarnings("unused")
    static void hospitalERDemo() {
        PriorityQueue<ERPatient> er = new PriorityQueue<>(
                Comparator.comparingInt((ERPatient p) -> p.severity)
                          .thenComparingInt(p -> p.arrivalTime));

        er.offer(new ERPatient("Alice",   3, 900,  "Fever"));
        er.offer(new ERPatient("Bob",     1, 905,  "Heart attack"));
        er.offer(new ERPatient("Charlie", 2, 902,  "Deep cut"));
        er.offer(new ERPatient("Diana",   4, 908,  "Sprained ankle"));
        er.offer(new ERPatient("Eve",     1, 910,  "Stroke"));
        er.offer(new ERPatient("Frank",   2, 903,  "Burns"));
        er.offer(new ERPatient("Grace",   3, 906,  "Broken arm"));

        System.out.printf("  %-6s %-10s %6s %s%n",
                "Sev.", "Patient", "Arrival", "Condition");
        sep();
        int slot = 1;
        while (!er.isEmpty()) {
            ERPatient p = er.poll();
            String sev = p.severity == 1 ? "🔴 P1" :
                         p.severity == 2 ? "🟠 P2" :
                         p.severity == 3 ? "🟡 P3" : "🟢 P4";
            System.out.printf("  %s  %-10s %6d  %s%n",
                    sev, p.name, p.arrivalTime, p.condition);
            slot++;
        }
    }

    // Stock Demo
    static void stockDemo() {
        PriorityQueue<double[]> stockPQ = new PriorityQueue<>(
                Comparator.comparingDouble(a -> a[1]));

        String[] stocks = {"AAPL","GOOG","MSFT","AMZN","META","TSLA","NVDA"};
        double[] prices = {185.2, 141.8, 378.5, 178.3, 497.1, 235.4, 875.9};

        for (int i = 0; i < stocks.length; i++)
            stockPQ.offer(new double[]{i, prices[i]});

        int k3 = 3;
        System.out.println("  All stocks:");
        for (int i = 0; i < stocks.length; i++)
            System.out.printf("  %-6s : $%.2f%n", stocks[i], prices[i]);

        System.out.println("\n  " + k3 + " Cheapest stocks:");
        PriorityQueue<double[]> copy = new PriorityQueue<>(stockPQ);
        for (int i = 0; i < k3 && !copy.isEmpty(); i++) {
            double[] s = copy.poll();
            System.out.printf("  #%d %-6s : $%.2f%n",
                    i+1, stocks[(int)s[0]], s[1]);
        }
    }

    // Event Scheduler Demo
    static void eventSchedulerDemo() {
        // [time, eventName]
        PriorityQueue<Object[]> scheduler = new PriorityQueue<>(
                Comparator.comparingInt(a -> (int) a[0]));

        scheduler.offer(new Object[]{900,  "Morning standup"});
        scheduler.offer(new Object[]{1400, "Client presentation"});
        scheduler.offer(new Object[]{1030, "Code review"});
        scheduler.offer(new Object[]{800,  "Check emails"});
        scheduler.offer(new Object[]{1200, "Lunch break"});
        scheduler.offer(new Object[]{1545, "Team retrospective"});
        scheduler.offer(new Object[]{1115, "1:1 with manager"});

        System.out.printf("  %-8s %s%n", "Time", "Event");
        sep();
        while (!scheduler.isEmpty()) {
            Object[] ev   = scheduler.poll();
            int      time = (int) ev[0];
            String   name = (String) ev[1];
            System.out.printf("  %02d:%02d    %s%n",
                    time/100, time%100, name);
        }
    }

    // Frequency Sort Demo
    static void frequencySortDemo() {
        int[] freqArr = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 5, 5};
        System.out.println("  Array   : " + Arrays.toString(freqArr));

        // Count frequencies
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int v : freqArr) freq.merge(v, 1, Integer::sum);

        // Sort by frequency descending, then by value ascending
        PriorityQueue<Map.Entry<Integer,Integer>> freqPQ = new PriorityQueue<>(
                (a, b) -> !a.getValue().equals(b.getValue())
                        ? b.getValue() - a.getValue()
                        : a.getKey() - b.getKey());
        freqPQ.addAll(freq.entrySet());

        System.out.println("  Frequencies:");
        List<Integer> freqSorted = new ArrayList<>();
        while (!freqPQ.isEmpty()) {
            Map.Entry<Integer,Integer> e = freqPQ.poll();
            System.out.printf("  Value %-3d : freq=%d %s%n",
                    e.getKey(), e.getValue(),
                    "█".repeat(e.getValue()));
            for (int i = 0; i < e.getValue(); i++) freqSorted.add(e.getKey());
        }
        System.out.println("  Sorted  : " + freqSorted);
    }
}

// ── Supporting classes ──
class Student {
    String name; double gpa;
    Student(String n, double g) { name = n; gpa = g; }
}

class Job {
    String title; int priority; double salary;
    Job(String t, int p, double s) { title=t; priority=p; salary=s; }
}

class PrintJob {
    String name; int priority; int pages;
    PrintJob(String n, int p, int pg) { name=n; priority=p; pages=pg; }
}

class ERPatient {
    String name; int severity; int arrivalTime; String condition;
    ERPatient(String n, int s, int t, String c) {
        name=n; severity=s; arrivalTime=t; condition=c;
    }
}