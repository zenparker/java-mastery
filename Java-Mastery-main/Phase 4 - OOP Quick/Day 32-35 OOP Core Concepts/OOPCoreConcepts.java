/*
 * ============================================================
 *      OOP CORE CONCEPTS IN JAVA — COMPLETE THEORY
 * ============================================================
 *
 * This file covers the ADVANCED/CORE OOP concepts:
 *
 *  1.  Inheritance (deep dive)
 *  2.  Method Overriding (deep dive)
 *  3.  super keyword (all uses)
 *  4.  Abstract Classes (deep dive)
 *  5.  Interfaces (deep dive)
 *  6.  Polymorphism (deep dive)
 *  7.  Encapsulation (deep dive)
 *  8.  final keyword (all uses)
 *  9.  instanceof & Pattern Matching
 *  10. Inner Classes (all 4 types)
 *  11. Enum (full coverage)
 *  12. Generics (basics)
 *  13. Anonymous Classes
 *  14. Covariant Return Types
 *  15. Object class deep dive
 *
 * ============================================================
 * INHERITANCE — DEEP DIVE
 * ============================================================
 *
 *  IS-A relationship between classes.
 *  Child gets ALL non-private members of parent.
 *
 *  Constructor chain during object creation:
 *   new Child()
 *   → Child() calls super() (implicitly or explicitly)
 *   → Parent() called first
 *   → Parent init completes
 *   → Child init completes
 *
 *  Object creation order:
 *   1. Static blocks (parent first, then child) — class load
 *   2. Parent instance block
 *   3. Parent constructor
 *   4. Child instance block
 *   5. Child constructor
 *
 * ============================================================
 * METHOD OVERRIDING — RULES
 * ============================================================
 *
 *  ✔ Same method name
 *  ✔ Same parameter list (exact match)
 *  ✔ Return type: same OR covariant (subtype)
 *  ✔ Access: same or WIDER (public > protected > default)
 *  ✔ Exceptions: can throw FEWER or NARROWER checked exceptions
 *  ✔ @Override annotation recommended
 *
 *  CANNOT override:
 *  ✘ private methods   (not inherited)
 *  ✘ static methods    (hidden, not overridden)
 *  ✘ final methods     (sealed)
 *  ✘ constructors      (not methods)
 *
 * ============================================================
 * ABSTRACT CLASS — DEEP DIVE
 * ============================================================
 *
 *  - Declared with 'abstract' keyword
 *  - Can have: abstract methods, concrete methods,
 *              constructors, fields, static members
 *  - Cannot be instantiated
 *  - Subclass must implement ALL abstract methods
 *    OR be declared abstract itself
 *  - Can implement interfaces partially
 *
 *  Use when:
 *  ✔ IS-A relationship with shared state/behavior
 *  ✔ Base behavior + enforced contract
 *  ✔ Template Method pattern
 *
 * ============================================================
 * INTERFACE — DEEP DIVE
 * ============================================================
 *
 *  Java 7 and before:
 *  - public abstract methods only
 *  - public static final fields only
 *
 *  Java 8+:
 *  - default methods (with body)
 *  - static methods (with body)
 *
 *  Java 9+:
 *  - private methods
 *  - private static methods
 *
 *  A class can implement MULTIPLE interfaces.
 *  An interface can extend MULTIPLE interfaces.
 *
 *  Diamond problem resolution:
 *  If two interfaces have same default method,
 *  implementing class MUST override it.
 *
 * ============================================================
 * INNER CLASSES — ALL TYPES
 * ============================================================
 *
 *  1. Static Nested Class
 *     - Declared static inside outer class
 *     - Does NOT need outer class instance
 *     - Can access outer static members only
 *     - Access: OuterClass.InnerClass obj = new OuterClass.InnerClass();
 *
 *  2. Non-Static Inner Class (Member Inner Class)
 *     - Declared without static inside outer class
 *     - NEEDS outer class instance to exist
 *     - Can access ALL outer class members (including private)
 *     - Access: OuterClass.InnerClass obj = outer.new InnerClass();
 *
 *  3. Local Inner Class
 *     - Defined inside a METHOD
 *     - Scope: only within that method
 *     - Can access effectively final local variables
 *
 *  4. Anonymous Inner Class
 *     - No name, defined and instantiated in one expression
 *     - Used for one-time implementations
 *     - Common with Runnable, Comparator, listeners
 *
 * ============================================================
 * ENUM — DEEP DIVE
 * ============================================================
 *
 *  - Special class representing fixed set of constants
 *  - Implicitly extends java.lang.Enum
 *  - Cannot be extended or instantiated with new
 *  - Can have fields, constructors, methods
 *  - Each constant is a public static final instance
 *
 *  Built-in methods:
 *  - values()   → array of all constants
 *  - valueOf(s) → constant by name
 *  - name()     → constant name as String
 *  - ordinal()  → zero-based position
 *  - compareTo()→ compares ordinals
 *
 * ============================================================
 * GENERICS — BASICS
 * ============================================================
 *
 *  Type-safe parameterized types.
 *  Eliminates casting and ClassCastException.
 *
 *  Syntax:
 *  class Box<T> { T value; }
 *  Box<String> box = new Box<>();
 *
 *  Type parameters convention:
 *  T → Type
 *  E → Element (collections)
 *  K → Key
 *  V → Value
 *  N → Number
 *  ? → Wildcard
 *
 *  Bounded types:
 *  <T extends Number>  → T must be Number or subtype
 *  <T super Integer>   → T must be Integer or supertype
 *  <?> wildcard        → any type
 *
 * ============================================================
 */

import java.util.*;
import java.util.function.*;

public class OOPCoreConcepts {

    static void sep()  { System.out.println("  " + "─".repeat(56)); }
    static void header(String t) {
        System.out.println(
            "\n  ╔══════════════════════════════════════════════════╗");
        System.out.printf(
            "  ║  %-48s║%n", t);
        System.out.println(
            "  ╚══════════════════════════════════════════════════╝");
    }
    static void sub(String s) {
        System.out.println("\n  ── " + s + " ──");
    }
    static void pillar(String s) {
        System.out.println(
            "\n╔════════════════════════════════════════════════════╗");
        System.out.printf(
            "║  %-50s║%n", s);
        System.out.println(
            "╚════════════════════════════════════════════════════╝");
    }

