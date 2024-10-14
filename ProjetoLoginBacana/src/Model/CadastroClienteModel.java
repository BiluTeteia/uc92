package Model;

import DAL.GerenciadorBancoDadosCliente;

public class CadastroClienteModel {
    
    private String nome;
    private String cep;
    private String endereco;
    private String fone;
    private String email;
    private String id;

    public CadastroClienteModel(String nome, String cep, String endereco, String fone, String email) {
        this.nome = nome;
        this.cep = cep;
        this.endereco = endereco;
        this.fone = fone;
        this.email = email;
    }
    
    
    
    public Boolean enviarDadosDbDAL(CadastroClienteModel novoCliente) {

        Boolean sucesso = null;
        GerenciadorBancoDadosCliente novoClient = new GerenciadorBancoDadosCliente();
        sucesso = novoClient.salvarClienteBD(novoCliente);
        return sucesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
