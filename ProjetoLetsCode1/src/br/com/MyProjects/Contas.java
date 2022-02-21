package br.com.MyProjects;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Random;

public class Contas extends Cliente {

    BigDecimal saldo;
    int agencia;
    int numeroDaConta;
    int digitoConta;
    int dadosAgencia;
    int dadosNumeroConta;
    int dadosDigitoConta;
    Cliente cliente;

    Scanner scanner = new Scanner(System.in);

    Contas(){

        this.saldo = getSaldo();



    }

    void consultarSaldo(Contas conta){

        System.out.print("Seu saldo é de R$ " + conta.saldo);

    }

    void sacar(Contas conta){

        BigDecimal valorSacado;

        System.out.println("Digite o valor que deseja sacar");
        valorSacado = scanner.nextBigDecimal();

        if (conta.cliente instanceof ClientePessoaFisica){
            conta.saldo = setSaldo(conta.saldo.subtract(valorSacado));
        }
        else if (conta.cliente instanceof ClientePessoaJuridica){
            valorSacado.multiply(new BigDecimal(1.005));
            conta.saldo = setSaldo(conta.saldo.subtract(valorSacado));
        }

        conta.saldo = setSaldo(saldo.subtract(valorSacado));

        consultarSaldo(conta);

    }

    void depositar(Contas conta){

        BigDecimal valorDepositado;

        System.out.println("Digite o valor que deseja depositar");
        valorDepositado = scanner.nextBigDecimal();

        conta.saldo = setSaldo(saldo.add(valorDepositado));

        consultarSaldo(conta);

    }

    void investir(Contas conta){

        BigDecimal valorInvestido;

        System.out.println("Digite o valor que deseja depositar");
        valorInvestido = scanner.nextBigDecimal();

        if (conta.cliente instanceof ClientePessoaFisica){
            conta.saldo = setSaldo(conta.saldo.add(valorInvestido));
        }
        else if (conta.cliente instanceof ClientePessoaJuridica){
            valorInvestido.multiply(new BigDecimal("1.02"));
            conta.saldo = setSaldo(conta.saldo.add(valorInvestido));
        }

        consultarSaldo(conta);

    }

    void transferir(Contas contaOrigem, Contas contaDestino) throws ContaInexistenteException {

        dadosAgencia = 0;
        dadosNumeroConta = 0;
        dadosDigitoConta = 0;

        System.out.println("Digite os dados da conta em que deseja depositar");

        System.out.print("Agencia: ");
        dadosAgencia = scanner.nextInt();
        System.out.print("Número da Conta: ");
        dadosNumeroConta = scanner.nextInt();
        System.out.print("Dígito da conta: ");
        dadosDigitoConta = scanner.nextInt();

        BigDecimal valorTransferido;

        System.out.println("Digite o valor que deseja transferir");
        valorTransferido = scanner.nextBigDecimal();

        if (contaOrigem.cliente instanceof ClientePessoaFisica){
            contaOrigem.saldo = setSaldo(contaOrigem.saldo.subtract(valorTransferido));
            contaDestino.saldo = setSaldo(contaDestino.saldo.add(valorTransferido));
        }
        else if (contaOrigem.cliente instanceof ClientePessoaJuridica){
            contaDestino.saldo = setSaldo(contaDestino.saldo.add(valorTransferido));
            valorTransferido.multiply(new BigDecimal(1.005));
            contaOrigem.saldo = setSaldo(contaOrigem.saldo.subtract(valorTransferido));
        }

        System.out.println("Você transferiu R$ " + valorTransferido);
        System.out.print("Seu atual saldo é de R$ " + contaOrigem.saldo);

    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public int getDigitoConta() {
        return digitoConta;
    }

    public void setDigitoConta(int digitoConta) {
        this.digitoConta = digitoConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
        return saldo;
    }
}

    /**
     * Adicionar os três tipos de Conta nesse trecho
     */