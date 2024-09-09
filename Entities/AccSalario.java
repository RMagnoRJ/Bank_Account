package Entities;

public class AccSalario extends Account {
    
    private String cpf;
    private Double renda;
    private String ocupacao;
    private String empresa;
    
    
    public AccSalario() {
        super();
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
        System.out.println("      |  CONTA SALÁRIO |");
        System.out.println("      ==================\n");
        
        
        String ocupacao = function.checkStringMin("Profissão/Cargo", 3);
        this.ocupacao = ocupacao;
        System.out.print("Renda:");
        double renda = function.checkDouble("Renda");
        this.renda = renda;
        String empresa = function.checkStringMin("Empresa", 3);
        this.empresa = empresa;

    }


    @Override
    public void alteraCadPessoal () {
        System.out.println("\n      ============");
        System.out.println("      |  PESSOAL |");
        System.out.println("      ============\n");

        System.out.print("\nSelecione para editar: \n" +
        "\n[1] Nome \n" +
        "[2] Telefone \n" +
        "[3] CPF \n" +
        "[4] Profissão/Cargo \n" +
        "[5] Renda \n" +
        "[6] Empresa\n");
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
            System.out.print("\nProfissão/Cargo: ");
            String ocupacao = function.checkStringMin("Profissão/Cargo", 3);
            this.ocupacao = ocupacao;

        } else if (op == 5){
            System.out.print("\nRenda:");
            double renda = function.checkDouble("Renda");
            this.renda = renda;

        } else if (op == 6){
            System.out.print("\nEmpresa: ");
            String empresa = inn.nextLine();
            this.empresa = empresa;
        }
    }
    
}
