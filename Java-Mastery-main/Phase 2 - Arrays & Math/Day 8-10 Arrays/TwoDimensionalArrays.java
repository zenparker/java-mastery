/*
 * ============================================================
 *       TWO DIMENSIONAL ARRAYS IN JAVA - THEORY
 * ============================================================
 *
 * WHAT IS A TWO DIMENSIONAL ARRAY?
 * ----------------------------------
 * A Two Dimensional (2D) Array is an array of arrays.
 * It stores data in a TABULAR form (rows and columns),
 * like a MATRIX or a SPREADSHEET.
 *
 * Think of it like a TABLE:
 *
 *          Col0  Col1  Col2  Col3
 *  Row 0:  [ 1]  [ 2]  [ 3]  [ 4]
 *  Row 1:  [ 5]  [ 6]  [ 7]  [ 8]
 *  Row 2:  [ 9]  [10]  [11]  [12]
 *
 * Real-life analogies:
 *  - Excel spreadsheet (rows × columns)
 *  - Chess board (8×8 grid)
 *  - Classroom seating arrangement
 *  - Marks of students in multiple subjects
 *  - Pixels on a screen (width × height)
 *  - Matrix in Mathematics
 *
 * ============================================================
 * MEMORY REPRESENTATION
 * ============================================================
 *
 *  int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
 *
 *  matrix          → reference to array of row references
 *  matrix[0]       → reference to first row  {1, 2, 3}
 *  matrix[1]       → reference to second row {4, 5, 6}
 *  matrix[2]       → reference to third row  {7, 8, 9}
 *
 *  matrix ──→ [ ref0 | ref1 | ref2 ]
 *                │       │       │
 *               [1,2,3] [4,5,6] [7,8,9]
 *
 *  Each row is stored as a separate 1D array in memory.
 *  Rows may NOT be contiguous in memory (unlike C/C++).
 *
 * ============================================================
 * SYNTAX & WAYS TO CREATE 2D ARRAY
 * ============================================================
 *
 *  Declaration:
 *  ------------
 *  int[][] matrix;           // preferred
 *  int matrix[][];           // valid but not preferred
 *
 *  Creation:
 *  ---------
 *  matrix = new int[rows][cols];
 *
 *  Declaration + Creation:
 *  ------------------------
 *  int[][] matrix = new int[3][4];   // 3 rows, 4 cols
 *
 *  Declaration + Creation + Initialization:
 *  -----------------------------------------
 *  int[][] matrix = {
 *      {1, 2, 3},    // row 0
 *      {4, 5, 6},    // row 1
 *      {7, 8, 9}     // row 2
 *  };
 *
 *  Accessing elements:
 *  --------------------
 *  matrix[row][col]      // row and col are 0-based
 *  matrix[1][2] → 6      // row 1, col 2
 *
 *  Dimensions:
 *  -----------
 *  matrix.length         → number of ROWS
 *  matrix[0].length      → number of COLUMNS in row 0
 *  matrix[i].length      → columns in row i (jagged support)
 *
 * ============================================================
 * DEFAULT VALUES (same as 1D array)
 * ============================================================
 *
 *  int     → 0
 *  double  → 0.0
 *  boolean → false
 *  char    → '\u0000'
 *  String  → null
 *
 * ============================================================
 * TYPES OF 2D ARRAYS
 * ============================================================
 *
 *  1. Square Matrix      → rows == cols (3×3, 4×4)
 *  2. Rectangular Matrix → rows != cols (3×4, 2×5)
 *  3. Jagged Array       → each row has different cols
 *
 * ============================================================
 * COMMON 2D ARRAY OPERATIONS
 * ============================================================
 *
 *  1.  Declaration & Initialization
 *  2.  Traversal (row-major, col-major)
 *  3.  Input & Display (formatted)
 *  4.  Matrix Addition
 *  5.  Matrix Subtraction
 *  6.  Matrix Multiplication
 *  7.  Matrix Transpose
 *  8.  Sum of rows, columns, diagonals
 *  9.  Search in 2D array
 *  10. Spiral Matrix Traversal
 *  11. Diagonal Elements
 *  12. Symmetric Matrix Check
 *  13. Jagged Arrays
 *  14. Real-world examples
 *
 * ============================================================
 * JAGGED ARRAY
 * ============================================================
 *
 *  A 2D array where each row can have a DIFFERENT number
 *  of columns. Also called "ragged array".
 *
 *  int[][] jagged = new int[3][];   // 3 rows, cols undefined
 *  jagged[0] = new int[2];          // row 0: 2 elements
 *  jagged[1] = new int[4];          // row 1: 4 elements
 *  jagged[2] = new int[3];          // row 2: 3 elements
 *
 * ============================================================
 * PASSING 2D ARRAY TO METHOD
 * ============================================================
 *
 *  void printMatrix(int[][] mat) { ... }
 *  printMatrix(myMatrix);   // passed by reference
 *
 * ============================================================
 * Arrays.deepToString() & Arrays.deepEquals()
 * ============================================================
 *
 *  Arrays.toString()     → only works for 1D arrays
 *  Arrays.deepToString() → works for 2D/3D nested arrays
 *  Arrays.deepEquals()   → compares 2D arrays content-wise
 *
 * ============================================================
 * IMPORTANT NOTES
 * ============================================================
 *
 *  - matrix.length    → rows (NOT total elements)
 *  - matrix[i].length → columns of row i
 *  - Index: matrix[row][col], both start from 0
 *  - ArrayIndexOutOfBoundsException if invalid index used
 *  - 2D arrays are OBJECTS stored on heap memory
 *  - Each ROW is a separate 1D array object
 *  - Java 2D arrays are NOT truly contiguous in memory
 *
 * ============================================================
 */

