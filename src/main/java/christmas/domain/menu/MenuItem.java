package christmas.domain.menu;

import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.MenuValidator.validateOrderMenu;

import java.util.List;

public class MenuItem {
    public static final String DELIMITER = "-";
    private final Menu menu;
    private final int count;

    private MenuItem(final String orderMenu) {
        validateOrderMenu(orderMenu);
        final List<String> menu = delimiterStringToList(DELIMITER, orderMenu);

        final String name = menu.get(0);
        final int count = Integer.parseInt(menu.get(1));

        this.menu = Menu.from(name);
        this.count = count;
    }

    public static MenuItem from(final String orderMenu) {
        return new MenuItem(orderMenu);
    }

    public boolean isMatch(final MenuCategory menuCategory) {
        return menu.getCategory().equals(menuCategory);
    }

    public String getName() {
        return menu.getName();
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return menu.getPrice();
    }

    public MenuCategory getCategory() {
        return menu.getCategory();
    }
}