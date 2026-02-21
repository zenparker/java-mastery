/*
 * ============================================================
 *           ARRAYS CLASS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS AN ARRAY?
 * ------------------
 * An array is a fixed-size, ordered collection of elements
 * of the SAME data type stored in CONTIGUOUS memory locations.
 *
 * Key Characteristics:
 *  - Fixed size (cannot grow or shrink after creation)
 *  - Zero-based indexing (first element = index 0)
 *  - All elements must be of the same type
 *  - Stored in contiguous memory locations
 *  - Default values assigned if not initialized
 *
 * Default Values:
 *  int/short/byte/long → 0
 *  float/double        → 0.0
 *  char                → '\u0000' (null char)
 *  boolean             → false
 *  Object/String       → null
 *
 * ============================================================
 * TYPES OF ARRAYS IN JAVA
 * ============================================================
 *
 *  1. Single Dimensional Array  (1D Array)
 *  2. Multi Dimensional Array   (2D, 3D Array)
 *  3. Jagged Array              (Array of Arrays)
 *
 * ============================================================
 * 1. SINGLE DIMENSIONAL ARRAY (1D)
 * ============================================================
 *
 *  Declaration:
 *  ------------
 *  dataType[] arrayName;           // preferred style
 *  dataType   arrayName[];         // C-style (valid but not preferred)
 *
 *  Creation (Memory Allocation):
 *  ------------------------------
 *  arrayName = new dataType[size];
 *
 *  Declaration + Creation (combined):
 *  ------------------------------------
 *  dataType[] arrayName = new dataType[size];
 *
 *  Declaration + Creation + Initialization:
 *  -----------------------------------------
 *  dataType[] arrayName = {val1, val2, val3};
 *  dataType[] arrayName = new dataType[]{val1, val2, val3};
 *
 *  Access Element:
 *  ---------------
 *  arrayName[index]       // index starts from 0
 *
 *  Array Length:
 *  -------------
 *  arrayName.length       // property (NOT a method, no parentheses)
 *
 *  Memory Layout (int[] arr = {10,20,30,40,50}):
 *  -----------------------------------------------
 *  Index :  [0]  [1]  [2]  [3]  [4]
 *  Value :   10   20   30   40   50
 *  Addr  :  100  104  108  112  116  (each int = 4 bytes)
 *
 * ============================================================
 * 2. MULTI-DIMENSIONAL ARRAY (2D)
 * ============================================================
 *
 *  A 2D array is an array of arrays (like a matrix/table).
 *
 *  Declaration + Creation:
 *  ------------------------
 *  dataType[][] arrayName = new dataType[rows][cols];
 *
 *  Initialization:
 *  ----------------
 *  int[][] matrix = {
 *      {1, 2, 3},   // row 0
 *      {4, 5, 6},   // row 1
 *      {7, 8, 9}    // row 2
 *  };
 *
 *  Access:
 *  -------
 *  matrix[row][col]
 *  matrix[1][2]  → 6
 *
 *  Dimensions:
 *  -----------
 *  matrix.length        → number of rows
 *  matrix[0].length     → number of columns
 *
 * ============================================================
 * 3. JAGGED ARRAY
 * ============================================================
 *
 *  An array where each row can have a DIFFERENT number of cols.
 *  Also called "ragged array".
 *
 *  int[][] jagged = new int[3][];
 *  jagged[0] = new int[2];    // row 0 has 2 elements
 *  jagged[1] = new int[4];    // row 1 has 4 elements
 *  jagged[2] = new int[3];    // row 2 has 3 elements
 *
 * ============================================================
 * 4. java.util.Arrays CLASS
 * ============================================================
 *
 *  Java provides a built-in utility class java.util.Arrays
 *  with helpful static methods for array operations.
 *
 *  Method                     Description
 *  -------------------------  ----------------------------------
 *  Arrays.sort(arr)           Sort array in ascending order
 *  Arrays.sort(arr,from,to)   Sort a subarray
 *  Arrays.binarySearch(arr,k) Search sorted array (returns index)
 *  Arrays.fill(arr, val)      Fill all elements with value
 *  Arrays.fill(arr,f,t,val)   Fill subarray with value
 *  Arrays.copyOf(arr, len)    Copy array with new length
 *  Arrays.copyOfRange(a,f,t)  Copy subarray
 *  Arrays.equals(a1, a2)      Compare two arrays
 *  Arrays.toString(arr)       Convert array to readable String
 *  Arrays.deepToString(arr)   Convert 2D array to String
 *  Arrays.deepEquals(a1,a2)   Compare two 2D arrays
 *
 * ============================================================
 * 5. ARRAY OPERATIONS (Manual)
 * ============================================================
 *
 *  - Traversal      : Visit each element
 *  - Insertion      : Add element at position
 *  - Deletion       : Remove element from position
 *  - Search         : Linear Search, Binary Search
 *  - Sorting        : Bubble, Selection, Insertion Sort
 *  - Reverse        : Reverse all elements
 *  - Min/Max        : Find minimum/maximum element
 *  - Sum/Average    : Calculate sum and average
 *
 * ============================================================
 * IMPORTANT NOTES
 * ============================================================
 *
 *  - Array index starts from 0 to (length - 1)
 *  - Accessing index out of range throws:
 *    ArrayIndexOutOfBoundsException
 *  - Arrays are OBJECTS in Java (stored on heap)
 *  - Array variable stores REFERENCE (not actual data)
 *  - Arrays.sort() uses Dual-Pivot Quicksort for primitives
 *  - Arrays.binarySearch() requires SORTED array
 *  - length is a PROPERTY, not a method (no parentheses)
 *    String.length() ← method (has parentheses)
 *    array.length    ← property (no parentheses)
 *
 * ============================================================
 */

