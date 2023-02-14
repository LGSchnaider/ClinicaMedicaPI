package controle;

import java.util.ArrayList;

import modelo.IAdministradorDAO;
import modelo.Administrador;

public class AdministradorDAO implements IAdministradorDAO {

	private static ArrayList<Administrador> produtos;
	private static AdministradorDAO instancia;


	private AdministradorDAO() {
	}

	public static AdministradorDAO getInstancia() {

		if (instancia == null) {
			instancia = new AdministradorDAO();
			produtos = new ArrayList<>();
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
