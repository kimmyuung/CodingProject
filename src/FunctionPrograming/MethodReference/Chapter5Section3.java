package FunctionPrograming.MethodReference;
import FunctionPrograming.FunctionalInterFace.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
public class Chapter5Section3 {
    public static void main(String[] args) {
        Map<String, BiFunction<String, String, Car>> carTypeToConstructor = new HashMap<>();
        carTypeToConstructor.put("sadan", Sadan::new);
        carTypeToConstructor.put("suv", SUV::new);
        carTypeToConstructor.put("van", Ben::new);
        User user = new User(1 , "alice");
        BiFunction<Integer, String, User> userCreator = User::new;
        User charlie = userCreator.apply(3, "charlie");
        System.out.println(charlie);

        String[][] inputs = new String[][] {
                {"sadan", "Sonata", "Hyundai"},
                {"van", "Sienna", "Toyota"},
                {"sedan", "Model S", "Tesla"},
                {"suv", "Sorento", "KIA"}
        };
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < inputs.length; i++) {
            String[] input = inputs[i];
            String carType = input[0];
            String name = input[1];
            String brand = input[2];

            carList.add(carTypeToConstructor.get(carType).apply(name, brand));
        }
        for(Car car : carList) {
            car.drive();
        }
    }
}
