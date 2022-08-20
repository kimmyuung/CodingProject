package FunctionPrograming.SummaryFunction;

import FunctionPrograming.FunctionalInterFace.Supplier;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Chapter9Section1 {
    // Scope : 변수에 접근할 수 있는 범위
    // 함수 안에 함수가 있을 때 내부 함수에서 외부 함수에 있는 변수에 접근이 가능하지만 그 반대는 불가능
    // Closure : 내부 함수가 존재하는 한 내부 함수가 사용한 외부 함수의 변수들 역시 계속 존재
    // 이 때 내부 함수가 사용한 외부 함수의 변수들은 내부 함수 선언 당시로부터 변할 수 없음
    // Curry : 여러 개의 매개변수를 받는 함수를 중첩된 여러 개의 함수로 쪼개어
    // 매개 변수를 한 번에 받지 않고 여러 단계에 걸쳐 나눠 받을 수 있게 하는 기술

    public static void main(String[] args) {
        Supplier<String> supplier = getStringSuppiler();
        System.out.println(supplier.get());

        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        Function<Integer, Function<Integer, Integer>> curriedadd = x -> y -> x + y;

        Function<Integer, Integer> addThree = curriedadd.apply(3);
        // 3은 final로 저장됨

        int result = addThree.apply(10);

        System.out.println(result);
        // 함수에 저장된 3 + result에 저장된 10을 더한 값 출력
    }
    public static Supplier<String> getStringSuppiler() {
        String hello = "hello";
        Supplier<String> supplier = () ->
        {
            String world = "world";
            return hello + world;
        };
        return supplier;
    }
}
