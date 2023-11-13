package christmas.controller;

import static christmas.domain.promotion.GiftPromotion.GIFT_MENU;

import christmas.domain.badge.BadgePromotion;
import christmas.domain.dto.BadgePromotionDto;
import christmas.domain.dto.OrderDto;
import christmas.domain.dto.OrderRecord;
import christmas.domain.dto.PromotionRecordDto;
import christmas.domain.order.Order;
import christmas.domain.promotion.GiftPromotion;
import christmas.domain.promotion.PromotionRecord;

public class OrderRecordMapper {
    private final Order order;
    private final PromotionRecord promotionRecord;
    private final BadgePromotion badgePromotion;

    public OrderRecordMapper(Order order, PromotionRecord promotionRecord) {
        this.order = order;
        this.promotionRecord = promotionRecord;
        this.badgePromotion = new BadgePromotion(promotionRecord);
    }

    public OrderRecord toOrderRecord() {
        return new OrderRecord(makeOrderDto(), makePromotionRecordDto(), makeBadgePromotionDto());
    }

    private OrderDto makeOrderDto() {
        return new OrderDto(order.getDate(), order.getMenus(), order.getPromotionProcessor());
    }

    private PromotionRecordDto makePromotionRecordDto() {
        int totalDiscountAmount = promotionRecord.getTotalDiscountAmount();

        return new PromotionRecordDto(
                promotionRecord.getChristmasPromotionDiscountAmount(),
                promotionRecord.getPeriodPromotionDiscountAmount(),
                promotionRecord.getSpecialPromotionDiscountAmount(),
                promotionRecord.getGiftPromotionDiscountAmount(),
                totalDiscountMapper(totalDiscountAmount)
        );
    }

    private int totalDiscountMapper(final int totalDiscountAmount) {
        if (GiftPromotion.isGiftPresent(totalDiscountAmount)) {
            return totalDiscountAmount - GIFT_MENU.getPrice();
        }

        return totalDiscountAmount;
    }

    private BadgePromotionDto makeBadgePromotionDto() {
        return new BadgePromotionDto(badgePromotion.getBadge());
    }
}