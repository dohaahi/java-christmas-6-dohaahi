package christmas.validator;

import static christmas.domain.menu.MenuItems.DELIMITER;
import static christmas.domain.menu.MenuItems.MAX_ORDER_COUNT;
import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.MenuValidator.ORDER_MENU_REGEX;

import christmas.domain.menu.MenuCategory;
import christmas.domain.menu.MenuItem;
import christmas.exception.IllegalMenuException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class MenusValidator {
    public static void validateInputOrderMenus(final String input) {
        validateValueEmpty(input);

        try {
            List<String> orderMenus = delimiterStringToList(DELIMITER, input);
            orderMenus.forEach(MenusValidator::validateOrderMenuMatchedMenuOrderRegex);
        } catch (IllegalArgumentException exception) {
            throw new IllegalMenuException();
        }
    }

    public static void validateValueEmpty(final String input) {
        if (input.isEmpty()) {
            throw new IllegalMenuException();
        }
    }

    public static void validateOrderMenuMatchedMenuOrderRegex(final String input) {
        if (!Pattern.matches(ORDER_MENU_REGEX, input)) {
            throw new IllegalMenuException();
        }
    }

    public static void validateOrderMenus(final List<MenuItem> menuItems, final MenuCategory menuCategory) {
        validateDuplicateMenu(menuItems);
        validateSingleOrderExceptionCategory(menuItems, menuCategory);
        validateMaxOrderCount(menuItems);
    }

    private static void validateDuplicateMenu(final List<MenuItem> menuItems) {
        List<String> menuNames = new ArrayList<>();
        menuItems.forEach(menu -> menuNames.add(menu.getName()));

        long count = new HashSet<>(menuNames).size();

        if (count != menuNames.size()) {
            throw new IllegalMenuException();
        }
    }

    private static void validateSingleOrderExceptionCategory(final List<MenuItem> menuItems,
                                                             final MenuCategory menuCategory) {
        final List<MenuCategory> menuCategories = menuCategories(menuItems);

        if (isSingleOrderExceptionCategory(menuCategories, menuCategory)) {
            throw new IllegalMenuException();
        }
    }

    private static List<MenuCategory> menuCategories(final List<MenuItem> menuItems) {
        return menuItems.stream()
                .map(MenuItem::getCategory)
                .distinct()
                .toList();
    }

    private static boolean isSingleOrderExceptionCategory(final List<MenuCategory> menuCategories,
                                                          final MenuCategory menuCategory) {
        return menuCategories.size() == 1 && menuCategories.get(0).equals(menuCategory);
    }

    private static void validateMaxOrderCount(final List<MenuItem> menuItems) {
        int totalCount = menuItems.stream().mapToInt(MenuItem::getCount).sum();

        if (totalCount > MAX_ORDER_COUNT) {
            throw new IllegalMenuException();
        }
    }
}