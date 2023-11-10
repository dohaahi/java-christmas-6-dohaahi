package christmas.domain.menu;

import christmas.domain.menu.MenuCategory;
import christmas.domain.menu.MenuItem;
import java.util.List;

public class Drink {
    private final List<MenuItem> menuItems;

    public Drink(List<MenuItem> menuItems) {
        List<MenuItem> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategoryName().equals(MenuCategory.DRINK))
                .toList();

        this.menuItems = menus;
    }
}