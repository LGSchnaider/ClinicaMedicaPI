package modelo;

public enum TipoSexo {
	
	MASCULINO("M", "Masculino"),
	FEMININO("F", "Feminino"),
	NAO_DEFINIDO("N", "Não Definido");
	
	

	TipoSexo(String sexo, String descricao) {
		this.codigo = sexo;
		this.descricao = descricao;
	}
	private String descricao;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	private String codigo;

	public static TipoSexo obterTipo(String descricao) {
		if(descricao.equals(MASCULINO.getCodigo())) {
			return MASCULINO;
		}
		if(descricao.equals(FEMININO.getCodigo())) {
			return FEMININO;
		}
		return NAO_DEFINIDO;
	}
}
