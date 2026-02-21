/*
 * ============================================================
 *         OBJECT-ORIENTED PROGRAMMING (OOP) IN JAVA
 *                     COMPLETE THEORY
 * ============================================================
 *
 * WHAT IS OOP?
 * -------------
 * Object-Oriented Programming is a programming PARADIGM that
 * organizes software design around OBJECTS rather than
 * functions and logic.
 *
 * An OBJECT is a real-world entity that has:
 *  - STATE      → attributes / fields / properties
 *  - BEHAVIOR   → methods / functions / actions
 *  - IDENTITY   → unique reference in memory
 *
 * Real-life analogy:
 *  Car (object):
 *   State    → color="red", speed=0, fuel=100
 *   Behavior → accelerate(), brake(), refuel()
 *   Identity → unique car object in memory
 *
 * ============================================================
 * WHY OOP?
 * ============================================================
 *
 *  ✔ Models real-world entities naturally
 *  ✔ Code reusability (inheritance)
 *  ✔ Modularity (encapsulation)
 *  ✔ Flexibility (polymorphism)
 *  ✔ Easier maintenance
 *  ✔ Scalability for large projects
 *  ✔ Security (data hiding)
 *
 * ============================================================
 * THE 4 PILLARS OF OOP
 * ============================================================
 *
 *  1. ENCAPSULATION  → Bundle data + methods, hide details
 *  2. INHERITANCE    → Child class reuses parent class code
 *  3. POLYMORPHISM   → One interface, many implementations
 *  4. ABSTRACTION    → Show essential, hide complexity
 *
 * ============================================================
 * KEY OOP CONCEPTS
 * ============================================================
 *
 *  CLASS:
 *  -------
 *  A BLUEPRINT / TEMPLATE for creating objects.
 *  Defines what data (fields) and behavior (methods) objects
 *  of that type will have.
 *  A class is not an object — it's a plan.
 *
 *  Syntax:
 *  class ClassName {
 *      // fields (state)
 *      // constructors
 *      // methods (behavior)
 *  }
 *
 *  OBJECT:
 *  --------
 *  An INSTANCE of a class. Created using 'new' keyword.
 *  Each object has its own copy of instance variables.
 *  Objects are stored on the HEAP.
 *  Object references are stored on the STACK.
 *
 *  Syntax:
 *  ClassName obj = new ClassName();
 *
 *  CLASS vs OBJECT:
 *  -----------------
 *  Class   → Blueprint of a house (plan)
 *  Object  → Actual house built from blueprint
 *  Many objects can be created from one class.
 *
 * ============================================================
 * CONSTRUCTOR
 * ============================================================
 *
 *  Special method called when object is created (new).
 *  Used to INITIALIZE the object's state.
 *
 *  Rules:
 *  - Same name as the class
 *  - NO return type (not even void)
 *  - Called automatically on 'new'
 *  - Can be overloaded
 *
 *  Types:
 *  1. Default constructor     → no parameters, Java provides if none defined
 *  2. No-arg constructor      → defined explicitly with no params
 *  3. Parameterized constructor → takes parameters
 *  4. Copy constructor        → takes same class object as param
 *
 *  Constructor Chaining:
 *  - this()       → calls another constructor in SAME class
 *  - super()      → calls parent class constructor
 *  - Must be FIRST statement in constructor
 *
 * ============================================================
 * this KEYWORD
 * ============================================================
 *
 *  Refers to the CURRENT object instance.
 *  Uses:
 *  1. Distinguish instance variable from parameter (same name)
 *  2. Call another constructor → this()
 *  3. Pass current object as argument
 *  4. Return current object (method chaining)
 *  5. Call instance method
 *
 * ============================================================
 * static KEYWORD
 * ============================================================
 *
 *  Belongs to the CLASS, not to any specific instance.
 *
 *  static field   → shared across ALL objects of the class
 *  static method  → can be called without creating object
 *  static block   → runs once when class is loaded
 *
 *  Rules:
 *  - static methods CANNOT access instance (non-static) fields
 *  - static methods CANNOT use 'this' keyword
 *  - Instance methods CAN access static fields
 *
 * ============================================================
 * ACCESS MODIFIERS
 * ============================================================
 *
 *  Modifier     Same Class  Same Package  Subclass  Anywhere
 *  ----------   ----------  ------------  --------  --------
 *  private      ✔           ✘             ✘         ✘
 *  (default)    ✔           ✔             ✘         ✘
 *  protected    ✔           ✔             ✔         ✘
 *  public       ✔           ✔             ✔         ✔
 *
 * ============================================================
 * PILLAR 1 — ENCAPSULATION
 * ============================================================
 *
 *  Bundling data (fields) and methods together in a class,
 *  and RESTRICTING direct access to data using private.
 *  Data is accessed only through GETTERS and SETTERS.
 *
 *  Benefits:
 *  ✔ Data hiding / security
 *  ✔ Validation in setters
 *  ✔ Control over data access
 *  ✔ Loose coupling
 *
 *  Pattern:
 *  private String name;           // hidden
 *  public String getName() {...}  // getter
 *  public void setName(...) {...} // setter with validation
 *
 * ============================================================
 * PILLAR 2 — INHERITANCE
 * ============================================================
 *
 *  Mechanism where a CHILD (subclass) inherits fields and
 *  methods from a PARENT (superclass).
 *  Promotes code REUSABILITY.
 *  Uses 'extends' keyword.
 *
 *  Types:
 *  1. Single      → A extends B
 *  2. Multilevel  → A extends B extends C
 *  3. Hierarchical→ B extends A, C extends A
 *  4. Multiple    → NOT supported with classes (use interfaces)
 *  5. Hybrid      → combination (via interfaces)
 *
 *  super keyword:
 *  - super.field    → access parent field
 *  - super.method() → call parent method
 *  - super()        → call parent constructor
 *
 *  What is NOT inherited:
 *  - private members
 *  - constructors
 *
 * ============================================================
 * PILLAR 3 — POLYMORPHISM
 * ============================================================
 *
 *  "Many forms" — one entity behaves differently in different
 *  contexts.
 *
 *  1. Compile-time (Static) Polymorphism:
 *     → Method OVERLOADING
 *     → Same method name, different parameters
 *     → Resolved at COMPILE time
 *
 *  2. Runtime (Dynamic) Polymorphism:
 *     → Method OVERRIDING
 *     → Child class redefines parent method
 *     → Resolved at RUNTIME via dynamic dispatch
 *
 *  Overloading vs Overriding:
 *  Feature      Overloading        Overriding
 *  ---------    ---------------    ---------------
 *  Location     Same class         Child class
 *  Signature    Must differ        Must be same
 *  Return type  Can differ         Must match (or covariant)
 *  Resolved     Compile time       Runtime
 *  static       Yes (can overload) No (can't truly override)
 *  @Override    Not needed         Recommended
 *
 * ============================================================
 * PILLAR 4 — ABSTRACTION
 * ============================================================
 *
 *  Hiding IMPLEMENTATION details, showing only ESSENTIALS.
 *
 *  Achieved via:
 *  1. Abstract class (0–100% abstract)
 *  2. Interface     (100% abstract — Java 7)
 *                   (can have default/static — Java 8+)
 *
 *  abstract class:
 *  - Declared with 'abstract' keyword
 *  - Can have abstract AND concrete methods
 *  - CANNOT be instantiated directly
 *  - Subclass MUST implement all abstract methods (or be abstract itself)
 *
 *  interface:
 *  - All methods implicitly public abstract (pre Java 8)
 *  - All fields implicitly public static final
 *  - A class can implement MULTIPLE interfaces
 *  - Java 8+: default methods, static methods
 *  - Java 9+: private methods
 *
 * ============================================================
 * FINAL KEYWORD
 * ============================================================
 *
 *  final variable → value cannot change (constant)
 *  final method   → cannot be overridden in child
 *  final class    → cannot be subclassed (e.g., String)
 *
 * ============================================================
 * instanceof OPERATOR
 * ============================================================
 *
 *  Checks if object is an instance of a class or interface.
 *  Returns true/false.
 *  Useful before casting to avoid ClassCastException.
 *
 * ============================================================
 * OBJECT CLASS — Root of all classes
 * ============================================================
 *
 *  Every class in Java implicitly extends Object.
 *  Key methods from Object:
 *  - toString()    → string representation
 *  - equals()      → content equality
 *  - hashCode()    → hash value (used in HashMap/HashSet)
 *  - getClass()    → runtime class info
 *  - clone()       → create object copy
 *  - finalize()    → called before GC (deprecated Java 9+)
 *
 * ============================================================
 */

