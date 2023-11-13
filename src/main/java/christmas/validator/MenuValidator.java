package christmas.validator;

import static christmas.domain.menu.MenuItem.DELIMITER;
import static christmas.domain.menu.MenuItems.MIN_ORDER_COUNT;
import static christmas.util.StringConverter.delimiterStringToList;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuItem;
import christmas.exception.IllegalMenuException;
import java.util.List;
import java.util.regex.Pattern;

public class MenuValidator {
    public static final String ORDER_MENU_REGEX = "^[가-힣]+" + MenuItem.DELIMITER + "[1-9]\\d*$";

    public static void validateOrderMenu(final String orderMenu) {
        validateOrderMenuMatchedMenuOrderRegex(orderMenu);

        List<String> menu = delimiterStringToList(DELIMITER, orderMenu);

        validateMinOrderCount(menu);
        validateMatchMenuItem(menu);
    }

    public static void validateOrderMenuMatchedMenuOrderRegex(final String input) {
        if (!Pattern.matches(ORDER_MENU_REGEX, input)) {
            throw new IllegalMenuException();
        }
    }

    private static void validateMinOrderCount(final List<String> menu) {
        int menuCount = Integer.parseInt(menu.get(1));

        if (menuCount < MIN_ORDER_COUNT) {
            throw new IllegalMenuException();
        }
    }

    private static void validateMatchMenuItem(final List<String> menu) {
        String menuName = menu.get(0);

        if (!Menu.isMatchMenu(menuName)) {
            throw new IllegalMenuException();
        }
    }
}