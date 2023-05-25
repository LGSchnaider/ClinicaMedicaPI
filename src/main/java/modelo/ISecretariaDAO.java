package modelo;

import java.util.ArrayList;

public interface ISecretariaDAO {
	
	public boolean inserir(MSecretary p);
	
	public boolean atualizar( MSecretary p);
	
	public boolean deletar( MSecretary p);
	
	public ArrayList<MSecretary> listaSecretaria();

}
