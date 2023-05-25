package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.MConsultation;
import modelo.MIPromptuaryDAO;
import modelo.MPromptuary;

public class CPromptuaryDAO implements MIPromptuaryDAO{

	@Override
	public boolean inserir(MPromptuary pr) {
		CConnection con = CConnection.getInstancia();
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
		}finally {
			con.fechaConexao();
		}
		return false;
	}

	public ArrayList<MPromptuary> listaPronptuary(int idp) {
		// Instacia classe Conexao
				CConnection con = CConnection.getInstancia();
				Connection c = con.conectar();

				ArrayList<MPromptuary> promptuarys = new ArrayList<>();
				try {
					Statement stm = c.createStatement();
					String query = "select prontuario.id, prontuario.data, prontuario.observacao, prontuario.valor, prontuario.medico_id_medico, prontuario.Paciente_id_paciente, medico.id as idMed, medico.nome as medNome, paciente.id as idPac, paciente.nome as pacNome from prontuario join medico on prontuario.medico_id_medico = medico.id join paciente on prontuario.Paciente_id_paciente = paciente.id where prontuario.paciente_id_paciente ="+idp+";";
					ResultSet rs = stm.executeQuery(query);
					while (rs.next()) {

						int id = rs.getInt("id");
						String data = rs.getString("data");
						String obs = rs.getString("observacao");
						String valor = rs.getString("valor");
						int idDoctor = rs.getInt("medico_id_medico");
						int idPatient = rs.getInt("Paciente_id_paciente");
						int idMed = rs.getInt("idMed");
						String nomeMed = rs.getString("medNome");
						int idPac = rs.getInt("idPac");
						String nomePac = rs.getString("pacNome");
						
						MPromptuary pr = new MPromptuary();
						pr.setId(id);
						pr.setData(data);
						pr.setObs(obs);
						pr.setValor(valor);
						pr.setIdPaciente(idPatient);
						pr.setIdMedico(idDoctor);		
						pr.setIdMedico(idMed);
						pr.setNameDoctor(nomeMed);
					    pr.setIdPaciente(idPac);
					    pr.setNamePatient(nomePac);
						
						promptuarys.add(pr);
						
						
					}

				} catch (SQLException e) {

					e.printStackTrace();
				}finally {
					con.fechaConexao();
				}

				return promptuarys;

	}

}