    public static void main(String[] args) {

        System.out.println(
            "##################################################");
        System.out.println(
            "#      OOP CORE CONCEPTS IN JAVA                #");
        System.out.println(
            "##################################################");

        // ════════════════════════════════════════════════════
        // 1. INHERITANCE — DEEP DIVE
        // ════════════════════════════════════════════════════
        pillar("1. INHERITANCE — DEEP DIVE");

        header("Object Creation Order");

        sub("Static → Instance block → Constructor (parent first)");
        System.out.println("  Creating new GrandChild()...");
        GrandChild gc = new GrandChild();
        System.out.println("  Object: " + gc);

        header("Constructor Chaining with super()");

        sub("Every constructor implicitly calls super()");
        System.out.println("  new Derived('Derived'):");
        Derived derived = new Derived("Derived");
        System.out.println("  " + derived);

        sub("Explicit super() with params");
        System.out.println("  new ColoredShape('Circle','Red',5.0):");
        ColoredShape cs = new ColoredShape("Circle","Red",5.0);
        System.out.println("  " + cs);

        header("Inheritance Chain — Method Resolution");

        sub("Method lookup: child → parent → grandparent → Object");
        Animal2 a = new Dog2("Rex","Labrador");
        System.out.println("  Dog2 toString   : " + a);
        a.breathe();      // inherited from Animal2
        a.makeSound();    // overridden in Dog2
        a.move();         // overridden in Dog2

        sub("Calling overridden parent method via super");
        Dog2 dog2 = new Dog2("Buddy","Poodle");
        dog2.fullIntro();

        header("What IS and IS NOT Inherited");

        System.out.println("  Inherited:");
        System.out.println("  ✔ public fields & methods");
        System.out.println("  ✔ protected fields & methods");
        System.out.println("  ✔ package-private (same package)");
        System.out.println("  ✔ static fields & methods (accessible, not overridden)");
        System.out.println();
        System.out.println("  NOT Inherited:");
        System.out.println("  ✘ private fields & methods");
        System.out.println("  ✘ constructors");
        System.out.println("  ✘ final class cannot be subclassed");

        header("Hiding vs Overriding — static methods");

        sub("static methods are HIDDEN, not overridden");
        Parent2 ref = new Child2();
        System.out.println("  ref type        : " + ref.getClass().getSimpleName());
        System.out.println("  ref.staticMethod: " + "(calls Parent2 — HIDDEN)");
        Parent2.staticHello();      // Parent version (compile-time binding)
        Child2.staticHello();       // Child version
        ref.instanceHello();        // Child version (runtime polymorphism)

        // ════════════════════════════════════════════════════
        // 2. METHOD OVERRIDING — DEEP DIVE
        // ════════════════════════════════════════════════════
        pillar("2. METHOD OVERRIDING — DEEP DIVE");

        header("Overriding Rules");

        sub("Access Modifier — Can Widen, Cannot Narrow");
        OverrideDemo od = new OverrideChild();
        od.publicMethod();      // ✔ public → public
        od.protectedMethod();   // ✔ protected → public (widened)

        sub("Covariant Return Type");
        AnimalFactory factory = new DogFactory();
        Animal2 produced = factory.create();  // declared Animal2, actual Dog2
        System.out.println("  Factory produced: " + produced.getClass().getSimpleName());

        sub("Exception Rules — Fewer or Narrower Checked Exceptions");
        System.out.println("  Parent throws IOException");
        System.out.println("  Child  throws FileNotFoundException (narrower ✔)");
        System.out.println("  Child  can also throw no exception at all ✔");
        System.out.println("  Child  CANNOT add new checked exceptions ✘");

        sub("@Override catches mistakes");
        System.out.println("  Without @Override: typo creates NEW method (no warning)");
        System.out.println("  With    @Override: compiler error on typo → safe!");

        header("Static Dispatch vs Dynamic Dispatch");

        sub("Compile-time (static): overloaded methods");
        DispatchDemo dd = new DispatchDemo();
        dd.show(42);           // int version
        dd.show("Hello");      // String version
        dd.show(3.14);         // double version

        sub("Runtime (dynamic): overridden methods");
        Base2[] bases = { new Base2(), new Sub2(), new SubSub2() };
        for (Base2 b : bases) {
            System.out.printf("  %-12s → ", b.getClass().getSimpleName());
            b.greet();
        }

        // ════════════════════════════════════════════════════
        // 3. super KEYWORD — ALL USES
        // ════════════════════════════════════════════════════
        pillar("3. super KEYWORD — ALL USES");

        header("All 3 Uses of super");

        SuperChild sc2 = new SuperChild("Java", 25);

        sub("Use 1 — super() : call parent constructor");
        System.out.println("  (shown during construction above)");

        sub("Use 2 — super.field : access parent field");
        sc2.showFields();

        sub("Use 3 — super.method() : call parent method");
        sc2.demonstrate();

        // ════════════════════════════════════════════════════
        // 4. ABSTRACT CLASSES — DEEP DIVE
        // ════════════════════════════════════════════════════
        pillar("4. ABSTRACT CLASSES — DEEP DIVE");

        header("Abstract Class Features");

        sub("Cannot instantiate abstract class");
        // AbstractAnimal aa = new AbstractAnimal(); // ✘ compile error
        System.out.println("  ✘ new AbstractAnimal() → compile error");
        System.out.println("  ✔ AbstractAnimal ref = new Dog3(...)  → OK");

        AbstractAnimal[] anim = {
            new Dog3("Rex","Labrador"),
            new Cat3b("Whiskers","Persian"),
            new Bird("Tweety","Canary")
        };

        System.out.printf("%n  %-10s %-12s %8s %8s%n",
                "Type","Name","Sound","Legs");
        sep();
        for (AbstractAnimal an : anim) {
            System.out.printf("  %-10s %-12s %8s %8d%n",
                    an.getClass().getSimpleName(),
                    an.name,
                    an.sound(),
                    an.legs());
            an.eat();      // concrete method from abstract class
        }

        sub("Abstract class CAN have constructor");
        System.out.println("  AbstractAnimal constructor runs during subclass new");
        System.out.println("  Used to initialize common fields: name, age");

        sub("Abstract class CAN have static members");
        System.out.println("  AbstractAnimal.kingdom = " + AbstractAnimal.kingdom);
        AbstractAnimal.printKingdom();

        sub("Template Method Pattern");
        System.out.println();
        Report[] reports = { new PDFReport("Q3 Results"),
                             new ExcelReport("Budget 2025"),
                             new HTMLReport("Dashboard") };
        for (Report r : reports) r.generate();

        sub("Abstract class partially implementing interface");
        System.out.println("  Partial: AbstractShape2 implements Drawable2");
        System.out.println("           but leaves draw() abstract");
        Drawable2[] shapes2 = {
            new FilledCircle(5.0,"Blue"),
            new FilledRect(4.0,6.0,"Green")
        };
        for (Drawable2 d : shapes2) {
            d.draw();
            d.resize(2.0);   // default in interface
            System.out.printf("  Area = %.2f%n", d.getArea());
        }

        // ════════════════════════════════════════════════════
        // 5. INTERFACES — DEEP DIVE
        // ════════════════════════════════════════════════════
        pillar("5. INTERFACES — DEEP DIVE");

        header("Interface Evolution (Java 7 → 9)");

        sub("Java 7: abstract methods + constants only");
        System.out.println("  interface Printable { void print(); }");

        sub("Java 8: default + static methods");
        Logger logger1 = new FileLogger("app.log");
        Logger logger2 = new ConsoleLogger();
        logger1.log("Server started");
        logger1.logError("Disk full");          // default method
        logger1.logWarning("Low memory");        // default method
        logger2.log("User logged in");
        logger2.logError("DB timeout");
        System.out.println("  Logger.formatTime(): " + Logger.formatTimestamp());

        sub("Java 9: private methods in interface");
        Payment payment1 = new CreditCard("4111-XXXX","Visa");
        Payment payment2 = new UPI("user@upi");
        payment1.processPayment(1500.0);
        payment2.processPayment(750.0);
        payment1.refund(200.0);          // uses private helper

        header("Multiple Interface Implementation");

        sub("A class can implement multiple interfaces");
        SmartDevice phone = new SmartPhone("iPhone15");
        phone.turnOn();
        phone.connect("WiFi-Home");
        phone.takePhoto(12);
        phone.playSound("Ring.mp3");
        phone.charge(85);

        sub("Interface extending multiple interfaces");
        AllInOne aio = new AllInOnePrinter("HP-Multi");
        aio.print("Document.pdf");
        aio.scan("Photo.jpg");
        aio.fax("Contract.pdf","9876543210");

        header("Diamond Problem & Resolution");

        sub("Two interfaces, same default method");
        System.out.println("  interface A: default void hello() {'A'}");
        System.out.println("  interface B: default void hello() {'B'}");
        System.out.println("  class C implements A,B → MUST override hello()");
        DiamondC dc = new DiamondC();
        dc.hello();               // overridden — calls A's version explicitly
        dc.callAHello();
        dc.callBHello();

        header("Functional Interfaces & Lambdas");

        sub("@FunctionalInterface — Single Abstract Method");
        Transformer<String,Integer> strLen = s -> s.length();
        Transformer<Integer,Integer> square = n -> n * n;
        Transformer<String,String>   upper  = String::toUpperCase;

        System.out.println("  strLen(\"Hello\")   : " + strLen.transform("Hello"));
        System.out.println("  square(7)          : " + square.transform(7));
        System.out.println("  upper(\"java\")     : " + upper.transform("java"));

        sub("Chaining custom functional interface");
        Transformer<String,Integer> lengthSquare =
                upper.andThen(strLen).andThen(square);
        System.out.println("  upper→len→square(\"hi\"): " + lengthSquare.transform("hi"));

        sub("Built-in Functional Interfaces");
        Predicate<Integer>      isEven    = n -> n % 2 == 0;
        Function<String,Integer> strToLen = String::length;
        Consumer<String>         printer  = System.out::println;
        Supplier<List<String>>   listMaker= ArrayList::new;
        BiFunction<Integer,Integer,Integer> multiply = (x,y) -> x*y;

        System.out.println("  isEven(4)          : " + isEven.test(4));
        System.out.println("  isEven.negate()(4) : " + isEven.negate().test(4));
        System.out.println("  strToLen(\"Java\")  : " + strToLen.apply("Java"));
        System.out.print ("  printer.accept     : "); printer.accept("Hello World");
        System.out.println("  listMaker.get()    : " + listMaker.get());
        System.out.println("  multiply(6,7)      : " + multiply.apply(6,7));

        // ════════════════════════════════════════════════════
        // 6. POLYMORPHISM — DEEP DIVE
        // ════════════════════════════════════════════════════
        pillar("6. POLYMORPHISM — DEEP DIVE");

        header("Upcasting & Downcasting");

        sub("Upcasting — Implicit, always safe");
        Dog2 myDog = new Dog2("Max","Beagle");
        Animal2 anRef = myDog;          // upcast — implicit
        System.out.println("  Dog2 upcasted to Animal2");
        System.out.println("  anRef.getClass() = " + anRef.getClass().getSimpleName());
        anRef.makeSound();              // polymorphic call → Dog2.makeSound()

        sub("Downcasting — Explicit, may throw ClassCastException");
        if (anRef instanceof Dog2) {
            Dog2 downDog = (Dog2) anRef;     // safe downcast
            downDog.fetch();
            System.out.println("  Breed: " + downDog.getBreed());
        }

        sub("Pattern Matching instanceof (Java 16+)");
        Object[] objs = { "Hello", 42, 3.14, new Dog2("Rex","Lab"), true };
        for (Object o : objs) {
            if (o instanceof String s) {
                System.out.println("  String: length=" + s.length() + " val='" + s + "'");
            } else if (o instanceof Integer i) {
                System.out.println("  Integer: " + i + " isEven=" + (i%2==0));
            } else if (o instanceof Double d) {
                System.out.println("  Double: " + d + " sqrt=" + Math.sqrt(d));
            } else if (o instanceof Dog2 dog) {
                System.out.println("  Dog2: " + dog.name + " sound=");
                dog.makeSound();
            } else {
                System.out.println("  Other: " + o);
            }
        }

        header("Polymorphism with Collections");

        sub("Store mixed subtypes via parent reference");
        List<Shape2> shapes = new ArrayList<>();
        shapes.add(new Circle2(7.0));
        shapes.add(new Rectangle2(5.0, 8.0));
        shapes.add(new Triangle2(3.0, 4.0, 5.0));
        shapes.add(new Circle2(3.5));
        shapes.add(new Rectangle2(10.0, 2.0));

        System.out.printf("  %-12s %10s %10s%n","Type","Area","Perimeter");
        sep();
        double totalArea = 0;
        for (Shape2 sh : shapes) {
            System.out.printf("  %-12s %10.2f %10.2f%n",
                    sh.getClass().getSimpleName(), sh.area(), sh.perimeter());
            totalArea += sh.area();
        }
        sep();
        System.out.printf("  %-12s %10.2f%n", "TOTAL AREA", totalArea);

        // Sort shapes by area
        shapes.sort(Comparator.comparingDouble(Shape2::area));
        System.out.println("  Sorted by area: " +
                shapes.stream()
                      .map(s -> s.getClass().getSimpleName()
                              + String.format("(%.1f)",s.area()))
                      .reduce((s1,s2)->s1+", "+s2).orElse(""));

        // ════════════════════════════════════════════════════
        // 7. ENCAPSULATION — DEEP DIVE
        // ════════════════════════════════════════════════════
        pillar("7. ENCAPSULATION — DEEP DIVE");

        header("Encapsulation Patterns");

        sub("Defensive Copying — Protect mutable fields");
        DefensiveCopy dc2 = new DefensiveCopy(
                new int[]{1,2,3,4,5}, Arrays.asList("A","B","C"));
        System.out.println("  Original data   : " + dc2);
        int[] arr = dc2.getData();        // returns COPY, not original
        arr[0] = 999;                     // modifying copy
        System.out.println("  After modifying returned array: " + dc2);
        System.out.println("  ✔ Internal state protected!");

        sub("Fluent Interface (Builder Pattern)");
        QueryBuilder query = new QueryBuilder()
                .select("name","age","email")
                .from("users")
                .where("age > 18")
                .where("city = 'Mumbai'")
                .orderBy("name")
                .limit(10);
        System.out.println("  Built query: " + query.build());

        sub("Lazy Initialization");
        LazyInit lazy = new LazyInit();
        System.out.println("  LazyInit created (heavy object NOT created yet)");
        System.out.println("  Accessing value: " + lazy.getValue());
        System.out.println("  Accessing again : " + lazy.getValue()); // uses cached

        sub("Read-Only + Write-Only Properties");
        SecureData sd = new SecureData();
        sd.setPassword("MySecret123");   // write-only setter
        sd.setScore(95);
        System.out.println("  getScore()      : " + sd.getScore());  // read OK
        System.out.println("  getPassword()   : " + sd.getPassword()); // returns masked

        // ════════════════════════════════════════════════════
        // 8. final KEYWORD — ALL USES
        // ════════════════════════════════════════════════════
        pillar("8. final KEYWORD — ALL USES");

        header("final Variable, Method, Class");

        sub("final local variable");
        final int MAX_SIZE  = 100;
        final String PREFIX = "USER_";
        System.out.println("  MAX_SIZE        : " + MAX_SIZE);
        System.out.println("  PREFIX          : " + PREFIX);

        sub("final instance field — blank final");
        FinalFieldDemo ffd1 = new FinalFieldDemo("Alice", 30);
        FinalFieldDemo ffd2 = new FinalFieldDemo("Bob",   25);
        System.out.println("  ffd1            : " + ffd1);
        System.out.println("  ffd2            : " + ffd2);

        sub("final static field — constants");
        System.out.println("  MathConst.PI    : " + MathConst.PI);
        System.out.println("  MathConst.E     : " + MathConst.E);
        System.out.println("  MathConst.GOLDEN: " + MathConst.GOLDEN_RATIO);

        sub("final method — cannot override");
        LicensedProduct lp = new LicensedProduct("Java SDK","Oracle");
        lp.showLicense();    // final method in parent
        lp.display();        // overridden method

        sub("final class — cannot extend");
        System.out.println("  String  is final → cannot extend");
        System.out.println("  Integer is final → cannot extend");
        System.out.println("  ImmutableConfig is final:");
        ImmutableConfig cfg = new ImmutableConfig("prod","v2.1","localhost");
        System.out.println("    " + cfg);

        sub("final parameter");
        System.out.println("  Circle with final param r:");
        double area = computeCircleArea(7.0);
        System.out.printf("  area(r=7)       : %.4f%n", area);

        sub("Effectively final (Java 8+ — lambdas)");
        int multiplier = 5;   // effectively final (not modified after)
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        nums.stream()
            .map(n -> n * multiplier)    // can use effectively final var
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // ════════════════════════════════════════════════════
        // 9. INNER CLASSES — ALL 4 TYPES
        // ════════════════════════════════════════════════════
        pillar("9. INNER CLASSES — ALL 4 TYPES");

        header("Type 1: Static Nested Class");

        sub("Does NOT need outer instance");
        Outer.StaticNested sn = new Outer.StaticNested("Static Nested");
        sn.display();
        System.out.println("  Outer.PI        : " + Outer.PI);

        header("Type 2: Non-Static (Member) Inner Class");

        sub("NEEDS outer class instance");
        Outer outer = new Outer("Outer Instance");
        Outer.MemberInner mi = outer.new MemberInner("Member Inner");
        mi.display();    // can access outer.data directly
        mi.showOuter();

        header("Type 3: Local Inner Class");

        sub("Defined inside a method, scope = method only");
        outer.demonstrateLocal("LocalData");

        header("Type 4: Anonymous Inner Class");

        sub("One-time use, no class name");
        Greeter formalGreeter = new Greeter() {
            @Override
            public void greet(String name) {
                System.out.println("  Good day, " + name + ". Welcome!");
            }
        };
        Greeter casualGreeter = new Greeter() {
            @Override
            public void greet(String name) {
                System.out.println("  Hey " + name + "! What's up?");
            }
        };
        formalGreeter.greet("Alice");
        casualGreeter.greet("Bob");

        sub("Anonymous class with Comparator");
        List<String> wordList = new ArrayList<>(
                Arrays.asList("Banana","Fig","Apple","Cherry","Kiwi","Date"));
        wordList.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() != b.length()
                        ? a.length() - b.length()
                        : a.compareTo(b);
            }
        });
        System.out.println("  Sorted by length: " + wordList);

        sub("Lambda vs Anonymous class (same result)");
        wordList.sort((s1, s2) -> s1.length() != s2.length()
                ? s1.length() - s2.length() : s1.compareTo(s2));
        System.out.println("  Lambda sort     : " + wordList);

        // ════════════════════════════════════════════════════
        // 10. ENUM — FULL COVERAGE
        // ════════════════════════════════════════════════════
        pillar("10. ENUM — FULL COVERAGE");

        header("Basic Enum");

        sub("values(), ordinal(), name()");
        System.out.printf("  %-12s %-4s %s%n","Name","Ord","name()");
        sep();
        for (Day day : Day.values()) {
            System.out.printf("  %-12s %-4d %s%n",
                    day, day.ordinal(), day.name());
        }

        sub("Enum in switch");
        Day today = Day.WEDNESDAY;
        switch (today) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
                 -> System.out.println("  " + today + " → Weekday");
            case SATURDAY, SUNDAY
                 -> System.out.println("  " + today + " → Weekend");
        }

        header("Enum with Fields & Methods");

        sub("Planet enum — fields + constructor + methods");
        System.out.printf("  %-10s %15s %12s %12s%n",
                "Planet","Mass(kg)","Radius(m)","Gravity(m/s²)");
        sep();
        for (Planet p : Planet.values()) {
            System.out.printf("  %-10s %15.2e %12.0f %12.2f%n",
                    p, p.mass(), p.radius(), p.surfaceGravity());
        }
        double myWeight = 70.0 * 9.8;  // weight on Earth in Newtons
        System.out.println();
        System.out.printf("  My weight on Earth : %.1f N%n", myWeight);
        for (Planet p : Planet.values()) {
            System.out.printf("  My weight on %-8s: %6.2f N%n",
                    p, p.surfaceWeight(myWeight));
        }

        header("Enum with Abstract Methods");

        sub("Each constant has its own implementation");
        System.out.printf("  %-12s %8s %s%n","Operation","Result","Expression");
        sep();
        double x = 10.0, y = 3.0;
        for (Operation op : Operation.values()) {
            System.out.printf("  %-12s %8.2f %s%n",
                    op, op.apply(x,y),
                    op.expression((int)x,(int)y));
        }

        header("Enum implementing Interface");

        sub("Status enum with behavior");
        for (OrderStatus status : OrderStatus.values()) {
            System.out.printf("  %-12s → %s%n", status, status.describe());
        }

        sub("EnumSet & EnumMap");
        EnumSet<Day> weekdays = EnumSet.of(
                Day.MONDAY,Day.TUESDAY,Day.WEDNESDAY,
                Day.THURSDAY,Day.FRIDAY);
        EnumSet<Day> weekends = EnumSet.complementOf(
                (EnumSet<Day>)weekdays);
        System.out.println("  Weekdays        : " + weekdays);
        System.out.println("  Weekends        : " + weekends);

        EnumMap<Day,String> schedule = new EnumMap<>(Day.class);
        schedule.put(Day.MONDAY,    "Team standup 9AM");
        schedule.put(Day.WEDNESDAY, "Code review 2PM");
        schedule.put(Day.FRIDAY,    "Sprint demo 4PM");
        System.out.println("  Schedule:");
        schedule.forEach((d,s) ->
                System.out.println("    " + d + ": " + s));

        // ════════════════════════════════════════════════════
        // 11. GENERICS — BASICS
        // ════════════════════════════════════════════════════
        pillar("11. GENERICS — BASICS");

        header("Generic Class");

        sub("Box<T> — type-safe wrapper");
        Box<String>  strBox = new Box<>("Hello Java");
        Box<Integer> intBox = new Box<>(42);
        Box<Double>  dblBox = new Box<>(3.14);

        System.out.println("  strBox.get()    : " + strBox.get());
        System.out.println("  intBox.get()    : " + intBox.get());
        System.out.println("  dblBox.get()    : " + dblBox.get());
        System.out.println("  strBox type     : " + strBox.getClass().getSimpleName());

        sub("Pair<K,V> — two type params");
        Pair<String,Integer> p1 = new Pair<>("Alice",  95);
        Pair<String,Integer> p2 = new Pair<>("Bob",    87);
        Pair<String,Double>  p3 = new Pair<>("Charlie",3.14);
        System.out.println("  p1              : " + p1);
        System.out.println("  p2              : " + p2);
        System.out.println("  p3              : " + p3);

        sub("Generic Stack<T>");
        GenStack<Integer> intStack = new GenStack<>();
        for (int i=1;i<=5;i++) intStack.push(i*10);
        System.out.println("  Stack           : " + intStack);
        System.out.println("  peek()          : " + intStack.peek());
        System.out.println("  pop()           : " + intStack.pop());
        System.out.println("  After pop       : " + intStack);

        header("Generic Methods");

        sub("Static generic method");
        System.out.println("  swap([1,2,3],0,2):");
        Integer[] arr2 = {1,2,3,4,5};
        GenUtils.swap(arr2, 0, 4);
        System.out.println("  After swap(0,4) : " + Arrays.toString(arr2));

        String[] sarr = {"A","B","C","D","E"};
        GenUtils.swap(sarr, 1, 3);
        System.out.println("  After swap(1,3) : " + Arrays.toString(sarr));

        sub("Generic method — find max");
        System.out.println("  max(3,7,1,9,4)  : " + GenUtils.max(3,7,1,9,4));
        System.out.println("  max(strings)    : " +
                GenUtils.max("Banana","Apple","Cherry"));

        header("Bounded Type Parameters");

        sub("<T extends Number> — numeric operations");
        System.out.println("  sum(1,2,3,4,5)     : " + GenUtils.sum(1,2,3,4,5));
        System.out.println("  sum(1.1,2.2,3.3)   : " + GenUtils.sum(1.1,2.2,3.3));
        System.out.println("  average(10,20,30)  : " + GenUtils.average(10,20,30));

        sub("Wildcard <?>— flexible parameter");
        List<Integer> iList = Arrays.asList(1,2,3,4,5);
        List<Double>  dList = Arrays.asList(1.1,2.2,3.3);
        List<String>  sList = Arrays.asList("A","B","C");

        System.out.print("  printAll(iList) : ");
        GenUtils.printAll(iList);
        System.out.print("  printAll(dList) : ");
        GenUtils.printAll(dList);
        System.out.print("  printAll(sList) : ");
        GenUtils.printAll(sList);

        System.out.println("  sumList(iList)  : " + GenUtils.sumList(iList));
        System.out.println("  sumList(dList)  : " + GenUtils.sumList(dList));

        // ════════════════════════════════════════════════════
        // 12. OBJECT CLASS — DEEP DIVE
        // ════════════════════════════════════════════════════
        pillar("12. Object CLASS — DEEP DIVE");

        header("toString(), equals(), hashCode()");

        sub("Default vs Overridden toString()");
        DefaultObj def = new DefaultObj(1,"Test");
        OverriddenObj ov1 = new OverriddenObj(1,"Alice",85);
        OverriddenObj ov2 = new OverriddenObj(1,"Alice",85);
        OverriddenObj ov3 = new OverriddenObj(2,"Bob",  90);

        System.out.println("  Default   toString: " + def);
        System.out.println("  Overridden toString:" + ov1);

        sub("equals() contract");
        System.out.println("  ov1.equals(ov2) : " + ov1.equals(ov2)); // true
        System.out.println("  ov1.equals(ov3) : " + ov1.equals(ov3)); // false
        System.out.println("  ov1.equals(null): " + ov1.equals(null)); // false
        System.out.println("  ov1 == ov2      : " + (ov1==ov2));      // false
        System.out.println("  Reflexive ov1.equals(ov1): " + ov1.equals(ov1));
        System.out.println("  Symmetric: ov1.equals(ov2) == ov2.equals(ov1): "
                + (ov1.equals(ov2) == ov2.equals(ov1)));

        sub("hashCode() contract");
        System.out.println("  ov1.hashCode()  : " + ov1.hashCode());
        System.out.println("  ov2.hashCode()  : " + ov2.hashCode());
        System.out.println("  ov3.hashCode()  : " + ov3.hashCode());
        System.out.println("  ov1.equals(ov2) → hashCodes MUST match: "
                + (ov1.hashCode() == ov2.hashCode()));

        sub("hashCode in HashSet (why it matters)");
        Set<OverriddenObj> objSet = new HashSet<>();
        objSet.add(ov1);
        objSet.add(ov2);   // duplicate: equals+hashCode match
        objSet.add(ov3);
        System.out.println("  Set size (expected 2): " + objSet.size());

        sub("getClass() vs instanceof");
        System.out.println("  ov1.getClass()  : " + ov1.getClass().getName());
        System.out.println("  ov1.getClass().getSimpleName(): "
                + ov1.getClass().getSimpleName());
        System.out.println("  ov1.getClass()==ov2.getClass(): "
                + (ov1.getClass()==ov2.getClass()));
        System.out.println("  ov1 instanceof OverriddenObj: "
                + (ov1 instanceof OverriddenObj));
        System.out.println("  ov1 instanceof Object: "
                + (ov1 instanceof Object));

        // ════════════════════════════════════════════════════
        // 13. REAL-WORLD SCENARIOS
        // ════════════════════════════════════════════════════
        pillar("13. REAL-WORLD SCENARIOS");

        header("Scenario 1: Plugin System (Interface)");
        pluginSystemDemo();

        header("Scenario 2: Order Processing (Abstract + Enum)");
        orderProcessingDemo();

        header("Scenario 3: Generic Repository");
        genericRepositoryDemo();

        System.out.println(
            "\n##################################################");
        System.out.println(
            "#   OOP Core Concepts — Done! ✔                 #");
        System.out.println(
            "##################################################");
    }

    // ── real-world demos ──
    static void pluginSystemDemo() {
        List<Plugin> plugins = new ArrayList<>();
        plugins.add(new AuthPlugin());
        plugins.add(new LoggingPlugin());
        plugins.add(new CachePlugin());
        plugins.add(new MetricsPlugin());

        System.out.println("  Initializing all plugins:");
        plugins.forEach(Plugin::initialize);
        System.out.println();
        System.out.println("  Executing all plugins:");
        plugins.forEach(p -> p.execute("SampleRequest"));
        System.out.println();
        System.out.println("  Shutting down:");
        plugins.forEach(Plugin::shutdown);
    }

    static void orderProcessingDemo() {
        List<Order> orders = Arrays.asList(
            new Order("ORD001","Alice",  2500.0, OrderStatus.PLACED),
            new Order("ORD002","Bob",    4200.0, OrderStatus.SHIPPED),
            new Order("ORD003","Charlie",1800.0, OrderStatus.DELIVERED),
            new Order("ORD004","Diana",  3300.0, OrderStatus.CANCELLED)
        );

        System.out.printf("  %-8s %-10s %10s %-12s %s%n",
                "OrderID","Customer","Amount","Status","Action");
        sep();
        for (Order o : orders) {
            System.out.printf("  %-8s %-10s %10.2f %-12s %s%n",
                    o.id, o.customer, o.amount,
                    o.status, o.status.describe());
        }

        // polymorphic notification
        System.out.println("\n  Sending notifications:");
        NotificationService sms   = new SMSNotification();
        NotificationService email = new EmailNotification();
        orders.forEach(o -> {
            if (o.status == OrderStatus.SHIPPED)   sms.notify(o.customer, o.id);
            if (o.status == OrderStatus.DELIVERED) email.notify(o.customer, o.id);
        });
    }

    static void genericRepositoryDemo() {
        Repository<String,Student3> stuRepo = new InMemoryRepository<>();
        stuRepo.save("S001", new Student3("S001","Alice",92.5));
        stuRepo.save("S002", new Student3("S002","Bob",  78.0));
        stuRepo.save("S003", new Student3("S003","Charlie",88.5));

        System.out.println("  All students:");
        stuRepo.findAll().forEach(s -> System.out.println("    " + s));
        System.out.println("  findById(S002)  : " + stuRepo.findById("S002"));
        stuRepo.delete("S001");
        System.out.println("  After delete S001: " + stuRepo.count() + " records");

        Repository<Integer, Product3> prodRepo = new InMemoryRepository<>();
        prodRepo.save(1, new Product3(1,"Laptop",75000));
        prodRepo.save(2, new Product3(2,"Phone", 25000));
        System.out.println("  Products        : " + prodRepo.count());
        System.out.println("  Product 1       : " + prodRepo.findById(1));
    }

    // utility
    static double computeCircleArea(final double r) {
        return Math.PI * r * r;
    }
}

