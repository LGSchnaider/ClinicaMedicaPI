package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controle.MedicoDAO;
import controle.PacienteDAO;
import controle.UsuarioDAO;
import junit.framework.Assert;

import modelo.Medico;

import modelo.Pessoa;

class MedicoTest {

	@Test
	public void testCadastro() {
		MedicoDAO mdDao = new MedicoDAO();
		// chama conexão
		Medico m = new Medico();
		m.setNome("Dr.Lucas pereira");
		m.setCpf((long) 751542154);
		m.setUf("AC");
		m.setCrm((long) 954828);
		m.getUsuario().setLogin("BlaBla");
		m.getUsuario().setSenha("blabla");
		m.getUsuario().setPefil(1);
		UsuarioDAO udao = new UsuarioDAO();
		udao.inserir(m.getUsuario());

		assertTrue(mdDao.inserir(m));
		
		Medico medicoBuscado = mdDao.buscarMedicoPorCrm(crm);
		
		assertEquals("Dr.Lucas pereira",medicoBuscado.getNome());
		assertEquals(751542154, medicoBuscado.getCpf());
		assertEquals("AC", medicoBuscado.getUf());
		assertEquals(954828, medicoBuscado.getCrm());
		assertEquals("BlaBla", medicoBuscado.getUsuario().getLogin());
		assertEquals("blabla", medicoBuscado.getUsuario().getSenha());
		assertEquals(1, medicoBuscado.getUsuario().getPerfil());
	}
}
