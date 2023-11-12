package christmas.domain.order;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItems;
import christmas.domain.promotion.PromotionProcessor;
import christmas.domain.promotion.PromotionRecord;

public class Order {
    private final Date date;
    private final MenuItems menus;
    private final PromotionProcessor promotionProcessor;

    public Order(Date date, MenuItems menus) {
        this.date = date;
        this.menus = menus;

        promotionProcessor = new PromotionProcessor(date, menus);
    }

    public PromotionRecord discount() {
        return promotionProcessor.discount();
    }
}