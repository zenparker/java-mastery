//Types of Variables in Java
public class VariablesTypes {
    
    //Instance Variable
    int instanceVariable = 10;

    //Static Variable
    static int staticVariable = 20;

    public void method() {
        //Local Variable
        int localVariable = 30;
        System.out.println("Local Variable: " + localVariable);
    }

    public static void main(String[] args) {
        VariablesTypes obj = new VariablesTypes();
        System.out.println("Instance Variable: " + obj.instanceVariable);
        System.out.println("Static Variable: " + VariablesTypes.staticVariable);
        obj.method();
    }
}