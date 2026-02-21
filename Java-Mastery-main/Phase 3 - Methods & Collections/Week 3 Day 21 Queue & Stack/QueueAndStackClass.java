/*
 * ============================================================
 *        QUEUE AND STACK IN JAVA - THEORY
 * ============================================================
 *
 * ============================================================
 * WHAT IS A STACK?
 * ============================================================
 *
 * A Stack is a LINEAR data structure that follows the
 * LIFO (Last In, First Out) principle.
 * The LAST element added is the FIRST one to be removed.
 *
 * Real-life analogies:
 *  - Stack of plates   → add/remove from TOP only
 *  - Undo/Redo history → last action undone first
 *  - Browser back button → last visited page first
 *  - Pile of books     → last book placed = first removed
 *
 * Key Operations:
 *  push(e)  → add element to TOP          O(1)
 *  pop()    → remove element from TOP     O(1)
 *  peek()   → view TOP without removing   O(1)
 *  isEmpty()→ check if stack is empty     O(1)
 *  size()   → number of elements          O(1)
 *
 * Visual (LIFO):
 *   push(1) push(2) push(3)
 *   ┌───┐
 *   │ 3 │ ← TOP (last in, first out)
 *   │ 2 │
 *   │ 1 │ ← BOTTOM
 *   └───┘
 *   pop() → returns 3, then 2, then 1
 *
 * ============================================================
 * WHAT IS A QUEUE?
 * ============================================================
 *
 * A Queue is a LINEAR data structure that follows the
 * FIFO (First In, First Out) principle.
 * The FIRST element added is the FIRST one to be removed.
 *
 * Real-life analogies:
 *  - Ticket counter queue → first person served first
 *  - Printer job queue    → first document printed first
 *  - Call center hold     → first caller answered first
 *  - Checkout line        → first in line = first out
 *
 * Key Operations:
 *  offer(e) / add(e) → add to REAR (end)         O(1)
 *  poll() / remove() → remove from FRONT          O(1)
 *  peek() / element()→ view FRONT without removing O(1)
 *  isEmpty()         → check if queue is empty    O(1)
 *  size()            → number of elements         O(1)
 *
 * Visual (FIFO):
 *   REAR ← add here     remove from here → FRONT
 *   ┌───┬───┬───┬───┐
 *   │ 4 │ 3 │ 2 │ 1 │
 *   └───┴───┴───┴───┘
 *   poll() → 1, then 2, then 3, then 4
 *
 * ============================================================
 * STACK IMPLEMENTATIONS IN JAVA
 * ============================================================
 *
 *  1. java.util.Stack (legacy, extends Vector)
 *     - Synchronized (thread-safe but slow)
 *     - Methods: push(), pop(), peek(), empty(), search()
 *     ⚠ Prefer Deque over Stack for new code
 *
 *  2. ArrayDeque as Stack (RECOMMENDED)
 *     - Not synchronized (faster)
 *     - Methods: push(), pop(), peek()
 *     - Use as stack: push/pop from SAME end
 *
 *  3. LinkedList as Stack
 *     - Implements Deque interface
 *     - Methods: push(), pop(), peek()
 *
 * ============================================================
 * QUEUE IMPLEMENTATIONS IN JAVA
 * ============================================================
 *
 *  1. LinkedList (implements Queue)
 *     - General purpose queue
 *     - Dynamic size, allows null
 *
 *  2. ArrayDeque (RECOMMENDED for Queue)
 *     - Resizable array, no null allowed
 *     - Faster than LinkedList in most cases
 *
 *  3. PriorityQueue
 *     - Elements ordered by PRIORITY (natural or Comparator)
 *     - Min-heap by default (smallest element first)
 *     - Does NOT follow strict FIFO
 *
 *  4. LinkedBlockingQueue (thread-safe)
 *     - Used in multi-threaded environments
 *     - Bounded or unbounded capacity
 *
 * ============================================================
 * DEQUE (Double-Ended Queue)
 * ============================================================
 *
 *  Deque (pronounced "deck") allows add/remove from BOTH ends.
 *  Can function as both Stack AND Queue.
 *
 *  Front ← remove/add     add/remove → Rear
 *  ┌────┬────┬────┬────┐
 *  │    │    │    │    │
 *  └────┴────┴────┴────┘
 *
 *  As Stack: push/pop from FRONT (addFirst/removeFirst)
 *  As Queue: add to REAR, remove from FRONT
 *
 *  Methods:
 *  addFirst(e) / offerFirst(e)  → add to front
 *  addLast(e)  / offerLast(e)   → add to rear
 *  removeFirst()/ pollFirst()   → remove from front
 *  removeLast() / pollLast()    → remove from rear
 *  peekFirst()                  → view front
 *  peekLast()                   → view rear
 *
 * ============================================================
 * QUEUE METHOD DIFFERENCES (throw vs return)
 * ============================================================
 *
 *  Operation    Throws Exception    Returns Special Value
 *  ---------    ----------------    --------------------
 *  Insert       add(e)              offer(e) → false
 *  Remove       remove()            poll()   → null
 *  Examine      element()           peek()   → null
 *
 *  RULE: Prefer offer/poll/peek for safer coding
 *        (no exceptions on empty/full queues)
 *
 * ============================================================
 * Stack vs Queue COMPARISON
 * ============================================================
 *
 *  Feature       Stack (LIFO)        Queue (FIFO)
 *  ----------    ---------------     ---------------
 *  Order         Last In First Out   First In First Out
 *  Add           push() → top        offer() → rear
 *  Remove        pop()  ← top        poll()  ← front
 *  View          peek() → top        peek()  → front
 *  Use cases     Undo, recursion,    Scheduling, BFS,
 *                backtracking,       printing, buffering
 *                expression eval
 *
 * ============================================================
 * TIME COMPLEXITIES
 * ============================================================
 *
 *  Operation     Stack      Queue      PriorityQueue
 *  ---------     -----      -----      -------------
 *  Push/Offer    O(1)       O(1)       O(log n)
 *  Pop/Poll      O(1)       O(1)       O(log n)
 *  Peek          O(1)       O(1)       O(1)
 *  Search        O(n)       O(n)       O(n)
 *  Size          O(1)       O(1)       O(1)
 *
 * ============================================================
 * COMMON USE CASES
 * ============================================================
 *
 *  STACK:
 *  - Undo / Redo operations
 *  - Browser back / forward
 *  - Function call stack
 *  - Expression evaluation (infix → postfix)
 *  - Balanced parentheses checking
 *  - DFS (Depth First Search)
 *  - Tower of Hanoi
 *  - Reverse a string
 *
 *  QUEUE:
 *  - CPU / Process scheduling
 *  - Print job spooler
 *  - BFS (Breadth First Search)
 *  - Ticket booking system
 *  - Call center system
 *  - Data stream buffering
 *  - Level-order tree traversal
 *
 *  PRIORITY QUEUE:
 *  - Dijkstra's shortest path
 *  - Hospital emergency triage
 *  - Task scheduling by priority
 *  - Huffman encoding
 *  - Top K elements problems
 *
 * ============================================================
 */