import java.util.*;

public class OOPBasics {

    // ── helpers ──
    static void sep()  { System.out.println("  " + "─".repeat(54)); }
    static void header(String t) {
        System.out.println("\n  ╔════════════════════════════════════════════════╗");
        System.out.printf ("  ║  %-46s║%n", t);
        System.out.println("  ╚════════════════════════════════════════════════╝");
    }
    static void sub(String s) { System.out.println("\n  ── " + s + " ──"); }
    static void pillar(String s) {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.printf ("║  %-48s║%n", s);
        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#    OBJECT-ORIENTED PROGRAMMING IN JAVA   #");
        System.out.println("############################################");

        // ============================================================
        // 1. CLASS AND OBJECT BASICS
        // ============================================================
        header("1. CLASS AND OBJECT BASICS");

        sub("Creating Objects");
        Car car1 = new Car("Toyota","Camry","Red",2022,0);
        Car car2 = new Car("Honda","Civic","Blue",2021,0);
        Car car3 = new Car();   // default constructor

        System.out.println("  car1             : " + car1);
        System.out.println("  car2             : " + car2);
        System.out.println("  car3 (default)   : " + car3);

        // Accessing fields & methods
        sub("Accessing Fields & Methods");
        car1.accelerate(60);
        car1.accelerate(30);
        car1.brake(20);
        System.out.println("  car1 speed       : " + car1.getSpeed() + " km/h");
        System.out.println("  car2 color       : " + car2.getColor());

        // Object reference
        sub("Object References");
        Car ref1 = car1;         // ref1 points to SAME object as car1
        Car ref2 = new Car("Toyota","Camry","Red",2022,0); // different object
        System.out.println("  car1 == ref1     : " + (car1 == ref1));  // true (same ref)
        System.out.println("  car1 == ref2     : " + (car1 == ref2));  // false (diff obj)
        System.out.println("  car1.equals(ref2): " + car1.equals(ref2)); // true (same content)

        // null reference
        sub("null Reference");
        Car nullCar = null;
        System.out.println("  nullCar == null  : " + (nullCar == null));
        // Demonstrate safe null checking
        System.out.println("  ✘ Cannot call accelerate() on nullCar - would cause NullPointerException");
        // Note: The following if-block is intentionally dead code to show what happens without null check
        // if (nullCar != null) {
        //     nullCar.accelerate(10);  // This would be unsafe without null check
        // }

        // Object info
        sub("Object Info");
        System.out.println("  getClass()       : " + car1.getClass().getName());
        System.out.println("  getSimpleName()  : " + car1.getClass().getSimpleName());
        System.out.println("  hashCode()       : " + car1.hashCode());
        System.out.println("  toString()       : " + car1.toString());

        // ============================================================
        // 2. CONSTRUCTORS
        // ============================================================
        header("2. CONSTRUCTORS");

        sub("Default vs Parameterized");
        Book b1 = new Book();                          // default
        Book b2 = new Book("Clean Code");              // 1-param
        Book b3 = new Book("Effective Java","Bloch");  // 2-param
        Book b4 = new Book("Design Patterns","GoF",60.0); // 3-param
        System.out.println("  Default         : " + b1);
        System.out.println("  1-param         : " + b2);
        System.out.println("  2-param         : " + b3);
        System.out.println("  3-param         : " + b4);

        sub("Copy Constructor");
        Book b5 = new Book(b4);   // copy constructor
        System.out.println("  Original        : " + b4);
        System.out.println("  Copy            : " + b5);
        System.out.println("  Same object?    : " + (b4 == b5));  // false
        System.out.println("  Same content?   : " + b4.equals(b5));// true

        sub("Constructor Chaining with this()");
        System.out.println("  Constructor chain output:");
        Point p1 = new Point();         // calls this(0,0)
        Point p2 = new Point(5);        // calls this(5,0)
        Point p3 = new Point(3,4);      // main constructor
        System.out.println("  p1 = " + p1);
        System.out.println("  p2 = " + p2);
        System.out.println("  p3 = " + p3);

        // ============================================================
        // 3. this KEYWORD
        // ============================================================
        header("3. this KEYWORD");

        sub("this — Distinguish Field from Parameter");
        Person person = new Person("Alice", 25, "Mumbai");
        System.out.println("  Person          : " + person);

        sub("this — Method Chaining (Builder Pattern)");
        Builder builder = new Builder()
                .setName("Bob")
                .setAge(30)
                .setCity("Delhi")
                .setSalary(75000);
        System.out.println("  Builder result  : " + builder.build());

        sub("this — Pass Current Object");
        Printer printer = new Printer();
        printer.printPerson(person);

        // ============================================================
        // 4. static KEYWORD
        // ============================================================
        header("4. static KEYWORD");

        sub("static Fields — Shared Across Objects");
        System.out.println("  Objects created : " + Counter.count);
        new Counter("C1");  // Create object to increment static counter
        new Counter("C2");  // Create object to increment static counter
        new Counter("C3");  // Create object to increment static counter
        System.out.println("  After 3 new     : Counter.count = " + Counter.count);
        System.out.println("  Via Counter.count : " + Counter.count);  // correct static access
        System.out.println("  Via Counter.count : " + Counter.count);  // correct static access

        sub("static Methods");
        System.out.println("  MathUtils.add(3,4)    : " + MathUtils.add(3,4));
        System.out.println("  MathUtils.square(5)   : " + MathUtils.square(5));
        System.out.println("  MathUtils.isPrime(17) : " + MathUtils.isPrime(17));
        System.out.println("  MathUtils.isPrime(15) : " + MathUtils.isPrime(15));
        System.out.println("  MathUtils.PI          : " + MathUtils.PI);

        sub("static Block — Class Loading Initialization");
        System.out.println("  Config.DB_URL   : " + Config.DB_URL);
        System.out.println("  Config.version  : " + Config.version);

        sub("static vs Instance");
        System.out.println("  static: shared, class-level, no 'this'");
        System.out.println("  instance: per-object, needs object, has 'this'");

        // ============================================================
        // PILLAR 1 — ENCAPSULATION
        // ============================================================
        pillar("PILLAR 1: ENCAPSULATION");

        header("5. Encapsulation — Data Hiding + Validation");

        sub("BankAccount with Encapsulation");
        BankAccount acc = new BankAccount("ACC001","Alice",10000);
        System.out.println("  Created         : " + acc);

        // Access through methods only
        acc.deposit(5000);
        acc.withdraw(3000);
        acc.withdraw(20000);  // will be rejected (insufficient)
        System.out.println("  Balance         : ₹" + acc.getBalance());

        // Validation in setters
        sub("Validation in Setters");
        Student2 stu = new Student2("Alice",20,85.5);
        System.out.println("  Valid student   : " + stu);
        stu.setAge(-5);        // rejected
        stu.setMarks(105);     // rejected
        stu.setName("");       // rejected
        stu.setAge(21);        // accepted
        System.out.println("  After valid set : " + stu);

        // Immutable class
        sub("Immutable Class (all final + no setters)");
        ImmutablePoint ip = new ImmutablePoint(3, 4);
        System.out.println("  ImmutablePoint  : " + ip);
        System.out.println("  distance(0,0)   : " + ip.distanceTo(0, 0));
        ImmutablePoint ip2 = ip.translate(2, 3); // returns NEW object
        System.out.println("  After translate : " + ip2 + " (original: " + ip + ")");

        // ============================================================
        // PILLAR 2 — INHERITANCE
        // ============================================================
        pillar("PILLAR 2: INHERITANCE");

        header("6. Inheritance — extends");

        sub("Single Inheritance: Animal → Dog");
        Animal animal = new Animal("Animal",5);
        Dog dog = new Dog("Buddy",3,"Golden Retriever");
        Cat cat = new Cat("Whiskers",4,"Tabby");

        System.out.println("  Animal          : " + animal);
        System.out.println("  Dog             : " + dog);
        System.out.println("  Cat             : " + cat);

        animal.eat();
        animal.sleep();
        dog.eat();       // inherited from Animal
        dog.bark();      // Dog-specific
        cat.eat();       // inherited
        cat.purr();      // Cat-specific

        sub("Accessing Parent with super");
        dog.displayInfo();  // calls super methods

        sub("Multilevel Inheritance: Vehicle → Car → ElectricCar");
        ElectricCar tesla = new ElectricCar("Tesla","Model3","White",2023,100);
        System.out.println("  ElectricCar     : " + tesla);
        tesla.accelerate(80);
        tesla.charge(20);
        tesla.showRange();

        sub("Hierarchical Inheritance");
        System.out.println("  Shape hierarchy: Shape → Circle, Rectangle, Triangle");
        Circle  circle = new Circle(7.0);
        Rect    rect   = new Rect(5.0,8.0);
        Triangle tri   = new Triangle(3.0,4.0,5.0);

        Shape[] shapes = {circle, rect, tri};
        System.out.printf("  %-12s %10s %10s%n","Shape","Area","Perimeter");
        sep();
        for (Shape sh : shapes) {
            System.out.printf("  %-12s %10.2f %10.2f%n",
                    sh.getClass().getSimpleName(),
                    sh.area(), sh.perimeter());
        }

        sub("What is NOT inherited");
        System.out.println("  ✘ private fields/methods");
        System.out.println("  ✘ constructors");
        System.out.println("  ✔ public, protected fields/methods");
        System.out.println("  ✔ package-private (same package)");

        // instanceof
        sub("instanceof Operator");
        System.out.println("  dog instanceof Dog    : " + (dog instanceof Dog));
        System.out.println("  dog instanceof Animal : " + (dog instanceof Animal));
        // System.out.println("  dog instanceof Cat    : " + (dog instanceof Cat)); // ❌ Compile error: Dog cannot be Cat
        System.out.println("  dog instanceof Object : " + (dog instanceof Object));

        // ============================================================
        // PILLAR 3 — POLYMORPHISM
        // ============================================================
        pillar("PILLAR 3: POLYMORPHISM");

        header("7. Compile-Time Polymorphism — Method Overloading");

        sub("Overloaded Methods — Same Name, Different Params");
        Calculator calc = new Calculator();
        System.out.println("  add(int,int)    : " + calc.add(5, 10));
        System.out.println("  add(double,dbl) : " + calc.add(5.5, 10.5));
        System.out.println("  add(int,int,int): " + calc.add(5, 10, 15));
        System.out.println("  add(String,Str) : " + calc.add("Hello"," World"));
        System.out.println("  add(long,long)  : " + calc.add(100L, 200L));
        System.out.println("  multiply(2,3)   : " + calc.multiply(2, 3));
        System.out.println("  multiply(2.5,4) : " + calc.multiply(2.5, 4));

        sub("Overloading — Type Promotion");
        System.out.println("  print(byte)     : "); calc.print((byte)10);
        System.out.println("  print(int)      : "); calc.print(100);
        System.out.println("  print(double)   : "); calc.print(3.14);
        System.out.println("  print(String)   : "); calc.print("Java");

        header("8. Runtime Polymorphism — Method Overriding");

        sub("Overriding — Child redefines parent method");
        // Upcasting: parent reference, child object
        Animal[] animals = {
            new Animal("Generic Animal", 1),
            new Dog("Rex",    2, "German Shepherd"),
            new Cat("Luna",   3, "Persian"),
            new Dog("Max",    4, "Labrador"),
            new Cat("Simba",  5, "Siamese")
        };

        System.out.println("  Dynamic dispatch — makeSound():");
        for (Animal a : animals) {
            System.out.printf("  %-20s → ", a.getClass().getSimpleName()
                    + "(" + a.getName() + ")");
            a.makeSound();    // runtime dispatch to actual type
        }

        sub("Downcasting — Parent ref → Child type");
        Animal animalRef = new Dog("Buddy", 3, "Poodle");
        System.out.println("  animalRef type  : " + animalRef.getClass().getSimpleName());
        if (animalRef instanceof Dog) {
            Dog downcastDog = (Dog) animalRef;   // safe downcast
            downcastDog.bark();
            System.out.println("  Breed           : " + downcastDog.getBreed());
        }

        // ClassCastException
        // ClassCastException demonstration
        try {
            Animal a = new Dog("Max",2,"Lab");
            @SuppressWarnings("unused")
            Cat unused = (Cat) a;  // Intentionally unused - demonstrates ClassCastException
        } catch (ClassCastException e) {
            System.out.println("  ✘ ClassCastException: Dog → Cat invalid");
        }

        sub("Overriding Rules");
        System.out.println("  ✔ Same method name, params, return type");
        System.out.println("  ✔ Access modifier can be same or WIDER");
        System.out.println("  ✔ Can throw fewer/narrower exceptions");
        System.out.println("  ✔ Use @Override annotation (catches mistakes)");
        System.out.println("  ✘ Cannot override static, final, private");
        System.out.println("  ✘ Cannot narrow access modifier");

        // ============================================================
        // PILLAR 4 — ABSTRACTION
        // ============================================================
        pillar("PILLAR 4: ABSTRACTION");

        header("9. Abstract Classes");

        sub("Abstract Class — Partial Implementation");
        // Cannot instantiate abstract class
        // Shape sh = new Shape("test"); // ✘ compile error

        // Polymorphism with abstract class
        Shape[] shapesAbs = {
            new Circle(5.0),
            new Rect(4.0, 6.0),
            new Triangle(3.0, 4.0, 5.0)
        };

        System.out.println("  Abstract Shape → concrete implementations:");
        System.out.printf("  %-12s %10s %10s %10s%n",
                "Shape","Area","Perimeter","Color");
        sep();
        for (Shape sh : shapesAbs) {
            System.out.printf("  %-12s %10.2f %10.2f %10s%n",
                    sh.getClass().getSimpleName(),
                    sh.area(), sh.perimeter(), sh.color);
        }

        // Template method pattern
        sub("Template Method Pattern with Abstract Class");
        DataProcessor csvProc  = new CSVProcessor();
        DataProcessor jsonProc = new JSONProcessor();
        System.out.println("  CSV Processing:");
        csvProc.process("data.csv");
        System.out.println("  JSON Processing:");
        jsonProc.process("data.json");

        header("10. Interfaces");

        sub("Interface — Full Contract");
        // Multiple implementations
        Drawable[] drawables = {
            new CircleShape(5),
            new Square(4),
            new Line(10)
        };
        System.out.println("  Drawable implementations:");
        for (Drawable d : drawables) {
            System.out.printf("  %-15s → draw: ", d.getClass().getSimpleName());
            d.draw();
            System.out.printf("  %-15s → area: %.2f%n", "", d.getArea());
        }

        sub("Multiple Interface Implementation");
        Robot robot = new Robot("R2D2");
        robot.move("North");
        robot.fly(100);
        robot.speak("Hello Human!");
        robot.charge(80);
        System.out.println("  Implements Movable, Flyable, Speakable, Chargeable");

        sub("Interface Default Methods (Java 8+)");
        Vehicle car3I = new SportsCar("Ferrari","F8");
        Vehicle truck  = new Truck("Volvo","FH16");
        car3I.start();
        car3I.stop();
        car3I.refuel(50);       // default method
        car3I.displayInfo();    // default method
        System.out.println();
        truck.start();
        truck.stop();
        truck.refuel(200);
        truck.displayInfo();

        sub("Interface static Methods (Java 8+)");
        System.out.println("  Vehicle.maxSpeed()  : " + Vehicle.getMaxSpeedLimit());
        System.out.println("  Vehicle.fuelTypes() : " + Vehicle.getFuelTypes());

        sub("Functional Interface (SAM — Java 8+)");
        // Can be used with lambda
        Validator emailVal = email -> email.contains("@") && email.contains(".");
        Validator phoneVal = phone -> phone.matches("\\d{10}");

        String[] testEmails = {"alice@gmail.com","bob.invalid","charlie@co.in"};
        String[] testPhones = {"9876543210","123","abcdefghij"};

        System.out.println("  Email validation:");
        for (String e : testEmails)
            System.out.printf("  %-20s → %s%n", e,
                    emailVal.isValid(e) ? "✔ Valid" : "✘ Invalid");

        System.out.println("  Phone validation:");
        for (String ph : testPhones)
            System.out.printf("  %-15s → %s%n", ph,
                    phoneVal.isValid(ph) ? "✔ Valid" : "✘ Invalid");

        header("11. Abstract Class vs Interface");

        sub("Side-by-Side Comparison");
        System.out.printf("  %-28s %-20s %-20s%n",
                "Feature","Abstract Class","Interface");
        sep();
        String[][] comparison = {
            {"Instantiation",         "✘ Cannot",           "✘ Cannot"},
            {"Constructor",           "✔ Has",              "✘ No"},
            {"Abstract methods",      "✔ Optional",         "✔ All (pre-Java8)"},
            {"Concrete methods",      "✔ Yes",              "✔ default (Java8+)"},
            {"Fields",                "Any type",           "public static final"},
            {"Access modifiers",      "Any",                "public only"},
            {"Extends/Implements",    "1 class only",       "Multiple allowed"},
            {"When to use",           "IS-A + shared code", "CAN-DO contract"},
        };
        for (String[] row : comparison)
            System.out.printf("  %-28s %-20s %-20s%n", row[0],row[1],row[2]);

        // ============================================================
        // 12. final KEYWORD
        // ============================================================
        header("12. final KEYWORD");

        sub("final Variable — Constant");
        final int MAX = 100;
        final double PI = 3.14159;
        System.out.println("  final MAX       : " + MAX);
        System.out.println("  final PI        : " + PI);

        sub("final Field in Class");
        FinalDemo fd = new FinalDemo("Java");
        System.out.println("  FinalDemo       : " + fd);

        sub("final Method — Cannot Override");
        System.out.println("  SecureAccount (final method):");
        SecureAccount sa = new SecureAccount("Alice",5000);
        sa.showBalance();  // final method — cannot be overridden

        sub("final Class — Cannot Subclass");
        System.out.println("  String is final → cannot extend String");
        System.out.println("  Integer is final → cannot extend Integer");
        System.out.println("  MathConstants is final → sealed constants");

        // ============================================================
        // 13. OBJECT CLASS METHODS
        // ============================================================
        header("13. Object Class — Root of All Classes");

        sub("toString()");
        Product2 prod1 = new Product2("Laptop",75000);
        Product2 prod2 = new Product2("Phone", 25000);
        System.out.println("  Default toString (without override): shows hashCode");
        System.out.println("  Custom toString : " + prod1);

        sub("equals() & hashCode()");
        System.out.println("  prod1.equals(prod2) : " + prod1.equals(prod2)); // false
        Product2 prod3 = new Product2("Laptop",75000);
        System.out.println("  prod1.equals(prod3) : " + prod1.equals(prod3)); // true
        System.out.println("  prod1 == prod3      : " + (prod1 == prod3));    // false
        System.out.println("  prod1.hashCode()    : " + prod1.hashCode());
        System.out.println("  prod3.hashCode()    : " + prod3.hashCode());
        System.out.println("  hashCodes equal?    : " + (prod1.hashCode()==prod3.hashCode()));

        sub("hashCode contract");
        System.out.println("  If a.equals(b) → a.hashCode() MUST equal b.hashCode()");
        System.out.println("  If !a.equals(b) → hashCodes MAY or MAY NOT be equal");
        System.out.println("  Consistent: same object → same hashCode");

        sub("getClass()");
        Object[] objs = {42, "Hello", 3.14, true, new Product2("X",10), new ArrayList<>()};
        for (Object o : objs) {
            System.out.printf("  %-15s → %s%n",
                    o.toString().substring(0, Math.min(12, o.toString().length())),
                    o.getClass().getSimpleName());
        }

        // ============================================================
        // 14. REAL-WORLD OOP EXAMPLES
        // ============================================================
        header("14. REAL-WORLD OOP EXAMPLES");

        // Example 1: Banking System
        System.out.println("  ── Banking System ──");
        bankingDemo();

        // Example 2: School Management
        System.out.println("\n  ── School Management System ──");
        schoolDemo();

        // Example 3: E-commerce System
        System.out.println("\n  ── E-commerce System ──");
        ecommerceDemo();

        System.out.println("\n############################################");
        System.out.println("#   OOP Basics in Java — Done! ✔          #");
        System.out.println("############################################");
    }

