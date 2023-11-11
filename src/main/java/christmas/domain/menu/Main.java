package christmas.domain.menu;

import java.util.List;

public class Main {
    private final List<Menu> menuItems;

    public Main(List<Menu> menuItems) {
        List<Menu> menus = menuItems.stream()
                .filter(menuItem -> menuItem.getCategory().equals(MenuCategory.MAIN))
                .toList();

        this.menuItems = menus;
    }
}