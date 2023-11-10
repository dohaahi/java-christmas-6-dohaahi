package christmas.domain.menu;

import java.util.List;

public class Main {
    private final List<MenuItem> menuItems;

    public Main(List<MenuItem> menuItems) {
        List<MenuItem> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equals(MenuCategory.MAIN))
                .toList();

        this.menuItems = menus;
    }
}