    // ============================================================
    // REAL-WORLD DEMO METHODS
    // ============================================================

    static void bankingDemo() {
        // Polymorphic bank accounts
        BankAccount2[] accounts = {
            new SavingsAccount("SAV001","Alice",50000,0.05),
            new CurrentAccount("CUR001","Bob Corp",100000,10000),
            new SavingsAccount("SAV002","Charlie",25000,0.04)
        };

        System.out.printf("  %-10s %-12s %-10s %-10s%n",
                "AccNo","Holder","Balance","Type");
        sep();
        for (BankAccount2 acc : accounts)
            System.out.printf("  %-10s %-12s %10.2f %-10s%n",
                    acc.accNo, acc.holder,
                    acc.balance, acc.getType());

        System.out.println("\n  Transactions:");
        accounts[0].deposit(10000);
        accounts[0].withdraw(5000);
        ((SavingsAccount)accounts[0]).addInterest();
        accounts[1].deposit(50000);
        accounts[1].withdraw(120000); // overdraft allowed for current
        System.out.println("\n  After transactions:");
        for (BankAccount2 acc : accounts)
            System.out.printf("  %-10s %-12s %10.2f%n",
                    acc.accNo, acc.holder, acc.balance);
    }

    static void schoolDemo() {
        List<SchoolPerson> persons = new ArrayList<>();
        persons.add(new Teacher("Alice","Mathematics","T001"));
        persons.add(new Teacher("Bob","Science","T002"));
        persons.add(new SchoolStudent("Charlie",9,"S001",88.5));
        persons.add(new SchoolStudent("Diana",  10,"S002",92.0));
        persons.add(new SchoolStudent("Eve",    9, "S003",78.5));

        System.out.printf("  %-12s %-8s %-10s%n","Name","Role","Details");
        sep();
        for (SchoolPerson p : persons) {
            System.out.printf("  %-12s %-8s %s%n",
                    p.name, p.getRole(), p.getDetails());
        }

        // Polymorphic greet
        System.out.println("\n  Greetings:");
        for (SchoolPerson p : persons) {
            System.out.print("  ");
            p.greet();
        }
    }

