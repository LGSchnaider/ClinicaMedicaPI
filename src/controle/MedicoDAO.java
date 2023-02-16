package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.IMedicoDAO;
import modelo.Medico;

public class MedicoDAO implements IMedicoDAO {

	@Override
	public boolean inserir(Medico p) {
		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();

		// abrir conexao
		con.conectar();

		Connection c = con.conectar();
		try {
			String query = "INSERT INTO medico " + "(nome, sobrenome, cpf, crm) VALUES (?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setString(2, p.getSobrenome());
			stm.setLong(3, p.getCpf());
			stm.setString(4, p.getCrm());

			stm.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return false;
	}

	public ArrayList<Medico> listaMedico() {

		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();

		// abrir conexao
		con.conectar();

		Connection c = con.conectar();
		ArrayList<Medico> Medicos = new ArrayList<>();
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM Medico";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				long cpf = rs.getLong("perfil");
				String crm = rs.getString("crm");

				Medico p = new Medico();
				p.setNome(nome);
				p.setSobrenome(sobrenome);
				p.setCpf(cpf);
				p.setCrm(crm);
				Medicos.add(p);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return Medicos;
	}

}