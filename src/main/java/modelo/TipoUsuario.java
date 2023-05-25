package modelo;

import java.util.ArrayList;

/**
 * Constantes
 * 
 * 
 * Este enum nao eh uma classe. Nao eh instanciavel.
 * 
 */
public enum TipoUsuario {

	MED_ADMIN(0, "Médico Administrativo"),
	MED_COMUM(1, "Médico Comum"),
	SEC_ADMIN(2, "Secretária Administrativo"),
	SEC_COMUM(3, "Secretária Comum");

	public static ArrayList<TipoUsuario> getTiposMedico() {
		ArrayList<TipoUsuario> arr = new ArrayList<TipoUsuario>();
		arr.add(MED_ADMIN);
		arr.add(MED_COMUM);
		return arr;
	}
	public static ArrayList<TipoUsuario> getTiposSecretarias() {
		ArrayList<TipoUsuario> arr = new ArrayList<TipoUsuario>();
		arr.add(SEC_ADMIN);
		arr.add(SEC_COMUM);
		return arr;
	}
	TipoUsuario(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	private int codigo;
	private String descricao;

	public int getCodigo() {
		return codigo;
	}

	public String getDesc() {
		return descricao;
	}

	public static TipoUsuario getTipoUsuarioPorCodigo(int codigo) {

		TipoUsuario tipoUsuario = null;
		for (TipoUsuario tipo : TipoUsuario.values()) {
			if (codigo == tipo.getCodigo()) {
				tipoUsuario = tipo;
			}

		}
		return tipoUsuario;

	}

}
