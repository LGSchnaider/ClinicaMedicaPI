package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controle.MedicoDAO;
import controle.PacienteDAO;
import junit.framework.Assert;

import modelo.Medico;

import modelo.Pessoa;

class MedicoTest {


	
	@Test
	 public boolean testCadastro() {
		MedicoDAO mdDao = new MedicoDAO();
		//chama conexão
		Medico m = new Medico();
		
		
		m.setNome("Dr.Lucas pereira");
		m.setCpf((long) 554578445);
		m.setUf("SP");
		m.setCrm((long) 952565);
		
		
        mdDao.inserir(m);
		
		mdDao.listaMedico();
		assertTrue(mdDao.inserir(m));
		
		System.out.println("Teste feito com sucesso");
		
		return false;
		
	}
}
