package christmas.domain.menu;

import java.util.List;

public class Appetizer {
    private final List<MenuItem> menuItems;

    public Appetizer(List<MenuItem> menuItems) {
        List<MenuItem> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equals(MenuCategory.APPETIZER))
                .toList();

        this.menuItems = menus;
    }
}