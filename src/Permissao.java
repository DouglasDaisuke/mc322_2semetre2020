import java.util.ArrayList;

public enum Permissao {
	ADICIONAR_USUARIO,
	REMOVER_USUARIO,
	ALTERAR_PERMISSAO,
	VISUALIZAR_INFO;
	
	private int id;
	private String description;
	
	public static ArrayList<Permissao> valuesInArrayList(){
		ArrayList<Permissao> p = new ArrayList<Permissao>();
		for (Permissao values : Permissao.values()) {
			p.add(values);
		}
		return p; 
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
