package christmas.domain.order;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItems;

public class OrderElement {
    private final Date date;
    private final MenuItems menuItems;

    public OrderElement(final Date date, final MenuItems menuItems) {
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