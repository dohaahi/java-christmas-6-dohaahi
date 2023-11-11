package christmas.domain.menu;

import java.util.List;

public class Main {
    private final List<MenuItems> menuItems;

    public Main(List<MenuItems> menuItems) {
        List<MenuItems> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equals(MenuCategory.MAIN))
                .toList();

        this.menuItems = menus;
    }
}