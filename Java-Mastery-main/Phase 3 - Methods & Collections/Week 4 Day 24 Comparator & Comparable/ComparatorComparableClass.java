/*
 * ============================================================
 *    Comparator AND Comparable IN JAVA - THEORY
 * ============================================================
 *
 * WHY DO WE NEED COMPARISON?
 * ---------------------------
 * Java needs to COMPARE objects to:
 *  - Sort collections (Collections.sort, Arrays.sort)
 *  - Use TreeSet / TreeMap (auto-sorted structures)
 *  - Use PriorityQueue (heap-based priority)
 *  - Find min / max (Collections.min, Collections.max)
 *  - Perform binary search
 *
 * Java provides TWO ways to define comparison logic:
 *  1. Comparable  → object compares ITSELF   (natural order)
 *  2. Comparator  → external comparison      (custom order)
 *
 * ============================================================
 * Comparable INTERFACE
 * ============================================================
 *
 * Package  : java.lang (auto-imported)
 * Method   : int compareTo(T other)
 *
 * When a class implements Comparable, it defines its
 * NATURAL ORDERING — the default way objects of that
 * class should be sorted.
 *
 * Contract:
 *  compareTo(other) returns:
 *   NEGATIVE → this < other  (this comes BEFORE other)
 *   ZERO     → this == other (same position)
 *   POSITIVE → this > other  (this comes AFTER other)
 *
 * Implementation pattern:
 *  @Override
 *  public int compareTo(Student other) {
 *      return this.marks - other.marks;  // ascending
 *  }
 *
 * Classes that implement Comparable:
 *  String, Integer, Double, Date, LocalDate,
 *  BigDecimal, Character, Boolean, Enum, etc.
 *
 * When to use Comparable:
 *  ✔ There is ONE obvious natural ordering
 *  ✔ You OWN the class (can modify it)
 *  ✔ The ordering is permanent (default behavior)
 *  Examples: Student by ID, Employee by empID,
 *            Product by productCode
 *
 * ============================================================
 * Comparator INTERFACE
 * ============================================================
 *
 * Package  : java.util
 * Method   : int compare(T o1, T o2)
 *
 * Comparator is an EXTERNAL comparison strategy.
 * It is separate from the class being compared.
 * Multiple Comparators can exist for the same class.
 *
 * Contract:
 *  compare(o1, o2) returns:
 *   NEGATIVE → o1 < o2  (o1 comes BEFORE o2)
 *   ZERO     → o1 == o2 (same position)
 *   POSITIVE → o1 > o2  (o1 comes AFTER o2)
 *
 * Ways to create Comparator (Java 8+):
 *  1. Anonymous class
 *  2. Lambda expression
 *  3. Method reference
 *  4. Comparator factory methods
 *
 * When to use Comparator:
 *  ✔ Multiple sort orders needed
 *  ✔ You DON'T own the class (can't modify)
 *  ✔ Temporary / context-specific ordering
 *  ✔ Chaining multiple sort criteria
 *
 * ============================================================
 * Comparable vs Comparator — QUICK COMPARISON
 * ============================================================
 *
 *  Feature          Comparable         Comparator
 *  -----------      ---------------    ---------------
 *  Package          java.lang          java.util
 *  Method           compareTo(T)       compare(T,T)
 *  Location         Inside class       Outside class
 *  Sort orders      One (natural)      Many (flexible)
 *  Modifies class   Yes                No
 *  Usage            Collections.sort   Collections.sort
 *                   TreeSet/TreeMap    (list, comparator)
 *  Java 8+          —                  Lambdas, chaining
 *  Example          String, Integer    Custom Comparators
 *
 * ============================================================
 * compareTo() / compare() RETURN VALUE TRICK
 * ============================================================
 *
 *  For NUMBERS:
 *    Ascending  → return this.field - other.field
 *    Descending → return other.field - this.field
 *    Safe way   → Integer.compare(this.field, other.field)
 *
 *  For STRINGS:
 *    Ascending  → return this.name.compareTo(other.name)
 *    Descending → return other.name.compareTo(this.name)
 *
 *  For DOUBLES (⚠ never subtract doubles directly):
 *    → return Double.compare(this.d, other.d)
 *
 * ============================================================
 * Comparator CHAINING (Java 8+)
 * ============================================================
 *
 *  Chain multiple comparators with thenComparing():
 *
 *  Comparator<Employee> comp =
 *      Comparator.comparingInt(Employee::getDept)
 *                .thenComparingDouble(Employee::getSalary)
 *                .thenComparing(Employee::getName);
 *
 *  Factory methods:
 *  comparing(keyExtractor)        → by field
 *  comparingInt(keyExtractor)     → by int field
 *  comparingDouble(keyExtractor)  → by double field
 *  comparingLong(keyExtractor)    → by long field
 *  reversed()                     → flip the order
 *  thenComparing(...)             → secondary sort
 *  naturalOrder()                 → Comparable's order
 *  reverseOrder()                 → reverse natural order
 *  nullsFirst(comparator)         → nulls go first
 *  nullsLast(comparator)          → nulls go last
 *
 * ============================================================
 * CONSISTENCY WITH equals()
 * ============================================================
 *
 *  Best practice: if compareTo() returns 0, equals() = true
 *  (and vice versa).
 *
 *  Violation example (BigDecimal):
 *  new BigDecimal("1.0").compareTo(new BigDecimal("1.00")) = 0
 *  new BigDecimal("1.0").equals(new BigDecimal("1.00"))    = false
 *
 *  TreeSet uses compareTo() for equality, not equals()!
 *  So {1.0, 1.00} in TreeSet → only 1 element!
 *
 * ============================================================
 */

