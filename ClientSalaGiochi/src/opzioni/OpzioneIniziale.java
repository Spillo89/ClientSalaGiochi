//scegliere se registrarsi o loggare

package opzioni;

import java.util.Scanner;

import clientencoder.*;

import costruttore.PerRegistrazione;

public class OpzioneIniziale {

	public static String opzione(){

		String dainviare=null;
		String stringa=null;
		
		System.out.println("premere R per registrarsi o L per effettuare il login se sei già registrato");

		Scanner scanner = new Scanner(System.in); 

		stringa = scanner.nextLine(); 

		if(stringa.equalsIgnoreCase("r")){
			
			System.out.println("Inserire il nome utente che preferisci");

			scanner = new Scanner(System.in); 

			PerRegistrazione.setNomeUtente(scanner.nextLine()); 
			
			System.out.println("Inserire il nome password che preferisci");
			
			scanner = new Scanner(System.in);
			
			PerRegistrazione.setPsw(scanner.nextLine());
			
			System.out.println("Inserire il tuo nome");
			
			PerRegistrazione.setNome(scanner.nextLine());
			
			System.out.println("Inserire il tuo cognome");
			
			PerRegistrazione.setCognome(scanner.nextLine());
			
			scanner.close();
			
			dainviare=ClientEncoderRegistrazione.registrazione();
			
			return dainviare;
		}else{

			
			System.out.println("Inserire il nome utente");

			scanner = new Scanner(System.in); 

			PerRegistrazione.setNomeUtente(scanner.nextLine()); 
			
			System.out.println("Inserire il nome password");
			
			scanner = new Scanner(System.in);
			
			PerRegistrazione.setPsw(scanner.nextLine());
			
			scanner.close();
			
			dainviare=ClientEncoderLogin.login();
			
			return dainviare;
			
		}
	}
}
