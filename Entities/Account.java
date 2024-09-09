package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Enum.Status;

public class Account extends Endereco {
    
       //SUPER CLASSE
    
    protected Integer registro;

    protected String modalidade;

    protected String holder;

    protected Double balance;

    protected String phone;

    protected Status status;

    protected LocalDate alteraStatus;

    protected String observacao = null;

    protected LocalDate clienteDesde;

    protected DateTimeFormatter dataOut = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 

    
    public Account() {
        super();
    }



    public Integer getRegistro() {
        return registro;
    }

    public String getHolder() {
        return holder;
    }
   
    public Double getBalance() {
        return balance;
    }
 
    public String getPhone() {
        return phone;
    }

    public Status getStatus() {
        return status;
    }

    public String getModalidade(){
        return modalidade;
    }

    public LocalDate getClienteDesde() {
        return clienteDesde;
    }

    public String getObservacao(){
        return observacao;
    }

    public LocalDate getAlteraStatus(){
        return alteraStatus;
    }


    public void deposit (Double amount){

        if (checkStatus() == true){
            balance = balance + amount;
        } else {
            System.out.println("\n### Conta BLOQUEADA! ###\nEntre em contato com a\ngerência.");
        }    
        
    }

    public boolean checkStatus(){

        boolean check = true;

        if (status == Status.BLOQUEADO || status == Status.TRANSFERIDO || status == Status.ENCERRADA){
            check = false;
        } else {
            check = true;
        }

        return check;
    }


    public void withdraw(Double amount){

        if (checkStatus() == true){
            if (amount < balance){
                balance = balance - amount;
            } else {
                System.out.println("Você não tem limite!");
            }
        } else {
            System.out.println("\n### Conta BLOQUEADA! ###\nEntre em contato com a\ngerência.");
        }

    }

    public void cadInfo (Integer registro, Double balance, Status status, LocalDate clienteDesde, String modalidade){
        
        this.registro = registro;
        this.balance = balance;
        this.status = status;
        this.clienteDesde = clienteDesde;
        this.modalidade = modalidade;
    }

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
        pressIt.append("\nSaldo: " + String.format("%.2f", getBalance()));
        pressIt.append("\n-------------------------------------");
        pressIt.append("\nCliente desde: " + getClienteDesde().format(dataOut));
        pressIt.append("\n-------------------------------------\n");

        return pressIt.toString();

    }
    
    public String imprimeDadosFull(){

        StringBuilder pressIt = new StringBuilder();

        pressIt.append("\n-------------------------------------");
        pressIt.append("\n               ENDEREÇO              ");
        pressIt.append("\n-------------------------------------");
        pressIt.append("\nLogradouro: " + getLogradouro().toUpperCase());
        pressIt.append("\nNúmero: " + getNumero());
        pressIt.append("\nComplemento: " + getComplemento().toUpperCase());
        pressIt.append("\nBairro: " + getBairro().toUpperCase());
        pressIt.append("\nCidade: " + getCidade().toUpperCase());
        pressIt.append("\nEstado: " + getEstado().toUpperCase());
        pressIt.append("\nCEP: " + getCep());
        pressIt.append("\n-------------------------------------\n");

        return pressIt.toString();
    }

    public void cadPessoal(){

        System.out.println("\n      ============");
        System.out.println("      |  PESSOAL |");
        System.out.println("      ============\n");
    }

    public void alteraStatus(){
        System.out.println("\nSelecione o status desejado: \n"+
        "\n[1] ATIVO \n" +
        "[2] TRANSFERIDO\n" +
        "[3] BLOQUEADO");
        int newStatus = function.recebeIntVariavel("\n> ", 1,3);

        if (newStatus == 1){
            this.status = Status.ATIVO;
            System.out.print("\nDetalhamento sobre ativação de conta: ");
            String observacao = inn.nextLine();
            this.observacao = observacao;
            this.alteraStatus = LocalDate.now();

        } else if (newStatus == 2){
            this.status = Status.TRANSFERIDO;
            System.out.print("\nDetalhamento sobre transferência de conta: ");
            String observacao = inn.nextLine();
            this.observacao = observacao;
            this.alteraStatus = LocalDate.now();

        } else if (newStatus == 3){
            this.status = Status.BLOQUEADO;
            System.out.print("\nDetalhamento sobre bloqueio de conta: ");
            String observacao = inn.nextLine();
            this.observacao = observacao;
            this.alteraStatus = LocalDate.now();
        }  
    }

    public void alteraCadPessoal () {

        System.out.println("\n      ============");
        System.out.println("      |  PESSOAL |");
        System.out.println("      ============\n");
        
    }

    public void limite(){

    }

    public void excluirConta(){
        this.balance = 0.0;
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
