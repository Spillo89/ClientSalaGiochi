package pakageClient;

import java.io.*; 
import java.net.*; 

import encoder.Encoder;

import registrazione.Login;
 
public class SimpleClient { 
 
//Porta e indirizzo di connessione 
private static final int port = 4445; 
private static final String host = "127.0.0.1"; 
 
public static void main(String[] args){ 
 
	Socket socket = null; 
	PrintWriter writer = null; 
	BufferedReader reader = null; 
	String[] stringhe=null;
	String dainviare=null;
	String ricevuta=null;
 
	try { 
		//Connessione al server remoto 
		socket = new Socket(host , port); 
		//Inizializzo la lettura dal socket 
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
		//Inizializzo la scrittura sul socket 
		writer = new PrintWriter(socket.getOutputStream(), true); 
		BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
		stringhe=Login.login();
		try { 
			dainviare=Encoder.unisci(stringhe);
			dainviare=inputBuffer.readLine();  
		}finally{ 
	 try { inputBuffer.close(); } catch (IOException e) { } 
		} 
		writer.println(dainviare);//scrivo su socket
		ricevuta = reader.readLine(); //Leggo dal socket 
		//System.out.println("Ricevuto dal server: " + stringa); 
		} catch (UnknownHostException e) { 
			System.err.println("Host "+host+" non conosciuto"); 
			System.exit(1); 
		} catch (IOException e) { 
			System.err.println("Connessione a "+host+" non riuscita"); 
			System.exit(1); 
		}finally{ //Alla fine chiudo sempre il reader, il writer e il socket 
			try { reader.close(); } catch (IOException e) {} 
			writer.close(); 
			if(!socket.isClosed()){ 
				try {socket.close(); } catch (IOException e) {} 
			} 
		} 
	 }


}