    static void ecommerceDemo() {
        List<EProduct> catalog = new ArrayList<>();
        catalog.add(new EProduct("Laptop",  75000, 10, "Electronics"));
        catalog.add(new EProduct("Phone",   25000, 25, "Electronics"));
        catalog.add(new EProduct("T-Shirt",   800,100, "Clothing"));
        catalog.add(new EProduct("Jeans",    2000, 50, "Clothing"));
        catalog.add(new EProduct("Novel",     500, 75, "Books"));

        Cart cart = new Cart("USR001");
        cart.addItem(catalog.get(0), 1); // Laptop x1
        cart.addItem(catalog.get(1), 2); // Phone x2
        cart.addItem(catalog.get(4), 3); // Novel x3
        cart.displayCart();
        cart.checkout(new CashPayment());
        System.out.println();
        cart.addItem(catalog.get(2), 5); // T-Shirt x5
        cart.checkout(new OnlinePayment("CARD-1234"));
    }
}

// ============================================================
// CLASSES FOR DEMONSTRATIONS
// ============================================================

// ── Car class (basic OOP) ──
class Car {
    private String brand, model, color;
    private int year;
    private int speed;
    static int totalCars = 0;

    Car() {
        this("Unknown","Unknown","White",2024,0);
    }
    Car(String brand, String model, String color, int year, int speed) {
        this.brand=brand; this.model=model; this.color=color;
        this.year=year;   this.speed=speed;
        totalCars++;
    }

