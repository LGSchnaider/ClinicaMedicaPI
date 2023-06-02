package controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.MDoctor;
import model.MIPatientDAO;
import model.MPatient;
import model.MTyperGender;
import model.MUser;

public class CPatientDAO implements MIPatientDAO {

	@Override
	public boolean inserir(MPatient p) {
		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();

		// abrir conexao
		con.conectar();

		Connection c = con.conectar();
		try {
			String query = "INSERT INTO paciente (nome, cpf, telefone, sexo, email) VALUES (?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.setLong(3, p.getTelefone());
			stm.setString(4, p.getSexo().getCodigo());
			stm.setString(5, p.getEmail());

			
			stm.executeUpdate();
			return true;
			

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return false;
	}

	public boolean atualizar(int id, MPatient p) {
		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();

		try {
			String query = "UPDATE paciente SET nome= ?, telefone = ?, sexo = ?, email = ?  WHERE id = ?;";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setLong(2, p.getTelefone());
			stm.setString(3, p.getSexo().getCodigo());
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

	public boolean deletar(long cpf) {
		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();

		try {
			String query = "DELETE FROM paciente WHERE cpf = " + cpf + ";";
			PreparedStatement stm = c.prepareStatement(query);

//			stm.setLong(1, p.getCpf());

			stm.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return false;

	}

	public ArrayList<MPatient> listaPaciente() {

		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();

		ArrayList<MPatient> Pacientes = new ArrayList<>();
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM Paciente";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				String nome = rs.getString("nome");
				long cpf = rs.getLong("cpf");
				long telefone = rs.getLong("telefone");
				String sexo = rs.getString("sexo");
				String email = rs.getString("email");
				int id = rs.getInt("id");
				
				MPatient p = new MPatient();
				p.setNome(nome);
				p.setCpf(cpf);
				p.setTelefone(telefone);
				p.setSexo(MTyperGender.obterTipo(sexo));
				p.setEmail(email);
				p.setIdPac(id);
				Pacientes.add(p);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return Pacientes;
	}

	@Override
	public boolean atualizar(MPatient p) {
		return false;
	}

	@Override
	public boolean deletar(MPatient p) {
		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();

		try {
			String query = "DELETE FROM paciente WHERE cpf = ?;";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, p.getCpf());

			stm.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return false;
	}

	public MPatient buscarPacientPorCpf(int cpf) {
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();
		MPatient p = null;
		try {
			String query = "select * from paciente where cpf ="+cpf+";";
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(query);

			if (rs.next()) {
				p = new MPatient();
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				long cpf1 = rs.getLong("cpf");
				long tel = rs.getLong("telefone");
				String sexo = rs.getString("sexo");
				String email = rs.getString("email");


				
				p.setId(id);
				p.setNome(nome);
				p.setCpf(cpf1);
				p.setTelefone(tel);
				p.setSexo((MTyperGender.obterTipo(sexo)));
				p.setEmail(email);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		return p;
	}

}