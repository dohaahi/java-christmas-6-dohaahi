package christmas.domain.promotion;

import static christmas.domain.promotion.Promotion.NO_DISCOUNT;
import static christmas.domain.promotion.WeekendPromotion.WEEKEND_DISCOUNT_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuItems;
import christmas.domain.order.OrderElement;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendPromotionTest {
    WeekendPromotion weekendPromotion;
    Date weekendDate;
    Date weekedayDate;
    MenuItems mainMenu;
    MenuItems dessertMenu;

    @BeforeEach
    void beforeEach() {
        weekendPromotion = new WeekendPromotion();
        weekendDate = new Date(1);
        weekedayDate = new Date(4);
        mainMenu = new MenuItems(List.of(MenuItem.from("크리스마스파스타-5")));
        dessertMenu = new MenuItems(List.of(MenuItem.from("초코케이크-5")));
    }

    @DisplayName("주말에 메인 메뉴를 주문하면 개 당 " + WEEKEND_DISCOUNT_AMOUNT + "원 만큼 할인해준다.")
    @Test
    void Weekend_Main_Menu_Order() {

        // given
        OrderElement orderElement = new OrderElement(weekendDate, mainMenu);

        // when
        int discountAmount = weekendPromotion.discountAmount(orderElement);

        // then
        assertThat(discountAmount).isEqualTo(WEEKEND_DISCOUNT_AMOUNT * 5);
    }

    @DisplayName("주말에 메인 메뉴를 주문하지 않으면 할인액은 없다.")
    @Test
    void Weekend_Main_Menu_Non_Order() {

        // given
        OrderElement orderElement = new OrderElement(weekendDate, dessertMenu);

        // when
        int discountAmount = weekendPromotion.discountAmount(orderElement);

        // then
        assertThat(discountAmount).isEqualTo(NO_DISCOUNT);
    }
}