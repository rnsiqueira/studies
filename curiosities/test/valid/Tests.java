package valid;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class Tests {

    @Test
    public void date() {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(simpleDateFormat.format(date));
    }

    @Test
    void arrays() {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        nums.forEach(System.out::println);
        System.out.println(nums.size());
        nums.clear();

        nums.forEach(System.out::println);
        System.out.println(nums.size());


    }

    @Test
    void roundIntegerNumber() {

        Integer num = 89;

        System.out.println(Integer.valueOf(String.valueOf(Math.ceil(Double.valueOf(num.toString().charAt(0) + "." + num.toString().charAt(1)))).replace(".", "")));
    }


}
