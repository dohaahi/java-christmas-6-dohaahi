package christmas.validator;

import static christmas.domain.util.StringConvertor.delimiterStringToList;
import static christmas.validator.InputValidator.validateOrderMenuMatchedMenuOrderRegex;
import static christmas.validator.InputValidator.validateValueEmpty;

import christmas.domain.OrderMenus;
import java.util.List;

public class OrderMenuValidator {
    public static void validateInputOrderMenu(final String input) {
        validateValueEmpty(input);
        List<String> orderMenus = delimiterStringToList(OrderMenus.DELIMITER, input);

        if (orderMenus.size() == 1) {
            validateOrderMenuMatchedMenuOrderRegex(input);
            return;
        }

        orderMenus.forEach(InputValidator::validateOrderMenuMatchedMenuOrderRegex);
    }
}