    void accelerate(int amount) {
        speed = Math.min(speed + amount, 200);
        System.out.printf("  Accelerate +%d → speed=%d km/h%n", amount, speed);
    }
    void brake(int amount) {
        speed = Math.max(speed - amount, 0);
        System.out.printf("  Brake -%d → speed=%d km/h%n", amount, speed);
    }

    int    getSpeed() { return speed; }
    String getColor() { return color; }
    String getBrand() { return brand; }
    String getModel() { return model; }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Car)) return false;
        Car c = (Car) o;
        return brand.equals(c.brand) && model.equals(c.model)
                && color.equals(c.color) && year == c.year;
    }
    @Override public int hashCode() {
        return Objects.hash(brand, model, color, year);
    }
    @Override public String toString() {
        return String.format("Car{%s %s, %s, %d, speed=%d}",
                brand, model, color, year, speed);
    }
}

// ── Book class (constructor demo) ──
class Book {
    String title, author;
    double price;
    Book() { this("Unknown","Unknown",0.0); }
    Book(String title) { this(title,"Unknown",0.0); }
    Book(String title, String author) { this(title,author,0.0); }
    Book(String title, String author, double price) {
        this.title=title; this.author=author; this.price=price;
    }
    Book(Book other) { this(other.title, other.author, other.price); }
    @Override public boolean equals(Object o) {
        if (!(o instanceof Book)) return false;
        Book b = (Book)o;
        return title.equals(b.title) && author.equals(b.author)
                && price==b.price;
    }
    @Override public String toString() {
        return String.format("Book{'%s' by %s, $%.2f}", title, author, price);
    }
}

