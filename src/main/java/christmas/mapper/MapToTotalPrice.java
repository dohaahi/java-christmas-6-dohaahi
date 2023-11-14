package christmas.mapper;

import christmas.domain.menu.MenuItems;

public class MapToTotalPrice {
    public static int mapToTotalPrice(final MenuItems menuItems) {
        return menuItems.totalPrice();
    }
}