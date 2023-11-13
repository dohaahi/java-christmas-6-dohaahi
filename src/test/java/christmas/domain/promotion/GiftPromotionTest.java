package christmas.domain.promotion;

import static christmas.domain.promotion.GiftPromotion.GIFT_MENU;
import static christmas.domain.promotion.GiftPromotion.MIN_ORDER_AMOUNT;
import static christmas.domain.promotion.Promotion.NO_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuItems;
import christmas.domain.order.OrderElement;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiftPromotionTest {
    Date date;
    GiftPromotion giftPromotion;

    @BeforeEach
    void beforeEach() {
        date = new Date(24);
        giftPromotion = new GiftPromotion();
    }

    @DisplayName(MIN_ORDER_AMOUNT + "원 이상 주문하면 증정 이벤트가 있다.")
    @Test
    void Total_Price_is_More_Than_Min_Order_Amount() {
        // given
        MenuItem pasta = MenuItem.from("크리스마스파스타-10");
        MenuItem steak = MenuItem.from("티본스테이크-10");
        MenuItems menuItems = new MenuItems(List.of(pasta, steak));
        OrderElement orderElement = new OrderElement(date, menuItems);

        // when
        int discountAmount = giftPromotion.discountAmount(orderElement);

        // then
        assertThat(discountAmount).isEqualTo(GIFT_MENU.getPrice());
    }

    @DisplayName(MIN_ORDER_AMOUNT + "원 미만으로 주문하면 증정 이벤트는 없다.")
    @Test
    void Total_Price_is_Less_Than_Min_Order_Amount() {
        // given
        MenuItems menuItems = new MenuItems(List.of(MenuItem.from("양송이수프-1")));
        OrderElement orderElement = new OrderElement(date, menuItems);

        // when
        int discountAmount = giftPromotion.discountAmount(orderElement);

        // then
        assertThat(discountAmount).isEqualTo(NO_DISCOUNT);
    }
}