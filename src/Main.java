/*	Questoes:

	1) Explique o que é polimorfismo, qual sua importancia e por que deve ser utilizado.
	R: Polimorfismo é o principio do qual dada uma classe mae, o qual possue sua implementacao,temos comportamentos diferentes para cada classe filha dessa classe mae para os metodos com a mesma assinatura. 
	Sua importancia é dada quando precisamos que as subclasses tenham comportamentos específicos e diferentes entre si. 
	Sua ultilizacao é necessária para que assim possamos ter  um código mais legível e coeso, visto que apesar de ser implementado diferentes, a o nome da operação é o mesmo, e além do fato de tornar o código mais flexivel e escalavel, pelo fato de poder incluir novas classses sem alterar as existentes.
	
	2) Como é o funcionamento do polimorfismo na linguagem Java?
	R: Quando um objeto, que é uma subclasse, chama um método polimorfico, esse metodo estara sobrescrito sobre o metodo da super classe, pois possui a mesma assinatura, dessa forma o  programa irá buscar pelo método "mais próximo" da classe do objeto que chamou o método, portanto o comportamento que será executado será o próprio método da subclasse. Importante ressaltar que isso só é possível por causa da Ligação dinâmica do java (a mensagem só é ligada a um método em tempo de execução).
	
	3) O que acontece se instanciarmos uma subclasse em uma variavel da superclasse e tentarmos chamar um método que nao foi implementado na superclasse? Como você resolveria essa situacao?
	R: Ocorrerá um erro, pois como é uma variável da superclasse, ela também deve ter o método implementado na sua classe. Então para que funcione, teremos que implementar o método na super classe também e não apenas na subclasse

*/

