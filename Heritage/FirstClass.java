package Heritage;

 abstract class FirstClass {

    protected Long id;

    protected String name;

    protected String cpf;


     public void setId(Long id) {
         this.id = id;
     }

     public Long getId() {
         return id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getCpf() {
         return cpf;
     }

     public void setCpf(String cpf) {
         this.cpf = cpf;
     }
 }
