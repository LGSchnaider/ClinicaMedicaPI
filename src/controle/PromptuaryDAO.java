package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.IPromptuaryDAO;
import modelo.Promptuary;

public class PromptuaryDAO implements IPromptuaryDAO{

	@Override
	public boolean inserir(Promptuary pr) {
		Conexao con = Conexao.getInstancia();
		Connection c1 = con.conectar();
		try {
			String query = "INSERT INTO agenda_medico " + "(data, hora, descricao, valor, medico_id_medico, paciente_id_paciente) VALUES (?,?,?,?,?,?);";
			PreparedStatement stm = c1.prepareStatement(query);

			stm.setString(1, pr.getData());
			stm.setString(2, pr.getHora());
			stm.setString(3, pr.getObs());
			stm.setString(4, pr.getValor());
			stm.setInt(5, pr.getIdMedico());
			stm.setInt(6, pr.getIdPaciente());
			stm.executeUpdate();
			con.fechaConexao();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean atualizar(Promptuary pr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(Promptuary pr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Promptuary> listaConsulta() {
		// TODO Auto-generated method stub
		return null;
	}

}
