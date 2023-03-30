package modelo;

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
