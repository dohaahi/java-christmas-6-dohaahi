package christmas.domain.promotion;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItems;
import christmas.domain.order.OrderElement;
import java.util.List;

public class PromotionProcessor {
    private final OrderElement orderElement;
    private final BadgePromotion badgePromotion = new BadgePromotion();
    private List<Promotion> promotions;

    public PromotionProcessor(final Date date, final MenuItems menuItems) {
        this.orderElement = new OrderElement(date, menuItems);

        if (date.isWeekend(date)) {
            weekendPromotions();
            return;
        }

        weekdayPromotions();
    }

    private void weekendPromotions() {
        promotions = List.of(
                new ChristmasPromotion(),
                new WeekendPromotion(),
                new SpecialPromotion(),
                new GiftPromotion());
    }

    private void weekdayPromotions() {
        promotions = List.of(
                new ChristmasPromotion(),
                new WeekdayPromotion(),
                new SpecialPromotion(),
                new GiftPromotion());
    }

    public int getTotalDiscountAmount() {
        return promotions.stream()
                .mapToInt(promotion -> promotion.discountAmount(orderElement))
                .sum();
    }

    public int getDiscountAmount(final Promotion promotion) {
        return promotion.discountAmount(orderElement);
    }

    public String getBadge(final int totalDiscountAmount) {
        return badgePromotion.getBadge(totalDiscountAmount)
                .getName();
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }
}