import java.util.ArrayList;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {

		Calendar futureTime = Calendar.getInstance();
		futureTime.set(2030, Calendar.MARCH, 6);
		
		System.out.println("0. Crie N variáveis do tipo Usuario e suas herdeiras (algum deles sendo uma instância Admin) e tente criar um grupo para cada usuário.");
		System.out.println();

		Usuario userSad = new Usuario (
				"userSad", 
				"tristeza@gmail.com.br", 
				"triste0123", 
				"descricao triste",
				false ,
				new ArrayList<Grupo>(),
				Calendar.getInstance()
				);
		UsuarioConvidado userBoring = new UsuarioConvidado (
				"userBoring", 
				"chato@gmail.com.br", 
				"chato0123", 
				"descricao chata",
				false ,
				new ArrayList<Grupo>(),
				Calendar.getInstance(),
				futureTime
				);
		Admin adminSenior = new Admin(
				"adminSenior", 
				"Administrator@gmail.com.br", 
				"admin0123", 
				"descricao de admin",
				true ,
				new ArrayList<Grupo>(),
				Calendar.getInstance()
				);
		
		System.out.println(" 0.1 userSad criando grupo...");
		Grupo grupo1 = userSad.criaGrupo(false);
		if (grupo1 != null) System.out.println(" Grupo criado!");
		else System.out.println(" Não foi possível criar o grupo!");
		System.out.println();

		System.out.println(" 0.2 userBoring criando grupo...");
		Grupo grupo2 = userBoring.criaGrupo(false);
		if (grupo2 != null) System.out.println(" Grupo criado!");
		else System.out.println(" Não foi possível criar o grupo!");
		System.out.println();

		System.out.println(" 0.3 adminSenior criando grupo...");
		Grupo publicGroup1 = adminSenior.criaGrupo(true); 
		if (publicGroup1 != null) System.out.println(" Grupo criado!");
		else System.out.println(" Não foi possível criar o grupo!");
		System.out.println();

		System.out.println(" 0.4 adminSenior criando grupo...");
		Grupo publicGroup2 = adminSenior.criaGrupo(true); 
		if (publicGroup2 != null) System.out.println(" Grupo criado!");
		else System.out.println(" Não foi possível criar o grupo!");
		System.out.println();
		
		System.out.println(" 0.5 adminSenior criando grupo...");
		Grupo privateGroup1 = adminSenior.criaGrupo(false); 
		if (privateGroup1 != null) System.out.println(" Grupo criado!");
		else System.out.println(" Não foi possível criar o grupo!");
		System.out.println();

		ArrayList<Permissao> listOfPermission = new ArrayList<Permissao>();
		listOfPermission.add(Permissao.ADICIONAR_USUARIO);

		
		System.out.println("___________ publicGroup1 ____________ ");
		System.out.println();
		System.out.println("1. Adicione ao menos 2 membros ao grupo.");
		System.out.println();
		if (publicGroup1.adicionaMembro(adminSenior, userBoring) == false) {
			System.out.println( " Nao foi possivel adicionar o membro no grupo!");
		}else System.out.println( " Membro adicionado no grupo!");
		if (publicGroup1.adicionaMembro(adminSenior, userSad) == false) {
			System.out.println( " Nao foi possivel adicionar o membro no grupo!");
		}else System.out.println( " Membro adicionado no grupo!");
		System.out.println();
		System.out.println("2. Imprima as permissoes de cada membro adicionado:");
		System.out.println();
		System.out.println(" 2.1 Quem tem permissao de adicionar:");
		for(Usuario user: publicGroup1.getPermissaoAdicionar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 2.2 Quem tem permissao de alterar:");
		for(Usuario user: publicGroup1.getPermissaoAlterar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 2.3 Quem tem permissao de criar cartao:");
		for(Usuario user: publicGroup1.getPermissaoCriarCartao()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 2.4 Quem tem permissao de remover:");
		for(Usuario user: publicGroup1.getPermissaoRemover()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 2.5 Quem tem permissao de visualizar:");
		for(Usuario user: publicGroup1.getPermissaoVisualizar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println();
		System.out.println("3. Teste a permissoes para ao menos 1 membro do grupo, ou seja:");
		System.out.println(); 
		System.out.println(" 3.1 Remova membros do grupo e imprima o resultado obtido.");
		System.out.println( "  3.1.1 Membros no grupo antes de remover:");
		for(Usuario user: publicGroup1.getMembros()) {
			System.out.println("   "+user.getLogin());
		}
		if (publicGroup1.removeMembro(userBoring, userSad) == false) {
			System.out.println( "  Nao foi possivel remover o membro no grupo!");
		}else System.out.println( "  Membro removido do grupo!");
		System.out.println( "  3.1.2 Membros no grupo depois de remover:");
		for(Usuario user: publicGroup1.getMembros()) {
			System.out.println("   "+user.getLogin());
		}
		System.out.println();
		System.out.println(" 3.2 Adicione novos membros ao grupo e imprima o resultado obtido.");
		System.out.println( "  3.2.1 Membros no grupo antes de adicionar:");
		for(Usuario user: publicGroup1.getMembros()) {
			System.out.println("   "+user.getLogin());
		}
		if (publicGroup1.adicionaMembro(userBoring, userSad) == false) {
			System.out.println( "  Nao foi possivel adicionar o membro no grupo!");
		}else System.out.println( "  Membro adicionado no grupo!");
		System.out.println( "  3.2.2 Membros no grupo depois de adicionar:");
		for(Usuario user: publicGroup1.getMembros()) {
			System.out.println("   "+user.getLogin());
		}
		System.out.println(); 
		System.out.println(" 3.3 Altere a permissao de membros do grupo.");
		System.out.println( "  3.3.1 Membros que tem permissao de adicionar antes de tirar a permissao:");
		for(Usuario user: publicGroup1.getPermissaoAdicionar()) {
			System.out.println("   "+user.getLogin());
		}
		if (publicGroup1.removePermissao(userBoring, userSad, listOfPermission) == false) {
			System.out.println( "  Nao foi possivel remover as permissoes!");
		}else System.out.println( "  Permissoes removidas!");
		System.out.println( "  3.3.2 Membros que tem permissao de adicionar depois de tirar a permissao:");
		for(Usuario user: publicGroup1.getPermissaoAdicionar()) {
			System.out.println("   "+user.getLogin());
		}
		System.out.println();
		System.out.println(" 3.4 Visualize os dados do grupo.");
		System.out.println("  "+publicGroup1);
		System.out.println();
		System.out.println(" 4 Imprima a lista de usuarios de cada permissao.");
		System.out.println();
		System.out.println(" 4.1 Quem tem permissao de adicionar:");
		for(Usuario user: publicGroup1.getPermissaoAdicionar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 4.2 Quem tem permissao de alterar:");
		for(Usuario user: publicGroup1.getPermissaoAlterar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 4.3 Quem tem permissao de criar cartao:");
		for(Usuario user: publicGroup1.getPermissaoCriarCartao()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 4.4 Quem tem permissao de remover:");
		for(Usuario user: publicGroup1.getPermissaoRemover()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 4.5 Quem tem permissao de visualizar:");
		for(Usuario user: publicGroup1.getPermissaoVisualizar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println();		
		System.out.println();
		
		System.out.println("___________ publicGroup2 ____________ ");
		System.out.println();
		System.out.println("1. Adicione ao menos 2 membros ao grupo.");
		System.out.println();
		if (publicGroup2.adicionaMembro(adminSenior, userSad) == false) {
			System.out.println( " Nao foi possivel adicionar o membro no grupo!");
		}else System.out.println( " Membro adicionado no grupo!");
		if (publicGroup2.adicionaMembro(adminSenior, userBoring) == false) {
			System.out.println( " Nao foi possivel adicionar o membro no grupo!");
		}else System.out.println( " Membro adicionado no grupo!");
		System.out.println();
		System.out.println("2. Imprima as permissoes de cada membro adicionado:");
		System.out.println();
		System.out.println(" 2.1 Quem tem permissao de adicionar:");
		for(Usuario user: publicGroup2.getPermissaoAdicionar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 2.2 Quem tem permissao de alterar:");
		for(Usuario user: publicGroup2.getPermissaoAlterar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 2.3 Quem tem permissao de criar cartao:");
		for(Usuario user: publicGroup2.getPermissaoCriarCartao()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 2.4 Quem tem permissao de remover:");
		for(Usuario user: publicGroup2.getPermissaoRemover()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 2.5 Quem tem permissao de visualizar:");
		for(Usuario user: publicGroup2.getPermissaoVisualizar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println();
		System.out.println("3. Teste a permissoes para ao menos 1 membro do grupo, ou seja:");
		System.out.println(); 
		System.out.println(" 3.1 Remova membros do grupo e imprima o resultado obtido.");
		System.out.println( "  3.1.1 Membros no grupo antes de remover:");
		for(Usuario user: publicGroup2.getMembros()) {
			System.out.println("   "+user.getLogin());
		}
		if (publicGroup2.removeMembro(userSad, userBoring) == false) {
			System.out.println( "  Nao foi possivel remover o membro no grupo!");
		}else System.out.println( "  Membro removido do grupo!");
		System.out.println( "  3.1.2 Membros no grupo depois de remover:");
		for(Usuario user: publicGroup2.getMembros()) {
			System.out.println("   "+user.getLogin());
		}
		System.out.println();
		System.out.println(" 3.2 Adicione novos membros ao grupo e imprima o resultado obtido.");
		System.out.println( "  3.2.1 Membros no grupo antes de adicionar:");
		for(Usuario user: publicGroup2.getMembros()) {
			System.out.println("   "+user.getLogin());
		}
		if (publicGroup2.adicionaMembro(userSad, userBoring) == false) {
			System.out.println( "  Nao foi possivel adicionar o membro no grupo!");
		}else System.out.println( "  Membro adicionado no grupo!");
		System.out.println( "  3.2.2 Membros no grupo depois de adicionar:");
		for(Usuario user: publicGroup2.getMembros()) {
			System.out.println("   "+user.getLogin());
		}
		System.out.println(); 
		System.out.println(" 3.3 Altere a permissao de membros do grupo.");
		System.out.println( "  3.3.1 Membros que tem permissao de adicionar antes de tirar a permissao:");
		for(Usuario user: publicGroup2.getPermissaoAdicionar()) {
			System.out.println("   "+user.getLogin());
		}
		if (publicGroup2.removePermissao(userSad, userBoring, listOfPermission) == false) {
			System.out.println( "  Nao foi possivel remover as permissoes!");
		}else System.out.println( "  Permissoes removidas!");
		System.out.println( "  3.3.2 Membros que tem permissao de adicionar depois de tirar a permissao:");
		for(Usuario user: publicGroup2.getPermissaoAdicionar()) {
			System.out.println("   "+user.getLogin());
		}
		System.out.println();
		System.out.println(" 3.4 Visualize os dados do grupo.");
		System.out.println("  "+publicGroup2);
		System.out.println();
		System.out.println(" 4 Imprima a lista de usuarios de cada permissao.");
		System.out.println();
		System.out.println(" 4.1 Quem tem permissao de adicionar:");
		for(Usuario user: publicGroup2.getPermissaoAdicionar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 4.2 Quem tem permissao de alterar:");
		for(Usuario user: publicGroup2.getPermissaoAlterar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 4.3 Quem tem permissao de criar cartao:");
		for(Usuario user: publicGroup2.getPermissaoCriarCartao()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 4.4 Quem tem permissao de remover:");
		for(Usuario user: publicGroup2.getPermissaoRemover()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 4.5 Quem tem permissao de visualizar:");
		for(Usuario user: publicGroup2.getPermissaoVisualizar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println();		
		System.out.println();
		
		System.out.println("___________ privateGroup1 ____________ ");
		System.out.println();
		System.out.println("1. Adicione ao menos 2 membros ao grupo.");
		System.out.println();
		if (privateGroup1.adicionaMembro(adminSenior, userSad) == false) {
			System.out.println( " Nao foi possivel adicionar o membro no grupo!");
		}else System.out.println( " Membro adicionado no grupo!");
		if (privateGroup1.adicionaMembro(adminSenior, userBoring) == false) {
			System.out.println( " Nao foi possivel adicionar o membro no grupo!");
		}else System.out.println( " Membro adicionado no grupo!");
		System.out.println();
		System.out.println("2. Imprima as permissoes de cada membro adicionado:");
		System.out.println();
		System.out.println(" 2.1 Quem tem permissao de adicionar:");
		for(Usuario user: privateGroup1.getPermissaoAdicionar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 2.2 Quem tem permissao de alterar:");
		for(Usuario user: privateGroup1.getPermissaoAlterar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 2.3 Quem tem permissao de criar cartao:");
		for(Usuario user: privateGroup1.getPermissaoCriarCartao()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 2.4 Quem tem permissao de remover:");
		for(Usuario user: privateGroup1.getPermissaoRemover()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 2.5 Quem tem permissao de visualizar:");
		for(Usuario user: privateGroup1.getPermissaoVisualizar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println();
		System.out.println("3. Teste a permissoes para ao menos 1 membro do grupo, ou seja:");
		System.out.println(); 
		System.out.println(" 3.1 Remova membros do grupo e imprima o resultado obtido.");
		System.out.println( "  3.1.1 Membros no grupo antes de remover:");
		for(Usuario user: privateGroup1.getMembros()) {
			System.out.println("   "+user.getLogin());
		}
		if (privateGroup1.removeMembro(userSad, userSad) == false) {
			System.out.println( "  Nao foi possivel remover o membro no grupo!");
		}else System.out.println( "  Membro removido do grupo!");
		System.out.println( "  3.1.2 Membros no grupo depois de remover:");
		for(Usuario user: privateGroup1.getMembros()) {
			System.out.println("   "+user.getLogin());
		}
		System.out.println();
		System.out.println(" 3.2 Adicione novos membros ao grupo e imprima o resultado obtido.");
		System.out.println( "  3.2.1 Membros no grupo antes de adicionar:");
		for(Usuario user: privateGroup1.getMembros()) {
			System.out.println("   "+user.getLogin());
		}
		if (privateGroup1.adicionaMembro(userSad, userSad) == false) {
			System.out.println( "  Nao foi possivel adicionar o membro no grupo!");
		}else System.out.println( "  Membro adicionado no grupo!");
		System.out.println( "  3.2.2 Membros no grupo depois de adicionar:");
		for(Usuario user: privateGroup1.getMembros()) {
			System.out.println("   "+user.getLogin());
		}
		System.out.println(); 
		System.out.println(" 3.3 Altere a permissao de membros do grupo.");
		System.out.println( "  3.3.1 Membros que tem permissao de adicionar antes de tirar a permissao:");
		for(Usuario user: privateGroup1.getPermissaoAdicionar()) {
			System.out.println("   "+user.getLogin());
		}
		if (privateGroup1.removePermissao(userSad, userSad, listOfPermission) == false) {
			System.out.println( "  Nao foi possivel remover as permissoes!");
		}else System.out.println( "  Permissoes removidas!");
		System.out.println( "  3.3.2 Membros que tem permissao de adicionar depois de tirar a permissao:");
		for(Usuario user: privateGroup1.getPermissaoAdicionar()) {
			System.out.println("   "+user.getLogin());
		}
		System.out.println();
		System.out.println(" 3.4 Visualize os dados do grupo.");
		System.out.println("  "+privateGroup1);
		System.out.println();
		System.out.println(" 4 Imprima a lista de usuarios de cada permissao.");
		System.out.println();
		System.out.println(" 4.1 Quem tem permissao de adicionar:");
		for(Usuario user: privateGroup1.getPermissaoAdicionar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 4.2 Quem tem permissao de alterar:");
		for(Usuario user: privateGroup1.getPermissaoAlterar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 4.3 Quem tem permissao de criar cartao:");
		for(Usuario user: privateGroup1.getPermissaoCriarCartao()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 4.4 Quem tem permissao de remover:");
		for(Usuario user: privateGroup1.getPermissaoRemover()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println(" 4.5 Quem tem permissao de visualizar:");
		for(Usuario user: privateGroup1.getPermissaoVisualizar()) {
			System.out.println("  "+user.getLogin());
		}
		System.out.println();		
		System.out.println();
		
		System.out.println("Para cada usuario criado, crie N cartoes e imprima o resultado.");
		System.out.println();
		System.out.println(" ___________ userSad ____________ ");
		if (userSad.criarCartao(0) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (userSad.criarCartao(0)== false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (userSad.criarCartao(0) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		System.out.println();
		System.out.println(" ___________ userBoring ____________ ");
		if (userBoring.criarCartao(1) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (userBoring.criarCartao(1)== false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (userBoring.criarCartao(1) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		System.out.println();
		System.out.println(" ___________ adminSenior ____________ ");
		if (adminSenior.criarCartao(2) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (adminSenior.criarCartao(2)== false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		if (adminSenior.criarCartao(2) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		}else System.out.println( " Cartao criado!");
		System.out.println();
		System.out.println(" Cartoes do publicGroup1:");
		System.out.println(publicGroup1.getCartoes());
		System.out.println();
		System.out.println(" Cartoes do publicGroup2:");
		System.out.println(publicGroup2.getCartoes());
		System.out.println();
		System.out.println(" Cartoes do privateGroup1:");
		System.out.println(privateGroup1.getCartoes());

	}
}
