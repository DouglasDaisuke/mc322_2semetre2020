import java.util.ArrayList;
import java.util.Calendar;

public class Cartao {

	private static int numeroCartoes;
	private int id;
	private int visibilidade;
	private String nome;
	private ArrayList<Label> Label;
	private boolean invitationOnly;
	private Calendar dataCriacao;

	public Cartao(int visibilidade, String nome, ArrayList<Label> label, boolean invitationOnly,
			Calendar dataCriacao) {
		this.id = numeroCartoes;
		setNumeroCartoes( numeroCartoes + 1);
		this.visibilidade = visibilidade;
		this.nome = nome;
		this.Label = new ArrayList<Label>();
		this.Label = label;
		this.invitationOnly = invitationOnly;
		this.dataCriacao = dataCriacao;
	}

	public Cartao() {
		this.id = numeroCartoes;
		setNumeroCartoes( numeroCartoes + 1);
		this.visibilidade = 1;
		this.nome = "Anônimo";
		this.Label = new ArrayList<Label>();
		this.invitationOnly = true;
		this.dataCriacao = Calendar.getInstance();
	}

	@Override
	public String toString() {
		String out ="numeroCartoes = " + numeroCartoes + "\n";
		out = out + "id = " + id +"\n";
		out = out + "visibilidade = " + visibilidade +"\n";
		out = out + "nome = "+ nome +"\n";
		out = out + "Label = "+ Label +"\n";
		out = out + "invitationOnly = " + invitationOnly +"\n";
		if (dataCriacao == null)
			out = out + "dataCriacao = " + "sem data" +"\n";
		else
			out = out + "dataCriacao = " + dataCriacao.getTime() +"\n";
		return out;
	}

	public static int getNumeroCartoes() {
		return numeroCartoes;
	}

	public void setNumeroCartoes(int numeroCartoes) {
		Cartao.numeroCartoes = numeroCartoes;
	}

	public int getId() {
		return id;
	}

	public int getVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(int visibilidade) {
		this.visibilidade = visibilidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isInvitationOnly() {
		return invitationOnly;
	}

	public void setInvitationOnly(boolean invitationOnly) {
		this.invitationOnly = invitationOnly;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}



}
