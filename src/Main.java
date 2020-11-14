/*	Questões:

	1) Tente modificar o valor da dono de um grupo (que é um atributo final). Crie um setter se necessário. Foi possível fazer a
	modificação? Explique.
	R: Não foi ṕossível modificar o valor do dono de um grupo, pois como foi criada como atributo final, seu valor é imutavel depois que instaciada uma vez.

	2) Agora, no método main, crie uma variável final do tipo Grupo, e instancie ela com os valores que preferir. Tente modificar
	algum atributo do objeto através de um setter, como o atributo referente ao id. Foi possível modificar esse atributo, mesmo
	com o objeto sendo final? Por quê?
	R: Sim, foi possível fazer a alteração, pois o modificador final se aplica apenas a sua referência, no caso, o objeto do tipo Grupo, e não ao conteudo do objeto referenciado, no caso, o atributo Id,
	dessa forma é possível fazer as alterações nos atributos do objeto usando os métodos de acesso
	
	3) Se ao invés de usar ArrayList para definir a lista de membros da classe Grupo tivéssemos usado um array, o que mudaria
	na implementação? Poderíamos continuar adicionado membros como fizemos? Haveria alguma limitação? Discuta as
	desvantagens dessa solução.
	R: Caso estivessemos usando Array ao invés de ArrayList passariamos a ter a lista de membros com um tamanho fixo definida no momento em que é inicializado,
	o que dificultaria caso quisessemos adicionar membros indefinidamente, ou seja, caso não saibamos quantos membros seriam adicionados, diferentemente de quando se usa  ArrayList que tem seu 
	tamanho dinâmico.
	
	4) Qual o principal benefício da herança?
	R: Com o conceito de herança podemos a partir de objetos mais gerais, criar objetos mais especializados, filhos dessas classes mais gerais, em que esses filhos poderam herdar caracteriticas
	de suas classes mães, e implementar as distinções de cada classe especializada apenas dentro de si. Essa é uma maneira bem natural de representar o mundo real, facilitando no reuso de 
	caracteristicas que conjuntos de objetos tem em comum.

	5) Adicione final na classe Grupo. O que aconteceu com o código? Por que isso aconteceu? Em vez de Grupo ser final e se
	definirmos GrupoPublico como final?
	R: Ao adicionar final na classe Grupo o código não pode mais ser compliado, pois as classes GrupoPublico e GrupoPrivado herdam de Grupo e no entanto uma classe final não pode ser herdada por nenhuma 
	outra classe. Se ao invés disso, colocarmos GrupoPublico como final, então o çódigo funcionará perfeitamente, pois não quebrará nenhuma regra, tendo em vista que a classe GrupoPublico não possue nenhum 
	herdeira, ou seja, não possue nenhuma classe filha.

	6) Por que definimos os métodos adicionaMembro e removeMembro nas classes filhas e não na classe mãe (Grupo)?
	R: Pois a implementação desse metodo para cada umas das classes filhas é diferente, caso queiramos definir na classe mãe teriamos que criar um médodo adicionaMembro e 
	removeMembro para cada classe filha, o que se tornaria inviavel conforme a classe mãe tivesse mais filhas.
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
		Admin admin = new Admin(
				"Administrator", 
				"Administrator@gmail.com.br", 
				"admin0123", 
				"descricao de admin",
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
				
		System.out.println("___________informações padrões do grupo publico...____________ ");
		System.out.println(group);
		
//		System.out.println("___________tentando mudar o dono do grupo publico...____________ ");
//		group.setDono(userHappy); -> não existe esse método, pois não é possivel modificar o dono (variavel do tipo final)
//		System.out.println(group);

		System.out.println("___________mudando status do grupo publico não sendo admin...____________ ");
		if (group.setStatus(false,userSad) == true) 
			System.out.println("Status alterado!");			
		else System.out.println("Não foi possivel alterar o status, pois não tem permissão");	
		
		System.out.println(group);
		
		System.out.println("___________mudando status do grupo publico sendo admin...____________ ");
		if (admin.desabilitaGrupo(group) == true) 
			System.out.println("Status alterado!");			
		else System.out.println("Não foi possivel alterar o status, pois não tem permissão");	

		System.out.println(group);
		
		group.setStatus(true, admin); // alterando status do grupo para true para poder adicionar e remover os membros
		
		System.out.println("___________adicionando um membro 'Chato' no grupo publico...____________ ");
		if (group.adicionaMembro(userBoring) == true) 
			System.out.println("membro adicionado!");			
		else System.out.println("Não foi possível adicionar, pois não tem permissão ou grupo inativo");			
		
		System.out.println(group);
		
		System.out.println("___________adicionando um membro 'Animado' no grupo publico...____________ ");
		if (group.adicionaMembro(userLively) == true) 
			System.out.println("membro adicionado!");			
		else System.out.println("Não foi possível adicionar, pois não tem permissão ou grupo inativo");			
		
		System.out.println(group);
		
		System.out.println("___________removendo um membro 'Chato' do grupo publico...____________ ");
		if (group.removeMembro(userBoring) == true) 
			System.out.println("membro removido!");			
		else System.out.println("Não foi possível remover, pois não tem permissão ou grupo inativo");			
			
		System.out.println(group);
		
		System.out.println("___________informações padrões do grupo privado...____________ ");
		System.out.println(VIPgroup);
		
		System.out.println("___________tentando adicionar um membro 'Chato' no grupo privado sem ser dono..____________ ");
		if (VIPgroup.adicionaMembro(userSad, userBoring) == true) 
			System.out.println("membro adicionado!");			
		else System.out.println("Não foi possível adicionar, pois não tem permissão ou grupo inativo");			
		
		System.out.println(VIPgroup);
		
		System.out.println("___________adicionando um membro 'Animado' no grupo privado...____________ ");
		if (VIPgroup.adicionaMembro(userHappy, userLively) == true) 
			System.out.println("membro adicionado!");			
		else System.out.println("Não foi possível adicionar, pois não tem permissão ou grupo inativo");					
		
		System.out.println(VIPgroup);
		
		System.out.println("___________adicionando um membro 'Chato' no grupo privado...____________ ");
		if (VIPgroup.adicionaMembro(userHappy, userBoring) == true) 
			System.out.println("membro adicionado!");			
		else System.out.println("Não foi possível adicionar, pois não tem permissão ou grupo inativo");					
		
		System.out.println(VIPgroup);
		
		System.out.println("___________tentando remover um membro 'Animado' do grupo privado sem ser dono...____________ ");
		if (VIPgroup.removeMembro(userSad, userLively) == true) 
			System.out.println("membro removido!");			
		else System.out.println("Não foi possível remover, pois não tem permissão ou grupo inativo");			
		
		System.out.println(VIPgroup);
		
		System.out.println("___________removendo um membro 'Chato' do grupo privado...____________ ");
		if (VIPgroup.removeMembro(userHappy, userBoring) == true) 
			System.out.println("membro removido!");			
		else System.out.println("Não foi possível remover, pois não tem permissão ou grupo inativo");					
		System.out.println(VIPgroup);
		 
	}
}