// ════════════════════════════════════════════════════════
//  SUPPORTING CLASSES & INTERFACES
// ════════════════════════════════════════════════════════

// ── Inheritance — Object creation order ──
class GrandParentCls {
    static { System.out.println("    [static] GrandParentCls loaded"); }
    { System.out.println("    [instance block] GrandParentCls"); }
    GrandParentCls() { System.out.println("    [constructor] GrandParentCls()"); }
    @Override public String toString() { return "GrandParentCls"; }
}

class ParentCls extends GrandParentCls {
    static { System.out.println("    [static] ParentCls loaded"); }
    { System.out.println("    [instance block] ParentCls"); }
    ParentCls() {
        super();
        System.out.println("    [constructor] ParentCls()");
    }
    @Override public String toString() { return "ParentCls→" + super.toString(); }
}

class GrandChild extends ParentCls {
    static { System.out.println("    [static] GrandChild loaded"); }
    { System.out.println("    [instance block] GrandChild"); }
    GrandChild() {
        super();
        System.out.println("    [constructor] GrandChild()");
    }
    @Override public String toString() { return "GrandChild→" + super.toString(); }
}

// ── Constructor chaining demo ──
class BaseShape {
    String shapeName;
    BaseShape(String name) {
        this.shapeName = name;
        System.out.println("    BaseShape(\"" + name + "\") called");
    }
}

