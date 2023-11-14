package christmas.mapper;

import static christmas.mapper.BadgeMapper.mapToBadge;
import static christmas.mapper.DateMapper.mapToDate;
import static christmas.mapper.GiftMenuMapper.mapToGiftMenu;
import static christmas.mapper.MenuItemsMapper.mapToMenuItems;
import static christmas.mapper.PromotionsMapper.mapToPromotions;
import static christmas.mapper.TotalDiscountAmountMapper.mapToTotalDiscountAmount;
import static christmas.mapper.TotalPriceMapper.mapToTotalPrice;

import christmas.domain.date.Date;
import christmas.domain.dto.OrderRecord;
import christmas.domain.menu.MenuItems;
import christmas.domain.promotion.PromotionProcessor;

public class OrderRecordMapper {
    private final Date date;
    private final MenuItems menuItems;
    private final PromotionProcessor promotionProcessor;

    public OrderRecordMapper(final Date date, final MenuItems menuItems, final PromotionProcessor promotionProcessor) {
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
