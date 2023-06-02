package model;

import java.util.ArrayList;

public interface MIPromptuaryDAO {
	public boolean inserir(MPromptuary pr);
	
	public ArrayList<MPromptuary> listaPronptuary(int idp);
}
