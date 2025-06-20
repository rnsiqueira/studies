package document;

import java.util.ArrayList;
import java.util.List;

public class DocumentCpf implements ValidDoc {

    private List<Integer> numbersCpf = new ArrayList<Integer>();
    private int numberValidator;


    @Override
    public boolean valided(String cpf) {
        String onlyNumber = cpf.replace(".", "").replace("-", "");
        numberValidator = Integer.parseInt(String.valueOf(onlyNumber.charAt(9)));
        int ruleSum = sumNoneDigits(onlyNumber);

        System.out.println((ruleSum * 10) % 11);

        return (ruleSum * 10) % 11 == numberValidator ? true : false;
    }

    private Integer sumNoneDigits(String onlyNumber) {

        for (int i = 0; i < 9; i++) {
            int number = Integer.parseInt(String.valueOf(onlyNumber.charAt(i)));
            numbersCpf.add(number);
        }


        return ruleValues();
    }

    private int ruleValues() {
        int sum = 0;
        int mult = 10;
        for (int i = 0; i < 9; i++) {
            sum += numbersCpf.get(i) * mult;
            mult--;

        }

        return sum;
    }
}
