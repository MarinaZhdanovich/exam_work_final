public class Counter implements AutoCloseable{
    private int value;

    public void add() {
        value++;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void close() {
        if (value > 0) {
            throw new IllegalStateException("Ресурс не был закрыт");
        }
    }
}

