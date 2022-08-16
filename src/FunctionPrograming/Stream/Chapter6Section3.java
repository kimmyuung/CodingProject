package FunctionPrograming.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter6Section3
{
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(3, 6, -4);
        List<Integer>  numberStream = numberList.stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
        Stream<Integer> numberListStream = numberList.stream();

        Stream<String> strStrem = numberListStream.map(x -> "Number is " + x);
        List<String> strList = strStrem.collect(Collectors.toList());


    }
}
