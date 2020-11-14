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
	
	public void criaGrupo(String nameOfGroup, String descriptionOfGroup, boolean publicGroup) {
		if (publicGroup == true) {
			GrupoPublico grupoPublico = new GrupoPublico(
						nameOfGroup,
						descriptionOfGroup,
						this,
						true,
						Calendar.getInstance()
						);
			getGrupos().add(grupoPublico);
		}if (publicGroup == false) {
			GrupoPrivado grupoPrivado = new GrupoPrivado(
					nameOfGroup,
					descriptionOfGroup,
					this,
					true,
					Calendar.getInstance()
					);
			getGrupos().add(grupoPrivado);
		}
		
	}
	
	public void removeGrupo(Grupo groupToBeRemoved) {
		getGrupos().remove(groupToBeRemoved);;
	}
}
