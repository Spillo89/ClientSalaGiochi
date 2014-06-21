package pakageClient;

import java.io.*; 
import java.net.*; 
import java.util.Scanner;

import opzioni.*;

import costruttore.Carta;
import costruttore.LoginFail;
import costruttore.NoCrediti;
import costruttore.RisultatoSlot;
import costruttore.SchedaTombola;
import costruttore.UtentePrelogin;
import costruttore.VincitaTombola;

import clientdecoder.ClientDecoderGiornaliera;
import clientdecoder.ClientDecoderGlobale;
import clientdecoder.ClientDecoderIniRubamazzo;
import clientdecoder.ClientDecoderLogin;
import clientdecoder.ClientDecoderRegistrazione;
import clientdecoder.ClientDecoderRubamazzo;
import clientdecoder.ClientDecoderSlot;
import clientdecoder.ClientDecoderTombola;
import clientencoder.ClientEncoderRubamazzo;
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
					//invio la combinazione user name e pass + se loggare o registrarsi al server
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
			ripeti=false;

			while(ripeti==false){


				dainviare=OpzioneSceltaGioco.opzione(); //chiedo all'utente cosa vuole fare
				try{

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

						while(VincitaTombola.getTipodiVincita().equalsIgnoreCase("TOMBOLA")){ //ciclo controllo scheda e segnatura numeri usciti
							Thread.sleep(4000);
							dainviare="ESTRAZIONE\n";

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
							int i=0;
							for(int j=0; j<3;j++){
								for(int k=0;k<9;k++){
									if(SchedaTombola.getValoriScheda1(j, k).contains("*")){
										i++;
									}
								}
								if(i==2){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("AMBO");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==3){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("TERNO");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==4){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("QUATERNA");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==5){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("CINQUINA");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==15){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("TOMBOLA");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
							}
							i=0;
							for(int j=0; j<3;j++){
								for(int k=0;k<9;k++){
									if(SchedaTombola.getValoriScheda2(j, k).contains("*")){
										i++;
									}
								}
								if(i==2){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("AMBO");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==3){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("TERNO");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==4){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("QUATERNA");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==5){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("CINQUINA");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==15){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("TOMBOLA");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
							}
							i=0;
							for(int j=0; j<3;j++){
								for(int k=0;k<9;k++){
									if(SchedaTombola.getValoriScheda3(j, k).contains("*")){
										i++;
									}
								}
								if(i==2){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("AMBO");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==3){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("TERNO");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==4){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("QUATERNA");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==5){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("CINQUINA");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==15){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("TOMBOLA");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
							}
							i=0;
							for(int j=0; j<3;j++){
								for(int k=0;k<9;k++){
									if(SchedaTombola.getValoriScheda4(j, k).contains("*")){
										i++;
									}
								}
								if(i==2){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("AMBO");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==3){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("TERNO");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==4){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("QUATERNA");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==5){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("CINQUINA");
										dainviare=ClientEncoderVincita.tombola();

										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
								if(i==15){
									System.out.println("hai fatto ambo, dichiara la tua vincita digitando v o non dichiararla digitando l");

									Scanner scanner = new Scanner(System.in); 

									String stringa = scanner.nextLine();

									if(stringa.equalsIgnoreCase("v")){
										VincitaTombola.setTipodiVincita("TOMBOLA");
										dainviare=ClientEncoderVincita.tombola();
										writer.println(dainviare);
										ricevuta=reader.readLine();
									}
									scanner.close();
								}
							}
						}
					}else{
						if(SimpleClient.parolachiave.equalsIgnoreCase("RUBAMAZZO")){

							ClientDecoderIniRubamazzo.decoderinirubamazzo(ricevuta);


							if(parolachiave.equalsIgnoreCase("KO")){
								System.out.println("non puoi giocare perchè hai "+NoCrediti.getCreditiTotali()+" crediti e sono troppo pochi");
							}
							else{
								int i=0;

								dainviare="AGGIORNAMENTO\n";

								writer.println(dainviare);
								ricevuta=reader.readLine();

								ClientDecoderRubamazzo.decoderestrazione(ricevuta);

								while(SimpleClient.parolachiave.equalsIgnoreCase("FINE")){
									if(ClientDecoderIniRubamazzo.lista.get(i).equals(UtentePrelogin.getNomeUtente())){


										System.out.println("le tue carte in mano sono:");
										for(int j=0;j<ClientDecoderRubamazzo.CarteinMano.size();j++){
											System.out.println(""+ClientDecoderRubamazzo.CarteinMano.get(j));
										}
										System.out.println("le tue carte in banco sono:");
										for(int j=0;j<ClientDecoderRubamazzo.CarteinBanco.size();j++){
											System.out.println(""+ClientDecoderRubamazzo.CarteinBanco.get(j));
										}
										System.out.println("la carta in cima al tuo mazzo è: "+ClientDecoderRubamazzo.CartainCima0.getVal()+" "+ClientDecoderRubamazzo.CartainCima0.getSeme()+" e le carte nel mazzetto sono: "+ClientDecoderRubamazzo.CartenelMazzetto0);
										System.out.println("la carta in cima al mazzetto del giocatore1: "+ClientDecoderRubamazzo.CartainCima1.getVal()+" "+ClientDecoderRubamazzo.CartainCima1.getSeme()+" e le carte nel mazzetto sono: "+ClientDecoderRubamazzo.CartenelMazzetto1);
										if(ClientDecoderRubamazzo.CartenelMazzetto2!=null){
											System.out.println("la carta in cima al tuo mazzo del giocatore2: "+ClientDecoderRubamazzo.CartainCima2.getVal()+" "+ClientDecoderRubamazzo.CartainCima2.getSeme()+" e le carte nel mazzetto sono: "+ClientDecoderRubamazzo.CartenelMazzetto2);
										}
										if(ClientDecoderRubamazzo.CartenelMazzetto3!=null){
											System.out.println("la carta in cima al tuo mazzo del giocatore3: "+ClientDecoderRubamazzo.CartainCima3.getVal()+" "+ClientDecoderRubamazzo.CartainCima3.getSeme()+" e le carte nel mazzetto sono: "+ClientDecoderRubamazzo.CartenelMazzetto3);
										}

										System.out.println("scegli la carta da giocare");

										Carta carta=OpzioneCarta.opzionecarta();

										dainviare=ClientEncoderRubamazzo.rubamazzo(carta);

										writer.println(dainviare);

										i++;
										if(i+1==ClientDecoderIniRubamazzo.lista.size()){
											i=0;
										}
										dainviare="AGGIORNAMENTO\n";

										writer.println(dainviare);

										ricevuta=reader.readLine();

										ClientDecoderRubamazzo.decoderestrazione(ricevuta);
									}
									else{
										System.out.println("le tue carte in mano sono:");
										for(int j=0;j<ClientDecoderRubamazzo.CarteinMano.size();j++){
											System.out.println(""+ClientDecoderRubamazzo.CarteinMano.get(j));
										}
										System.out.println("le tue carte in banco sono:");
										for(int j=0;j<ClientDecoderRubamazzo.CarteinBanco.size();j++){
											System.out.println(""+ClientDecoderRubamazzo.CarteinBanco.get(j));
										}
										System.out.println("la carta in cima al tuo mazzo è: "+ClientDecoderRubamazzo.CartainCima0.getVal()+" "+ClientDecoderRubamazzo.CartainCima0.getSeme()+" e le carte nel mazzetto sono: "+ClientDecoderRubamazzo.CartenelMazzetto0);
										System.out.println("la carta in cima al mazzetto del giocatore1: "+ClientDecoderRubamazzo.CartainCima1.getVal()+" "+ClientDecoderRubamazzo.CartainCima1.getSeme()+" e le carte nel mazzetto sono: "+ClientDecoderRubamazzo.CartenelMazzetto1);
										if(ClientDecoderRubamazzo.CartenelMazzetto2!=null){
											System.out.println("la carta in cima al tuo mazzo del giocatore2: "+ClientDecoderRubamazzo.CartainCima2.getVal()+" "+ClientDecoderRubamazzo.CartainCima2.getSeme()+" e le carte nel mazzetto sono: "+ClientDecoderRubamazzo.CartenelMazzetto2);
										}
										if(ClientDecoderRubamazzo.CartenelMazzetto3!=null){
											System.out.println("la carta in cima al tuo mazzo del giocatore3: "+ClientDecoderRubamazzo.CartainCima3.getVal()+" "+ClientDecoderRubamazzo.CartainCima3.getSeme()+" e le carte nel mazzetto sono: "+ClientDecoderRubamazzo.CartenelMazzetto3);
										}
										i++;

										dainviare="AGGIORNAMENTO\n";

										writer.println(dainviare);

										ricevuta=reader.readLine();

										ClientDecoderRubamazzo.decoderestrazione(ricevuta);

										if(i+1==ClientDecoderIniRubamazzo.lista.size()){
											i=0;
										}

									}
								}
								//chiedere l'aggiornamento quando non giochi tu o giocare in caso sia il tuo turno facendo scorrere l'array lista e vedendo se il nome al'interno è uguale a quello dell'utente
							}



						}else{
							if(SimpleClient.parolachiave.equalsIgnoreCase("CLASSIFICAGLOBALE")){

								ClientDecoderGlobale.decoderestrazione(ricevuta);
								for(int i=0;i<ClientDecoderGlobale.classifica.size();i++){
									System.out.println("il "+ i+1 +"in classifica globale è::"+ClientDecoderGlobale.classifica.get(i));
								}

							}
							else{
								if(SimpleClient.parolachiave.equalsIgnoreCase("CLASSIFICAGIORNALIERA")){
									ClientDecoderGiornaliera.decoderestrazione(ricevuta);
									for(int i=0;i<ClientDecoderGiornaliera.classifica.size();i++){
										System.out.println("il "+ i+1 +"in classifica globale è::"+ClientDecoderGiornaliera.classifica.get(i));
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
