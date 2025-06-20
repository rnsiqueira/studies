package java18;

public class Outer {

    //Large array
    private int[] data;

    private void processData(){
        //Do something with data
    }

    class Inner{
        //Does not access anything in the outer instance.
    }

    public static void main(String[] args) {
        Outer outer= new Outer();
        Inner inner = outer.new Inner();
    }
}
