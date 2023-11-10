package christmas.domain;

import java.util.List;

public enum MenuItem {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000),
    T_BONE_STEAK("티본스테이크", 55_000),
    BARBECUE_LIP("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000),
    CHOCO_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000),
    ZERO_COLA("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    private final String menuName;
    private final int menuPrice;

    MenuItem(String menuName, int menuPrice) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    private static List<MenuItem> menuItems = List.of(
            MUSHROOM_SOUP,
            TAPAS,
            CAESAR_SALAD,
            T_BONE_STEAK,
            BARBECUE_LIP,
            SEAFOOD_PASTA,
            CHRISTMAS_PASTA,
            CHOCO_CAKE,
            ICE_CREAM,
            ZERO_COLA,
            RED_WINE,
            CHAMPAGNE
    );

    public static boolean isMatchMenu(final OrderMenu menu) {
        return menuItems.stream()
                .anyMatch(menuItem -> menu.getMenuName().equals(menuItem.menuName));
    }

    public String getMenuName() {
        return menuName;
    }
}