// ── Point class (this() chaining) ──
class Point {
    int x, y;
    Point() {
        this(0, 0);
        System.out.println("    Point() → calls this(0,0)");
    }
    Point(int x) {
        this(x, 0);
        System.out.println("    Point(x) → calls this(x,0)");
    }
    Point(int x, int y) {
        this.x=x; this.y=y;
        System.out.println("    Point(x,y) → sets x=" + x + " y=" + y);
    }
    double distanceTo(Point other) {
        return Math.sqrt(Math.pow(x-other.x,2) + Math.pow(y-other.y,2));
    }
    @Override public String toString() { return "(" + x + "," + y + ")"; }
}

// ── Person class (this keyword) ──
class Person {
    String name, city;
    int age;
    Person(String name, int age, String city) {
        this.name=name; this.age=age; this.city=city;
    }
    @Override public String toString() {
        return name + "(age="+age+", city="+city+")";
    }
}

// ── Builder Pattern (method chaining with this) ──
class Builder {
    private String name="", city="";
    private int age=0;
    private double salary=0;
    Builder setName(String n)   { this.name=n;   return this; }
    Builder setAge(int a)       { this.age=a;    return this; }
    Builder setCity(String c)   { this.city=c;   return this; }
    Builder setSalary(double s) { this.salary=s; return this; }
    String build() {
        return "Person{name=" + name + ", age=" + age
                + ", city=" + city + ", salary=" + salary + "}";
    }
}

// ── Printer (this as argument) ──
class Printer {
    void printPerson(Person p) {
        System.out.println("  Printing: " + p);
    }
}

// ── Counter (static field) ──
class Counter {
    static int count = 0;
    String name;
    Counter(String name) {
        this.name=name; count++;
        System.out.println("  Created: " + name + " (total=" + count + ")");
    }
}

// ── MathUtils (static methods) ──
class MathUtils {
    static final double PI = 3.14159265;
    private MathUtils() {}  // prevent instantiation
    static int    add(int a, int b)    { return a+b; }
    static int    square(int n)        { return n*n; }
    static boolean isPrime(int n) {
        if (n<2) return false;
        for (int i=2; i<=Math.sqrt(n); i++)
            if (n%i==0) return false;
        return true;
    }
}

// ── Config (static block) ──
class Config {
    static String DB_URL;
    static String version;
    static {
        System.out.println("  [Static Block] Loading Config...");
        DB_URL  = "jdbc:mysql://localhost:3306/mydb";
        version = "2.1.0";
        System.out.println("  [Static Block] Config loaded!");
    }
}

// ── BankAccount (encapsulation) ──
class BankAccount {
    private final String accNo;
    private final String holder;
    private double balance;
    private List<String> txHistory = new ArrayList<>();

    BankAccount(String accNo, String holder, double initialBalance) {
        this.accNo=accNo; this.holder=holder; this.balance=initialBalance;
        txHistory.add("Account opened with ₹" + initialBalance);
    }
    void deposit(double amount) {
        if (amount <= 0) { System.out.println("  ✘ Invalid deposit"); return; }
        balance += amount;
        txHistory.add("Deposited ₹" + amount);
        System.out.printf("  ✔ Deposited ₹%.0f | Balance: ₹%.0f%n", amount, balance);
    }
    void withdraw(double amount) {
        if (amount <= 0) { System.out.println("  ✘ Invalid amount"); return; }
        if (amount > balance) {
            System.out.printf("  ✘ Insufficient funds (balance=₹%.0f)%n", balance);
            return;
        }
        balance -= amount;
        txHistory.add("Withdrew ₹" + amount);
        System.out.printf("  ✔ Withdrew ₹%.0f  | Balance: ₹%.0f%n", amount, balance);
    }
    double getBalance()     { return balance; }
    String getAccNo()       { return accNo;   }
    String getHolder()      { return holder;  }
    List<String> getHistory(){ return Collections.unmodifiableList(txHistory); }
    @Override public String toString() {
        return String.format("Account{%s, holder=%s, balance=₹%.0f}",
                accNo, holder, balance);
    }
}

// ── Student2 (encapsulation with validation) ──
class Student2 {
    private String name;
    private int    age;
    private double marks;
    Student2(String name, int age, double marks) {
        setName(name); setAge(age); setMarks(marks);
    }
    void setName(String n) {
        if (n == null || n.trim().isEmpty()) {
            System.out.println("  ✘ Name cannot be empty"); return;
        }
        this.name = n;
    }
    void setAge(int a) {
        if (a < 0 || a > 150) {
            System.out.println("  ✘ Invalid age: " + a); return;
        }
        this.age = a;
    }
    void setMarks(double m) {
        if (m < 0 || m > 100) {
            System.out.println("  ✘ Marks must be 0-100, got: " + m); return;
        }
        this.marks = m;
    }
    String getName()  { return name;  }
    int    getAge()   { return age;   }
    double getMarks() { return marks; }
    @Override public String toString() {
        return String.format("Student{%s, age=%d, marks=%.1f}", name, age, marks);
    }
}

// ── ImmutablePoint ──
final class ImmutablePoint {
    private final int x, y;
    ImmutablePoint(int x, int y) { this.x=x; this.y=y; }
    int getX() { return x; }
    int getY() { return y; }
    ImmutablePoint translate(int dx, int dy) { return new ImmutablePoint(x+dx,y+dy); }
    double distanceTo(int ox, int oy) {
        return Math.sqrt(Math.pow(x-ox,2)+Math.pow(y-oy,2));
    }
    @Override public String toString() { return "("+x+","+y+")"; }
}

// ── Animal hierarchy (Inheritance + Polymorphism) ──
class Animal {
    protected String name;
    protected int age;
    Animal(String name, int age) { this.name=name; this.age=age; }
    void eat()   { System.out.println("  " + name + " is eating."); }
    void sleep() { System.out.println("  " + name + " is sleeping."); }
    void makeSound() { System.out.println(name + " makes a sound."); }
    String getName() { return name; }
    @Override public String toString() {
        return getClass().getSimpleName()+"("+name+", age="+age+")";
    }
}

class Dog extends Animal {
    private String breed;
    Dog(String name, int age, String breed) {
        super(name, age); this.breed=breed;
    }
    @Override public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
    void bark()  { System.out.println("  " + name + " barks loudly!"); }
    String getBreed() { return breed; }
    void displayInfo() {
        System.out.println("  Dog Info: " + name + ", Breed=" + breed);
        super.eat();   // calling super method
    }
    @Override public String toString() {
        return super.toString() + " Breed=" + breed;
    }
}

