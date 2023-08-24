package entities;
import java.net.*;

public class JokeList {
	private static final int CHOOSING = 0;
	private static final int TOCTOC = 1;
	private static final int SENTJOKE = 2;
	private static final int SENTCLUE = 3;
	private static final int ANOTHER = 4;
	
	private static final int NUMJOKES = 4;
	
	private int state = CHOOSING;
	private int currentJoke = 0;
	private Character answer = null;
	
	private String[] toctoc = { "Noé", "Dem", "Mário", "KGB"};
    private String[] respostas = { 
			 "Noé da sua conta.",
             "Demorou pra responder e eu esqueci a piada.",
             "Deixa quieto.",
             "Slap! Nós quem fazemos as perguntas!"
             					};
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
			   "Por isso muita gente parece brilhante até a ouvirmos falar."
								};
    private String[] pontinho = {
			   "O que é um pontinho vermelho na salada?",
			   "O que é um pontinho azul no céu?",
			   "O que é um pontinho amarelo na estrada?",
			   "O que é um pontinho vermelho no pântano?"
			};
    private String[] pontinhoResp = {
			   "Uma ervilha prendendo a respiração.",
			   "Um urublue.",
			   "Um Uno milho.",
			   "Um jacared."
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
    		theOutput = "Qual o tipo de piada você deseja? \n" + 
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
    				// salva o tipo de piada para selecionar array correto
    				answer = 'a';
    				state = SENTCLUE;
    			} else if(theInput.equalsIgnoreCase("h")) {
    				theOutput = historinha[currentJoke];
    				answer = 'h';
    				state = SENTCLUE;
    			} else if(theInput.equalsIgnoreCase("p")) {
    				theOutput = pontinho[currentJoke];
    				answer = 'p';
    				state = SENTCLUE;
    			} else if(theInput.equalsIgnoreCase("t")) {
    				theOutput = "Toc! Toc!";
    				answer = 't';
    				state = TOCTOC;
    			} else if (theInput.equalsIgnoreCase("Explodir!")){
        			theOutput = "BOOOM!";
        		}
    			
    		} else if(!theInput.equalsIgnoreCase("Explodir!")){
    			theOutput = "Escolha inválida! " +
    					"Escolha um tipo de piada dentre as possíveis!\n" +
    					"Qual o tipo de piada você deseja?\n" +
    					"[A]divinhas, [p]ontinho, [h]istorinha, ou [t]oc toc?";
    		} else {
    			theOutput = "BOOOM!";
    		}
    	} else if(state == TOCTOC){
    		if(theInput.equalsIgnoreCase("Quem é?")) {
    			theOutput = toctoc[currentJoke];
    			answer = 't';
    			state = SENTCLUE;
    		} else if(!theInput.equalsIgnoreCase("Explodir!")){
    			theOutput = "Você deveria perguntar \"Quem é?\""
    						+"\nTenta de novo. Toc! toc!";
    		} else {
    			theOutput = "BOOOM!";
    		}
    	} else if (state == SENTCLUE) {
    		if(answer == 'a') {
    			if(theInput.equalsIgnoreCase(adivinhasResp[currentJoke])) {
    				theOutput = "Acertou! \nQuer mais uma piada? (s/n)";
    				state = ANOTHER;
    			} else if(!theInput.equalsIgnoreCase("Explodir!")){
    				theOutput = adivinhasResp[currentJoke] 
    						+ "\nVai outra? (s/n)";
    				state = ANOTHER;
    			} else {
        			theOutput = "BOOOM!";
        		}
    		} else if(answer == 'h') {
    			if(theInput.equalsIgnoreCase(punchLine[currentJoke])) {
    				theOutput = "Já conhecia essa, né?!"
    						+ " \nQuer mais uma piada? (s/n)";
    				state = ANOTHER;
    			} else if(!theInput.equalsIgnoreCase("explodir!")){
    				theOutput = punchLine[currentJoke] 
    						+ "\nQuer outra piada? (s/n)";
    				state = ANOTHER;
    			}
    		} else if(answer == 'p') {
    			if(theInput.equalsIgnoreCase(pontinhoResp[currentJoke])) {
    				theOutput = "Acertou! \nQuer mais uma piada? (s/n)";
    				state = ANOTHER;
    			} else if(!theInput.equalsIgnoreCase("Explodir!")){
    				theOutput = pontinhoResp[currentJoke] 
    						+ "\nVai outra? (s/n)";
    				state = ANOTHER;
    			} else {
        			theOutput = "BOOOM!";
        		}
    		} else if(answer == 't') {
    			if(theInput.equalsIgnoreCase("Que " + toctoc[currentJoke] + "?")) {
    				theOutput = respostas[currentJoke] 
    						+ "Vai outra? (s/n)";
    				state = ANOTHER;
    			} else if(!theInput.equalsIgnoreCase("Explodir!")){
    				theOutput = "Você deveria perguntar: Que " 
    						+ toctoc[currentJoke]
    						+ "?\n"
    						+ "Tenta de novo! "
    						+ "Toc Toc!";
    				state = TOCTOC;
    			} else {
        			theOutput = "BOOOM!";
        		}
    		}
    	} else if(state == ANOTHER) {
    		if(theInput.equalsIgnoreCase("s")) {
    			theOutput = "Qual o tipo de piada você deseja? \n" + 
        				"[A]divinhas, [p]ontinho, [h]istorinha, ou [t]oc toc?";
    			if(currentJoke == (NUMJOKES -1)) {
    				currentJoke = 0;
    			} else {
    				currentJoke++;
    			}
    			state = SENTJOKE;
    		} else if(!theInput.equalsIgnoreCase("Explodir!")){
    			theOutput = "Tchau! Até logo!";
    			state = CHOOSING;
    		} else {
    			theOutput = "BOOOM!";
    		}
    	}
    	
    	return theOutput;
    }
}
