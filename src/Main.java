/*	Questoes:

	3.1.1) Qual foi a estratégia abordada: Interface, Classe Abstrata ou manutenção da classe concreta? Explique sua escolha.
	R: Classe Abstrata. O primeiro ponto a se observar é que a classe GrupoPublico e classe GrupoPrivado estão intimamente ligadas entre si e se relacionam com a classe Grupo (classe mãe) mais como tipos especificos de Grupo,no sentido de herança, e não como classes que devem obedecer uma certo contrato de implementação assim como é a interface, podendo ter a possíbilidade, inclusive, de ter metodos concretos dentro de Grupo que são herdados pelas classes filhas, GrupoPublico e GrupoPrivado.
	
	3.1.4) Em outra possível abordagem, a classe Usuario poderia ser implementada como uma Interface? Caso sim, por quê? Quais alterações seriam necessárias?
	R: Sim, pois poderiamos enxergar a classe Usuario apenas como um modelo o qual as classes filhas devem seguir, determinando os metodos que devem ser implementados. Para fazer esse alteração precisariamos passar todos os atributos de usuario para suas classes filhas, transformar todas seus metodos em metodos abstrados e fazer a implementação desses metodos nas suas classes filhas. Apesar de ser possível, não acredito que seja a melhor abordagem, tendo em vista que usando classe Abstratas podemos ter métodos concretos e instancias na classe usuario, o que faz com que reutilizamos bastante código que, no caso de ser interface, precisariamos copiar para cada filho, mesmo tendo implemetações iguais, como seria o caso nesse exemplo.

*/

