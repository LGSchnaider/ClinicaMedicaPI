package model;

import java.sql.Date;
import java.sql.Time;

public class MConsultation{
	private int id;
	private String date;
	private String hour;
	private String obs;
	private String value;
	private int idDoctor;
	private int idPatient;
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
		return value;
	}
	public void setValor(String valorInt) {
		this.value = valorInt;
	}
	
	public String getData() {
		return date;
	}
	public void setData(String data) {
		this.date = data;
	}
	public String getHora() {
		return hour;
	}
	public void setHora(String hora) {
		this.hour = hora;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public int getIdMedico() {
		return idDoctor;
	}
	public void setIdMedico(int idMedico) {
		this.idDoctor = idMedico;
	}
	public int getIdPaciente() {
		return idPatient;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPatient = idPaciente;
	}
	
		
	}

