package christmas.domain.menu;

import java.util.List;

public class Drink {
    private final List<MenuItem> menuItems;

    public Drink(List<MenuItem> menuItems) {
        List<MenuItem> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equals(MenuCategory.DRINK))
                .toList();

        this.menuItems = menus;
    }
}