import java.util.*;

public class QueueAndStackClass {

    // ── separator helper ──
    static void sep() { System.out.println("  " + "-".repeat(50)); }
    static void header(String title) {
        System.out.println("\n  ╔══════════════════════════════════════╗");
        System.out.printf ("  ║  %-36s║%n", title);
        System.out.println("  ╚══════════════════════════════════════╝");
    }

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#      QUEUE AND STACK IN JAVA             #");
        System.out.println("############################################");

        // ============================================================
        // PART 1 — STACK
        // ============================================================
        System.out.println("\n\n╔══════════════════════════════════════════╗");
        System.out.println(  "║              PART 1: STACK               ║");
        System.out.println(  "╚══════════════════════════════════════════╝");

        // ============================================================
        // 1. Stack CLASS (legacy java.util.Stack)
        // ============================================================
        header("1. java.util.Stack (Legacy)");

        Stack<Integer> legacyStack = new Stack<>();
        System.out.println("  Empty stack       : " + legacyStack);
        System.out.println("  empty()           : " + legacyStack.empty());

        // push() — add to top
        System.out.println("\n  --- push() ---");
        legacyStack.push(10);
        legacyStack.push(20);
        legacyStack.push(30);
        legacyStack.push(40);
        legacyStack.push(50);
        System.out.println("  After push(10-50) : " + legacyStack);
        System.out.println("  Size              : " + legacyStack.size());

        // peek() — view top without removing
        System.out.println("\n  --- peek() ---");
        System.out.println("  peek()            : " + legacyStack.peek());  // 50
        System.out.println("  Stack unchanged   : " + legacyStack);

