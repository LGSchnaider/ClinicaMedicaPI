package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

	@Override
	public boolean inserir(Usuario p) {
		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO usuario " + "(login, senha, perfil, admin) VALUES (?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getLogin());
			stm.setString(2, p.getSenha());
			stm.setInt(3, p.getPefil());

			stm.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return false;
	}

	public boolean atualizar(Usuario p) {
		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();

		try {
			String query = "UPDATE usuario SET login= ?, senha = ?, perfil = ?, admin = ?  WHERE id = ?";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getLogin());
			stm.setString(2, p.getSenha());
			stm.setInt(3, p.getPefil());

			stm.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		con.fechaConexao();
		return false;
	}

	public boolean deletar(Usuario p) {
		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();
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

	public ArrayList<Usuario> listaAdministrador() {

		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();
		ArrayList<Usuario> Usuarios = new ArrayList<>();
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM usuario";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				String login = rs.getString("login");
				String senha = rs.getString("senha");
				int perfil = rs.getInt("perfil");

				Usuario p = new Usuario();
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

	public Usuario buscarUsuarioPorLoginSenha(String login, String senha) {

		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM usuario WHERE  login = '"+login+"' AND senha = '"+senha+"';";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				String loginn = rs.getString("login");
				String senhaa = rs.getString("senha");
				int perfil = rs.getInt("perfil");

				Usuario p = new Usuario();
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