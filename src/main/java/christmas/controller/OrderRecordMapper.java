package christmas.controller;

import static christmas.mapper.MapToBadge.mapToBadge;
import static christmas.mapper.MapToDate.mapToDate;
import static christmas.mapper.MapToGiftMenu.mapToGiftMenu;
import static christmas.mapper.MapToMenuItems.mapToMenuItems;
import static christmas.mapper.MapToPromotions.mapToPromotions;
import static christmas.mapper.MapToTotalDiscountAmount.mapToTotalDiscountAmount;
import static christmas.mapper.MapToTotalPrice.mapToTotalPrice;

import christmas.domain.date.Date;
import christmas.domain.dto.OrderRecord;
import christmas.domain.menu.MenuItems;
import christmas.domain.promotion.PromotionProcessor;

public class OrderRecordMapper {
    private final Date date;
    private final MenuItems menuItems;
    private final PromotionProcessor promotionProcessor;

    public OrderRecordMapper(Date date, MenuItems menuItems, PromotionProcessor promotionProcessor) {
        this.date = date;
        this.menuItems = menuItems;
        this.promotionProcessor = promotionProcessor;
    }

    public OrderRecord toOrderRecord() {
        return new OrderRecord(
                mapToDate(date),
                mapToMenuItems(menuItems),
                mapToTotalPrice(menuItems),
                mapToGiftMenu(),
                mapToPromotions(promotionProcessor),
                mapToTotalDiscountAmount(promotionProcessor),
                mapToFinalPaymentAmount(),
                mapToBadge(promotionProcessor)
        );
    }

    private int mapToFinalPaymentAmount() {
        return mapToTotalPrice(menuItems) - mapToTotalDiscountAmount(promotionProcessor);
    }
}
