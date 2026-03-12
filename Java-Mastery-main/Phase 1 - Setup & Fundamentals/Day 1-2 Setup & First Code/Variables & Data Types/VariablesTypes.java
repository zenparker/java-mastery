//Types of Variables in Java
public class VariablesTypes {
    
    //Instance Variable
    int instanceVariable = 10;

    //Static Variable
    static int staticVariable = 20;

    //This is a method to demonstrate local variable
    public void method() {
        //Local Variable
        int localVariable = 30;
        System.out.println("Local Variable: " + localVariable);
    }

    // Another method to demonstrate local variable

    public void method2() {
        int localVariable = 40;
        System.out.println("Local Variable: " + localVariable);
    }

    public static void main(String[] args) {
        VariablesTypes obj = new VariablesTypes(); //new keyword is used to create an object of the class and obj is the reference variable that holds the reference to the object created in the heap memory.

        System.out.println("Instance Variable: " + obj.instanceVariable);
        System.out.println("Static Variable: " + VariablesTypes.staticVariable);
        obj.method(); // Calling the method to demonstrate local variable
        obj.method2(); // Calling the second method to demonstrate local variable
    }
}

//Naming conventions for variables in Java:
//1. Variable names should start with a letter, underscore (_), or dollar sign ($). They cannot start with a number.
//2. Variable names should be meaningful and descriptive of their purpose.
//3. Variable names should follow camelCase convention, where the first word is lowercase and subsequent words are capitalized (e.g., myVariable).
//4. Variable names should not be the same as Java reserved keywords (e.g., int, class, public).

//Types of Variables in Java:
//1. Instance Variable: A variable that is declared inside a class, but outside any method, constructor, or block. It is also known as a class-level variable. It is not initialized by default and must be initialized before it is used.
//2. Static Variable: A variable that is declared with the static keyword. It belongs to the class rather than any instance of the class. It is initialized only once and shared among all instances of the class.
//3. Local Variable: A variable that is declared inside a method, constructor, or block

// Snake case is a naming convention where words are separated by underscores (e.g., my_variable). It is commonly used in languages like Python but is not typically used in Java. In Java, camelCase is the preferred naming convention for variables.
// Pascal case is a naming convention where words are capitalized and separated by underscores (e.g., MyVariable). It is commonly used in languages like C# but is not typically used in Java. In Java, camelCase is the preferred naming convention for variables.
// Hungarian notation is a naming convention where the type of the variable is indicated by a prefix (e.g., int myVariable). It is not commonly used in Java and is generally discouraged.
//Camel case is a naming convention where the first word is lowercase and subsequent words are capitalized (e.g., myVariable). It is the preferred naming convention for variables in Java.
//Java is a strongly typed language, which means that the type of a variable must be explicitly declared and cannot be changed once it is declared. This helps to prevent errors and ensures that the program behaves as expected.