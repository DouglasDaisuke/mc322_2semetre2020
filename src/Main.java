/*	Questões:
 
	1) Qual o impacto de se tentar mudar diretamente o valor do atributo login de um dos objetos Usuario no método main? Por quê?
	- Ocorre um erro na compilação do código. Pois o atributo login esta como "private", ou seja, não é visível para as Classes fora da Classe Usuario

	2) Como você trataria o problema levantado na questão anterior? Qual seriam os prós e os contras desta nova abordagem? Que conceito de Orientação a Objetos estaria sendo ”quebrado” neste caso?
	- Caso queira mudar o valor do atributo, podemos utilizar o metodo setLogin, dessa forma materiamos o conceito de encapsulamento. 
	O Lado positivo de usar encapsulamento é que garantimos a segurança, garantindo que a interação de quem está mexendo com o atributo Login e o atributo seja somente pelos metodos, além disso, o encapsulamento impede que ao fazer uma mudança no atributo dentro da classe Usuario, isso não cause problemas em Classes externas e por fim, isso ajuda a simplificar os programas, tendo em vista que a responsabilidade da forma de implementação é somente da Classe Usuario e não de quem a usa.
	O Lado negativo dessa nova abordagem seria que a pessoa que fosse ultilizar a Classe Usuario precisaria seguir necessariamente os metodos dados por quem criou essa Classe, tendo limitações de implementação, mas é importante resaltar que é um contraponto irrelevante tendo em vista as grandes vantagens do encapsulamento.
 */

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		Usuario userHappy = new Usuario (
				0, 
				"Felicidade", 
				"feliz@gmail.com.br", 
				"feliz0123", 
				true ,
				Calendar.getInstance()
		);
		Usuario userSad = new Usuario (
				1, 
				"Tristeza", 
				"tristeza@gmail.com.br", 
				"triste0123", 
				false ,
				Calendar.getInstance()
		);
		Perfil profilePersonal = new Perfil(
				'm', 
				Calendar.getInstance(), 
				"Campinas", 
				"São Paulo", 
				"(11)40028922", 
				"um perfil qualquer", 
				"uma foto aleatoria"
		);
		Perfil profileProfessional = new Perfil(
				'f', 
				Calendar.getInstance(), 
				"João Pessoa", 
				"Paraiba", 
				"(83)40028922", 
				"um perfil profissional", 
				"uma foto profissional"
		);
		System.out.println("Usuario 1: " +userHappy+"\n");
		System.out.println("Usuario 2: " +userSad+"\n");
		System.out.println("Perfil 1: " +profilePersonal+"\n");
		System.out.println("Perfil 2: " +profileProfessional+"\n");
	}
}
