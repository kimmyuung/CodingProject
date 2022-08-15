package FunctionPrograming.Stream;

import FunctionPrograming.Stream.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Chapter6Section2 {
    public static void main(String[] args) {
        Stream<Integer> numberStream = Stream.of(3, -5, 7, 10, -3);
        Stream<Integer> filternumberStream = numberStream.filter(x -> x > 0);
        List<Integer> filternumbers = filternumberStream.collect(Collectors.toList());
        System.out.println(filternumbers);

        List<Integer> newFilterStream = Stream.of(3, -5, 7, 10, -3)
                .filter(x ->x > 0)
                .collect(Collectors.toList());
        System.out.println(newFilterStream);

        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@naver.com");

        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("Bob@naver.com");

        User user3 = new User()
                .setId(101)
                .setName("Charile")
                .setVerified(false)
                .setEmailAddress("Charile@naver.com");

        List<User> users = Arrays.asList(user1, user2, user3);
        List<User> verifiedusers = users.stream()
                .filter(user -> user.isVerified())
                .collect(Collectors.toList());
        System.out.println(verifiedusers);


        List<User> unverifiedusers = users.stream()
                .filter(user -> !user.isVerified())
                .collect(Collectors.toList());
        System.out.println(unverifiedusers);

        Order order1 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.CREATED);

        Order order2 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.ERROR);

        Order order3 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.PROCESSED);

        Order order4 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.IN_PROGRESS);

        Order order5 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.ERROR);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

        List<Order> Errororder = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .collect(Collectors.toList());
        System.out.println(Errororder);

    }
}
