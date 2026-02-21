/**
 * Bit Manipulation in Java
 * 
 * This program demonstrates:
 * - AND (&), OR (|), XOR (^), NOT (~)
 * - Left shift (<<), Right shift (>>)
 * - Check if bit set
 * - Count set bits
 * - Power of 2 check
 * - Ten bit manipulation problems
 */
public class BitManipulation {
    public static void main(String[] args) {
        // Program 1: Basic bitwise operations (AND, OR, XOR, NOT)
        System.out.println("Program 1 - Basic bitwise operations:");
        int a = 12; // Binary: 1100
        int b = 10; // Binary: 1010
        
        System.out.println("a = " + a + " (binary: " + Integer.toBinaryString(a) + ")");
        System.out.println("b = " + b + " (binary: " + Integer.toBinaryString(b) + ")");
        
        System.out.println("a & b (AND) = " + (a & b) + " (binary: " + Integer.toBinaryString(a & b) + ")");
        System.out.println("a | b (OR)  = " + (a | b) + " (binary: " + Integer.toBinaryString(a | b) + ")");
        System.out.println("a ^ b (XOR) = " + (a ^ b) + " (binary: " + Integer.toBinaryString(a ^ b) + ")");
        System.out.println("~a (NOT)    = " + (~a) + " (binary: " + Integer.toBinaryString(~a) + ")");
        System.out.println();
        
        // Program 2: Left and Right shift operations
        System.out.println("Program 2 - Left and Right shift operations:");
        int num = 8; // Binary: 1000
        System.out.println("num = " + num + " (binary: " + Integer.toBinaryString(num) + ")");
        
        int leftShift = num << 2; // Shift left by 2 positions (multiply by 2^2 = 4)
        System.out.println("num << 2 = " + leftShift + " (binary: " + Integer.toBinaryString(leftShift) + ")");
        
        int rightShift = num >> 2; // Shift right by 2 positions (divide by 2^2 = 4)
        System.out.println("num >> 2 = " + rightShift + " (binary: " + Integer.toBinaryString(rightShift) + ")");
        
        int unsignedRightShift = -8 >>> 2; // Unsigned right shift
        System.out.println("-8 >>> 2 = " + unsignedRightShift + " (unsigned right shift)");
        System.out.println();
        
        // Program 3: Check if a specific bit is set
        System.out.println("Program 3 - Check if a specific bit is set:");
        int value = 26; // Binary: 11010
        System.out.println("value = " + value + " (binary: " + Integer.toBinaryString(value) + ")");
        
        // Check if bit at position 1 is set (positions start from 0)
        int position = 1;
        boolean isBitSet = (value & (1 << position)) != 0;
        System.out.println("Is bit at position " + position + " set? " + isBitSet);
        
        // Check if bit at position 3 is set
        position = 3;
        isBitSet = (value & (1 << position)) != 0;
        System.out.println("Is bit at position " + position + " set? " + isBitSet);
        
        // Check if bit at position 4 is set
        position = 4;
        isBitSet = (value & (1 << position)) != 0;
        System.out.println("Is bit at position " + position + " set? " + isBitSet);
        System.out.println();
        
        // Program 4: Count set bits (Hamming weight)
        System.out.println("Program 4 - Count set bits:");
        int number = 29; // Binary: 11101
        System.out.println("number = " + number + " (binary: " + Integer.toBinaryString(number) + ")");
        
        int count = countSetBits(number);
        System.out.println("Number of set bits in " + number + ": " + count);
        
        // Using built-in method
        int builtinCount = Integer.bitCount(number);
        System.out.println("Using Integer.bitCount(): " + builtinCount);
        System.out.println();
        
        // Program 5: Check if a number is power of 2
        System.out.println("Program 5 - Check if a number is power of 2:");
        int[] testNumbers = {1, 2, 3, 4, 8, 15, 16, 31, 32, 64, 65};
        
        for (int n : testNumbers) {
            boolean isPowerOfTwo = isPowerOfTwo(n);
            System.out.println(n + " is power of 2: " + isPowerOfTwo);
        }
        System.out.println();
        
        // Program 6: Toggle a specific bit
        System.out.println("Program 6 - Toggle a specific bit:");
        int original = 12; // Binary: 1100
        System.out.println("Original = " + original + " (binary: " + Integer.toBinaryString(original) + ")");
        
        int bitPosition = 1;
        int toggled = toggleBit(original, bitPosition);
        System.out.println("After toggling bit at position " + bitPosition + ": " + toggled + 
                          " (binary: " + Integer.toBinaryString(toggled) + ")");
        System.out.println();
        
        // Program 7: Turn off a specific bit
        System.out.println("Program 7 - Turn off a specific bit:");
        int numToModify = 15; // Binary: 1111
        System.out.println("Original = " + numToModify + " (binary: " + Integer.toBinaryString(numToModify) + ")");
        
        int positionToTurnOff = 2;
        int turnedOff = turnOffBit(numToModify, positionToTurnOff);
        System.out.println("After turning off bit at position " + positionToTurnOff + ": " + turnedOff + 
                          " (binary: " + Integer.toBinaryString(turnedOff) + ")");
        System.out.println();
        
        // Program 8: Turn on a specific bit
        System.out.println("Program 8 - Turn on a specific bit:");
        int numToChange = 8; // Binary: 1000
        System.out.println("Original = " + numToChange + " (binary: " + Integer.toBinaryString(numToChange) + ")");
        
        int positionToTurnOn = 1;
        int turnedOn = turnOnBit(numToChange, positionToTurnOn);
        System.out.println("After turning on bit at position " + positionToTurnOn + ": " + turnedOn + 
                          " (binary: " + Integer.toBinaryString(turnedOn) + ")");
        System.out.println();
        
        // Program 9: Swap two numbers without temporary variable
        System.out.println("Program 9 - Swap two numbers using XOR:");
        int x = 5, y = 10;
        System.out.println("Before swap: x = " + x + ", y = " + y);
        
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        
        System.out.println("After swap: x = " + x + ", y = " + y);
        System.out.println();
        
        // Program 10: Find the rightmost set bit
        System.out.println("Program 10 - Find the rightmost set bit:");
        int n = 20; // Binary: 10100
        System.out.println("n = " + n + " (binary: " + Integer.toBinaryString(n) + ")");
        
        int rightmostSetBitPosition = findRightmostSetBit(n);
        System.out.println("Rightmost set bit position: " + rightmostSetBitPosition);
        System.out.println();
        
        // Additional examples
        
        // Example 1: Find two numbers that appear once in an array where all others appear twice
        System.out.println("Additional Example 1 - Find two unique numbers:");
        int[] arr = {1, 2, 3, 4, 1, 2};
        findTwoUniqueNumbers(arr);
        System.out.println();
        
        // Example 2: Reverse bits of a number
        System.out.println("Additional Example 2 - Reverse bits of a number:");
        int numToReverse = 4; // Binary: 100
        int reversed = reverseBits(numToReverse, 8); // Reverse in 8-bit context
        System.out.println("Original: " + numToReverse + " (binary: " + String.format("%8s", Integer.toBinaryString(numToReverse)).replace(' ', '0') + ")");
        System.out.println("Reversed: " + reversed + " (binary: " + String.format("%8s", Integer.toBinaryString(reversed)).replace(' ', '0') + ")");
    }
    
