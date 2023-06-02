package model;

import java.util.ArrayList;

public interface MIPatientDAO {

	public boolean inserir(MPatient p);
	
	public boolean atualizar( MPatient p);
	
	public boolean deletar( MPatient p);
	
	public ArrayList<MPatient> listaPaciente();

}
