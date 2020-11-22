/*	Questões:

	1) Há alguma diferença entre utilizar atributos final e Enumerações ? Explique.
	
	2) Na main tente instanciar uma nova Permissao (enum) com a palavra-chave new, o que acontece? Qual seria o motivo desse
resultado?

	3) Sobre os relacionamentos entre as classes: Em teoria, qual o tipo de relacionamento entre as Grupo(Privado e Público)
e Usuario? E entre Usuario e Sala? (Lembre-se que relacionamentos são classificados em: Associação, Agregação e
Composição.)

	4) Qual a multiplicidade dos relacionamentos citados na questão anterior?

*/

import java.util.ArrayList;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {

		Usuario userSad = new Usuario (
				"Tristeza", 
				"tristeza@gmail.com.br", 
				"triste0123", 
				"descricao triste",
				false ,
				new ArrayList<Grupo>(),
				Calendar.getInstance()
				);
		Usuario userHappy = new Usuario (
				"Felicidade", 
				"felicidade@gmail.com.br", 
				"feliz0123", 
				"descricao feliz",
				false ,
				new ArrayList<Grupo>(),
				Calendar.getInstance()
				);
		Usuario userBoring = new Usuario (
				"Chato", 
				"chato@gmail.com.br", 
				"chato0123", 
				"descricao chata",
				false ,
				new ArrayList<Grupo>(),
				Calendar.getInstance()
				);
		Usuario userLively = new Usuario (
				"Animado", 
				"animacao@gmail.com.br", 
				"animacao0123", 
				"descricao animada",
				false ,
				new ArrayList<Grupo>(),
				Calendar.getInstance()
				);
		Admin adminSenior = new Admin(
				"Administrator", 
				"Administrator@gmail.com.br", 
				"admin0123", 
				"descricao de admin",
				true ,
				new ArrayList<Grupo>(),
				Calendar.getInstance()
				);
		Admin adminJunior = new Admin(
				"Administrator JR", 
				"AdministratorJR@gmail.com.br", 
				"adminJR0123", 
				"descricao de adminJR",
				true ,
				new ArrayList<Grupo>(),
				Calendar.getInstance()
				);
		GrupoPublico group = new GrupoPublico(
				"new public group",
				"description",
				userSad,
				true,
				Calendar.getInstance()
				);
		GrupoPrivado VIPgroup = new GrupoPrivado(
				"new VIP group",
				"description VIP",
				userHappy,
				true,
				Calendar.getInstance()
				);
		
		System.out.println("___________ group (grupo publico) ...____________ ");	
		if (group.adicionaMembro(userSad, userBoring) == true) {
			System.out.println("membro userBoring adicionado!");	
		}else System.out.println("não foi possível adicionar!");
		if (group.adicionaMembro(userSad, userHappy) == true) {
			System.out.println("membro userHappy adicionado!");	
		}else System.out.println("não foi possível adicionar!");
		if (group.adicionaMembro(userSad, userLively) == true) {
			System.out.println("membro userLively adicionado!");	
		}else System.out.println("não foi possível adicionar!");
		System.out.println();
		
		System.out.println("___________ impressão das permissoes dos usuarios do grupo publico ...____________ ");	
		System.out.println("____Usuarios que podem adicionar membros:");
		System.out.println(group.getPermissaoAdicionar());
		System.out.println("____Usuarios que podem alterar permissao dos membros:");
		System.out.println(group.getPermissaoAlterar());
		System.out.println("____Usuarios que podem remover permissoes:");
		System.out.println(group.getPermissaoRemover());
		System.out.println("____Usuarios que podem visualizar o grupo:");
		System.out.println(group.getPermissaoVisualizar());
		System.out.println();

		System.out.println("___________ testes no group (grupo publico) ...____________ ");	
		System.out.println();		
		System.out.println();
		
		System.out.println("___________ userHappy adicionando adminJunior no grupo...____________ ");	
		if (group.adicionaMembro(userHappy, adminJunior) == true) {
			System.out.println("membro adicionado!");	
		}else System.out.println("não foi possível adicionar!");
		System.out.println(group);
		System.out.println();

		System.out.println("___________userHappy removendo userBoring do grupo...____________ ");	
		if (group.removeMembro(userHappy, userBoring) == true) {
			System.out.println("membro removido!");	
		}else System.out.println("não foi possível remover!");
		System.out.println(group);
		System.out.println();
		
		System.out.println("___________ userHappy removendo permissao de alterar do userSad...____________ ");
		ArrayList<Permissao> arrayListWithAlteraPermissao = new ArrayList<Permissao>();
		arrayListWithAlteraPermissao.add(Permissao.ALTERAR_PERMISSAO);
		if (group.removePermissao(userHappy, userSad, arrayListWithAlteraPermissao) == true) {
			System.out.println("permissao removida!");	
		}else System.out.println("não foi possível remover permissao!");
		System.out.println(group);
		System.out.println();
		
		System.out.println("___________ userHappy adicionando permissao de alterar do userSad ...____________ ");
		if (group.adicionaPermissao(userHappy, userSad, arrayListWithAlteraPermissao) == true) {
			System.out.println("permissao adicionada!");	
		}else System.out.println("não foi possível adicionar permissao!");
		System.out.println();

		System.out.println("___________ visualizando dados dos grupos que são visiveis para userHappy ...____________ ");	
		System.out.println(userHappy.getGruposVisiveis());

		
		System.out.println();
		System.out.println();

		
		System.out.println("___________ VIPgroup (grupo privado) ...____________ ");	
		if (VIPgroup.adicionaMembro(userHappy, userSad) == true) {
			System.out.println("membro adicionado!");	
		}else System.out.println("não foi possível adicionar!");
		if (VIPgroup.adicionaMembro(userHappy, userBoring) == true) {
			System.out.println("membro adicionado!");	
		}else System.out.println("não foi possível adicionar!");
		if (VIPgroup.adicionaMembro(userHappy, userLively) == true) {
			System.out.println("membro adicionado!");	
		}else System.out.println("não foi possível adicionar!");
		System.out.println();
		
		System.out.println("___________ impressão das listas de usuario de cada permissao do grupo privado  ...____________ ");	
		System.out.println("____Usuarios que podem adicionar membros:");
		System.out.println(VIPgroup.getPermissaoAdicionar());
		System.out.println("____Usuarios que podem alterar permissao dos membros:");
		System.out.println(VIPgroup.getPermissaoAlterar());
		System.out.println("____Usuarios que podem remover membros:");
		System.out.println(VIPgroup.getPermissaoRemover());
		System.out.println("____Usuarios que podem visualizar o grupo:");
		System.out.println(VIPgroup.getPermissaoVisualizar());
		System.out.println();
		
		System.out.println("___________ testes no VIPgroup (grupo privado) ...____________ ");		
		System.out.println();		
		System.out.println();
		
		System.out.println("___________ testando a permissao de visualização do userBoring ...____________ ");	
		System.out.println(userBoring.getGruposVisiveis());
		System.out.println();

		System.out.println("___________ removendo a permissao de visualização do userBoring ...____________ ");	
		ArrayList<Permissao> arrayListWithPermissaoVisualiza = new ArrayList<Permissao>();
		arrayListWithPermissaoVisualiza.add(Permissao.VISUALIZAR_INFO);
		if(VIPgroup.removePermissao(userHappy, userBoring, arrayListWithPermissaoVisualiza) == true){
			System.out.println("permissao removida!");
		}else System.out.println("não foi possível remover permissao!");
		System.out.println();

		System.out.println("___________ testando a permissao de visualização do userBoring ...____________ ");	
		System.out.println(userBoring.getGruposVisiveis());
		System.out.println();
	
		System.out.println("___________ adicionando a permissao de alteração do userBoring ...____________ ");	
		ArrayList<Permissao> arrayListWithPermissaoAlterar = new ArrayList<Permissao>();
		arrayListWithPermissaoAlterar.add(Permissao.ALTERAR_PERMISSAO);
		if(VIPgroup.adicionaPermissao(userHappy, userBoring, arrayListWithPermissaoAlterar) == true){
			System.out.println("permissao adicionada!");
		}else System.out.println("não foi possível adicionar permissao!");
		System.out.println();

		System.out.println("___________ testando a permissao de alteração do userBoring ...____________ ");	
		if(VIPgroup.removePermissao(userBoring, userHappy, arrayListWithPermissaoAlterar) == true){
			System.out.println("permissao removida!");
		}else System.out.println("não foi possível remover permissao!"); 
		System.out.println();
		
		System.out.println("___________ impressão das listas de usuario de cada permissao do grupo privado  ...____________ ");	
		System.out.println("____Usuarios que podem adicionar membros:");
		System.out.println(VIPgroup.getPermissaoAdicionar());
		System.out.println("____Usuarios que podem alterar permissao dos membros:");
		System.out.println(VIPgroup.getPermissaoAlterar());
		System.out.println("____Usuarios que podem remover membros:");
		System.out.println(VIPgroup.getPermissaoRemover());
		System.out.println("____Usuarios que podem visualizar o grupo:");
		System.out.println(VIPgroup.getPermissaoVisualizar());
		System.out.println();
	}
}