import java.util.ArrayList;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {

		Calendar futureTime = Calendar.getInstance();
		futureTime.set(2030, Calendar.MARCH, 6);
		
		Perfil perfilSad = new Perfil(
				Sexo.Homem,
				Calendar.getInstance(),
				"cidade",
				Estado.Alagoas,
				"(19)999999999",
				"descricao1",
				"foto1"
				);
		Perfil perfilBoring = new Perfil(
				Sexo.Homem,
				Calendar.getInstance(),
				"cidade",
				Estado.Acre,
				"(19)999999999",
				"descricao2",
				"foto2"
				);
		Perfil perfilAdmin = new Perfil(
				Sexo.Mulher,
				Calendar.getInstance(),
				"cidade",
				Estado.Amapá,
				"(19)999999999",
				"descricao3",
				"foto3"
				);
		Usuario userSad = new UsuarioComum (
				"userSad", 
				"tristeza@gmail.com.br", 
				"triste0123", 
				"descricao triste",
				false ,
				new ArrayList<Grupo>(),
				Calendar.getInstance(),
				perfilSad
				);
		Usuario userBoring = new UsuarioConvidado (
				"userBoring", 
				"chato@gmail.com.br", 
				"chato0123", 
				"descricao chata",
				false ,
				new ArrayList<Grupo>(),
				Calendar.getInstance(),
				futureTime,
				perfilBoring
				);
		Usuario adminSenior = new Admin(
				"adminSenior", 
				"Administrator@gmail.com.br", 
				"admin0123", 
				"descricao de admin",
				true ,
				new ArrayList<Grupo>(),
				Calendar.getInstance(),
				perfilAdmin
				);
		
		System.out.println("___________ 0. Crie N grupos, privados e públicos. ____________ ");
		System.out.println("___________ 0.1. criando grupo publico ____________ ");
		System.out.println(" adminSenior criando grupo publico");
		Grupo publicGroup1 = adminSenior.criaGrupo(true); 
		if (publicGroup1 != null) System.out.println(" Grupo criado!");
		else System.out.println(" Não foi possível criar o grupo!");
		System.out.println();
		
		System.out.println("___________ 0.2. criando grupo privado ____________ ");
		System.out.println(" adminSenior criando grupo privado");
		Grupo privateGroup1 = adminSenior.criaGrupo(false); 
		if (privateGroup1 != null) System.out.println(" Grupo criado!");
		else System.out.println(" Não foi possível criar o grupo!");
		System.out.println();

		ArrayList<Permissao> listOfPermission = new ArrayList<Permissao>();
		listOfPermission.add(Permissao.ADICIONAR_USUARIO);

		
		System.out.println("___________ 1. grupo publico ____________ ");
		System.out.println();
		System.out.println("1.1 Adicione ao menos 3 usuários ao grupo, um usuário de cada tipo.");
		System.out.println();
		if (publicGroup1.adicionaMembro(adminSenior, userBoring) == false) {
			System.out.println( " Nao foi possivel adicionar o membro no grupo!");
		}else System.out.println( " Membro adicionado no grupo!");
		if (publicGroup1.adicionaMembro(adminSenior, userSad) == false) {
			System.out.println( " Nao foi possivel adicionar o membro no grupo!");
		}else System.out.println( " Membro adicionado no grupo!");
		System.out.println();
		System.out.println();

		System.out.println("1.2. Utilize um usuário do grupo para criar 6 cartões com diferentes níveis de prioridade e atribuia como o responsável algum outro usuário do grupo.");
		if (adminSenior.criarCartao(0, "cartao publico 1", 1, "assunto", 1, userSad ) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (adminSenior.criarCartao(0, "cartao publico 2", 1, "assunto", 2, userSad ) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (adminSenior.criarCartao(0, "cartao publico 3", 1, "assunto", 3, userSad ) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (adminSenior.criarCartao(0, "cartao publico 4", 1, "assunto", 4, userSad ) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (adminSenior.criarCartao(0, "cartao publico 5", 1, "assunto", 4, userSad ) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (adminSenior.criarCartao(0, "cartao publico 6", 1, "assunto", 5, userSad ) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		System.out.println();
		System.out.println(); 

		System.out.println("1.3. Imprima os cartoes criados:");
		System.out.println(publicGroup1.getCartoesAFazer());
		System.out.println(); 
		System.out.println(); 

		System.out.println(" 1.4. Execute todos os cartões criados de acordo com suas prioridades.:");
		if (userSad.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println( " Nao foi possivel executar tarefa!");
		}else System.out.println( "_____ Tarefa executada! _____");
		for (Cartao cartao: publicGroup1.getCartoesAFazer()) {
			System.out.println("  cartao id = " + cartao.getId());
			System.out.println("  cartao = " + cartao.getNome());
			System.out.println("  labels = " + cartao.getLabel());
			System.out.println("  prioridade: "+cartao.getPrioridade() + "\n");
			}
			
		if (userSad.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println( " Nao foi possivel executar tarefa!");
		}else System.out.println( "_____ Tarefa executada! _____");
		for (Cartao cartao: publicGroup1.getCartoesAFazer()) {
			System.out.println("  cartao id = " + cartao.getId());
			System.out.println("  cartao = " + cartao.getNome());
			System.out.println("  labels = " + cartao.getLabel());
			System.out.println("  prioridade: "+cartao.getPrioridade() + "\n");
			}
		
		if (userSad.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println( " Nao foi possivel executar tarefa!");
		}else System.out.println( "_____ Tarefa executada! _____");
		for (Cartao cartao: publicGroup1.getCartoesAFazer()) {
			System.out.println("  cartao id = " + cartao.getId());
			System.out.println("  cartao = " + cartao.getNome());
			System.out.println("  labels = " + cartao.getLabel());
			System.out.println("  prioridade: "+cartao.getPrioridade() + "\n");
			}
		
		if (userSad.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println( " Nao foi possivel executar tarefa!");
		}else System.out.println( "_____ Tarefa executada! _____");
		for (Cartao cartao: publicGroup1.getCartoesAFazer()) {
			System.out.println("  cartao id = " + cartao.getId());
			System.out.println("  cartao = " + cartao.getNome());
			System.out.println("  labels = " + cartao.getLabel());
			System.out.println("  prioridade: "+cartao.getPrioridade() + "\n");
			}
		
		if (userSad.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println( " Nao foi possivel executar tarefa!");
		}else System.out.println( "_____ Tarefa executada! _____");
		for (Cartao cartao: publicGroup1.getCartoesAFazer()) {
			System.out.println("  cartao id = " + cartao.getId());
			System.out.println("  cartao = " + cartao.getNome());
			System.out.println("  labels = " + cartao.getLabel());
			System.out.println("  prioridade: "+cartao.getPrioridade() + "\n");
			}
		
		if (userSad.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println( " Nao foi possivel executar tarefa!");
		}else System.out.println( "_____ Tarefa executada! _____");
		for (Cartao cartao: publicGroup1.getCartoesAFazer()) {
			System.out.println("  cartao id = " + cartao.getId());
			System.out.println("  cartao = " + cartao.getNome());
			System.out.println("  labels = " + cartao.getLabel());
			System.out.println("  prioridade: "+cartao.getPrioridade() + "\n");
			}
		
		
		System.out.println("___________ 2. grupo privado ____________ ");
		System.out.println();
		System.out.println("2.1 Adicione ao menos 3 usuários ao grupo, um usuário de cada tipo.");
		System.out.println();
		if (privateGroup1.adicionaMembro(adminSenior, userBoring) == false) {
			System.out.println( " Nao foi possivel adicionar o membro no grupo!");
		}else System.out.println( " Membro adicionado no grupo!");
		if (privateGroup1.adicionaMembro(adminSenior, userSad) == false) {
			System.out.println( " Nao foi possivel adicionar o membro no grupo!");
		}else System.out.println( " Membro adicionado no grupo!");
		System.out.println();
		System.out.println();

		System.out.println("2.2. Utilize um usuário do grupo para criar 6 cartões com diferentes níveis de prioridade e atribuia como o responsável algum outro usuário do grupo.");
		if (adminSenior.criarCartao(1, "cartao privado 1", 1, "assunto", 1, userBoring ) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (adminSenior.criarCartao(1, "cartao privado 2", 1, "assunto", 2, userBoring ) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (adminSenior.criarCartao(1, "cartao privado 3", 1, "assunto", 3, userBoring ) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (adminSenior.criarCartao(1, "cartao privado 4", 1, "assunto", 4, userBoring ) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (adminSenior.criarCartao(1, "cartao privado 5", 1, "assunto", 1, userBoring ) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (adminSenior.criarCartao(1, "cartao privado 6", 1, "assunto", 5, userBoring ) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		System.out.println();
		System.out.println(); 

		System.out.println("2.3. Imprima os cartoes criados:");
		System.out.println(privateGroup1.getCartoesAFazer());
		System.out.println(); 
		System.out.println(); 

		System.out.println("2.4. Execute todos os cartões criados de acordo com suas prioridades.:");
		if (userSad.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println( " Nao foi possivel executar tarefa!");
		}else System.out.println( "_____ Tarefa executada! _____");
		for (Cartao cartao: privateGroup1.getCartoesAFazer()) {
			System.out.println("  cartao id = " + cartao.getId());
			System.out.println("  cartao = " + cartao.getNome());
			System.out.println("  labels = " + cartao.getLabel());
			System.out.println("  prioridade: "+cartao.getPrioridade() + "\n");
			}
			
		if (userSad.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println( " Nao foi possivel executar tarefa!");
		}else System.out.println( "_____ Tarefa executada! _____");
		for (Cartao cartao: privateGroup1.getCartoesAFazer()) {
			System.out.println("  cartao id = " + cartao.getId());
			System.out.println("  cartao = " + cartao.getNome());
			System.out.println("  labels = " + cartao.getLabel());
			System.out.println("  prioridade: "+cartao.getPrioridade() + "\n");
			}
		
		if (userSad.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println( " Nao foi possivel executar tarefa!");
		}else System.out.println( "_____ Tarefa executada! _____");
		for (Cartao cartao: privateGroup1.getCartoesAFazer()) {
			System.out.println("  cartao id = " + cartao.getId());
			System.out.println("  cartao = " + cartao.getNome());
			System.out.println("  labels = " + cartao.getLabel());
			System.out.println("  prioridade: "+cartao.getPrioridade() + "\n");
			}
		
		if (userSad.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println( " Nao foi possivel executar tarefa!");
		}else System.out.println( "_____ Tarefa executada! _____");
		for (Cartao cartao: privateGroup1.getCartoesAFazer()) {
			System.out.println("  cartao id = " + cartao.getId());
			System.out.println("  cartao = " + cartao.getNome());
			System.out.println("  labels = " + cartao.getLabel());
			System.out.println("  prioridade: "+cartao.getPrioridade() + "\n");
			}
		
		if (userSad.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println( " Nao foi possivel executar tarefa!");
		}else System.out.println( "_____ Tarefa executada! _____");
		for (Cartao cartao: privateGroup1.getCartoesAFazer()) {
			System.out.println("  cartao id = " + cartao.getId());
			System.out.println("  cartao = " + cartao.getNome());
			System.out.println("  labels = " + cartao.getLabel());
			System.out.println("  prioridade: "+cartao.getPrioridade() + "\n");
			}
		
		if (userSad.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println( " Nao foi possivel executar tarefa!");
		}else System.out.println( "_____ Tarefa executada! _____");
		for (Cartao cartao: privateGroup1.getCartoesAFazer()) {
			System.out.println("  cartao id = " + cartao.getId());
			System.out.println("  cartao = " + cartao.getNome());
			System.out.println("  labels = " + cartao.getLabel());
			System.out.println("  prioridade: "+cartao.getPrioridade() + "\n");
			}
	}
}
