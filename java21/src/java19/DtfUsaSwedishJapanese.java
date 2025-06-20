package java19;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Example shows how to format date object and display month and year
 * only using 3 locales: US/Swedish/Japanese.
 */
public class DtfUsaSwedishJapanese {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();

        //Show example of FormatStyle.Medium for US,Swedish,Japanese locale
        usingMediumFormatStyleUS_Sweden_Japan(date);

        //Show example of ofPattern for US,Swedish,Japanese locale
        usingOfPattern_US_Sweden_Japan(date);

        //Show example of ofLocalizedPattern for US,Swedish,Japanese locale
        usingOfLocalizedPattern_US_Sweden_Japan(date);
    }

    private static void usingOfLocalizedPattern_US_Sweden_Japan(LocalDate date) {

        System.out.println("Using the new ofLocalizedPattern method: ");

        var usLocale = Locale.US;
        var swedishLocale = Locale.of("sv","SE");
        var japaneseLocale = Locale.of("ja");

        var pattern  = "yMMM";

        var ofLocalizedPatternUS = DateTimeFormatter.ofLocalizedPattern(pattern)
                                                    .withLocale(usLocale);
        System.out.println("ofLocalizedPattern|US Locale: "
                + date.format(ofLocalizedPatternUS));

        var ofLocalizedPatternSwedish  = DateTimeFormatter.ofLocalizedPattern(pattern)
                                                          .withLocale(swedishLocale);
        System.out.println("ofLocalized|Swedish Locale: "
                + date.format(ofLocalizedPatternSwedish));

        var ofLocalizedPatternJapanese  = DateTimeFormatter.ofLocalizedPattern(pattern)
                                                           .withLocale(japaneseLocale);
        System.out.println("ofLocalized|Japanese Locale: "
                + date.format(ofLocalizedPatternJapanese));
    }

    private static void usingOfPattern_US_Sweden_Japan(LocalDate date) {
        System.out.println("Using ofPattern method with pattern string as: MMM y");

        var yearMonthPattern = "MMM y";
        var ofPatternUSLocale = DateTimeFormatter.ofPattern(yearMonthPattern, Locale.US);
        System.out.println("ofPattern|US Locale: " + date.format(ofPatternUSLocale));

        var swedishLocale = Locale.of("sv","SE");
        var ofPatternSwedishLocale = DateTimeFormatter.ofPattern(yearMonthPattern)
                                                      .withLocale(swedishLocale);
        System.out.println("ofPattern|Swedish: " + date.format(ofPatternSwedishLocale));

        //See how the pattern produces incorrect result for the same
        var japaneseLocale = Locale.JAPANESE;
        var ofPatternJapaneseLocale = DateTimeFormatter.ofPattern(yearMonthPattern)
                                                       .withLocale(japaneseLocale);
        System.out.println("ofPattern|Japanese: " + date.format(ofPatternJapaneseLocale));
    }

    private static void usingMediumFormatStyleUS_Sweden_Japan(LocalDate date) {

        System.out.println("Using FormatStyle Medium for US,Swedish & Japanese Locales: ");

        var usMediumFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                                                 .withLocale(Locale.US);
        String usMediumFormat = date.format(usMediumFormatter);
        System.out.println("ofLocalizedDate|US Locale|Medium: "+usMediumFormat);

        var swedishLocale = Locale.of("sv","SE");
        var swedishMediumFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                                                      .withLocale(swedishLocale);
        String swedishMediumFormat = date.format(swedishMediumFormatter);
        System.out.println("ofLocalizedDate|Swedish|Medium: "+swedishMediumFormat);

        var japaneseLocale = Locale.JAPANESE;
        var japaneseMediumFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                                                       .withLocale(japaneseLocale);
        String japaneseMediumFormat = date.format(japaneseMediumFormatter);
        System.out.println("ofLocalizedDate|Japanese|Medium: "+japaneseMediumFormat);
    }
}
