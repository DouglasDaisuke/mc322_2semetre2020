import java.util.Calendar;

public class Sala {

	private static int numeroSalas;
	private int id;
	private int capacidadeMaxima;
	private int numeroUsuarios;
	private String descricao;
	private Usuario dono;
	private boolean ingressoAutomatico;
	private Calendar dataCriacao;

	public Sala(int capacidadeMaxima, String descricao, Usuario dono,
			boolean ingressoAutomatico, Calendar dataCriacao) {
		this.id = numeroSalas;
		setNumeroSalas( numeroSalas + 1);
		this.capacidadeMaxima = capacidadeMaxima;
		this.descricao = descricao;
		this.dono = dono;
		this.ingressoAutomatico = ingressoAutomatico;
		this.dataCriacao = dataCriacao;
	}

	public Sala() {
		this.id = numeroSalas;
		setNumeroSalas( numeroSalas + 1);
		this.capacidadeMaxima = 50;
		this.numeroUsuarios = 1;
		this.descricao = "uma sala generica";
		this.dono = userDefault;
		this.ingressoAutomatico = false;
		this.dataCriacao = Calendar.getInstance();
	}

	@Override
	public String toString() {
		String out ="numeroSalas = " + numeroSalas +  "\n";
		out = out + "id = " + id + "\n";
		out = out + "capacidadeMaxima = " + capacidadeMaxima +"\n";
		out = out + "numeroUsuarios = " + numeroUsuarios +"\n";
		out = out + "descricao = " + descricao +"\n";
		out = out + "dono = " + dono+ "\n";
		out = out + "ingressoAutomatico = " + ingressoAutomatico + "\n";
		if (dataCriacao == null)
			out = out + "dataCriacao = " + "sem data" +"\n";
		else
			out = out + "dataCriacao = " + dataCriacao.getTime() +"\n";
		return out;
	}

	public static int getNumeroSalas() {
		return numeroSalas;
	}

	public void setNumeroSalas(int numeroSalas) {
		Sala.numeroSalas = numeroSalas;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id ;
	}

	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public int getnumeroUsuarios() {
		return numeroUsuarios;
	}

	public void setnumeroUsuarios(int numeroUsuarios) {
		this.numeroUsuarios = numeroUsuarios;
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

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public boolean isIngressoAutomatico() {
		return ingressoAutomatico;
	}

	public void setIngressoAutomatico(boolean ingressoAutomatico) {
		this.ingressoAutomatico = ingressoAutomatico;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public boolean salaVazia() {
		if (getnumeroUsuarios() <= 0) 
			return true;
		else
			return false;
	}

	public boolean salaCheia() {
		if (getnumeroUsuarios() >= getCapacidadeMaxima()) {
			return true;
		}
		else
			return false;
	}

	public void SubtraiUmUsuario(){
		int novo_numUsuario = getnumeroUsuarios()-1;
		setnumeroUsuarios(novo_numUsuario);
	}

	public void SomaUmUsuario(){
		int novo_numUsuario = getnumeroUsuarios()+1;
		setnumeroUsuarios(novo_numUsuario);
	}

	public boolean adicionaUsuario() {
		if (salaCheia()) {
			System.out.println("Infelizmente não deu para adicionar, pois a sala está CHEIA");
			return false;
		}
		else {
			SomaUmUsuario();
			return true;
		}	
	}

	public boolean removeUsuario() {
		if (salaVazia()) {
			System.out.println("Ué, a sala já esta VAZIA");
			return false;	
		}
		else {
			SubtraiUmUsuario();
			return true;
		}	
	} 

	Usuario userDefault = new Usuario (
			"Nome padrão", 
			"email.generico@gmail.com.br", 
			"batata123", 
			false ,
			Calendar.getInstance()
			);
}
