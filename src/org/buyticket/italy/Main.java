package org.buyticket.italy;

public class Main {

	public static void main(String[] args){
		
		try {
			Biglietto ticket = new Biglietto(50, 70);
			System.out.println(ticket);
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	}
	
}
