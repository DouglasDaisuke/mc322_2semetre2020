import java.util.Calendar;

public class Usuario {
	private int id;
	private String login;
	private String email;
	private String senha;
	private boolean status;
	private Calendar dataAtivacao;
	
	public Usuario(int id, String login, String email,String senha, boolean status, Calendar dataAtivacao) {
		this.id = id;
		this.login=login;
		this.email=email;
		this.senha=senha;
		this.status=status;
		this.dataAtivacao=dataAtivacao;
	}
	
	public String toString() {
		String out = getLogin()+" (id: "+getId()+")\n";
		out = out +"email: "+getEmail()+"\n";
		out = out +"senha: "+getSenha()+"\n";
		out = out +"status: "+getStatus()+"\n";
		out = out +"dataAtivacao: "+getDataAtivacao().getTime()+"\n";
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
}
