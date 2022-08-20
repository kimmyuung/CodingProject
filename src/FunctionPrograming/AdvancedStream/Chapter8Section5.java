package FunctionPrograming.AdvancedStream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter8Section5 {
    public static void main(String[] args) {
        List<Integer> numberList = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.toList());

        Set<Integer> numberSet = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.toSet());

        List<Integer> numberList2 = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toList()));
        // 절댓값 출력
        Set<Integer> numberSet2 = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toSet()));

        int sum = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.reducing(0, (x, y) -> x + y));


    }
}
