/*
 * ============================================================
 *       ONE DIMENSIONAL ARRAYS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS A ONE DIMENSIONAL ARRAY?
 * ----------------------------------
 * A One Dimensional (1D) Array is a LINEAR collection of
 * elements of the SAME data type stored in CONTIGUOUS
 * (adjacent) memory locations, accessed using a single index.
 *
 * Think of it like a ROW of boxes:
 *  Index:  [0]  [1]  [2]  [3]  [4]
 *  Value:   10   20   30   40   50
 *
 * Real-life analogy:
 *  - A row of lockers in school (each locker = one element)
 *  - A train with numbered compartments
 *  - A list of marks on a marksheet
 *
 * ============================================================
 * MEMORY REPRESENTATION
 * ============================================================
 *
 *  int[] arr = {10, 20, 30, 40, 50};
 *
 *  Memory Address:  1000  1004  1008  1012  1016
 *                   ┌────┬─────┬─────┬─────┬────┐
 *  Value:           │ 10 │  20 │  30 │  40 │ 50 │
 *                   └────┴─────┴─────┴─────┴────┘
 *  Index:            [0]   [1]   [2]   [3]   [4]
 *
 *  - Each int takes 4 bytes
 *  - Elements stored in contiguous memory
 *  - arr variable stores the BASE ADDRESS (1000)
 *  - arr[i] = base address + (i × size of datatype)
 *
 * ============================================================
 * SYNTAX & WAYS TO CREATE 1D ARRAY
 * ============================================================
 *
 *  Step 1 — DECLARATION (tells compiler array exists):
 *  -------
 *  int[]    arr;    // preferred Java style
 *  int      arr[];  // C-style (valid but not preferred)
 *
 *  Step 2 — CREATION / INSTANTIATION (allocates memory):
 *  -------
 *  arr = new int[5];   // creates array of 5 integers
 *
 *  Step 3 — INITIALIZATION (assigns values):
 *  -------
 *  arr[0] = 10;
 *  arr[1] = 20; ... etc
 *
 *  ── All in ONE line (Declaration + Creation):
 *  int[] arr = new int[5];       // default values (all 0)
 *
 *  ── All in ONE line (Declaration + Creation + Init):
 *  int[] arr = new int[]{10, 20, 30, 40, 50};
 *
 *  ── Shorthand (most common):
 *  int[] arr = {10, 20, 30, 40, 50};
 *
 * ============================================================
 * DEFAULT VALUES WHEN NOT INITIALIZED
 * ============================================================
 *
 *  Data Type       Default Value
 *  -------------   ----------------
 *  byte            0
 *  short           0
 *  int             0
 *  long            0L
 *  float           0.0f
 *  double          0.0d
 *  char            '\u0000' (null)
 *  boolean         false
 *  String/Object   null
 *
 * ============================================================
 * ACCESSING ELEMENTS
 * ============================================================
 *
 *  arrayName[index]
 *
 *  - Index starts from 0
 *  - Last element index = length - 1
 *  - arr[0]              → first element
 *  - arr[arr.length - 1] → last element
 *
 *  ⚠ Accessing invalid index throws:
 *    ArrayIndexOutOfBoundsException
 *
 * ============================================================
 * IMPORTANT PROPERTIES
 * ============================================================
 *
 *  arr.length    → total number of elements (property, no ())
 *  arr[i]        → access element at index i
 *  arr[i] = val  → update element at index i
 *
 *  Note:
 *  String → .length()  ← method (has parentheses)
 *  Array  → .length    ← property (NO parentheses)
 *
 * ============================================================
 * COMMON 1D ARRAY OPERATIONS
 * ============================================================
 *
 *  1.  Traversal        → Visit every element
 *  2.  Insertion        → Add element at position
 *  3.  Deletion         → Remove element from position
 *  4.  Linear Search    → Search element one by one
 *  5.  Binary Search    → Search in sorted array (faster)
 *  6.  Sorting          → Arrange in order
 *  7.  Reversing        → Reverse all elements
 *  8.  Min / Max        → Find smallest / largest
 *  9.  Sum / Average    → Calculate total and mean
 *  10. Frequency Count  → Count occurrences
 *  11. Array Copy       → Copy elements to new array
 *  12. Merge Arrays     → Combine two arrays
 *  13. Remove Duplicates→ Keep only unique elements
 *  14. Rotate Array     → Left or right rotation
 *  15. Second Max/Min   → Find 2nd largest/smallest
 *
 * ============================================================
 * PASSING ARRAY TO METHOD
 * ============================================================
 *
 *  Arrays are passed by REFERENCE in Java.
 *  → Changes made inside the method AFFECT the original array!
 *
 *  Syntax:
 *  void printArray(int[] arr) { ... }
 *  printArray(myArray);   // pass array to method
 *
 * ============================================================
 * RETURNING ARRAY FROM METHOD
 * ============================================================
 *
 *  int[] createArray() {
 *      return new int[]{1, 2, 3, 4, 5};
 *  }
 *
 * ============================================================
 * LIMITATIONS OF ARRAYS
 * ============================================================
 *
 *  1. Fixed size — cannot grow or shrink after creation
 *  2. Only same data type elements
 *  3. Insertion/Deletion is expensive (shifting required)
 *  4. No built-in methods like add(), remove() etc.
 *     (Use ArrayList for dynamic operations)
 *
 * ============================================================
 */

