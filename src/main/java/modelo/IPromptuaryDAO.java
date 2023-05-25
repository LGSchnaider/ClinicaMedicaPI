package modelo;

import java.util.ArrayList;

public interface IPromptuaryDAO {
	public boolean inserir(Promptuary pr);
	
	public ArrayList<Promptuary> listaPronptuary(int idp);
}