        // pop() — remove from top
        System.out.println("\n  --- pop() ---");
        System.out.println("  pop()             : " + legacyStack.pop());   // 50
        System.out.println("  pop()             : " + legacyStack.pop());   // 40
        System.out.println("  After pops        : " + legacyStack);

        // search() — 1-based position from top
        System.out.println("\n  --- search() ---");
        System.out.println("  search(30)        : " + legacyStack.search(30)); // 1 (top)
        System.out.println("  search(20)        : " + legacyStack.search(20)); // 2
        System.out.println("  search(10)        : " + legacyStack.search(10)); // 3
        System.out.println("  search(99)        : " + legacyStack.search(99)); // -1 not found

        // empty()
        System.out.println("\n  --- empty() ---");
        System.out.println("  empty()           : " + legacyStack.empty()); // false
        legacyStack.clear();
        System.out.println("  After clear()     : " + legacyStack);
        System.out.println("  empty()           : " + legacyStack.empty()); // true

        // Exception on empty pop
        System.out.println("\n  --- Exception Handling ---");
        try {
            legacyStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("  ✘ pop() on empty → EmptyStackException");
        }

        // ============================================================
        // 2. ArrayDeque AS STACK (Recommended)
        // ============================================================
        header("2. ArrayDeque as Stack (RECOMMENDED)");

        Deque<String> dequeStack = new ArrayDeque<>();
        System.out.println("  Empty ArrayDeque  : " + dequeStack);

        // push() → addFirst() (adds to front = top of stack)
        System.out.println("\n  --- push() (addFirst) ---");
        dequeStack.push("First");
        dequeStack.push("Second");
        dequeStack.push("Third");
        dequeStack.push("Fourth");
        System.out.println("  After push()      : " + dequeStack);
        System.out.println("  Top (peek)        : " + dequeStack.peek());

        // pop() → removeFirst()
        System.out.println("\n  --- pop() (removeFirst) ---");
        System.out.println("  pop()             : " + dequeStack.pop());   // Fourth
        System.out.println("  pop()             : " + dequeStack.pop());   // Third
        System.out.println("  After pops        : " + dequeStack);

        // peek() — view without removing
        System.out.println("  peek()            : " + dequeStack.peek());  // Second
        System.out.println("  peekFirst()       : " + dequeStack.peekFirst());
        System.out.println("  peekLast()        : " + dequeStack.peekLast());

        // isEmpty() — safe check
        System.out.println("  isEmpty()         : " + dequeStack.isEmpty());

        // null-safe pop (poll returns null instead of exception)
        System.out.println("\n  --- Safe Operations ---");
        Deque<String> safeStack = new ArrayDeque<>();
        System.out.println("  poll() on empty   : " + safeStack.poll());  // null (no exception)
        System.out.println("  peek() on empty   : " + safeStack.peek());  // null (no exception)

        // ============================================================
        // 3. STACK VISUALIZER
        // ============================================================
        header("3. Stack VISUALIZER");

        Deque<Integer> visStack = new ArrayDeque<>();
        int[] pushVals = {5, 12, 8, 20, 3, 17};

        System.out.println("  Pushing: " + Arrays.toString(pushVals));
        for (int v : pushVals) {
            visStack.push(v);
            System.out.printf("  push(%-2d)  → Stack: %-25s TOP: %d%n",
                    v, visStack.toString(), visStack.peek());
        }
        System.out.println();
        while (!visStack.isEmpty()) {
            int top = visStack.pop();
            System.out.printf("  pop()    ← %-3d  Remaining: %s%n",
                    top, visStack.toString());
        }

        // ============================================================
        // 4. STACK OPERATIONS — Practical
        // ============================================================
        header("4. Practical STACK OPERATIONS");

        // Reverse a string using stack
        System.out.println("  --- Reverse String with Stack ---");
        String[] revTests = {"Hello", "Java", "racecar", "OpenAI"};
        for (String s : revTests) {
            Deque<Character> charStack = new ArrayDeque<>();
            for (char c : s.toCharArray()) charStack.push(c);
            StringBuilder reversed = new StringBuilder();
            while (!charStack.isEmpty()) reversed.append(charStack.pop());
            System.out.printf("  reverse(\"%-10s\") = \"%s\"%n",
                    s + "\"", reversed);
        }

