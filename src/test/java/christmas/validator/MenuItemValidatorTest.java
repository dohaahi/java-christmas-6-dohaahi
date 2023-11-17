package christmas.validator;

import static christmas.domain.menu.MenuItems.MIN_ORDER_COUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.menu.MenuItem;
import christmas.exception.IllegalMenuException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuItemValidatorTest {
    @DisplayName("주문한 메뉴 개수가 " + MIN_ORDER_COUNT + "개 미만인 경우 예외 발생")
    @Test
    void Order_Count_Under_Min() {
        // given
        String menus1 = "시저샐러드-0";
        String menus2 = "양송이수프--1";

        // when
        // then
        assertThatThrownBy(() -> MenuItem.from(menus1))
                .isInstanceOf(IllegalMenuException.class);
        assertThatThrownBy(() -> MenuItem.from(menus2))
                .isInstanceOf(IllegalMenuException.class);
    }

    @DisplayName("메뉴 목록에 존재하는 메뉴를 시키면 검증 통과")
    @Test
    void Order_Menu_In_Menu_Item() {
        // given
        String menus1 = "양송이수프-1";
        String menus2 = "크리스마스파스타-3";

        // when
        // then
        MenuItem.from(menus1);
        MenuItem.from(menus2);
    }

    @DisplayName("메뉴 목록에 존재하지 않는 메뉴를 시키면 예외 발생")
    @Test
    void Order_Menu_Not_In_Menu_Item() {
        // given
        String menus1 = "브로콜리수프-1";
        String menus2 = "브로콜리수프-1";

        // when
        // then
        assertThatThrownBy(() -> MenuItem.from(menus1))
                .isInstanceOf(IllegalMenuException.class);
        assertThatThrownBy(() -> MenuItem.from(menus2))
                .isInstanceOf(IllegalMenuException.class);
    }
}