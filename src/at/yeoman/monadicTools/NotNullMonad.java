package at.yeoman.monadicTools;

public class NotNullMonad<E> {
    public static final NotNullMonad<?> NullInstance = createNullInstance();

    private final E value;

    public NotNullMonad(E value) {
        this.value = value;
    }

    public static <E> NotNullMonad<E> unit(E value) {
        if (value == null) {
            return nullInstance();
        }
        else {
            return new NotNullMonad<E>(value);
        }
    }

    public <R> NotNullMonad<R> bind(NotNullMonadFunction<E> function) {
        if (value == null) {
            return nullInstance();
        }
        else {
            // TODO test: this really shouldn't work, as "R" as the return type name could be a pure coincidence...
            return function.call(value);
        }
    }

    @SuppressWarnings("unchecked")
    private static <E> NotNullMonad<E> nullInstance() {
        return (NotNullMonad<E>) NullInstance;
    }

    private static NotNullMonad<?> createNullInstance() {
        return new NotNullMonad<>(null);
    }
}
