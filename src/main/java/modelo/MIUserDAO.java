package modelo;

import java.util.ArrayList;

public interface MIUserDAO {

	public boolean inserir(MUser p);
	
	public boolean atualizar( MUser p);
	
	public boolean deletar( MUser p);
	
	public ArrayList<MUser> listaAdministrador();
}
 