class Cat extends Animal {
    private String pattern;
    Cat(String name, int age, String pattern) {
        super(name, age); this.pattern=pattern;
    }
    @Override public void makeSound() {
        System.out.println(name + " says: Meow! Meow!");
    }
    void purr() { System.out.println("  " + name + " purrs..."); }
    @Override public String toString() {
        return super.toString() + " Pattern=" + pattern;
    }
}

// ── Vehicle hierarchy (Multilevel) ──
class Vehicle2 {
    protected String brand;
    protected int speed = 0;
    Vehicle2(String brand) { this.brand=brand; }
    void accelerate(int s) { speed+=s; System.out.println("  Speed: "+speed+" km/h"); }
    void displayBrand()    { System.out.println("  Brand: "+brand); }
}

class Car2 extends Vehicle2 {
    protected String model;
    protected String color;
    protected int year;
    Car2(String brand, String model, String color, int year) {
        super(brand); this.model=model; this.color=color; this.year=year;
    }
    void honk() { System.out.println("  "+brand+" "+model+" goes BEEP!"); }
    @Override public String toString() {
        return brand+" "+model+" ("+color+", "+year+")";
    }
}

class ElectricCar extends Car2 {
    private int batteryPercent;
    ElectricCar(String brand, String model, String color, int year, int battery) {
        super(brand, model, color, year);
        this.batteryPercent = battery;
    }
    void charge(int percent) {
        batteryPercent = Math.min(batteryPercent+percent, 100);
        System.out.println("  Charging... Battery: "+batteryPercent+"%");
    }
    void showRange() {
        System.out.println("  Estimated range: "+(batteryPercent*5)+" km");
    }
    @Override public String toString() {
        return super.toString()+" [EV, battery="+batteryPercent+"%]";
    }
}

// ── Shape hierarchy (abstract) ──
abstract class Shape {
    protected String color;
    Shape(String color) { this.color=color; }
    abstract double area();
    abstract double perimeter();
    void display() {
        System.out.printf("  %s: area=%.2f perimeter=%.2f%n",
                getClass().getSimpleName(), area(), perimeter());
    }
}

class Circle extends Shape {
    private double radius;
    Circle(double r) { super("Red"); this.radius=r; }
    @Override public double area()      { return Math.PI*radius*radius; }
    @Override public double perimeter() { return 2*Math.PI*radius; }
}

class Rect extends Shape {
    private double w, h;
    Rect(double w, double h) { super("Blue"); this.w=w; this.h=h; }
    @Override public double area()      { return w*h; }
    @Override public double perimeter() { return 2*(w+h); }
}

class Triangle extends Shape {
    private double a, b, c;
    Triangle(double a, double b, double c) { super("Green"); this.a=a; this.b=b; this.c=c; }
    @Override public double area() {
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    @Override public double perimeter() { return a+b+c; }
}

// ── Template Method Pattern ──
abstract class DataProcessor {
    // Template method — defines skeleton
    final void process(String file) {
        readData(file);
        parseData();
        saveData();
        System.out.println("  Processing complete.");
    }
    abstract void readData(String file);
    abstract void parseData();
    void saveData() { System.out.println("  Saving to database..."); } // default impl
}

class CSVProcessor extends DataProcessor {
    @Override void readData(String f) { System.out.println("  Reading CSV: "+f); }
    @Override void parseData()        { System.out.println("  Parsing comma-separated values..."); }
}

class JSONProcessor extends DataProcessor {
    @Override void readData(String f) { System.out.println("  Reading JSON: "+f); }
    @Override void parseData()        { System.out.println("  Parsing JSON nodes..."); }
    @Override void saveData()         { System.out.println("  Saving as JSON documents..."); }
}

// ── Interfaces ──
interface Drawable {
    void draw();
    double getArea();
    default String getDescription() { return "I am a drawable shape"; }
}

class CircleShape implements Drawable {
    int r;
    CircleShape(int r) { this.r=r; }
    @Override public void   draw()    { System.out.println("Drawing Circle r=" + r); }
    @Override public double getArea() { return Math.PI*r*r; }
}

class Square implements Drawable {
    int side;
    Square(int s) { this.side=s; }
    @Override public void   draw()    { System.out.println("Drawing Square side=" + side); }
    @Override public double getArea() { return side*side; }
}

class Line implements Drawable {
    int length;
    Line(int l) { this.length=l; }
    @Override public void   draw()    { System.out.println("Drawing Line length=" + length); }
    @Override public double getArea() { return 0; }
}

// Multiple interfaces
interface Movable   { void move(String direction); }
interface Flyable   { void fly(int altitude); }
interface Speakable { void speak(String msg); }
interface Chargeable{ void charge(int percent); }

class Robot implements Movable, Flyable, Speakable, Chargeable {
    String name;
    Robot(String name) { this.name=name; }
    @Override public void move(String d)   { System.out.println("  "+name+" moving "+d); }
    @Override public void fly(int alt)     { System.out.println("  "+name+" flying at "+alt+"m"); }
    @Override public void speak(String m)  { System.out.println("  "+name+": \""+m+"\""); }
    @Override public void charge(int p)    { System.out.println("  "+name+" charging to "+p+"%"); }
}

// Interface with default/static methods
interface Vehicle {
    void start();
    void stop();
    String getType();
    default void refuel(int liters) {
        System.out.println("  Refueling " + liters + "L for " + getType());
    }
    default void displayInfo() {
        System.out.println("  Vehicle type: " + getType());
    }
    static String getMaxSpeedLimit() { return "120 km/h (highway)"; }
    static String getFuelTypes()     { return "Petrol, Diesel, Electric, CNG"; }
}

class SportsCar implements Vehicle {
    String brand, model;
    SportsCar(String brand, String model) { this.brand=brand; this.model=model; }
    @Override public void start()       { System.out.println("  "+brand+" "+model+" roars!"); }
    @Override public void stop()        { System.out.println("  "+brand+" "+model+" stops."); }
    @Override public String getType()   { return "Sports Car"; }
}

class Truck implements Vehicle {
    String brand, model;
    Truck(String brand, String model) { this.brand=brand; this.model=model; }
    @Override public void start()       { System.out.println("  "+brand+" "+model+" starts."); }
    @Override public void stop()        { System.out.println("  "+brand+" "+model+" stops."); }
    @Override public String getType()   { return "Heavy Truck"; }
}

// Functional interface
@FunctionalInterface
interface Validator { boolean isValid(String input); }

// ── final demos ──
class FinalDemo {
    final String lang;
    FinalDemo(String lang) { this.lang=lang; }
    @Override public String toString() { return "FinalDemo{lang="+lang+"}"; }
}

class SecureAccount {
    private String owner;
    private double balance;
    SecureAccount(String owner, double balance) {
        this.owner=owner; this.balance=balance;
    }
    final void showBalance() {   // final — cannot override
        System.out.printf("  %s's balance: ₹%.2f%n", owner, balance);
    }
}

// ── Object class methods ──
class Product2 {
    private String name;
    private double price;
    Product2(String name, double price) { this.name=name; this.price=price; }
    @Override public String toString() {
        return String.format("Product{%s, ₹%.0f}", name, price);
    }
    @Override public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof Product2)) return false;
        Product2 p = (Product2)o;
        return name.equals(p.name) && Double.compare(price,p.price)==0;
    }
    @Override public int hashCode() { return Objects.hash(name, price); }
}

