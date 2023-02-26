package modelo;

import java.util.ArrayList;

public interface IMedicoDAO {
	
	public boolean inserir(Medico p);
	
	public boolean atualizar( Medico p);
	
	public boolean deletar( Medico p);
	
	public ArrayList<Medico> listaMedico();

}
