package christmas.view;

import static christmas.domain.date.Date.CURRENT_MONTH;

public enum OrderRecordMessage {
    ORDER_MENU("주문 메뉴"),
    TOTAL_PRICE_BEFORE_PROMOTION("할인 전 총주문 금액"),
    GIFT_MENU("증정 메뉴"),
    PROMOTION_RECORD("혜택 내역"),
    TOTAL_PROMOTION_PRICE("총혜택 금액"),
    ESTIMATED_PAYMENT_AFTER_PROMOTION("할인 후 예상 결제 금액"),
    EVENT_BADGE(CURRENT_MONTH + "월 이벤트 배지");

    private final String message;

    OrderRecordMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "\n\n<" + message + ">\n";
    }
}