package christmas.domain;

import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.MenuValidator.validateOrderMenu;

import java.util.List;

public class MenuItem {
    public static final String DELIMITER = "-";
    private final String menuName;
    private final int menuCount;

    private MenuItem(String orderMenu) {
        List<String> menu = delimiterStringToList(DELIMITER, orderMenu);
        validateOrderMenu(menu);

        String menuName = menu.get(0);
        int menuCount = Integer.parseInt(menu.get(1));

        this.menuName = menuName;
        this.menuCount = menuCount;
    }

    public static MenuItem from(final String orderMenu) {
        return new MenuItem(orderMenu);
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuCount() {
        return menuCount;
    }
}