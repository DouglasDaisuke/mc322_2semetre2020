
public enum Sexo {
	Homem("H"),
	Mulher("M");

	Sexo(String sigla) {
		this.sigla = sigla;
	}

	private String sigla;
	private String nomePorExtenso;
	
	public String getSigla() {
		return sigla;
	}
	
	public String getNomePorExtenso() {
		return nomePorExtenso;
	}

	public void setNomePorExtenso(String nomePorExtenso) {
		this.nomePorExtenso = nomePorExtenso;
	}

}
