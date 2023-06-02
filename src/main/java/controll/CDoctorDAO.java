package controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.MDoctor;
import model.MIDoctorDAO;
import model.MUser;

public class CDoctorDAO implements MIDoctorDAO {

	@Override
	public boolean inserir(MDoctor p) {
		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO medico " + "(nome, cpf, uf, crm, usuario_idusuario) VALUES (?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.setString(3, p.getUf());
			stm.setLong(4, p.getCrm());
			stm.setInt(5, p.getUsuario().getIdusuario());
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return false;
	}

	public boolean atualizar(MDoctor p) {
		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
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
			stm.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return false;
	}

	public ArrayList<MDoctor> listaMedico() {

		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();

		ArrayList<MDoctor> Medicos = new ArrayList<>();
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

				MDoctor p = new MDoctor();
				p.setId(idMedico);
				p.setNome(nome);
				p.setCpf(cpf);
				p.setCrm(crm);
				p.setUf(UF);

				MUser u = new MUser();
				u.setIdusuario(idUsuario);
				u.setLogin(login);
				u.setSenha(senha);
				
				u.setPefil(perfil);
				p.setUsuario(u);

				Medicos.add(p);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// fechar conexao
			con.fechaConexao();
		}

		return Medicos;
	}

	@Override
	public boolean deletar(MDoctor p) {
		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();
		// dao.deletar(p.getUsuario());

		try {
			String query = "DELETE medico, usuario FROM medico, usuario WHERE medico.usuario_idusuario = usuario.id and medico.crm ="
					+ p.getCrm() + "";
			PreparedStatement stm = c.prepareStatement(query);

			stm.executeUpdate();
			return true;

		}catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "O médico possuí uma consulta agendada");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return false;
	}

	public MDoctor buscarMedicoPorCrm(long crm) {
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();

		CUserDAO dao = new CUserDAO();
		MUser u = new MUser();
		MDoctor p = null;
		try {
			String query = "select usuario.id as usuarioid, usuario.login, usuario.senha, usuario.perfil, medico.id, medico.nome, medico.cpf, medico.UF, medico.crm  from usuario inner join medico on medico.usuario_idusuario = usuario.id where medico.crm = "
					+ crm + ";";
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(query);

			if (rs.next()) {
				p = new MDoctor();
				String nome = rs.getString("nome");
				long cpf = rs.getLong("cpf");
				Long crm1 = rs.getLong("crm");
				String UF = rs.getString("Uf");

				String login = rs.getString("login");
				String senha = rs.getString("senha");
				int perfil = rs.getInt("perfil");
				int idUsuario = rs.getInt("usuarioid");
				int idMedico = rs.getInt("id");

				p.setId(idMedico);
				p.setNome(nome);
				p.setCpf(cpf);
				p.setCrm(crm1);
				p.setUf(UF);

				u.setIdusuario(idUsuario);
				u.setLogin(login);
				u.setSenha(senha);
				u.setPefil(perfil);
				p.setUsuario(u);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return p;
	}

}