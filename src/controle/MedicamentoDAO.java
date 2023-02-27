package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.IMedicamentoDAO;
import modelo.Medicamento;
import modelo.Medico;

public class MedicamentoDAO implements IMedicamentoDAO {
	@Override
	public boolean inserir(Medicamento p){
		// Instacia classe Conexao
				Conexao con = Conexao.getInstancia();
				Connection c = con.conectar();
		try {
			String query = "INSERT INTO medicamento " + "(nome, tarja, formula) VALUES (?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setString(2, p.getTarja());
			stm.setString(3, p.getFormula());

			stm.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return false;
	}
	
	public boolean atualizar(Medicamento p) {
		// Instacia classe Conexao
				Conexao con = Conexao.getInstancia();
				Connection c = con.conectar();

		try {
			String query = "UPDATE medicamento SET nome= ?, tarja = ?, formula = ?  WHERE id = ?";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());
			stm.setString(2, p.getTarja());
			stm.setString(3, p.getFormula());
			

			stm.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		con.fechaConexao();
		return false;
	}
	
	public boolean deletar(Medicamento p) {
		// Instacia classe Conexao
		Conexao con = Conexao.getInstancia();
		Connection c = con.conectar();
	
		try {
			String query = "DELETE FROM medicamento WHERE id = ?";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getNome());

			stm.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		con.fechaConexao();
		return false;

	}


	public ArrayList<Medicamento> listaMedicamento() {

		// Instacia classe Conexao
				Conexao con = Conexao.getInstancia();
				Connection c = con.conectar();
				
		ArrayList<Medicamento> Medicamentos = new ArrayList<>();
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM Medicamento";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				String nome = rs.getString("nome");
				String tarja = rs.getString("tarja");
				String formula = rs.getString("formula");

				Medicamento p = new Medicamento();
				p.setNome(nome);
				p.setTarja(tarja);
				p.setFormula(formula);
				Medicamentos.add(p);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return Medicamentos;
	}

}

