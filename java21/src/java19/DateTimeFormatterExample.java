package java19;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import java.util.Locale;

public class DateTimeFormatterExample {

    public static void main(String[] args) {

        var date  = LocalDate.now();

        //Shows an example of using LocalDate,LocalDateTime with DateTimeFormatter.
        usingSimpleLocalDateAndFormatter(date);

        //Shows example of FormatStyle
        usingFormatStyleFormatter(date);

        //Shows example of FormatStyle.Medium for US/Swedish locales.
        usingMediumFormatStyleUS_Sweden(date);

        //Using ofPattern()
        usingOfPattern(date);

        //Using new method ofLocalizedPattern();
        usingOfLocalizedPattern(date);

    }

    private static void usingOfLocalizedPattern(LocalDate date) {

        System.out.println("Using the new ofLocalizedPattern method: ");

        var usLocale = Locale.US;
        var swedishLocale = Locale.of("sv","SE");

        var ofLocalizedPatternUS = DateTimeFormatter.ofLocalizedPattern("MMMd")
                                                    .withLocale(usLocale);
        System.out.println("ofLocalizedPattern|US Locale: "
                + date.format(ofLocalizedPatternUS));

        var ofLocalizedPatternSwedish  = DateTimeFormatter.ofLocalizedPattern("MMMd")
                                                          .withLocale(swedishLocale);
        System.out.println("ofLocalized|Swedish Locale: "
                + date.format(ofLocalizedPatternSwedish));
    }

    private static void usingMediumFormatStyleUS_Sweden(LocalDate date) {

        System.out.println("Using FormatStyle Medium for US and Swedish Locales: ");

        var usMediumFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.US);
        String usMediumFormat = date.format(usMediumFormatter);
        System.out.println("ofLocalizedDate|US Locale|Medium: "+usMediumFormat);

        var swedishLocale = Locale.of("sv","SE");
        var swedishMediumFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(swedishLocale);
        String swedishMediumFormat = date.format(swedishMediumFormatter);
        System.out.println("ofLocalizedDate|Swedish|Medium: "+swedishMediumFormat);
    }

    private static void usingOfPattern(LocalDate date) {

        System.out.println("Using ofPattern method with pattern string as: MMM d");

        var monthDatePattern = "MMM d";
        var ofPatternUSLocale = DateTimeFormatter.ofPattern(monthDatePattern, Locale.US);
        System.out.println("ofPattern|US Locale: " + date.format(ofPatternUSLocale));

        var swedishLocale = Locale.of("sv","SE");
        var ofPatternSwedishLocale = DateTimeFormatter.ofPattern(monthDatePattern)
                                                      .withLocale(swedishLocale);
        System.out.println("ofPattern|Swedish: " + date.format(ofPatternSwedishLocale));
    }

    /**
     * Shows simple example of using LocalDate/LocalDateTime
     * with DateTimeFormatter
     */
    private static void usingSimpleLocalDateAndFormatter(LocalDate date) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;
        var dateString = date.format(dateFormatter);
        System.out.println("Simple DateFormatter : "+ dateString);

        var dateTime = LocalDateTime.now();
        var dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        var dateTimeString = dateTime.format(dateTimeFormatter);
        System.out.println("Simple DateTimeFormatter : "+ dateTimeString);
    }

    private static void usingFormatStyleFormatter(LocalDate date) {

        System.out.println("Shows date in Full,Long,Medium & Short string formats... ");
        System.out.println("Default locale is : " + Locale.getDefault());

        var defaultFullFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String defaultFullFormat = date.format(defaultFullFormatter);
        System.out.println("Default Locale,[Full]: "+defaultFullFormat);

        var usFullFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                                               .withLocale(Locale.US);
        String usFullFormat = date.format(usFullFormatter);
        System.out.println("US Locale,[Full]: "+usFullFormat);

        var swedishLocale = Locale.of("sv","SE");
        var swedishFullFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                                                    .withLocale(swedishLocale);
        String swedishFullFormat = date.format(swedishFullFormatter);
        System.out.println("Swedish,[Full]: "+swedishFullFormat);

        var swedishLongFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                                                    .withLocale(swedishLocale);
        String swedishLongFormat = date.format(swedishLongFormatter);
        System.out.println("Swedish,[Long]: "+swedishLongFormat);

        var swedishMediumFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                                                      .withLocale(swedishLocale);
        String swedishMediumFormat = date.format(swedishMediumFormatter);
        System.out.println("Swedish,[Medium]: "+swedishMediumFormat);

        var swedishShortFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                                                     .withLocale(swedishLocale);
        String swedishShortFormat = date.format(swedishShortFormatter);
        System.out.println("Swedish,[Short]: "+swedishShortFormat);
    }

}
