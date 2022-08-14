package FunctionPrograming.FunctionalInterFace;

@FunctionalInterface
public interface Supplier<T> { // 데이터를 입력하는 것만 가능
    T get();
}
