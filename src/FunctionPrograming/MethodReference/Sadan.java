package FunctionPrograming.MethodReference;

public class Sadan extends Car{
    public Sadan(String name, String brand) {
        super(name, brand);
    }

    public void drive() {
        System.out.println("Driving a sedan ' " + name + " from " + brand);
    }
}
