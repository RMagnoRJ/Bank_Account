package Entities;

import java.time.LocalDate;

import Enum.Status;

public class AccUniversitaria extends Account {
    
    private String cpf;
    private String curso;
    private String anoConclusao;
    private String universidade;
    private Double specialLimit;
    


    public AccUniversitaria() {
        super();
    }





    public String getCpf() {
        return cpf;
    }

    public String getCurso() {
        return curso;
    }

    public String getAnoConclusao() {
        return anoConclusao;
    }

    public String getUniversidade() {
        return universidade;
    }

    public Double getSpecialLimit() {
        return specialLimit;
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
        System.out.print("\nValor (R$): ");
        double valor = function.checkDouble("Valor");
        this.specialLimit = valor;
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

        System.out.println("\n      ========================");
        System.out.println("      |  CONTA UNIVERSITÁRIA |");
        System.out.println("      ========================\n");
        
        String curso = function.checkStringMin("Curso", 3);
        this.curso = curso;
        String anoConclusao = function.checkStringMinMax("Ano de conclusão", 2, 4);
        this.anoConclusao = anoConclusao;
        String universidade = function.checkStringMin("Universidade", 3);
        this.universidade = universidade;
        this.specialLimit = 400.0;

    }

    @Override
    public void alteraCadPessoal () {
        System.out.println("\n      ============");
        System.out.println("      |  PESSOAL |");
        System.out.println("      ============\n");

        System.out.print("\nSelecione para editar: \n" +
        "\n[1] Nome \n" +
        "[2] Telefone \n" +
        "[3] CPF\n" +
        "[4] Curso \n" +
        "[5] Ano de conclusão \n" +
        "[6] Universidade \n");
        int op = function.recebeIntVariavel("\n> ", 1, 6);

        if (op == 1){
            String holder = function.checkStringMin("Nome", 3);
            this.holder = holder;

        } else if (op == 2){
            String phone = function.checkStringMinMax("Telefone (XX) XXXXX-XXXX",11, 15);
            this.phone = phone;

        } else if (op == 3){
            String cpf = function.checkStringMinMax("CPF XXX.XXX.XXX-XX", 11, 14);
            this.cpf = cpf;

        } else if (op == 4){
            System.out.print("\nCurso: ");
            String curso = inn.nextLine();
            this.curso = curso;

        } else if (op == 5){
            String anoConclusao = function.checkStringMinMax("Ano de conclusão: ", 2, 4);
            this.anoConclusao = anoConclusao;

        } else if (op == 6){
            System.out.print("Universidade: ");
            String universidade = inn.nextLine();
            this.universidade = universidade;
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
        pressIt.append("\nSaldo: " + String.format("%.2f", getBalance()));
        pressIt.append("\nLimite Especial: " + String.format("%.2f", getSpecialLimit()));
        pressIt.append("\n-------------------------------------");
        pressIt.append("\nCliente desde: " + getClienteDesde().format(dataOut));
        pressIt.append("\n-------------------------------------\n");

        return pressIt.toString();
    }

    @Override
    public void excluirConta(){
        this.balance = 0.0;
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
