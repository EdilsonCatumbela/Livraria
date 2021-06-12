package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Livraria;
import conexao.AcessoBanco;

public class ControleLivraria {
	AcessoBanco ab = new AcessoBanco();
	Livraria livrario = new Livraria();
	
	public void salvar(Livraria livraria){
		ab.conectar();
		try {
			PreparedStatement ptm = ab.con.prepareStatement("insert into sistema (nome_livro, secao_livro, qtd_livro, precoa_livro, precov_livro) values (?, ?, ?, ?, ?)");
			//ptm.setInt(1, livraria.getCodLivro());
			ptm.setString(1, livraria.getNomeLivro());
			ptm.setString(2, livraria.getSecLivro());
			ptm.setInt(3, livraria.getQtdeLivro());
			ptm.setDouble(4, livraria.getPrecoa());
			ptm.setDouble(5, livraria.getPrecov());
			ptm.execute();
			JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar salvar um livro\n!!"+ e.getMessage());
		}
		ab.desconectar();
			
	}
	
	public Livraria buscarLivro(Livraria livro){
		ab.conectar();
		ab.executarSql("select * from sistema where cod_livro like '%"+livro.getPesquisa()+"%'");
		try {
			
			if(ab.res.first()){
				// ab.res.first();
				livro.setCodLivro(ab.res.getInt("cod_livro"));
				livro.setNomeLivro(ab.res.getString("nome_livro"));
				livro.setSecLivro(ab.res.getString("secao_livro"));
				livro.setQtdeLivro(ab.res.getInt("qtd_livro"));
				livro.setPrecoa(ab.res.getDouble("precoa_livro"));
				livro.setPrecov(ab.res.getDouble("precov_livro"));
			}else{JOptionPane.showMessageDialog(null, "O livro não existe!!");}
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar livro\n!!"+ e.getMessage());
		}
		
		ab.desconectar();
		
		return livro;
	}

	public void Editar(Livraria livro){
		ab.conectar();
		try {
			PreparedStatement pst = ab.con.prepareStatement("update sistema set nome_livro=?, secao_livro=?, qtd_livro=?, precoa_livro=?, precov_livro=? where cod_livro=?");
			//pst.setInt(1, livro.getCodLivro());
			pst.setString(1, livro.getNomeLivro());
			pst.setString(2, livro.getSecLivro());
			pst.setInt(3, livro.getQtdeLivro());
			pst.setDouble(4, livro.getPrecoa());
			pst.setDouble(5, livro.getPrecov());
			pst.setInt(6, livro.getCodLivro());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Livro editado com sucesso!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar editar livro\n!!" + e.getMessage());
		}
		ab.desconectar();
	}

	public void remover(Livraria livro){
		ab.conectar();
		try {
			PreparedStatement pst = ab.con.prepareStatement("delete from sistema where cod_livro=?");
			pst.setInt(1, livro.getCodLivro());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Livro removido com sucesso!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar remover livro\n!!" + e.getMessage());
		}

		ab.desconectar();
	}
}
