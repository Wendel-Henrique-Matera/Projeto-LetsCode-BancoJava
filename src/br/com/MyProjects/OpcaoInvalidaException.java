package br.com.MyProjects;

public class OpcaoInvalidaException extends Exception{

    public OpcaoInvalidaException(int tipoDeOperacao){

        System.err.println("A operação de número " + tipoDeOperacao + "não existe");

    }

}
