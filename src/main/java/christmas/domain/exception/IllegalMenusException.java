package christmas.domain.exception;

public class IllegalMenusException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public IllegalMenusException() {
        super(EXCEPTION_MESSAGE);
    }
}
