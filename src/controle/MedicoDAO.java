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
			String query = "SELECT * FROM Medico";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				String nome = rs.getString("nome");
				long cpf = rs.getLong("cpf");
				Long crm = rs.getLong("crm");

				Medico p = new Medico();
				p.setNome(nome);
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

	@Override
	public boolean deletar(Medico p) {
		// Instacia classe Conexao
				Conexao con = Conexao.getInstancia();
				Connection c = con.conectar();
			
				try {
					String query = "DELETE FROM medico WHERE crm = "+p.getCrm()+"";
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