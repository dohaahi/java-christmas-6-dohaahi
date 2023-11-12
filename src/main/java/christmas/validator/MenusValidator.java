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
            throw new IllegalMenusException();
        }
    }

    private static void validateSingleOrderExceptionCategory(final List<MenuItem> menuItems,
                                                             final MenuCategory menuCategory) {
        final List<MenuCategory> menuCategories = menuCategories(menuItems);

        if (isSingleOrderExceptionCategory(menuCategories, menuCategory)) {
            throw new IllegalMenusException();
        }
    }

    private static List<MenuCategory> menuCategories(final List<MenuItem> menuItems) {
        return menuItems.stream()
                .map(menu -> Menu.getMenuItem(menu).getCategory())
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
            throw new IllegalMenusException();
        }
    }
}