import java.util.Arrays;

public class OneDimensionalArrays {

    // ── Helper: Print array nicely ──
    static void printArray(String label, int[] arr) {
        System.out.printf("%-20s: %s%n", label, Arrays.toString(arr));
    }

    // ── Helper: Print separator ──
    static void sep() {
        System.out.println("  " + "-".repeat(45));
    }

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#     ONE DIMENSIONAL ARRAYS IN JAVA       #");
        System.out.println("############################################");

        // ============================================================
        // 1. ARRAY DECLARATION, CREATION & INITIALIZATION
        // ============================================================
        System.out.println("\n===== 1. DECLARATION, CREATION & INIT =====");

        // Step by step
        int[] stepArr;                   // Step 1: Declaration
        stepArr = new int[5];            // Step 2: Creation
        stepArr[0] = 10;                 // Step 3: Initialization
        stepArr[1] = 20;
        stepArr[2] = 30;
        stepArr[3] = 40;
        stepArr[4] = 50;
        printArray("Step-by-step", stepArr);

        // Declaration + Creation (default values)
        int[] defaultArr = new int[5];
        printArray("Default (int)", defaultArr);   // [0, 0, 0, 0, 0]

        double[] defaultDbl = new double[4];
        System.out.printf("%-20s: %s%n", "Default (double)", Arrays.toString(defaultDbl));

        boolean[] defaultBool = new boolean[3];
        System.out.printf("%-20s: %s%n", "Default (boolean)", Arrays.toString(defaultBool));

        String[] defaultStr = new String[3];
        System.out.printf("%-20s: %s%n", "Default (String)", Arrays.toString(defaultStr));

        // Shorthand initialization
        int[]     intArr  = {10, 20, 30, 40, 50};
        double[]  dblArr  = {1.1, 2.2, 3.3, 4.4};
        char[]    chrArr  = {'J', 'A', 'V', 'A'};
        boolean[] bolArr  = {true, false, true};
        String[]  strArr  = {"Alice", "Bob", "Charlie"};

        System.out.printf("%-20s: %s%n", "int[]",     Arrays.toString(intArr));
        System.out.printf("%-20s: %s%n", "double[]",  Arrays.toString(dblArr));
        System.out.printf("%-20s: %s%n", "char[]",    Arrays.toString(chrArr));
        System.out.printf("%-20s: %s%n", "boolean[]", Arrays.toString(bolArr));
        System.out.printf("%-20s: %s%n", "String[]",  Arrays.toString(strArr));

        // ============================================================
        // 2. ACCESSING ELEMENTS & PROPERTIES
        // ============================================================
        System.out.println("\n===== 2. ACCESSING ELEMENTS & PROPERTIES =====");

        int[] marks = {85, 92, 78, 95, 88, 72, 96};
        printArray("marks", marks);
        System.out.println("Length             : " + marks.length);
        System.out.println("First  [0]         : " + marks[0]);
        System.out.println("Second [1]         : " + marks[1]);
        System.out.println("Middle [3]         : " + marks[3]);
        System.out.println("Last   [length-1]  : " + marks[marks.length - 1]);