import java.util.Arrays;

public class ArraysClass {

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#           ARRAYS IN JAVA                 #");
        System.out.println("############################################");

        // ============================================================
        // 1. ARRAY DECLARATION, CREATION & INITIALIZATION
        // ============================================================
        System.out.println("\n===== 1. DECLARATION, CREATION & INITIALIZATION =====");

        // Method 1: Declare then create (default values)
        int[] arr1 = new int[5];
        System.out.println("Method 1 (default values): " + Arrays.toString(arr1));
        // [0, 0, 0, 0, 0]

        // Method 2: Declare, create and initialize
        int[] arr2 = new int[]{10, 20, 30, 40, 50};
        System.out.println("Method 2 (explicit new)  : " + Arrays.toString(arr2));

        // Method 3: Shorthand initialization
        int[] arr3 = {100, 200, 300, 400, 500};
        System.out.println("Method 3 (shorthand)     : " + Arrays.toString(arr3));

        // Different data types
        double[]  doubles  = {1.1, 2.2, 3.3, 4.4, 5.5};
        char[]    chars    = {'J', 'A', 'V', 'A'};
        boolean[] booleans = {true, false, true, true};
        String[]  strings  = {"Alice", "Bob", "Charlie", "Diana"};

        System.out.println("double[]  : " + Arrays.toString(doubles));
        System.out.println("char[]    : " + Arrays.toString(chars));
        System.out.println("boolean[] : " + Arrays.toString(booleans));
        System.out.println("String[]  : " + Arrays.toString(strings));

        // ============================================================
        // 2. ACCESSING & MODIFYING ELEMENTS
        // ============================================================
        System.out.println("\n===== 2. ACCESSING & MODIFYING ELEMENTS =====");

        int[] marks = {85, 92, 78, 95, 88};
        System.out.println("Array       : " + Arrays.toString(marks));
        System.out.println("Length      : " + marks.length);
        System.out.println("First (i=0) : " + marks[0]);
        System.out.println("Last  (i=4) : " + marks[marks.length - 1]);
        System.out.println("Index  [2]  : " + marks[2]);

        // Modify element
        marks[2] = 99;
        System.out.println("After marks[2]=99 : " + Arrays.toString(marks));

        // ArrayIndexOutOfBoundsException demo (safe check)
        System.out.println("\n--- Safe Access with bounds check ---");
        int idx = 10;
        if (idx >= 0 && idx < marks.length) {
            System.out.println("marks[" + idx + "] = " + marks[idx]);
        } else {
            System.out.println("✘ Index " + idx + " out of bounds! (length=" + marks.length + ")");
        }

        // ============================================================
        // 3. ARRAY TRAVERSAL
        // ============================================================
        System.out.println("\n===== 3. ARRAY TRAVERSAL =====");

        int[] nums = {15, 30, 45, 60, 75, 90};

