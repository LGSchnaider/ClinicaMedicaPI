package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.ISecretariaDAO;
import modelo.Secretaria;

public class SecretariaDAO implements ISecretariaDAO {

	@Override
	public boolean inserir(Secretaria p) {
		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();

		// abrir conexao
		con.conectar();

		Connection c = con.conectar();
		try {
			String query = "INSERT INTO secretaria " + "(nome, cpf, telefone, email) VALUES (?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.setLong(3, p.getTelefone());
			stm.setString(4, p.getEmail());

			stm.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return false;
	}

	public ArrayList<Secretaria> listaSecretaria() {

		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();

		// abrir conexao
		con.conectar();

		Connection c = con.conectar();
		ArrayList<Secretaria> Secretarias = new ArrayList<>();
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM Secretaria";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				String nome = rs.getString("nome");
				long cpf = rs.getLong("cpf");
				long telefone = rs.getLong("telefone");
				String email = rs.getString("email");

				Secretaria p = new Secretaria();
				p.setNome(nome);
				p.setCpf(cpf);
				p.setTelefone(telefone);
				p.setEmail(email);
				Secretarias.add(p);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return Secretarias;
	}

}