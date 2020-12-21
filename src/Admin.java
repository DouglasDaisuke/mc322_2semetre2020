import java.util.ArrayList;
import java.util.Calendar;

public class Admin extends Usuario{
	public Admin(String login, String email, String senha, String descricao, 
			boolean status, ArrayList<Grupo> grupos, Calendar dataAtivacao) {
		super(login, email, senha, descricao, status, grupos, dataAtivacao);
		// TODO Auto-generated constructor stub
	}

	public boolean desabilitaGrupo(Grupo groupToBeDisable) {
		if (groupToBeDisable.setStatus(false, this) == true)
			return true;
		else
			return false;
	}
	
	public Grupo criaGrupo(boolean visibilidade) {
		if (visibilidade == true) {
			GrupoPublico grupoPublico = new GrupoPublico(
						"groupPublicName",
						"descriptionOfGroup",
						this,
						true,
						Calendar.getInstance()
						);
			return grupoPublico;
		}else {
			GrupoPrivado grupoPrivado = new GrupoPrivado(
					"groupPrivateName",
					"descriptionOfGroup",
					this,
					true,
					Calendar.getInstance()
					);
			return grupoPrivado;
		}
	}


}
