package Entities;

import java.time.LocalDate;

import Enum.Status;

public class AccPj extends Account {

     // CONTA EMPRESA = PESSOA JURÍDICA

    private String cnpj;

    private Double capital;

    private Double loanLimit;

    private Double specialLimit;




    public AccPj() {
        super();
    }


    


    public String getCnpj() {
        return cnpj;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public Double getCapital(){
        return capital;
    }

    public Double getSpecialLimit() {
        return specialLimit;
    }



    public void loan (Double amount){

        if (amount < loanLimit){
            loanLimit = loanLimit - amount;
            balance = balance + amount;
        }
    }

    @Override
    public void withdraw (Double amount){

        if (checkStatus() == true){
            if (balance - amount > specialLimit){
                balance = balance - amount;
            } else {
                System.out.println("OPERAÇÃO NÃO REALIZADA! \nNão há limite para saque!");
            }
        } else {
                System.out.println("\n### Conta BLOQUEADA! ###\nEntre em contato com a\ngerência.");
        }
    }

    @Override
    public void limite(){

        System.out.print("\nSelecione para editar: \n" +
        "\n[1] Capital \n" +
        "[2] Empréstimo\n" +
        "[3] Cheque Especial"); 
        
        int op = function.recebeIntVariavel("\n> ", 1, 3);

        Double valor = 0.0;

        if (op == 1){
            System.out.print("Capital: ");
            valor = function.checkDouble("Capital");
            this.capital = valor;
            this.loanLimit = capital * 0.25;
            this.specialLimit = capital * 0.35;

        } else if (op == 2){
            System.out.print("Empréstimo: ");
            valor = function.checkDouble("Empréstimo");
            this.loanLimit = valor;

        } else if (op == 3){
            System.out.print("Cheque Especial: ");
            valor = function.checkDouble("Cheque Especial");
            this.specialLimit = valor;
        }

    }

    @Override
    public void cadPessoal(){

        System.out.println("\n      ==================");
        System.out.println("      |  CONTA EMPRESA |");
        System.out.println("      ==================\n");

        String holder = function.checkStringMin("Empresa", 3);
        this.holder = holder;
        String phone = function.checkStringMinMax("Telefone (XX) XXXXX-XXXX",11, 15);
        this.phone = phone;
        String cnpj = function.checkStringMinMax("CNPJ 00.000.000/0000-00", 14, 18);
        this.cnpj = cnpj;
        System.out.print("\nCapital (R$): ");
        Double capital = function.checkDouble("Capital");
        this.capital = capital;
        this.loanLimit = capital * 0.25;
        this.specialLimit = capital * 0.35;

    }

    @Override
    public void alteraCadPessoal () {

        System.out.println("\n      ==================");
        System.out.println("      |  CONTA EMPRESA |");
        System.out.println("      ==================\n");

        System.out.print("\nSelecione para editar: \n" +
        "\n[1] Nome \n" +
        "[2] Telefone\n" +
        "[3] CNPJ\n"); 
        
        int op = function.recebeIntVariavel("\n> ", 1, 3);

        if (op == 1){
            String holder = function.checkStringMin("Empresa", 3);
            this.holder = holder;
            

        } else if (op == 2){
            String phone = function.checkStringMinMax("Telefone (XX) XXXXX-XXXX",11, 15);
            this.phone = phone;

        } else if (op == 3){
            String cnpj = function.checkStringMinMax("CNPJ 00.000.000/0000-00", 14, 18);
            this.cnpj = cnpj;

        } 
    }
    
    @Override
    public String imprimeDados(){
        
        StringBuilder pressIt = new StringBuilder();
                             
        pressIt.append("\n-------------------------------------");
        pressIt.append("\nSTATUS: " + getStatus());
        if (getObservacao() != null){
            pressIt.append("\n-------------------------------------");
            pressIt.append("\nOBSERVAÇÃO: " + getObservacao());
            pressIt.append("\nStatus alterado em: " + getAlteraStatus().format(dataOut));
        }
        pressIt.append("\n-------------------------------------");
        pressIt.append("\nRegistro Nº: " + getRegistro());
        pressIt.append("\nModalidade: " + getModalidade());
        pressIt.append("\n-------------------------------------");
        pressIt.append("\nNome: " + getHolder().toUpperCase());
        pressIt.append("\nCapital: " + String.format("%.2f", getCapital()));
        pressIt.append("\nSaldo: " + String.format("%.2f", getBalance()));
        pressIt.append("\nLimite Especial: " + String.format("%.2f", getSpecialLimit()));
        pressIt.append("\nLimite Empréstimo: " + String.format("%.2f", getLoanLimit()));
        pressIt.append("\n-------------------------------------");
        pressIt.append("\nCliente desde: " + getClienteDesde().format(dataOut));
        pressIt.append("\n-------------------------------------\n");

        return pressIt.toString();
    }

    @Override
     public void excluirConta(){
        this.balance = 0.0;
        this.capital = 0.0;
        this.loanLimit = 0.0;
        this.specialLimit = 0.0;
        this.status = Status.ENCERRADA;
        this.alteraStatus = LocalDate.now();
        System.out.print("\nDeseja acrescentar informações a esta operação? \n" +
        "\n[1] Sim \n" +
        "[2] Não"); 
        
        int op = function.recebeIntVariavel("\n> ", 1, 2);

        if (op == 1){
            System.out.print("\nDetalhamento sobre encerramento de conta: ");
            String observacao = inn.nextLine();
            this.observacao = observacao;
        }
        
    }
    
}
