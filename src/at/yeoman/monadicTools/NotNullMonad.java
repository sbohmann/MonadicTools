package at.yeoman.monadicTools;

public class NotNullMonad<E> {
    private static final NotNullMonad<?> NullInstance = createNullInstance();

    private final E value;

    private NotNullMonad(E value) {
        this.value = value;
    }

    public static <E> NotNullMonad<E> unit(E value) {
        if (value == null) {
            return nullInstance();
        } else {
            return new NotNullMonad<E>(value);
        }
    }

    public <R> NotNullMonad<R> bind(NotNullMonadFunction<E,R> function) {
        if (value == null) {
            return nullInstance();
        } else {
            return function.call(value);
        }
    }

    public E get() {
        return value;
    }

    @SuppressWarnings("unchecked")
    private static <E> NotNullMonad<E> nullInstance() {
        return (NotNullMonad<E>) NullInstance;
    }

    private static NotNullMonad<?> createNullInstance() {
        return new NotNullMonad<>(null);
    }
}
