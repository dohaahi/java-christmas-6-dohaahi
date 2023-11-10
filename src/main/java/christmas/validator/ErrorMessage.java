package christmas.validator;

public enum ErrorMessage {
    ENTER_VALUE_MASSAGE("값을 입력해주세요."),
    INVALID_INPUT_NUMBER_MESSAGE("숫자를 입력해주세요."),
    INVALID_INPUT_DATE_MESSAGE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_INPUT_ORDER_MENU_MESSAGE("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    DO_NOT_JUST_ORDER_DRINK_MESSAGE("음료만 주문은 불가합니다. 다시 입력해 주세요."),
    INVALID_INPUT_ORDER_MENU_COUNT_MESSAGE("최대로 주문 가능한 메뉴는 20개 입니다. 다시 입력해 주세요.");

    private final String errorFormat = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return errorFormat + message;
    }
}
