import java.util.concurrent.atomic.AtomicInteger;

public class ValueStorage {
    private static AtomicInteger value = new AtomicInteger();

    public static void IncrementValue(){
        value.incrementAndGet();
        //value.addAndGet(2);
    }

    public static int getValue() {
        return value.intValue();
    }
}
