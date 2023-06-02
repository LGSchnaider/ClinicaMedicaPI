package model;

import java.util.ArrayList;

public interface MIDoctorDAO {
	
	public boolean inserir(MDoctor p);
	
	public boolean atualizar( MDoctor p);
	
	public boolean deletar( MDoctor p);
	
	public ArrayList<MDoctor> listaMedico();

}
