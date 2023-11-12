package christmas.domain.order;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItems;

public class Order {
    private final Date date;
    private final MenuItems menus;

    public Order(Date date, MenuItems menus) {
        this.date = date;
        this.menus = menus;
    }
}