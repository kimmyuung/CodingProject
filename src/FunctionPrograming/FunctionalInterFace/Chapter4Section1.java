package FunctionPrograming.FunctionalInterFace;

public class Chapter4Section1 {
    public static void main(String[] args) {
        Supplier<String> myStringSupplier = () -> "Hello, world!";
        System.out.println(myStringSupplier.get());

        System.out.println(myStringSupplier.get());

        Supplier<Double> myRandomSupplier = () -> Math.random();
       printRandomDoubles(myRandomSupplier, 5);
    }

        public static void printRandomDoubles(Supplier<Double> randomSupplier
        , int count) {
            for(int i = 0; i <count; i++) {
                System.out.println(randomSupplier.get());
            }
        }

}
