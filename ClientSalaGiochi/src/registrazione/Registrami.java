package registrazione;

import java.util.Scanner;

public class Registrami {
	
	public static String[] registrazione(){
		
		String NomeUtentePassword[] = null;
		
		System.out.println("Inserire il nome utente che preferisci");

		Scanner scanner = new Scanner(System.in); 

		NomeUtentePassword[1] = scanner.nextLine(); 
		
		System.out.println("Inserire il nome passsword che preferisci");
		
		scanner = new Scanner(System.in);
		
		NomeUtentePassword[2] = scanner.nextLine();
		
		scanner.close();
		
		return NomeUtentePassword;
	}
}
