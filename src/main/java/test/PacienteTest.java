package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import controll.CDoctorDAO;
import controll.CPatientDAO;
import controll.CUserDAO;
import model.MDoctor;
import model.MPatient;
import model.MTyperGender;

class PacienteTest {


	@Test
	@Order(1)
	public void testCadastro() {
		CPatientDAO pDao = new CPatientDAO();
		// chama conexão
		MPatient p = new MPatient();
		
		 p.setNome("Jose");
		 p.setCpf((long) 455445553);
	     p.setTelefone((long) 99099974);
	     String sexo = "M";
	     p.setSexo((MTyperGender.obterTipo(sexo)));
	     p.setEmail("jose@gmail");		  
		 assertTrue(pDao.inserir(p));
		
		MPatient pac = pDao.buscarPacientPorCpf(455445553);

		assertEquals("Jose", pac.getNome());
		assertEquals(455445553, pac.getCpf());
		assertEquals(99099974, pac.getTelefone());
		assertEquals("jose@gmail", pac.getEmail());
	}

	@Test
	@Order(2)
	public void testCadastroNaoE() {
		CPatientDAO pDao = new CPatientDAO();
		// chama conexão
		MPatient pac = pDao.buscarPacientPorCpf(22);
		assertNull(pac);
	}
	

	@Test
	@Order(4)
	public void testDeletar() {
		CPatientDAO pacDao = new CPatientDAO();
		// chama conexão
		assertTrue(pacDao.deletar(455445553));
	}


	@Test
	@Order(3)
	public void testAlterar() {
		CPatientDAO pacDao = new CPatientDAO();
		// chama conexão
		MPatient pac = pacDao.buscarPacientPorCpf(455445553);
		pac.setNome("Alterado");
		pac.setEmail("desespero@gmail.com");
		assertTrue(pacDao.atualizar(pac));;
		
		pac = pacDao.buscarPacientPorCpf(455445553);

		assertEquals("Alterado", pac.getNome());
		assertEquals(554454477, pac.getCpf());
		assertEquals(99099974, pac.getTelefone());
		assertEquals("M", pac.getSexo());
		assertEquals("desespero@gmail.com", pac.getEmail());
		
	}

}
