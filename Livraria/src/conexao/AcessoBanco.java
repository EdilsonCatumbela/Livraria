package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class AcessoBanco {
	
	public Statement stm;
	public ResultSet res;
	String servidor = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String senha = "Phonseca";
	String driver = "com.mysql.jdbc.Driver";
	public Connection con;
	
	public void conectar() {
		
		try {
			System.setProperty("jdbc.driver", driver);
			con = DriverManager.getConnection(servidor, usuario, senha);
			
		}catch (SQLException e) {
		    System.out.println("Erro" + e.getMessage());
		    JOptionPane.showMessageDialog(null, "Erro na conexao"+e.getMessage());
		}		
	}
	
	@SuppressWarnings("static-access")
	public void executarSql(String sql){
	
			try {
				stm = con.createStatement(res.TYPE_SCROLL_INSENSITIVE, res.CONCUR_READ_ONLY);
				res = stm.executeQuery(sql);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ExecutaAql:\n" + e.getMessage());
			}
	
		
	}
	
	public void desconectar(){
		try {
			con.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar conexao com\n"+e.getMessage());
			
		}
	}
}
