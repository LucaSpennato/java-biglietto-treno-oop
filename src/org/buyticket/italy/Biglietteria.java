package org.buyticket.italy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Biglietteria {

	public static void main(String[] args){
		
		Scanner sc = null;
		
		Biglietto ticket = null;
		
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
			
			ticket = new Biglietto(userKm, userAge, flexExp);
			System.out.println(ticket);
			
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			sc.close();
		}
		
		//File Creation
		//------------------------------------------------------------------------------------------------------------ 
		
		FileWriter printTicket = null;
		
		try {
			
			printTicket = new FileWriter("./ticket.txt");
			
			printTicket.write(ticket.toString());
			
		} catch (IOException e) {
			
//			e.printStackTrace();
			System.err.println(e.getMessage());
			
		} finally {
			
			try {
				
				printTicket.close();
				
			}catch(IOException e) {
				
				e.printStackTrace();
				
			}
		}
		
		// File reader
		//------------------------------------------------------------------------------
		
		File fileToRead = new File("./ticket.txt");
		Scanner fileSc = null;
		
		try {
			
			fileSc = new Scanner(fileToRead);
			
			while (fileSc.hasNextLine()) {
				
				String line = fileSc.nextLine();
				
				System.out.println(line);
				
			}
			
			
		}catch(FileNotFoundException e) {
			
			System.err.println(e.getMessage());
			
		} finally {
			
			fileSc.close();
		}
		
	}
	
}
