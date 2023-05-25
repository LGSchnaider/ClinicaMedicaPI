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
			String query = "insert into prontuario(data, observacao, valor, medico_id_medico, paciente_id_paciente) values (?, ?, ?, ?, ?);";
			PreparedStatement stm = c1.prepareStatement(query);

			stm.setString(1, pr.getData());
			stm.setString(2, pr.getObs());
			stm.setString(3, pr.getValor());
			stm.setInt(4, pr.getIdMedico());
			stm.setInt(5, pr.getIdPaciente());
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
