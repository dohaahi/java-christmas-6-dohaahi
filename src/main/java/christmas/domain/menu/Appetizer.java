package christmas.domain.menu;

import java.util.List;

public class Appetizer {
    private final List<MenuItems> menuItems;

    public Appetizer(List<MenuItems> menuItems) {
        List<MenuItems> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equals(MenuCategory.APPETIZER))
                .toList();

        this.menuItems = menus;
    }
}