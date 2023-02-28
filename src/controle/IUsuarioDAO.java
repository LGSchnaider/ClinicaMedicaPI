package controle;

import java.util.ArrayList;

import modelo.Usuario;

public interface IUsuarioDAO {

	public boolean inserir(Usuario p);
	
	public boolean atualizar( Usuario p);
	
	public boolean deletar( Usuario p);
	
	public ArrayList<Usuario> listaAdministrador();
}
 