        // Balanced parentheses checker
        System.out.println("\n  --- Balanced Parentheses ---");
        String[] parenTests = {
            "()",  "()[]{}", "(]",  "([)]",
            "{[]}", "(((",   "{[()]}", "(({}[]))"
        };
        for (String expr : parenTests) {
            System.out.printf("  %-12s → %s%n",
                    "\"" + expr + "\"",
                    isBalanced(expr) ? "✔ Balanced" : "✘ Not Balanced");
        }

        // Decimal to Binary using stack
        System.out.println("\n  --- Decimal to Binary ---");
        int[] decNums = {0, 1, 5, 10, 25, 42, 100, 255};
        for (int n : decNums) {
            System.out.printf("  %-4d → %s%n", n, decToBinary(n));
        }

        // Undo-Redo system
        System.out.println("\n  --- Undo / Redo System ---");
        undoRedoDemo();

        // ============================================================
        // PART 2 — QUEUE
        // ============================================================
        System.out.println("\n\n╔══════════════════════════════════════════╗");
        System.out.println(  "║              PART 2: QUEUE               ║");
        System.out.println(  "╚══════════════════════════════════════════╝");

        // ============================================================
        // 5. LinkedList AS QUEUE
        // ============================================================
        header("5. LinkedList as Queue");

        Queue<String> linkedQueue = new LinkedList<>();
        System.out.println("  Empty Queue       : " + linkedQueue);
        System.out.println("  isEmpty()         : " + linkedQueue.isEmpty());

        // offer() / add() — add to REAR
        System.out.println("\n  --- offer() add to REAR ---");
        linkedQueue.offer("Alice");
        linkedQueue.offer("Bob");
        linkedQueue.offer("Charlie");
        linkedQueue.offer("Diana");
        linkedQueue.offer("Eve");
        System.out.println("  After offer()     : " + linkedQueue);
        System.out.println("  Size              : " + linkedQueue.size());

        // peek() — view FRONT without removing
        System.out.println("\n  --- peek() view FRONT ---");
        System.out.println("  peek()            : " + linkedQueue.peek());  // Alice
        System.out.println("  Queue unchanged   : " + linkedQueue);

        // poll() — remove from FRONT
        System.out.println("\n  --- poll() remove from FRONT ---");
        System.out.println("  poll()            : " + linkedQueue.poll()); // Alice
        System.out.println("  poll()            : " + linkedQueue.poll()); // Bob
        System.out.println("  After polls       : " + linkedQueue);

        // element() vs peek() — element() throws if empty
        System.out.println("\n  --- element() vs peek() ---");
        System.out.println("  element()         : " + linkedQueue.element()); // Charlie
        System.out.println("  peek()            : " + linkedQueue.peek());    // Charlie

        Queue<String> emptyQ = new LinkedList<>();
        System.out.println("  peek() on empty   : " + emptyQ.peek());        // null (safe)
        try {
            emptyQ.element();  // throws NoSuchElementException
        } catch (NoSuchElementException e) {
            System.out.println("  ✘ element() on empty → NoSuchElementException");
        }

        // add() vs offer() — add() throws if capacity exceeded
        System.out.println("\n  --- add() vs offer() ---");
        System.out.println("  add() throws on full  (use offer() for safety)");
        System.out.println("  remove() throws empty (use poll()  for safety)");
        System.out.println("  element() throws empty(use peek()  for safety)");

        // contains() — not a Queue interface method but LinkedList has it
        System.out.println("\n  --- contains() ---");
        System.out.println("  contains(Charlie) : "
                + ((LinkedList<String>)linkedQueue).contains("Charlie")); // true
        System.out.println("  contains(Bob)     : "
                + ((LinkedList<String>)linkedQueue).contains("Bob"));     // false (removed)

        // ============================================================
        // 6. ArrayDeque AS QUEUE (Recommended)
        // ============================================================
        header("6. ArrayDeque as Queue (RECOMMENDED)");

        Queue<Integer> arrayQueue = new ArrayDeque<>();

        // offer to REAR, poll from FRONT
        System.out.println("  --- offer() + poll() ---");
        for (int i = 1; i <= 7; i++) arrayQueue.offer(i * 10);
        System.out.println("  After offer(10-70): " + arrayQueue);
        System.out.println("  peek() FRONT      : " + arrayQueue.peek());   // 10

