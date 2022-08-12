package FunctionPrograming.LambdaExpression;

import java.util.function.Function;

public class LambdaExpression {

    public static void main(String[] args) {

        Function<Integer, Integer> myadder  // 람다 식을 포함한 변수를 저장
                =  x  ->  x + 10;  // 생략가능
                // = (Integer x) -> { return x + 10; };
        // 인수가 하나인 경우 () 생략 가능, 변수 타입 유추 가능한 경우 타입 생략 가능
        // 리턴 값이 하나인 경우 중괄호 생략 가능

        int result = myadder.apply(5);
        System.out.println(result);

        // 함수의 구성 요소
        // 1. 함수의 이름
        // 2. 반환값의 타입
        // 3. 매개변수
        // 4. 함수의 내용

        // LambdaExpression : 이름이 없는 함수

        // @Functional Interface : 함수의 뼈대
        // : 단 하나의 abstract method만을 가지는 인터페이스
        // Default method와 static method는 이미 구현이 되어있으므로 있어도 괜찮음

        TriFunction<Integer, Integer, Integer, Integer>
                addThreeNumbers = (x,  y,  z) ->  x + y + z;

        addThreeNumbers.apply(3, 2, 5);

    }
}
