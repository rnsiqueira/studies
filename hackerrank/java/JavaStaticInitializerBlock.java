package hackerrank.java;

import java.util.Scanner;

public class JavaStaticInitializerBlock {
    static Scanner scan = new Scanner("-1\n" +
            "3");
    static int B = scan.nextInt();
    static int H = scan.nextInt();
    static boolean flag = true;

    static {
        try {
            if (B <= 0 || H <= 0) {
                flag = false;
                throw new Exception("Breadth and height must be positive");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        if (flag) {

            int area = B * H;
            System.out.println(area);

        }


    }
}
