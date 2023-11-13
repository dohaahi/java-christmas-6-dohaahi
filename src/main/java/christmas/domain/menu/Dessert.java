package christmas.domain.menu;

import java.util.List;

public class Dessert {
    private final List<Menu> menuItems;

    public Dessert(final List<Menu> menuItems) {
        final List<Menu> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equals(MenuCategory.DESSERT))
                .toList();

        this.menuItems = menus;
    }
}