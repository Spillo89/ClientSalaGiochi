package pakageClient;

import java.io.*; 
import java.net.*; 
import java.util.Scanner;

import opzioni.*;

import costruttore.LoginFail;
import costruttore.NoCrediti;
import costruttore.RisultatoSlot;
import costruttore.SchedaTombola;
import costruttore.VincitaTombola;

import clientdecoder.ClientDecoderIniTombola;
import clientdecoder.ClientDecoderLogin;
import clientdecoder.ClientDecoderRegistrazione;
import clientdecoder.ClientDecoderSlot;
import clientdecoder.ClientDecoderTombola;
import clientencoder.ClientEncoderVincita;

//import clientencoder.ClientEncoder;



public class SimpleClient { 

	//Porta e indirizzo di connessione 
	private static final int port = 4445; 
	private static final String host = "127.0.0.1"; 
	public static String parolachiave=null;

	public static void main(String[] args) throws InterruptedException{ 

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

			dainviare=OpzioneSceltaGioco.opzione();
			try{
				dainviare=inputBuffer.readLine();
			}finally{
				try { inputBuffer.close(); } catch (IOException e) { } 
			}

			writer.println(dainviare);//scrivo su socket
			ricevuta = reader.readLine(); //Leggo dal socket

			if(SimpleClient.parolachiave.equalsIgnoreCase("SLOT")){
				ClientDecoderSlot.decoderslot(ricevuta);

				if(SimpleClient.parolachiave.equalsIgnoreCase("KO")){
					System.out.println("hai solo "+NoCrediti.getCreditiTotali()+" quindi non puoi giocare");
				}else{
					System.out.println("sono usciti: "+RisultatoSlot.getValore1()+" "+RisultatoSlot.getValore2()+" "+RisultatoSlot.getValore3());
					System.out.println("quindi hai "+RisultatoSlot.getRisultato()+ " questi crediti "+RisultatoSlot.getCreditiVinti()+" e i crediti totali sono "+RisultatoSlot.getCreditiTotali());
				}

			}else{
				if(SimpleClient.parolachiave.equalsIgnoreCase("TOMBOLA")){
					ClientDecoderTombola.decodertombola(ricevuta);

					while(VincitaTombola.getTipodiVincita().equalsIgnoreCase("TOMBOLA")){
						Thread.sleep(4000);
						dainviare="ESTRAZIONE\n";
						dainviare=inputBuffer.readLine();
						writer.println(dainviare);
						ricevuta=reader.readLine();
						System.out.println("il numero estrato è: "+Integer.parseInt(ricevuta));
						for(int j=0; j<3;j++){
							for(int k=0; k<9;k++){
								if(ricevuta==SchedaTombola.getValoriScheda1(j, k)){
									SchedaTombola.setValoriScheda1(ricevuta+"*", j, k);
								}
							}
						}
						for(int j=0; j<3;j++){
							for(int k=0; k<9;k++){
								if(ricevuta==SchedaTombola.getValoriScheda2(j, k)){
									SchedaTombola.setValoriScheda2(ricevuta+"*", j, k);
								}
							}
						}for(int j=0; j<3;j++){
							for(int k=0; k<9;k++){
								if(ricevuta==SchedaTombola.getValoriScheda3(j, k)){
									SchedaTombola.setValoriScheda3(ricevuta+"*", j, k);
								}
							}
						}for(int j=0; j<3;j++){
							for(int k=0; k<9;k++){
								if(ricevuta==SchedaTombola.getValoriScheda4(j, k)){
									SchedaTombola.setValoriScheda4(ricevuta+"*", j, k);
								}
							}
						}
						for(int j=0; j<3;j++){
							int i=0;
							for(int k=0;k<9;k++){
								if(SchedaTombola.getValoriScheda1(j, k).contains("*")){
									i++;
								}
								if(i>2){
									System.out.println("hai vinto qulacosa, dichiara la tua vincita digitando v o non dichiararla digitando l");
									
									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();
									
									if(stringa.equalsIgnoreCase("v")){
										dainviare=ClientEncoderVincita.tombola();
										dainviare=inputBuffer.readLine();
										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
								}
							}
						}
					}
				}
			}

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
