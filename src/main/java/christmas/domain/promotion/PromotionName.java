package christmas.domain.promotion;

public enum PromotionName {
    CHRISTMAS_PROMOTION("크리스마스 디데이 할인"),
    WEEKEND_PROMOTION("주말 할인"),
    WEEKDAY_PROMOTION("평일 할인"),
    SPECIAL_PROMOTION("특별 할인"),
    GIFT_PROMOTION("증정 이벤트");
    private final String name;

    PromotionName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}