        // Update element
        System.out.println("\nBefore update      : " + Arrays.toString(marks));
        marks[2] = 100;
        System.out.println("After marks[2]=100 : " + Arrays.toString(marks));

        // Safe access with bounds check
        System.out.println("\n--- Safe Bounds Check ---");
        int[] checkIdx = {7, 0, 4, marks.length, -1};
        for (int idx : checkIdx) {
            if (idx >= 0 && idx < marks.length) {
                System.out.printf("marks[%2d] = %d ✔%n", idx, marks[idx]);
            } else {
                System.out.printf("marks[%2d] → ✘ Out of bounds!%n", idx);
            }
        }

        // ============================================================
        // 3. ARRAY TRAVERSAL
        // ============================================================
        System.out.println("\n===== 3. ARRAY TRAVERSAL =====");

        int[] nums = {10, 25, 38, 47, 56, 63, 72};
        printArray("nums", nums);

        // for loop (with index)
        System.out.println("--- for loop ---");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("  nums[%d] = %d%n", i, nums[i]);
        }

        // for-each loop
        System.out.println("--- for-each loop ---");
        System.out.print("  ");
        for (int val : nums) System.out.print(val + " ");
        System.out.println();

        // while loop
        System.out.println("--- while loop ---");
        int wi = 0;
        System.out.print("  ");
        while (wi < nums.length) {
            System.out.print(nums[wi] + " ");
            wi++;
        }
        System.out.println();

        // Reverse traversal
        System.out.println("--- Reverse traversal ---");
        System.out.print("  ");
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        // ============================================================
        // 4. SUM, AVERAGE, MIN, MAX
        // ============================================================
        System.out.println("\n===== 4. SUM, AVERAGE, MIN, MAX =====");

        int[] values = {45, 12, 78, 34, 89, 23, 56, 67, 11, 90};
        printArray("values", values);

        int    sumVal = 0;
        int    maxVal = values[0];
        int    minVal = values[0];
        int    maxIdx = 0;
        int    minIdx = 0;

        for (int i = 0; i < values.length; i++) {
            sumVal += values[i];
            if (values[i] > maxVal) { maxVal = values[i]; maxIdx = i; }
            if (values[i] < minVal) { minVal = values[i]; minIdx = i; }
        }
        double avg = (double) sumVal / values.length;

        System.out.println("Sum     : " + sumVal);
        System.out.printf("Average : %.2f%n", avg);
        System.out.println("Max     : " + maxVal + " at index " + maxIdx);
        System.out.println("Min     : " + minVal + " at index " + minIdx);

        // ============================================================
        // 5. LINEAR SEARCH
        // ============================================================
        System.out.println("\n===== 5. LINEAR SEARCH =====");

        int[] lsArr  = {64, 34, 25, 12, 22, 11, 90, 47, 55};
        int   lsKey1 = 22;
        int   lsKey2 = 99;

        printArray("Array", lsArr);

        for (int key : new int[]{lsKey1, lsKey2}) {
            int foundAt = -1;
            for (int i = 0; i < lsArr.length; i++) {
                if (lsArr[i] == key) { foundAt = i; break; }
            }
            if (foundAt != -1)
                System.out.printf("Search %2d → ✔ Found at index %d%n", key, foundAt);
            else
                System.out.printf("Search %2d → ✘ Not found%n", key);
        }

        // ============================================================
        // 6. BINARY SEARCH (on sorted array)
        // ============================================================
        System.out.println("\n===== 6. BINARY SEARCH =====");

        int[] bsArr  = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        int   bsKey1 = 55;
        int   bsKey2 = 40;
        printArray("Sorted Array", bsArr);

        for (int key : new int[]{bsKey1, bsKey2}) {
            int low = 0, high = bsArr.length - 1, mid, result = -1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (bsArr[mid] == key)      { result = mid; break; }
                else if (bsArr[mid] < key)    low  = mid + 1;
                else                          high = mid - 1;
            }
            if (result != -1)
                System.out.printf("Binary Search %2d → ✔ Found at index %d%n", key, result);
            else
                System.out.printf("Binary Search %2d → ✘ Not found%n", key);
        }

        // Using Arrays.binarySearch()
        System.out.println("\n--- Arrays.binarySearch() ---");
        System.out.println("Arrays.binarySearch(55) → index: "
                + Arrays.binarySearch(bsArr, 55));
        System.out.println("Arrays.binarySearch(40) → index: "
                + Arrays.binarySearch(bsArr, 40) + " (negative = not found)");

        // ============================================================
        // 7. SORTING
        // ============================================================
        System.out.println("\n===== 7. SORTING =====");

        // Bubble Sort
        System.out.println("--- Bubble Sort ---");
        int[] bubble = {64, 34, 25, 12, 22, 11, 90};
        printArray("Before", bubble);
        for (int pass = 0; pass < bubble.length - 1; pass++) {
            for (int j = 0; j < bubble.length - pass - 1; j++) {
                if (bubble[j] > bubble[j + 1]) {
                    int tmp = bubble[j]; bubble[j] = bubble[j+1]; bubble[j+1] = tmp;
                }
            }
        }
        printArray("After (Asc)", bubble);

        // Selection Sort
        System.out.println("\n--- Selection Sort ---");
        int[] selection = {64, 25, 12, 22, 11};
        printArray("Before", selection);
        for (int i = 0; i < selection.length - 1; i++) {
            int minI = i;
            for (int j = i + 1; j < selection.length; j++) {
                if (selection[j] < selection[minI]) minI = j;
            }
            int tmp = selection[minI]; selection[minI] = selection[i]; selection[i] = tmp;
        }
        printArray("After (Asc)", selection);

        // Insertion Sort
        System.out.println("\n--- Insertion Sort ---");
        int[] insertion = {12, 11, 13, 5, 6};
        printArray("Before", insertion);
        for (int i = 1; i < insertion.length; i++) {
            int key = insertion[i];
            int j   = i - 1;
            while (j >= 0 && insertion[j] > key) {
                insertion[j + 1] = insertion[j];
                j--;
            }
            insertion[j + 1] = key;
        }
        printArray("After (Asc)", insertion);

        // Arrays.sort() — built-in
        System.out.println("\n--- Arrays.sort() (built-in) ---");
        int[] builtIn = {50, 10, 80, 30, 70, 20, 60, 40};
        printArray("Before", builtIn);
        Arrays.sort(builtIn);
        printArray("After (Asc)", builtIn);

        // Sort descending (manual)
        System.out.println("\n--- Sort Descending ---");
        int[] descArr = {50, 10, 80, 30, 70};
        printArray("Before", descArr);
        Arrays.sort(descArr);
        // Reverse after sorting
        for (int i = 0, j = descArr.length - 1; i < j; i++, j--) {
            int tmp = descArr[i]; descArr[i] = descArr[j]; descArr[j] = tmp;
        }
        printArray("After (Desc)", descArr);

        // ============================================================
        // 8. REVERSING AN ARRAY
        // ============================================================
        System.out.println("\n===== 8. REVERSING AN ARRAY =====");

        int[] revArr = {1, 2, 3, 4, 5, 6, 7};
        printArray("Before", revArr);

        // Two-pointer technique
        int l = 0, r = revArr.length - 1;
        while (l < r) {
            int tmp  = revArr[l];
            revArr[l] = revArr[r];
            revArr[r] = tmp;
            l++; r--;
        }
        printArray("After", revArr);

        // ============================================================
        // 9. COPYING AN ARRAY
        // ============================================================
        System.out.println("\n===== 9. COPYING AN ARRAY =====");

        int[] src = {10, 20, 30, 40, 50};
        printArray("Source", src);

        // Method 1: Manual copy
        // int[] manual = new int[src.length];
        // for (int i = 0; i < src.length; i++) manual[i] = src[i];
        // manual[0] = 999;
        // printArray("Manual copy", manual);
        // printArray("Source (unchanged)", src);

        // Method 2: Arrays.copyOf()
        int[] copy1 = Arrays.copyOf(src, src.length);
        int[] copy2 = Arrays.copyOf(src, 3);         // shorter
        int[] copy3 = Arrays.copyOf(src, 8);         // longer (padded 0)
        printArray("copyOf(full)", copy1);
        printArray("copyOf(3)", copy2);
        printArray("copyOf(8)", copy3);

        // Method 3: Arrays.copyOfRange()
        int[] rangeCopy = Arrays.copyOfRange(src, 1, 4); // index 1,2,3
        printArray("copyOfRange(1,4)", rangeCopy);

        // Method 4: System.arraycopy()
        int[] sysCopy = new int[src.length];
        System.arraycopy(src, 0, sysCopy, 0, src.length);
        printArray("System.arraycopy", sysCopy);

        // ============================================================
        // 10. MERGING TWO ARRAYS
        // ============================================================
        System.out.println("\n===== 10. MERGING TWO ARRAYS =====");

        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10};
        int[] merged = new int[arr1.length + arr2.length];

        printArray("Array 1", arr1);
        printArray("Array 2", arr2);

        // Simple merge
        System.arraycopy(arr1, 0, merged, 0, arr1.length);
        System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);
        printArray("Merged", merged);

        // Sort merged
        Arrays.sort(merged);
        printArray("Merged + Sorted", merged);

        // ============================================================
        // 11. FREQUENCY COUNT & DUPLICATES
        // ============================================================
        System.out.println("\n===== 11. FREQUENCY COUNT =====");

        int[] freq = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        printArray("Array", freq);
        Arrays.sort(freq);
        printArray("Sorted", freq);

        System.out.println("Frequencies:");
        int fi = 0;
        while (fi < freq.length) {
            int current = freq[fi];
            int cnt     = 0;
            while (fi < freq.length && freq[fi] == current) { cnt++; fi++; }
            System.out.printf("  %d appears %d time(s)%n", current, cnt);
        }

        // ============================================================
        // 12. REMOVE DUPLICATES
        // ============================================================
        System.out.println("\n===== 12. REMOVE DUPLICATES =====");

        int[] withDups = {1, 3, 2, 3, 5, 1, 4, 2, 5, 6};
        printArray("With duplicates", withDups);

        Arrays.sort(withDups);
        int[] unique  = new int[withDups.length];
        int   uCount  = 0;
        for (int i = 0; i < withDups.length; i++) {
            if (i == 0 || withDups[i] != withDups[i - 1]) {
                unique[uCount++] = withDups[i];
            }
        }
        printArray("Unique (sorted)", Arrays.copyOf(unique, uCount));

        // ============================================================
        // 13. LEFT & RIGHT ROTATION
        // ============================================================
        System.out.println("\n===== 13. ARRAY ROTATION =====");

        int[] rotArr = {1, 2, 3, 4, 5};
        printArray("Original", rotArr);

        // Left rotate by 1
        int[] leftRot = Arrays.copyOf(rotArr, rotArr.length);
        int   first   = leftRot[0];
        for (int i = 0; i < leftRot.length - 1; i++) leftRot[i] = leftRot[i + 1];
        leftRot[leftRot.length - 1] = first;
        printArray("Left Rotate by 1", leftRot);

        // Right rotate by 1
        int[] rightRot = Arrays.copyOf(rotArr, rotArr.length);
        int   last     = rightRot[rightRot.length - 1];
        for (int i = rightRot.length - 1; i > 0; i--) rightRot[i] = rightRot[i - 1];
        rightRot[0] = last;
        printArray("Right Rotate by 1", rightRot);

        // ============================================================
        // 14. SECOND LARGEST & SECOND SMALLEST
        // ============================================================
        System.out.println("\n===== 14. SECOND LARGEST & SMALLEST =====");

        int[] sArr     = {12, 35, 1, 10, 34, 1};
        printArray("Array", sArr);

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int val : sArr) {
            if (val > max1)       { max2 = max1; max1 = val; }
            else if (val > max2)  { max2 = val; }

            if (val < min1)       { min2 = min1; min1 = val; }
            else if (val < min2)  { min2 = val; }
        }
        System.out.println("Largest        : " + max1);
        System.out.println("Second Largest : " + max2);
        System.out.println("Smallest       : " + min1);
        System.out.println("Second Smallest: " + min2);

        // ============================================================
        // 15. PASSING ARRAY TO METHOD & RETURNING ARRAY
        // ============================================================
        System.out.println("\n===== 15. ARRAY IN METHODS =====");

        int[] methodArr = {5, 3, 8, 1, 9, 2, 7};
        printArray("Before method", methodArr);

        doubleElements(methodArr);     // modifies original!
        printArray("After doubleElements()", methodArr);

        int[] squared = squareElements(new int[]{1, 2, 3, 4, 5});
        printArray("squareElements(1-5)", squared);

        // ============================================================
        // 16. REAL-WORLD EXAMPLES
        // ============================================================
        System.out.println("\n===== 16. REAL-WORLD EXAMPLES =====");

        // Example 1: Exam Result Analyzer
        System.out.println("--- Exam Result Analyzer ---");
        String[] students  = {"Alice","Bob","Charlie","Diana","Eve","Frank"};
        int[]    examMarks = {88, 54, 73, 91, 47, 66};

        int   exTotal = 0, pass = 0, fail = 0;
        int   exMax = examMarks[0], exMin = examMarks[0];
        int   topIdx = 0;

        for (int i = 0; i < examMarks.length; i++) {
            exTotal += examMarks[i];
            if (examMarks[i] >= 50) pass++; else fail++;
            if (examMarks[i] > exMax) { exMax = examMarks[i]; topIdx = i; }
            if (examMarks[i] < exMin)   exMin = examMarks[i];
        }

        System.out.printf("%-10s %6s %8s%n", "Student", "Marks", "Result");
        sep();
        for (int i = 0; i < students.length; i++) {
            System.out.printf("%-10s %6d %8s%n",
                students[i], examMarks[i],
                examMarks[i] >= 50 ? "✔ PASS" : "✘ FAIL");
        }
        sep();
        System.out.printf("%-10s %6.1f%n", "Average", (double)exTotal/examMarks.length);
        System.out.println("Highest    : " + exMax + " (" + students[topIdx] + ")");
        System.out.println("Lowest     : " + exMin);
        System.out.println("Passed     : " + pass + " | Failed: " + fail);

        // Example 2: Shopping Cart
        System.out.println("\n--- Shopping Cart ---");
        String[] items    = {"Rice","Oil","Milk","Eggs","Bread"};
        double[] price    = {60.0, 120.0, 28.0, 72.0, 45.0};
        int[]    quantity = {2, 1, 3, 2, 2};

        double cartTotal = 0;
        System.out.printf("%-10s %8s %5s %10s%n", "Item","Price","Qty","Amount");
        sep();
        for (int i = 0; i < items.length; i++) {
            double amt = price[i] * quantity[i];
            cartTotal += amt;
            System.out.printf("%-10s %8.2f %5d %10.2f%n",
                    items[i], price[i], quantity[i], amt);
        }
        sep();
        System.out.printf("%-24s %10.2f%n", "Total:", cartTotal);
        double gst   = cartTotal * 0.05;
        double final_ = cartTotal + gst;
        System.out.printf("%-24s %10.2f%n", "GST (5%):", gst);
        System.out.printf("%-24s %10.2f%n", "Grand Total:", final_);

        // Example 3: Temperature Statistics
        System.out.println("\n--- Weekly Temperature Stats ---");
        String[] days  = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        double[] temps = {28.5, 30.2, 27.8, 31.5, 29.4, 26.7, 32.1};

        double tSum = 0, tMax = temps[0], tMin = temps[0];
        for (double t : temps) {
            tSum += t;
            if (t > tMax) tMax = t;
            if (t < tMin) tMin = t;
        }

        System.out.printf("%-5s %8s %6s%n", "Day", "Temp°C", "Status");
        sep();
        for (int i = 0; i < days.length; i++) {
            String status = temps[i] >= 30 ? "🔥 Hot" :
                            temps[i] >= 28 ? "🌤 Warm" : "❄ Cool";
            System.out.printf("%-5s %8.1f %6s%n", days[i], temps[i], status);
        }
        sep();
        System.out.printf("Average : %.2f°C%n", tSum / temps.length);
        System.out.printf("Highest : %.1f°C | Lowest: %.1f°C%n", tMax, tMin);

        System.out.println("\n############################################");
        System.out.println("#  One Dimensional Arrays — Done! ✔       #");
        System.out.println("############################################");
    }

    // ── Method: double all elements (modifies original) ──
    static void doubleElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) arr[i] *= 2;
    }

    // ── Method: return squared elements (new array) ──
    static int[] squareElements(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) result[i] = arr[i] * arr[i];
        return result;
    }
}