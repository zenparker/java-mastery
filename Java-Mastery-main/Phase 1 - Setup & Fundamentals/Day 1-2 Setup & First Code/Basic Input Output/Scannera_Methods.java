import java.util.Scanner;

public class Scannera_Methods {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading an integer
        System.out.print("Enter an integer: "); // Input is integer like 10, 20, 30 etc.
        int num = sc.nextInt();
        System.out.println("You entered: " + num);

        // Reading a double
        System.out.print("Enter a double: "); // Input is double like 10.5, 20.75, 30.0 etc.
        double d = sc.nextDouble();
        System.out.println("You entered: " + d); 

        // Reading a float
        System.out.print("Enter a float: "); // Input is float like 10.5f, 20.75f, 30.0f etc.
        float f = sc.nextFloat();
        System.out.println("You entered: " + f);

        // Reading a long
        System.out.print("Enter a long: "); // Input is long like 100L, 200L, 300L etc.
        long l = sc.nextLong();
        System.out.println("You entered: " + l);

        // Reading a boolean
        System.out.print("Enter a boolean: "); // Input is boolean like true, false etc.
        boolean b = sc.nextBoolean();
        System.out.println("You entered: " + b);

        // Reading a string
        System.out.print("Enter a string: "); // Input is string like Hello, World, Java etc. It will read only the first word until space is encountered.
        String str = sc.next();
        System.out.println("You entered: " + str);

        // Reading Character
        System.out.print("Enter a character: "); // Input is character like a, b, c etc. It will read only the first character of the input.
        char c = sc.next().charAt(0);
        System.out.println("You entered: " + c);

        // Reading a short
        System.out.print("Enter a short: "); // Input is short like 10, 20, 30 etc. It will read the short value from the input.
        short s = sc.nextShort();
        System.out.println("You entered: " + s);

       // Reading a byte
        System.out.print("Enter a byte: "); // Input is byte like 10, 20, 30 etc. It will read the byte value from the input.
        byte by = sc.nextByte();
        System.out.println("You entered: " + by);

        // Reading a line of text
        System.out.print("Enter a line of text: "); // Input is string like Hello, World, Java etc. It will read the entire line until newline is encountered.
        sc.nextLine(); // Consume the newline left-over
        String line = sc.nextLine();
        System.out.println("You entered: " + line);

        // Clearing the buffer before reading the next line
        System.out.print("Enter another line of text: "); // Input is string like Hello, World, Java etc. It will read the entire line until newline is encountered.
        String line2 = sc.nextLine();
        System.out.println("You entered: " + line2);

        //Reading a single word
        System.out.print("Enter a single word: "); //Input is string like Hello, World, Java etc. It will read only the first word until space is encountered.
        String word = sc.next();
        System.out.println("You entered: " + word);


        // Reading multiple inputs in one line
        System.out.print("Enter multiple inputs (int, double, string): "); // Input is like 10 20.5 Hello etc. It will read the integer, double and string in one line separated by space.
        int num2 = sc.nextInt();
        double d2 = sc.nextDouble();
        String str2 = sc.next();
        System.out.println("You entered: " + num2 + ", " + d2 + ", " + str2);
        
        // Closing the scanner
        sc.close();

    }
}