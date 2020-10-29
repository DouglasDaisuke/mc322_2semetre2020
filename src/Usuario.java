import java.util.Calendar;

public class Usuario {
	private int id;
	private String login;
	private String email;
	private String senha;
	private String descricao;
	private boolean status;
	private Calendar dataAtivacao;

	public Usuario(String login, String email,String senha,String descricao, boolean status, Calendar dataAtivacao) {
		this.id = id+1;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.status = status;
		this.dataAtivacao = dataAtivacao;
		this.descricao = descricao;
	}

	public String toString() {
		String out =  "{ \n";
		out = out + " " + login +" (id: "+id +")\n";
		out = out + " email: "+ email +"\n";
		out = out + " senha: "+ senha+"\n";
		out = out + " status: "+ status +"\n";
		out = out + " descricao: "+ descricao +"\n";
		if (dataAtivacao == null)
			out = out + "dataAtivacao = " + "sem data" +"\n";
		else
			out = out + "dataAtivacao = " + dataAtivacao.getTime() +"\n";
		out = out + "}";
		return out;
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

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Calendar getDataAtivacao() {
		return dataAtivacao;
	}

	public void setDataAtivacao(Calendar dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}
	
	public String criaGrupo() {
		return "grupo criado";
	}
	
	public String removeGrupo() {
		return "grupo removido";
	}
}
