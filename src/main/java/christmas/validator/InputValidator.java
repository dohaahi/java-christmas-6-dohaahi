package christmas.validator;

import christmas.domain.Menu;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    public static final String NUMBER_REGEX = "^[\\d]*$";
    public static final String ORDER_MENU_REGEX = "^[가-힣]+" + Menu.DELIMITER + "[\\d]*$";

    public static void validateValueEmpty(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_VALUE_MASSAGE.getMessage());
        }
    }

    public static void validateValueEmpty(final List<String> input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_VALUE_MASSAGE.getMessage());
        }
    }

    public static void validateDateMatchedNumberRegex(final String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER_MESSAGE.getMessage());
        }
    }

    public static void validateOrderMenuMatchedMenuOrderRegex(final String input) {
        if (!Pattern.matches(ORDER_MENU_REGEX, input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }
    }
}
