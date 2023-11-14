package christmas.mapper;

import static christmas.domain.promotion.GiftPromotion.GIFT_COUNT;
import static christmas.domain.promotion.GiftPromotion.GIFT_MENU;

import christmas.domain.dto.MenuItemDto;

public class GiftMenuMapper {
    public static MenuItemDto mapToGiftMenu() {
        return new MenuItemDto(GIFT_MENU.getName(), GIFT_COUNT);
    }
}