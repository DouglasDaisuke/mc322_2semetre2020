import java.util.Calendar;

public final class GrupoPublico extends Grupo{

	public GrupoPublico(String nome, String descricao, Usuario dono, boolean status, Calendar dataCriacao) {
		super(nome, descricao, dono, status, dataCriacao);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		String out =  "{ \n";
		out = out + " nome do grupo publico:"+ getNome()  +" (id: "+getId() +")\n";
		out = out + " descricao do grupo publico:" + getDescricao()  +"\n";
		out = out + " dono do grupo publico: "+ getDono() +"\n";
		out = out + " membros do grupo publico: "+ getMembros() +"\n";
		out = out + " status do grupo publico: "+ isStatus() +"\n";
		if (getDataCriacao() == null)
			out = out + " dataCriacao do grupo publico = " + "sem data" +"\n";
		else
			out = out + " dataCriacao do grupo publico = " + getDataCriacao().getTime() +"\n";
		out = out + " }";
		return out;
	}
	
	public boolean adicionaMembro(Usuario user) {
		if (isStatus() == true) {
			getMembros().add(user);
			user.getGrupos().add(this);
			return true;
		}
		else
			return false;
	}
	
	public boolean removeMembro(Usuario user) {
		if (isStatus() == true) {
			getMembros().remove(user);
			user.getGrupos().remove(this);
			return true;
		}
		else
			return false;
		}
}
