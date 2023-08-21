package entities;
import java.net.*;

public class JokeList {
	private static final int CHOOSING = 0;
	private static final int SENTJOKE = 1;
	private static final int SENTCLUE = 2;
	private static final int ANOTHER = 3;
	
	private int state = CHOOSING;
	private int currentJoke = 0;
	
	private String[] toctoc = { "Noé", "Dem", "Mário", "KGB"};
    private String[] respostas = { "Noé da sua conta.",
                                 "Demorou pra responder e eu esqueci a piada.",
                                 "Deixa quieto.",
                                 "Slap! Nós quem fazemos as perguntas!"};
	private String[] historinha = {
					    		"Seu delegado, meu marido saiu de casa hoje"
					    		+" cedo pra comprar arroz e não voltou, o que faço?",
					    		"Contratei um personal que me recomendou uma série"
					    		+" de abdominais.",
					    		"Psiquiatra: Por hoje é só. Na próxima sessão"
					    		+" trabalharemos com o inconsciente.",
					    		"A luz viaja mais rápido que o som."
					    		
    						};
    private String[] punchLine = {
    							   "Sei lá, faz macarrão.",
    							   "Mas até agora não encontrei no catálogo da Netflix",
    							   "Paciente: Impossível! Meu marido não quer vir.",
    							   "Por isso muita gente parece brilhante até a ouvirmos falar"
    							};
    private String[] pontinho = {
			   "O que é um pontinho vermelho na salada?",
			   "O que é um pontinho azul no céu?",
			   "O que é um pontinho amarelo na estrada?",
			   "O que é um pontinho vermelho no pântano?"
			};
    private String[] pontinhoResp = {
			   "Uma ervilha prendendo a respiração.",
			   "Um urublue",
			   "Um Uno milho",
			   "Um jacared"
			};
    private String[] adivinhas = {
    							"O que é pior que ser atingido por um raio?",
    							"Por que a catarata é a doença mais óbvia?",
    							"Qual a semelhança entre o divórcio e a granada?",
    							"Qual a fórmula da água benta?"
    							};
    private String[] adivinhasResp = {
								"Ser atingido pelo diâmetro, que tem o dobro do tamanho.",
								"Porque ela dá na vista.",
								"Se tirar o anel leva metade da casa.",
								"H Deus O."
								};
    
    public String processInput(String theInput) {
    	String theOutput = null;
    	
    	if(state == CHOOSING) {
    		theOutput = "Qual o tipo de piada você deseja?" + 
    				"[A]divinhas, [p]ontinho, [h]istorinha, ou [t]oc toc?";
    		state = SENTJOKE;
    	} else if(state == SENTJOKE) {
    		// checa se a escolha de piadas foi feita corretamente
    		if(theInput.equalsIgnoreCase("a") ||
    				theInput.equalsIgnoreCase("p") ||
    				theInput.equalsIgnoreCase("h") ||
    				theInput.equalsIgnoreCase("t")) {
    			// começa o fluxo da piada escolhida
    			if(theInput.equalsIgnoreCase("a")) {
    				theOutput = adivinhas[currentJoke];
    				state = SENTCLUE;
    			}
    			if(theInput.equalsIgnoreCase("h")) {
    				theOutput = historinha[currentJoke];
    				state = SENTCLUE;
    			}
    			if(theInput.equalsIgnoreCase("p")) {
    				theOutput = pontinho[currentJoke];
    				state = SENTCLUE;
    			}
    			if(theInput.equalsIgnoreCase("t")) {
    				theOutput = toctoc[currentJoke];
    				state = SENTCLUE;
    			}
    			
    		}else {
    			theOutput = "Escolha inválida" +
    					"Escolha um tipo de piada dentre as possíveis!" +
    					"Qual o tipo de piada você deseja?" +
    					"[A]divinhas, [p]ontinho, [h]istorinha, ou [t]oc toc?";
    		}
    	} else if (state == SENTCLUE) {
    		
    	}
    	
    	return "";
    }
}
