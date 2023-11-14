package christmas.domain.order;

import christmas.controller.OrderRecordMapper;
import christmas.domain.date.Date;
import christmas.domain.dto.OrderRecord;
import christmas.domain.menu.MenuItems;
import christmas.domain.promotion.PromotionProcessor;

public class Order {
    private final Date date;
    private final MenuItems menus;
    private final PromotionProcessor promotionProcessor;

    public Order(final Date date, final MenuItems menus) {
        this.date = date;
        this.menus = menus;

        promotionProcessor = new PromotionProcessor(date, menus);
    }

    public OrderRecord discount() {
        return new OrderRecordMapper(date, menus, promotionProcessor).toOrderRecord();
    }

    public Date getDate() {
        return date;
    }
}