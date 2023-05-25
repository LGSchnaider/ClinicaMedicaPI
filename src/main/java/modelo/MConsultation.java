package modelo;

import java.sql.Date;
import java.sql.Time;

public class MConsultation{
	private int id;
	private String data;
	private String hora;
	private String obs;
	private String valor;
	private int idMedico;
	private int idPaciente;
	private String nameDoctor;
	private String namePatient;
	
	public String getNameDoctor() {
		return nameDoctor;
	}
	
	public void setNameDoctor(String nameDoctor) {
		this.nameDoctor = nameDoctor;
	}
	
	public String getNamePatient() {
		return namePatient;
	}
	
	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}
	public void setValor(String valorInt) {
		this.valor = valorInt;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	
		
	}

