package br.com.MyProjects;

import java.math.BigDecimal;

public class ContaInvestimento extends Contas {

    Cliente cliente;
    BigDecimal saldo;
    int agencia;
    int numeroDaConta;
    int digitoDaConta;

    ContaInvestimento(Cliente cliente, BigDecimal saldo, int agencia, int numeroDaConta, int digitoDaConta){

        this.cliente = cliente;
        this.saldo = saldo;
        this.agencia = agencia;
        this.numeroDaConta = numeroDaConta;
        this.digitoDaConta = digitoDaConta;

    }

    @Override
    public BigDecimal getSaldo() {
        return saldo;
    }

    @Override
    public BigDecimal setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
        return saldo;
    }

    @Override
    public int getAgencia() {
        return agencia;
    }

    @Override
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    @Override
    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    @Override
    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    @Override
    public int getDigitoConta() {
        return super.getDigitoConta();
    }

    @Override
    public void setDigitoConta(int digitoConta) {
        super.setDigitoConta(digitoConta);
    }

}
