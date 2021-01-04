import java.util.ArrayList;
import java.util.Calendar;

public abstract class Usuario {
	private static int numUsuarios;
	private int id;
	private String login;
	private String email;
	private String senha;
	private String descricao;
	private boolean status;
	private ArrayList<Grupo> grupos;
	private Calendar dataAtivacao;
	private Perfil perfil;

	public Usuario(String login, String email,String senha,String descricao, boolean status, 
			ArrayList<Grupo> grupos, Calendar dataAtivacao, Perfil perfil) {
		this.id = numUsuarios;
		setNumUsuarios( numUsuarios + 1);
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.descricao = descricao;
		this.status = status;
		this.grupos = grupos;
		this.dataAtivacao = dataAtivacao;
		this.perfil = perfil;
	}

	public abstract String toString();
	
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
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public abstract Grupo criaGrupo(boolean visibilidade);
	
	public void removeGrupo(Grupo groupToBeRemoved) {
		getGrupos().remove(groupToBeRemoved);;
	}
	
	public boolean criarCartao(int id, String nomeCartao, int visibilidade, String assunto, int prioridade, Usuario responsavel) {
		for (Grupo grupo: getGrupos()){
			if (grupo.getId() == id && grupo.getPermissaoCriarCartao().contains(this)) {
				if (grupo.getMembros().contains(responsavel)) {
					Cartao cartao = new Cartao(
							visibilidade, 
							nomeCartao, 
							Label.TO_DO, 
							assunto,
							true,
							Calendar.getInstance(),
							prioridade,
							responsavel
							);
					grupo.adicionaCartao(cartao);
					return true;
				}
			}
		}
		return false;
	}
	
	public Cartao encontraCartaoDeMaiorPrioridade() {
		Cartao cartaoPrioritario = null;
		boolean primeiroCartao = true;
		for (Grupo grupo: getGrupos()){
			for (Cartao cartao: grupo.getCartoesAFazer()){
				if (primeiroCartao) {
					cartaoPrioritario = cartao;
					primeiroCartao = false;
				}
				else if (cartao.compareTo(cartaoPrioritario) >= 0)
					cartaoPrioritario = cartao;
			}
		}
		return cartaoPrioritario;
	}
	
	public void removeLabeldoCartao(Label labelToRemove, Cartao cartao ) {
		int index = 0;
		int LabelIndex = 0;
		for(Label label : cartao.getLabel()) {
			if (label == labelToRemove) {
				LabelIndex = index;
				break;
			}
			else index++;
		}
		cartao.getLabel().remove(LabelIndex);
	}
	
	public boolean executarTarefaDeMaiorPrioridade() {
		Cartao cartaoPrioritario = encontraCartaoDeMaiorPrioridade();
		if (cartaoPrioritario != null) {
			removeLabeldoCartao(Label.TO_DO, cartaoPrioritario);
			cartaoPrioritario.getLabel().add(Label.DONE);
			cartaoPrioritario.setPrioridade(5);
			return true;
		}else 
			return false;		
	}
}
