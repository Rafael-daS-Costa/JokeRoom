package entities;
import java.net.*;
import java.io.*;

public class KKMultiServerThread extends Thread {
    private Socket socket = null;

    public KKMultiServerThread(Socket socket) {
        super("KKMultiServerThread");
        this.socket = socket;
    }
    
    public void run() {

        try (
        	 /*PrintWriter mostra representações formatadas de um objeto
        	   em um fluxo de saída. Sozinho, não possui métodos para escrever
        	   bytes puros, por isso, usa-se o getOutputStream()*/
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        		
        	/*Le texto de um fluxo de entrada de caracteres armazenando no buffer
        	 * esses caracteres. O tamanho do buffer deve ser especificado, ou então
        	 * é usado o tamanho padrão
        	 * InputStreamReader converte bytes em caracteres*/
            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream()));
        ) {
            String inputLine, outputLine;
            ChooseJokeProtocol protocol = new ChooseJokeProtocol();
            outputLine = protocol.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = protocol.processInput(inputLine);
                out.println(outputLine);
                if (inputLine.equals("Explodir!"))
                    System.exit(0);
                if(outputLine.equals("Bye")) {
                	break;
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
