package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import controle.MedicoDAO;
import controle.PacienteDAO;
import controle.UsuarioDAO;
import modelo.Medico;
import modelo.Paciente;
import modelo.TipoSexo;

class PacienteTest {


	@Test
	@Order(1)
	public void testCadastro() {
		PacienteDAO pDao = new PacienteDAO();
		// chama conexão
		Paciente p = new Paciente();
		
		 p.setNome("Jose");
		 p.setCpf((long) 554454477);
	     p.setTelefone((long) 99099974);
	     String sexo = "M";
	     p.setSexo((TipoSexo.obterTipo(sexo)));
	     p.setEmail("jose@gmail");		  
		 assertTrue(pDao.inserir(p));
		
		Paciente pac = pDao.buscarPacientPorCpf(554454477);

		assertEquals("Jose", pac.getNome());
		assertEquals(554454477, pac.getCpf());
		assertEquals(99099974, pac.getTelefone());
		assertEquals("M", pac.getSexo());
		assertEquals("jose@gmail", pac.getEmail());
	}

	@Test
	@Order(2)
	public void testCadastroNaoE() {
		PacienteDAO pDao = new PacienteDAO();
		// chama conexão
		Paciente pac = pDao.buscarPacientPorCpf(22);
		assertNull(pac);
	}
	

	@Test
	@Order(4)
	public void testDeletar() {
		PacienteDAO pacDao = new PacienteDAO();
		// chama conexão
		Paciente pac = pacDao.buscarPacientPorCpf(352464);
		assertTrue(pacDao.deletar(pac));
	}


	@Test
	@Order(3)
	public void testAlterar() {
		PacienteDAO pacDao = new PacienteDAO();
		// chama conexão
		Paciente pac = pacDao.buscarPacientPorCpf(352464);
		pac.setNome("Alterado");
		pac.setEmail("desespero@gmail.com");
		assertTrue(pacDao.atualizar(pac));;
		
		pac = pacDao.buscarPacientPorCpf(352464);

		assertEquals("Alterado", pac.getNome());
		assertEquals(554454477, pac.getCpf());
		assertEquals(99099974, pac.getTelefone());
		assertEquals("M", pac.getSexo());
		assertEquals("desespero@gmail.com", pac.getEmail());
		
	}

}