        System.out.println("\n  Draining queue:");
        while (!arrayQueue.isEmpty()) {
            System.out.printf("  poll() ← %-3d  Remaining: %s%n",
                    arrayQueue.poll(), arrayQueue);
        }
        System.out.println("  isEmpty()         : " + arrayQueue.isEmpty());

        // ============================================================
        // 7. QUEUE VISUALIZER
        // ============================================================
        header("7. Queue VISUALIZER (FIFO)");

        Queue<String> visQueue = new ArrayDeque<>();
        String[] customers = {"Alice","Bob","Charlie","Diana","Eve"};

        System.out.println("  --- Customers joining queue ---");
        for (String c : customers) {
            visQueue.offer(c);
            System.out.printf("  offer(%-8s) → Queue: %s  FRONT: %s%n",
                    c + ")", visQueue, visQueue.peek());
        }
        System.out.println();
        System.out.println("  --- Serving customers (FIFO) ---");
        while (!visQueue.isEmpty()) {
            String served = visQueue.poll();
            System.out.printf("  Serving: %-8s  Remaining: %s%n",
                    served, visQueue);
        }

        // ============================================================
        // 8. DEQUE — Double Ended Queue
        // ============================================================
        header("8. DEQUE — Double Ended Queue");

        Deque<Integer> deque = new ArrayDeque<>();
        System.out.println("  --- addFirst() & addLast() ---");
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addFirst(2);
        deque.addFirst(1);
        System.out.println("  After adds        : " + deque);
        System.out.println("  peekFirst()       : " + deque.peekFirst()); // 1
        System.out.println("  peekLast()        : " + deque.peekLast());  // 5

        System.out.println("\n  --- removeFirst() & removeLast() ---");
        System.out.println("  removeFirst()     : " + deque.removeFirst()); // 1
        System.out.println("  removeLast()      : " + deque.removeLast());  // 5
        System.out.println("  After removes     : " + deque);

        System.out.println("\n  --- offerFirst() & offerLast() ---");
        Deque<String> dq = new ArrayDeque<>();
        dq.offerLast("Middle");
        dq.offerFirst("Front");
        dq.offerLast("Back");
        dq.offerFirst("VeryFront");
        System.out.println("  Deque             : " + dq);
        System.out.println("  pollFirst()       : " + dq.pollFirst());
        System.out.println("  pollLast()        : " + dq.pollLast());
        System.out.println("  After polls       : " + dq);

        // Deque as both Stack and Queue
        System.out.println("\n  --- Deque as Stack (LIFO) ---");
        Deque<Integer> stackMode = new ArrayDeque<>();
        stackMode.push(1); stackMode.push(2); stackMode.push(3);
        System.out.print("  LIFO order: ");
        while (!stackMode.isEmpty()) System.out.print(stackMode.pop() + " ");
        System.out.println();

        System.out.println("  --- Deque as Queue (FIFO) ---");
        Deque<Integer> queueMode = new ArrayDeque<>();
        queueMode.offerLast(1);
        queueMode.offerLast(2);
        queueMode.offerLast(3);
        System.out.print("  FIFO order: ");
        while (!queueMode.isEmpty()) System.out.print(queueMode.pollFirst() + " ");
        System.out.println();

        // All Deque methods summary
        System.out.println("\n  --- Deque Method Summary ---");
        System.out.printf("  %-20s %-20s %-20s%n",
                "Operation", "Front (Head)", "Back (Tail)");
        sep();
        System.out.printf("  %-20s %-20s %-20s%n",
                "Insert (throw)","addFirst(e)","addLast(e)");
        System.out.printf("  %-20s %-20s %-20s%n",
                "Insert (safe)","offerFirst(e)","offerLast(e)");
        System.out.printf("  %-20s %-20s %-20s%n",
                "Remove (throw)","removeFirst()","removeLast()");
        System.out.printf("  %-20s %-20s %-20s%n",
                "Remove (safe)","pollFirst()","pollLast()");
        System.out.printf("  %-20s %-20s %-20s%n",
                "Examine (throw)","getFirst()","getLast()");
        System.out.printf("  %-20s %-20s %-20s%n",
                "Examine (safe)","peekFirst()","peekLast()");

        // ============================================================
        // 9. PRIORITY QUEUE
        // ============================================================
        header("9. PRIORITY QUEUE");

