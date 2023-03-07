package controle;

import modelo.Paciente;

public class TesteDAO {

	public static void main(String[] args) {
		PacienteDAO pdao = new PacienteDAO();
		
		Paciente p = new Paciente();
		p.setNome("fsfsdfsd");
		p.setCpf(11546);
		p.setSexo("m");
		p.setEmail("aadad");
		pdao.inserir(p);

	}

}
