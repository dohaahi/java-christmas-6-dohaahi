package christmas.validator;

import static christmas.validator.InputValidator.validateDateMatchedNumberRegex;
import static christmas.validator.InputValidator.validateValueEmpty;

public class DateValidator {
    public static void validateInputDate(final String input) {
        validateValueEmpty(input);
        validateDateMatchedNumberRegex(input);
    }
}