// ── Banking real-world demo ──
abstract class BankAccount2 {
    String accNo, holder;
    double balance;
    BankAccount2(String accNo, String holder, double balance) {
        this.accNo=accNo; this.holder=holder; this.balance=balance;
    }
    abstract String getType();
    abstract void   withdraw(double amount);
    void deposit(double amount) {
        balance += amount;
        System.out.printf("  ✔ [%s] Deposited ₹%.0f | Balance: ₹%.0f%n",
                accNo, amount, balance);
    }
}

class SavingsAccount extends BankAccount2 {
    double interestRate;
    SavingsAccount(String no, String holder, double bal, double rate) {
        super(no,holder,bal); this.interestRate=rate;
    }
    @Override public String getType() { return "Savings"; }
    @Override public void withdraw(double amount) {
        if (amount > balance)
            System.out.printf("  ✘ [%s] Insufficient funds%n", accNo);
        else {
            balance -= amount;
            System.out.printf("  ✔ [%s] Withdrew ₹%.0f | Balance: ₹%.0f%n",
                    accNo, amount, balance);
        }
    }
    void addInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.printf("  ✔ [%s] Interest ₹%.0f added | Balance: ₹%.0f%n",
                accNo, interest, balance);
    }
}

class CurrentAccount extends BankAccount2 {
    double overdraftLimit;
    CurrentAccount(String no, String holder, double bal, double od) {
        super(no,holder,bal); this.overdraftLimit=od;
    }
    @Override public String getType() { return "Current"; }
    @Override public void withdraw(double amount) {
        if (amount > balance + overdraftLimit)
            System.out.printf("  ✘ [%s] Exceeds overdraft limit%n", accNo);
        else {
            balance -= amount;
            System.out.printf("  ✔ [%s] Withdrew ₹%.0f | Balance: ₹%.0f%s%n",
                    accNo, amount, balance, balance<0?" [OVERDRAFT]":"");
        }
    }
}

// ── School demo ──
abstract class SchoolPerson {
    String name;
    SchoolPerson(String name) { this.name=name; }
    abstract String getRole();
    abstract String getDetails();
    abstract void greet();
}

class Teacher extends SchoolPerson {
    String subject, empId;
    Teacher(String name, String subject, String empId) {
        super(name); this.subject=subject; this.empId=empId;
    }
    @Override public String getRole()    { return "Teacher"; }
    @Override public String getDetails() { return "Subject="+subject+" ID="+empId; }
    @Override public void greet() {
        System.out.println("Good day! I'm "+name+", your "+subject+" teacher.");
    }
}

class SchoolStudent extends SchoolPerson {
    int grade; String stuId; double gpa;
    SchoolStudent(String name, int grade, String stuId, double gpa) {
        super(name); this.grade=grade; this.stuId=stuId; this.gpa=gpa;
    }
    @Override public String getRole()    { return "Student"; }
    @Override public String getDetails() { return "Grade="+grade+" GPA="+gpa; }
    @Override public void greet() {
        System.out.println("Hi! I'm "+name+", a grade "+grade+" student.");
    }
}

// ── E-commerce demo ──
class EProduct {
    String name, category;
    double price;
    int stock;
    EProduct(String name, double price, int stock, String category) {
        this.name=name; this.price=price;
        this.stock=stock; this.category=category;
    }
}

class Cart {
    String userId;
    List<EProduct> items = new ArrayList<>();
    List<Integer>  qtys  = new ArrayList<>();
    Cart(String userId) { this.userId=userId; }
    void addItem(EProduct p, int qty) {
        items.add(p); qtys.add(qty);
        System.out.printf("  ✔ Added %-12s x%d to cart%n", p.name, qty);
    }
    void displayCart() {
        System.out.printf("  %-14s %8s %5s %10s%n","Item","Price","Qty","Subtotal");
        System.out.println("  " + "─".repeat(42));
        double total = 0;
        for (int i=0; i<items.size(); i++) {
            EProduct p = items.get(i);
            int q = qtys.get(i);
            double sub = p.price * q;
            total += sub;
            System.out.printf("  %-14s %8.0f %5d %10.0f%n",
                    p.name, p.price, q, sub);
        }
        System.out.println("  " + "─".repeat(42));
        System.out.printf("  %-29s %10.0f%n","Total:", total);
    }
    void checkout(PaymentMethod payment) {
        double total = 0;
        for (int i=0; i<items.size(); i++)
            total += items.get(i).price * qtys.get(i);
        payment.pay(total);
        items.clear(); qtys.clear();
    }
}

// Payment strategy (polymorphism)
interface PaymentMethod {
    void pay(double amount);
}

class CashPayment implements PaymentMethod {
    @Override public void pay(double amount) {
        System.out.printf("  💵 Cash payment of ₹%.0f received. Thank you!%n", amount);
    }
}

class OnlinePayment implements PaymentMethod {
    String cardNo;
    OnlinePayment(String cardNo) { this.cardNo=cardNo; }
    @Override public void pay(double amount) {
        System.out.printf("  💳 Online payment of ₹%.0f via %s. Success!%n",
                amount, cardNo);
    }
}



// ── Calculator class (for method overloading demo) ──
class Calculator {
    // Overloaded add() methods
    int add(int a, int b) {
        return a + b;
    }
    
    double add(double a, double b) {
        return a + b;
    }
    
    int add(int a, int b, int c) {
        return a + b + c;
    }
    
    String add(String a, String b) {
        return a + b;
    }
    
    long add(long a, long b) {
        return a + b;
    }
    
    // Overloaded multiply() methods
    int multiply(int a, int b) {
        return a * b;
    }
    
    double multiply(double a, double b) {
        return a * b;
    }
    
    // Overloaded print() methods
    void print(byte value) {
        System.out.println("  [byte] " + value);
    }
    
    void print(int value) {
        System.out.println("  [int] " + value);
    }
    
    void print(double value) {
        System.out.println("  [double] " + value);
    }
    
    void print(String value) {
        System.out.println("  [string] " + value);
    }
}