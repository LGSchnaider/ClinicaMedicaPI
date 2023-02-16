package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.IAdministradorDAO;
import modelo.Administrador;

public class AdministradorDAO implements IAdministradorDAO {

	@Override
	public boolean inserir(Administrador p) {
		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();

		// abrir conexao
		con.conectar();

		Connection c = con.conectar();
		try {
			String query = "INSERT INTO usuario " + "(login, senha, perfil, admin) VALUES (?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getLogin());
			stm.setString(2, p.getSenha());
			stm.setInt(3, p.getPefil());
			stm.setBoolean(4, p.isAdmin());

			stm.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return false;
	}

	public ArrayList<Administrador> listaAdministrador() {

		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();

		// abrir conexao
		con.conectar();

		Connection c = con.conectar();
		ArrayList<Administrador> Administradores = new ArrayList<>();
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM Administrador";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				String login = rs.getString("login");
				String senha = rs.getString("senha");
				int perfil = rs.getInt("perfil");
				boolean admin = rs.getBoolean("admin");

				Administrador p = new Administrador();
				p.setLogin(login);
				p.setSenha(senha);
				p.setPefil(perfil);
				p.setAdmin(admin);
				Administradores.add(p);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return Administradores;
	}

}