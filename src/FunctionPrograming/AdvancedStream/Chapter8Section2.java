package FunctionPrograming.AdvancedStream;

import FunctionPrograming.Optional.User;
import FunctionPrograming.Stream.Order;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Chapter8Section2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
        boolean allPostive = numbers.stream()
                .allMatch(number -> number > 0);
        System.out.println(allPostive);

        boolean anyNegative = numbers.stream()
                .anyMatch(number -> number < 0);
        System.out.println(anyNegative);

        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@fastcampus.co.kr");
        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@fastcampus.co.kr");
        List<User> users = Arrays.asList(user1, user2, user3);

        boolean allAllUserVerified = users.stream()
                .allMatch(User::isVerified);

        System.out.println(allAllUserVerified);

        Order order1 = new Order()
                .setId(1001L)
                .setAmount(BigDecimal.valueOf(2000))
                .setStatus(Order.OrderStatus.CREATED);
        Order order2 = new Order()
                .setId(1002L)
                .setAmount(BigDecimal.valueOf(4000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order3 = new Order()
                .setId(1003L)
                .setAmount(BigDecimal.valueOf(3000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order4 = new Order()
                .setId(1004L)
                .setAmount(BigDecimal.valueOf(7000))
                .setStatus(Order.OrderStatus.PROCESSED);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4);

        boolean allErrors = orders.stream()
                .allMatch(order -> order.getStatus() == Order.OrderStatus.ERROR);

        System.out.println(allErrors);
    }
}
