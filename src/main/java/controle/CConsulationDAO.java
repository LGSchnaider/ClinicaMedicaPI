package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.MConsultation;
import modelo.MIConsultationDAO;
import modelo.MDoctor;
import modelo.MPatient;
import modelo.MTyperGender;

public class CConsulationDAO implements MIConsultationDAO{


	public boolean inserir(MConsultation c) {
		CConnection con = CConnection.getInstancia();
		Connection c1 = con.conectar();
		try {
			String query = "INSERT INTO agenda_medico " + "(data, hora, descricao, valor, medico_id_medico, paciente_id_paciente) VALUES (?,?,?,?,?,?);";
			PreparedStatement stm = c1.prepareStatement(query);

			stm.setString(1, c.getData());
			stm.setString(2, c.getHora());
			stm.setString(3, c.getObs());
			stm.setString(4, c.getValor());
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


	public boolean edit(MConsultation c) {
		CConnection con = CConnection.getInstancia();
		Connection c1 = con.conectar();
		
		try {
			String query = "update agenda_medico set data = ?, hora = ?, descricao = ?, valor = ?, medico_id_medico = ?, paciente_id_paciente = ? where id = ?;";
			PreparedStatement stm = c1.prepareStatement(query);

			stm.setString(1, c.getData());
			stm.setString(2, c.getHora());
			stm.setString(3, c.getObs());
			stm.setString(4, c.getValor());
			stm.setInt(5, c.getIdMedico());
			stm.setInt(6, c.getIdPaciente());
			stm.setInt(7, c.getId());
			stm.executeUpdate();
			con.fechaConexao();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return false;
	}


	public boolean deletar(MConsultation c) {
		CConnection con = CConnection.getInstancia();
		Connection c1 = con.conectar();

		try {
			String query = "DELETE FROM agenda_medico WHERE id = ?;";
			PreparedStatement stm = c1.prepareStatement(query);
			stm.setInt(1, c.getId());

			stm.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.fechaConexao();

		return false;
	}

	@Override
	public ArrayList<MConsultation> listaConsulta() {

		// Instacia classe Conexao
		CConnection con = CConnection.getInstancia();
		Connection c = con.conectar();

		ArrayList<MConsultation> consultas = new ArrayList<>();
		try {
			Statement stm = c.createStatement();
			String query = "select agenda_medico.id, agenda_medico.data, agenda_medico.hora, agenda_medico.descricao, agenda_medico.valor, agenda_medico.medico_id_medico,"
					+ " agenda_medico.Paciente_id_paciente, medico.id as idMed, medico.nome as medNome, paciente.id as idPac, paciente.nome as pacNome from agenda_medico"
					+ " join medico on agenda_medico.medico_id_medico = medico.id join paciente on agenda_medico.Paciente_id_paciente = paciente.id;";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				int id = rs.getInt("id");
				String data = rs.getString("data");
				String hora = rs.getString("hora");
				String descricao = rs.getString("descricao");
				String valor = rs.getString("valor");
				int idDoctor = rs.getInt("medico_id_medico");
				int idPatient = rs.getInt("Paciente_id_paciente");
				int idMed = rs.getInt("idMed");
				String nomeMed = rs.getString("medNome");
				int idPac = rs.getInt("idPac");
				String nomePac = rs.getString("pacNome");
				
				MConsultation ct = new MConsultation();
				ct.setId(id);
				ct.setData(data);
				ct.setHora(hora);
				ct.setObs(descricao);
				ct.setValor(valor);
				ct.setIdPaciente(idPatient);
				ct.setIdMedico(idDoctor);		
				ct.setIdMedico(idMed);
				ct.setNameDoctor(nomeMed);
			    ct.setIdPaciente(idPac);
			    ct.setNamePatient(nomePac);
				
				consultas.add(ct);
				
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return consultas;
	}

}
