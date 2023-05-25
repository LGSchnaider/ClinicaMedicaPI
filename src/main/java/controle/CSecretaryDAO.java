package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.ISecretariaDAO;
import modelo.MDoctor;
import modelo.MPatient;
import modelo.MSecretary;
import modelo.MUser;

public class CSecretaryDAO implements ISecretariaDAO {

	@Override
	public boolean inserir(MSecretary p) {
		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();

		// abrir conexao
		con.conectar();

		Connection c = con.conectar();
		try {
			String query = "INSERT INTO secretaria (nome, cpf, telefone, email, usuario_idusuario) VALUES (?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.setLong(3, p.getTelefone());
			stm.setString(4, p.getEmail());
			stm.setInt(5, p.getUsuario().getIdusuario());
			System.out.println(stm);
			stm.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return false;
	}
	
	public boolean atualizar(MSecretary p) {
		// Instacia classe Conexao
				CConnection con = CConnection.getInstancia();
				Connection c = con.conectar();

		try {
			//String query = "UPDATE secretaria SET nome= ?, cpf = ?, telefone = ?, email = ?  WHERE id = ?";
			String query = "UPDATE secretaria SET nome= ?, cpf = ?, telefone = ?, email = ? WHERE id = ?";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.setLong(3, p.getTelefone());
			stm.setString(4, p.getEmail());
			stm.setInt(5, p.getId());

			stm.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return false;
	}
	
	public boolean deletar(MSecretary p) {
		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();
	
		try {
			String query = "DELETE FROM secretaria WHERE cpf = "+p.getCpf()+"";
			PreparedStatement stm = c.prepareStatement(query);

			stm.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return false;

	}

	public ArrayList<MSecretary> listaSecretaria() {

		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();

		// abrir conexao
		con.conectar();

		Connection c = con.conectar();
		ArrayList<MSecretary> Secretarias = new ArrayList<>();
		try {
			Statement stm = c.createStatement();
			String query = "select usuario.id as usuarioid, usuario.login, usuario.senha, usuario.perfil, secretaria.id, secretaria.nome, secretaria.cpf,"
					+ " secretaria.telefone, secretaria.email from  usuario inner join secretaria on secretaria.usuario_idusuario = usuario.id;";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				long cpf = rs.getLong("cpf");
				long telefone = rs.getLong("telefone");
				String email = rs.getString("email");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				int perfil = rs.getInt("perfil");
				
				
				MSecretary S = new MSecretary();
				S.setId(id);
				S.setNome(nome);
				S.setCpf(cpf);
				S.setTelefone(telefone);
				S.setEmail(email);
				
				MUser u = new MUser();
				u.setLogin(login);
				u.setSenha(senha);
				u.setPefil(perfil);
				S.setUsuario(u);

				Secretarias.add(S);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return Secretarias;
	}

	public MSecretary buscarSecretariaPorCpf(long cpf) {
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();
		MUser u = null;
		MSecretary s = null;
		try {
			String query = "select usuario.id as usuarioid, usuario.login, usuario.senha,"
					+ " usuario.perfil, secretaria.id, secretaria.nome, secretaria.cpf,"
					+ "secretaria.telefone, secretaria.email from  usuario inner join secretaria"
					+ " on secretaria.usuario_idusuario = usuario.id where cpf ="+cpf+";";
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(query);

			if (rs.next()) {
				s = new MSecretary();
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				long cpf1 = rs.getLong("cpf");
				long telefone = rs.getLong("telefone");
				String gmail = rs.getString("email");
				
				u = new MUser();
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				int perfil = rs.getInt("perfil");
				
				s.setId(id);
				s.setNome(nome);
				s.setCpf(cpf1);
				s.setEmail(gmail);
				s.setTelefone(telefone);

				u.setLogin(login);
				u.setSenha(senha);
				u.setPefil(perfil);
				s.setUsuario(u);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return s;
	}
/*	
	public Secretaria buscarSecretaria(int cpf) {
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();

		UsuarioDAO dao = new UsuarioDAO();
		Usuario u = new Usuario();
		Secretaria p = null;
		try {
			String query = "select usuario.id as usuarioid, usuario.login, usuario.senha, usuario.perfil, medico.id, medico.nome, medico.cpf, medico.UF, medico.crm  from usuario inner join medico on medico.usuario_idusuario = usuario.id where medico.crm = "
					+ cpf + ";";
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(query);

			if (rs.next()) {
				p = new Secretaria();
				String nome = rs.getString("nome");
				long cpf1 = rs.getLong("cpf");
				Long telefone = rs.getLong("telefone");
				String  = rs.getString("email");

				String login = rs.getString("login");
				String senha = rs.getString("senha");
				int perfil = rs.getInt("perfil");
				int idUsuario = rs.getInt("usuarioid");
				int idMedico = rs.getInt("id");

				p.setId(id);
				p.setNome(nome);
				p.setCpf(cpf1);
				p.setTelefone(telefone);
				p.setUsuario(u);

				u.setIdusuario(idUsuario);
				u.setLogin(login);
				u.setSenha(senha);
				u.setPefil(perfil);
				p.setUsuario(u);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return p;
	}*/

}