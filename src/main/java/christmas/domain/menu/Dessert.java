package christmas.domain.menu;

import java.util.List;

public class Dessert {
    private final List<MenuItems> menuItems;

    public Dessert(List<MenuItems> menuItems) {
        List<MenuItems> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equals(MenuCategory.DESSERT))
                .toList();

        this.menuItems = menus;
    }
}