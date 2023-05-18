package test;

import modelo.Secretaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controle.SecretariaDAO;



public class SecretariaTest {
	
	@Test
	 public boolean testSecretariaCadastro() {
		
		SecretariaDAO secDao = new SecretariaDAO();
		//chamar a conexão
		Secretaria s = new Secretaria();
		/*
		 * O que está no banco:
		 * insert into secretaria (nome, cpf, telefone, email, usuario_idusuario) 
		 * values ('Matilda Frank', 65656595956, 54545888, 'mfrank@gmail.com', 8);
		 */
		
		s.setNome("M");
		s.setCpf((long) 656565959);
		s.setTelefone(54545888);
		s.setEmail("mfrank@gmail.com");
		
		
		secDao.inserir(s);
		
		secDao.listaSecretaria();
		
		
		if(s.getNome() == "Matilda Frank" || s.getCpf()== 656565959 || s.getTelefone() == 54545888 || s.getEmail() == "mfrank@gmail.com" ) 
		{
			assertTrue(secDao.inserir(s));
			System.out.println("Teste feito com sucesso");
		} else {
			System.out.println("Não está correto");
		}
		
		return false;
	}

}
