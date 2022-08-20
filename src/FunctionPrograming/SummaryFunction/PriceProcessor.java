package FunctionPrograming.SummaryFunction;

import FunctionPrograming.Stream.Order;
import FunctionPrograming.Stream.OrderLine;

import java.math.BigDecimal;
import java.util.function.Function;

public class PriceProcessor implements Function<Order, Order> {

    @Override
    public Order apply(Order order) {
        return order.setAmount(order.getOrderLines().stream()
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }
}