class ColoredShape extends BaseShape {
    String color;
    double size;
    ColoredShape(String name, String color, double size) {
        super(name);
        this.color = color;
        this.size  = size;
        System.out.println("    ColoredShape(\""+name+"\",\""+color+"\","
                +size+") called");
    }
    @Override public String toString() {
        return shapeName + "(" + color + ", size=" + size + ")";
    }
}

// ── super keyword demo ──
class SuperParent {
    String language = "Java (Parent)";
    SuperParent(String lang) {
        System.out.println("    SuperParent constructor: " + lang);
    }
    void hello() {
        System.out.println("    SuperParent.hello()");
    }
    String getInfo() { return "Parent info"; }
}

class SuperChild extends SuperParent {
    String language = "Java (Child)";
    int version;
    SuperChild(String lang, int version) {
        super(lang);   // Use 1: call parent constructor
        this.version = version;
    }
    void showFields() {
        System.out.println("    this.language   : " + this.language);
        System.out.println("    super.language  : " + super.language); // Use 2: parent field
    }
    void demonstrate() {
        super.hello();            // Use 3: parent method
        System.out.println("    SuperChild.hello() after super.hello()");
        System.out.println("    super.getInfo() : " + super.getInfo());
    }
}

// ── Parent2/Child2 (static hiding) ──
class Parent2 {
    static void staticHello() { System.out.println("    Parent2.staticHello()"); }
    void instanceHello()      { System.out.println("    Parent2.instanceHello()"); }
}

