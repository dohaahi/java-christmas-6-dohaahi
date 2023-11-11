package christmas.domain.menu;

import christmas.domain.MenuItem;
import christmas.validator.ErrorMessage;
import java.util.List;
import java.util.Optional;

public enum Menu {
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

    private static List<Menu> menuItems = List.of(
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
    private final String menuName;
    private final int menuPrice;
    private final MenuCategory category;

    Menu(String menuName, int menuPrice, MenuCategory categoryName) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = categoryName;
    }

    public static boolean isMatchMenu(final String menuName) {
        return menuItems.stream()
                .anyMatch(menuItem -> menuName.equals(menuItem.menuName));
    }

    public static Menu getMenuItem(final MenuItem menuItem) {
        Optional<Menu> findMenu = menuItems.stream()
                .filter(menuItem -> menuItem.menuName.equals(menuItem.getMenuName()))
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

    public MenuCategory getCategory(final MenuItem menu) {
        return menuItems.stream()
                .filter(menuItem -> menuItem.menuName.equals(menu.getMenuName()))
                .findAny()
                .get()
                .getCategory();
    }
}