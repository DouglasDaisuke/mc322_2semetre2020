
public enum Estado {
	Acre ("AC", "Rio Branco"),
	Alagoas ("AL",  "Maceió"),
	Amapá ("AP", "Macapá"),
	Amazonas ("AM", "Manaus"),
	Bahia ("BA", "Salvador"),
	Ceará ("CE", "Fortaleza"),
	Distrito_Federal ("DF", "Brasília"),
	Espírito_Santo ("ES", "Vitória"),
	Goiás ("GO", "Goiânia"),
	Maranhão ("MA", "São Luís"),
	Mato_Grosso ("MT", "Cuiabá"),
	Mato_Grosso_do_sul ("MS", "Campo Grande"),
	Minas_Gerais ("MG", "Belo Horizonte"),
	Pará ("PA", "Belém"),
	Paraíba ("PB", "João Pessoa"),
	Paraná ("PR", "Curitiba"),
	Pernambuco ("PE", "Recife"),
	Piauí ("PI", "Teresina"),
	Rio_de_Janeiro ("RJ", "Rio de Janeiro"),
	Rio_Grande_do_Norte ("RN", "Natal"),
	Rio_Grande_do_Sul ("RS", "Porto Alegre"),
	Rondônia ("RO", "Porto Velho"),
	Roraima ("RR", "Boa Vista"),
	Santa_Catarina ("SC", "Florianópolis"),
	São_Paulo ("SP", "São Paulo"),
	Sergipe ("SE", "Aracaju"),
	Tocantins ("TO", "Palmas");
	
	
	private String sigla;
	private String capital;
	private String descricao;
	
	Estado(String sigla, String capital) {
		this.sigla = sigla;
		this.capital = capital;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public String getCapital() {
		return capital;
	}


}
