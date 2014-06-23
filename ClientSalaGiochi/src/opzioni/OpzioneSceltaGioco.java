//scegliere se registrarsi o loggare

package opzioni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import pakageClient.SimpleClient;

import clientencoder.*;

import costruttore.RichiestaTombola;

public class OpzioneSceltaGioco {


	public static String opzione() throws IOException{

		String dainviare=null;

		System.out.println("S per la slot, T per la tombola, R per rubamazzo, C per la classifica globale o G per la classifica giornaliera");


		System.out.println("ho inizializzato lo scanner");

	
		System.out.println("ho fatto lo scanner senza aspettare imput");
		
		String stringa="S";
		
		System.out.println("la stringa è: "+stringa);

		if(stringa.equalsIgnoreCase("S")){

			System.out.println("premi un tasto per e invio per far partire la slot");

			dainviare=ClientEncoderSlot.slot();
			
			System.out.println("sono uscito da clientencoderslot");

			SimpleClient.parolachiave="SLOT";

		}else{
			if(stringa.equalsIgnoreCase("T")){

				System.out.println("digita il numero di schede che vuoi acquistare da 1 a 4");


				RichiestaTombola.setNumeroSchede(Integer.parseInt(OpzioneIniziale.scanner.nextLine()));

				dainviare=ClientEncoderTombola.tombola();

				SimpleClient.parolachiave="TOMBOLA";



			}
			else{
				if(stringa.equalsIgnoreCase("C")){
					dainviare=ClientEncoderClassificaGlobale.classifica();

					SimpleClient.parolachiave="CLASSIFICAGLOBALE";

				}else{
					if(stringa.equalsIgnoreCase("G")){
						dainviare=ClientEncoderClassificaGiornaliera.classifica();

						SimpleClient.parolachiave="CLASSIFICAGIORNALIERA";

					}else{
						if(stringa.equalsIgnoreCase("R")){
							dainviare=ClientEncoderIniRubamazzo.rubamazzo();

							SimpleClient.parolachiave="RUBAMAZZO";

						}
						else{
							System.out.println("comando non riconosciuto");

							dainviare=null;
						}
					}
				}
			}			
		}
		
		System.out.println("ritorno da inviare: "+dainviare);
		
		return dainviare;
	}
}
