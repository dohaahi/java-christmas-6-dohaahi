package christmas.domain.menu;

import java.util.List;

public class Appetizer {
    private final List<Menu> menuItems;

    public Appetizer(List<Menu> menuItems) {
        List<Menu> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equals(MenuCategory.APPETIZER))
                .toList();

        this.menuItems = menus;
    }
}