package christmas.domain;

import static christmas.validator.MenusValidator.validateOrderMenus;

import java.util.List;

public class MenuItems {
    public static final String DELIMITER = ", ";
    public static final int MIN_ORDER_COUNT = 1;
    public static final int MAX_ORDER_COUNT = 20;

    private final List<MenuItem> menuItems;

    public MenuItems(final List<MenuItem> menuItems) {
        validateOrderMenus(menuItems);
        this.menuItems = menuItems;
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        menuItems.stream()
                .mapToInt(menuItem -> menuItem.getCount() * menuItem.getPrice())
                .sum();

        return totalPrice;
    }

    public List<MenuItem> getMenuItems() {
        return List.copyOf(menuItems);
    }
}