/*	Questões:

	1) Tente modificar o valor da dono de um grupo (que é um atributo final). Crie um setter se necessário. Foi possível fazer a
modificação? Explique.

	2) Agora, no método main, crie uma variável final do tipo Grupo, e instancie ela com os valores que preferir. Tente modificar
algum atributo do objeto através de um setter, como o atributo referente ao id. Foi possível modificar esse atributo, mesmo
com o objeto sendo final? Por quê?

	3) Se ao invés de usar ArrayList para definir a lista de membros da classe Grupo tivéssemos usado um array, o que mudaria
na implementação? Poderíamos continuar adicionado membros como fizemos? Haveria alguma limitação? Discuta as
desvantagens dessa solução.

	4) Qual o principal benefício da herança?

	5) Adicione final na classe Grupo. O que aconteceu com o código? Por que isso aconteceu? Em vez de Grupo ser final e se
definirmos GrupoPublico como final?

	6) Por que definimos os métodos adicionaMembro e removeMembro nas classes filhas e não na classe mãe (Grupo)?
 */

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {

		Usuario userSad = new Usuario (
				"Tristeza", 
				"tristeza@gmail.com.br", 
				"triste0123", 
				"descricao triste",
				false ,
				Calendar.getInstance()
				);
		Usuario userHappy = new Usuario (
				"Felicidade", 
				"felicidade@gmail.com.br", 
				"feliz0123", 
				"descricao feliz",
				false ,
				Calendar.getInstance()
				);
		Usuario userBoring = new Usuario (
				"Chato", 
				"hato@gmail.com.br", 
				"chato0123", 
				"descricao chata",
				false ,
				Calendar.getInstance()
				);
		Usuario userLively = new Usuario (
				"Animacao", 
				"animacao@gmail.com.br", 
				"animacao0123", 
				"descricao animada",
				false ,
				Calendar.getInstance()
				);
		Admin admin = new Admin(
				"Administrator", 
				"Administrator@gmail.com.br", 
				"admin0123", 
				"descricao de admin",
				true ,
				Calendar.getInstance()
				);
		GrupoPublico group = new GrupoPublico(
				1,
				"new public group",
				"description",
				userSad,
				true,
				Calendar.getInstance()
				);
		GrupoPrivado VIPgroup = new GrupoPrivado(
				2,
				"new VIP group",
				"description VIP",
				userHappy,
				true,
				Calendar.getInstance()
				);

		System.out.println("___________informações padrões...____________ ");
		System.out.println(group);
		System.out.println(VIPgroup);

		
		System.out.println("___________adicionando no grupo publico...____________ ");
		group.adicionaMembro(userSad);		
		System.out.println(group);
		group.adicionaMembro(userLively);		
		System.out.println(group);
		
		System.out.println("___________removendo do grupo publico...____________ ");
		group.removeMembro(userSad);		
		System.out.println(group);
		group.removeMembro(userLively);		
		System.out.println(group);
		
		System.out.println("___________adicionando no grupo privado...____________ ");
		VIPgroup.adicionaMembro(userHappy);		
		System.out.println(VIPgroup);
		VIPgroup.adicionaMembro(userBoring);		
		System.out.println(VIPgroup);
		
		
		System.out.println("___________removendo do grupo privado...____________ ");
		VIPgroup.removeMembro(userHappy);
		System.out.println(VIPgroup);
		VIPgroup.removeMembro(userBoring);		
		System.out.println(VIPgroup);
		 
	}
}
