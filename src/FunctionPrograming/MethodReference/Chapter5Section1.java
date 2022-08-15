package FunctionPrograming.MethodReference;

import FunctionPrograming.FunctionalInterFace.Predicate;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Chapter5Section1 {
    public static int calucalate(int x, int y, BiFunction<Integer, Integer, Integer> operator)
    {
        return operator.apply(x, y);
    }
    public static int multiply(int x, int y) {
        return x * y;
    }
    public int substract(int x, int y) {
        return x - y;
    }
    public void mymethod() {
        System.out.println(calucalate(10, 3, this::substract));
    }
    public static void main(String[] args) {
        int a = Integer.parseInt("15");
        Function<String, Integer> str2int = Integer::parseInt;

        System.out.println(str2int.apply("20"));

        String str = "hello";
        boolean b = str.equals("world");
        Predicate<String> equalToHello = str::equals;

        System.out.println(calucalate(8, 2, (x, y) -> x + y));
        System.out.println(calucalate(8, 2, Chapter5Section1::multiply));
        Chapter5Section1 instance = new Chapter5Section1();
        System.out.println(calucalate(8, 2, instance::substract));
        instance.mymethod();
    }

}
