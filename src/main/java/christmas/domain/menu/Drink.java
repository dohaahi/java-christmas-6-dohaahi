package christmas.domain.menu;

import java.util.List;

public class Drink {
    private final List<Menu> menuItems;

    public Drink(final List<Menu> menuItems) {
        final List<Menu> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equals(MenuCategory.DRINK))
                .toList();

        this.menuItems = menus;
    }
}