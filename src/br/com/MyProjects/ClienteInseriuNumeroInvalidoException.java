package br.com.MyProjects;

public class ClienteInseriuNumeroInvalidoException extends Exception{

    public ClienteInseriuNumeroInvalidoException(int tipoDeConta){
        System.err.println("O número digitado foi " + tipoDeConta + ". Número não válido");
    }


}
