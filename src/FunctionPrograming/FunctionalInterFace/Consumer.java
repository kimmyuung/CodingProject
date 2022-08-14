package FunctionPrograming.FunctionalInterFace;

@FunctionalInterface
public interface Consumer<T> { // 데이터를 받아들이는 것만 가능
    void accept(T t);
}
