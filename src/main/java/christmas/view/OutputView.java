package christmas.view;

import static christmas.domain.date.Date.CURRENT_MONTH;
import static christmas.view.OrderRecordMessage.ESTIMATED_PAYMENT_AFTER_PROMOTION;
import static christmas.view.OrderRecordMessage.EVENT_BADGE;
import static christmas.view.OrderRecordMessage.ORDER_MENU;
import static christmas.view.OrderRecordMessage.PROMOTION_RECORD;
import static christmas.view.OrderRecordMessage.TOTAL_PRICE_BEFORE_PROMOTION;
import static christmas.view.OrderRecordMessage.TOTAL_PROMOTION_PRICE;

import christmas.domain.dto.MenuItemDto;
import christmas.domain.dto.OrderRecord;
import christmas.domain.dto.PromotionDto;
import christmas.domain.promotion.GiftPromotion;
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
        printPreviewEvent(orderRecord);
        printOrderMenus(orderRecord);
        printTotalPrice(orderRecord);
        printGift(orderRecord);
        printPromotionRecord(orderRecord);
        printTotalPromotionPrice(orderRecord);
        printEstimatedPaymentAfterPromotion(orderRecord);
        printBadge(orderRecord);
    }

    private void printPreviewEvent(final OrderRecord orderRecord) {
        System.out.printf(PREVIEW_EVENT_MESSAGE, orderRecord.date());
    }

    private void printOrderMenus(final OrderRecord orderRecord) {
        System.out.print(ORDER_MENU.getMessage());

        final List<MenuItemDto> menuItems = orderRecord.menuItemDtos();

        for (int count = 0; count < menuItems.size() - 1; count++) {
            System.out.printf(PRINT_MENU_FORMAT + "\n", menuItems.get(count).name(),
                    decimalFormat(menuItems.get(count).count()));
        }

        System.out.printf(PRINT_MENU_FORMAT, menuItems.get(menuItems.size() - 1).name(),
                menuItems.get(menuItems.size() - 1).count());
    }

    private void printTotalPrice(final OrderRecord orderRecord) {
        System.out.print(TOTAL_PRICE_BEFORE_PROMOTION.getMessage());
        System.out.print(decimalFormat(orderRecord.TotalPrice()) + MONETARY_UNIT);
    }

    private void printGift(final OrderRecord orderRecord) {
        System.out.print(OrderRecordMessage.GIFT_MENU.getMessage());

        final boolean giftPresent = GiftPromotion.isGiftPresent(orderRecord.TotalDiscountAmount());
        if (giftPresent) {
            System.out.printf(PRINT_MENU_FORMAT + "\n", orderRecord.GiftMenu().name(), orderRecord.GiftMenu().count());
        }

        System.out.print(NOTHING);
    }

    private void printPromotionRecord(final OrderRecord orderRecord) {
        System.out.print(PROMOTION_RECORD.getMessage());

        final int totalDiscountAmount = orderRecord.TotalDiscountAmount();

        if (totalDiscountAmount == 0) {
            System.out.print(NOTHING);
            return;
        }

        List<PromotionDto> promotions = orderRecord.Promotions();

        promotions.forEach(promotion -> {
            System.out.printf(PROMOTION_RECORD_FORMAT + "\n", promotion.name(),
                    decimalFormat(promotion.discountAmount()));
        });
    }

    private void printTotalPromotionPrice(final OrderRecord orderRecord) {
        System.out.print(TOTAL_PROMOTION_PRICE.getMessage());

        final int totalDiscountAmount = orderRecord.TotalDiscountAmount();
        if (totalDiscountAmount == 0) {
            System.out.print(NOTHING);
            return;
        }

        System.out.printf(TOTAL_PROMOTION_PRICE_FORMAT, decimalFormat(totalDiscountAmount));
    }

    private void printEstimatedPaymentAfterPromotion(final OrderRecord orderRecord) {
        System.out.print(ESTIMATED_PAYMENT_AFTER_PROMOTION.getMessage());

        System.out.print(decimalFormat(orderRecord.FinalPaymentAmount()) + MONETARY_UNIT);
    }

    private void printBadge(final OrderRecord orderRecord) {
        System.out.print(EVENT_BADGE.getMessage());

        System.out.println(orderRecord.badge());
    }

    private String decimalFormat(final int price) {
        final DecimalFormat decimalFormat = new DecimalFormat(MONEY_FORMAT);
        return decimalFormat.format(price);
    }
}