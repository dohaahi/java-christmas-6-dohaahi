package christmas.domain;

import java.util.List;

public class Main {
    private final List<MenuItem> menuItems;

    public Main(List<MenuItem> menuItems) {
        List<MenuItem> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategoryName().equals(MenuCategory.MAIN))
                .toList();

        this.menuItems = menus;
    }
}