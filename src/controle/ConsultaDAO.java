package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Consulta;
import modelo.IConsultaDAO;

public class ConsultaDAO implements IConsultaDAO{


	public boolean inserir(Consulta c) {
		Conexao con = Conexao.getInstancia();
		Connection c1 = con.conectar();
		try {
			String query = "INSERT INTO agenda_medico " + "(data, hora, descricao, valor, medico_id_medico, paciente_id_paciente) VALUES (?,?,?,?,?,?);";
			PreparedStatement stm = c1.prepareStatement(query);

			stm.setString(1, c.getData());
			stm.setString(2, c.getHora());
			stm.setString(3, c.getObs());
			stm.setLong(4, c.getValor());
			stm.setInt(5, c.getIdMedico());
			stm.setInt(6, c.getIdPaciente());
			stm.executeUpdate();
			con.fechaConexao();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}


	public boolean atualizar(Consulta c) {

		return false;
	}


	public boolean deletar(Consulta c) {

		return false;
	}

	@Override
	public ArrayList<Consulta> listaConsulta() {

		return null;
	}

}
