package christmas.domain;

import christmas.domain.badge.BadgePromotion;
import christmas.domain.order.Order;
import christmas.domain.promotion.PromotionRecord;

public record OrderRecord(Order order, PromotionRecord promotionRecord, BadgePromotion badgePromotion) {
}
