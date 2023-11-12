package christmas.controller;

import christmas.domain.OrderRecord;
import christmas.domain.badge.BadgePromotion;
import christmas.domain.order.Order;
import christmas.domain.promotion.PromotionRecord;

public class OrderRecordMapper {
    /*
        주문 메뉴 - Order - menuItems
        할인 전 총 주문 금액 - Order - menuItems
        증정 메뉴 - Order - promotionProcessor
        혜택 내역 - PromotionRecord
        총 혜택 금액 - PromotionRecord
        할인 후 결제 예상 금액 - PromotionRecord
        12월 이벤트 배지 - Badge <- menuItems: totalPrice
     */
    private final Order order;
    private final PromotionRecord promotionRecord;
    private final BadgePromotion badgePromotion = new BadgePromotion();

    public OrderRecordMapper(Order order, PromotionRecord promotionRecord) {
        this.order = order;
        this.promotionRecord = promotionRecord;
    }

    public OrderRecord toOrderRecord() {
        return new OrderRecord(order, promotionRecord, badgePromotion);
    }
}