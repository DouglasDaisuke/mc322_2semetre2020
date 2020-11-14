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
	
	public Grupo(String nome, String descricao, Usuario dono, boolean status,
			Calendar dataCriacao) {
		super();
		this.id = numGrupos;
		setNumGrupos(numGrupos+1);
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
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

}
