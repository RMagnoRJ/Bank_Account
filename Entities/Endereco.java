package Entities;

import java.util.Scanner;
import Services.GeneralFunctions;

public class Endereco {
    
     GeneralFunctions function = new GeneralFunctions();

    Scanner inn = new Scanner (System.in);
    
    protected String logradouro;

    protected String numero;

    protected String complemento;

    protected String bairro;

    protected String cidade;

    protected String estado;

    protected String cep;


    public Endereco() {
    }


    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public void cadEndereco(){

        System.out.println("\n      =============");
        System.out.println("      |  ENDEREÇO |");
        System.out.println("      =============\n");

        System.out.print("\n    # ENDEREÇO #\n\nLogradouro: ");
        String logradouro = inn.nextLine();
        this.logradouro = logradouro;
        System.out.print("Número: ");
        String numero = inn.nextLine();
        this.numero = numero;
        System.out.print("Complemento: ");
        String complemento = inn.nextLine();
        this.complemento = complemento;
        System.out.print("Bairro: ");
        String bairro = inn.nextLine();
        this.bairro = bairro;
        System.out.print("Cidade: ");
        String cidade = inn.nextLine();
        this.cidade = cidade;
        //System.out.print("Estado: ");
        String estado = function.checkStringMinMax("Estado", 2, 2);
        this.estado = estado;
        //System.out.print("CEP: ");
        String cep = function.checkStringMinMax("CEP", 8, 9);
        this.cep = cep;
        
    }

    public void alteraEndereco(){

        System.out.println("\n      =============");
        System.out.println("      |  ENDEREÇO |");
        System.out.println("      =============\n");

        boolean alterar = true;

        while (alterar == true){

            System.out.print("\nSelecione para editar: \n" +
            "\n[1] Logradouro \n" +
            "[2] Número\n" +
            "[3] Complemento\n" +
            "[4] Bairro\n" +
            "[5] Cidade\n" +
            "[6] Estado\n" +
            "[7] CEP\n"); 
            
            int op = function.recebeIntVariavel("\n> ", 1, 8);
    
            if (op == 1){
                System.out.print("Logradouro: ");
                String logradouro = inn.nextLine();
                this.logradouro = logradouro;
                alterar = false;
    
            } else if (op == 2){
                System.out.print("Número: ");
                String numero = inn.nextLine();
                this.numero = numero;
                alterar = false;
    
            } else if (op == 3){
                System.out.print("Complemento: ");
                String complemento = inn.nextLine();
                this.complemento = complemento;
                alterar = false;
    
            } else if (op == 4){
                System.out.print("Bairro: ");
                String bairro = inn.nextLine();
                this.bairro = bairro;
                alterar = false;
    
            } else if (op == 5){
                System.out.print("Cidade: ");
                String cidade = inn.nextLine();
                this.cidade = cidade;
                alterar = false;
    
            } else if (op == 6){
                String estado = function.checkStringMinMax("Estado", 2, 2);
                this.estado = estado;
                alterar = false;
    
            } else if (op == 7){
                String cep = function.checkStringMinMax("CEP", 8, 9);
                this.cep = cep;
                alterar = false;
    
            } 
        }
    }

}
