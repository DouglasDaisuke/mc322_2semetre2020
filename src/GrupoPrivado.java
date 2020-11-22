import java.util.ArrayList;
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
		out = out + "permissaoAdicionar"+ getPermissaoAdicionar()+"\n";
		out = out + "permissaoRemover"+ getPermissaoRemover() +"\n";
		out = out + "permissaoAlterar"+ getPermissaoAlterar()+"\n" ;
		out = out + "permissaoVisualizar"+ getPermissaoVisualizar()+"\n" ;
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
			ArrayList<Permissao> arrayListWithPermissaoVisualiza = new ArrayList<Permissao>();
			arrayListWithPermissaoVisualiza.add(Permissao.VISUALIZAR_INFO);
			adicionaPermissao(userWhoAdds,userToBeAdd,arrayListWithPermissaoVisualiza);
			userToBeAdd.getGrupos().add(this);
			return true;
		}
		else
			return false;
	}
	
	public boolean removeMembro(Usuario userWhoRemoves, Usuario userToBeRemoved) {
		if (isStatus() == true && userWhoRemoves == getDono()) {
			getMembros().remove(userToBeRemoved);
			removePermissao(userWhoRemoves,userToBeRemoved,Permissao.valuesInArrayList());
			userToBeRemoved.getGrupos().remove(this);
			return true;
		}
		else
			return false;
	}
	public boolean adicionaPermissao(Usuario userWhoGivesPermission, Usuario userWhoRecivePermissions, ArrayList<Permissao> listOfPermission) {
		if (getPermissaoAlterar().contains(userWhoGivesPermission) == true) {
			for (Permissao p: listOfPermission) {
				if (p == Permissao.ADICIONAR_USUARIO) {
					getPermissaoAdicionar().add(userWhoRecivePermissions);
				}
				if (p == Permissao.ALTERAR_PERMISSAO) {
					getPermissaoAlterar().add(userWhoRecivePermissions);
				}
				if(p == Permissao.REMOVER_USUARIO) {
					getPermissaoRemover().add(userWhoRecivePermissions);
				}
				if(p == Permissao.VISUALIZAR_INFO) {
					getPermissaoVisualizar().add(userWhoRecivePermissions);
				}
			}
			return true;
		}else 
			return false;
	}
	
	public boolean removePermissao(Usuario userWhoRemovesPermission, Usuario userWhoLostPermissions, ArrayList<Permissao> listOfPermission) {
		if (getPermissaoAlterar().contains(userWhoRemovesPermission) == true) {
			for (Permissao p: listOfPermission) {
				if (p == Permissao.ADICIONAR_USUARIO) {
					getPermissaoAdicionar().remove(userWhoLostPermissions);
				}
				if (p == Permissao.ALTERAR_PERMISSAO) {
					getPermissaoAlterar().remove(userWhoLostPermissions);
				}
				if(p == Permissao.REMOVER_USUARIO) {
					getPermissaoRemover().remove(userWhoLostPermissions);
				}
				if(p == Permissao.VISUALIZAR_INFO) {
					getPermissaoVisualizar().remove(userWhoLostPermissions);
				}
			}
			return true;
		}else 
			return false;
	}
}