import java.util.Arrays;

public class TwoDimensionalArrays {

    // ── Helper: Print 2D matrix with label ──
    static void printMatrix(String label, int[][] mat) {
        System.out.println(label + ":");
        for (int[] row : mat) {
            System.out.print("  ");
            for (int val : row) System.out.printf("%5d", val);
            System.out.println();
        }
    }

    // ── Helper: Print formatted matrix with border ──
    static void printMatrixBorder(int[][] mat) {
        int cols = mat[0].length;
        String border = "  +" + "-----+".repeat(cols);
        System.out.println(border);
        for (int[] row : mat) {
            System.out.print("  |");
            for (int val : row) System.out.printf("%4d |", val);
            System.out.println();
            System.out.println(border);
        }
    }

    // ── Helper: Print double matrix ──
    static void printMatrixD(String label, double[][] mat) {
        System.out.println(label + ":");
        for (double[] row : mat) {
            System.out.print("  ");
            for (double val : row) System.out.printf("%8.2f", val);
            System.out.println();
        }
    }

    // ── Helper: separator ──
    static void sep() { System.out.println("  " + "-".repeat(45)); }

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("#     TWO DIMENSIONAL ARRAYS IN JAVA       #");
        System.out.println("############################################");

        // ============================================================
        // 1. DECLARATION, CREATION & INITIALIZATION
        // ============================================================
        System.out.println("\n===== 1. DECLARATION, CREATION & INIT =====");

        // Step by step
        int[][] stepMat;                        // Declaration
        stepMat = new int[3][3];                // Creation
        stepMat[0][0]=1; stepMat[0][1]=2; stepMat[0][2]=3;
        stepMat[1][0]=4; stepMat[1][1]=5; stepMat[1][2]=6;
        stepMat[2][0]=7; stepMat[2][1]=8; stepMat[2][2]=9;
        printMatrix("Step-by-step", stepMat);

        // Declaration + Creation (default 0s)
        int[][] defaultMat = new int[3][4];
        printMatrix("Default (3×4)", defaultMat);

        // Shorthand initialization
        int[][] shortMat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        printMatrix("Shorthand (3×3)", shortMat);

