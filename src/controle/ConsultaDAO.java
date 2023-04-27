package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.crypto.Data;

import com.mysql.cj.xdevapi.Statement;

import modelo.Consulta;
import modelo.IConsultaDAO;
import modelo.Medico;
import modelo.Paciente;

public class ConsultaDAO implements IConsultaDAO{


	public boolean inserir(Consulta c) {
		Conexao con = Conexao.getInstancia();
		
		con.conectar();
		
		Connection c1 = con.conectar();
		
		
		try {
			String query = "INSERT INTO agenda_medico " + "(data, hora, descricao, medico_id_medico, paciente_id_paciente) VALUES (?,?,?,?,?);";
			PreparedStatement stm = c1.prepareStatement(query);

			stm.setDate(1, c.getData());
			stm.setTime(2, c.getHora());
			stm.setString(3, c.getObs());
			stm.setInt(4, c.getIdMedico());
			stm.setInt(5, c.getIdPaciente());
			
			stm.executeUpdate();
			con.fechaConexao();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}


	public boolean atualizar(Consulta c) {
		Conexao con = Conexao.getInstancia();
		Connection c1 = con.conectar();
		
		try {
			String query = "upadte agenda_medico on data = ?, hora = ?, descricao = ?";
			PreparedStatement stm = c1.prepareStatement(query);
			
			stm.setDate(1, c.getData());
			stm.setTime(2, c.getHora());
			stm.setString(3, c.getObs());
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		con.fechaConexao();
		return false;	
	}


	public boolean deletar(Consulta c) {
		Conexao con = Conexao.getInstancia();
		Connection cl = con.conectar();
		
		ConsultaDAO dao = new ConsultaDAO();
		//dao.deletar(c.getIdPaciente());
		return false;
	}



	public ArrayList<Consulta> listaConsulta() {
		
		Conexao con = Conexao.getInstancia();
		Connection cl = con.conectar();
		
		ArrayList<Consulta> consultas = new ArrayList<>();
		try {
			Statement stm = (Statement) cl.createStatement();
			
			//Resolve ai,porque não sei, Obg
			String query = "select agenda_medico as medico.id, paciente.id, data, hora, Obs";
			ResultSet rs = ((java.sql.Statement) stm).executeQuery(query);
			while(rs.next()) {
				int idMedico = rs.getInt("MedicoID");
				int idPaciente = rs.getInt("PacienteID");
				Date Data = rs.getDate("data");
				Time Hora = rs.getTime("hora");
				String Obs = rs.getString("Obs");
				
				Medico p = new Medico();
				p.setId(idMedico);
				
				Paciente pl = new Paciente();
				pl.setId(idPaciente);
				
				consultas.addAll((Collection<? extends Consulta>) p);
				consultas.addAll((Collection<? extends Consulta>) pl);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		con.fechaConexao();
		return consultas;
	}

}
