# Java Mastery

A comprehensive learning journey through Java programming, organized in phases to build expertise from fundamentals to advanced topics.

## Overview

This repository contains a structured curriculum designed to master Java programming from the ground up. The content is organized in phases, covering everything from basic setup to advanced concepts like streams and lambda expressions.

## Repository Structure

This repository contains two main folder structures:

### 1. Java-Mastery-main (Original Curriculum)

The original six-phase curriculum covering Java fundamentals to advanced topics:

```
Java-Mastery-main/
├── FAAH.txt
│
├── Phase 1 - Setup & Fundamentals/
│   ├── Day 1-2 Setup & First Code/
│   │   ├── Day 1-2 Setup & First Code.iml
│   │   ├── Basic Input Output/
│   │   │   ├── BasicInputOutput.java
│   │   │   └── Scannera_Methods.java
│   │   ├── Introduction to Java/
│   │   │   ├── HelloWorld.java
│   │   │   └── IntroductionToJava.java
│   │   └── Variables & Data Types/
│   │       ├── VariablesAndDataTypes.java
│   │       └── VariablesTypes.java
│   │
│   ├── Day 3-4 Core Operations/
│   │   ├── Day 3-4 Core Operations.iml
│   │   ├── Operators/
│   │   │   └── OperatorsInJava.java
│   │   └── Type Conversion/
│   │       └── TypeConversion.java
│   │
│   └── Day 5-7 Control Flow/
│       ├── Day 5-7 Control Flow.iml
│       ├── Conditionals/
│       │   └── ConditionalsInJava.java
│       └── Loops/
│           └── LoopsInJava.java
│
├── Phase 2 - Arrays & Math/
│   ├── Phase 2 - Arrays & Math.iml
│   ├── Day 8-10 Arrays/
│   │   ├── ArraysClass.java
│   │   ├── OneDimensionalArrays.java
│   │   └── TwoDimensionalArrays.java
│   ├── Day 11-12 Math Class/
│   │   └── MathClass.java
│   └── Day 13-14 Strings/
│       ├── CharacterClass.java
│       ├── StringBasics.java
│       └── StringBuilderClass.java
│
├── Phase 3 - Methods & Collections/
│   ├── Phase 3 - Methods & Collections.iml
│   ├── Week 3 Day 15-16 Methods/
│   │   └── MethodsInJava.java
│   ├── Week 3 Day 17-18 ArrayList & LinkedList/
│   │   └── ArrayListClass.java
│   ├── Week 3 Day 19 HashMap/
│   │   └── HashMapClass.java
│   ├── Week 3 Day 20 HashSet & TreeSet/
│   │   └── HashSetClass.java
│   ├── Week 3 Day 21 Queue & Stack/
│   │   ├── QueueAndStackClass.java
│   │   └── QueueStackClass.java
│   ├── Week 4 Day 22 PriorityQueue/
│   │   └── PriorityQueueClass.java
│   ├── Week 4 Day 23 Collections Utility Class/
│   │   └── CollectionsUtilityClass.java
│   └── Week 4 Day 24 Comparator & Comparable/
│       └── ComparatorComparableClass.java
│
├── Phase 4 - OOP Quick/
│   ├── Phase 4 - OOP Quick.iml
│   ├── Day 29-31 OOP Basics/
│   │   └── OOPBasics.java
│   └── Day 32-35 OOP Core Concepts/
│       └── OOPCoreConcepts.java
│
├── Phase 5 - Exception Handling & Extras/
│   ├── Phase 5 - Exception Handling & Extras.iml
│   ├── Day 36-38 Exception Handling/
│   │   └── ExceptionHandling.java
│   ├── Day 39-40 Important Additions/
│   │   └── BitManipulation.java
│   └── Day 41-42 Best Practices & Review/
│
└── Phase 6 - Advanced Topics/
    ├── Phase 6 - Advanced Topics.iml
    ├── Week 7 Day 43-44 Lambda Expressions/
    │   └── LambdaExpressions.java
    ├── Week 7 Day 45-46 Streams API/
    │   └── StreamsAPI.java
    ├── Week 7 Day 47 Optional Class/
    │   └── OptionalClass.java
    └── Week 7 Day 48 Method References/
        └── MethodReferences.java
```

### 2. Java-Mastery-ReMap (DSA-Optimized Curriculum)

A restructured curriculum optimized for Data Structures and Algorithms (DSA) preparation. Key changes from the original:

- **Phase 3 is now OOP Basics** — moved earlier to sit before Collections, not after
- **Phase 6 is a brand new Recursion phase** — the bridge between Java and DSA (the missing piece in the original)
- **Lambda/Streams removed** — not needed for DSA prep
- **DSA phases added directly** — Foundation, Core Data Structures, and Advanced DSA topics live in one place
- **Days are renumbered cleanly** — continuous flow without gaps