import java.util.*;
import java.util.stream.Collectors;

public class ComparatorComparableClass {

    // ── helpers ──
    static void sep()  { System.out.println("  " + "─".repeat(54)); }
    static void header(String t) {
        System.out.println("\n  ╔════════════════════════════════════════════════╗");
        System.out.printf ("  ║  %-46s║%n", t);
        System.out.println("  ╚════════════════════════════════════════════════╝");
    }
    static void sub(String s) { System.out.println("\n  ── " + s + " ──"); }

    // ── print list of objects ──
    static <T> void printList(String label, List<T> list) {
        System.out.println("  " + label);
        for (int i = 0; i < list.size(); i++)
            System.out.printf("  [%2d] %s%n", i, list.get(i));
    }

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("# Comparator & Comparable IN JAVA          #");
        System.out.println("############################################");

        // ============================================================
        // PART 1 — Comparable
        // ============================================================
        System.out.println("\n\n╔══════════════════════════════════════════╗");
        System.out.println(  "║           PART 1: Comparable              ║");
        System.out.println(  "╚══════════════════════════════════════════╝");

        // ============================================================
        // 1. Built-in Comparable — String, Integer, Double
        // ============================================================
        header("1. Built-in Comparable Classes");

        // String compareTo
        sub("String compareTo()");
        String s1 = "Apple", s2 = "Banana", s3 = "Apple", s4 = "cherry";
        System.out.printf("  %-20s : %d (negative → Apple < Banana)%n",
                "Apple.compareTo(Banana)", s1.compareTo(s2));
        System.out.printf("  %-20s : %d (zero → equal)%n",
                "Apple.compareTo(Apple)", s1.compareTo(s3));
        System.out.printf("  %-20s : %d (positive → Banana > Apple)%n",
                "Banana.compareTo(Apple)", s2.compareTo(s1));
        System.out.printf("  %-20s : %d (uppercase < lowercase)%n",
                "Apple.compareTo(cherry)", s1.compareTo(s4));
        System.out.printf("  %-20s : %d (case-insensitive)%n",
                "compareToIgnoreCase", s1.compareToIgnoreCase(s4));

        // Integer compareTo
        sub("Integer compareTo()");
        Integer i1 = 10, i2 = 20, i3 = 10;
        System.out.printf("  10.compareTo(20)    : %d (negative)%n", i1.compareTo(i2));
        System.out.printf("  10.compareTo(10)    : %d (zero)%n",     i1.compareTo(i3));
        System.out.printf("  20.compareTo(10)    : %d (positive)%n", i2.compareTo(i1));
        System.out.printf("  Integer.compare(5,9): %d%n", Integer.compare(5,9));
        System.out.printf("  Double.compare(3,3) : %d%n", Double.compare(3.0, 3.0));

        // Sorting built-in types
        sub("Sorting with Natural Order (Comparable)");
        List<String> fruits = new ArrayList<>(
                Arrays.asList("Mango","Apple","Cherry","Banana","Date","Avocado"));
        List<Integer> nums = new ArrayList<>(
                Arrays.asList(64,25,12,34,90,11,45));

        System.out.println("  Strings before  : " + fruits);
        Collections.sort(fruits);  // uses compareTo()
        System.out.println("  Strings sorted  : " + fruits);

        System.out.println("  Numbers before  : " + nums);
        Collections.sort(nums);
        System.out.println("  Numbers sorted  : " + nums);

        // TreeSet uses Comparable automatically
        sub("TreeSet — Uses Comparable Automatically");
        TreeSet<String> ts = new TreeSet<>(
                Arrays.asList("Banana","Apple","Cherry","Avocado","Date"));
        System.out.println("  TreeSet<String> : " + ts); // auto-sorted

