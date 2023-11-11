package christmas.domain.order;

import christmas.domain.Date;
import christmas.domain.MenuItems;

public class Order {
    private final Date date;
    private final MenuItems menus;

    public Order(Date date, MenuItems menus) {
        this.date = date;
        this.menus = menus;
    }
}