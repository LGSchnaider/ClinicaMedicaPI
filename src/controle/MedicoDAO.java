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
			String query = "INSERT INTO medico " + "(nome, cpf, uf, crm, usuario_idusuario) VALUES (?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.setString(3, p.getUf());
			stm.setLong(4, p.getCrm());
			stm.setInt(5, p.getUsuario().getIdusuario());
			System.out.println(stm);
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return false;
	}

	public boolean atualizar(Medico p) {
		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();

		try {
			String query = "update medico join usuario on medico.usuario_idusuario = usuario.id set medico.nome = ?, medico.cpf = ?,medico.uf = ?, medico.crm = ?, usuario.login = ?, usuario.senha = ?, usuario.perfil = ? where medico.id = ?;";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.setString(3, p.getUf());
			stm.setLong(4, p.getCrm());
			stm.setString(5, p.getUsuario().getLogin());
			stm.setString(6, p.getUsuario().getSenha());
			stm.setInt(7, p.getUsuario().getPerfil());
			stm.setLong(8, p.getId());
			System.out.println(stm);
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
			String query = "select usuario.id as usuarioid, usuario.login, usuario.senha, usuario.perfil, medico.id, medico.nome, medico.cpf, medico.UF, medico.crm  from usuario inner join medico on medico.usuario_idusuario = usuario.id;";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				String nome = rs.getString("nome");
				long cpf = rs.getLong("cpf");
				Long crm = rs.getLong("crm");
				String UF = rs.getString("Uf");

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
				p.setUf(UF);

				
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
		//		dao.deletar(p.getUsuario());
			
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