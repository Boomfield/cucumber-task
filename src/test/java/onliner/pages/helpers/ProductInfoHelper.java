package onliner.pages.helpers;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductInfoHelper {
    public static Function<String, Integer> extractTvDiagonal = d -> {
        Matcher matcher = Pattern.compile("^\\d+").matcher(d);
        return matcher.find() ? Integer.parseInt(matcher.group(0)) : null;
    };

    public static String convertPriceToString(String price) {
        return price.replaceAll("[^0-9,]+", "").replace(',', '.');
    }
}
