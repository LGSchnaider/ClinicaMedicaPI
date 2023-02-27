package modelo;

import java.util.ArrayList;

public interface IPacienteDAO {

	public boolean inserir(Paciente p);
	
	public boolean atualizar( Paciente p);
	
	public boolean deletar( Paciente p);
	
	public ArrayList<Paciente> listaPaciente();

}
