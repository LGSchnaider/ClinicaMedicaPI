package modelo;

import java.util.ArrayList;

public interface ISecretariaDAO {
	
	public boolean inserir(Secretaria p);
	
	public boolean atualizar( Secretaria p);
	
	public boolean deletar( Secretaria p);
	
	public ArrayList<Secretaria> listaSecretaria();

}