        // Default: Min-Heap (smallest element first)
        System.out.println("  --- Min-Heap (default) ---");
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        int[] pqVals = {30, 10, 50, 20, 40, 15, 35};
        System.out.println("  Inserting: " + Arrays.toString(pqVals));
        for (int v : pqVals) minPQ.offer(v);
        System.out.println("  PQ (internal): " + minPQ);
        System.out.println("  peek() MIN    : " + minPQ.peek());  // 10

        System.out.print("  Polling order  : ");
        PriorityQueue<Integer> pqCopy = new PriorityQueue<>(minPQ);
        while (!pqCopy.isEmpty()) System.out.print(pqCopy.poll() + " ");
        System.out.println("  ← sorted ascending");

        // Max-Heap (largest element first)
        System.out.println("\n  --- Max-Heap (reverseOrder) ---");
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int v : pqVals) maxPQ.offer(v);
        System.out.println("  peek() MAX    : " + maxPQ.peek());  // 50
        System.out.print("  Polling order  : ");
        while (!maxPQ.isEmpty()) System.out.print(maxPQ.poll() + " ");
        System.out.println("  ← sorted descending");

        // PriorityQueue with Strings (alphabetical)
        System.out.println("\n  --- String PQ (alphabetical) ---");
        PriorityQueue<String> strPQ = new PriorityQueue<>();
        Collections.addAll(strPQ, "Banana","Apple","Cherry","Avocado","Blueberry");
        System.out.print("  Polling order  : ");
        while (!strPQ.isEmpty()) System.out.print(strPQ.poll() + " ");
        System.out.println();

        // PriorityQueue with custom objects
        System.out.println("\n  --- Task Priority Queue ---");
        PriorityQueue<Task> taskPQ = new PriorityQueue<>(
                Comparator.comparingInt(t -> t.priority));
        taskPQ.offer(new Task("Write report",    3));
        taskPQ.offer(new Task("Fix critical bug",1));
        taskPQ.offer(new Task("Code review",     2));
        taskPQ.offer(new Task("Update docs",     4));
        taskPQ.offer(new Task("Deploy to prod",  1));

        System.out.printf("  %-5s %-25s%n","Pri.","Task");
        sep();
        while (!taskPQ.isEmpty()) {
            Task t = taskPQ.poll();
            System.out.printf("  [%d]   %s%n", t.priority, t.name);
        }

        // PQ operations
        System.out.println("\n  --- PQ Operations ---");
        PriorityQueue<Integer> opPQ = new PriorityQueue<>(
                Arrays.asList(5,1,8,3,9,2,7));
        System.out.println("  PQ              : " + opPQ);
        System.out.println("  peek()          : " + opPQ.peek());      // 1
        System.out.println("  poll()          : " + opPQ.poll());      // 1
        System.out.println("  peek() after    : " + opPQ.peek());      // 2
        System.out.println("  size()          : " + opPQ.size());
        System.out.println("  contains(8)     : " + opPQ.contains(8));
        opPQ.remove(8);
        System.out.println("  after remove(8) : " + opPQ);

        // ============================================================
        // 10. REAL-WORLD EXAMPLES
        // ============================================================
        System.out.println("\n\n╔══════════════════════════════════════════╗");
        System.out.println(  "║         REAL-WORLD EXAMPLES              ║");
        System.out.println(  "╚══════════════════════════════════════════╝");

        // Example 1: Browser History (Stack)
        header("Browser History (Stack)");
        browserHistoryDemo();

        // Example 2: Call Center Queue
        header("Call Center Queue");
        callCenterDemo();

        // Example 3: Expression Evaluator (Stack)
        header("Postfix Expression Evaluator (Stack)");
        String[] postfixExprs = {
            "3 4 +",          // 3 + 4 = 7
            "5 1 2 + 4 * + 3 -",  // 5 + ((1+2)*4) - 3 = 14
            "2 3 4 * +",      // 2 + (3*4) = 14
            "7 2 3 * - 4 +"   // 7 - (2*3) + 4 = 5
        };
        for (String expr : postfixExprs) {
            System.out.printf("  %-30s = %d%n",
                    "\"" + expr + "\"", evaluatePostfix(expr));
        }

        // Example 4: Hot Potato Simulation (Queue)
        header("Hot Potato Game (Queue)");
        hotPotatoGame(
            new String[]{"Alice","Bob","Charlie","Diana","Eve","Frank"}, 3);

        // Example 5: Level-Order Tree Traversal (Queue)
        header("Level-Order Tree Traversal (Queue)");
        levelOrderTraversal();

        // Example 6: Sliding Window Maximum (Deque)
        header("Sliding Window Maximum (Deque)");
        int[] winArr = {1,3,-1,-3,5,3,6,7};
        int   k = 3;
        int[] maxArr = slidingWindowMax(winArr, k);
        System.out.println("  Array  : " + Arrays.toString(winArr));
        System.out.println("  k      : " + k);
        System.out.println("  Max[]  : " + Arrays.toString(maxArr));

        // Example 7: Hospital Triage (PriorityQueue)
        header("Hospital Emergency Triage (PriorityQueue)");
        hospitalTriage();

        System.out.println("\n############################################");
        System.out.println("# Queue and Stack in Java — Done! ✔       #");
        System.out.println("############################################");
    }

    // ============================================================
    // HELPER METHODS
    // ============================================================

    // Balanced Parentheses Checker
    static boolean isBalanced(String expr) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) return false;
            }
        }
        return stack.isEmpty();
    }

    // Decimal to Binary using Stack
    static String decToBinary(int n) {
        if (n == 0) return "0";
        Deque<Integer> stack = new ArrayDeque<>();
        while (n > 0) {
            stack.push(n % 2);
            n /= 2;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }

    // Undo / Redo Demo
    static void undoRedoDemo() {
        Deque<String> undoStack = new ArrayDeque<>();
        Deque<String> redoStack = new ArrayDeque<>();
        String currentState = "Document: []";

        System.out.println("  Initial: " + currentState);

        // Perform actions
        String[] actions = {"Type 'Hello'","Type ' World'","Bold text","Insert image"};
        for (String action : actions) {
            undoStack.push(currentState);
            redoStack.clear();
            currentState = "After: " + action;
            System.out.println("  ✏ Do    → " + currentState);
        }

        // Undo twice
        for (int i = 0; i < 2; i++) {
            if (!undoStack.isEmpty()) {
                redoStack.push(currentState);
                currentState = undoStack.pop();
                System.out.println("  ↩ Undo  → " + currentState);
            }
        }

        // Redo once
        if (!redoStack.isEmpty()) {
            undoStack.push(currentState);
            currentState = redoStack.pop();
            System.out.println("  ↪ Redo  → " + currentState);
        }
    }

    // Browser History Demo
    static void browserHistoryDemo() {
        Deque<String> backStack    = new ArrayDeque<>();
        Deque<String> forwardStack = new ArrayDeque<>();
        String currentPage = "google.com";
        System.out.println("  Current: " + currentPage);

        // Visit pages
        String[] pages = {"youtube.com","github.com","stackoverflow.com","reddit.com"};
        for (String page : pages) {
            backStack.push(currentPage);
            forwardStack.clear();
            currentPage = page;
            System.out.println("  🌐 Visit   → " + currentPage
                    + "  (back: " + backStack.size() + ")");
        }

        // Go back twice
        for (int i = 0; i < 2; i++) {
            if (!backStack.isEmpty()) {
                forwardStack.push(currentPage);
                currentPage = backStack.pop();
                System.out.println("  ← Back    → " + currentPage);
            }
        }

        // Go forward once
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
            System.out.println("  → Forward → " + currentPage);
        }

        System.out.println("  Final page : " + currentPage);
    }

    // Call Center Demo
    static void callCenterDemo() {
        Queue<String> callQueue   = new LinkedList<>();
        String[] incomingCalls    = {
            "Alice (billing)", "Bob (tech support)", "Charlie (sales)",
            "Diana (billing)", "Eve (tech support)", "Frank (general)"
        };

        System.out.println("  --- Incoming calls ---");
        for (String call : incomingCalls) {
            callQueue.offer(call);
            System.out.println("  📞 Queued  : " + call
                    + "  | Queue size: " + callQueue.size());
        }

        System.out.println("\n  --- Agents serving calls (FIFO) ---");
        String[] agents = {"Agent Smith","Agent Jones","Agent Brown"};
        int agentIdx = 0;
        while (!callQueue.isEmpty()) {
            String call  = callQueue.poll();
            String agent = agents[agentIdx % agents.length];
            System.out.printf("  ✅ %-20s serving %-30s | Waiting: %d%n",
                    agent, call, callQueue.size());
            agentIdx++;
        }
    }

    // Postfix Expression Evaluator
    @SuppressWarnings("UnnecessaryTemporaryOnConversionFromString")
    static int evaluatePostfix(String expr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : expr.split(" ")) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "*" -> stack.push(a * b);
                    case "/" -> stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }

    // Hot Potato Game
    static void hotPotatoGame(String[] players, int count) {
        Queue<String> circle = new LinkedList<>(Arrays.asList(players));
        System.out.println("  Players : " + circle);
        System.out.println("  Count   : " + count);
        System.out.println();

        int round = 1;
        while (circle.size() > 1) {
            // Pass potato 'count' times
            for (int i = 0; i < count; i++) {
                circle.offer(circle.poll()); // move front to back
            }
            String eliminated = circle.poll();
            System.out.printf("  Round %d: %-10s eliminated! → Remaining: %s%n",
                    round++, eliminated, circle);
        }
        System.out.println("  🏆 Winner: " + circle.peek());
    }

    // Level-Order Tree Traversal (simulated with array)
    static void levelOrderTraversal() {
        // Binary tree represented as array
        // Index:  0    1    2    3    4    5    6
        int[] tree = {1,   2,   3,   4,   5,   6,   7};
        //           root  L    R   LL   LR   RL   RR

        System.out.println("  Tree structure:");
        System.out.println("          1");
        System.out.println("        /   \\");
        System.out.println("       2     3");
        System.out.println("      / \\   / \\");
        System.out.println("     4   5 6   7");
        System.out.println();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);  // start with root index
        int level = 0;

        System.out.println("  Level-order traversal:");
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.printf("  Level %d: ", level);
            for (int i = 0; i < levelSize; i++) {
                int idx  = queue.poll();
                System.out.print(tree[idx] + " ");
                int left  = 2 * idx + 1;
                int right = 2 * idx + 2;
                if (left  < tree.length) queue.offer(left);
                if (right < tree.length) queue.offer(right);
            }
            System.out.println();
            level++;
        }
    }

    // Sliding Window Maximum using Deque
    static int[] slidingWindowMax(int[] arr, int k) {
        int[] result = new int[arr.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();  // stores indices

        for (int i = 0; i < arr.length; i++) {
            // Remove indices out of window
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1)
                dq.pollFirst();
            // Remove smaller elements (useless)
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                dq.pollLast();
            dq.offerLast(i);
            // Record result when window is full
            if (i >= k - 1)
                result[i - k + 1] = arr[dq.peekFirst()];
        }
        return result;
    }

    // Hospital Triage using PriorityQueue
    @SuppressWarnings("unused")
    static void hospitalTriage() {
        // Lower number = higher priority
        PriorityQueue<Patient> triage = new PriorityQueue<>(
                Comparator.comparingInt(p -> p.severity));

        triage.offer(new Patient("John",   3, "Broken arm"));
        triage.offer(new Patient("Mary",   1, "Heart attack"));
        triage.offer(new Patient("Steve",  2, "Deep wound"));
        triage.offer(new Patient("Linda",  4, "Mild fever"));
        triage.offer(new Patient("Bob",    1, "Stroke"));
        triage.offer(new Patient("Anna",   3, "Fracture"));
        triage.offer(new Patient("Carlos", 2, "Burns"));

        System.out.printf("  %-8s %-10s %s%n", "Priority","Patient","Condition");
        sep();
        int order = 1;
        while (!triage.isEmpty()) {
            Patient p = triage.poll();
            String label = p.severity == 1 ? "🔴 CRITICAL" :
                           p.severity == 2 ? "🟠 URGENT  " :
                           p.severity == 3 ? "🟡 MODERATE" :
                                             "🟢 MILD    ";
            System.out.printf("  %s  %-10s %s%n",
                    label, p.name, p.condition);
            order++;
        }
    }
}

// ── Task class for PriorityQueue demo ──
class Task {
    String name;
    int    priority;
    Task(String name, int priority) {
        this.name     = name;
        this.priority = priority;
    }
}

// ── Patient class for Hospital Triage ──
class Patient {
    String name;
    int    severity;
    String condition;
    Patient(String name, int severity, String condition) {
        this.name      = name;
        this.severity  = severity;
        this.condition = condition;
    }
}