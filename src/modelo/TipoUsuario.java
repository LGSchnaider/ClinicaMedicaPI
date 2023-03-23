package modelo;

/**
 * Constantes
 * 
 * 
 * Este enum nao eh uma classe.
 * Nao eh instanciavel.
 * 
 */
public enum TipoUsuario {

	ADMIN(0, "Administrador"), COMUM(1, "Comum");
	
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
