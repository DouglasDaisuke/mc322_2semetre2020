
public enum Estado {
	Acre ("AC", "Rio Branco","descricao do acre"),
	Alagoas ("AL",  "Maceió","descricao de alagoas"),
	Amapá ("AP", "Macapá","descricao do amapa"),
	Amazonas ("AM", "Manaus","descricao do amazonas"),
	Bahia ("BA", "Salvador","descricao da bahia"),
	Ceará ("CE", "Fortaleza","descricao do ceara"),
	Distrito_Federal ("DF", "Brasília","descricao do distrito federal"),
	Espírito_Santo ("ES", "Vitória","descricao do espirito santo"),
	Goiás ("GO", "Goiânia","descricao de goias"),
	Maranhão ("MA", "São Luís", "descricao do maranhao"),
	Mato_Grosso ("MT", "Cuiabá","descricao do mato grosso"),
	Mato_Grosso_do_sul ("MS", "Campo Grande","descricao do mato grosso do sul"),
	Minas_Gerais ("MG", "Belo Horizonte","descricao de minas"),
	Pará ("PA", "Belém","descricao do pará"),
	Paraíba ("PB", "João Pessoa","descricao do paraiba"),
	Paraná ("PR", "Curitiba","descricao do parana"),
	Pernambuco ("PE", "Recife","descricao do Pernambuco"),
	Piauí ("PI", "Teresina","descricao do piaui"),
	Rio_de_Janeiro ("RJ", "Rio de Janeiro","descricao do rio de janeiro"),
	Rio_Grande_do_Norte ("RN", "Natal", "descricao do rio grande do norte"),
	Rio_Grande_do_Sul ("RS", "Porto Alegre","descricao do rio grande do sul"),
	Rondônia ("RO", "Porto Velho","descricao de rondonia"),
	Roraima ("RR", "Boa Vista","descricao do roraima"),
	Santa_Catarina ("SC", "Florianópolis","descricao do santa catarina"),
	São_Paulo ("SP", "São Paulo","descricao do sao paulo"),
	Sergipe ("SE", "Aracaju","descricao do sergipe"),
	Tocantins ("TO", "Palmas","descricao do tocantins");
	
	
	private String sigla;
	private String capital;
	private String descricao;
	
	Estado(String sigla, String capital, String descricao) {
		this.sigla = sigla;
		this.capital = capital;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public String getCapital() {
		return capital;
	}


}
