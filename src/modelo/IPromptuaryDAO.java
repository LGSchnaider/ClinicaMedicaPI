package modelo;

import java.util.ArrayList;

public interface IPromptuaryDAO {
	public boolean inserir(Promptuary pr);
	
	public boolean atualizar(Promptuary pr);
	
	public boolean deletar(Promptuary pr);
	
	public ArrayList<Promptuary> listaConsulta();
}
