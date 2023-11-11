package christmas.validator;

import static christmas.domain.MenuItems.MAX_ORDER_COUNT;
import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.InputValidator.validateOrderMenuMatchedMenuOrderRegex;
import static christmas.validator.InputValidator.validateValueEmpty;

import christmas.domain.MenuItem;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuCategory;
import christmas.exception.IllegalMenusException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MenusValidator {
    public static void validateInputOrderMenus(final String input) {
        validateValueEmpty(input);
        List<String> orderMenus = delimiterStringToList(christmas.domain.MenuItems.DELIMITER, input);

        if (orderMenus.size() == 1) {
            validateOrderMenuMatchedMenuOrderRegex(input);
            return;
        }

        orderMenus.forEach(InputValidator::validateOrderMenuMatchedMenuOrderRegex);
    }

    public static void validateOrderMenus(final List<MenuItem> menuItems) {
        validateDuplicateMenu(menuItems);
        validateDrinkOnly(menuItems);
        validateMaxOrderCount(menuItems);
    }

    private static void validateDuplicateMenu(final List<MenuItem> menuItems) {
        List<String> menuNames = new ArrayList<>();
        menuItems.forEach(menu -> menuNames.add(menu.getName()));

        long count = new HashSet<>(menuNames).size();

        if (count != menuNames.size()) {
            throw new IllegalMenusException();
        }
    }

    private static void validateDrinkOnly(final List<MenuItem> menuItems) {
        List<MenuCategory> menuCategories = menuItems.stream()
                .map(menu -> Menu.getMenuItem(menu).getCategory())
                .toList();

        boolean isDrinkOnly = menuCategories.stream()
                .filter(MenuCategory.DRINK::equals)
                .count() == menuItems.size();

        if (isDrinkOnly) {
            throw new IllegalMenusException();
        }
    }

    private static void validateMaxOrderCount(final List<MenuItem> menuItems) {
        int totalCount = menuItems.stream()
                .mapToInt(MenuItem::getCount)
                .sum();

        if (totalCount > MAX_ORDER_COUNT) {
            throw new IllegalMenusException();
        }
    }
}