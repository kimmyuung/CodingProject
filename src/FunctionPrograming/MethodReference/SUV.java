package FunctionPrograming.MethodReference;

public class SUV extends Car{
    public SUV(String name, String brand) {
        super(name, brand);
    }

    public void drive() {
        System.out.println("Driving an SUV " + name + " from"  + brand );
    }
}
