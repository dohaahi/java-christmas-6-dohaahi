package christmas.domain.badge;

import christmas.domain.menu.MenuItems;

public class BadgePromotion {

    public Badge present(final MenuItems menuItems) {
        if (menuItems.totalPrice() > Badge.SANTA.getMinPrice()) {
            return Badge.STAR;
        }

        if (menuItems.totalPrice() > Badge.TREE.getMinPrice()) {
            return Badge.TREE;
        }

        if (menuItems.totalPrice() > Badge.STAR.getMinPrice()) {
            return Badge.SANTA;
        }

        return Badge.NONE;
    }
}