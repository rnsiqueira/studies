package java21;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

/**
 * Shows an example of Record Pattern
 */
public class RecordPattern {

    public static void main(String[] args) {

        Object datum = someThirdPartyCode();
        String result = usingSwitchRecordPattern(datum);
        System.out.println(result);
    }

    public static String usingSwitchRecordPattern(Object datum) {
        return switch (datum) {
            case String result -> "Creating String schema for: " + result.toUpperCase();
            case DateRange(var fromDate, var toDate) ->
                    "Record type schema for DateRange between:" + fromDate + " and " + toDate;
            case LocalDate result -> "Creating Date schema for Date: " +
                    result.format(DateTimeFormatter.ISO_DATE);
            case Enum result -> "Creating Enum schema for: " + result.name();
            case Collection result -> "Creating Array like schema: " + result;
            case null, default -> throw new IllegalArgumentException("Can't create schema for: "
                    + datum);
        };
    }

    public static Object someThirdPartyCode() {
        return new DateRange(LocalDate.now().minusDays(2), LocalDate.now());
    }
}
