package br.com.MyProjects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao extends Banco {

    public static void main(String[] args) throws ClientePJContaPoupancaException, ClienteInseriuNumeroInvalidoException, ContaInexistenteException, OpcaoInvalidaException {

        Aplicacao aplicacao = new Aplicacao();
        aplicacao.IniciarOperacoes();

    }

    private void IniciarOperacoes() throws ClientePJContaPoupancaException, ClienteInseriuNumeroInvalidoException, ContaInexistenteException, OpcaoInvalidaException {

        int tipoDeOperacao;
        boolean continuarOperacoes = true;

        Cliente Mario = new ClientePessoaFisica("Mario","World","36985214705", 40);
        Cliente Luigi = new ClientePessoaJuridica("Luigi","Mansion","12.345.678/0001-90");
        Contas MarioCorrentes = new ContaCorrente(Mario, BigDecimal.valueOf(10_000),1234,56789,0);
        contasList.add(MarioCorrentes);
        Contas LuigiInvestimentos = new ContaInvestimento(Luigi, BigDecimal.valueOf(10_001),9876,54321,0);
        contasList.add(LuigiInvestimentos);

        Contas contaAtual = new Contas();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Banco XXX");

        while (continuarOperacoes){

            tipoDeOperacao = 0;

            System.out.println("Digite a operação que deseja realizar:");
            System.out.println("""
                    1 - Abrir Conta
                    2 - Consultar Saldo
                    3 - Sacar Valor
                    4 - Depositar Valor
                    5 - Investir Valor
                    6 - Transferir Valor
                    7 - Finalizar Operações
                    """);

            tipoDeOperacao = scanner.nextInt();

            if (tipoDeOperacao == 1){
                abrirConta();
            }
            else{
                contaAtual = acessarConta(contaAtual);
                switch (tipoDeOperacao) {
                    case 2:
                        consultarSaldo(contaAtual);
                        break;
                    case 3:
                        sacar(contaAtual);
                        break;
                    case 4:
                        depositar(contaAtual);
                        break;
                    case 5:
                        investir(contaAtual);
                        break;
                    case 6:
                        Contas contaDestino = new Contas();
                        acessarConta(contaDestino);
                        transferir(contaAtual, contaDestino);
                        break;
                    case 7:
                        continuarOperacoes = false;
                        break;
                    default:
                        throw new OpcaoInvalidaException(tipoDeOperacao);
                }
            }
        }
    }
}


/**
 * Implementar as funcionalidades no "Main"
 * Testar para corrigir qualquer erro
 * Definir o encapsulamento das classes (public, private, protected)
 */