package christmas.domain.menu;

import christmas.domain.Menu;
import christmas.validator.ErrorMessage;
import java.util.List;
import java.util.Optional;

public enum MenuItem {
    MUSHROOM_SOUP("양송이수프", 6_000, MenuCategory.APPETIZER),
    TAPAS("타파스", 5_500, MenuCategory.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8_000, MenuCategory.APPETIZER),
    T_BONE_STEAK("티본스테이크", 55_000, MenuCategory.MAIN),
    BARBECUE_LIP("바비큐립", 54_000, MenuCategory.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35_000, MenuCategory.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, MenuCategory.MAIN),
    CHOCO_CAKE("초코케이크", 15_000, MenuCategory.DESSERT),
    ICE_CREAM("아이스크림", 5_000, MenuCategory.DESSERT),
    ZERO_COLA("제로콜라", 3_000, MenuCategory.DRINK),
    RED_WINE("레드와인", 60_000, MenuCategory.DRINK),
    CHAMPAGNE("샴페인", 25_000, MenuCategory.DRINK);

    private final String menuName;
    private final int menuPrice;
    private final MenuCategory category;

    MenuItem(String menuName, int menuPrice, MenuCategory categoryName) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = categoryName;
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

    public static boolean isMatchMenu(final Menu menu) {
        return menuItems.stream()
                .anyMatch(menuItem -> menu.getMenuName().equals(menuItem.menuName));
    }

    public static MenuItem getMenuItem(final Menu menu) {
        Optional<MenuItem> findMenu = menuItems.stream()
                .filter(menuItem -> menuItem.menuName.equals(menu.getMenuName()))
                .findFirst();

        if (findMenu.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }

        return findMenu.get();
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public MenuCategory getCategory() {
        return category;
    }
}