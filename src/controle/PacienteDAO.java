package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.IPacienteDAO;
import modelo.Medico;
import modelo.Paciente;
import modelo.TipoSexo;

public class PacienteDAO implements IPacienteDAO {

	@Override
	public boolean inserir(Paciente p) {
		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();

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
			System.out.println(stm);
			stm.executeUpdate();
			return false;
			

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return true;
	}

	public boolean atualizar(int id, Paciente p) {
		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();

		try {
			String query = "UPDATE paciente SET nome= ?, telefone = ?, sexo = ?, email = ?  WHERE id = " + id+ ";";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setLong(2, p.getTelefone());
			stm.setString(3, p.getSexo().getCodigo());
			stm.setString(4, p.getEmail());

			stm.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		con.fechaConexao();

		return false;
	}

	public boolean deletar(String del) {
		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();

		try {
			String query = "DELETE FROM paciente WHERE cpf = " + del + ";";
			PreparedStatement stm = c.prepareStatement(query);

//			stm.setLong(1, p.getCpf());

			stm.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.fechaConexao();

		return false;

	}

	public ArrayList<Paciente> listaPaciente() {

		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();

		ArrayList<Paciente> Pacientes = new ArrayList<>();
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
				
				Paciente p = new Paciente();
				p.setNome(nome);
				p.setCpf(cpf);
				p.setTelefone(telefone);
				p.setSexo(TipoSexo.obterTipo(sexo));
				p.setEmail(email);
				p.setIdPac(id);
				Pacientes.add(p);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return Pacientes;
	}

	@Override
	public boolean atualizar(Paciente p) {
		return false;
	}

	@Override
	public boolean deletar(Paciente p) {
		return false;
	}

}