import java.util.ArrayList;
import java.util.Calendar;

public class UsuarioComum extends Usuario{

	public UsuarioComum(String login, String email, String senha, String descricao, boolean status,
			ArrayList<Grupo> grupos, Calendar dataAtivacao, Perfil perfil) {
		super(login, email, senha, descricao, status, grupos, dataAtivacao, perfil);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		String group_names =  "[";
		for (Grupo g: getGrupos()) {
			 group_names = group_names + g.toString_names();
		}
		group_names = group_names + "  ]";
		String out =  "{ \n";
		out = out + "  " + getLogin() +" (id: "+ getId() +")\n";
		out = out + "  email: "+ getEmail() +"\n";
		out = out + "  senha: "+ getSenha() +"\n";
		out = out + "  status do usuario: "+ getStatus() +"\n";
		out = out + "  grupos: " + group_names + "\n";
		out = out + "  descricao do usuario: "+ getDescricao() +"\n";
		if (getDataAtivacao() == null)
			out = out + "  dataAtivacao do usuario = " + "sem data" +"\n";
		else
			out = out + "  dataAtivacao do usuario = " + getDataAtivacao().getTime() +"\n";
		out = out + "  Perfil: "+ getPerfil() +"\n";
		out = out + "  }";
		return out;
	}

	@Override
	public Grupo criaGrupo(boolean visibilidade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
