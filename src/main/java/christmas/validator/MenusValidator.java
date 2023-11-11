package christmas.validator;

import static christmas.domain.Menus.MAX_ORDER_COUNT;
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

public class MenusValidator {
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
        validateDuplicateMenu(menus);
        validateDrinkOnly(menus);
        validateMaxOrderCount(menus);
    }

    private static void validateDuplicateMenu(final List<Menu> menus) {
        List<String> menuNames = new ArrayList<>();
        menus.forEach(menu -> menuNames.add(menu.getMenuName()));

        long count = new HashSet<>(menuNames).size();

        if (count != menuNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }
    }

    private static void validateDrinkOnly(final List<Menu> menus) {
        List<MenuCategory> menuCategories = menus.stream()
                .map(menu -> MenuItem.getMenuItem(menu).getCategory())
                .toList();

        boolean isDrinkOnly = menuCategories.stream()
                .filter(MenuCategory.DRINK::equals)
                .count() == menus.size();

        if (isDrinkOnly) {
            throw new IllegalArgumentException(ErrorMessage.DO_NOT_JUST_ORDER_DRINK_MESSAGE.getMessage());
        }
    }

    private static void validateMaxOrderCount(final List<Menu> menus) {
        int totalCount = menus.stream()
                .mapToInt(Menu::getMenuCount)
                .sum();

        if (totalCount > MAX_ORDER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_COUNT_MESSAGE.getMessage());
        }
    }
}