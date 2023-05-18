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
		//chama conexão
		Medico m = new Medico();
		m.setNome("Dr.Lucas pereira");
		m.setCpf((long) 262532655);
		m.setUf("AC");
		m.setCrm((long) 545158);
		m.getUsuario().setIdusuario(15);
		m.getUsuario().setLogin("BlaBla");
		m.getUsuario().setSenha("blabla");
		m.getUsuario().setPefil(1);
		UsuarioDAO udao = new UsuarioDAO();
		udao.inserir(m.getUsuario());
        mdDao.inserir(m);
		assertEquals("Dr.Lucas pereira", m.getNome());
		
	}
}
