import java.util.ArrayList;
import java.util.Calendar;

public class Grupo {
	private int id;
	private String nome;
	private String descricao;
	private final Usuario dono;
	private ArrayList<Usuario> membros;
	private boolean status;
	private Calendar dataCriacao; 
	
	public Grupo(int id, String nome, String descricao, Usuario dono, boolean status,
			Calendar dataCriacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		this.membros = new ArrayList<Usuario>(); 
		this.status = status;
		this.dataCriacao = dataCriacao;
	}
	
	public String toString() {
		String out =  "{ \n";
		out = out + " nome:"+ nome  +" (id: "+ id +")\n";
		out = out + " descricao:" + descricao  +"\n";
		out = out + " dono: "+ dono +"\n";
		out = out + " membros: "+ membros +"\n";
		out = out + " status: "+ status +"\n";
		if (dataCriacao == null)
			out = out + "dataCriacao = " + "sem data" +"\n";
		else
			out = out + "dataCriacao = " + dataCriacao.getTime() +"\n";
		return out;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
