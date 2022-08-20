package FunctionPrograming.AdvancedStream;

import FunctionPrograming.Optional.User;
import FunctionPrograming.Stream.Order;
import FunctionPrograming.Stream.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Chapter8Section4 {
    // Reduce : 주어진 함수를 반복 적용해 Stream 안의 데이터를 하나의 값으로 합치는 자업

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);
        int sum = numbers.stream()
                .reduce((x, y) -> x + y)
                .get();

        int min = numbers.stream()
                .reduce((x, y) -> x > y ? x : y)
                .get();

        int product = numbers.stream()
                .reduce(1, (x, y) -> x * y);
        System.out.println(product);

        List<String> numbersStrList = Arrays.asList("3", "2", "5", "-4");

        int sumOfnumber = numbersStrList.stream()
                .map(Integer::parseInt)
                .reduce(0 , (x,y) -> x + y);
        System.out.println(numbersStrList);

        int sumOfnumberStrList2 = numbersStrList.stream()
                .reduce(0, (number, str)
                        -> number + Integer.parseInt(str),
                        (num1, num2) -> num1 + num2);
        System.out.println(sumOfnumberStrList2);

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

        int sumOfNumbersfriends = users.stream()
                .map(User::getFriendUserIds)
                .map(List::size)
                .reduce(0, (x , y) -> x + y);

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

        BigDecimal sumofOrderLine = orders.stream()
                .map(Order::getOrderLines)
                .flatMap(List::stream)
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(sumofOrderLine);


    }
}