class Child2 extends Parent2 {
    static void staticHello() { System.out.println("    Child2.staticHello()"); }
    @Override
    void instanceHello()      { System.out.println("    Child2.instanceHello()"); }
}

// ── Derived/Base (constructor chain) ──
class Base {
    String name;
    Base(String name) {
        this.name = name;
        System.out.println("    Base(\"" + name + "\")");
    }
    @Override public String toString() { return "Base(" + name + ")"; }
}

class Derived extends Base {
    Derived(String name) {
        super(name + "_from_Derived");
        System.out.println("    Derived(\"" + name + "\")");
    }
    @Override public String toString() { return "Derived→" + super.toString(); }
}

// ── Animal2 hierarchy ──
class Animal2 {
    protected String name;
    Animal2(String name) { this.name = name; }
    void breathe()    { System.out.println("  " + name + " breathes."); }
    void makeSound()  { System.out.println("  " + name + " makes a sound."); }
    void move()       { System.out.println("  " + name + " moves."); }
    String getName()  { return name; }
    @Override public String toString() {
        return getClass().getSimpleName() + "(" + name + ")";
    }
}

class Dog2 extends Animal2 {
    private String breed;
    Dog2(String name, String breed) {
        super(name); this.breed = breed;
    }
    @Override public void makeSound() {
        System.out.println("  " + name + " barks: Woof!");
    }
    @Override public void move() {
        System.out.println("  " + name + " runs on 4 legs.");
    }
    void fetch() { System.out.println("  " + name + " fetches the ball!"); }
    String getBreed() { return breed; }
    void fullIntro() {
        System.out.println("  [Dog intro] Name=" + name + " Breed=" + breed);
        System.out.print("  [Parent animal says] ");
        super.makeSound();
        System.out.print("  [Dog says] ");
        this.makeSound();
    }
    @Override public String toString() {
        return super.toString() + " breed=" + breed;
    }
}

