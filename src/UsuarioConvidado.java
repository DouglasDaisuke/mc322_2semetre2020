import java.util.ArrayList;
import java.util.Calendar;

public class UsuarioConvidado extends Usuario{
	
	private Calendar dataExpiracao;

	public UsuarioConvidado(String login, String email, String senha, String descricao, boolean status,
			ArrayList<Grupo> grupos, Calendar dataAtivacao, Calendar dataExpiracao) {
		super(login, email, senha, descricao, status, grupos, dataAtivacao);
		this.setDataExpiracao(dataExpiracao);
	}

	public Calendar getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Calendar dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
	public Grupo criaGrupo(boolean visibilidade) {
		return null;
	}

	
}
