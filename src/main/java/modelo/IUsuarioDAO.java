package modelo;

import java.util.ArrayList;

public interface IUsuarioDAO {

	public boolean inserir(Usuario p);
	
	public boolean atualizar( Usuario p);
	
	public boolean deletar( Usuario p);
	
	public ArrayList<Usuario> listaAdministrador();
}
 