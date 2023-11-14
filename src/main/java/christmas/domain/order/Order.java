package christmas.domain.order;

import christmas.domain.date.Date;
import christmas.domain.dto.OrderRecord;
import christmas.domain.menu.MenuItems;
import christmas.domain.promotion.PromotionProcessor;
import christmas.mapper.OrderRecordMapper;

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