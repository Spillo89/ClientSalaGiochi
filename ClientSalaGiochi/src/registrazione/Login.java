package registrazione;

import java.util.Scanner;

public class Login {
	
	
	public String[] login(){
		
		String NomeUtentePassword[] = null;
		
		System.out.println("Inserire il nome utente");

		Scanner scanner = new Scanner(System.in); 

		NomeUtentePassword[0] = scanner.nextLine(); 
		
		System.out.println("Inserire il nome passsword");
		
		scanner = new Scanner(System.in);
		
		NomeUtentePassword[1] = scanner.nextLine();
		
		

		
		return NomeUtentePassword;
	}

}
