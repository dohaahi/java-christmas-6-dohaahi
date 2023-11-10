package christmas.domain;

import static christmas.util.StringConverter.delimiterStringToList;

import java.util.List;

public class Menu {
    public static final String DELIMITER = "-";
    private final String menuName;
    private final int menuCount;

    private Menu(String orderMenu) {
        List<String> menu = delimiterStringToList(DELIMITER, orderMenu);
        String menuName = menu.get(0);
        int menuCount = Integer.parseInt(menu.get(1));

        this.menuName = menuName;
        this.menuCount = menuCount;
    }

    public static Menu from(final String orderMenu) {
        return new Menu(orderMenu);
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuCount() {
        return menuCount;
    }
}