package christmas.domain;

import static christmas.util.StringConverter.delimiterStringToList;
import static christmas.validator.MenusValidator.validateOrderMenus;

import christmas.validator.ErrorMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MenuItems {
    public static final String DELIMITER = ", ";
    public static final int MIN_ORDER_COUNT = 1;
    public static final int MAX_ORDER_COUNT = 20;
    private final Map<christmas.domain.menu.MenuItems, Integer> menus;

    public MenuItems(final String input) {
        List<String> orderMenus = delimiterStringToList(DELIMITER, input);
        List<MenuItem> menuItems = converterStringToMenus(orderMenus);
        validateOrderMenus(menuItems);

        Map<christmas.domain.menu.MenuItems, Integer> menuStorage = new HashMap<>();
        menuItems.forEach(menu -> {
            menuStorage.put(christmas.domain.menu.MenuItems.getMenuItem(menu), menu.getCount());
        });

        this.menus = menuStorage;
    }

    private List<MenuItem> converterStringToMenus(List<String> orderMenus) {
        List<MenuItem> menuItems = new ArrayList<>();

        try {
            orderMenus.forEach(orderMenu -> {
                MenuItem menuItem = MenuItem.from(orderMenu);
                menuItems.add(menuItem);
            });
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_MENU_MESSAGE.getMessage());
        }

        return menuItems;
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (Entry<christmas.domain.menu.MenuItems, Integer> menu : menus.entrySet()) {
            totalPrice += menu.getKey().getPrice() * menu.getValue();
        }

        return totalPrice;
    }

    public Map<christmas.domain.menu.MenuItems, Integer> getMenus() {
        return Map.copyOf(menus);
    }
}