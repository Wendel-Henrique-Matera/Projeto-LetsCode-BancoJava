package br.com.MyProjects;

public class ClientePessoaJuridica extends Cliente {

    String nome;
    String endereco;
    String CNPJ;

    ClientePessoaJuridica(String nome, String endereco, String CNPJ){

        this.nome = nome;
        this.endereco = endereco;
        this.CNPJ = CNPJ;

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

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}
