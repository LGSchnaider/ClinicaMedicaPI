package modelo;

import java.util.ArrayList;

public interface IMedicamentoDAO {
	
	public boolean inserir(Medicamento p);
	
	public boolean atualizar( Medicamento p);
	
	public boolean deletar( Medicamento p);
	
	public ArrayList<Medicamento> listaMedicamento();


}
