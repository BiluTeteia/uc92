package DAL;

import Model.CadastroClienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciadorBancoDadosCliente {
    public Boolean salvarClienteBD(CadastroClienteModel novoCliente) {

        Boolean sucesso = null;
        String sql = "insert into TB_CLIENTES (NOME_CLIENTE, CEP_CLIENTE, ENDERECO_CLIENTE, FONE_CLIENTE, EMAIL_CLIENTE) values (?, ?, ?, ?, ?)";
        PreparedStatement pst = null;
        Connection connection = null;

        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, novoCliente.getNome());
            pst.setString(2, novoCliente.getCep());
            pst.setString(3, novoCliente.getEndereco());
            pst.setString(4, novoCliente.getFone());
            pst.setString(5, novoCliente.getEmail());
            pst.executeUpdate();
            System.out.println("Registro inserido com sucesso no banco de dados!");
            sucesso = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Login ou email existente no banco de dados!");
            sucesso = false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO::GerenciadorBancoDados::salvarUsuarioBD");
            sucesso = false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sucesso;
    }
}
