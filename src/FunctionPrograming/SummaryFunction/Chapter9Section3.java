package FunctionPrograming.SummaryFunction;


import FunctionPrograming.Stream.Order;
import FunctionPrograming.Stream.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Chapter9Section3 {
    // Function Composition
    // 함수 합성
    // 여러 개의 함수를 합쳐 하나의 새로운 함수로 만드는 것
    public static void main(String[] args) {
        Function<Integer, Integer> multiplyByTwo = x -> 2 * x;
        Function<Integer, Integer> addTen = x -> x + 10;

        Function<Integer, Integer> composedFunction =
                multiplyByTwo.andThen(addTen);

        System.out.println(composedFunction.apply(3));

        Order uncomposedOrder = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))
                ));
        List<Function<Order, Order>> priceProcessors = getPriceProcessors(uncomposedOrder);

        Function<Order,Order> mergedPriceProcessors = priceProcessors.stream()
                .reduce(Function.identity(), Function::andThen);

        Order ProcessedOrder = mergedPriceProcessors.apply(uncomposedOrder);

    }
    public static List<Function<Order, Order>> getPriceProcessors(Order order) {
        return Arrays.asList(new PriceProcessor(),
                new TaxPriceProcessor(new BigDecimal("9.375")));
    }
}
