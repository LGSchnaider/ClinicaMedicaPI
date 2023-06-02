package model;

import java.util.ArrayList;

/**
 * Constantes
 * 
 * 
 * Este enum nao eh uma classe. Nao eh instanciavel.
 * 
 */
public enum MTypeUser {

	MED_ADMIN(0, "Médico Administrativo"),
	MED_COMUM(1, "Médico Comum"),
	SEC_ADMIN(2, "Secretária Administrativo"),
	SEC_COMUM(3, "Secretária Comum");

	public static ArrayList<MTypeUser> getTiposMedico() {
		ArrayList<MTypeUser> arr = new ArrayList<MTypeUser>();
		arr.add(MED_ADMIN);
		arr.add(MED_COMUM);
		return arr;
	}
	public static ArrayList<MTypeUser> getTiposSecretarias() {
		ArrayList<MTypeUser> arr = new ArrayList<MTypeUser>();
		arr.add(SEC_ADMIN);
		arr.add(SEC_COMUM);
		return arr;
	}
	MTypeUser(int codigo, String descricao) {
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

	public static MTypeUser getTipoUsuarioPorCodigo(int codigo) {

		MTypeUser tipoUsuario = null;
		for (MTypeUser tipo : MTypeUser.values()) {
			if (codigo == tipo.getCodigo()) {
				tipoUsuario = tipo;
			}

		}
		return tipoUsuario;

	}

}
