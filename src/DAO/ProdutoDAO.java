
package DAO;

import Modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO  extends ExecuteSQL {
    public ProdutoDAO(Connection con){
        super(con);
    }
    
    public String Cadastrar_Produto (Produto a){
        String sql = "INSERT INTO produto VALUES (0,?,?,?,?,?)";
            try {
                PreparedStatement ps = getCon().prepareStatement(sql);
                
                ps.setString(1, a.getNome());
                ps.setString(2, a.getQuantidade());
                ps.setString(3, a.getValor());
                ps.setString(4, a.getData());
                ps.setString(5, a.getFornecedor());
                
                if(ps.executeUpdate() > 0){
                    return " Cadastro realizado com sucesso !";
                }else{
                    return " Erro";
                }
                
            } catch (SQLException e) {
                return e.getMessage();
            }
        }
    
}
