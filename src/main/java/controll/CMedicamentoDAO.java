package controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.MDoctor;
import model.MIMedicineDAO;
import model.MMedicine;

public class CMedicamentoDAO implements MIMedicineDAO {
	@Override
	public boolean inserir(MMedicine p){
		// Instacia classe Conexao
				CConnection con = CConnection.getInstancia();
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
	
	public boolean atualizar(MMedicine p) {
		// Instacia classe Conexao
				CConnection con = CConnection.getInstancia();
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
	
	public boolean deletar(MMedicine p) {
		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
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


	public ArrayList<MMedicine> listaMedicamento() {

		// Instacia classe Conexao
				CConnection con = CConnection.getInstancia();
				Connection c = con.conectar();
				
		ArrayList<MMedicine> Medicamentos = new ArrayList<>();
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM Medicamento";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				String nome = rs.getString("nome");
				String tarja = rs.getString("tarja");
				String formula = rs.getString("formula");

				MMedicine p = new MMedicine();
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

