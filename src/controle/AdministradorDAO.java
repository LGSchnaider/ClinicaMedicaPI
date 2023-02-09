package controle;

import java.util.ArrayList;

import modelo.IAdministradorDAO;
import modelo.Administrador;

public class AdministradorDAO implements IAdministradorDAO {

	private static ArrayList<Administrador> produtos;
	private static AdministradorDAO instancia;

	/**
	 * Padrao singleton
	 */
	private AdministradorDAO() {
	}

	public static AdministradorDAO getInstancia() {

		if (instancia == null) {
			instancia = new AdministradorDAO();
			produtos = new ArrayList<>();

			Administrador p1 = new Administrador();
			p1.setNome("Bola");
			p1.setCategoria("Brinquedo");
			p1.setValor(30.00);

			Administrador p2 = new Administrador();
			p2.setNome("Carrinho de controle remoto");
			p2.setCategoria("Brinquedo");
			p2.setValor(120.00);

			Administrador p3 = new Administrador();
			p3.setNome("Kinder ovo");
			p3.setCategoria("Alimento");
			p3.setValor(8.00);

			produtos.add(p1);
			produtos.add(p2);
			produtos.add(p3);
		}

		return instancia;
	}

	public ArrayList<Administrador> listarProduto() {
		return produtos;
	}

	@Override
	public boolean inserir(Administrador p) {
		if (p != null) {
			produtos.add(p);
			return true;
		}
		return false;
	}
	
	
	public void deletar(int p) {
		produtos.remove(p);
	}

}