// ── Overriding rules ──
class OverrideDemo {
    void publicMethod()    { System.out.println("  OverrideDemo.publicMethod()"); }
    protected void protectedMethod() { System.out.println("  OverrideDemo.protectedMethod()"); }
}

class OverrideChild extends OverrideDemo {
    @Override
    public void publicMethod() { System.out.println("  OverrideChild.publicMethod() ✔"); }
    @Override
    public void protectedMethod() {
        System.out.println("  OverrideChild.protectedMethod() widened to public ✔");
    }
}

// ── Covariant return ──
class AnimalFactory {
    Animal2 create() { return new Animal2("Generic"); }
}

class DogFactory extends AnimalFactory {
    @Override
    Dog2 create() { return new Dog2("Rex","Lab"); }  // covariant — Dog2 ⊆ Animal2
}

// ── Dispatch demo ──
class DispatchDemo {
    void show(int    n) { System.out.println("  show(int)    : " + n); }
    void show(String s) { System.out.println("  show(String) : " + s); }
    void show(double d) { System.out.println("  show(double) : " + d); }
}

class Base2 {
    void greet() { System.out.println("Base2.greet()"); }
}
class Sub2 extends Base2 {
    @Override void greet() { System.out.println("Sub2.greet()"); }
}
class SubSub2 extends Sub2 {
    @Override void greet() { System.out.println("SubSub2.greet()"); }
}

// ── Abstract animal ──
abstract class AbstractAnimal {
    static final String kingdom = "Animalia";
    protected String name;
    protected int    age;
    AbstractAnimal(String name, int age) {
        this.name=name; this.age=age;
    }
    abstract String sound();
    abstract int    legs();
    void eat() { System.out.println("  " + name + " eats food."); }
    static void printKingdom() {
        System.out.println("  Kingdom: " + kingdom);
    }
}

class Dog3 extends AbstractAnimal {
    String breed;
    Dog3(String name, String breed) { super(name,3); this.breed=breed; }
    @Override public String sound() { return "Woof"; }
    @Override public int    legs()  { return 4; }
}

class Cat4 extends AbstractAnimal {  // renamed to avoid conflict
    String pattern;
    Cat4(String name, String pattern) { super(name,2); this.pattern=pattern; }
    @Override public String sound() { return "Meow"; }
    @Override public int    legs()  { return 4; }
}

// renamed Cat3→Cat4 for abstract demo:
class Cat3b extends AbstractAnimal {
    String pattern;
    Cat3b(String name, String pattern) { super(name,2); this.pattern=pattern; }
    @Override public String sound() { return "Meow"; }
    @Override public int    legs()  { return 4; }
}

class Bird extends AbstractAnimal {
    String species;
    Bird(String name, String species) { super(name,1); this.species=species; }
    @Override public String sound() { return "Tweet"; }
    @Override public int    legs()  { return 2; }
}

// fix: use Cat3b in main — rebuild Cat array entries
// Rebuild inner to use correct types:
// (Already used Dog3, Cat3b, Bird in the anim[] array correctly)

// ── Template Method ──
abstract class Report {
    final void generate() {
        System.out.println("  [" + getClass().getSimpleName() + "]");
        fetchData();
        formatContent();
        export();
        System.out.println("  Report done.");
    }
    abstract void fetchData();
    abstract void formatContent();
    void export() { System.out.println("    Exporting to output folder..."); }
}

class PDFReport extends Report {
    String title;
    PDFReport(String t) { this.title=t; }
    @Override void fetchData()      { System.out.println("    Querying DB for: "+title); }
    @Override void formatContent()  { System.out.println("    Formatting as PDF layout..."); }
    @Override void export()         { System.out.println("    Saving as "+title+".pdf"); }
}

class ExcelReport extends Report {
    String title;
    ExcelReport(String t) { this.title=t; }
    @Override void fetchData()      { System.out.println("    Loading spreadsheet: "+title); }
    @Override void formatContent()  { System.out.println("    Building Excel rows/cols..."); }
}

class HTMLReport extends Report {
    String title;
    HTMLReport(String t) { this.title=t; }
    @Override void fetchData()      { System.out.println("    Fetching API data: "+title); }
    @Override void formatContent()  { System.out.println("    Rendering HTML template..."); }
    @Override void export()         { System.out.println("    Publishing "+title+".html"); }
}

// ── Interface + abstract partially ──
interface Drawable2 {
    void draw();
    double getArea();
    default void resize(double factor) {
        System.out.println("    Resizing by factor " + factor);
    }
}

abstract class AbstractShape2 implements Drawable2 {
    protected String color;
    AbstractShape2(String c) { this.color=c; }
    @Override public abstract void   draw();
    @Override public abstract double getArea();
}

class FilledCircle extends AbstractShape2 {
    double r;
    FilledCircle(double r, String c) { super(c); this.r=r; }
    @Override public void   draw()    { System.out.println("  ●  FilledCircle r="+r+" color="+color); }
    @Override public double getArea() { return Math.PI*r*r; }
}

class FilledRect extends AbstractShape2 {
    double w,h;
    FilledRect(double w, double h, String c) { super(c); this.w=w; this.h=h; }
    @Override public void   draw()    { System.out.println("  ▬  FilledRect "+w+"x"+h+" color="+color); }
    @Override public double getArea() { return w*h; }
}

// ── Interfaces Java 8/9 ──
interface Logger {
    void log(String msg);
    default void logError(String msg) {
        log("[ERROR] " + msg);
    }
    default void logWarning(String msg) {
        log("[WARN]  " + msg);
    }
    static String formatTimestamp() { return "2025-08-01T10:30:00"; }
}

class FileLogger implements Logger {
    String file;
    FileLogger(String file) { this.file=file; }
    @Override public void log(String msg) {
        System.out.println("  [FILE:" + file + "] " + msg);
    }
}

