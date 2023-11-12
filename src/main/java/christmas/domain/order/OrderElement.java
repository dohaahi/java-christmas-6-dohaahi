package christmas.domain.order;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItems;

public class OrderElement {
    private final MenuItems menuItems;
    private final Date date;

    public OrderElement(MenuItems menuItems, Date date) {
        this.menuItems = menuItems;
        this.date = date;
    }

    public MenuItems getMenuItems() {
        return menuItems;
    }

    public Date getDate() {
        return date;
    }
}