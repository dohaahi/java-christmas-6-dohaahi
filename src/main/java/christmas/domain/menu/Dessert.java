package christmas.domain.menu;

import java.util.List;

public class Dessert {
    private final List<MenuItem> menuItems;

    public Dessert(List<MenuItem> menuItems) {
        List<MenuItem> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equals(MenuCategory.DESSERT))
                .toList();

        this.menuItems = menus;
    }
}