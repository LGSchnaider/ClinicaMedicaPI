package modelo;

import java.util.ArrayList;

public interface IConsultaDAO {
	public boolean inserir(Consulta c);
	
	public boolean atualizar(Consulta c);
	
	public boolean deletar(Consulta c);
	
	public ArrayList<Consulta> listaConsulta();
}
