package christmas.domain.menu;

import java.util.List;

public class Drink {
    private final List<MenuItems> menuItems;

    public Drink(List<MenuItems> menuItems) {
        List<MenuItems> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equals(MenuCategory.DRINK))
                .toList();

        this.menuItems = menus;
    }
}