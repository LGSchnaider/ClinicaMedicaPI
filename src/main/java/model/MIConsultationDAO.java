package model;

import java.util.ArrayList;

public interface MIConsultationDAO {
	public boolean inserir(MConsultation c);
	
	public boolean edit(MConsultation c);
	
	public boolean deletar(MConsultation c);
	
	public ArrayList<MConsultation> listaConsulta();
}
