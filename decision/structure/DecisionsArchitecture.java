package decision.structure;

public class DecisionsArchitecture<aNumber> {

    private static int sum;

    public static String setCompanyId(int id) {
        return id == 7878 || id == 8080 ? "name1" : "name2";
    }

    private static int aNumber;

    private static void decisionMethod(int number){

        switch (number){
            case 5:
                sum = number;
                break;
            default:
                System.out.println("Invalid number!!!");
        }

    }



    public static void main(String[] args) {

        System.out.println(setCompanyId(8081));

        decisionMethod(7);
        System.out.println(sum);
    }


}
