package christmas.mapper;

import christmas.domain.date.Date;

public class MapToDate {
    public static int mapToDate(final Date date) {
        return date.getDay();
    }
}