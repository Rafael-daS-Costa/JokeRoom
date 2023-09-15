package entities;

public class JokeList {
	private String[] knockKnock = { "Noé", "Dem", "Mário", "KGB"};
	
    private String[] kkAnswers = { 
			 "Noé da sua conta.",
             "Demorou pra responder e eu esqueci a piada.",
             "Deixa quieto.",
             "Slap! Nós quem fazemos as perguntas!"
             					};
	private String[] stories = {
    		"Seu delegado, meu marido saiu de casa hoje"
    		+" cedo pra comprar arroz e não voltou, o que faço?",
    		"Contratei um personal que me recomendou uma série"
    		+" de abdominais.",
    		"Psiquiatra: Por hoje é só. Na próxima sessão"
    		+" trabalharemos com o inconsciente.",
    		"A luz viaja mais rápido que o som."
					    		};
    private String[] storiesPunchLine = {
			   "Sei lá, faz macarrão.",
			   "Mas até agora não encontrei no catálogo da Netflix",
			   "Paciente: Impossível! Meu marido não quer vir.",
			   "Por isso muita gente parece brilhante até a ouvirmos falar."
								};
    private String[] littleDot = {
			   "O que é um pontinho vermelho na salada?",
			   "O que é um pontinho azul no céu?",
			   "O que é um pontinho amarelo na estrada?",
			   "O que é um pontinho vermelho no pântano?"
			};
    private String[] littleDotAnswers = {
			   "Uma ervilha prendendo a respiração.",
			   "Um urublue.",
			   "Um Uno milho.",
			   "Um jacared."
			};
    private String[] guessing = {
				"O que é pior que ser atingido por um raio?",
				"Por que a catarata é a doença mais óbvia?",
				"Qual a semelhança entre o divórcio e a granada?",
				"Qual a fórmula da água benta?"
    							};
    private String[] guessingAnswers = {
				"Ser atingido pelo diâmetro, que tem o dobro do tamanho.",
				"Porque ela dá na vista.",
				"Se tirar o anel leva metade da casa.",
				"H Deus O."
									};
	public String[] getKnockKnock() {
		return knockKnock;
	}
	public String[] getKkAnswers() {
		return kkAnswers;
	}
	public String[] getStories() {
		return stories;
	}
	public String[] getStoriesPunchLine() {
		return storiesPunchLine;
	}
	public String[] getLittleDot() {
		return littleDot;
	}
	public String[] getLittleDotAnswers() {
		return littleDotAnswers;
	}
	public String[] getGuessing() {
		return guessing;
	}
	public String[] getGuessingAnswers() {
		return guessingAnswers;
	}
    
    
}
