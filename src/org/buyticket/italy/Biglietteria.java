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
			
			System.out.println("Flessibilità data scadenza, se si, avrà una maggiorazione del 10%");
			System.out.println("1- Si\n2- No");
			int flexChoice = sc.nextInt();
			boolean flexExp = false;
			
			if(flexChoice == 1) {
				flexExp = true;
			}else if(flexChoice == 2) {
				flexExp = false;
			}else {
				System.out.println("Dati inseriti non corretti.");
			}
			
			Biglietto ticket = new Biglietto(userKm, userAge, flexExp);
			System.out.println(ticket);
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			sc.close();
		}
		
	}
	
}
