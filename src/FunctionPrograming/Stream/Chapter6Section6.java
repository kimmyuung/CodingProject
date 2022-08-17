package FunctionPrograming.Stream;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter6Section6 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -5, 4, -5, 2, 3);
        List<Integer> distictnumber = numbers.stream()
                .distinct() // 중복 숫자 제거
                .collect(Collectors.toList());
        Order order1 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedBuUserId(101)
                .setCreadtdAt(LocalDateTime.now().minusHours(4));

        Order order2 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedBuUserId(102)
                .setCreadtdAt(LocalDateTime.now().minusHours(10));

        Order order3 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedBuUserId(103)
                .setCreadtdAt(LocalDateTime.now().minusHours(36));

        Order order4 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedBuUserId(104)
                .setCreadtdAt(LocalDateTime.now().minusHours(15));

        Order order5 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedBuUserId(105)
                .setCreadtdAt(LocalDateTime.now().minusHours(10));


        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Long> userIds =orders.stream()
                .map(Order::getCreatedBuUserId)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

    }
}
