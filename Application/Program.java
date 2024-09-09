package Application;

import java.time.LocalDate;
import java.util.Scanner;

import Entities.AccountDataBase;
import Enum.Status;
import Services.GeneralFunctions;
import Entities.AccPj;
import Entities.AccSalario;
import Entities.AccSaving;
import Entities.AccSpecial;
import Entities.AccUniversitaria;
import Entities.Account;




public class Program {
    
    public static void main(String[] args) throws InterruptedException {
        // Aula 178 - Exercício de fixação - Try/Catch
        Scanner inn = new Scanner (System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("                   Bank Account v 1.0                 ");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

        /* 

         * ----------------------------------------------------------------------------
         *                                VERSÃO 1.0
         * ----------------------------------------------------------------------------
         * 
         * Esta versão, dispõem de apenas UMA CLASSE para executar o programa inteiro,
         * simulando assim, a administração de contas e o uso de contas, por uma
         * mesma interface.
         * 
         * 
         * ----------------------------------------------------------------------------
         *                                VERSÃO 2.0
         * ----------------------------------------------------------------------------
         * 
         * Neste versão, haverá uma separação de CLASSES DE INTERFACE, onde as 
         * operações de ADMINISTRAÇÃO serão operadas EXCLUSIVAMENTE na classe
         * ADMINSTRADOR e o usuário irá manipular exclusivamente a SUA CONTA
         * através da classe USER, operando-a com seu REGISTRO DE CONTA e
         * SENHA DE ACESSO.      
         * 
         * ----------------------------------------------------------------------------
         *                                VERSÃO 3.0
         * ----------------------------------------------------------------------------    
         * 
         * Nesta versão, a CLASSE ADMINISTRADOR, não abrigará TODO O CÓDIGO. Será
         * criada uma SUPER CLASSE ABRI_CONTA que terá como SUBCLASSE os códigos
         * de abertura para cada tipo de conta. O programa principal, chamará apenas
         * a FUNÇÃO ESPECÍFICA para abrir a conta.
         * 
         * Haverá CLASSES separadas para BUSCAR, EDITAR e EXCLUIR as contas. O 
         * programa principal irá chamar FUNÇÕES, não abrigará mais a totalidade
         * do código.
         * 
         */
        
        
        GeneralFunctions function = new GeneralFunctions();
        AccountDataBase listaContas = new AccountDataBase();
        boolean programa =  true;
        int menu;

        while (programa == true){
            
            System.out.println("\n       **********");
            System.out.println("       |  MENU  |");
            System.out.println("       **********\n");
            System.out.print("\n[1] Abrir Conta\n" +
            "[2] Buscar Conta\n" +
            "[3] Editar Conta\n" +
            "[4] Encerrar Conta\n" +
            "[5] Fechar programa");
            menu = function.recebeIntVariavel("\n> ", 1, 5);

            switch (menu) {
                case 1:
    // ABRIR CONTA            
                    
                    System.out.println("\n      ============");
                    System.out.println("      |  CONTAS  |");
                    System.out.println("      ============\n");
                    System.out.println("\nSelecione o tipo de conta:");
                    System.out.print("\n[1] Conta Poupança\n" +
                    "[2] Conta Salário\n" +
                    "[3] Conta Universitária\n" +
                    "[4] Conta física Especial\n" +
                    "[5] Conta Empresa");
                    int conta = function.recebeIntVariavel("\n> ", 1, 5);

                    if (conta == 1){
                        // conta poupança - Registro = 3 dígitos
                        int cadastro = function.addRegistro(3);
                        Account abreSaving = new AccSaving();
                        Double saldo = 5.0;
                        abreSaving.cadEndereco();
                        abreSaving.cadPessoal();
                        LocalDate clienteDesde = LocalDate.now();
                        abreSaving.cadInfo(cadastro, saldo, Status.ATIVO, clienteDesde, "CONTA POUPANÇA");
                        listaContas.addConta(abreSaving);
                        function.pause("Cadastrando", '.', 3, 1000);
                        listaContas.sucesso();
                        

                    } else if (conta == 2){
                        // conta salario  - Registro = 4 dígitos
                        int cadastro = function.addRegistro(4);
                        Account abreSalario = new AccSalario();
                        Double saldo = 5.0;
                        abreSalario.cadEndereco();
                        abreSalario.cadPessoal();
                        LocalDate clienteDesde = LocalDate.now();
                        abreSalario.cadInfo(cadastro, saldo, Status.ATIVO, clienteDesde, "CONTA SALÁRIO");
                        listaContas.addConta(abreSalario);
                        function.pause("\nCadastrando", '.', 3, 1000);
                        listaContas.sucesso();
                        

                    } else if (conta == 3){
                        // conta universitaria  - Registro = 5 dígitos
                        int cadastro = function.addRegistro(5);
                        Account abreUni = new AccUniversitaria();
                        Double saldo = 5.0;
                        abreUni.cadEndereco();
                        abreUni.cadPessoal();
                        LocalDate clienteDesde = LocalDate.now();
                        abreUni.cadInfo(cadastro, saldo, Status.ATIVO, clienteDesde, "CONTA UNIVERSITÁRIA");
                        listaContas.addConta(abreUni);
                        function.pause("\nCadastrando", '.', 3, 1000);
                        listaContas.sucesso();
                        
                    } else if (conta == 4){
                        // conta especial - Registro = 6 dígitos
                        int cadastro = function.addRegistro(6);
                        Account abreEsp = new AccSpecial();
                        System.out.println("\n      ============");
                        System.out.println("      |  ATENÇÃO |");
                        System.out.println("      ============\n");
                        System.out.println("\nConta ESPECIAL precisa de renda\n"+
                        "MÍNIMA no valor de R$ 4.500,00\n");
                        
                        System.out.print("\nDeseja prosseguir?\n"+
                        "\n[1] SIM, abrir conta especial\n"+
                        "[2] NÃO, escolher outro tipo");
                        int prossegue = function.recebeIntVariavel("\n> ", 1, 2);

                        if (prossegue == 1){
                            
                            double saldo = 5.0;
                            abreEsp.cadEndereco();
                            abreEsp.cadPessoal();
                            LocalDate clienteDesde = LocalDate.now();
                            abreEsp.cadInfo(cadastro, saldo, Status.ATIVO, clienteDesde, "CONTA ESPECIAL");
                            listaContas.addConta(abreEsp);
                            function.pause("\nCadastrando", '.', 3, 1000);
                            listaContas.sucesso();
                             
                        } 

                    } else if (conta == 5){
                        // conta empresa  - Registro = 7 dígitos
                        int cadastro = function.addRegistro(7);
                        Account abrePJ = new AccPj();
                        double saldo = 5.0;
                        abrePJ.cadEndereco();
                        abrePJ.cadPessoal();
                        LocalDate clienteDesde = LocalDate.now();
                        abrePJ.cadInfo(cadastro, saldo, Status.ATIVO, clienteDesde, "CONTA EMPRESA");
                        listaContas.addConta(abrePJ);
                        function.pause("\nCadastrando", '.', 3, 1000);
                        listaContas.sucesso();
                    }
                    break;
            
                case 2:
    // BUSCAR CONTA
                    
                    System.out.print("\n\nSelecione: \n"+
                    "\n[1] Busca por registro \n"+
                    "[2] Busca por nome");
                    int op = function.recebeIntVariavel("\n> ", 1, 2);

                    if (op == 1){

                        boolean search = true;
                        while (search == true){
                            op = 0;
                            System.out.print("\nRegistro:");
                            int reg = function.checkInt("Registro");
                            boolean showError = true;
                            for (int i = 0; i < listaContas.getConta().size() ; i++){

                                if (listaContas.getConta().get(i).getRegistro() == reg){
                                    showError = false;
                                    System.out.println(listaContas.getConta().get(i).imprimeDados());

                                    System.out.print("\nSelecione: \n" +
                                    "\n[1] Expandir informações desta conta \n" +
                                    "[2] Buscar um novo registro\n" +
                                    "[3] Voltar ao MENU inicial");
                                    op = function.recebeIntVariavel("\n> ", 1, 3);

                                    if (op == 1) {
                                        System.out.println();
                                        System.out.println(listaContas.getConta().get(i).imprimeDadosFull());
                                        function.waitLine();
                                        function.pause("Retornando ao menu", '.', 3, 600);
                                        System.out.println();
                                        search = false;
                                    } else if (op == 3){
                                        search = false;
                                        break;
                                    } else {
                                        search = true;
                                    }
                    
                                } 
                            }
                            if (showError == true) {
                                function.pause("\nBuscando", '.', 3, 500);
                                System.out.println("\nRegistro não localizado!");
                                op = 0;
                                System.out.println("Selecione: \n"+
                                "\n[1] Buscar novo registro\n"+
                                "[2] Voltar ao MENU\n");
                                op = function.recebeIntVariavel("> ", 1, 2);
                                function.waitLine();
                                if (op == 2){
                                    search = false;
                                    break;
                                } else {
                                    search = true;
                                }
                            }
                        }

                    } else if (op == 2){

                        boolean search = true;
                        while (search == true){
                            op = 0;
                            //System.out.print("\nNome:");
                            String name = function.checkStringMin("\nNome", 3);
                            boolean showError = true;

                            for (int i = 0; i < listaContas.getConta().size() ; i++){

                                if (listaContas.getConta().get(i).getHolder().charAt(0) == name.charAt(0)){
                                    if (listaContas.getConta().get(i).getHolder().charAt(1) == name.charAt(1)){
                                        if (listaContas.getConta().get(i).getHolder().charAt(2) == name.charAt(2)){
                                            showError = false;
                                            System.out.println(listaContas.getConta().get(i).imprimeDados());

                                            System.out.print("\nSelecione: \n" +
                                            "\n[1] Expandir informações deste cliente \n" +
                                            "[2] Buscar um novo cliente\n" +
                                            "[3] Voltar ao MENU inicial\n");
                                            op = function.recebeIntVariavel("> ", 1, 3);

                                            if (op == 1) {
                                                System.out.println();
                                                System.out.println(listaContas.getConta().get(i).imprimeDadosFull());
                                                function.waitLine();
                                                function.pause("Retornando ao menu", '.', 3, 600);
                                                System.out.println();
                                                search = false;
                                            } else if (op == 3){
                                                search = false;
                                                break;
                                            } else {
                                                search = true;
                                            }
                                        } 
                                    }
                                } 
                            }

                            if (showError == true) {
                                function.pause("\nBuscando", '.', 3, 500);
                                System.out.println("\nCliente não localizado!");
                                op = 0;
                                System.out.println("Selecione: \n"+
                                "\n[1] Buscar novo cliente\n"+
                                "[2] Voltar ao MENU\n");
                                op = function.recebeIntVariavel("\n> ", 1, 2);
                                function.waitLine();
                                if (op == 2){
                                    search = false;
                                    break;
                                } else {
                                    search = true;
                                }
                            }
                        }
                    }
                    break;

                case 3:
// EDITAR CONTA
                op = 0;
                System.out.print("\n\nSelecione: \n"+
                "\n[1] Digitar registro \n"+
                "[2] Digitar nome");
                op = function.recebeIntVariavel("\n> ", 1, 2);

                if (op == 1){

                    boolean search = true;
                    while (search == true){
                        op = 0;
                        System.out.print("\nRegistro:");
                        int reg = function.checkInt("Registro");
                        boolean showError = true;
                        for (int i = 0; i < listaContas.getConta().size() ; i++){

                            if (listaContas.getConta().get(i).getRegistro() == reg){
                                showError = false;
                                System.out.println(listaContas.getConta().get(i).imprimeDados());

                                System.out.print("\nSelecione: \n" +
                                "\n[1] Editar endereço\n" +
                                "[2] Editar cadastro pessoal\n" +
                                "[3] Alterar status\n" +
                                "[4] Alterar limites\n" +
                                "[5] Buscar um novo registro\n" +
                                "[6] Voltar ao MENU inicial");
                                op = function.recebeIntVariavel("\n> ", 1, 6);

                                if (op == 1) {
                                    System.out.println();
                                    listaContas.getConta().get(i).alteraEndereco();
                                    System.out.println();
                                    System.out.println(listaContas.getConta().get(i).imprimeDadosFull());
                                    function.waitLine();
                                    function.pause("Gravando dados", '.', 3, 600);
                                    System.out.println();
                                    search = false;
                                    break;
                                } else if (op == 2){
                                    System.out.println();
                                    listaContas.getConta().get(i).alteraCadPessoal();
                                    System.out.println();
                                    System.out.println(listaContas.getConta().get(i).imprimeDadosFull());
                                    function.waitLine();
                                    function.pause("Gravando dados", '.', 3, 600);
                                    System.out.println();
                                    search = false;
                                    break;
                                } else if (op == 3){
                                    System.out.println();
                                    listaContas.getConta().get(i).alteraStatus();
                                    System.out.println();
                                    System.out.println(listaContas.getConta().get(i).imprimeDados());
                                    function.waitLine();
                                    function.pause("Gravando dados", '.', 3, 600);
                                    System.out.println();
                                    search = false;
                                    break;

                                } else if (op == 4){
                                // Dígitos 7 (9999999), 6 (999999), 5 (99999) > 10000

                                    if(reg > 9999){
                                        System.out.println();
                                        listaContas.getConta().get(i).limite();
                                        System.out.println();
                                        System.out.println(listaContas.getConta().get(i).imprimeDados());
                                        function.waitLine();
                                        function.pause("Gravando dados", '.', 3, 600);
                                        System.out.println();
                                    } else {
                                        System.out.println("\n### ERROR ###\n"+
                                                           "Esta conta não possui cheque\n"+
                                                           "especial!\n");
                                                        
                                    }
                                    search = false;
                                    break;
                                } else if (op == 5){
                                    search = true;
                                } else {
                                    search = false;
                                    break;
                                }
                            } 
                        }
                        if (showError == true) {
                            function.pause("\nBuscando", '.', 3, 500);
                            System.out.println("\nRegistro não localizado!");
                            op = 0;
                            System.out.println("Selecione: \n"+
                            "\n[1] Buscar novo registro\n"+
                            "[2] Voltar ao MENU\n");
                            op = function.recebeIntVariavel("> ", 1, 2);
                            function.waitLine();
                            if (op == 2){
                                search = false;
                                break;
                            } else {
                                search = true;
                            }
                        }
                    }

                } else if (op == 2){

                    boolean search = true;
                    while (search == true){
                        op = 0;
                        //System.out.print("\nNome:");
                        String name = function.checkStringMin("\nNome", 3);
                        boolean showError = true;

                        for (int i = 0; i < listaContas.getConta().size() ; i++){

                            if (listaContas.getConta().get(i).getHolder().charAt(0) == name.charAt(0)){
                                if (listaContas.getConta().get(i).getHolder().charAt(1) == name.charAt(1)){
                                    if (listaContas.getConta().get(i).getHolder().charAt(2) == name.charAt(2)){
                                        showError = false;
                                        System.out.println(listaContas.getConta().get(i).imprimeDados());

                                        System.out.print("\nSelecione: \n" +
                                        "\n[1] Editar endereço\n" +
                                        "[2] Editar cadastro pessoal\n" +
                                        "[3] Alterar status\n" +
                                        "[4] Alterar limites\n" +
                                        "[5] Buscar um novo registro\n" +
                                        "[6] Voltar ao MENU inicial");
                                        op = function.recebeIntVariavel("\n> ", 1, 6);

                                        if (op == 1) {
                                            System.out.println();
                                            listaContas.getConta().get(i).alteraEndereco();
                                            System.out.println();
                                            System.out.println(listaContas.getConta().get(i).imprimeDadosFull());
                                            function.waitLine();
                                            function.pause("Gravando dados", '.', 3, 600);
                                            System.out.println();
                                            search = false;
                                            break;
                                        } else if (op == 2){
                                            search = false;
                                            System.out.println();
                                            listaContas.getConta().get(i).alteraCadPessoal();
                                            System.out.println();
                                            System.out.println(listaContas.getConta().get(i).imprimeDadosFull());
                                            function.waitLine();
                                            function.pause("Gravando dados", '.', 3, 600);
                                            System.out.println();
                                            search = false;
                                            break;
                                        } else if (op == 3){
                                            System.out.println();
                                            listaContas.getConta().get(i).alteraStatus();
                                            System.out.println();
                                            System.out.println(listaContas.getConta().get(i).imprimeDados());
                                            function.waitLine();
                                            function.pause("Gravando dados", '.', 3, 600);
                                            System.out.println();
                                            search = false;
                                            break;
                                        } else if (op == 4){
                                        // Dígitos 7 (9999999), 6 (999999), 5 (99999) > 10000

                                            if(listaContas.getConta().get(i).getRegistro() > 9999){
                                                System.out.println();
                                                listaContas.getConta().get(i).limite();
                                                System.out.println();
                                                System.out.println(listaContas.getConta().get(i).imprimeDados());
                                                function.waitLine();
                                                function.pause("Gravando dados", '.', 3, 600);
                                                System.out.println();

                                            } else {
                                                System.out.println("\n### ERROR ###\n"+
                                                                "Esta conta não possui cheque\n"+
                                                                "especial!\n");
                                            }
                                            search = false;
                                            break;
                                        } else if (op == 5){
                                            search = true;
                                        } else {
                                            search = false;
                                            break;
                                        }
                                    } 
                                }
                            } 
                        }

                        if (showError == true) {
                            function.pause("\nBuscando", '.', 3, 500);
                            System.out.println("\nCliente não localizado!");
                            op = 0;
                            System.out.println("\nSelecione: \n"+
                            "\n[1] Buscar novo cliente\n"+
                            "[2] Voltar ao MENU");
                            op = function.recebeIntVariavel("\n> ", 1, 2);
                            function.waitLine();
                            if (op == 2){
                                search = false;
                                break;
                            } else {
                                search = true;
                            }
                        }
                    }
                }
                break;

                case 4:
    // ENCERRAR CONTA
                op = 0;
                System.out.print("\n\nSelecione: \n"+
                "\n[1] Digitar registro \n"+
                "[2] Buscar registro por nome\n");
                op = function.recebeIntVariavel("\n> ", 1, 2);
                boolean excluir = true;
                
                while (excluir == true){

                    if (op == 1){

                        boolean search = true;

                        while (search == true){
                            op = 0;
                            System.out.print("\nRegistro:");
                            int reg = function.checkInt("Registro");
                            boolean showError = true;
                            for (int i = 0; i < listaContas.getConta().size() ; i++){

                                if (listaContas.getConta().get(i).getRegistro() == reg){
                                    showError = false;
                                    
                                    System.out.println(listaContas.getConta().get(i).imprimeDados());

                                    System.out.print("\nSelecione: \n" +
                                    "[1] Encerrar esta conta\n" +
                                    "[2] Buscar um novo registro\n" +
                                    "[3] Voltar ao MENU inicial\n");
                                    op = function.recebeIntVariavel("\n> ", 1, 3);

                                    if (op == 1) {
                                        System.out.println();
                                        listaContas.getConta().get(i).excluirConta();
                                        function.pause("Encerrando conta", '.', 3, 600);
                                        function.waitLine();
                                        excluir = false;

                                    } else if (op == 2){
                                        search = true;

                                    } else if (op == 3){
                                        search = false;
                                        excluir = false;
                                        break;
                                    }
                    
                                } 
                            }
                            if (showError == true) {
                                function.pause("\nBuscando", '.', 3, 500);
                                System.out.println("\nRegistro não localizado!");
                                op = 0;
                                System.out.println("Selecione: \n"+
                                "\n[1] Buscar novo registro\n"+
                                "[2] Voltar ao MENU\n");
                                op = function.recebeIntVariavel("\n> ", 1, 2);
                                function.waitLine();
                                if (op == 2){
                                    search = false;
                                    excluir = false;
                                    break;
                                }
                            }
                        }

                    } else if (op == 2){

                        boolean search = true;
                        while (search == true){
                            op = 0;
                            
                            String name = function.checkStringMin("\nNome", 3);
                            boolean showError = true;

                            for (int i = 0; i < listaContas.getConta().size() ; i++){

                                if (listaContas.getConta().get(i).getHolder().charAt(0) == name.charAt(0)){
                                    if (listaContas.getConta().get(i).getHolder().charAt(1) == name.charAt(1)){
                                        if (listaContas.getConta().get(i).getHolder().charAt(2) == name.charAt(2)){
                                            showError = false;

                                            System.out.println(listaContas.getConta().get(i).imprimeDados());

                                            System.out.print("\nSelecione: \n" +
                                            "\n[1] Encerrar esta conta\n" +
                                            "[2] Buscar novo cliente\n" +
                                            "[3] Voltar ao MENU inicial");
                                            op = function.recebeIntVariavel("\n> ", 1, 3);

                                            if (op == 1) {
                                                System.out.println();
                                                listaContas.getConta().get(i).excluirConta();
                                                function.pause("Encerrando conta", '.', 3, 600);
                                                function.waitLine();
                                                search = false;
                                                excluir = false;
                                                break;

                                            } else if (op == 2){
                                                search = true;

                                            } else if (op == 3){
                                                search = false;
                                                excluir = false;
                                                break;
                                            }
                                        } 
                                    }
                                } 
                            }

                            if (showError == true) {
                                function.pause("\nBuscando", '.', 3, 500);
                                System.out.println("\nCliente não localizado!");
                                op = 0;
                                System.out.println("\nSelecione: \n"+
                                "\n[1] Buscar novo cliente\n"+
                                "[2] Voltar ao MENU");
                                op = function.recebeIntVariavel("\n> ", 1, 2);
                                function.waitLine();
                                if (op == 2){
                                    search = false;
                                    excluir = false;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;

                case 5:
   // ENCERRAR PROGRAMA
                programa = false;
                break;
            }
        }
        System.out.println("\n\n**********************");
        System.out.println(" >>> VOLTE SEMPRE <<< ");
        System.out.println("**********************\n\n");
        inn.close();
    }
 
}
