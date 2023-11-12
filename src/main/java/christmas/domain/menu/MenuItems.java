package christmas.domain.menu;

import static christmas.validator.MenusValidator.validateOrderMenus;

import java.util.List;

public class MenuItems {
    public static final String DELIMITER = ", ";
    public static final int MIN_ORDER_COUNT = 1;
    public static final int MAX_ORDER_COUNT = 20;
    public static final MenuCategory SINGLE_ORDER_EXCEPTION_CATEGORY = MenuCategory.DRINK;

    private final List<MenuItem> menuItems;

    public MenuItems(final List<MenuItem> menuItems) {
        validateOrderMenus(menuItems, SINGLE_ORDER_EXCEPTION_CATEGORY);
        this.menuItems = menuItems;
    }

    public boolean isLessThan(final int price) {
        return totalPrice() < price;
    }

    private int totalPrice() {
        return menuItems.stream().mapToInt(menuItem -> menuItem.getCount() * menuItem.getPrice()).sum();
    }

    public List<MenuItem> getMenuItems() {
        return List.copyOf(menuItems);
    }
}