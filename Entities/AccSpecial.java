package Entities;

import java.time.LocalDate;

import Enum.Status;

public class AccSpecial extends Account {
     
    private String cpf;
    private Double renda;
    private String ocupacao;
    private String empresa;
    private Double specialLimit;



    public AccSpecial() {
        super();
    }

    

    public Double getSpecialLimit() {
        return specialLimit;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getRenda() {
        return renda;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public String getEmpresa() {
        return empresa;
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


    public Double checkRenda (Double renda) {
        
        Double rendaCheck = renda;
        while (rendaCheck < 4500.00){
            System.out.println("\nRenda inferior ao mínimo\n"+
                                 "      ### ERROR ###     \n"+ 
                                 "   Operação CANCELADA!  ");
            rendaCheck = function.checkDouble("Renda");
        }
        return rendaCheck;
        
    }

    @Override
    public void limite(){
        System.out.print("\nLimite especial (R$): ");
        double valor = function.checkDouble("Limite especial");
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
    

        System.out.println("\n      ==================");
        System.out.println("      |  CONTA ESPECIAL |");
        System.out.println("      ==================\n");
        
        String empresa = function.checkStringMin("Empresa", 3);
        this.empresa = empresa;
        String ocupacao = function.checkStringMin("Profissão/Cargo", 3);
        this.ocupacao = ocupacao;
        System.out.print("Renda:");
        double renda = function.checkDouble("Renda");
        checkRenda(renda);
        this.renda = renda;
        this.specialLimit = renda * 0.40;

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
        "[4] Empresa \n" +
        "[5] Profissão/Cargo \n" +
        "[6] Renda \n");
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
            System.out.print("\nEmpresa: ");
            String empresa = inn.nextLine();
            this.empresa = empresa;

        } else if (op == 5){
            System.out.print("\nProfissão/Cargo: ");
            String ocupacao = function.checkStringMin("Profissão/Cargo", 3);
            this.ocupacao = ocupacao;

        } else if (op == 6){
            System.out.print("\nRenda:");
            double renda = function.checkDouble("Renda");
            checkRenda(renda);
            this.renda = renda;
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
        pressIt.append("\nRenda: " + String.format("%.2f", getRenda()));
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
        this.renda = 0.0;
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
