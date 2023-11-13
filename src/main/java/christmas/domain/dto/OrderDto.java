package christmas.domain.dto;

import christmas.domain.date.Date;
import christmas.domain.menu.MenuItems;
import christmas.domain.promotion.PromotionProcessor;

public record OrderDto(Date date, MenuItems menus, PromotionProcessor promotionProcessor) {
}