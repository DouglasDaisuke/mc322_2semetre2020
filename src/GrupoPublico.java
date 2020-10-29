import java.util.Calendar;

public class GrupoPublico extends Grupo{

	public GrupoPublico(int id, String nome, String descricao, Usuario dono, boolean status, Calendar dataCriacao) {
		super(id, nome, descricao, dono, status, dataCriacao);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		String out =  "{ \n";
		out = out + " nome:"+ getNome()  +" (id: "+getId() +")\n";
		out = out + " descricao:" + getDescricao()  +"\n";
		out = out + " dono: "+ getDono() +"\n";
//		for (String i:membros)
			out = out + " membros: "+ getMembros() +"\n";
		out = out + " status: "+ isStatus() +"\n";
		if (getDataCriacao() == null)
			out = out + "dataCriacao = " + "sem data" +"\n";
		else
			out = out + "dataCriacao = " + getDataCriacao().getTime() +"\n";
		return out;
	}
	
	public void adicionaMembro(Usuario user) {
		getMembros().add(user);
	}
}
