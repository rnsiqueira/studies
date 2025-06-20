package java21;

public class NormalSwitchCase {

    public static void main(String[] args) {

        NormalSwitchCase normalSwitchCase = new NormalSwitchCase();
        int budget = 2000000;
        int numberOfBedRoomsUsingStatement = normalSwitchCase.getNumberOfRoomsUsingStatement(budget);
        int numberOfBedRoomsUsingExpression = normalSwitchCase.getNumberOfRoomsUsingExpression(budget);
        System.out.println("You can get a house with " + numberOfBedRoomsUsingStatement + " room(s) in this budget");

        System.out.println("You can get a house with " + numberOfBedRoomsUsingExpression + " room(s) in this budget");
    }


    public int getNumberOfRoomsUsingStatement(int budget) {
        int numberOfRooms = 0;
        switch (budget) {
            case 1000000: numberOfRooms = 1;
                break;
            case 2000000:
            case 3000000: numberOfRooms = 2;
                break;
            case 4000000:
            case 5000000: System.out.println("Hello");
                break;
            default:
                System.out.println("Hello");
        }
        return numberOfRooms;
    }

    public int getNumberOfRoomsUsingExpression(int budget) {


        int numberOfRooms = switch (budget) {
            case 1000000 -> 1;
            case 2000000, 3000000 -> 2;
            case 4000000, 5000000 -> 3;
            default -> throw new IllegalStateException("No rooms available for this budget");
        };

        return numberOfRooms;
    }

}

