package hackerrank.ai;

import java.util.Scanner;

public class BotSavesPrincess {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int matixDimension = scanner.nextInt();

        String[][] arena = new String[matixDimension][matixDimension];

        for (int i = 0; i < matixDimension; i++) {
            String[] line = scanner.next().split("\\.*");
            int charAt = 0;
            while (charAt < line.length) {
                arena[i][charAt] = line[charAt];
                charAt++;
            }
        }

        int xPositionM = 0;
        int xPositionP = 0;
        int yPositionM = 0;
        int yPositionP = 0;

        for (int positionY = 0; positionY < matixDimension; positionY++) {
            for (int positionX = 0; positionX < matixDimension; positionX++) {
                if ("m".equals(arena[positionY][positionX])) {
                    xPositionM = positionX;
                    yPositionM = positionY;
                } else if ("p".equals(arena[positionY][positionX])) {
                    xPositionP = positionX;
                    yPositionP = positionY;

                }

            }
        }

        while (xPositionP != xPositionM || yPositionP != yPositionM) {
            if (xPositionM > xPositionP) {
                System.out.println("LEFT");
                xPositionM--;
            }
            if (xPositionM < xPositionP) {
                System.out.println("RIGHT");
                xPositionM++;
            }


            if (yPositionM > yPositionP) {
                System.out.println("UP");
                yPositionM--;
            }
            if (yPositionM < yPositionP) {
                System.out.println("DOWN");
                yPositionM++;
            }
        }


    }
}
