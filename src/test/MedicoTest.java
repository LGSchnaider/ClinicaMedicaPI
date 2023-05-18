package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import controle.MedicoDAO;
import controle.UsuarioDAO;
import modelo.Medico;

@TestMethodOrder(OrderAnnotation.class)
class MedicoTest {

	@Test
	@Order(1)
	public void testCadastro() {
		MedicoDAO mdDao = new MedicoDAO();
		// chama conexão
		Medico m = new Medico();
		
		 m.setNome("Dr.Lucas pereira");
		 m.setCpf((long) 554454477);
		 m.setUf("AC");
		 m.setCrm((long) 352464);
		 m.getUsuario().setLogin("BlaBla");
		 m.getUsuario().setSenha("blabla");
		 m.getUsuario().setPefil(1); 
		 UsuarioDAO udao = new UsuarioDAO();
		 udao.inserir(m.getUsuario());
		  
		 assertTrue(mdDao.inserir(m));
		
		Medico medicoBuscado = mdDao.buscarMedicoPorCrm(352464);

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
		MedicoDAO mdDao = new MedicoDAO();
		// chama conexão
		Medico medicoBuscado = mdDao.buscarMedicoPorCrm(22);
		assertNull(medicoBuscado);
	}


}