    // Count set bits in a number
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1; // Add 1 if the rightmost bit is set
            n = n >>> 1; // Unsigned right shift to check next bit
        }
        return count;
    }
    
    // Check if a number is power of 2
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        // A power of 2 has exactly one bit set, so n & (n-1) will be 0
        return (n & (n - 1)) == 0;
    }
    
    // Toggle a specific bit
    public static int toggleBit(int n, int position) {
        return n ^ (1 << position);
    }
    
    // Turn off a specific bit
    public static int turnOffBit(int n, int position) {
        return n & ~(1 << position);
    }
    
    // Turn on a specific bit
    public static int turnOnBit(int n, int position) {
        return n | (1 << position);
    }
    
    // Find the rightmost set bit position (1-indexed)
    public static int findRightmostSetBit(int n) {
        if (n == 0) return 0;
        // n & -n gives us the rightmost set bit
        int rightmostBit = n & -n;
        // Find its position
        int position = 0;
        while ((rightmostBit & 1) == 0) {
            rightmostBit >>= 1;
            position++;
        }
        return position + 1;
    }
    
    // Find two numbers that appear once in an array where others appear twice
    public static void findTwoUniqueNumbers(int[] arr) {
        int xorResult = 0;
        for (int num : arr) {
            xorResult ^= num;
        }
        
        // Find rightmost set bit in xorResult
        int rightmostSetBit = xorResult & -xorResult;
        
        int group1 = 0, group2 = 0;
        for (int num : arr) {
            if ((num & rightmostSetBit) == 0) {
                group1 ^= num;
            } else {
                group2 ^= num;
            }
        }
        
        System.out.println("Two unique numbers: " + group1 + " and " + group2);
    }
    
    // Reverse bits of a number in specified bit-width
    public static int reverseBits(int n, int bitWidth) {
        int result = 0;
        for (int i = 0; i < bitWidth; i++) {
            result <<= 1; // Left shift result
            result |= (n & 1); // Add the rightmost bit of n to result
            n >>= 1; // Right shift n
        }
        return result;
    }
}