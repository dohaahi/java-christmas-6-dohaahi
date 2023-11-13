package christmas.view;

import static christmas.domain.date.Date.CURRENT_MONTH;
import static christmas.domain.date.Date.isWeekend;
import static christmas.domain.promotion.GiftPromotion.GIFT_COUNT;
import static christmas.domain.promotion.GiftPromotion.GIFT_MENU;
import static christmas.view.OrderRecordMessage.ESTIMATED_PAYMENT_AFTER_PROMOTION;
import static christmas.view.OrderRecordMessage.EVENT_BADGE;
import static christmas.view.OrderRecordMessage.ORDER_MENU;
import static christmas.view.OrderRecordMessage.PROMOTION_RECORD;
import static christmas.view.OrderRecordMessage.TOTAL_PRICE_BEFORE_PROMOTION;
import static christmas.view.OrderRecordMessage.TOTAL_PROMOTION_PRICE;

import christmas.domain.dto.OrderRecord;
import christmas.domain.dto.PromotionRecordDto;
import christmas.domain.menu.MenuItem;
import christmas.domain.promotion.GiftPromotion;
import christmas.domain.promotion.PromotionName;
import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    public static final String PREVIEW_EVENT_MESSAGE = CURRENT_MONTH + "월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public static final String PRINT_MENU_FORMAT = "%s %s개";
    public static final String MONETARY_UNIT = "원";
    public static final String PROMOTION_RECORD_FORMAT = "%s: -%s" + MONETARY_UNIT;
    public static final String TOTAL_PROMOTION_PRICE_FORMAT = "-%s" + MONETARY_UNIT;
    public static final String NOTHING = "없음";
    public static final String MONEY_FORMAT = "###,###";

    public void printOrderRecord(final OrderRecord orderRecord) {
        printPreviewEvent(orderRecord.order().date().getDay());
        printOrderMenus(orderRecord);
        printTotalPrice(orderRecord);
        printGift(orderRecord);
        printPromotionRecord(orderRecord);
        printTotalPromotionPrice(orderRecord);
        printEstimatedPaymentAfterPromotion(orderRecord);
        printBadge(orderRecord);
    }

    private void printPreviewEvent(final int date) {
        System.out.printf(PREVIEW_EVENT_MESSAGE, date);
    }

    private void printOrderMenus(final OrderRecord orderRecord) {
        System.out.print(ORDER_MENU.getMessage());

        List<MenuItem> menuItems = orderRecord.order().menus().getMenuItems();

        for (int count = 0; count < menuItems.size() - 1; count++) {
            System.out.printf(PRINT_MENU_FORMAT + "\n", menuItems.get(count).getName(),
                    decimalFormat(menuItems.get(count).getCount()));
        }

        System.out.printf(PRINT_MENU_FORMAT, menuItems.get(menuItems.size() - 1).getName(),
                menuItems.get(menuItems.size() - 1).getCount());
    }

    private void printTotalPrice(final OrderRecord orderRecord) {
        System.out.print(TOTAL_PRICE_BEFORE_PROMOTION.getMessage());
        System.out.print(decimalFormat(orderRecord.order().menus().totalPrice()) + MONETARY_UNIT);
    }

    private void printGift(final OrderRecord orderRecord) {
        System.out.print(OrderRecordMessage.GIFT_MENU.getMessage());

        boolean giftPresent = GiftPromotion.isGiftPresent(orderRecord.promotionRecord().totalDiscountAmount());
        if (giftPresent) {
            System.out.printf(PRINT_MENU_FORMAT + "\n", GIFT_MENU, GIFT_COUNT);
        }

        System.out.print(NOTHING);
    }

    private void printPromotionRecord(final OrderRecord orderRecord) {
        System.out.print(PROMOTION_RECORD.getMessage());

        final int totalDiscountAmount = orderRecord.promotionRecord().totalDiscountAmount();
        if (totalDiscountAmount == 0) {
            System.out.print(NOTHING);
            return;
        }

        PromotionRecordDto promotion = orderRecord.promotionRecord();
        System.out.printf(PROMOTION_RECORD_FORMAT + "\n", PromotionName.CHRISTMAS_PROMOTION.getName(),
                decimalFormat(promotion.christmasPromotionDiscountAmount()));

        printPeriodPromotionRecord(orderRecord, promotion);

        System.out.printf(PROMOTION_RECORD_FORMAT + "\n", PromotionName.SPECIAL_PROMOTION.getName(),
                decimalFormat(promotion.specialPromotionDiscountAmount()));

        System.out.printf(PROMOTION_RECORD_FORMAT, PromotionName.GIFT_PROMOTION.getName(),
                decimalFormat(promotion.giftPromotionDiscountAmount()));
    }

    private void printPeriodPromotionRecord(final OrderRecord orderRecord, PromotionRecordDto promotion) {
        if (isWeekend(orderRecord.order().date())) {
            System.out.printf(PROMOTION_RECORD_FORMAT + "\n", PromotionName.WEEKEND_PROMOTION.getName(),
                    decimalFormat(promotion.periodPromotionDiscountAmount()));
            return;
        }

        System.out.printf(PROMOTION_RECORD_FORMAT + "\n", PromotionName.WEEKDAY_PROMOTION.getName(),
                decimalFormat(promotion.periodPromotionDiscountAmount()));
    }

    private void printTotalPromotionPrice(final OrderRecord orderRecord) {
        System.out.print(TOTAL_PROMOTION_PRICE.getMessage());

        final int totalDiscountAmount = orderRecord.promotionRecord().totalDiscountAmount();
        if (totalDiscountAmount == 0) {
            System.out.print(NOTHING);
            return;
        }

        System.out.printf(TOTAL_PROMOTION_PRICE_FORMAT, decimalFormat(totalDiscountAmount));
    }

    private void printEstimatedPaymentAfterPromotion(final OrderRecord orderRecord) {
        System.out.print(ESTIMATED_PAYMENT_AFTER_PROMOTION.getMessage());

        int totalPrice = orderRecord.order().menus().totalPrice();
        int totalDiscountAmount = orderRecord.promotionRecord().totalDiscountAmount();
        System.out.print(decimalFormat(totalPrice - totalDiscountAmount) + MONETARY_UNIT);
    }

    private void printBadge(final OrderRecord orderRecord) {
        System.out.print(EVENT_BADGE.getMessage());

        System.out.println(orderRecord.badgePromotion().badge().getName());
    }

    private String decimalFormat(final int price) {
        DecimalFormat decimalFormat = new DecimalFormat(MONEY_FORMAT);
        return decimalFormat.format(price);
    }
}