package at.yeoman.monadicTools;

public interface NotNullMonadFunction<T,R> {
    public NotNullMonad<R> call(T value);
}
