package FunctionPrograming.LambdaExpression;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
                        // 제네릭 타입
        R apply(T t, U u, V v);
}
