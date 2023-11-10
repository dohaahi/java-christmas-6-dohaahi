package christmas.validator;

import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.InputValidator.validateOrderMenuMatchedMenuOrderRegex;
import static christmas.validator.InputValidator.validateValueEmpty;

import christmas.domain.menu.MenuCategory;
import christmas.domain.menu.MenuItem;
import christmas.domain.Menu;
import christmas.domain.Menus;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderMenusValidator {
    public static void validateInputOrderMenus(final String input) {
        validateValueEmpty(input);
        List<String> orderMenus = delimiterStringToList(Menus.DELIMITER, input);

        if (orderMenus.size() == 1) {
            validateOrderMenuMatchedMenuOrderRegex(input);
            return;
        }

        orderMenus.forEach(InputValidator::validateOrderMenuMatchedMenuOrderRegex);
    }

    public static void validateOrderMenus(final List<Menu> menus) {
        validateMatchMenuItem(menus);
        validateDuplicateMenu(menus);
        isDrinkOnly(menus);
        validateMenuCount(menus);
    }

    private static void validateMatchMenuItem(final List<Menu> menus) {
        menus.forEach(menu -> {
            if (!MenuItem.isMatchMenu(menu)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
            }
        });
    }

    private static void validateDuplicateMenu(final List<Menu> menus) {
        List<String> menuNames = new ArrayList<>();
        menus.forEach(menu -> menuNames.add(menu.getMenuName()));

        long count = new HashSet<>(menuNames).size();

        if (count != menuNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }
    }

    private static void isDrinkOnly(final List<Menu> menus) {
        Set<String> menuCategory = new HashSet<>();

        menus.forEach(menu -> menuCategory.add(menu.getMenuName()));

        if (menuCategory.size() == 1 && menuCategory.contains(MenuCategory.DRINK.getCategoryName())) {
            throw new IllegalArgumentException(ErrorMessage.DO_NOT_JUST_ORDER_DRINK_MESSAGE.getMessage());
        }
    }

    private static void validateMenuCount(final List<Menu> menus) {
        if (menus.size() > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_COUNT_MESSAGE.getMessage());
        }
    }
}