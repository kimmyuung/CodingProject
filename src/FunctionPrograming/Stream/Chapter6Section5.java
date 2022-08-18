package FunctionPrograming.Stream;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter6Section5 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -5, 7, 4);
        List<Integer> sortednumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

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
        List<User> sortedUsers = users.stream()
                .sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .collect(Collectors.toList());
        System.out.println(sortedUsers);


        Order order1 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101)
                .setCreatedAt(LocalDateTime.now().minusHours(4));

        Order order2 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(102)
                .setCreatedAt(LocalDateTime.now().minusHours(10));

        Order order3 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(103)
                .setCreatedAt(LocalDateTime.now().minusHours(36));

        Order order4 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(104)
                .setCreatedAt(LocalDateTime.now().minusHours(15));

        Order order5 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(105)
                .setCreatedAt(LocalDateTime.now().minusHours(10));


        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

        List<Order> sortedOrders = orders.stream().sorted((o1, o2) -> o1.getCreatedAt().compareTo(o2.getCreatedAt()))
                .collect(Collectors.toList());
        System.out.println(sortedOrders);

    }
}
