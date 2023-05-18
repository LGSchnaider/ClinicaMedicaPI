package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import controle.SecretariaDAO;
import controle.UsuarioDAO;
import modelo.Secretaria;

@TestMethodOrder(OrderAnnotation.class)
public class SecretariaTest {

	@Test
	@Order(1)
	public void testCadastro() {
		SecretariaDAO secDao = new SecretariaDAO();
		// chama conexão
		Secretaria s = new Secretaria();

		s.setNome("Matilda Frank");
		s.setCpf((long) 515155664);
		s.setEmail("mfrank@gmail.com");
		s.setTelefone(44444555);
		s.getUsuario().setLogin("BlaBla");
		s.getUsuario().setSenha("blabla");
		s.getUsuario().setPefil(1);
		 UsuarioDAO udao = new UsuarioDAO();
		 udao.inserir(s.getUsuario());
		 assertTrue(secDao.inserir(s));

		Secretaria secretariaBuscada = secDao.buscarSecretariaPorCpf(515155664);

		assertEquals("Matilda Frank", secretariaBuscada.getNome());
		assertEquals(515155664, secretariaBuscada.getCpf());
		assertEquals("mfrank@gmail.com", secretariaBuscada.getEmail());
		assertEquals(44444555, secretariaBuscada.getTelefone());

		assertEquals("BlaBla", secretariaBuscada.getUsuario().getLogin());
		assertEquals("blabla", secretariaBuscada.getUsuario().getSenha());
		assertEquals(1, secretariaBuscada.getUsuario().getPerfil());

	}

	@Test
	@Order(2)
	public void testCadastroNaoE() {
		SecretariaDAO secDao = new SecretariaDAO();
		// chama conexão
		Secretaria secretariaBuscada = secDao.buscarSecretariaPorCpf(252);
		assertNull(secretariaBuscada);
	}

	@Test
	@Order(4)
	public void testDeletar() {
		SecretariaDAO secDao = new SecretariaDAO();
		// chama conexão
		Secretaria secretariaBuscada = secDao.buscarSecretariaPorCpf(515155664);
		assertTrue(secDao.deletar(secretariaBuscada));
	}

	@Test
	@Order(3)
	public void testAlterar() {
		SecretariaDAO secDao = new SecretariaDAO();
		// chama conexão
		Secretaria secretariaBuscada = secDao.buscarSecretariaPorCpf(515155664);
		secretariaBuscada.setNome("Alterado");
		secretariaBuscada.setEmail("esse@emailaki");
		secretariaBuscada.setTelefone(66666666);

		assertTrue(secDao.atualizar(secretariaBuscada));
		secretariaBuscada = secDao.buscarSecretariaPorCpf(515155664);
		assertEquals("Alterado", secretariaBuscada.getNome());
		assertEquals(515155664, secretariaBuscada.getCpf());
		assertEquals(66666666, secretariaBuscada.getTelefone());
		assertEquals("esse@emailaki", secretariaBuscada.getEmail());
		
		assertEquals(1, secretariaBuscada.getUsuario().getPerfil());

	}

}
