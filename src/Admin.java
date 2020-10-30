import java.util.Calendar;

public class Admin extends Usuario{
	public Admin(String login, String email, String senha, String descricao, boolean status, Calendar dataAtivacao) {
		super(login, email, senha, descricao, status, dataAtivacao);
		// TODO Auto-generated constructor stub
	}

	public void desabilitaGrupo() {
		System.out.println("desabilita o grupo");
	}

}
