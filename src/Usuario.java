import java.util.ArrayList;
import java.util.Calendar;

public class Usuario {
	private static int numUsuarios;
	private int id;
	private String login;
	private String email;
	private String senha;
	private String descricao;
	private boolean status;
	private ArrayList<Grupo> grupos;
	private Calendar dataAtivacao;

	public Usuario(String login, String email,String senha,String descricao, boolean status, 
			ArrayList<Grupo> grupos, Calendar dataAtivacao) {
		this.id = numUsuarios;
		setNumUsuarios( numUsuarios + 1);
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.descricao = descricao;
		this.status = status;
		this.grupos = grupos;
		this.dataAtivacao = dataAtivacao;
	}

	public String toString() {
		String group_names =  "[";
		for (Grupo g: grupos) {
			 group_names = group_names + g.toString_names();
		}
		group_names = group_names + "  ]";
		String out =  "{ \n";
		out = out + "  " + login +" (id: "+id +")\n";
		out = out + "  email: "+ email +"\n";
		out = out + "  senha: "+ senha+"\n";
		out = out + "  status do usuario: "+ status +"\n";
		out = out + "  grupos: " + group_names + "\n";
		out = out + "  descricao do usuario: "+ descricao +"\n";
		if (dataAtivacao == null)
			out = out + "  dataAtivacao do usuario = " + "sem data" +"\n";
		else
			out = out + "  dataAtivacao do usuario = " + dataAtivacao.getTime() +"\n";
		out = out + "  }";
		return out;
	}
	
	public static int getNumUsuarios() {
		return numUsuarios;
	}

	public static void setNumUsuarios(int numUsuarios) {
		Usuario.numUsuarios = numUsuarios;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}
	
	public ArrayList<Grupo> getGruposVisiveis() {
		ArrayList<Grupo> gruposVisiveis = new ArrayList<Grupo>();
		for (Grupo g: grupos ) {
			if(g.getPermissaoVisualizar().contains(this) == true) {
				gruposVisiveis.add(g);
			}
		}
		return gruposVisiveis;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Calendar getDataAtivacao() {
		return dataAtivacao;
	}

	public void setDataAtivacao(Calendar dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}
	
	public Grupo criaGrupo(boolean visibilidade) {
		return null;
	}
	
	public void removeGrupo(Grupo groupToBeRemoved) {
		getGrupos().remove(groupToBeRemoved);;
	}
	
	public boolean criarCartao(int id) {
		for (Grupo grupo: getGrupos()){
			if (grupo.getId() == id && grupo.getPermissaoCriarCartao().contains(this)) {
				Cartao cartao = new Cartao(
						1, 
						"Cartao", 
						Label.TO_DO, 
						"assunto",
						true,
						Calendar.getInstance()
						);
				grupo.adicionaCartao(cartao);
				return true;
			}
		}
		return false;
	}
}
