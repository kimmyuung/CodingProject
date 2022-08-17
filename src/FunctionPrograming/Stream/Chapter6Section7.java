package FunctionPrograming.Stream;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter6Section7 {

    //FlatMap : Map + Flatten
    // 데이터에 함수를 적용한 후 중첩된 stream을 연결하여 하나의 stream으로 리턴
    public static void main(String[] args) {
        String[][] cities = new String[][]{
                {"Seoul", "Busan"},
                {"San Franisco", "New York"},
                {"Madrid", "Barcelona"},
        };
        Stream<String[]> citystream = Arrays.stream(cities);
        Stream<Stream<String>> citystreamstream = citystream.map(x -> Arrays.stream(x));
        List<Stream<String>>  citystreamlist = citystreamstream.collect(Collectors.toList());

        Stream<String[]> citystream2 = Arrays.stream(cities);
        Stream<String> flatmapcitystream = citystream2.flatMap(x -> Arrays.stream(x));
        List<String> flatcitylist = flatmapcitystream.collect(Collectors.toList());
        System.out.println(flatcitylist);

        Order order1 = new Order()
                .setId(101)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedBuUserId(101)
                .setCreadtdAt(LocalDateTime.now().minusHours(4))
                .setOrderLine(Arrays.asList(new Order(
                        .setId(1001)
                        .setStatus(Order.OrderStatus.IN_PROGRESS)
                        .setCreatedBuUserId(101) ) ) ;


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



        List<Order> orders = Arrays.asList(order1, order2, order3);

    }
}