```
Java-Mastery-ReMap/
├── DSA Phase 1 - Foundation/
│   ├── Arrays/
│   ├── Hashing/
│   ├── Searching Algorithms/
│   ├── Sliding Window/
│   ├── Sorting Algorithms/
│   ├── Strings/
│   └── Two Pointer Technique/
│
├── DSA Phase 2 - Core Data Structures/
│   ├── Heap/
│   ├── Linked List/
│   ├── Matrix & Grid/
│   ├── Queue/
│   ├── Stack/
│   └── Tree/
│
├── DSA Phase 3 - Advanced/
│   ├── Backtracking/
│   ├── Dynamic Programming/
│   ├── Graph/
│   └── Greedy Algorithms/
│
├── Phase 1 - Setup & Fundamentals/
│   ├── Day 1-2 Setup & First Code/
│   │   ├── Basic Input Output/
│   │   ├── Introduction to Java/
│   │   └── Variables & Data Types/
│   ├── Day 3-4 Core Operations/
│   │   ├── Operators/
│   │   └── Type Conversion/
│   └── Day 5-7 Control Flow/
│       ├── Conditionals/
│       └── Loops/
│
├── Phase 2 - Arrays & Math/
│   ├── Day 8-10 Arrays/
│   ├── Day 11-12 Math Class/
│   └── Day 13-14 Strings/
│
├── Phase 3 - OOP Basics/
│   ├── Day 15-17 OOP Fundamentals/
│   └── Day 18-21 OOP Core Concepts/
│
├── Phase 4 - Methods & Collections/
│   ├── Day 22-23 Methods/
│   ├── Day 24-25 ArrayList & LinkedList/
│   ├── Day 26 HashMap/
│   ├── Day 27 HashSet & TreeSet/
│   ├── Day 28 Queue & Stack/
│   ├── Day 29 PriorityQueue/
│   ├── Day 30 Collections Utility Class/
│   └── Day 31 Comparator & Comparable/
│
├── Phase 5 - Exception Handling & Extras/
│   ├── Day 32-34 Exception Handling/
│   ├── Day 35-36 Bit Manipulation/
│   └── Day 37-38 Best Practices & Review/
│
└── Phase 6 - Recursion (Bridge to DSA)/
    ├── Day 39-40 Recursion Basics/
    ├── Day 41-42 Recursion Practice Problems/
    └── Day 43 Recursion with Arrays & Strings/
```

### Original Curriculum Phases

#### Phase 1: Setup & Fundamentals
- Days 1-2: Setup & First Code
- Days 3-4: Core Operations  
- Days 5-7: Control Flow

#### Phase 2: Arrays & Math
- Days 8-10: Arrays
- Days 11-12: Math Class
- Days 13-14: Strings

#### Phase 3: Methods & Collections
- Week 3 (Days 15-21): Methods, ArrayList, LinkedList, HashMap, HashSet, TreeSet, Queue, Stack
- Week 4 (Days 22-24): PriorityQueue, Collections Utility Class, Comparator & Comparable

#### Phase 4: OOP Quick
- Days 29-31: OOP Basics
- Days 32-35: OOP Core Concepts

#### Phase 5: Exception Handling & Extras
- Days 36-38: Exception Handling
- Days 39-40: Important Additions
- Days 41-42: Best Practices & Review

#### Phase 6: Advanced Topics
- Week 7 (Days 43-48): Lambda Expressions, Streams API, Optional Class, Method References

### DSA-Optimized Curriculum Phases

#### Phase 1-2: Java Fundamentals (Days 1-14)
Same as original: Setup, Core Operations, Control Flow, Arrays, Math, Strings

#### Phase 3: OOP Basics (Days 15-21)
Moved earlier: OOP Fundamentals and Core Concepts before Collections

#### Phase 4: Methods & Collections (Days 22-31)
Extended coverage: Methods, ArrayList, LinkedList, HashMap, HashSet, TreeSet, Queue, Stack, PriorityQueue, Collections Utility, Comparator & Comparable

#### Phase 5: Exception Handling & Extras (Days 32-38)
Exception Handling, Bit Manipulation, Best Practices & Review

#### Phase 6: Recursion - Bridge to DSA (Days 39-43)
**New Phase**: Recursion Basics, Practice Problems, Recursion with Arrays & Strings

#### DSA Phase 1: Foundation
Arrays, Hashing, Searching Algorithms, Sliding Window, Sorting Algorithms, Strings, Two Pointer Technique

#### DSA Phase 2: Core Data Structures
Heap, Linked List, Matrix & Grid, Queue, Stack, Tree

#### DSA Phase 3: Advanced
Backtracking, Dynamic Programming, Graph, Greedy Algorithms

## Learning Path

Each day builds upon the previous knowledge with practical examples and exercises. The progression is designed to gradually increase complexity while reinforcing fundamental concepts.

## Features

- Comprehensive coverage from basics to advanced topics
- Practical examples and demonstrations
- Exception handling best practices
- Object-oriented programming principles
- Collections framework mastery
- Modern Java features (Lambda expressions, Streams)

## Getting Started

1. Clone the repository:
```bash
git clone https://github.com/zenparker/java-mastery.git
```

2. Navigate to the specific phase/day you want to study:
```bash
cd Java-Mastery-main/Phase\ 1\ -\ Setup\ \&\ Fundamentals/Day\ 1-2\ Setup\ \&\ First\ Code/
```

3. Compile and run the Java examples:
```bash
javac YourExample.java
java YourExample
```

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Basic understanding of programming concepts (helpful but not required)

## Contributing

Feel free to fork this repository and contribute improvements or additional examples. Pull requests are welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

Zen Parker

## Acknowledgments

- Java documentation and community resources
- Best practices guides and tutorials from Oracle and other sources
=======
# java-mastery
Java Mastery with Parker
>>>>>>> b37b3b3018c3f9e5ae3efbf30685740351499436