        // Method 1: for loop with index
        System.out.println("--- for loop with index ---");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("nums[%d] = %d%n", i, nums[i]);
        }

        // Method 2: for-each loop
        System.out.println("--- for-each loop ---");
        for (int val : nums) {
            System.out.print(val + " ");
        }
        System.out.println();

        // Method 3: while loop
        System.out.println("--- while loop ---");
        int i = 0;
        while (i < nums.length) {
            System.out.print(nums[i] + " ");
            i++;
        }
        System.out.println();

        // Traverse in reverse
        System.out.println("--- Reverse traversal ---");
        for (int j = nums.length - 1; j >= 0; j--) {
            System.out.print(nums[j] + " ");
        }
        System.out.println();

        // ============================================================
        // 4. ARRAY OPERATIONS (Manual)
        // ============================================================
        System.out.println("\n===== 4. ARRAY OPERATIONS (Manual) =====");

        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original : " + Arrays.toString(data));

        // Sum and Average
        int    total   = 0;
        int    maxVal  = data[0];
        int    minVal  = data[0];

        for (int val : data) {
            total += val;
            if (val > maxVal) maxVal = val;
            if (val < minVal) minVal = val;
        }
        double average = (double) total / data.length;

        System.out.println("Sum     : " + total);
        System.out.printf("Average : %.2f%n", average);
        System.out.println("Max     : " + maxVal);
        System.out.println("Min     : " + minVal);

        // Count occurrences
        int[] scores = {75, 90, 85, 90, 60, 90, 75, 80};
        int   target = 90;
        int   countOcc = 0;
        for (int val : scores) {
            if (val == target) countOcc++;
        }
        System.out.println("\nArray   : " + Arrays.toString(scores));
        System.out.println("Count of " + target + " : " + countOcc);

        // Linear Search (manual)
        System.out.println("\n--- Linear Search ---");
        int[] searchArr = {40, 10, 70, 50, 30, 20, 60};
        int   searchVal = 50;
        int   foundIdx  = -1;
        for (int k = 0; k < searchArr.length; k++) {
            if (searchArr[k] == searchVal) {
                foundIdx = k;
                break;
            }
        }
        System.out.println("Array  : " + Arrays.toString(searchArr));
        System.out.println("Search : " + searchVal);
        System.out.println(foundIdx != -1
            ? "✔ Found at index: " + foundIdx
            : "✘ Not found");

        // Reverse array (manual)
        System.out.println("\n--- Reverse Array ---");
        int[] revArr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Before : " + Arrays.toString(revArr));
        int left = 0, right = revArr.length - 1;
        while (left < right) {
            int temp      = revArr[left];
            revArr[left]  = revArr[right];
            revArr[right] = temp;
            left++;
            right--;
        }
        System.out.println("After  : " + Arrays.toString(revArr));

        // Bubble Sort (manual)
        System.out.println("\n--- Bubble Sort ---");
        int[] bubbleArr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before : " + Arrays.toString(bubbleArr));
        int len = bubbleArr.length;
        for (int pass = 0; pass < len - 1; pass++) {
            for (int j = 0; j < len - pass - 1; j++) {
                if (bubbleArr[j] > bubbleArr[j + 1]) {
                    int tmp        = bubbleArr[j];
                    bubbleArr[j]   = bubbleArr[j + 1];
                    bubbleArr[j+1] = tmp;
                }
            }
        }
        System.out.println("After  : " + Arrays.toString(bubbleArr));

        // Copy array manually
        // System.out.println("\n--- Manual Array Copy ---");
        // int[] original = {10, 20, 30, 40, 50};
        // int[] copy     = new int[original.length];
        // for (int k = 0; k < original.length; k++) {
        //     copy[k] = original[k];
        // }
        // copy[0] = 999;  // modify copy — original unchanged
        // System.out.println("Original : " + Arrays.toString(original));
        // System.out.println("Copy     : " + Arrays.toString(copy));

        // ============================================================
        // 5. java.util.Arrays CLASS METHODS
        // ============================================================
        System.out.println("\n===== 5. java.util.Arrays METHODS =====");

        int[] sample = {50, 10, 80, 30, 70, 20, 60, 40};
        System.out.println("Original : " + Arrays.toString(sample));

        // Arrays.sort()
        int[] sorted = Arrays.copyOf(sample, sample.length);
        Arrays.sort(sorted);
        System.out.println("\nArrays.sort()        : " + Arrays.toString(sorted));

        // Arrays.sort() — subarray (index 2 to 5)
        int[] partSort = Arrays.copyOf(sample, sample.length);
        Arrays.sort(partSort, 2, 6);   // sort index 2 to 5 (exclusive 6)
        System.out.println("Arrays.sort(2,6)     : " + Arrays.toString(partSort));

        // Arrays.binarySearch() — must be sorted!
        int searchKey = 60;
        int bsResult  = Arrays.binarySearch(sorted, searchKey);
        System.out.println("\nArrays.binarySearch(" + searchKey + ") in sorted array: index = " + bsResult);

        // Search value not in array
        int notFound  = Arrays.binarySearch(sorted, 999);
        System.out.println("binarySearch(999)    : " + notFound + " (negative = not found)");

        // Arrays.fill()
        int[] filled  = new int[6];
        Arrays.fill(filled, 7);
        System.out.println("\nArrays.fill(7)       : " + Arrays.toString(filled));

        // Arrays.fill() — subrange
        int[] partFill = {1, 2, 3, 4, 5, 6, 7};
        Arrays.fill(partFill, 2, 5, 99);   // fill index 2 to 4
        System.out.println("Arrays.fill(2,5,99)  : " + Arrays.toString(partFill));

        // Arrays.copyOf()
        int[] original2 = {10, 20, 30, 40, 50};
        int[] copyOf1   = Arrays.copyOf(original2, 3);   // shorter
        int[] copyOf2   = Arrays.copyOf(original2, 7);   // longer (padded with 0)
        System.out.println("\nOriginal             : " + Arrays.toString(original2));
        System.out.println("Arrays.copyOf(3)     : " + Arrays.toString(copyOf1));
        System.out.println("Arrays.copyOf(7)     : " + Arrays.toString(copyOf2));

        // Arrays.copyOfRange()
        int[] rangeCopy = Arrays.copyOfRange(original2, 1, 4);  // index 1 to 3
        System.out.println("Arrays.copyOfRange(1,4): " + Arrays.toString(rangeCopy));

        // Arrays.equals()
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {1, 2, 3, 4, 5};
        int[] a3 = {1, 2, 3, 4, 6};
        System.out.println("\nArrays.equals(a1,a2) : " + Arrays.equals(a1, a2));  // true
        System.out.println("Arrays.equals(a1,a3) : " + Arrays.equals(a1, a3));  // false

        // Arrays.toString()
        String[]  strArr  = {"Java", "Python", "C++", "Kotlin"};
        double[]  dblArr  = {1.1, 2.2, 3.3};
        System.out.println("\nArrays.toString(String[]): " + Arrays.toString(strArr));
        System.out.println("Arrays.toString(double[]): " + Arrays.toString(dblArr));

        // ============================================================
        // 6. 2D ARRAY (Multi-Dimensional)
        // ============================================================
        System.out.println("\n===== 6. 2D ARRAY (Matrix) =====");

        // Declaration and initialization
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Display matrix
        // System.out.println("--- Matrix Display ---");
        // System.out.println("Rows : " + matrix.length);
        // System.out.println("Cols : " + matrix[0].length);
        // for (int row = 0; row < matrix.length; row++) {
        //     for (int col = 0; col < matrix[row].length; col++) {
        //         System.out.printf("%4d", matrix[row][col]);
        //     }
        //     System.out.println();
        // }

        // Arrays.deepToString() for 2D
        System.out.println("deepToString : " + Arrays.deepToString(matrix));

        // Matrix Addition
        System.out.println("\n--- Matrix Addition ---");
        int[][] m1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] m2 = {{7, 8, 9}, {1, 2, 3}};
        int[][] sum2D = new int[2][3];

        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 3; c++) {
                sum2D[r][c] = m1[r][c] + m2[r][c];
            }
        }
        System.out.println("M1  : " + Arrays.deepToString(m1));
        System.out.println("M2  : " + Arrays.deepToString(m2));
        System.out.println("Sum : " + Arrays.deepToString(sum2D));

        // Matrix Transpose
        System.out.println("\n--- Matrix Transpose ---");
        int[][] original3x3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transpose   = new int[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                transpose[c][r] = original3x3[r][c];
            }
        }
        System.out.println("Original  : " + Arrays.deepToString(original3x3));
        System.out.println("Transpose : " + Arrays.deepToString(transpose));

        // Arrays.deepEquals()
        int[][] d1 = {{1, 2}, {3, 4}};
        int[][] d2 = {{1, 2}, {3, 4}};
        int[][] d3 = {{1, 2}, {3, 5}};
        System.out.println("\ndeepEquals(d1,d2) : " + Arrays.deepEquals(d1, d2)); // true
        System.out.println("deepEquals(d1,d3) : " + Arrays.deepEquals(d1, d3)); // false

        // ============================================================
        // 7. JAGGED ARRAY
        // ============================================================
        System.out.println("\n===== 7. JAGGED ARRAY =====");

        int[][] jagged = new int[4][];
        jagged[0] = new int[]{1};
        jagged[1] = new int[]{1, 2};
        jagged[2] = new int[]{1, 2, 3};
        jagged[3] = new int[]{1, 2, 3, 4};

        System.out.println("Jagged Array (Triangle):");
        for (int r = 0; r < jagged.length; r++) {
            System.out.printf("Row %d (%d cols): ", r, jagged[r].length);
            for (int val : jagged[r]) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        // ============================================================
        // 8. REAL-WORLD EXAMPLES
        // ============================================================
        System.out.println("\n===== 8. REAL-WORLD EXAMPLES =====");

        // Example 1: Student Marks Report
        System.out.println("--- Student Marks Report ---");
        String[] names    = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        int[][]  subMarks = {
            {85, 90, 78, 92, 88},   // Alice
            {72, 68, 75, 80, 70},   // Bob
            {95, 98, 92, 96, 94},   // Charlie
            {60, 55, 65, 58, 62},   // Diana
            {88, 82, 79, 85, 90}    // Eve
        };
        String[] subjects = {"Math", "Sci", "Eng", "Hindi", "CS"};

        // Header
        System.out.printf("%-10s", "Name");
        for (String sub : subjects) System.out.printf("%6s", sub);
        System.out.printf("%7s %6s%n", "Total", "Avg");
        System.out.println("-".repeat(55));

        // Data rows
        for (int s = 0; s < names.length; s++) {
            int rowTotal = 0;
            System.out.printf("%-10s", names[s]);
            for (int m : subMarks[s]) {
                System.out.printf("%6d", m);
                rowTotal += m;
            }
            System.out.printf("%7d %6.1f%n", rowTotal, (double) rowTotal / subjects.length);
        }

        // Example 2: Frequency Count
        System.out.println("\n--- Frequency Count ---");
        int[] votes = {1, 3, 2, 1, 3, 3, 2, 1, 1, 3, 2, 3};
        int[] freq  = new int[4];   // candidates 1, 2, 3
        for (int v : votes) {
            freq[v]++;
        }
        System.out.println("Votes  : " + Arrays.toString(votes));
        for (int c = 1; c <= 3; c++) {
            System.out.println("Candidate " + c + " → " + freq[c] + " votes"
                    + (freq[c] == Arrays.stream(freq).max().getAsInt() ? " 🏆" : ""));
        }

        // Example 3: Inventory System
        System.out.println("\n--- Inventory System ---");
        String[] products = {"Laptop", "Mouse", "Keyboard", "Monitor", "Headphones"};
        int[]    stock    = {15, 50, 30, 20, 25};
        double[] unitPrice= {75000, 500, 1200, 15000, 3000};

        System.out.printf("%-12s %6s %10s %14s%n",
                "Product", "Stock", "Unit Price", "Total Value");
        System.out.println("-".repeat(46));

        double grandTotalVal = 0;
        for (int p = 0; p < products.length; p++) {
            double totalVal = stock[p] * unitPrice[p];
            grandTotalVal  += totalVal;
            System.out.printf("%-12s %6d %10.0f %14.0f%n",
                    products[p], stock[p], unitPrice[p], totalVal);
        }
        System.out.println("-".repeat(46));
        System.out.printf("%-30s %14.0f%n", "Grand Total Value:", grandTotalVal);

        // Low stock alert
        System.out.println("\n⚠ Low Stock Alert (< 20 units):");
        for (int p = 0; p < products.length; p++) {
            if (stock[p] < 20) {
                System.out.println("  → " + products[p] + " (only " + stock[p] + " left!)");
            }
        }

        System.out.println("\n############################################");
        System.out.println("#      Arrays in Java — Done! ✔            #");
        System.out.println("############################################");
    }
}