class ConsoleLogger implements Logger {
    @Override public void log(String msg) {
        System.out.println("  [CONSOLE] " + msg);
    }
}

interface Payment {
    void processPayment(double amount);
    default void refund(double amount) {
        validateAmount(amount);
        System.out.println("  Refunding ₹" + amount);
    }
    private void validateAmount(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Invalid amount");
        System.out.println("  [private] Validating ₹" + amount + " → OK");
    }
}

class CreditCard implements Payment {
    String cardNo, type;
    CreditCard(String no, String type) { this.cardNo=no; this.type=type; }
    @Override public void processPayment(double amount) {
        System.out.printf("  💳 CreditCard(%s) charged ₹%.2f%n", type, amount);
    }
}

class UPI implements Payment {
    String upiId;
    UPI(String id) { this.upiId=id; }
    @Override public void processPayment(double amount) {
        System.out.printf("  📱 UPI(%s) paid ₹%.2f%n", upiId, amount);
    }
}

// ── Multiple interfaces ──
interface PowerSwitch { void turnOn(); void turnOff(); }
interface NetworkConn { void connect(String network); }
interface Camera      { void takePhoto(int megapixels); }
interface Speaker     { void playSound(String file); }
interface Charger     { void charge(int percent); }

interface SmartDevice extends PowerSwitch, NetworkConn, Camera, Speaker, Charger {}

class SmartPhone implements SmartDevice {
    String model;
    SmartPhone(String m) { this.model=m; }
    @Override public void turnOn()              { System.out.println("  "+model+" ON"); }
    @Override public void turnOff()             { System.out.println("  "+model+" OFF"); }
    @Override public void connect(String net)   { System.out.println("  Connected: "+net); }
    @Override public void takePhoto(int mp)     { System.out.println("  📸 Photo "+mp+"MP"); }
    @Override public void playSound(String f)   { System.out.println("  🔊 Playing "+f); }
    @Override public void charge(int pct)       { System.out.println("  🔋 Charging to "+pct+"%"); }
}

interface Printable2 { void print(String doc); }
interface Scannable  { void scan(String doc); }
interface Faxable    { void fax(String doc, String num); }
interface AllInOne extends Printable2, Scannable, Faxable {}

class AllInOnePrinter implements AllInOne {
    String name;
    AllInOnePrinter(String n) { this.name=n; }
    @Override public void print(String d) { System.out.println("  ["+name+"] Print: "+d); }
    @Override public void scan(String d)  { System.out.println("  ["+name+"] Scan:  "+d); }
    @Override public void fax(String d, String n) {
        System.out.println("  ["+this.name+"] Fax:   "+d+" → "+n);
    }
}

// ── Diamond problem ──
interface InterfaceA {
    default void hello() { System.out.println("  InterfaceA.hello()"); }
}

interface InterfaceB {
    default void hello() { System.out.println("  InterfaceB.hello()"); }
}

class DiamondC implements InterfaceA, InterfaceB {
    @Override
    public void hello() {
        System.out.println("  DiamondC.hello() [overrides both]");
        InterfaceA.super.hello();   // explicitly call A's version
    }
    void callAHello() { InterfaceA.super.hello(); }
    void callBHello() { InterfaceB.super.hello(); }
}

// ── Functional interface ──
@FunctionalInterface
interface Transformer<I,O> {
    O transform(I input);
    default <R> Transformer<I,R> andThen(Transformer<O,R> after) {
        return input -> after.transform(this.transform(input));
    }
}

// ── Upcasting/Downcasting shapes ──
abstract class Shape2 {
    abstract double area();
    abstract double perimeter();
}

class Circle2 extends Shape2 {
    double r;
    Circle2(double r) { this.r=r; }
    @Override public double area()      { return Math.PI*r*r; }
    @Override public double perimeter() { return 2*Math.PI*r; }
}

class Rectangle2 extends Shape2 {
    double w,h;
    Rectangle2(double w,double h) { this.w=w;this.h=h; }
    @Override public double area()      { return w*h; }
    @Override public double perimeter() { return 2*(w+h); }
}

class Triangle2 extends Shape2 {
    double a,b,c;
    Triangle2(double a,double b,double c) { this.a=a;this.b=b;this.c=c; }
    @Override public double area() {
        double s=(a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    @Override public double perimeter() { return a+b+c; }
}

// ── Encapsulation patterns ──
class DefensiveCopy {
    private int[]        data;
    private List<String> tags;
    DefensiveCopy(int[] data, List<String> tags) {
        this.data = data.clone();               // defensive copy in
        this.tags = new ArrayList<>(tags);
    }
    int[] getData() { return data.clone(); }    // defensive copy out
    List<String> getTags() { return Collections.unmodifiableList(tags); }
    @Override public String toString() {
        return "DC{data=" + Arrays.toString(data) + ", tags=" + tags + "}";
    }
}

class QueryBuilder {
    private String         table   = "";
    private List<String>   columns = new ArrayList<>();
    private List<String>   wheres  = new ArrayList<>();
    private String         order   = "";
    private int            lim     = -1;

    QueryBuilder select(String... cols) {
        columns.addAll(Arrays.asList(cols)); return this;
    }
    QueryBuilder from(String t)    { this.table=t; return this; }
    QueryBuilder where(String w)   { wheres.add(w); return this; }
    QueryBuilder orderBy(String o) { this.order=o; return this; }
    QueryBuilder limit(int l)      { this.lim=l; return this; }
    String build() {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(String.join(", ", columns));
        sb.append(" FROM ").append(table);
        if (!wheres.isEmpty())
            sb.append(" WHERE ").append(String.join(" AND ", wheres));
        if (!order.isEmpty()) sb.append(" ORDER BY ").append(order);
        if (lim > 0)          sb.append(" LIMIT ").append(lim);
        return sb.toString();
    }
}

class LazyInit {
    private String heavyObject = null;
    String getValue() {
        if (heavyObject == null) {
            System.out.println("  [LazyInit] Creating heavy object...");
            heavyObject = "ExpensiveData@" + System.nanoTime() % 10000;
        }
        return heavyObject;
    }
}

class SecureData {
    private String hashedPassword = "";
    private int    score          = 0;
    void setPassword(String pwd) { this.hashedPassword = "*".repeat(pwd.length()); }
    String getPassword()         { return hashedPassword; }
    void setScore(int s)         { if(s>=0&&s<=100) this.score=s; }
    int  getScore()              { return score; }
}

// ── final demos ──
class FinalFieldDemo {
    final String name;
    final int    age;
    FinalFieldDemo(String n, int a) { this.name=n; this.age=a; }
    @Override public String toString() { return "FinalField{"+name+", age="+age+"}"; }
}

class MathConst {
    static final double PI           = 3.14159265358979;
    static final double E            = 2.71828182845904;
    static final double GOLDEN_RATIO = 1.61803398874989;
    private MathConst() {}
}

class BaseProduct {
    String name;
    BaseProduct(String n) { this.name=n; }
    final void showLicense() {
        System.out.println("  License: © 2025 All rights reserved for " + name);
    }
    void display() { System.out.println("  Product: " + name); }
}

class LicensedProduct extends BaseProduct {
    String vendor;
    LicensedProduct(String n, String v) { super(n); this.vendor=v; }
    @Override void display() {
        System.out.println("  LicensedProduct: " + name + " by " + vendor);
    }
}

final class ImmutableConfig {
    private final String env, version, host;
    ImmutableConfig(String e, String v, String h) {
        this.env=e; this.version=v; this.host=h;
    }
    @Override public String toString() {
        return "Config{env="+env+",v="+version+",host="+host+"}";
    }
}

// ── Inner classes ──
class Outer {
    static final double PI = 3.14159;
    private String data;
    Outer(String data) { this.data=data; }

    // Static nested
    static class StaticNested {
        String label;
        StaticNested(String l) { this.label=l; }
        void display() {
            System.out.println("  StaticNested: " + label);
            System.out.println("  Outer.PI    : " + PI);   // can access static
        }
    }

    // Non-static inner
    class MemberInner {
        String label;
        MemberInner(String l) { this.label=l; }
        void display() {
            System.out.println("  MemberInner : " + label);
            System.out.println("  Outer.data  : " + data); // accesses outer field
        }
        void showOuter() {
            System.out.println("  Outer ref   : " + Outer.this.data);
        }
    }

    // Local inner class inside method
    void demonstrateLocal(String methodParam) {
        final String localVar = "LocalVar";
        class LocalClass {
            void show() {
                System.out.println("  LocalClass sees methodParam: " + methodParam);
                System.out.println("  LocalClass sees localVar   : " + localVar);
                System.out.println("  LocalClass sees outer.data : " + data);
            }
        }
        new LocalClass().show();
    }
}

// ── Anonymous inner class interface ──
interface Greeter { void greet(String name); }

// ── Enums ──
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS  (4.869e+24, 6.0518e6),
    EARTH  (5.976e+24, 6.37814e6),
    MARS   (6.421e+23, 3.3972e6);

    private final double mass;
    private final double radius;
    static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass=mass; this.radius=radius;
    }
    double mass()            { return mass; }
    double radius()          { return radius; }
    double surfaceGravity()  { return G*mass/(radius*radius); }
    double surfaceWeight(double otherWeight) {
        return otherWeight * surfaceGravity() / 9.81;
    }
}

