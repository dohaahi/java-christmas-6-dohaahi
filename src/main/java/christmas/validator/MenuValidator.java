package christmas.validator;

import static christmas.domain.Menus.MIN_ORDER_COUNT;

import christmas.domain.menu.MenuItem;
import java.util.List;

public class MenuValidator {
    public static void validateOrderMenu(final List<String> menu) {
        validateMinOrderCount(menu);
        validateMatchMenuItem(menu);
    }

    private static void validateMinOrderCount(final List<String> menu) {
        int menuCount = Integer.parseInt(menu.get(1));

        if (menuCount < MIN_ORDER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }
    }

    private static void validateMatchMenuItem(final List<String> menu) {
        String menuName = menu.get(0);

        if (!MenuItem.isMatchMenu(menuName)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }
    }
}
