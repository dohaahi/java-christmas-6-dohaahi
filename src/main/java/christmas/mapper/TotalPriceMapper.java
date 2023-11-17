package christmas.mapper;

import christmas.domain.menu.MenuItems;

public class TotalPriceMapper {
    public static int mapToTotalPrice(final MenuItems menuItems) {
        return menuItems.totalPrice();
    }
}