        TreeSet<Integer> ti = new TreeSet<>(
                Arrays.asList(5,3,8,1,9,2,7,4,6));
        System.out.println("  TreeSet<Integer>: " + ti); // auto-sorted

        // ============================================================
        // 2. Implementing Comparable in Custom Class
        // ============================================================
        header("2. Custom Class Implementing Comparable");

        sub("Student sorted by marks (natural order)");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(103, "Charlie", 95.5, "CS"),
                new Student(101, "Alice",   88.0, "Math"),
                new Student(105, "Eve",     72.5, "CS"),
                new Student(102, "Bob",     92.0, "Physics"),
                new Student(104, "Diana",   85.5, "Math")
        ));
        System.out.println("  Before sort (natural order = by marks):");
        students.forEach(s -> System.out.println("    " + s));
        Collections.sort(students);   // uses Student.compareTo()
        System.out.println("  After  sort:");
        students.forEach(s -> System.out.println("    " + s));

        // TreeSet with Comparable
        sub("TreeSet<Student> — Uses Comparable");
        TreeSet<Student> stuTree = new TreeSet<>(students);
        System.out.println("  TreeSet (auto-sorted by marks):");
        stuTree.forEach(s -> System.out.println("    " + s));
        System.out.println("  first() : " + stuTree.first());
        System.out.println("  last()  : " + stuTree.last());

        // PriorityQueue with Comparable
        sub("PriorityQueue<Student> — Uses Comparable");
        PriorityQueue<Student> stuPQ = new PriorityQueue<>(students);
        System.out.println("  PQ peek (lowest marks): " + stuPQ.peek());
        System.out.println("  Drain order:");
        PriorityQueue<Student> pqCopy = new PriorityQueue<>(stuPQ);
        while (!pqCopy.isEmpty())
            System.out.println("    " + pqCopy.poll());

        // ============================================================
        // 3. Comparable with multiple fields
        // ============================================================
        header("3. Comparable — Multi-Field Comparison");

        sub("Employee sorted by dept, then salary, then name");
        List<Employee> emps = new ArrayList<>(Arrays.asList(
                new Employee(1, "Charlie", "Engineering", 85000),
                new Employee(2, "Alice",   "Marketing",   72000),
                new Employee(3, "Bob",     "Engineering", 92000),
                new Employee(4, "Diana",   "HR",          68000),
                new Employee(5, "Eve",     "Marketing",   78000),
                new Employee(6, "Frank",   "Engineering", 85000),
                new Employee(7, "Grace",   "HR",          71000)
        ));
        System.out.println("  Before sort:");
        emps.forEach(e -> System.out.println("    " + e));
        Collections.sort(emps);
        System.out.println("  After sort (dept → salary → name):");
        emps.forEach(e -> System.out.println("    " + e));

        // compareTo consistency with equals
        sub("compareTo() consistency with equals()");
        Employee e1 = new Employee(10,"Alice","Eng",80000);
        Employee e2 = new Employee(11,"Alice","Eng",80000);
        Employee e3 = new Employee(12,"Bob",  "Eng",80000);
        System.out.printf("  e1.compareTo(e2): %d (same dept+salary+name)%n",
                e1.compareTo(e2));
        System.out.printf("  e1.compareTo(e3): %d (Alice < Bob)%n",
                e1.compareTo(e3));

        // ============================================================
        // PART 2 — Comparator
        // ============================================================
        System.out.println("\n\n╔══════════════════════════════════════════╗");
        System.out.println(  "║           PART 2: Comparator              ║");
        System.out.println(  "╚══════════════════════════════════════════╝");

        // ============================================================
        // 4. Comparator — 4 ways to create
        // ============================================================
        header("4. Creating Comparators — 4 Ways");

        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Laptop",  75000, 4.2, 15),
                new Product("Phone",   25000, 4.5, 42),
                new Product("Tablet",  35000, 4.0,  8),
                new Product("Monitor", 18000, 4.3, 23),
                new Product("Keyboard", 1500, 4.7, 67),
                new Product("Mouse",     800, 4.1, 34),
                new Product("Headset",  3000, 4.6,  5)
        ));

        // Way 1: Anonymous class
        sub("Way 1: Anonymous Class");
        Comparator<Product> byPriceAnon = new Comparator<Product>() {
            @Override
            public int compare(Product a, Product b) {
                return Double.compare(a.price, b.price);
            }
        };
        List<Product> sorted1 = new ArrayList<>(products);
        sorted1.sort(byPriceAnon);
        System.out.println("  Sort by price (anon class):");
        sorted1.forEach(p -> System.out.printf(
                "  %-12s ₹%8.0f%n", p.name, p.price));

        // Way 2: Lambda expression
        sub("Way 2: Lambda Expression");
        Comparator<Product> byRatingLambda =
                (a, b) -> Double.compare(b.rating, a.rating); // desc
        List<Product> sorted2 = new ArrayList<>(products);
        sorted2.sort(byRatingLambda);
        System.out.println("  Sort by rating desc (lambda):");
        sorted2.forEach(p -> System.out.printf(
                "  %-12s ★%.1f%n", p.name, p.rating));

        // Way 3: Method reference
        sub("Way 3: Method Reference");
        Comparator<Product> byNameRef =
                Comparator.comparing(Product::getName);
        List<Product> sorted3 = new ArrayList<>(products);
        sorted3.sort(byNameRef);
        System.out.println("  Sort by name (method ref):");
        sorted3.forEach(p -> System.out.printf(
                "  %-12s%n", p.name));

        // Way 4: Comparator factory methods
        sub("Way 4: Comparator Factory Methods (Java 8+)");
        Comparator<Product> byStock =
                Comparator.comparingInt(p -> p.stock);
        List<Product> sorted4 = new ArrayList<>(products);
        sorted4.sort(byStock);
        System.out.println("  Sort by stock asc (factory):");
        sorted4.forEach(p -> System.out.printf(
                "  %-12s stock=%-4d%n", p.name, p.stock));

        // ============================================================
        // 5. Comparator CHAINING with thenComparing()
        // ============================================================
        header("5. Comparator CHAINING — thenComparing()");

        sub("Sort by department, then salary desc, then name");
        List<Employee> emps2 = new ArrayList<>(Arrays.asList(
                new Employee(1,"Charlie","Engineering",85000),
                new Employee(2,"Alice",  "Marketing",  72000),
                new Employee(3,"Bob",    "Engineering",92000),
                new Employee(4,"Diana",  "HR",         68000),
                new Employee(5,"Eve",    "Marketing",  78000),
                new Employee(6,"Frank",  "Engineering",85000),
                new Employee(7,"Grace",  "HR",         71000),
                new Employee(8,"Henry",  "Marketing",  72000)
        ));

        Comparator<Employee> chainedComp =
                Comparator.comparing((Employee e) -> e.dept)          // 1st: dept asc
                          .thenComparingDouble(e -> -e.salary)        // 2nd: salary desc
                          .thenComparing(e -> e.name);                // 3rd: name asc

        emps2.sort(chainedComp);
        System.out.printf("  %-12s %-15s %10s%n", "Name","Department","Salary");
        sep();
        emps2.forEach(e -> System.out.printf(
                "  %-12s %-15s %10.0f%n", e.name, e.dept, e.salary));

        // Chain on primitive types
        sub("Multi-criteria Product Sort");
        Comparator<Product> multiComp =
                Comparator.comparingDouble((Product p) -> p.rating).reversed()  // rating desc
                          .thenComparingDouble(p -> p.price)                    // price asc
                          .thenComparing(p -> p.name);                          // name asc

        List<Product> multiSorted = new ArrayList<>(products);
        multiSorted.sort(multiComp);
        System.out.printf("  %-12s %8s %8s %6s%n","Name","Price","Rating","Stock");
        sep();
        multiSorted.forEach(p -> System.out.printf(
                "  %-12s %8.0f %8.1f %6d%n",
                p.name, p.price, p.rating, p.stock));

        // ============================================================
        // 6. Comparator.reversed()
        // ============================================================
        header("6. reversed() — Flip Sort Order");

        List<Student> stuList = new ArrayList<>(Arrays.asList(
                new Student(3,"Charlie",95.5,"CS"),
                new Student(1,"Alice",  88.0,"Math"),
                new Student(5,"Eve",    72.5,"CS"),
                new Student(2,"Bob",    92.0,"Physics"),
                new Student(4,"Diana",  85.5,"Math")
        ));

        // Natural order (ascending marks)
        Collections.sort(stuList);
        System.out.println("  Ascending  marks: "
                + stuList.stream().map(s->s.name+"("+s.marks+")").collect(Collectors.joining(", ")));

        // Reversed (descending marks)
        stuList.sort(Comparator.comparingDouble((Student s)->s.marks).reversed());
        System.out.println("  Descending marks: "
                + stuList.stream().map(s->s.name+"("+s.marks+")").collect(Collectors.joining(", ")));

        // Reverse string natural order
        List<String> strList = new ArrayList<>(
                Arrays.asList("Banana","Apple","Cherry","Date","Elderberry"));
        strList.sort(Comparator.reverseOrder());
        System.out.println("  Strings reversed: " + strList);

        // Double reverse = original order (natural order)
        strList.sort(Comparator.naturalOrder());
        System.out.println("  Double reversed : " + strList);

        // ============================================================
        // 7. Comparator.naturalOrder() & reverseOrder()
        // ============================================================
        header("7. naturalOrder() & reverseOrder()");

        List<Integer> numList = new ArrayList<>(
                Arrays.asList(5,2,8,1,9,3,7,4,6));
        System.out.println("  Original        : " + numList);

        numList.sort(Comparator.naturalOrder());
        System.out.println("  naturalOrder()  : " + numList);

        numList.sort(Comparator.reverseOrder());
        System.out.println("  reverseOrder()  : " + numList);

        // With Collections.sort
        Collections.sort(numList, Collections.reverseOrder());
        System.out.println("  Collections.rev : " + numList);

        // ============================================================
        // 8. nullsFirst() & nullsLast()
        // ============================================================
        header("8. nullsFirst() & nullsLast()");

        List<String> nullableList = new ArrayList<>(
                Arrays.asList("Banana", null, "Apple", null, "Cherry", "Date"));
        System.out.println("  Original        : " + nullableList);

        // nullsFirst
        nullableList.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("  nullsFirst()    : " + nullableList);

        // nullsLast
        nullableList.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println("  nullsLast()     : " + nullableList);

        // nullsFirst with reverseOrder
        nullableList.sort(
                Comparator.nullsFirst(Comparator.reverseOrder()));
        System.out.println("  nullsFirst+rev  : " + nullableList);

        // Nullable custom objects
        sub("nullsFirst with Custom Objects");
        List<Student> nullStudents = new ArrayList<>(Arrays.asList(
                new Student(1,"Alice",88,"CS"),
                null,
                new Student(2,"Bob",92,"Math"),
                null,
                new Student(3,"Charlie",75,"CS")
        ));
        System.out.println("  Before          : " + nullStudents);
        nullStudents.sort(Comparator.nullsLast(
                Comparator.comparingDouble(s -> s.marks)));
        System.out.println("  nullsLast(marks): " + nullStudents);

        // ============================================================
        // 9. Comparator.comparing() with Key Extractor
        // ============================================================
        header("9. Comparator.comparing() Key Extractor");

        sub("comparing(Function)");
        List<String> words = new ArrayList<>(
                Arrays.asList("banana","Fig","apple","CHERRY","date","elderberry"));
        System.out.println("  Original        : " + words);

        // Compare ignoring case
        words.sort(Comparator.comparing(String::toLowerCase));
        System.out.println("  Case-insensitive: " + words);

        // Compare by last character
        words.sort(Comparator.comparing(w -> w.charAt(w.length()-1)));
        System.out.println("  By last char    : " + words);

        // Compare by string length then content
        words.sort(Comparator.comparingInt(String::length)
                             .thenComparing(Comparator.naturalOrder()));
        System.out.println("  Len then alpha  : " + words);

        // comparingInt / comparingDouble / comparingLong
        sub("comparingInt / comparingDouble / comparingLong");
        List<Product> pList = new ArrayList<>(products);

        pList.sort(Comparator.comparingInt(p -> p.stock));
        System.out.println("  comparingInt(stock):");
        pList.forEach(p -> System.out.printf(
                "  %-12s stock=%d%n", p.name, p.stock));

        pList.sort(Comparator.comparingDouble(p -> p.rating));
        System.out.println("  comparingDouble(rating):");
        pList.forEach(p -> System.out.printf(
                "  %-12s rating=%.1f%n", p.name, p.rating));

        // ============================================================
        // 10. Passing Comparator to Collections
        // ============================================================
        header("10. Comparator in Collections & Data Structures");

        // Collections.sort with Comparator
        sub("Collections.sort(list, comparator)");
        List<String> colList = new ArrayList<>(
                Arrays.asList("Banana","Apple","Cherry","Date","Elderberry","Fig"));
        System.out.println("  Before          : " + colList);
        Collections.sort(colList, (a,b)->b.compareTo(a)); // desc
        System.out.println("  Desc sort       : " + colList);

        // Collections.min / max with Comparator
        sub("Collections.min() / max() with Comparator");
        List<Student> sList = new ArrayList<>(stuList);
        Student topMark   = Collections.max(sList,
                Comparator.comparingDouble(s->s.marks));
        Student youngest  = Collections.min(sList,
                Comparator.comparingInt(s->s.id));
        System.out.println("  Top marks       : " + topMark);
        System.out.println("  First (by ID)   : " + youngest);

        // TreeSet with custom Comparator
        sub("TreeSet with Custom Comparator");
        TreeSet<Student> byNameTree = new TreeSet<>(
                Comparator.comparing(s->s.name));
        byNameTree.addAll(stuList);
        System.out.println("  TreeSet by name :");
        byNameTree.forEach(s -> System.out.println(
                "  " + s.name + " (" + s.marks + ")"));

        // TreeMap with custom Comparator
        sub("TreeMap with Custom Comparator");
        TreeMap<String,Integer> descMap = new TreeMap<>(
                Comparator.reverseOrder());
        descMap.put("Banana",3); descMap.put("Apple",1);
        descMap.put("Cherry",2); descMap.put("Date",4);
        System.out.println("  TreeMap desc    : " + descMap);

        // PriorityQueue with Comparator
        sub("PriorityQueue with Comparator");
        PriorityQueue<Employee> empPQ = new PriorityQueue<>(
                Comparator.comparingDouble((Employee e)->-e.salary));
        emps2.forEach(empPQ::offer);
        System.out.println("  Max-salary PQ:");
        PriorityQueue<Employee> pqE = new PriorityQueue<>(empPQ);
        while (!pqE.isEmpty()) {
            Employee e = pqE.poll();
            System.out.printf("  %-12s ₹%.0f%n", e.name, e.salary);
        }

        // ============================================================
        // 11. Comparator vs Comparable — Side-by-Side
        // ============================================================
        header("11. Comparable vs Comparator — Side-by-Side");

        List<Book> books = new ArrayList<>(Arrays.asList(
                new Book("Clean Code",      "Robert Martin",  2008, 45.99),
                new Book("Effective Java",  "Joshua Bloch",   2018, 55.00),
                new Book("Design Patterns", "Gang of Four",   1994, 60.00),
                new Book("Pragmatic Prog",  "Andy Hunt",      1999, 42.50),
                new Book("Refactoring",     "Martin Fowler",  2018, 50.00),
                new Book("Clean Arch",      "Robert Martin",  2017, 48.00)
        ));

        sub("Comparable — Natural Order (by year)");
        Collections.sort(books);
        books.forEach(b -> System.out.printf(
                "  %-20s %-16s %d%n", b.title, b.author, b.year));

        sub("Comparator — By price ascending");
        Comparator<Book> byPrice =
                Comparator.comparingDouble(b -> b.price);
        books.sort(byPrice);
        books.forEach(b -> System.out.printf(
                "  %-20s $%.2f%n", b.title, b.price));

        sub("Comparator — By author then title");
        books.sort(Comparator.comparing((Book b) -> b.author)
                             .thenComparing(b -> b.title));
        books.forEach(b -> System.out.printf(
                "  %-18s by %-16s%n", b.title, b.author));

        sub("Comparator — By year desc, then price asc");
        books.sort(Comparator.comparingInt((Book b) -> b.year).reversed()
                             .thenComparingDouble(b -> b.price));
        books.forEach(b -> System.out.printf(
                "  %-20s %d  $%.2f%n", b.title, b.year, b.price));

        // ============================================================
        // 12. REAL-WORLD EXAMPLES
        // ============================================================
        header("12. REAL-WORLD EXAMPLES");

        // Example 1: E-commerce Product Sorter
        System.out.println("  ── E-commerce Product Sorter ──");
        ecommerceSorter(products);

        // Example 2: Student Ranker
        System.out.println("\n  ── Student Ranker ──");
        studentRanker();

        // Example 3: Employee HR System
        System.out.println("\n  ── Employee HR System ──");
        employeeHRSystem();

        // Example 4: Flight Scheduler
        System.out.println("\n  ── Flight Scheduler ──");
        flightScheduler();

        // Example 5: Sports Leaderboard
        System.out.println("\n  ── Sports Leaderboard ──");
        sportsLeaderboard();

        System.out.println("\n############################################");
        System.out.println("# Comparator & Comparable — Done! ✔       #");
        System.out.println("############################################");
    }

    // ============================================================
    // REAL-WORLD METHODS
    // ============================================================

    static void ecommerceSorter(List<Product> products) {
        System.out.println("  Products:");
        System.out.printf("  %-12s %8s %6s %5s%n",
                "Name","Price","Rating","Stock");
        sep();
        products.forEach(p -> System.out.printf(
                "  %-12s %8.0f %6.1f %5d%n",
                p.name, p.price, p.rating, p.stock));

        String[] sorts = {
            "Cheapest first",
            "Most expensive first",
            "Top rated first",
            "Best value (rating/price)"
        };
        @SuppressWarnings("unchecked")
        Comparator<Product>[] comps = new Comparator[]{
            Comparator.comparingDouble((Product p)->p.price),
            Comparator.comparingDouble((Product p)->-p.price),
            Comparator.comparingDouble((Product p)->-p.rating),
            Comparator.comparingDouble((Product p)->-(p.rating/p.price*10000))
        };

        for (int i = 0; i < sorts.length; i++) {
            List<Product> sorted = new ArrayList<>(products);
            sorted.sort(comps[i]);
            System.out.printf("%n  Sort: %s%n", sorts[i]);
            sorted.forEach(p -> System.out.printf(
                    "  %-12s ₹%8.0f  ★%.1f%n", p.name, p.price, p.rating));
        }
    }

    static void studentRanker() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Alice",   92.5, "CS"),
                new Student(2, "Bob",     78.0, "Math"),
                new Student(3, "Charlie", 95.5, "CS"),
                new Student(4, "Diana",   92.5, "Physics"),
                new Student(5, "Eve",     85.0, "Math"),
                new Student(6, "Frank",   78.0, "CS"),
                new Student(7, "Grace",   95.5, "Math")
        ));

        // Rank by marks desc, then name asc (for ties)
        students.sort(Comparator.comparingDouble((Student s) -> -s.marks)
                                .thenComparing(s -> s.name));

        System.out.printf("  %-4s %-12s %8s %-10s%s%n",
                "Rank","Name","Marks","Dept","Note");
        sep();
        int rank = 1;
        double prevMarks = -1;
        int    sameRank  = rank;
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.marks != prevMarks) { sameRank = rank; }
            String note = s.marks == 95.5 ? " 🏆 Tied 1st" :
                          s.marks == 92.5 ? " 🥈 Tied"     :
                          s.marks == 78.0 ? " Tied"         : "";
            System.out.printf("  #%-3d %-12s %8.1f %-10s%s%n",
                    sameRank, s.name, s.marks, s.dept, note);
            prevMarks = s.marks;
            rank++;
        }

        // Statistics
        Student top    = Collections.max(students, Comparator.comparingDouble(s->s.marks));
        Student lowest = Collections.min(students, Comparator.comparingDouble(s->s.marks));
        System.out.println("  Top scorer      : " + top.name    + " (" + top.marks + ")");
        System.out.println("  Lowest scorer   : " + lowest.name + " (" + lowest.marks + ")");
    }

    static void employeeHRSystem() {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(1,"Alice",   "Engineering",95000),
                new Employee(2,"Bob",     "Marketing",  68000),
                new Employee(3,"Charlie", "Engineering",87000),
                new Employee(4,"Diana",   "HR",         72000),
                new Employee(5,"Eve",     "Marketing",  75000),
                new Employee(6,"Frank",   "Engineering",95000),
                new Employee(7,"Grace",   "HR",         68000),
                new Employee(8,"Henry",   "Marketing",  80000)
        ));

        // Group by department, sort by salary desc within group
        Comparator<Employee> hrComp =
                Comparator.comparing((Employee e)->e.dept)
                          .thenComparingDouble(e->-e.salary)
                          .thenComparing(e->e.name);
        employees.sort(hrComp);

        System.out.printf("  %-12s %-15s %10s%n","Name","Department","Salary");
        sep();
        String prevDept = "";
        for (Employee e : employees) {
            if (!e.dept.equals(prevDept)) {
                System.out.println("  [" + e.dept + "]");
                prevDept = e.dept;
            }
            System.out.printf("  %-12s %-15s %10.0f%n",
                    e.name, e.dept, e.salary);
        }

        // Dept salary stats using Comparators
        sep();
        Employee highest = Collections.max(employees,
                Comparator.comparingDouble(e->e.salary));
        Employee lowest  = Collections.min(employees,
                Comparator.comparingDouble(e->e.salary));
        System.out.println("  Highest paid    : "
                + highest.name + " ₹" + highest.salary);
        System.out.println("  Lowest  paid    : "
                + lowest.name  + " ₹" + lowest.salary);
    }

    static void flightScheduler() {
        List<Flight> flights = new ArrayList<>(Arrays.asList(
                new Flight("AI201","Mumbai",  "Delhi",  "06:30", 3500, 180),
                new Flight("6E102","Mumbai",  "Kolkata","07:15", 4200, 120),
                new Flight("SG301","Delhi",   "Mumbai", "08:00", 2800, 200),
                new Flight("AI302","Chennai", "Delhi",  "06:45", 5100,  95),
                new Flight("6E203","Delhi",   "Chennai","07:30", 3900, 150),
                new Flight("SG402","Kolkata", "Mumbai", "08:30", 4500, 110),
                new Flight("AI103","Mumbai",  "Delhi",  "09:00", 3200, 180)
        ));

        // Sort by departure time, then price
        Comparator<Flight> flightComp =
                Comparator.comparing((Flight f)->f.departure)
                          .thenComparingDouble(f->f.price);
        flights.sort(flightComp);

        System.out.printf("  %-8s %-10s %-10s %-8s %8s %5s%n",
                "Flight","From","To","Depart","Price","Seats");
        sep();
        flights.forEach(f -> System.out.printf(
                "  %-8s %-10s %-10s %-8s %8.0f %5d%n",
                f.flightNo, f.from, f.to, f.departure, f.price, f.seats));

        // Find cheapest and earliest
        Flight cheapest = Collections.min(flights,
                Comparator.comparingDouble(f->f.price));
        Flight earliest = Collections.min(flights,
                Comparator.comparing(f->f.departure));
        System.out.println("  Cheapest flight : " + cheapest.flightNo
                + " ₹" + cheapest.price);
        System.out.println("  Earliest flight : " + earliest.flightNo
                + " at " + earliest.departure);
    }

    static void sportsLeaderboard() {
        List<Athlete> athletes = new ArrayList<>(Arrays.asList(
                new Athlete("Alice",   "100m", 10.85, 3),
                new Athlete("Bob",     "100m", 10.92, 1),
                new Athlete("Charlie", "100m", 10.78, 5),
                new Athlete("Diana",   "100m", 10.85, 2),
                new Athlete("Eve",     "100m", 11.02, 4),
                new Athlete("Frank",   "100m", 10.78, 6)
        ));

        // Sort: time asc (lower = faster), then wins desc, then name
        Comparator<Athlete> sportComp =
                Comparator.comparingDouble((Athlete a)->a.time)
                          .thenComparingInt(a->-a.wins)
                          .thenComparing(a->a.name);
        athletes.sort(sportComp);

        System.out.printf("  %-5s %-12s %8s %5s%n",
                "Pos","Athlete","Time(s)","Wins");
        sep();
        for (int i = 0; i < athletes.size(); i++) {
            Athlete a = athletes.get(i);
            String medal = i==0?"🥇":i==1?"🥈":i==2?"🥉":"  ";
            System.out.printf("  %s%-4d %-12s %8.2f %5d%n",
                    medal, i+1, a.name, a.time, a.wins);
        }
        // Stats
        Athlete fastest  = Collections.min(athletes,
                Comparator.comparingDouble(a->a.time));
        Athlete mostWins = Collections.max(athletes,
                Comparator.comparingInt(a->a.wins));
        System.out.println("  Fastest time    : " + fastest.name
                + " (" + fastest.time + "s)");
        System.out.println("  Most wins       : " + mostWins.name
                + " (" + mostWins.wins + " wins)");
    }
}

