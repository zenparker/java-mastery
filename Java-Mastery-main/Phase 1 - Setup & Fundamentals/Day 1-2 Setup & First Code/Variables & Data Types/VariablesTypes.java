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
