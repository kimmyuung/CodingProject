package FunctionPrograming.AdvancedStream;

import java.util.Optional;
import java.util.stream.Stream;

public class Chapter8Section3 {
    // findFirst : Stream 안의 첫번째 데이터를 반환, Stream이 비어있다면 비어있는 Optional 반환
    // findAny : Stream 안의 아무 데이터나 리턴
    public static void main(String[] args) {
        Optional<Integer> anynegative = Stream.of(3, -2, -5, 6)
                .filter(x ->x < 0)
                .findAny();

        Optional<Integer> firstPositive = Stream.of(3, -2, -5, 6)
                .filter(x -> x > 0)
                .findFirst();

    }
}
