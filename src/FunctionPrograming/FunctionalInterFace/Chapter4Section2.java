package FunctionPrograming.FunctionalInterFace;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Chapter4Section2 {
    public static void main(String[] args) {
        Consumer<String> myStringConsumer = (str) -> System.out.println(str);

        myStringConsumer.accept("hello");
        List<Integer> integers = Arrays.asList(4, 2, 3);
        // 숫자가 담긴 리스트를 만들어줌 -> 변형 불가능
        Consumer<Integer> myIntegerProcessor = (Integer x) ->
                System.out.println("Processing integer" + x);
        process(integers, myIntegerProcessor);
        Consumer<Integer> myDifferentIntegerProcessor = x ->
                System.out.println("Processing integer in different way" + x);
        process(integers, myDifferentIntegerProcessor);

        Consumer<Double> myDoubleProcessor = x ->
                System.out.println("Processing double" + x);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        process(doubleList, myDoubleProcessor);

    }
    public static <T> void process(List<T> inputs, Consumer<T> processor) {
        for(T input : inputs) {
            processor.accept(input);
        }

    }
}
