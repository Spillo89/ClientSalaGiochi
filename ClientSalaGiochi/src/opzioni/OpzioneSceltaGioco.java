//scegliere se registrarsi o loggare

package opzioni;

import java.util.Scanner;

import pakageClient.SimpleClient;

import clientencoder.*;

import costruttore.PerRegistrazione;
import costruttore.RichiestaTombola;

public class OpzioneSceltaGioco {

	public static String opzione(){

		String dainviare=null;
		String stringa=null;
		
		System.out.println("S per la slot, T per la tombola e R per rubamazzo");

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
				//da fare
				return dainviare;
			}
			
			
				

			
		}
	}
}
