import java.util.ArrayList;

public enum Permissao {
	ADICIONAR_USUARIO (1, "o usuario tem permissao de adicionar um membro"),
	REMOVER_USUARIO (2, "o usuario tem permissao de remover um membro"),
	ALTERAR_PERMISSAO (3, "o usuario tem permissao de alterar as permissao de um membro"),
	VISUALIZAR_INFO (4, "o usuario tem permissao de visualizar as informações do grupo"),
	CRIAR_CARTAO (5, "o usuario tem permissao de criar um cartao");
	
	private int codigo;
	private String descricao;
	
	Permissao(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static ArrayList<Permissao> valuesInArrayList(){
		ArrayList<Permissao> p = new ArrayList<Permissao>();
		for (Permissao values : Permissao.values()) {
			p.add(values);
		}
		return p; 
	}
	
	public int getcodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
