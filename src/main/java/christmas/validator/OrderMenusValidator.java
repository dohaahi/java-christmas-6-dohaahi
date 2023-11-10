package christmas.validator;

import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.InputValidator.validateOrderMenuMatchedMenuOrderRegex;
import static christmas.validator.InputValidator.validateValueEmpty;

import christmas.domain.OrderMenus;
import java.util.List;

public class OrderMenusValidator {
    public static void validateInputOrderMenus(final String input) {
        validateValueEmpty(input);
        List<String> orderMenus = delimiterStringToList(OrderMenus.DELIMITER, input);

        if (orderMenus.size() == 1) {
            validateOrderMenuMatchedMenuOrderRegex(input);
            return;
        }

        orderMenus.forEach(InputValidator::validateOrderMenuMatchedMenuOrderRegex);
    }
}