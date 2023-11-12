package christmas.domain;

import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.MenuValidator.validateOrderMenu;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuCategory;
import java.util.List;

public class MenuItem {
    public static final String DELIMITER = "-";
    private final Menu menu;
    private final int count;

    private MenuItem(String orderMenu) {
        List<String> menu = delimiterStringToList(DELIMITER, orderMenu);
        validateOrderMenu(menu);

        String name = menu.get(0);
        int count = Integer.parseInt(menu.get(1));

        this.menu = Menu.from(name);
        this.count = count;
    }

    public static MenuItem from(final String orderMenu) {
        return new MenuItem(orderMenu);
    }

    public String getName() {
        return menu.name();
    }

    public MenuCategory getCategory() {
        return menu.getCategory();
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return menu.getPrice();
    }
}