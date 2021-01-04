import java.util.ArrayList;
import java.util.Calendar;

public abstract class Grupo {
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
	private ArrayList<Cartao> cartoesAFazer;
	private ArrayList<Cartao> cartoesFeitos;


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
		this.cartoesAFazer = new ArrayList<Cartao>();
		this.cartoesFeitos = new ArrayList<Cartao>();
		this.membros = new ArrayList<Usuario>(); 
		this.status = status;
		this.dataCriacao = dataCriacao;
		getMembros().add(dono);
		dono.getGrupos().add(this);
	}
	
	public abstract String toString(Usuario user); 
	
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

	public ArrayList<Cartao> getCartoesAFazer() {
		return cartoesAFazer;
	}

	public void setCartoesAFazer(ArrayList<Cartao> cartoesAFazer) {
		this.cartoesAFazer = cartoesAFazer;
	}

	public ArrayList<Cartao> getCartoesFeitos() {
		return cartoesFeitos;
	}

	public void setCartoesFeitos(ArrayList<Cartao> cartoesFeitos) {
		this.cartoesFeitos = cartoesFeitos;
	}
	
	public abstract boolean adicionaMembro(Usuario userWhoAdds,Usuario userToBeAdd);
	
	public abstract boolean removeMembro(Usuario userWhoRemoves, Usuario userToBeRemoved);
	
	public abstract boolean adicionaPermissao(Usuario userWhoGivesPermission, Usuario userWhoRecivePermissions, ArrayList<Permissao> listOfPermission);
	
	public abstract boolean removePermissao(Usuario userWhoRemovesPermission, Usuario userWhoLostPermissions, ArrayList<Permissao> listOfPermission);
	
	public boolean adicionaCartao(Cartao cartao) {
		if (isStatus() == true) {
			getCartoesAFazer().add(cartao);
			return true;
		}else return false;
	}

}
