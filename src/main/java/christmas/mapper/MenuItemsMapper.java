package christmas.mapper;

import christmas.domain.dto.MenuItemDto;
import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuItems;
import java.util.List;

public class MenuItemsMapper {
    public static List<MenuItemDto> mapToMenuItems(final MenuItems menuItems) {
        final List<MenuItem> menus = menuItems.getMenuItems();

        return menus.stream()
                .map(MenuItemsMapper::toMenuItemDto)
                .toList();
    }

    private static MenuItemDto toMenuItemDto(final MenuItem menuItem) {
        return new MenuItemDto(menuItem.getName(), menuItem.getCount());
    }
}