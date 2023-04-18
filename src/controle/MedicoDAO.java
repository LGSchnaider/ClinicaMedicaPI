package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Usuario;
import modelo.IMedicoDAO;
import modelo.Medico;

public class MedicoDAO implements IMedicoDAO {

	@Override
	public boolean inserir(Medico p) {
		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO medico " + "(nome, cpf, crm, usuario_idusuario) VALUES (?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.setLong(3, p.getCrm());
			stm.setInt(4, p.getUsuario().getIdusuario());
			System.out.println(stm);
			stm.executeUpdate();
			con.fechaConexao();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao

		return false;
	}

	public boolean atualizar(Medico p) {
		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();

		try {
			String query = "UPDATE medico SET nome= ?, cpf = ?, crm = ?  WHERE id = ?";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.setLong(3, p.getCrm());

			stm.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		con.fechaConexao();
		return false;
	}


	public ArrayList<Medico> listaMedico() {

		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();

		ArrayList<Medico> Medicos = new ArrayList<>();
		try {
			Statement stm = c.createStatement();
			String query = "select usuario.id as usuarioid, usuario.login, usuario.senha, usuario.perfil, medico.id, medico.nome, medico.cpf, medico.crm  from usuario inner join medico on medico.usuario_idusuario = usuario.id;";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				String nome = rs.getString("nome");
				long cpf = rs.getLong("cpf");
				Long crm = rs.getLong("crm");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				int perfil = rs.getInt("perfil");
				int idUsuario = rs.getInt("usuarioid");
				int idMedico = rs.getInt("id");

				Medico p = new Medico();
				p.setId(idMedico);
				p.setNome(nome);
				p.setCpf(cpf);
				p.setCrm(crm);

				
				Usuario u = new Usuario();
				u.setIdusuario(idUsuario);
				u.setLogin(login);
				u.setSenha(senha);
				u.setPefil(perfil);
				p.setUsuario(u);
				
				Medicos.add(p);
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return Medicos;
	}

	@Override
	public boolean deletar(Medico p) {
		// Instacia classe Conexao
				Conexao con = Conexao.getInstancia();
				Connection c = con.conectar();
				
				UsuarioDAO dao = new UsuarioDAO();
				dao.deletar(p.getUsuario());
			
				try {
					String query = "DELETE medico, usuario FROM medico, usuario WHERE medico.usuario_idusuario = usuario.id and medico.crm ="+p.getCrm()+"";
					PreparedStatement stm = c.prepareStatement(query);

					

					stm.executeUpdate();
					return true;

				} catch (SQLException e) {

					e.printStackTrace();
				}
				con.fechaConexao();
				return false;
	}

}