enum Operation {
    ADD("+") {
        @Override public double apply(double x, double y) { return x+y; }
    },
    SUBTRACT("-") {
        @Override public double apply(double x, double y) { return x-y; }
    },
    MULTIPLY("×") {
        @Override public double apply(double x, double y) { return x*y; }
    },
    DIVIDE("÷") {
        @Override public double apply(double x, double y) { return x/y; }
    },
    POWER("^") {
        @Override public double apply(double x, double y) { return Math.pow(x,y); }
    },
    MOD("%") {
        @Override public double apply(double x, double y) { return x%y; }
    };

    private final String symbol;
    Operation(String sym) { this.symbol=sym; }
    public abstract double apply(double x, double y);
    public String expression(int x, int y) {
        return x + " " + symbol + " " + y;
    }
}

interface Describable { String describe(); }

enum OrderStatus implements Describable {
    PLACED    { @Override public String describe(){ return "✅ Order confirmed"; } },
    SHIPPED   { @Override public String describe(){ return "🚚 On the way";      } },
    DELIVERED { @Override public String describe(){ return "📦 Delivered!";       } },
    CANCELLED { @Override public String describe(){ return "❌ Cancelled";        } }
}

// ── Generics ──
class Box<T> {
    private T value;
    Box(T value) { this.value=value; }
    T get()      { return value; }
    void set(T v){ this.value=v; }
    @Override public String toString() { return "Box[" + value + "]"; }
}

class Pair<K,V> {
    K key; V value;
    Pair(K k, V v) { this.key=k; this.value=v; }
    @Override public String toString() {
        return "(" + key + " → " + value + ")";
    }
}

class GenStack<T> {
    private List<T> list = new ArrayList<>();
    void push(T item) { list.add(item); }
    T    pop()        { return list.isEmpty()?null:list.remove(list.size()-1); }
    T    peek()       { return list.isEmpty()?null:list.get(list.size()-1); }
    boolean isEmpty() { return list.isEmpty(); }
    @Override public String toString() { return list.toString(); }
}

class GenUtils {
    static <T> void swap(T[] arr, int i, int j) {
        T tmp=arr[i]; arr[i]=arr[j]; arr[j]=tmp;
    }

    @SafeVarargs
    static <T extends Comparable<T>> T max(T... items) {
        T best = items[0];
        for (T item : items) if (item.compareTo(best) > 0) best = item;
        return best;
    }

    @SafeVarargs
    static <T extends Number> double sum(T... nums) {
        double s=0; for (T n:nums) s+=n.doubleValue(); return s;
    }

    @SafeVarargs
    static <T extends Number> double average(T... nums) {
        return sum(nums) / nums.length;
    }

    static void printAll(List<?> list) {
        list.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    static double sumList(List<? extends Number> list) {
        double s=0; for (Number n:list) s+=n.doubleValue(); return s;
    }
}

// ── Object class demo ──
class DefaultObj {
    int id; String name;
    DefaultObj(int id, String name) { this.id=id; this.name=name; }
    // NO toString/equals/hashCode override → uses Object defaults
}

class OverriddenObj {
    int id; String name; double score;
    OverriddenObj(int id, String name, double score) {
        this.id=id; this.name=name; this.score=score;
    }
    @Override public String toString() {
        return "Obj{id="+id+",name="+name+",score="+score+"}";
    }
    @Override public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof OverriddenObj)) return false;
        OverriddenObj obj = (OverriddenObj) o;
        return id==obj.id && name.equals(obj.name)
                && Double.compare(score,obj.score)==0;
    }
    @Override public int hashCode() {
        return Objects.hash(id, name, score);
    }
}

// ── Plugin system ──
interface Plugin {
    void initialize();
    void execute(String request);
    void shutdown();
    default String getName() { return getClass().getSimpleName(); }
}

class AuthPlugin implements Plugin {
    @Override public void initialize() { System.out.println("  [Auth] Loading JWT keys..."); }
    @Override public void execute(String r) { System.out.println("  [Auth] Validating: "+r); }
    @Override public void shutdown()    { System.out.println("  [Auth] Cleared keys."); }
}

class LoggingPlugin implements Plugin {
    @Override public void initialize() { System.out.println("  [Log]  Opening log file..."); }
    @Override public void execute(String r) { System.out.println("  [Log]  Logging: "+r); }
    @Override public void shutdown()    { System.out.println("  [Log]  Flushing buffer."); }
}

class CachePlugin implements Plugin {
    @Override public void initialize() { System.out.println("  [Cache] Loading cache..."); }
    @Override public void execute(String r) { System.out.println("  [Cache] Checking: "+r); }
    @Override public void shutdown()    { System.out.println("  [Cache] Evicting entries."); }
}

class MetricsPlugin implements Plugin {
    @Override public void initialize() { System.out.println("  [Metrics] Init counters..."); }
    @Override public void execute(String r) { System.out.println("  [Metrics] Recording: "+r); }
    @Override public void shutdown()    { System.out.println("  [Metrics] Flushing stats."); }
}

// ── Order processing ──
class Order {
    String id, customer;
    double amount;
    OrderStatus status;
    Order(String id, String customer, double amount, OrderStatus status) {
        this.id=id; this.customer=customer;
        this.amount=amount; this.status=status;
    }
}

interface NotificationService { void notify(String customer, String orderId); }
class SMSNotification implements NotificationService {
    @Override public void notify(String c, String o) {
        System.out.println("  📱 SMS  → "+c+": Your order "+o+" is shipped!");
    }
}
class EmailNotification implements NotificationService {
    @Override public void notify(String c, String o) {
        System.out.println("  📧 Email→ "+c+": Order "+o+" delivered. Thank you!");
    }
}

// ── Generic repository ──
interface Repository<K,V> {
    void   save(K key, V value);
    V      findById(K key);
    void   delete(K key);
    List<V>findAll();
    int    count();
}

class InMemoryRepository<K,V> implements Repository<K,V> {
    private Map<K,V> store = new LinkedHashMap<>();
    @Override public void    save(K k, V v)    { store.put(k,v); }
    @Override public V       findById(K k)     { return store.get(k); }
    @Override public void    delete(K k)       { store.remove(k); }
    @Override public List<V> findAll()         { return new ArrayList<>(store.values()); }
    @Override public int     count()           { return store.size(); }
}

class Student3 {
    String id,name; double gpa;
    Student3(String id,String name,double gpa){ this.id=id;this.name=name;this.gpa=gpa;}
    @Override public String toString(){return "Student{"+id+","+name+",gpa="+gpa+"}";}
}

class Product3 {
    int id; String name; double price;
    Product3(int id,String name,double price){this.id=id;this.name=name;this.price=price;}
    @Override public String toString(){return "Product{"+id+","+name+",₹"+price+"}";}
}