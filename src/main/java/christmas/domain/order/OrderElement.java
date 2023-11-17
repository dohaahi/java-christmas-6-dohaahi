package christmas.domain.order;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuItems;
import java.util.List;

public class OrderElement {
    private final Date date;
    private final MenuItems menuItems;

    public OrderElement(final Date date, final MenuItems menuItems) {
        this.menuItems = menuItems;
        this.date = date;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems.getMenuItems();
    }

    public boolean isPriceLessThan(final int price) {
        return menuItems.totalPrice() < price;
    }

    public Date getDate() {
        return date;
    }
}