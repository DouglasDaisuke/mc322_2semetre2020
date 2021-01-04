import java.util.ArrayList;
import java.util.Calendar;

public class Cartao implements Comparable<Cartao>{

	private static int numeroCartoes;
	private int id;
	private int visibilidade;
	private String nome;
	private ArrayList<Label> label;
	private String assunto;
	private boolean invitationOnly;
	private Calendar dataCriacao;
	private int prioridade;
	private Usuario responsavel;

	public Cartao(int visibilidade, String nome, Label label,String assunto, boolean invitationOnly,
			Calendar dataCriacao, int prioridade, Usuario responsavel) {
		this.id = numeroCartoes;
		setNumeroCartoes( numeroCartoes + 1);
		this.visibilidade = visibilidade;
		this.nome = nome;
		this.label = new ArrayList<Label>();
		this.label.add(label);
		this.assunto = assunto;
		this.invitationOnly = invitationOnly;
		this.dataCriacao = dataCriacao;
		this.prioridade = prioridade;
		this.responsavel = responsavel;
	}

	public Cartao() {
		this.id = numeroCartoes;
		setNumeroCartoes( numeroCartoes + 1);
		this.visibilidade = 1;
		this.nome = "Anônimo";
		this.label.add(Label.TO_DO);
		this.assunto = "assunto";
		this.invitationOnly = true;
		this.dataCriacao = Calendar.getInstance();
	}

	@Override
	public String toString() {
		String out ="numeroCartoes = " + numeroCartoes + "\n";
		out = out + "id = " + id +"\n";
		out = out + "prioridade: " + prioridade +"\n";
		out = out + "visibilidade = " + visibilidade +"\n";
		out = out + "nome = "+ nome +"\n";
		out = out + "Label = "+ label +"\n";
		out = out + "invitationOnly = " + invitationOnly +"\n";
		if (dataCriacao == null)
			out = out + "dataCriacao = " + "sem data" +"\n";
		else
			out = out + "dataCriacao = " + dataCriacao.getTime() +"\n";
		out = out + "responsavel: " + responsavel +"\n";
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
	
	public ArrayList<Label> getLabel() {
		return label;
	}

	public void setLabel(ArrayList<Label> label) {
		this.label = label;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
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

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}
	
	@Override
	public int compareTo(Cartao cartao2) {
		if (this.getPrioridade() < cartao2.getPrioridade())
			return 1;
		else if (this.getPrioridade() > cartao2.getPrioridade())
			return -1;
		else return 0;
	}

	
}
