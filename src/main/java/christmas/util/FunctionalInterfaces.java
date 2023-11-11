package christmas.util;

import java.util.function.Supplier;

public class FunctionalInterfaces {
    public static <T> T retryIfFailure(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}