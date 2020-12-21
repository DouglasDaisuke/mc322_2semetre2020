import java.util.ArrayList;
import java.util.Calendar;

public class Grupo {
	private static int numGrupos;
	private int id;
	private String nome;
	private String descricao;
	private final Usuario dono;
	private ArrayList<Usuario> membros;
	private boolean status;
	private Calendar dataCriacao; 
	private ArrayList<Usuario> permissaoAdicionar;
	private ArrayList<Usuario> permissaoRemover;
	private ArrayList<Usuario> permissaoAlterar;
	private ArrayList<Usuario> permissaoVisualizar;
	private ArrayList<Usuario> permissaoCriarCartao;
	private ArrayList<Cartao> cartoes;

	public Grupo(String nome, String descricao, Usuario dono, boolean status,
			Calendar dataCriacao) {
		super();
		this.id = numGrupos;
		setNumGrupos(numGrupos+1);
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		this.permissaoAdicionar = new ArrayList<Usuario>();
		this.permissaoAdicionar.add(dono);
		this.permissaoRemover = new ArrayList<Usuario>();
		this.permissaoRemover.add(dono);
		this.permissaoAlterar = new ArrayList<Usuario>();
		this.permissaoAlterar.add(dono);
		this.permissaoVisualizar = new ArrayList<Usuario>();
		this.permissaoVisualizar.add(dono);
		this.permissaoCriarCartao = new ArrayList<Usuario>();
		this.permissaoCriarCartao.add(dono);
		this.cartoes = new ArrayList<Cartao>();
		this.membros = new ArrayList<Usuario>(); 
		this.status = status;
		this.dataCriacao = dataCriacao;
		getMembros().add(dono);
		dono.getGrupos().add(this);
	}
	
	public String toString() {
		String out =  "{ \n";
		out = out + " nome do grupo:"+ nome  +" (id: "+ id +")\n";
		out = out + " descricao do grupo:" + descricao  +"\n";
		out = out + " dono do grupo: "+ dono +"\n";
		out = out + " membros : "+ membros +"\n";
		out = out + "permissaoAdicionar"+ permissaoAdicionar+"\n";
		out = out + "permissaoRemover"+ permissaoRemover +"\n";
		out = out + "permissaoAlterar"+ permissaoAlterar+"\n" ;
		out = out + "permissaoVisualizar"+ permissaoVisualizar+"\n" ;
		out = out + "permissaoCriarCartao"+ permissaoCriarCartao+"\n" ;
		out = out + "cartoes"+ cartoes +"\n" ;
		out = out + " status do grupo: "+ status +"\n";
		if (dataCriacao == null)
			out = out + " dataCriacao do grupo = " + "sem data" +" \n";
		else
			out = out + " dataCriacao do grupo= " + dataCriacao.getTime() +" \n";
		out = out + " }";
		return out;
	}
	
	public String toString_names() {
		String out =  "\n";
		out = out + "   "+ nome  +" (id: "+ id +")";
		out = out +"\n";
		return out;
	}
	
	public static int getNumGrupos() {
		return numGrupos;
	}

