package org.buyticket.italy;

public class Biglietto {
	
	private int kmToRide;
	
	private int age;
	
	
	public Biglietto(int kmToRide, int age) throws Exception {
		
		isValidKm(kmToRide);
		isValidAge(age);
	}


	public int getKmToRide() {
		return kmToRide;
	}

	private void isValidKm(int kmToRide) throws Exception {
		
		if(kmToRide <= 0) {
			throw new Exception("I km inseriti non sono validi.");
		}
		
		this.kmToRide = kmToRide;
	}

	public int getAge() {
		return age;
	}
	
	private void isValidAge(int age) throws Exception {
		
		if(age <= 0) {
			throw new Exception("L'età non è valida.");
		}
		
	}

	
	
}
