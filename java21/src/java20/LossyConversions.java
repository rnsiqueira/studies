package java20;



/**
 * Shows examples of lossy conversions.
 */
public class LossyConversions {

    public static void main(String[] args) {

        int k = 25;
        k+= 25; // 50
        System.out.println(k);

        //double data to short data conversion
        doubleToShortExample();

        // integer data to byte data conversion
        intToByteExample();

        // double data to long data conversion
        doubleToLongExample();

        // long data to integer data conversion
        //longToIntExample();
    }

    private static void doubleToShortExample() {
        short x = 3;
        //x = x + 4.6; // Compiler error
        x+=4.6 ;     // No compiler error, 7.6 ?
        System.out.println(x); // 7
    }

    private static void longToIntExample() {
        int wordCount = getInternalWordCount();
        //int wordCount = getInternalWordCount() + getExternalWordCount(); //Compiler error
        //wordCount +=getExternalWordCount(); // No compiler error,compound assignment
        System.out.println("WordCount : " + wordCount);
    }

    private static void doubleToLongExample() {
        long b = 1L;
        //long b = 1L + 0.1 * 5L; //Compiler error
        b += 0.1 * 5L;  // No compiler error,compound assignment
        System.out.println("doubleToLong: " + b); //Expected 1.5
    }

    private static void intToByteExample() {
        byte b = 127;
        //b =  b + 128; //Compiler error
        b += 128; // No compiler error
        System.out.println("intToByte: " + b); // -128
    }

    private static long getExternalWordCount(){
        return 3000000000L;
    }

    private static int getInternalWordCount(){
        return 1000000000;
    }
}