        // Rectangular matrix (3 rows × 4 cols)
        int[][] rect = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9, 10, 11, 12}
        };
        printMatrix("Rectangular (3×4)", rect);
        System.out.println("  Rows : " + rect.length);
        System.out.println("  Cols : " + rect[0].length);
        System.out.println("  Total elements: " + rect.length * rect[0].length);

        // Different data types
        double[][] dMat = {{1.1,2.2},{3.3,4.4},{5.5,6.6}};
        String[][] sMat = {{"Alice","Bob"},{"Charlie","Diana"},{"Eve","Frank"}};
        boolean[][] bMat= {{true,false},{false,true}};

        printMatrixD("double[][]", dMat);
        System.out.println("String[][] :");
        for (String[] row : sMat) System.out.println("  " + Arrays.toString(row));
        System.out.println("boolean[][]:");
        for (boolean[] row : bMat) System.out.println("  " + Arrays.toString(row));

        // ============================================================
        // 2. ACCESSING & MODIFYING ELEMENTS
        // ============================================================
        System.out.println("\n===== 2. ACCESSING & MODIFYING ELEMENTS =====");

        int[][] mat = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };
        printMatrix("Original", mat);
        System.out.println("  mat[0][0] = " + mat[0][0]);  // 10
        System.out.println("  mat[1][2] = " + mat[1][2]);  // 60
        System.out.println("  mat[2][1] = " + mat[2][1]);  // 80

        // Modify
        mat[1][1] = 999;
        System.out.println("  After mat[1][1]=999:");
        printMatrix("Modified", mat);

        // Reset
        mat[1][1] = 50;

        // Safe access
        System.out.println("  Safe access check:");
        int r = 5, c = 2;
        if (r >= 0 && r < mat.length && c >= 0 && c < mat[0].length)
            System.out.println("  mat[" + r + "][" + c + "] = " + mat[r][c]);
        else
            System.out.println("  mat[" + r + "][" + c + "] → ✘ Out of bounds!");

        // ============================================================
        // 3. TRAVERSAL (Row-major & Column-major)
        // ============================================================
        System.out.println("\n===== 3. TRAVERSAL =====");

        int[][] tMat = {{1,2,3},{4,5,6},{7,8,9}};
        printMatrix("Matrix", tMat);

        // Row-major traversal (row by row)
        System.out.println("--- Row-Major Traversal ---");
        for (int i = 0; i < tMat.length; i++) {
            System.out.print("  Row " + i + ": ");
            for (int j = 0; j < tMat[i].length; j++) {
                System.out.printf("%3d", tMat[i][j]);
            }
            System.out.println();
        }

        // Column-major traversal (col by col)
        // System.out.println("--- Column-Major Traversal ---");
        // for (int j = 0; j < tMat[0].length; j++) {
        //     System.out.print("  Col " + j + ": ");
        //     for (int i = 0; i < tMat.length; i++) {
        //         System.out.printf("%3d", tMat[i][j]);
        //     }
        //     System.out.println();
        // }

        // for-each traversal
        System.out.println("--- for-each Traversal ---");
        System.out.print("  ");
        for (int[] row : tMat)
            for (int val : row)
                System.out.printf("%3d", val);
        System.out.println();

        // Formatted box display
        System.out.println("--- Formatted Box Display ---");
        printMatrixBorder(tMat);

        // Arrays.deepToString()
        System.out.println("deepToString: " + Arrays.deepToString(tMat));

        // ============================================================
        // 4. SUM OF ROWS, COLUMNS & DIAGONALS
        // ============================================================
        System.out.println("\n===== 4. ROW, COLUMN & DIAGONAL SUMS =====");

        int[][] sumMat = {
            { 1,  2,  3,  4},
            { 5,  6,  7,  8},
            { 9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        printMatrix("Matrix (4×4)", sumMat);
        int rows4 = sumMat.length;
        int cols4 = sumMat[0].length;

        // Row sums
        System.out.println("--- Row Sums ---");
        for (int i = 0; i < rows4; i++) {
            int rSum = 0;
            for (int j = 0; j < cols4; j++) rSum += sumMat[i][j];
            System.out.printf("  Row %d sum = %d%n", i, rSum);
        }

        // Column sums
        System.out.println("--- Column Sums ---");
        for (int j = 0; j < cols4; j++) {
            int cSum = 0;
            for (int i = 0; i < rows4; i++) cSum += sumMat[i][j];
            System.out.printf("  Col %d sum = %d%n", j, cSum);
        }

        // Total sum
        int totalSum = 0;
        for (int[] row : sumMat) for (int v : row) totalSum += v;
        System.out.println("  Total sum = " + totalSum);

        // Primary diagonal (top-left → bottom-right)
        System.out.println("--- Diagonal Sums (square matrix) ---");
        int[][] sq = {{1,2,3},{4,5,6},{7,8,9}};
        int primaryDiag = 0, secondaryDiag = 0;
        int n = sq.length;
        for (int i = 0; i < n; i++) {
            primaryDiag   += sq[i][i];
            secondaryDiag += sq[i][n - 1 - i];
        }
        System.out.println("  Primary   diagonal (↘): " + primaryDiag);   // 1+5+9=15
        System.out.println("  Secondary diagonal (↙): " + secondaryDiag); // 3+5+7=15

        // ============================================================
        // 5. MATRIX TRANSPOSE
        // ============================================================
        System.out.println("\n===== 5. MATRIX TRANSPOSE =====");

        int[][] orig = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] transposed = new int[orig[0].length][orig.length];
        for (int i = 0; i < orig.length; i++)
            for (int j = 0; j < orig[0].length; j++)
                transposed[j][i] = orig[i][j];

        printMatrix("Original  (3×3)", orig);
        printMatrix("Transposed(3×3)", transposed);

        // Rectangular transpose (2×3 → 3×2)
        int[][] rect2 = {{1,2,3},{4,5,6}};
        int[][] trans2 = new int[rect2[0].length][rect2.length];
        for (int i = 0; i < rect2.length; i++)
            for (int j = 0; j < rect2[0].length; j++)
                trans2[j][i] = rect2[i][j];
        printMatrix("Original  (2×3)", rect2);
        printMatrix("Transposed(3×2)", trans2);

        // ============================================================
        // 6. MATRIX ADDITION & SUBTRACTION
        // ============================================================
        System.out.println("\n===== 6. MATRIX ADDITION & SUBTRACTION =====");

        int[][] mA = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mB = {{9,8,7},{6,5,4},{3,2,1}};
        int     mRows = mA.length;
        int     mCols = mA[0].length;
        int[][] addResult = new int[mRows][mCols];
        int[][] subResult = new int[mRows][mCols];

        for (int i = 0; i < mRows; i++)
            for (int j = 0; j < mCols; j++) {
                addResult[i][j] = mA[i][j] + mB[i][j];
                subResult[i][j] = mA[i][j] - mB[i][j];
            }

        printMatrix("Matrix A", mA);
        printMatrix("Matrix B", mB);
        printMatrix("A + B   ", addResult);
        printMatrix("A - B   ", subResult);

        // ============================================================
        // 7. MATRIX MULTIPLICATION
        // ============================================================
        System.out.println("\n===== 7. MATRIX MULTIPLICATION =====");

        int[][] m1 = {{1,2},{3,4},{5,6}};   // 3×2
        int[][] m2 = {{7,8,9},{10,11,12}};  // 2×3
        // Result: 3×3 (m1.rows × m2.cols)
        int[][] mulResult = new int[m1.length][m2[0].length];

        for (int i = 0; i < m1.length; i++)
            for (int j = 0; j < m2[0].length; j++)
                for (int k = 0; k < m1[0].length; k++)
                    mulResult[i][j] += m1[i][k] * m2[k][j];

        printMatrix("M1 (3×2)", m1);
        printMatrix("M2 (2×3)", m2);
        printMatrix("M1 × M2 = (3×3)", mulResult);

        // Check if multiplication is possible
        System.out.println("  M1 cols (" + m1[0].length +
                ") == M2 rows (" + m2.length + ") → ✔ Multiplication possible");

        // ============================================================
        // 8. SEARCH IN 2D ARRAY
        // ============================================================
        System.out.println("\n===== 8. SEARCH IN 2D ARRAY =====");

        int[][] searchMat = {
            {10, 20, 30, 40},
            {50, 60, 70, 80},
            {90, 100,110,120}
        };
        printMatrix("Search Matrix", searchMat);

        int[] searchKeys = {70, 55, 100};
        for (int key : searchKeys) {
            boolean found = false;
            outer:
            for (int i = 0; i < searchMat.length; i++) {
                for (int j = 0; j < searchMat[i].length; j++) {
                    if (searchMat[i][j] == key) {
                        System.out.printf("  Search %3d → ✔ Found at [%d][%d]%n", key, i, j);
                        found = true;
                        break outer;
                    }
                }
            }
            if (!found)
                System.out.printf("  Search %3d → ✘ Not found%n", key);
        }

        // ============================================================
        // 9. MIN & MAX IN 2D ARRAY
        // ============================================================
        System.out.println("\n===== 9. MIN & MAX IN 2D ARRAY =====");

        int[][] mmMat = {
            {45, 12, 78},
            {34, 89, 23},
            {56, 67, 11}
        };
        printMatrix("Matrix", mmMat);

        int gMax = mmMat[0][0], gMin = mmMat[0][0];
        int gmR = 0, gmC = 0, gnR = 0, gnC = 0;

        for (int i = 0; i < mmMat.length; i++)
            for (int j = 0; j < mmMat[i].length; j++) {
                if (mmMat[i][j] > gMax) { gMax=mmMat[i][j]; gmR=i; gmC=j; }
                if (mmMat[i][j] < gMin) { gMin=mmMat[i][j]; gnR=i; gnC=j; }
            }

        System.out.printf("  Max = %d at [%d][%d]%n", gMax, gmR, gmC);
        System.out.printf("  Min = %d at [%d][%d]%n", gMin, gnR, gnC);

        // ============================================================
        // 10. DIAGONAL ELEMENTS
        // ============================================================
        System.out.println("\n===== 10. DIAGONAL ELEMENTS =====");

        int[][] diagMat = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9,  10, 11, 12},
            {13, 14, 15, 16}
        };
        printMatrix("Matrix (4×4)", diagMat);
        int dn = diagMat.length;

        System.out.print("  Primary   diagonal (↘): ");
        for (int i = 0; i < dn; i++) System.out.print(diagMat[i][i] + " ");
        System.out.println();

        System.out.print("  Secondary diagonal (↙): ");
        for (int i = 0; i < dn; i++) System.out.print(diagMat[i][dn-1-i] + " ");
        System.out.println();

        // ============================================================
        // 11. SYMMETRIC MATRIX CHECK
        // ============================================================
        System.out.println("\n===== 11. SYMMETRIC MATRIX CHECK =====");
        // A matrix is symmetric if mat[i][j] == mat[j][i]

        int[][] symMat = {{1,2,3},{2,5,4},{3,4,6}};
        int[][] notSym = {{1,2,3},{4,5,6},{7,8,9}};

        printMatrix("Matrix 1", symMat);
        System.out.println("  Is Symmetric: " + isSymmetric(symMat));  // true

        printMatrix("Matrix 2", notSym);
        System.out.println("  Is Symmetric: " + isSymmetric(notSym));  // false

        // ============================================================
        // 12. SPIRAL MATRIX TRAVERSAL
        // ============================================================
        System.out.println("\n===== 12. SPIRAL TRAVERSAL =====");

        int[][] spiral = {
            { 1,  2,  3,  4},
            { 5,  6,  7,  8},
            { 9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        printMatrix("Matrix (4×4)", spiral);
        System.out.print("  Spiral order: ");
        spiralTraversal(spiral);
        System.out.println();

        // ============================================================
        // 13. JAGGED ARRAY
        // ============================================================
        System.out.println("\n===== 13. JAGGED ARRAY =====");

        int[][] jagged = new int[4][];
        jagged[0] = new int[]{1};
        jagged[1] = new int[]{1, 2};
        jagged[2] = new int[]{1, 2, 3};
        jagged[3] = new int[]{1, 2, 3, 4};

        System.out.println("Jagged Array (Triangle shape):");
        for (int i = 0; i < jagged.length; i++) {
            System.out.printf("  Row %d (%d cols): ", i, jagged[i].length);
            for (int val : jagged[i]) System.out.print(val + " ");
            System.out.println();
        }

        // Pascal's Triangle using jagged array
        System.out.println("\n--- Pascal's Triangle (5 rows) ---");
        int rows5 = 5;
        int[][] pascal = new int[rows5][];
        for (int i = 0; i < rows5; i++) {
            pascal[i] = new int[i + 1];
            pascal[i][0] = pascal[i][i] = 1;
            for (int j = 1; j < i; j++)
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
        }
        for (int i = 0; i < rows5; i++) {
            System.out.print("  ");
            for (int sp = 0; sp < rows5 - i - 1; sp++) System.out.print("  ");
            for (int val : pascal[i]) System.out.printf("%3d ", val);
            System.out.println();
        }

        // ============================================================
        // 14. COPY 2D ARRAY
        // ============================================================
        System.out.println("\n===== 14. COPY 2D ARRAY =====");

        int[][] original = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] deepCopy = new int[original.length][];
        for (int i = 0; i < original.length; i++)
            deepCopy[i] = Arrays.copyOf(original[i], original[i].length);

        deepCopy[0][0] = 999;   // modify copy
        printMatrix("Original (unchanged)", original);
        printMatrix("Deep Copy (modified)", deepCopy);

        // Arrays.deepEquals()
        int[][] eq1 = {{1,2},{3,4}};
        int[][] eq2 = {{1,2},{3,4}};
        int[][] eq3 = {{1,2},{3,5}};
        System.out.println("deepEquals(eq1,eq2): " + Arrays.deepEquals(eq1,eq2)); // true
        System.out.println("deepEquals(eq1,eq3): " + Arrays.deepEquals(eq1,eq3)); // false

        // ============================================================
        // 15. REAL-WORLD EXAMPLES
        // ============================================================
        System.out.println("\n===== 15. REAL-WORLD EXAMPLES =====");

        // Example 1: Student Marks — Multiple Subjects
        System.out.println("--- Student Marks Sheet ---");
        String[] stuNames = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        String[] subjects = {"Math", "Science", "English", "Hindi", "CS"};
        int[][] stuMarks  = {
            {92, 88, 76, 84, 95},
            {74, 65, 80, 72, 68},
            {98, 95, 91, 89, 97},
            {55, 48, 62, 58, 50},
            {85, 90, 78, 88, 92}
        };

        // Header
        System.out.printf("  %-10s", "Name");
        for (String sub : subjects) System.out.printf("%9s", sub);
        System.out.printf("%8s%7s%n", "Total", "Grade");
        sep();

        for (int i = 0; i < stuNames.length; i++) {
            int rowTotal = 0;
            System.out.printf("  %-10s", stuNames[i]);
            for (int m : stuMarks[i]) {
                System.out.printf("%9d", m);
                rowTotal += m;
            }
            double avg2   = (double) rowTotal / subjects.length;
            String grade2 = avg2>=90?"A+":avg2>=80?"A":avg2>=70?"B":avg2>=60?"C":"D";
            System.out.printf("%8d%7s%n", rowTotal, grade2);
        }
        sep();

        // Subject averages
        System.out.printf("  %-10s", "Avg");
        for (int j = 0; j < subjects.length; j++) {
            double subSum = 0;
            for (int[] row : stuMarks) subSum += row[j];
            System.out.printf("%9.1f", subSum / stuNames.length);
        }
        System.out.println();

        // Example 2: Seating Chart (Cinema Hall)
        System.out.println("\n--- Cinema Hall Seating (1=Booked, 0=Available) ---");
        int[][] seats = {
            {1, 0, 1, 1, 0, 1, 0, 0},
            {1, 1, 0, 1, 1, 0, 1, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1}
        };

        System.out.print("     ");
        for (int c1 = 1; c1 <= seats[0].length; c1++)
            System.out.printf("%3d", c1);
        System.out.println("   ← Seat No.");
        sep();

        int totalBooked = 0, totalAvail = 0;
        for (int i = 0; i < seats.length; i++) {
            System.out.printf("  R%d |", i + 1);
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] == 1 ? "  ✘" : "  ○");
                if (seats[i][j] == 1) totalBooked++;
                else totalAvail++;
            }
            System.out.println();
        }
        sep();
        System.out.println("  ✘ = Booked  ○ = Available");
        System.out.println("  Total Booked   : " + totalBooked);
        System.out.println("  Total Available: " + totalAvail);

        // Example 3: Sales Report (Monthly)
        System.out.println("\n--- Quarterly Sales Report ---");
        String[] salesReps = {"Alice", "Bob", "Charlie", "Diana"};
        String[] months    = {"January", "February", "March"};
        double[][] sales   = {
            {45000, 52000, 48000},
            {38000, 41000, 55000},
            {62000, 58000, 70000},
            {29000, 35000, 42000}
        };

        System.out.printf("  %-10s", "Sales Rep");
        for (String mo : months) System.out.printf("%12s", mo);
        System.out.printf("%12s%n", "Total");
        sep();

        double bestSales = 0; String bestRep = "";
        for (int i = 0; i < salesReps.length; i++) {
            double repTotal = 0;
            System.out.printf("  %-10s", salesReps[i]);
            for (double s : sales[i]) {
                System.out.printf("%12.0f", s);
                repTotal += s;
            }
            System.out.printf("%12.0f%n", repTotal);
            if (repTotal > bestSales) { bestSales = repTotal; bestRep = salesReps[i]; }
        }
        sep();

        // Monthly totals
        System.out.printf("  %-10s", "Total");
        double grandSales = 0;
        for (int j = 0; j < months.length; j++) {
            double mTotal = 0;
            for (double[] row : sales) mTotal += row[j];
            System.out.printf("%12.0f", mTotal);
            grandSales += mTotal;
        }
        System.out.printf("%12.0f%n", grandSales);
        sep();
        System.out.println("  🏆 Top Performer: " + bestRep
                + " (₹" + String.format("%.0f", bestSales) + ")");

        System.out.println("\n############################################");
        System.out.println("#  Two Dimensional Arrays — Done! ✔       #");
        System.out.println("############################################");
    }

    // ── Method: Check Symmetric Matrix ──
    static boolean isSymmetric(int[][] mat) {
        if (mat.length != mat[0].length) return false;
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                if (mat[i][j] != mat[j][i]) return false;
        return true;
    }

    // ── Method: Spiral Traversal ──
    static void spiralTraversal(int[][] mat) {
        int top=0, bottom=mat.length-1;
        int left=0, right=mat[0].length-1;
        while (top <= bottom && left <= right) {
            for (int i = left;  i <= right;  i++) System.out.print(mat[top][i]    + " ");
            top++;
            for (int i = top;   i <= bottom; i++) System.out.print(mat[i][right]  + " ");
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--)  System.out.print(mat[bottom][i] + " ");
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--)  System.out.print(mat[i][left]   + " ");
                left++;
            }
        }
    }
}