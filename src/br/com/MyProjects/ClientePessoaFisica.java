package br.com.MyProjects;

public class ClientePessoaFisica extends Cliente {

    String nome;
    String endereco;
    String CPF;
    int idade;

    ClientePessoaFisica(String nome, String endereco, String CPF, int idade){

        this.nome = nome;
        this.endereco = endereco;
        this.CPF = CPF;
        this.idade = idade;

    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
