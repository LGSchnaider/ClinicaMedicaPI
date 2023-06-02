package model;

import java.util.ArrayList;

public interface MIMedicineDAO {
	
	public boolean inserir(MMedicine p);
	
	public boolean atualizar( MMedicine p);
	
	public boolean deletar( MMedicine p);
	
	public ArrayList<MMedicine> listaMedicamento();


}
