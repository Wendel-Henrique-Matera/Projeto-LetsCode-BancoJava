package br.com.MyProjects;

public class ContaInexistenteException extends Exception{

    public ContaInexistenteException(){
        System.err.println("A conta pesquisada é inexistente");
    }

}
