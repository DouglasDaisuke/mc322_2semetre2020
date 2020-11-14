import java.util.Calendar;

public class GrupoPrivado extends Grupo{

	public GrupoPrivado(String nome, String descricao, Usuario dono, boolean status, Calendar dataCriacao) {
		super(nome, descricao, dono, status, dataCriacao);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		String out =  "{ \n";
		out = out + " nome do grupo privado:"+ getNome()  +" (id: "+getId() +")\n";
		out = out + " descricao do grupo privado:" + getDescricao()  +"\n";
		out = out + " dono do grupo privado: "+ getDono() +"\n";
		out = out + " membros do grupo privado: "+ getMembros() +"\n";
		out = out + " status do grupo privado: "+ isStatus() +"\n";
		if (getDataCriacao() == null)
			out = out + " dataCriacao do grupo privado = " + "sem data" +"\n";
		else
			out = out + " dataCriacao do grupo privado = " + getDataCriacao().getTime() +"\n";
		out = out + " }";
		return out;
	}
	
	public boolean adicionaMembro(Usuario userWhoAdds,Usuario userToBeAdd) {
		if (isStatus() == true && userWhoAdds == getDono()) {
			getMembros().add(userToBeAdd);
			userToBeAdd.getGrupos().add(this);
			return true;
		}
		else
			return false;
	}
	
	public boolean removeMembro(Usuario userWhoRemoves, Usuario userToBeRemoved) {
		if (isStatus() == true && userWhoRemoves == getDono()) {
			getMembros().remove(userToBeRemoved);
			userToBeRemoved.getGrupos().remove(this);
			return true;
		}
		else
			return false;
	}
}
