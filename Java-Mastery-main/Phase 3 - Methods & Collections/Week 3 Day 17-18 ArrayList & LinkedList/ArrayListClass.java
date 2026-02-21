/*
 * ============================================================
 *         ArrayList CLASS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS ArrayList?
 * -------------------
 * ArrayList is a RESIZABLE (dynamic) array implementation
 * of the List interface found in java.util package.
 * Unlike regular arrays (fixed size), ArrayList can GROW
 * and SHRINK automatically as elements are added or removed.
 *
 * Key Characteristics:
 *  - Dynamic size    → grows/shrinks automatically
 *  - Ordered         → maintains insertion order
 *  - Index-based     → access elements by index (0-based)
 *  - Allows duplicates → same value can appear multiple times
 *  - Allows null     → null can be stored as element
 *  - NOT thread-safe → use Collections.synchronizedList()
 *                      or CopyOnWriteArrayList for threads
 *  - Generic         → type-safe with <T> generics
 *
 * ============================================================
 * Array vs ArrayList
 * ============================================================
 *
 *  Feature          Array           ArrayList
 *  ----------       ----------      --------------------
 *  Size             Fixed           Dynamic (resizable)
 *  Type             Primitive/Object Object only
 *  Generics         No              Yes (<T>)
 *  Performance      Faster          Slightly slower
 *  Methods          None            Rich API (add, remove...)
 *  Syntax           int[]           ArrayList<Integer>
 *  Null             Yes (objects)   Yes
 *  Duplicates       Yes             Yes
 *  Memory           Contiguous      May not be contiguous
 *
 * ============================================================
 * INTERNAL WORKING
 * ============================================================
 *
 *  Internally, ArrayList uses an Object[] array.
 *  Default initial capacity = 10
 *
 *  When capacity is exceeded:
 *  newCapacity = oldCapacity + (oldCapacity >> 1)
 *             = oldCapacity × 1.5
 *
 *  10 → 15 → 22 → 33 → 49 → ...
 *
 *  Growth is automatic — you don't need to manage it.
 *  Pre-set capacity with: new ArrayList<>(100)
 *
 * ============================================================
 * IMPORT REQUIRED
 * ============================================================
 *
 *  import java.util.ArrayList;
 *  import java.util.Collections;  // for sort, shuffle, etc.
 *  import java.util.List;         // for List interface
 *  import java.util.Iterator;     // for Iterator
 *  import java.util.ListIterator; // for ListIterator
 *
 * ============================================================
 * WAYS TO CREATE ArrayList
 * ============================================================
 *
 *  1. Empty ArrayList:
 *     ArrayList<String> list = new ArrayList<>();
 *
 *  2. With initial capacity:
 *     ArrayList<Integer> list = new ArrayList<>(50);
 *
 *  3. From another collection:
 *     ArrayList<String> list = new ArrayList<>(anotherList);
 *
 *  4. Using List.of() (immutable → then copy):
 *     ArrayList<String> list = new ArrayList<>(List.of("a","b","c"));
 *
 *  5. Using Arrays.asList():
 *     ArrayList<String> list = new ArrayList<>(Arrays.asList("a","b"));
 *
 * ============================================================
 * ALL ArrayList METHODS
 * ============================================================
 *
 *  ADDING:
 *  --------
 *  add(element)           → add at end
 *  add(index, element)    → add at specific index
 *  addAll(collection)     → add all from collection
 *  addAll(index, coll)    → add all at specific index
 *
 *  REMOVING:
 *  ----------
 *  remove(index)          → remove by index
 *  remove(Object)         → remove by value (first occurrence)
 *  removeAll(collection)  → remove all matching elements
 *  removeIf(predicate)    → remove elements matching condition
 *  clear()                → remove ALL elements
 *
 *  ACCESSING:
 *  -----------
 *  get(index)             → get element at index
 *  indexOf(Object)        → first index of element (-1 if absent)
 *  lastIndexOf(Object)    → last index of element (-1 if absent)
 *  subList(from, to)      → portion of list (from inclusive, to exclusive)
 *
 *  UPDATING:
 *  ----------
 *  set(index, element)    → replace element at index
 *  replaceAll(operator)   → replace all with UnaryOperator
 *
 *  CHECKING:
 *  ----------
 *  contains(Object)       → true if element exists
 *  containsAll(collection)→ true if all elements exist
 *  isEmpty()              → true if list has no elements
 *  size()                 → number of elements
 *
 *  CONVERTING:
 *  ------------
 *  toArray()              → convert to Object[]
 *  toArray(T[])           → convert to typed array
 *  toString()             → string representation
 *
 *  SORTING & ORDER:
 *  -----------------
 *  sort(Comparator)       → sort with comparator
 *  Collections.sort(list) → sort in natural order
 *  Collections.reverse(list) → reverse order
 *  Collections.shuffle(list) → random shuffle
 *
 *  CAPACITY:
 *  ----------
 *  ensureCapacity(minCap) → ensure minimum capacity
 *  trimToSize()           → trim to current size
 *
 *  ITERATION:
 *  -----------
 *  iterator()             → returns Iterator
 *  listIterator()         → returns ListIterator
 *  forEach(action)        → iterate with lambda
 *  stream()               → returns Stream for functional ops
 *
 * ============================================================
 * AUTOBOXING & UNBOXING
 * ============================================================
 *
 *  ArrayList cannot store primitives directly.
 *  Use wrapper classes:
 *
 *  int     → Integer
 *  double  → Double
 *  char    → Character
 *  boolean → Boolean
 *
 *  Autoboxing:  int x = 5; list.add(x);   // auto int→Integer
 *  Unboxing:    int y = list.get(0);       // auto Integer→int
 *
 * ============================================================
 * IMPORTANT NOTES
 * ============================================================
 *
 *  - Index-based: 0 to size()-1
 *  - remove(int) removes by INDEX
 *  - remove(Object) removes by VALUE
 *  - To remove Integer value, use remove(Integer.valueOf(5))
 *  - ConcurrentModificationException if list is modified
 *    during iteration with for-each — use Iterator.remove()
 *  - Use Collections.unmodifiableList() for read-only list
 *
 * ============================================================
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListClass {

    // ── separator helper ──
    static void sep() { System.out.println("  " + "-".repeat(48)); }

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#         ArrayList CLASS IN JAVA          #");
        System.out.println("############################################");

        // ============================================================
        // 1. CREATING ArrayList
        // ============================================================
        System.out.println("\n===== 1. CREATING ArrayList =====");

        // Empty ArrayList
        ArrayList<String> list1 = new ArrayList<>();
        System.out.println("Empty list         : " + list1);
        System.out.println("Size               : " + list1.size());
        System.out.println("isEmpty()          : " + list1.isEmpty());

        // With initial capacity (performance optimization)
        ArrayList<Integer> list2 = new ArrayList<>(50);
        System.out.println("\nWith capacity(50)  : " + list2);

        // From Arrays.asList()
        ArrayList<String> list3 = new ArrayList<>(
                Arrays.asList("Alice", "Bob", "Charlie", "Diana"));
        System.out.println("\nFrom Arrays.asList : " + list3);

        // From List.of() (Java 9+)
        ArrayList<Integer> list4 = new ArrayList<>(
                List.of(10, 20, 30, 40, 50));
        System.out.println("From List.of()     : " + list4);

        // From another ArrayList
        ArrayList<String> list5 = new ArrayList<>(list3);
        System.out.println("From another list  : " + list5);

        // Different data types
        ArrayList<Integer>   intList  = new ArrayList<>();
        ArrayList<Double>    dblList  = new ArrayList<>();
        ArrayList<Character> chrList  = new ArrayList<>();
        ArrayList<Boolean>   bolList  = new ArrayList<>();

        intList.add(10); intList.add(20); intList.add(30);
        dblList.add(1.1); dblList.add(2.2); dblList.add(3.3);
        chrList.add('J'); chrList.add('A'); chrList.add('V'); chrList.add('A');
        bolList.add(true); bolList.add(false); bolList.add(true);

        System.out.println("\nArrayList<Integer>  : " + intList);
        System.out.println("ArrayList<Double>   : " + dblList);
        System.out.println("ArrayList<Character>: " + chrList);
        System.out.println("ArrayList<Boolean>  : " + bolList);

        // ============================================================
        // 2. add() — ADDING ELEMENTS
        // ============================================================
        System.out.println("\n===== 2. add() — ADDING ELEMENTS =====");

        ArrayList<String> fruits = new ArrayList<>();

        // add at end
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Mango");
        fruits.add("Orange");
        System.out.println("After add()         : " + fruits);
        System.out.println("Size                : " + fruits.size());

        // add at specific index
        fruits.add(0, "Avocado");   // insert at beginning
        System.out.println("add(0, Avocado)     : " + fruits);

        fruits.add(3, "Blueberry"); // insert in middle
        System.out.println("add(3, Blueberry)   : " + fruits);

        // add duplicate & null
        fruits.add("Apple");         // duplicate allowed
        fruits.add(null);            // null allowed
        System.out.println("add(duplicate+null) : " + fruits);

        // addAll() — add entire collection
        ArrayList<String> moreFruits = new ArrayList<>(
                List.of("Grape", "Kiwi", "Lemon"));
        fruits.addAll(moreFruits);
        System.out.println("addAll(moreFruits)  : " + fruits);

        // addAll at index
        ArrayList<String> tropical = new ArrayList<>(
                List.of("Papaya", "Pineapple"));
        fruits.addAll(2, tropical);
        System.out.println("addAll(2, tropical) : " + fruits);

        // ============================================================
        // 3. get() & set() — ACCESSING & UPDATING
        // ============================================================
        System.out.println("\n===== 3. get() & set() =====");

        ArrayList<String> names = new ArrayList<>(
                List.of("Alice", "Bob", "Charlie", "Diana", "Eve"));
        System.out.println("List                : " + names);

        // get()
        System.out.println("get(0)              : " + names.get(0));   // Alice
        System.out.println("get(2)              : " + names.get(2));   // Charlie
        System.out.println("get(last)           : " + names.get(names.size()-1)); // Eve

        // Iterate with get()
        System.out.print("Iterate get()       : ");
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + " ");
        }
        System.out.println();

        // set() — update element
        System.out.println("\nBefore set()        : " + names);
        String old = names.set(1, "Benjamin");  // returns old value
        System.out.println("set(1, Benjamin)    : " + names);
        System.out.println("Replaced value      : " + old);  // Bob

        names.set(names.size()-1, "Evelyn");
        System.out.println("set(last, Evelyn)   : " + names);

        // ============================================================
        // 4. remove() — REMOVING ELEMENTS
        // ============================================================
        System.out.println("\n===== 4. remove() — REMOVING ELEMENTS =====");

        ArrayList<String> colors = new ArrayList<>(
                List.of("Red","Green","Blue","Red","Yellow","Purple","Red"));
        System.out.println("Original            : " + colors);

        // remove by INDEX
        String removed = colors.remove(0);
        System.out.println("remove(0) → \"" + removed + "\" : " + colors);

        // remove by VALUE (first occurrence)
        boolean wasRemoved = colors.remove("Red");
        System.out.println("remove(\"Red\")        : " + colors + " (removed: " + wasRemoved + ")");

        // remove non-existent
        boolean notFound = colors.remove("Pink");
        System.out.println("remove(\"Pink\")       : " + notFound + " (not found)");

        // removeAll() — remove all matching
        ArrayList<String> toRemove = new ArrayList<>(List.of("Green","Purple"));
        colors.removeAll(toRemove);
        System.out.println("removeAll(Green,Purple): " + colors);

        // removeIf() — remove by condition
        ArrayList<Integer> numbers = new ArrayList<>(
                List.of(1,2,3,4,5,6,7,8,9,10));
        System.out.println("\nBefore removeIf     : " + numbers);
        numbers.removeIf(n -> n % 2 == 0);   // remove even numbers
        System.out.println("removeIf(even)      : " + numbers);

        // clear() — remove ALL
        ArrayList<String> temp = new ArrayList<>(List.of("a","b","c"));
        System.out.println("\nBefore clear()      : " + temp);
        temp.clear();
        System.out.println("After  clear()      : " + temp + " size=" + temp.size());

        // ⚠ remove(int) vs remove(Object)
        System.out.println("\n--- ⚠ remove(int) vs remove(Integer) ---");
        ArrayList<Integer> nums = new ArrayList<>(List.of(10,20,30,40,50));
        System.out.println("List                : " + nums);
        nums.remove(2);                  // removes by INDEX 2 → 30
        System.out.println("remove(2) by index  : " + nums);   // [10,20,40,50]
        nums.remove(Integer.valueOf(20));// removes by VALUE 20
        System.out.println("remove(Integer 20)  : " + nums);   // [10,40,50]

        // ============================================================
        // 5. SEARCHING — contains(), indexOf(), lastIndexOf()
        // ============================================================
        System.out.println("\n===== 5. SEARCHING =====");

        ArrayList<String> search = new ArrayList<>(
                List.of("Java","Python","Java","C++","Java","Kotlin","Python"));
        System.out.println("List                : " + search);

        // contains()
        System.out.println("contains(\"Java\")     : " + search.contains("Java"));    // true
        System.out.println("contains(\"Ruby\")     : " + search.contains("Ruby"));    // false

        // containsAll()
        ArrayList<String> subset = new ArrayList<>(List.of("Java","Python"));
        System.out.println("containsAll([Java,Python]): " + search.containsAll(subset));

        // indexOf() — first occurrence
        System.out.println("indexOf(\"Java\")      : " + search.indexOf("Java"));      // 0
        System.out.println("indexOf(\"Python\")    : " + search.indexOf("Python"));    // 1
        System.out.println("indexOf(\"Ruby\")      : " + search.indexOf("Ruby"));      // -1

        // lastIndexOf() — last occurrence
        System.out.println("lastIndexOf(\"Java\")  : " + search.lastIndexOf("Java"));  // 4
        System.out.println("lastIndexOf(\"Python\"): " + search.lastIndexOf("Python"));// 6

        // Count occurrences (manual)
        String target = "Java";
        int occCount  = 0;
        for (String s : search) if (s.equals(target)) occCount++;
        System.out.println("\"Java\" appears " + occCount + " times");

        // ============================================================
        // 6. subList() — EXTRACT PORTION
        // ============================================================
        System.out.println("\n===== 6. subList() =====");

        ArrayList<Integer> full = new ArrayList<>(
                List.of(1,2,3,4,5,6,7,8,9,10));
        System.out.println("Full list           : " + full);

        List<Integer> sub1 = full.subList(2, 6);   // index 2 to 5
        List<Integer> sub2 = full.subList(0, 5);   // first half
        List<Integer> sub3 = full.subList(5, 10);  // second half

        System.out.println("subList(2, 6)       : " + sub1);
        System.out.println("subList(0, 5)       : " + sub2);
        System.out.println("subList(5, 10)      : " + sub3);

        // Copy subList to new ArrayList
        ArrayList<Integer> subCopy = new ArrayList<>(full.subList(3, 8));
        System.out.println("subList copy(3,8)   : " + subCopy);

        // ============================================================
        // 7. SORTING & ORDERING
        // ============================================================
        System.out.println("\n===== 7. SORTING & ORDERING =====");

        ArrayList<Integer> sortList = new ArrayList<>(
                List.of(64, 34, 25, 12, 22, 11, 90));
        System.out.println("Original            : " + sortList);

        // Collections.sort() — ascending
        Collections.sort(sortList);
        System.out.println("sort() ascending    : " + sortList);

        // Collections.reverse()
        Collections.reverse(sortList);
        System.out.println("reverse()           : " + sortList);

        // sort() with Comparator — descending
        sortList.sort((a, b) -> b - a);
        System.out.println("sort desc           : " + sortList);

        // sort ascending again
        sortList.sort((a, b) -> a - b);
        System.out.println("sort asc            : " + sortList);

        // Sort Strings
        ArrayList<String> strSort = new ArrayList<>(
                List.of("Banana","Apple","Mango","Cherry","Avocado"));
        System.out.println("\nString original     : " + strSort);
        Collections.sort(strSort);
        System.out.println("String sorted       : " + strSort);

        // Sort by length
        strSort.sort((a, b) -> a.length() - b.length());
        System.out.println("Sort by length      : " + strSort);

        // Sort by length then alphabetically
        strSort.sort((a, b) -> a.length() != b.length()
                ? a.length() - b.length()
                : a.compareTo(b));
        System.out.println("Sort len+alpha      : " + strSort);

        // Collections.shuffle()
        ArrayList<Integer> shuffleList = new ArrayList<>(
                List.of(1,2,3,4,5,6,7,8,9,10));
        System.out.println("\nBefore shuffle      : " + shuffleList);
        Collections.shuffle(shuffleList);
        System.out.println("After  shuffle      : " + shuffleList);

        // Collections.min() & max()
        System.out.println("min()               : " + Collections.min(sortList));
        System.out.println("max()               : " + Collections.max(sortList));

        // Collections.frequency()
        ArrayList<String> freqList = new ArrayList<>(
                List.of("A","B","A","C","A","B","D","A"));
        System.out.println("\nfrequency(\"A\")      : " +
                Collections.frequency(freqList, "A"));  // 4

        // ============================================================
        // 8. ITERATION METHODS
        // ============================================================
        System.out.println("\n===== 8. ITERATION METHODS =====");

        ArrayList<String> iter = new ArrayList<>(
                List.of("Red","Green","Blue","Yellow","Purple"));
        System.out.println("List                : " + iter);

        // Method 1: for loop with index
        System.out.print("for(index)          : ");
        for (int i = 0; i < iter.size(); i++)
            System.out.print("[" + i + "]" + iter.get(i) + " ");
        System.out.println();

        // Method 2: for-each
        System.out.print("for-each            : ");
        for (String s : iter) System.out.print(s + " ");
        System.out.println();

        // Method 3: forEach with lambda
        System.out.print("forEach(lambda)     : ");
        iter.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // Method 4: Iterator
        System.out.print("Iterator            : ");
        Iterator<String> it = iter.iterator();
        while (it.hasNext()) System.out.print(it.next() + " ");
        System.out.println();

        // Method 5: ListIterator (bidirectional)
        System.out.print("ListIterator(rev)   : ");
        ListIterator<String> lit = iter.listIterator(iter.size());
        while (lit.hasPrevious()) System.out.print(lit.previous() + " ");
        System.out.println();

        // Safe removal during iteration
        System.out.println("\n--- Safe Removal During Iteration ---");
        ArrayList<Integer> safeRemove = new ArrayList<>(
                List.of(1,2,3,4,5,6,7,8,9,10));
        System.out.println("Before              : " + safeRemove);
        Iterator<Integer> safeIt = safeRemove.iterator();
        while (safeIt.hasNext()) {
            int val = safeIt.next();
            if (val % 3 == 0) safeIt.remove();  // safe removal
        }
        System.out.println("Remove multiples of 3: " + safeRemove);

        // ============================================================
        // 9. CONVERSION METHODS
        // ============================================================
        System.out.println("\n===== 9. CONVERSION METHODS =====");

        ArrayList<String> conv = new ArrayList<>(
                List.of("Java","Python","C++","Kotlin","Swift"));

        // toArray()
        Object[] objArr = conv.toArray();
        System.out.println("toArray()           : " + Arrays.toString(objArr));

        // toArray(T[]) — typed
        @SuppressWarnings("CollectionsToArray")
        String[] strArr = conv.toArray(new String[0]);
        System.out.println("toArray(String[])   : " + Arrays.toString(strArr));

        // Array → ArrayList
        String[] langArr   = {"Rust","Go","Scala","Groovy"};
        ArrayList<String> fromArr = new ArrayList<>(Arrays.asList(langArr));
        System.out.println("Array → ArrayList   : " + fromArr);

        // ArrayList → String (join)
        String joined = String.join(", ", conv);
        System.out.println("join(\", \")          : " + joined);

        // replaceAll() — modify all elements
        ArrayList<String> repAll = new ArrayList<>(
                List.of("hello","world","java","rocks"));
        repAll.replaceAll(String::toUpperCase);
        System.out.println("replaceAll(toUpper) : " + repAll);

        // replaceAll with custom operation
        ArrayList<Integer> repNums = new ArrayList<>(
                List.of(1,2,3,4,5));
        repNums.replaceAll(n -> n * n);  // square each element
        System.out.println("replaceAll(square)  : " + repNums);

        // ============================================================
        // 10. ArrayList of Objects
        // ============================================================
        System.out.println("\n===== 10. ArrayList OF OBJECTS =====");

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(101, "Alice",   92.5));
        students.add(new Student(102, "Bob",     78.0));
        students.add(new Student(103, "Charlie", 95.5));
        students.add(new Student(104, "Diana",   85.0));
        students.add(new Student(105, "Eve",     70.5));

        System.out.println("--- All Students ---");
        System.out.printf("  %-5s %-12s %6s%n", "ID", "Name", "Marks");
        sep();
        for (Student s : students) System.out.println("  " + s);

        // Sort by marks (descending)
        students.sort((a, b) -> Double.compare(b.marks, a.marks));
        System.out.println("\n--- Sorted by Marks (Desc) ---");
        students.forEach(s -> System.out.println("  " + s));

        // Sort by name
        students.sort((a, b) -> a.name.compareTo(b.name));
        System.out.println("\n--- Sorted by Name ---");
        students.forEach(s -> System.out.println("  " + s));

        // Filter — marks above 80
        System.out.println("\n--- Students with Marks > 80 ---");
        for (Student s : students)
            if (s.marks > 80) System.out.println("  " + s);

        // Find by name
        System.out.println("\n--- Find Student by Name ---");
        String findName = "Charlie";
        boolean found   = false;
        for (Student s : students) {
            if (s.name.equalsIgnoreCase(findName)) {
                System.out.println("  Found: " + s);
                found = true; break;
            }
        }
        if (!found) System.out.println("  Student not found!");

        // ============================================================
        // 11. NESTED ArrayList (2D ArrayList)
        // ============================================================
        System.out.println("\n===== 11. NESTED ArrayList (2D) =====");

        // Create 2D ArrayList
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 1; j <= 4; j++)
                row.add(i * j);   // multiplication table values
            matrix.add(row);
        }

        System.out.println("2D ArrayList (3×4):");
        for (int i = 0; i < matrix.size(); i++) {
            System.out.print("  Row " + i + ": ");
            for (int val : matrix.get(i))
                System.out.printf("%4d", val);
            System.out.println();
        }

        // Access specific element
        System.out.println("matrix.get(1).get(2) = " + matrix.get(1).get(2)); // row1, col2

        // Student subjects marks (jagged)
        System.out.println("\n--- Jagged 2D ArrayList ---");
        ArrayList<ArrayList<String>> schedule = new ArrayList<>();
        schedule.add(new ArrayList<>(List.of("Math","English","Science")));
        schedule.add(new ArrayList<>(List.of("PE","Art")));
        schedule.add(new ArrayList<>(List.of("History","Geography","CS","Music")));

        String[] days = {"Monday","Tuesday","Wednesday"};
        for (int i = 0; i < schedule.size(); i++) {
            System.out.printf("  %-12s: %s%n", days[i], schedule.get(i));
        }

        // ============================================================
        // 12. Collections UTILITY METHODS
        // ============================================================
        System.out.println("\n===== 12. Collections UTILITY METHODS =====");

        ArrayList<Integer> utilList = new ArrayList<>(
                List.of(30, 10, 50, 20, 40, 10, 30, 50));
        System.out.println("List                : " + utilList);

        // sort, reverse, shuffle
        Collections.sort(utilList);
        System.out.println("sort()              : " + utilList);
        Collections.reverse(utilList);
        System.out.println("reverse()           : " + utilList);

        // binarySearch (must be sorted first)
        Collections.sort(utilList);
        int bsIdx = Collections.binarySearch(utilList, 30);
        System.out.println("binarySearch(30)    : index " + bsIdx);

        // frequency
        System.out.println("frequency(10)       : " + Collections.frequency(utilList, 10));
        System.out.println("frequency(50)       : " + Collections.frequency(utilList, 50));

        // min & max
        System.out.println("min()               : " + Collections.min(utilList));
        System.out.println("max()               : " + Collections.max(utilList));

        // fill (replace all with value)
        ArrayList<String> fillList = new ArrayList<>(List.of("A","B","C","D","E"));
        System.out.println("\nBefore fill         : " + fillList);
        Collections.fill(fillList, "X");
        System.out.println("fill(X)             : " + fillList);

        // nCopies — create list of repeated elements
        List<String> copies = Collections.nCopies(5, "Java");
        System.out.println("nCopies(5, Java)    : " + copies);

        // unmodifiableList
        List<String> readOnly = Collections.unmodifiableList(
                new ArrayList<>(List.of("A","B","C")));
        System.out.println("unmodifiableList    : " + readOnly);
        try {
            readOnly.add("D");  // will throw exception
        } catch (UnsupportedOperationException e) {
            System.out.println("✘ Cannot modify unmodifiableList!");
        }

        // disjoint — true if no common elements
        ArrayList<Integer> dl1 = new ArrayList<>(List.of(1,2,3,4));
        ArrayList<Integer> dl2 = new ArrayList<>(List.of(5,6,7,8));
        ArrayList<Integer> dl3 = new ArrayList<>(List.of(3,4,5,6));
        System.out.println("disjoint([1-4],[5-8]): " + Collections.disjoint(dl1,dl2));// true
        System.out.println("disjoint([1-4],[3-6]): " + Collections.disjoint(dl1,dl3));// false

        // ============================================================
        // 13. REAL-WORLD EXAMPLES
        // ============================================================
        System.out.println("\n===== 13. REAL-WORLD EXAMPLES =====");

        // Example 1: Shopping Cart
        System.out.println("--- Shopping Cart ---");
        ArrayList<String>  cartItems   = new ArrayList<>();
        ArrayList<Double>  cartPrices  = new ArrayList<>();
        ArrayList<Integer> cartQtys    = new ArrayList<>();

        cartItems.add("Laptop");  cartPrices.add(75000.0); cartQtys.add(1);
        cartItems.add("Mouse");   cartPrices.add(500.0);   cartQtys.add(2);
        cartItems.add("Keyboard");cartPrices.add(1200.0);  cartQtys.add(1);
        cartItems.add("Monitor"); cartPrices.add(15000.0); cartQtys.add(1);
        cartItems.add("Headset"); cartPrices.add(3000.0);  cartQtys.add(1);

        double cartTotal = 0;
        System.out.printf("  %-12s %10s %5s %12s%n","Item","Price","Qty","Amount");
        sep();
        for (int i = 0; i < cartItems.size(); i++) {
            double amt = cartPrices.get(i) * cartQtys.get(i);
            cartTotal += amt;
            System.out.printf("  %-12s %10.2f %5d %12.2f%n",
                    cartItems.get(i), cartPrices.get(i), cartQtys.get(i), amt);
        }
        sep();
        System.out.printf("  %-28s %12.2f%n", "Total:", cartTotal);
        System.out.printf("  %-28s %12.2f%n", "GST(18%):", cartTotal*0.18);
        System.out.printf("  %-28s %12.2f%n", "Grand Total:", cartTotal*1.18);

        // Remove an item
        int removeIdx = cartItems.indexOf("Mouse");
        cartItems.remove(removeIdx);
        cartPrices.remove(removeIdx);
        cartQtys.remove(removeIdx);
        System.out.println("  After removing Mouse: " + cartItems);

        // Example 2: Student Attendance
        System.out.println("\n--- Student Attendance System ---");
        ArrayList<String>  stuNames2  = new ArrayList<>(
                List.of("Alice","Bob","Charlie","Diana","Eve","Frank"));
        ArrayList<Integer> present    = new ArrayList<>(
                List.of(22,18,25,20,15,23));
        int totalDays = 25;

        System.out.printf("  %-10s %8s %8s %10s%n",
                "Student","Present","Absent","Attendance%");
        sep();
        ArrayList<String> lowAttendance = new ArrayList<>();

        for (int i = 0; i < stuNames2.size(); i++) {
            int absent = totalDays - present.get(i);
            double pct = (double)present.get(i) / totalDays * 100;
            System.out.printf("  %-10s %8d %8d %10.1f%%%n",
                    stuNames2.get(i), present.get(i), absent, pct);
            if (pct < 75) lowAttendance.add(stuNames2.get(i));
        }
        sep();
        System.out.println("  ⚠ Low attendance (<75%): " + lowAttendance);

        // Example 3: Todo List Manager
        System.out.println("\n--- Todo List Manager ---");
        ArrayList<String>  todos   = new ArrayList<>();
        ArrayList<Boolean> done    = new ArrayList<>();

        // Add tasks
        todos.add("Buy groceries");     done.add(false);
        todos.add("Finish Java project");done.add(false);
        todos.add("Call dentist");      done.add(true);
        todos.add("Read book");         done.add(false);
        todos.add("Exercise");          done.add(true);
        todos.add("Pay electricity bill");done.add(false);

        // Display all
        System.out.println("  All Tasks:");
        for (int i = 0; i < todos.size(); i++) {
            System.out.printf("  %2d. [%s] %s%n",
                    i+1, done.get(i) ? "✔" : " ", todos.get(i));
        }

        // Display pending only
        System.out.println("\n  Pending Tasks:");
        for (int i = 0; i < todos.size(); i++)
            if (!done.get(i))
                System.out.println("  → " + todos.get(i));

        // Mark a task done
        int taskIdx = todos.indexOf("Buy groceries");
        done.set(taskIdx, true);
        System.out.println("\n  Marked done: " + todos.get(taskIdx));
        System.out.println("  Pending count: " +
                Collections.frequency(done, false));

        // Example 4: Leaderboard
        System.out.println("\n--- Game Leaderboard ---");
        ArrayList<String>  players = new ArrayList<>(
                List.of("Alice","Bob","Charlie","Diana","Eve"));
        ArrayList<Integer> scores  = new ArrayList<>(
                List.of(4500, 7800, 3200, 9100, 6500));

        // Sort by score descending (maintain parallel lists)
        Integer[] indices = {0,1,2,3,4};
        Arrays.sort(indices, (i, j) -> scores.get(j) - scores.get(i));

        System.out.printf("  %-5s %-12s %8s%n","Rank","Player","Score");
        sep();
        for (int rank = 0; rank < indices.length; rank++) {
            int i = indices[rank];
            String medal = rank == 0 ? "🥇" : rank == 1 ? "🥈" :
                           rank == 2 ? "🥉" : "  ";
            System.out.printf("  %s%-4d %-12s %8d%n",
                    medal, rank+1, players.get(i), scores.get(i));
        }

        System.out.println("\n############################################");
        System.out.println("#      ArrayList in Java — Done! ✔        #");
        System.out.println("############################################");
    }
}

// ── Student class for object ArrayList demo ──
class Student {
    int    id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id    = id;
        this.name  = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("ID:%-4d %-12s Marks: %.1f", id, name, marks);
    }
} 