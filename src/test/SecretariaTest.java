package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import controle.SecretariaDAO;
import controle.UsuarioDAO;
import modelo.Medico;
import modelo.Secretaria;

class SecretariaTest {

	@Test
	public void testCadastro() {
		SecretariaDAO secDAO = new SecretariaDAO();
		// chama conexão
		 Secretaria s = new Secretaria();
		
		 s.setNome("Dr.Lucas pereira");
		 s.setCpf((long) 554454477);
		 s.setTelefone((long) 54545888);
		 s.setId((int) 352464);
		 s.getUsuario().setLogin("Francis");
		 s.getUsuario().setSenha("fras");
		 s.getUsuario().setPefil(3); 
		 UsuarioDAO udao = new UsuarioDAO();
		 udao.inserir(s.getUsuario());
		  
		 assertTrue(secDAO.inserir(s));
		
/*		Secretaria medicoBuscado = secDAO.();

		assertEquals("Dr.Lucas pereira", medicoBuscado.getNome());
		assertEquals(554454477, medicoBuscado.getCpf());
		assertEquals("AC", medicoBuscado.getId());
		assertEquals(352464, medicoBuscado.getTelefone());
		assertEquals("BlaBla", medicoBuscado.getUsuario().getLogin());
		assertEquals("blabla", medicoBuscado.getUsuario().getSenha());
		assertEquals(1, medicoBuscado.getUsuario().getPerfil());

	}

	@Test
	@Order(2)
	public void testCadastroNaoE() {
		SecretariaDAO secDao = new SecretariaDAO();
		// chama conexão
		Medico medicoBuscado = secDao.listaSecretaria(22);
		assertNull(medicoBuscado);
	}

	@Test
	@Order(4)
	public void testDeletar() {
		MedicoDAO mdDao = new MedicoDAO();
		// chama conexão
		Medico medicoBuscado = mdDao.buscarMedicoPorCrm(352464);
		assertTrue(mdDao.deletar(medicoBuscado));
	}


	@Test
	@Order(3)
	public void testAlterar() {
		MedicoDAO mdDao = new MedicoDAO();
		// chama conexão
		Medico medicoBuscado = mdDao.buscarMedicoPorCrm(352464);
		medicoBuscado.setNome("Alterado");
		medicoBuscado.setUf("SC");
		medicoBuscado.getUsuario().setLogin("Alt");
		medicoBuscado.getUsuario().setSenha("alt");
		assertTrue(mdDao.atualizar(medicoBuscado));;
		
		medicoBuscado = mdDao.buscarMedicoPorCrm(352464);

		assertEquals("Alterado", medicoBuscado.getNome());
		assertEquals(554454477, medicoBuscado.getCpf());
		assertEquals("SC", medicoBuscado.getUf());
		assertEquals(352464, medicoBuscado.getCrm());
		assertEquals("Alt", medicoBuscado.getUsuario().getLogin());
		assertEquals("alt", medicoBuscado.getUsuario().getSenha());
		assertEquals(1, medicoBuscado.getUsuario().getPerfil());
		
	*/}
}
