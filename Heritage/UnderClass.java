package Heritage;

public class UnderClass extends FirstClass {

   UnderClass(){
       super();
   }

   public String validCPF(String cpf){
       
       return null;

   }

    public static void main(String[] args) {
        UnderClass underClass = new UnderClass();

        underClass.setId(3L);

        System.out.println(underClass.getId());
    }
}
