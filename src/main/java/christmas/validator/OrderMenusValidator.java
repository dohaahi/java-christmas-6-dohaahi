package christmas.validator;

import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.InputValidator.validateOrderMenuMatchedMenuOrderRegex;
import static christmas.validator.InputValidator.validateValueEmpty;

import christmas.domain.MenuItem;
import christmas.domain.OrderMenu;
import christmas.domain.OrderMenus;
import java.util.ArrayList;
import java.util.HashSet;
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

    public static void validateOrderMenus(final List<OrderMenu> menus) {
        validateMatchMenuItem(menus);
        validateDuplicateMenu(menus);
        validateMenuCount(menus);
    }

    private static void validateMatchMenuItem(final List<OrderMenu> menus) {
        menus.forEach(menu -> {
            if (!MenuItem.isMatchMenu(menu)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
            }
        });
    }

    private static void validateDuplicateMenu(final List<OrderMenu> menus) {
        List<String> menuNames = new ArrayList<>();
        menus.forEach(menu -> menuNames.add(menu.getMenuName()));

        long count = new HashSet<>(menuNames).size();

        if (count != menuNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }
    }

    private static void validateMenuCount(final List<OrderMenu> menus) {
        if (menus.size() > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_COUNT_MESSAGE.getMessage());
        }
    }
}