
public enum Sexo {
	Homem("H", "descricao do homem"),
	Mulher("M", "descricao da mulher");

	Sexo(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	private String sigla;
	private String descricao;
	
	public String getSigla() {
		return sigla;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
