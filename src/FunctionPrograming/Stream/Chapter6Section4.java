package FunctionPrograming.Stream;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter6Section4 {
    // Stream의 구성요소
    // 1. Source : 컬렉션, 배열 등
    // 2. Intermediate Operations : 0개 이상의 filter, map 등의 중간처리
    // 3. Terminal Operation : Collect, reduce 등
    public static void main(String[] args) {
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
        List<String> emails = new ArrayList<>();
        for(User user : users) {
            if(user.isVerified()) {
                emails.add(user.getEmailAddress());
            }
        }
        List<String> emails2 = users.stream()
                .filter(user -> ! user.isVerified())
                .map(User::getEmailAddress)
                .collect(Collectors.toList());


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

        List<Long> userIds = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());

        List<Order> ordersInErrorStatus = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR )
                .filter(order -> order.getCreatedAt().isAfter(LocalDateTime.now().minusHours(24)))
                .collect(Collectors.toList());


    }
}
