import java.util.Calendar;

public class Cartao {

	private static int numeroCartoes;
	private int id;
	private int visibilidade;
	private String nome;
	private Usuario dono;
	private boolean invitationOnly;
	private Calendar dataCriacao;

	public Cartao(int visibilidade, String nome, Usuario dono, boolean invitationOnly,
			Calendar dataCriacao) {
		this.id = numeroCartoes;
		setNumeroCartoes( numeroCartoes + 1);
		this.visibilidade = visibilidade;
		this.nome = nome;
		this.dono = dono;
		this.invitationOnly = invitationOnly;
		this.dataCriacao = dataCriacao;
	}

	public Cartao() {
		this.id = numeroCartoes;
		setNumeroCartoes( numeroCartoes + 1);
		this.visibilidade = 1;
		this.nome = "Anônimo";
		this.dono = userDefault;
		this.invitationOnly = true;
		this.dataCriacao = Calendar.getInstance();
	}

	@Override
	public String toString() {
		String out ="numeroCartoes = " + numeroCartoes + "\n";
		out = out + "id = " + id +"\n";
		out = out + "visibilidade = " + visibilidade +"\n";
		out = out + "nome = "+ nome +"\n";
		out = out + "dono = "+  dono +"\n";
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

	private void setId(int id) {
		this.id = id;
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

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
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

	Usuario userDefault = new Usuario (
			"Nome padrão", 
			"email.generico@gmail.com.br", 
			"batata123", 
			false ,
			Calendar.getInstance()
			);

}
