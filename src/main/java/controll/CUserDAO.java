package controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.MIUserDAO;
import model.MUser;

public class CUserDAO implements MIUserDAO {

	@Override
	public boolean inserir(MUser p) {
		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO usuario " + "(login, senha, perfil) VALUES (?,?,?);";
			PreparedStatement stm = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stm.setString(1, p.getLogin());
			stm.setString(2, p.getSenha());
			stm.setInt(3, p.getPerfil());

			stm.executeUpdate();
			
			try (ResultSet generatedKeys = stm.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                p.setIdusuario((int) generatedKeys.getLong(1));
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
			
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return false;
	}

	public boolean atualizar(MUser p) {
		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();

		try {
			String query = "UPDATE usuario SET login= ?, senha = ?, perfil = ?  WHERE id = ?";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getLogin());
			stm.setString(2, p.getSenha());
			stm.setInt(3, p.getPerfil());
			stm.setInt(4, p.getIdusuario());

			stm.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		con.fechaConexao();
		return false;
	}

	public boolean deletar(MUser p) {
		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();

		try {
			String query = "DELETE FROM usuario WHERE id = ?";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, p.getIdusuario());

			stm.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		con.fechaConexao();
		return false;

	}

	public ArrayList<MUser> listaAdministrador() {

		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();
		ArrayList<MUser> Usuarios = new ArrayList<>();
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM usuario";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				String login = rs.getString("login");
				String senha = rs.getString("senha");
				int perfil = rs.getInt("perfil");

				MUser p = new MUser();
				p.setLogin(login);
				p.setSenha(senha);
				p.setPefil(perfil);
				Usuarios.add(p);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return Usuarios;
	}

	public MUser buscarUsuarioPorLoginSenha(String login, String senha) {

		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM usuario WHERE  login = '"+login+"' AND senha = '"+senha+"';";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				String loginn = rs.getString("login");
				String senhaa = rs.getString("senha");
				int perfil = rs.getInt("perfil");

				MUser p = new MUser();
				p.setLogin(loginn);
				p.setSenha(senhaa);
				p.setPefil(perfil);
				return p;
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();
		
		return null;
}

}