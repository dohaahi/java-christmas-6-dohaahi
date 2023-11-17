package christmas.util;

import java.util.Arrays;
import java.util.List;

public class StringConverter {
    public static List<String> delimiterStringToList(final String delimiter, final String input) {
        return Arrays.stream(input.split(delimiter)).toList();
    }
}
