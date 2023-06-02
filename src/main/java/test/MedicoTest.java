package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import controll.CDoctorDAO;
import controll.CUserDAO;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import model.MDoctor;

@TestMethodOrder(OrderAnnotation.class)
class MedicoTest {


	@Test
	@Order(1)
	public void testCadastro() {
		CDoctorDAO mdDao = new CDoctorDAO();
		// chama conexão
		MDoctor m = new MDoctor();
		
		 m.setNome("Dr.Lucas pereira");
		 m.setCpf((long) 554454477);
		 m.setUf("AC");
		 m.setCrm((long) 352464);
		 m.getUsuario().setLogin("BlaBla");
		 m.getUsuario().setSenha("blabla");
		 m.getUsuario().setPefil(1); 
		 CUserDAO udao = new CUserDAO();
		 udao.inserir(m.getUsuario());
		 assertTrue(mdDao.inserir(m));
		
		MDoctor medicoBuscado = mdDao.buscarMedicoPorCrm(352464);

		assertEquals("Dr.Lucas pereira", medicoBuscado.getNome());
		assertEquals(554454477, medicoBuscado.getCpf());
		assertEquals("AC", medicoBuscado.getUf());
		assertEquals(352464, medicoBuscado.getCrm());
		assertEquals("BlaBla", medicoBuscado.getUsuario().getLogin());
		assertEquals("blabla", medicoBuscado.getUsuario().getSenha());
		assertEquals(1, medicoBuscado.getUsuario().getPerfil());

	}

	@Test
	@Order(2)
	public void testCadastroNaoE() {
		CDoctorDAO mdDao = new CDoctorDAO();
		// chama conexão
		MDoctor medicoBuscado = mdDao.buscarMedicoPorCrm(22);
		assertNull(medicoBuscado);
	}

	@Test
	@Order(4)
	public void testDeletar() {
		CDoctorDAO mdDao = new CDoctorDAO();
		// chama conexão
		MDoctor medicoBuscado = mdDao.buscarMedicoPorCrm(352464);
		assertTrue(mdDao.deletar(medicoBuscado));
	}


	@Test
	@Order(3)
	public void testAlterar() {
		CDoctorDAO mdDao = new CDoctorDAO();
		// chama conexão
		MDoctor medicoBuscado = mdDao.buscarMedicoPorCrm(352464);
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
		
	}

}
