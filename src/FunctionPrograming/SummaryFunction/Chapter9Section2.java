package FunctionPrograming.SummaryFunction;

import FunctionPrograming.FunctionalInterFace.Supplier;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter9Section2 {
    // Lazy Evaluation
    // Lambda의 계산은 그 결과값이 필요할 때가 되어서야 계산
    // 불필요한 계산 줄이거나 해당 코드의 실행 순서를 미룰 수 있음
    public static void main(String[] args) {
        if (returnTrue() || returnFalse()) {
        //    System.out.println("true");
        } // 앞의 조건 중 하나라도 일치한다면 뒤의 것은 실행되지 않음

        if(or(returnTrue(), returnFalse())) { // 둘다 계산후에 실행
            System.out.println("true");
        }

        if(lazyor(() -> returnTrue(), () -> returnFalse())) {
            // return false 실행 안됨
            System.out.println("true");
        }
        Stream<Integer> integerStream = Stream.of(3, -2, 5, 8, -3, 10)
                .filter(x -> x > 0)
                .peek(x -> System.out.println("Peeking " + x)) // 2번 실행
                .filter(x -> x % 2 == 0);
        System.out.println("Before Collect"); // 1번 실행

        List<Integer> integers =integerStream.collect(Collectors.toList());
        System.out.println("After Collect"); // 3번 실행

    }

    public static boolean lazyor(Supplier<Boolean> x, Supplier<Boolean> y) {
        return x.get() || y.get();
    }
    public static boolean or(boolean x, boolean y) {
        return x || y;
    }

    public static boolean returnTrue() {
        System.out.println("Returning true");
        return true;
    }
    public static boolean returnFalse() {
        System.out.println("Returning false");
        return false;
    }
}
