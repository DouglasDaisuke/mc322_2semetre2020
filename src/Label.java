
public enum Label {
	 TO_DO ("urgente", "vermelho"),
	 DOING ("atenção", "amarelo"),
	 DONE ("ok", "verde");
	
	private String rotulo;
	private String cor;
	
	Label(String rotulo, String cor) {
		this.cor = cor;
		this.rotulo = rotulo;
	}

	public String getRotulo() {
		return rotulo;
	}
	
	public String getCor() {
		return cor;
	}
}
