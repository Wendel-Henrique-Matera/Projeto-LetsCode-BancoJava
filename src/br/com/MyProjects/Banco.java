package br.com.MyProjects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Banco extends Contas {

    String nome;
    String endereco;
    String CPF;
    String CNPJ;
    int idade;
    int conta;
    int tipoDeConta;
    int agencia;
    int numeroDaConta;
    int digitoConta;
    int dadosAgencia;
    int dadosNumeroConta;
    int dadosDigitoConta;
    BigDecimal saldo;
    Cliente cliente;

    List<Contas> contasList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    Contas pesquisa = new Contas();

    void abrirConta() throws ClientePJContaPoupancaException, ClienteInseriuNumeroInvalidoException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe qual tipo de pessoa você é, sendo que:");
        System.out.println("""
                1 - Pessoa Física
                2 - Pessoa Jurídica
                \n""");

        System.out.print("Conta: ");
        conta = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: \n");
        nome = scanner.nextLine();
        System.out.print("endereço: \n");
        endereco = scanner.nextLine();

        if(conta == 1){
            System.out.print("CPF: \n");
            CPF = scanner.nextLine();
            System.out.print("Idade: \n");
            idade = scanner.nextInt();
            ClientePessoaFisica cliente = new ClientePessoaFisica(nome, endereco, CPF, idade);
            System.out.println("""
                    Defina o tipo de conta que você deseja, sendo que:
                    1 - Conta Corrente
                    2 - Conta Investimento
                    3 - Conta Poupanca
                    """);
            tipoDeConta = scanner.nextInt();
            criarConta(cliente, tipoDeConta);

        }
        else if (conta == 2){
            System.out.println("CNPJ: \n");
            CNPJ = scanner.nextLine();
            ClientePessoaJuridica cliente = new ClientePessoaJuridica(nome, endereco, CNPJ);
            System.out.println("""
                    Defina o tipo de conta que você deseja, sendo que:
                    1 - Conta Corrente
                    2 - Conta Investimento
                    """);
            tipoDeConta = scanner.nextInt();
            criarConta(cliente, tipoDeConta);
        }

    }

        Contas acessarConta(Contas contaAtual) throws ContaInexistenteException {

        dadosAgencia = 0;
        dadosNumeroConta = 0;
        dadosDigitoConta = 0;

        System.out.println("Digite os dados de sua conta: ");
        System.out.print("Agencia: ");
        dadosAgencia = scanner.nextInt();
        System.out.print("Número da Conta: ");
        dadosNumeroConta = scanner.nextInt();
        System.out.print("Dígito da Conta: ");
        dadosDigitoConta = scanner.nextInt();

        int i = 0;
        int verificador = 0;

        Contas pesquisa = contasList.get(i);

        for(i = 0; i <= contasList.size() && verificador != 1; i++){

            if (contasList.get(i) instanceof ContaCorrente){
                if (((ContaCorrente)pesquisa).agencia == dadosAgencia){
                    if (((ContaCorrente)pesquisa).numeroDaConta == dadosNumeroConta){
                        if (((ContaCorrente)pesquisa).digitoConta == dadosDigitoConta){
                            contaAtual = pesquisa;
                            verificador = 1;
                        }
                    }
                }
            }
            else
            if (contasList.get(i) instanceof ContaInvestimento){
                if (((ContaInvestimento)pesquisa).agencia == dadosAgencia){
                    if (((ContaInvestimento)pesquisa).numeroDaConta == dadosNumeroConta){
                        if (((ContaInvestimento)pesquisa).digitoConta == dadosDigitoConta){
                            contaAtual = pesquisa;
                            verificador = 1;
                        }
                    }
                }
            }
            else
            if (contasList.get(i) instanceof ContaPoupanca){
                if (((ContaPoupanca)pesquisa).agencia == dadosAgencia){
                    if (((ContaPoupanca)pesquisa).numeroDaConta == dadosNumeroConta){
                        if (((ContaPoupanca)pesquisa).digitoConta == dadosDigitoConta){
                            contaAtual = pesquisa;
                            verificador = 1;
                        }
                    }
                }
            }
        }
        return contaAtual;
    }

    void criarConta(Cliente cliente, int tipoDeConta) throws ClientePJContaPoupancaException, ClienteInseriuNumeroInvalidoException {

        System.out.print("Saldo: ");
        saldo = scanner.nextBigDecimal();

        agencia = random.nextInt(1000, 9999);
        numeroDaConta = random.nextInt(10000, 99999);
        digitoConta = random.nextInt(0, 9);

        switch (tipoDeConta) {

            case 1:
                System.out.println("Parabéns! Você acabou de criar uma conta conosco! Obrigado pela preferência!");
                System.out.println("À seguir, os dados da sua nova conta:" +
                        "Agência: " + agencia + "\n" + "Número de Conta: " + numeroDaConta + "-" + digitoConta);
                System.out.println("\nRedirecionaremos vocês para a tela principal...");
                Contas contaCorrente = new ContaCorrente(cliente, saldo, agencia, numeroDaConta, digitoConta);
                contasList.add(contaCorrente);
                break;
            case 2:
                System.out.println("Parabéns! Você acabou de criar uma conta conosco! Obrigado pela preferência!");
                System.out.println("À seguir, os dados da sua nova conta:" +
                        "Agência: " + agencia + "\n" + "Número de Conta: " + numeroDaConta + "-" + digitoConta);
                System.out.println("\nRedirecionaremos vocês para a tela principal...");
                Contas contaInvestimento = new ContaInvestimento(cliente, saldo, agencia, numeroDaConta, digitoConta);
                contasList.add(contaInvestimento);
                break;
            case 3:
                if (cliente instanceof ClientePessoaFisica){
                    System.out.println("Parabéns! Você acabou de criar uma conta conosco! Obrigado pela preferência!");
                    System.out.println("À seguir, os dados da sua nova conta:" +
                            "Agência: " + agencia + "\n" + "Número de Conta: " + numeroDaConta + "-" + digitoConta);
                    System.out.println("\nRedirecionaremos vocês para a tela principal...");
                    Contas contaPoupanca = new ContaPoupanca(cliente, saldo, agencia, numeroDaConta, digitoConta);
                    contasList.add(contaPoupanca);
                }
                else if (cliente instanceof ClientePessoaJuridica){
                    throw new ClientePJContaPoupancaException(tipoDeConta);
                }
                break;
            default:
                throw new ClienteInseriuNumeroInvalidoException(tipoDeConta);
        }
    }
}