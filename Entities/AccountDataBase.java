package Entities;

import java.util.ArrayList;
import java.util.List;

import Services.GeneralFunctions;

public class AccountDataBase {
    
     private List <Account> listaContas = new ArrayList<>();

    GeneralFunctions function = new GeneralFunctions();

    public AccountDataBase() {
    }

    public List<Account> getConta() {
        return listaContas;
    }
    
    public void addConta(Account conta){
        listaContas.add(conta);
    }
        
    public void sucesso(){

        System.out.println("\n\nOperação realizada com sucesso!");
        System.out.println("\nRegistro: " + listaContas.getLast().registro); 
        System.out.println("Cliente: " +listaContas.getLast().holder.toUpperCase());
        System.out.println("Status: " +listaContas.getLast().status);
        function.waitLine();

    }

}
