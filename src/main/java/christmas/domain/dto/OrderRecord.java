package christmas.domain.dto;

import java.util.List;

public record OrderRecord(
        int date,
        List<MenuItemDto> menuItemDtos,
        int TotalPrice,
        MenuItemDto GiftMenu,
        List<PromotionDto> Promotions,
        int TotalDiscountAmount,
        int FinalPaymentAmount,
        String badge) {
}