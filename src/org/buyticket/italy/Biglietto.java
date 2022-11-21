package org.buyticket.italy;

import java.math.BigDecimal;

public class Biglietto {

	private static final BigDecimal PRICE_KM = new BigDecimal(0.21);
	
	private static final BigDecimal ELDER_DISCOUNT = new BigDecimal(0.4);
	
	private static final BigDecimal MINOR_DISCOUNT = new BigDecimal(0.2);
	
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
		this.age = age;
	}
	
	private BigDecimal checkDiscount(BigDecimal price) {
		
		BigDecimal hund = new BigDecimal(100);
		BigDecimal discountedPrice = null;
		
		if(age >= 65) {
			discountedPrice = price.multiply(ELDER_DISCOUNT);
		}else if(age < 18) {
			discountedPrice = price.multiply(MINOR_DISCOUNT);
		}else {
			return price;
		}
		
		return price.subtract(discountedPrice);
		
	}

	public float getFinalPrice() {
		
		BigDecimal price = PRICE_KM.multiply(BigDecimal.valueOf(kmToRide));
		
		return checkDiscount(price).floatValue();
	}
	
	@Override
	public String toString() {
		
		return "Age: " + age 
				+ "\nFinalPrice: " + getFinalPrice();
	}
	
}
