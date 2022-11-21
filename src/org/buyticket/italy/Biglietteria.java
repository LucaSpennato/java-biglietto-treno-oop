package org.buyticket.italy;

import java.util.Scanner;

public class Biglietteria {

	public static void main(String[] args){
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(System.in);
			
			System.out.print("Inserisci in km da percorrere: ");
			int userKm = sc.nextInt();
			
			System.out.print("Inserisci la tua età: ");
			int userAge = sc.nextInt();
			
			Biglietto ticket = new Biglietto(userKm, userAge, false);
			System.out.println(ticket);
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			sc.close();
		}
		
	}
	
}
