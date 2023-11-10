package christmas.domain.menu;

public enum MenuCategory {
    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    DRINK("음료");
    private final String categoryName;

    MenuCategory(String categoryName) {
        this.categoryName = categoryName;
    }
}