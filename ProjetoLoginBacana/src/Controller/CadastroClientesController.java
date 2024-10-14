package Controller;

import Model.CadastroClienteModel;
import javax.swing.JOptionPane;

public class CadastroClientesController {
    
    public void criarClientesController(String nome, String cep, String endereco, String fone, String email){
    
        Boolean sucesso; 
        CadastroClienteModel novoCliente = new CadastroClienteModel(nome, cep, endereco, fone, email);
        sucesso = novoCliente.enviarDadosDbDAL(novoCliente);
        
        if(sucesso){
            String mensagem = "Registro realizado com sucesso!";
            JOptionPane.showMessageDialog(null, mensagem);
        }else{
            String mensagem = "Falha ao realizar o registro no banco de dados!";
            JOptionPane.showMessageDialog(null, mensagem);
        }
        
    }
}
