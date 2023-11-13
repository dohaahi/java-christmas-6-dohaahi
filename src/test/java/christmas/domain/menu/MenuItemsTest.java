package christmas.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuItemsTest {
    @DisplayName("총 합계 금액을 구할 수 있다.")
    @Test
    void test() {
        // given
        MenuItem salad = MenuItem.from("시저샐러드-3");
        MenuItem soup = MenuItem.from("양송이수프-1");
        MenuItem cola = MenuItem.from("제로콜라-5");
        MenuItems menuItems = new MenuItems(List.of(salad, soup, cola));

        // when
        int totalPrice = menuItems.totalPrice();

        // then
        assertThat(totalPrice).isEqualTo(
                Menu.CAESAR_SALAD.getPrice() * 3
                        + Menu.MUSHROOM_SOUP.getPrice()
                        + Menu.ZERO_COLA.getPrice() * 5);
    }
}