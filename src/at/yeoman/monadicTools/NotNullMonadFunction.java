package at.yeoman.monadicTools;

public interface NotNullMonadFunction<T> {
    public <R> NotNullMonad<R> call(T value);
}
