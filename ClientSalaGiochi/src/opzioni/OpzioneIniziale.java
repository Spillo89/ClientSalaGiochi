//scegliere se registrarsi o loggare

package opzioni;

import java.util.Scanner;

import clientencoder.*;

import costruttore.PerRegistrazione;

public class OpzioneIniziale {
	
	public static Scanner scanner = new Scanner(System.in); 

	public static String opzione(){

		String dainviare=null;
		String stringa=null;
		
		System.out.println("premere R per registrarsi o L per effettuare il login se sei già registrato");

		

		stringa = scanner.nextLine(); 

		if(stringa.equalsIgnoreCase("r")){
			
			System.out.println("Inserire il nome utente che preferisci");

			PerRegistrazione.setNomeUtente(scanner.nextLine()); 
			
			System.out.println("Inserire il nome password che preferisci");
			
			PerRegistrazione.setPsw(scanner.nextLine());
			
			System.out.println("Inserire il tuo nome");
			
			PerRegistrazione.setNome(scanner.nextLine());
			
			System.out.println("Inserire il tuo cognome");
			
			PerRegistrazione.setCognome(scanner.nextLine());
						
			dainviare=ClientEncoderRegistrazione.registrazione();
			
			
			return dainviare;
		}else{

			
			System.out.println("Inserire il nome utente");

			PerRegistrazione.setNomeUtente(scanner.nextLine()); 
			
			System.out.println("Inserire il nome password");
			
			PerRegistrazione.setPsw(scanner.nextLine());
						
			dainviare=ClientEncoderLogin.login();
			
			return dainviare;
			
		}
	}
}
