package pakageClient;

import java.io.*; 
import java.net.*; 

import opzioni.*;

import costruttore.LoginFail;

import clientdecoder.ClientDecoderLogin;
import clientdecoder.ClientDecoderRegistrazione;

//import clientencoder.ClientEncoder;



public class SimpleClient { 

	//Porta e indirizzo di connessione 
	private static final int port = 4445; 
	private static final String host = "127.0.0.1"; 
	public static String parolachiave=null;

	public static void main(String[] args){ 

		Socket socket = null; 
		PrintWriter writer = null; 
		BufferedReader reader = null; 
		String dainviare=null;
		String ricevuta=null;
		Boolean ripeti=false;

		try { 
			//Connessione al server remoto 
			socket = new Socket(host , port); 
			//Inizializzo la lettura dal socket 
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			//Inizializzo la scrittura sul socket 
			writer = new PrintWriter(socket.getOutputStream(), true); 
			BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
			while(ripeti==false){
				dainviare=OpzioneIniziale.opzione();
				try { 
					dainviare=inputBuffer.readLine();			//invio la combinazione user name e pass + se loggare o registrarsi al server
				}finally{ 
					try { inputBuffer.close(); } catch (IOException e) { } 
				} 
				writer.println(dainviare);//scrivo su socket
				ricevuta = reader.readLine(); //Leggo dal socket

				if(SimpleClient.parolachiave.equalsIgnoreCase("LOGIN")){
					ClientDecoderLogin.decoderlogin(ricevuta);
				}else{
					ClientDecoderRegistrazione.decoderregistrazione(ricevuta);
				}

				if(SimpleClient.parolachiave.equalsIgnoreCase("KO")){
					System.out.println(LoginFail.getMotivo());
					ripeti=false;
				}else{
					ripeti=true;
				}
			}
			
			dainviare=OpzioneGioco.opzione();
			try{
				dainviare=inputBuffer.readLine();
			}finally{
				try { inputBuffer.close(); } catch (IOException e) { } 
			}
			
			writer.println(dainviare);//scrivo su socket
			ricevuta = reader.readLine(); //Leggo dal socket
			

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
