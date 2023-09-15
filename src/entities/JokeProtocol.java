package entities;
import java.net.*;
import java.util.Random;

public class JokeProtocol {
	private static final int CHOOSING = 0;
	private static final int TOCTOC = 1;
	private static final int SENTJOKE = 2;
	private static final int SENTCLUE = 3;
	private static final int ANOTHER = 4;
	
	private static final int NUMJOKES = 4;
	
	private int state = CHOOSING;
	private int currentJoke = 0;
	private Character answer = null;
	private JokeList joke = new JokeList();
	private Random sorting = new Random();
    
    public String processInput(String theInput) {
    	String theOutput = null;
    	
    	if(state == CHOOSING) {
    		theOutput = "Qual o tipo de piada você deseja? \n" + 
    					"[A]divinhas, [p]ontinho, [h]istorinha, [t]oc toc "
    					+ "ou [r]andômica?";
    		state = SENTJOKE;
    	} else if(state == SENTJOKE) {
    		// checa se a escolha de piadas foi feita corretamente
    		if(theInput.equalsIgnoreCase("a") ||
    				theInput.equalsIgnoreCase("p") ||
    				theInput.equalsIgnoreCase("h") ||
    				theInput.equalsIgnoreCase("t") ||
    				theInput.equalsIgnoreCase("r")) {
    			//escolhe aleatoriamente um tipo de piada
    			if(theInput.equalsIgnoreCase("r")) {
    				int number = sorting.nextInt(4) + 1;
    				switch(number) {
    				case 1:
    					theInput = "a";
    					break;
    				case 2:
    					theInput = "p";
    					break;
    				case 3:
    					theInput = "h";
    					break;
    				case 4:
    					theInput = "t";
    					break;
    				}
    				System.out.println(number);
    			}
    			// começa o fluxo da piada escolhida
    			if(theInput.equalsIgnoreCase("a")) {
    				theOutput = joke.getGuessing()[currentJoke];
    				// salva o tipo de piada para selecionar array correto
    				answer = 'a';
    				state = SENTCLUE;
    			} else if(theInput.equalsIgnoreCase("h")) {
    				theOutput = joke.getStories()[currentJoke];
    				answer = 'h';
    				state = SENTCLUE;
    			} else if(theInput.equalsIgnoreCase("p")) {
    				theOutput = joke.getLittleDot()[currentJoke];
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
    					"[A]divinhas, [p]ontinho, [h]istorinha, [t]oc toc "
    					+ "ou [r]andômica?";
    		} else {
    			theOutput = "BOOOM!";
    		}
    	} else if(state == TOCTOC){
    		if(theInput.equalsIgnoreCase("Quem é?")) {
    			theOutput = joke.getKnockKnock()[currentJoke];
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
    			if(theInput.equalsIgnoreCase(joke.getKkAnswers()[currentJoke])) {
    				theOutput = "Acertou! \nQuer mais uma piada? (s/n)";
    				state = ANOTHER;
    			} else if(!theInput.equalsIgnoreCase("Explodir!")){
    				theOutput = joke.getGuessingAnswers()[currentJoke] 
    						+ "\nVai outra? (s/n)";
    				state = ANOTHER;
    			} else {
        			theOutput = "BOOOM!";
        		}
    		} else if(answer == 'h') {
    			if(theInput.equalsIgnoreCase(joke.getStoriesPunchLine()[currentJoke])) {
    				theOutput = "Já conhecia essa, né?!"
    						+ " \nQuer mais uma piada? (s/n)";
    				state = ANOTHER;
    			} else if(!theInput.equalsIgnoreCase("explodir!")){
    				theOutput = joke.getStoriesPunchLine()[currentJoke] 
    						+ "\nQuer outra piada? (s/n)";
    				state = ANOTHER;
    			}
    		} else if(answer == 'p') {
    			if(theInput.equalsIgnoreCase(joke.getLittleDotAnswers()[currentJoke])) {
    				theOutput = "Acertou! \nQuer mais uma piada? (s/n)";
    				state = ANOTHER;
    			} else if(!theInput.equalsIgnoreCase("Explodir!")){
    				theOutput = joke.getLittleDotAnswers()[currentJoke] 
    						+ "\nVai outra? (s/n)";
    				state = ANOTHER;
    			} else {
        			theOutput = "BOOOM!";
        		}
    		} else if(answer == 't') {
    			if(theInput.equalsIgnoreCase("Que " + joke.getKnockKnock()[currentJoke] + "?")) {
    				theOutput = joke.getKkAnswers()[currentJoke] 
    						+ "Vai outra? (s/n)";
    				state = ANOTHER;
    			} else if(!theInput.equalsIgnoreCase("Explodir!")){
    				theOutput = "Você deveria perguntar: Que " 
    						+ joke.getKnockKnock()[currentJoke]
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
    					"[A]divinhas, [p]ontinho, [h]istorinha, [t]oc toc "
    					+ "ou [r]andômica?";
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
