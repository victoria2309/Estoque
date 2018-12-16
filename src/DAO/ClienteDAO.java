
package DAO;




import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;


public class ClienteDAO extends ExecuteSQL {
    public ClienteDAO(Connection con){
        super(con);
    }
    
    public boolean Logar(String login, String senha){
        boolean finalResult = false;
        try{
            String consulta = "SELECT email,senha FROM `cliente` WHERE email = '"+ login +"' AND senha = '"+ senha+"' ";
            
            PreparedStatement ps = getCon().prepareStatement (consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()){
                    Cliente a = new Cliente();
                  a.setEmail(rs.getString(1));
                  a.setSenha(rs.getString(2));
                   finalResult = true;
                   
            }
        }
    } catch(SQLException ex){
        ex.getMessage();
    }
        return finalResult;
    }
    
    public String Cadastrar_Cliente(Cliente a){
        String sql = "INSERT INTO cliente VALUES (0,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = getCon().prepareStatement(sql);
               ps.setString(1,a.getNome());
               ps.setString(2,a.getCidade());
               ps.setString(3,a.getCep());
               ps.setString(4,a.getCpf());
               ps.setString(5,a.getSexo());
               ps.setString(6,a.getTelefone());
             ps.setString(7, a.getEmail());
               ps.setString(8,a.getSenha());
               
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


