package FunctionPrograming.MethodReference;

public class Ben extends Car{
    public Ben(String name, String brand) {
        super(name, brand);
    }

    public void drive() {
        System.out.println("Driving an Ben " + name + " from"  + brand );
    }
}