// ============================================================
// DOMAIN CLASSES
// ============================================================

// Student — implements Comparable (natural: ascending marks)
class Student implements Comparable<Student> {
    int    id;
    String name;
    double marks;
    String dept;

    Student(int id, String name, double marks, String dept) {
        this.id=id; this.name=name; this.marks=marks; this.dept=dept;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.marks, other.marks); // ascending
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', marks=%.1f, dept='%s'}",
                id, name, marks, dept);
    }
}

// Employee — implements Comparable (dept → salary → name)
class Employee implements Comparable<Employee> {
    int    id;
    String name;
    String dept;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id=id; this.name=name; this.dept=dept; this.salary=salary;
    }

    @Override
    public int compareTo(Employee other) {
        int deptCmp = this.dept.compareTo(other.dept);
        if (deptCmp != 0) return deptCmp;
        int salCmp  = Double.compare(this.salary, other.salary);
        if (salCmp  != 0) return salCmp;
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return String.format("Employee{%s, %s, ₹%.0f}", name, dept, salary);
    }
}

// Product — no Comparable, uses Comparators
class Product {
    String name;
    double price;
    double rating;
    int    stock;

    Product(String name, double price, double rating, int stock) {
        this.name=name; this.price=price;
        this.rating=rating; this.stock=stock;
    }

    public String getName()   { return name;   }
    public double getPrice()  { return price;  }
    public double getRating() { return rating; }
    public int    getStock()  { return stock;  }

    @Override
    public String toString() {
        return String.format("Product{%s, ₹%.0f, ★%.1f, stock=%d}",
                name, price, rating, stock);
    }
}

// Book — implements Comparable (natural: by year)
class Book implements Comparable<Book> {
    String title;
    String author;
    int    year;
    double price;

    Book(String title, String author, int year, double price) {
        this.title=title; this.author=author;
        this.year=year; this.price=price;
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.year, other.year); // ascending year
    }

    @Override
    public String toString() {
        return String.format("Book{'%s' by %s, %d, $%.2f}",
                title, author, year, price);
    }
}

// Flight — no Comparable, uses Comparators
class Flight {
    String flightNo, from, to, departure;
    double price;
    int    seats;

    Flight(String fn, String fr, String t, String dep, double pr, int s) {
        flightNo=fn; from=fr; to=t;
        departure=dep; price=pr; seats=s;
    }
}

// Athlete — no Comparable, uses Comparators
class Athlete {
    String name, event;
    double time;
    int    wins;

    Athlete(String n, String ev, double t, int w) {
        name=n; event=ev; time=t; wins=w;
    }
}