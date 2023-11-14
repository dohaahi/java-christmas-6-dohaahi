package christmas.mapper;

import christmas.domain.dto.MenuItemDto;
import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuItems;
import java.util.List;

public class MapToMenuItems {
    public static List<MenuItemDto> mapToMenuItems(final MenuItems menuItems) {
        List<MenuItem> menus = menuItems.getMenuItems();

        return menus.stream()
                .map(MapToMenuItems::toMenuItemDto)
                .toList();
    }

    private static MenuItemDto toMenuItemDto(MenuItem menuItem) {
        return new MenuItemDto(menuItem.getName(), menuItem.getCount());
    }
}