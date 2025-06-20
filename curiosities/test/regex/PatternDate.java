package regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDate {


    @Test
    void catchDate() {
        Pattern compilePattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2})");
        String text = "Payout Date=2023-10-25, Bank=555, Branch=55, Account=55555";
        Matcher matcher = compilePattern.matcher(text);
        System.out.println(matcher.find());
        System.out.println(matcher.group(1));


    }
}