	public static void setNumGrupos(int numGrupos) {
		Grupo.numGrupos = numGrupos;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Usuario getDono() {
		return dono;
	}
	
	public ArrayList<Usuario> getMembros() {
		return membros;
	}
	
	public void setMembros(ArrayList<Usuario> membros) {
		this.membros = membros;
	}

	public boolean isStatus() {
		return status;
	}

	public boolean setStatus(boolean status, Usuario admin) {
		if (admin instanceof Admin) {
			this.status = status;
			return true;
		}else 
			return false;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public ArrayList<Usuario> getPermissaoAdicionar() {
		return permissaoAdicionar;
	}

	public void setPermissaoAdicionar(ArrayList<Usuario> permissaoAdicionar) {
		this.permissaoAdicionar = permissaoAdicionar;
	}

	public ArrayList<Usuario> getPermissaoRemover() {
		return permissaoRemover;
	}

	public void setPermissaoRemover(ArrayList<Usuario> permissaoRemover) {
		this.permissaoRemover = permissaoRemover;
	}

	public ArrayList<Usuario> getPermissaoAlterar() {
		return permissaoAlterar;
	}

	public void setPermissaoAlterar(ArrayList<Usuario> permissaoAlterar) {
		this.permissaoAlterar = permissaoAlterar;
	}

	public ArrayList<Usuario> getPermissaoVisualizar() {
		return permissaoVisualizar;
	}

	public void setPermissaoVisualizar(ArrayList<Usuario> permissaoVisualizar) {
		this.permissaoVisualizar = permissaoVisualizar;
	}
	
	public ArrayList<Usuario> getPermissaoCriarCartao() {
		return permissaoCriarCartao;
	}

	public void setPermissaoCriarCartao(ArrayList<Usuario> permissaoCartao) {
		this.permissaoCriarCartao = permissaoCartao;
	}

	public ArrayList<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(ArrayList<Cartao> cartoes) {
		this.cartoes = cartoes;
	}
	
	public boolean adicionaMembro(Usuario userWhoAdds,Usuario userToBeAdd) {
		if (isStatus() == true && getPermissaoAdicionar().contains(userWhoAdds) == true) {
			getMembros().add(userToBeAdd);
			adicionaPermissao(userWhoAdds,userToBeAdd,Permissao.valuesInArrayList());
			userToBeAdd.getGrupos().add(this);
			return true;
		}
		else
			return false;
	}
	
	public boolean removeMembro(Usuario userWhoRemoves, Usuario userToBeRemoved) {
		if (isStatus() == true && getPermissaoRemover().contains(userWhoRemoves) == true && userToBeRemoved != this.getDono()) {
			getMembros().remove(userToBeRemoved);
			removePermissao(userWhoRemoves,userToBeRemoved,Permissao.valuesInArrayList());
			userToBeRemoved.getGrupos().remove(this);
			return true;
		}
		else
			return false;
		}
	
	public boolean adicionaPermissao(Usuario userWhoGivesPermission, Usuario userWhoRecivePermissions, ArrayList<Permissao> listOfPermission) {
		if (isStatus() == true && getPermissaoAlterar().contains(userWhoGivesPermission) == true) {
			for (Permissao p: listOfPermission) {
				if (p == Permissao.ADICIONAR_USUARIO) {
					getPermissaoAdicionar().add(userWhoRecivePermissions);
				}
				if (p == Permissao.ALTERAR_PERMISSAO) {
					getPermissaoAlterar().add(userWhoRecivePermissions);
				}
				if(p == Permissao.REMOVER_USUARIO) {
					getPermissaoRemover().add(userWhoRecivePermissions);
				}
				if(p == Permissao.VISUALIZAR_INFO) {
					getPermissaoVisualizar().add(userWhoRecivePermissions);
				}
				if(p == Permissao.CRIAR_CARTAO) {
					getPermissaoCriarCartao().add(userWhoRecivePermissions);
				}
			}
			return true;
		}else 
			return false;
	}
	
	public boolean removePermissao(Usuario userWhoRemovesPermission, Usuario userWhoLostPermissions, ArrayList<Permissao> listOfPermission) {
		if (isStatus() == true && getPermissaoAlterar().contains(userWhoRemovesPermission) == true && userWhoLostPermissions != this.getDono()) {
			for (Permissao p: listOfPermission) {
				if (p == Permissao.ADICIONAR_USUARIO) {
					getPermissaoAdicionar().remove(userWhoLostPermissions);
				}
				if (p == Permissao.ALTERAR_PERMISSAO) {
					getPermissaoAlterar().remove(userWhoLostPermissions);
				}
				if(p == Permissao.REMOVER_USUARIO) {
					getPermissaoRemover().remove(userWhoLostPermissions);
				}
				if(p == Permissao.VISUALIZAR_INFO) {
					getPermissaoVisualizar().remove(userWhoLostPermissions);
				}
				if(p == Permissao.CRIAR_CARTAO) {
					getPermissaoCriarCartao().remove(userWhoLostPermissions);
				}
			}
			return true;
		}else 
			return false;
	}
	
	public boolean adicionaCartao(Cartao cartao) {
		if (isStatus() == true) {
			getCartoes().add(cartao);
			return true;
		}else return false;
	}

}
