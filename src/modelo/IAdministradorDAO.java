package modelo;

import java.util.ArrayList;

public interface IAdministradorDAO {

	public boolean inserir(Administrador p);
	
	public boolean atualizar( Administrador p);
	
	public boolean deletar( Administrador p);
	
	public ArrayList<Administrador> listaAdministrador();
}
 