//scegliere se registrarsi o loggare

package opzioni;

import java.util.Scanner;

import pakageClient.SimpleClient;

import clientencoder.*;

import costruttore.RichiestaTombola;

public class OpzioneSceltaGioco {

	@SuppressWarnings("resource")
	public static String opzione(){

		String dainviare=null;
		String stringa=null;

		System.out.println("S per la slot, T per la tombola, R per rubamazzo, C per la classifica globale o G per la classifica giornaliera");

		Scanner scanner = new Scanner(System.in); 

		stringa = scanner.nextLine(); 

		if(stringa.equalsIgnoreCase("S")){

			System.out.println("premi un tasto per e invio per far partire la slot");

			scanner = new Scanner(System.in); 

			dainviare=ClientEncoderSlot.slot();

			SimpleClient.parolachiave="SLOT";

			scanner.close();

			return dainviare;
		}else{
			if(stringa.equalsIgnoreCase("T")){

				System.out.println("digita il numero di schede che vuoi acquistare da 1 a 4");

				scanner = new Scanner(System.in);

				RichiestaTombola.setNumeroSchede(Integer.parseInt(scanner.nextLine()));

				dainviare=ClientEncoderTombola.tombola();

				SimpleClient.parolachiave="TOMBOLA";

				scanner.close();

				return dainviare;

			}
			else{
				if(stringa.equalsIgnoreCase("C")){
					dainviare=ClientEncoderClassificaGlobale.classifica();

					SimpleClient.parolachiave="CLASSIFICAGLOBALE";

					return dainviare;
				}else{
					if(stringa.equalsIgnoreCase("G")){
						dainviare=ClientEncoderClassificaGiornaliera.classifica();

						SimpleClient.parolachiave="CLASSIFICAGIORNALIERA";

						return dainviare;
					}else{
						if(stringa.equalsIgnoreCase("R")){
							dainviare=ClientEncoderIniRubamazzo.rubamazzo();
							
							SimpleClient.parolachiave="RUBAMAZZO";
							
							return dainviare;
						}
						else{
							System.out.println("comando non riconosciuto");
							return null;
						}
					}
				}
			}			
		}
	}
}
