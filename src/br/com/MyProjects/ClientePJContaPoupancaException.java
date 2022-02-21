package br.com.MyProjects;

public class ClientePJContaPoupancaException extends Exception{

    public ClientePJContaPoupancaException(int tipoDeConta){
        System.err.println("Um cliente Pessoa Jurídica não pode abrir uma conta poupança!");
    }

}
