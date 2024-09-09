package Entities;

public class AccSaving extends Account {

     // CONTA POUPANÇA

     private String cpf;

    
   
     public AccSaving() {
         super();
     }
 
 
 
     public String getCpf(){
         return cpf;
     }
     
     public void interest (Double rate){
         balance = balance * rate;
     }
 
     @Override
     public void cadPessoal(){
 
         System.out.println("\n      ============");
         System.out.println("      |  PESSOAL |");
         System.out.println("      ============\n");
 
         String holder = function.checkStringMin("Nome", 3);
         this.holder = holder;
         String phone = function.checkStringMinMax("Telefone (XX) XXXXX-XXXX",11, 15);
         this.phone = phone;
         String cpf = function.checkStringMinMax("CPF XXX.XXX.XXX-XX", 11, 14);
         this.cpf = cpf;
 
         System.out.println("\n      =============");
         System.out.println("      |  POUPANÇA |");
         System.out.println("      =============\n");
 
     }
 
     @Override
     public void alteraCadPessoal () {
         
         System.out.println("\n      ============");
         System.out.println("      |  PESSOAL |");
         System.out.println("      ============\n");
 
         System.out.print("\nSelecione para editar: \n" +
         "\n[1] Nome \n" +
         "[2] Telefone \n" +
         "[3] CPF\n");
         int op = function.recebeIntVariavel("\n> ", 1, 3);
 
         if (op == 1){
             String holder = function.checkStringMin("Nome", 3);
             this.holder = holder;
 
         } else if (op == 2){
             String phone = function.checkStringMinMax("Telefone (XX) XXXXX-XXXX",11, 15);
             this.phone = phone;
 
         } else if (op == 3){
             String cpf = function.checkStringMinMax("CPF XXX.XXX.XXX-XX", 11, 14);
             this.cpf = cpf;
 
         } 
     }
    
}
