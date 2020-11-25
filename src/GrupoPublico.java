import java.util.ArrayList;
import java.util.Calendar;

public final class GrupoPublico extends Grupo{

	public GrupoPublico(String nome, String descricao, Usuario dono, boolean status, Calendar dataCriacao) {
		super(nome, descricao, dono, status, dataCriacao);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(Usuario user) {
		if (this.getPermissaoVisualizar().contains(user) == true) {
			String out =  "{ \n";
			out = out + " nome do grupo publico:"+ getNome()  +" (id: "+getId() +")\n";
			out = out + " descricao do grupo publico:" + getDescricao()  +"\n";
			out = out + " dono do grupo publico: "+ getDono() +"\n";
			out = out + " membros do grupo publico: "+ getMembros() +"\n";
			out = out + "permissaoAdicionar"+ getPermissaoAdicionar()+"\n";
			out = out + "permissaoRemover"+ getPermissaoRemover() +"\n";
			out = out + "permissaoAlterar"+ getPermissaoAlterar()+"\n" ;
			out = out + "permissaoVisualizar"+ getPermissaoVisualizar()+"\n" ;
			out = out + " status do grupo publico: "+ isStatus() +"\n";
			if (getDataCriacao() == null)
				out = out + " dataCriacao do grupo publico = " + "sem data" +"\n";
			else
				out = out + " dataCriacao do grupo publico = " + getDataCriacao().getTime() +"\n";
			out = out + " }";
			return out;
		}else return "Não tem permissão para visualizar";
	}
	
	public boolean adicionaMembro(Usuario userWhoAdds,Usuario userToBeAdd) {
		if (isStatus() == true && getPermissaoAdicionar().contains(userWhoAdds) == true) {
			getMembros().add(userToBeAdd);
			adicionaPermissao(userWhoAdds,userToBeAdd,Permissao.valuesInArrayList());
			userToBeAdd.getGrupos().add(this);
			return true;
		}
		else
			return false;
	}
	
	public boolean removeMembro(Usuario userWhoRemoves, Usuario userToBeRemoved) {
		if (isStatus() == true && getPermissaoRemover().contains(userWhoRemoves) == true && userToBeRemoved != this.getDono()) {
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
		if (getPermissaoAlterar().contains(userWhoRemovesPermission) == true && userWhoLostPermissions != this.getDono()) {
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
